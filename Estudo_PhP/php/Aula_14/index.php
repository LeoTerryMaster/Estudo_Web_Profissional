<?php

$falso = true;

echo $falso;

echo "<br>";


if(true){
    echo "Instrução é verdadeira";
}else{
   echo "instrução é falsa";
}

echo "<br>";

if(false){
    echo "Instrução é verdadeira";
}else{
   echo "instrução é falsa";
}
echo "<br>";

if(is_bool($falso)){
echo"É verdadero";
}

?>