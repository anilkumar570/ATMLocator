function Request(subset){
    if(subset === "all"){
        AllATMs();         
    }
    else if(subset === "city"){
        AllATMsInCity();        
    }
}

function AllATMs() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/locate/atms", false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var jsonArray = jQuery.parseJSON(xhttp.responseText);
    var source = $("#some-template").html();
    var template = Handlebars.compile(source);
    $('#form').html("");
    $('#form').append(template(jsonArray));
    //return jsonArray;
};
 
function AllATMsInCity() {
    var city = document.getElementById("CitySelector").value.toString(); 
    var xhttp = new XMLHttpRequest();
    //xhttp.open("GET", "/locate/atms/" + city, false);
    xhttp.open("GET", "/locate/atms", false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var jsonArray = jQuery.parseJSON(xhttp.responseText);
    var results = []; 
    for(var i = 0; i < jsonArray.length; i++){
        var element = jsonArray[i];
        if(element.address.city === city){
            results.push(element); 
        }
    }
    var source = $("#some-template").html();
    var template = Handlebars.compile(source);
    $('#form').html("");
    $('#form').append(template(results));
    //return results;    
};