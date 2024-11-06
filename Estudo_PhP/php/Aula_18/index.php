<?php


$pessoa=[
    'nome' =>'Leandro',
    'idade' =>40,
    'profissão' =>'Programador',
    'Graduação' =>'Engenheiro de software'
];



print_r($pessoa);

echo "<br>";


$idade = $pessoa['idade'];

if($idade >= 18){
    echo"Maior de idade";
}else{
    echo"Menor de idade";
}



?>