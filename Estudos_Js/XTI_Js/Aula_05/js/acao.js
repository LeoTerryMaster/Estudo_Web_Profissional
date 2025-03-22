function calcularIMC() {
  var forumlario = document.getElementById("formulario");

  var kilos = +forumlario.kilos.value;
  var metros = +forumlario.metros.value;
  var centientros = +forumlario.centientros.value;

  var altura = (metros * 100 + centientros) / 100;

  var imc = kilos / (altura * altura)

  forumlario.imc.value = imc.toFixed(2);

  if (imc < 20) {
    alert("Abaixo de peso");
  } else if (imc > 20 && imc <= 25) {
    alert("Peso ideal");
  } if (imc >= 25 && imc <= 30) {
    alert("Vc esta gordo!!!");
  } if (imc >= 35 && imc <= 40) {
    alert("Obesidade Moderada");
  } if (imc >= 40 && imc <= 50) {
    alert("Obesidade Mórbida");
  } else {
    alert("Super Obesidade");
  }



}