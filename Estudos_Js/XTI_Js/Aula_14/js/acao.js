try {
    var x = a;
    var b = x + 10;
    alert(b);


} catch (error) {
   // alert(error.name + " = "+ error.message);
        alert(error.toString())
}