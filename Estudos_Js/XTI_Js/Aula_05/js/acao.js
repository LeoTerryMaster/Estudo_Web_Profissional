function calcularIMC(){
  var forumlario =  document.getElementById("formulario");

        var kilos= +forumlario.kilos.value;
        var metros= +forumlario.metros.value;
        var centientros= +forumlario.centientros.value;

        var altura= (metros* 100 + centientros)/100;

        var imc = kilos / (altura * altura)

        forumlario.imc.value = imc.toFixed(2);

}