

var texto = "";

for(var i=0; i<=40; i++ ){
   if((i % 2)==0){
    if(i == 40){
        texto += i; 
        break;
    }
        texto += i + ", ";
   }
}

alert(texto);