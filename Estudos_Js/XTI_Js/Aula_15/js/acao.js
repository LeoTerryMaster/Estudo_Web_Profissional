
var x = prompt("Informe número maior que 10");

try {
    if(x<10){
        throw "Número menor que 10";
    }
    alert(x);
} catch (error) {
   // alert(error.name + " = "+ error.message);
        alert(error.toString())
}