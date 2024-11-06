<?php


$carro=[
    'Marca' =>'BMW',
    'Roda' =>4,
    'Teto_solar' =>true,
    'Velocidade_max' =>300,
    'Blindado' =>false
];




print_r($carro);

echo "<br>";

$marca= $carro['Marca'];
$velocidade_maxima= $carro['Velocidade_max'];


echo"o carro é marca $marca e atinge no máximo $velocidade_maxima Km/h";




?>