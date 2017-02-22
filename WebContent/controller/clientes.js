var clienteModulo = angular.module('clienteModulo',[]);

clienteModulo.controller("clienteController", function($scope, $http) {
	
	urlServico = 'http://localhost:8080/meusservicos/rest/servicos';
	urlCliente = 'http://localhost:8080/meusservicos/rest/clientes';
	
	$scope.listarClientes = function() {
		$http.get(urlCliente).success(function (clientes) {
			$scope.clientes = clientes;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.listarServicos = function() {
		$http.get(urlServico).success(function (servicos) {
			$scope.servicos = servicos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionacliente = function(clienteSelecionado) {
		$scope.cliente = clienteSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.cliente = "";
	}
	
	$scope.salvar = function() {
	
		console.log($scope.cliente.codigo);
		if ($scope.cliente.codigo == undefined) {
			//alert("POST - codigo vazuio = novo registro");
			//console.log("POST - codigo vazio = novo registro");
		   $http.post(urlCliente,$scope.cliente).success(function(cliente) {
		        $scope.clientes.push($scope.cliente);
		        $scope.limparCampos();
		        $scope.listarClientes();
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			//alert("PUT - codigo nao vazio = altera registro");
			//console.log("PUT - codigo nao vazio = altera registro");
			  $http.put(urlCliente,$scope.cliente).success(function(cliente) {
				  $scope.listarClientes();
			      $scope.limparCampos();
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.cliente.codigo == undefined) {
			//alert("Favor selecionar um registro para poder excluir");
			//console.log("Favor selecionar um registro para poder excluir");
		} else {
			$http.delete(urlCliente+'/'+$scope.cliente.codigo).success(function () {
				 $scope.listarClientes();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarClientes();
	$scope.listarServicos();
	
	
});





