<?php
// Routes

$app->get('/departamento/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM dep') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});
$app->get('/funcionario/list', function ($request, $response) {

	$db = $this->db;
	foreach($db->query('SELECT * FROM emp') as $row){
		$return[] = $row;
	};

	return $response->withJson($return);
});

$app->post('/departamento/new', function ($request, $response) {

	$db = $this->db;
	$sth = $db->prepare("INSERT INTO dep VALUES (:n_dep, :nome_dep, :local_dep)");

	$departamento = $request->getParsedBody();
	$sth->execute($departamento);
	return $response->withJson($departamento); 

});
$app->post('/funcionario/new', function ($request, $response) {

	$db = $this->db;
	$sth = $db->prepare("INSERT INTO emp VALUES (:n_emp, :nome_emp, :cargo, :sal)");

	$funcionario = $request->getParsedBody();

	$sth->execute($funcionario);
	return $response->withJson($funcionario); 

});