

var texto = "";
var legf = 80;


for(var i=0; i<=legf; i++ ){
   if((i % 2)==0){
    if(i == legf){
        texto += i; 
        break;
    }
        texto += i + ", ";
   }
}
alert(texto);