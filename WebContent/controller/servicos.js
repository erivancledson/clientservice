var servicoModulo = angular.module('servicoModulo',[]);

servicoModulo.controller("servicosController", function($scope, $http) {
	
	urlServico = 'http://localhost:8080/meusservicos/rest/servicos';
	
	$scope.listarServicos = function() {
		$http.get(urlServico).success(function (servicos) {
			$scope.servicos = servicos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionaservico = function(servicoSelecionado) {
		$scope.servico = servicoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.servico = "";
	}
	
	$scope.salvar = function() {
	
		console.log($scope.servico.codigo);
		//se o codigo for igual a vazio ele vai gravar um novo registro
		
		if ($scope.servico.codigo == undefined) {
			//alert("POST - codigo vazuio = novo registro");
			//console.log("POST - codigo vazio = novo registro");
			//Se teve sucesso ele grava os dados
		   $http.post(urlServico,$scope.servico).success(function(servico) {
		      
		        $scope.limparCampos();
		        //cadastrou lista o servico
		        $scope.listarServicos();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			//aqui é o atualizar
			//se o registro não estiver com o id vazio ele atualiza
		//	alert("PUT - codigo nao vazio = altera registro");
		//	console.log("PUT - codigo nao vazio = altera registro");
			////passa pela url enviando o servico
			  $http.put(urlServico,$scope.servico).success(function(servico) {
				  $scope.listarServicos();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	//se não tiver codigo ele informa está mensagem
	$scope.excluir = function() {
		if ($scope.servico.codigo == undefined) {
		//	alert("Favor selecionar um registro para poder excluir");
		//	console.log("Favor selecionar um registro para poder excluir");
		} else {
			//se tiver codigo ele deleta
			//passa a url e o codigo do professor
			$http.delete(urlServico+'/'+$scope.servico.codigo).success(function () {
				 $scope.listarServicos();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarServicos();
	
	
});





