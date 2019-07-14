let firstName = document.getElementById('firstName');
let lastName = document.getElementById('lastName');
let position = document.getElementById('position');


function validateFormWorker() {
    firstName = document.getElementById('firstName').value;
    lastName = document.getElementById('lastName').value;
    position = document.getElementById('position').value;

    if(firstName=="" && lastName=="" && position==""){
        document.getElementById("firstName_error").innerHTML="First name field may not be the empty";
        document.getElementById("lastName_error").innerHTML="Last name field may not be the empty";
        document.getElementById("position_error").innerHTML="Position name field may not be the empty";
        return false;
    }else {
        document.getElementById("firstName_error").innerHTML="";
        document.getElementById("lastName_error").innerHTML="";
        document.getElementById("position_error").innerHTML="";
    }


    if(lastName=="" && position==""){
        document.getElementById("lastName_error").innerHTML="Last name field may not be the empty";
        document.getElementById("position_error").innerHTML="Position name field may not be the empty";
        return false;
    }

    if(firstName==null || firstName==""){
        document.getElementById("firstName_error").innerHTML="First name field may not be the empty";
        return false;
    }else {
        document.getElementById("firstName_error").innerHTML="";
    }

    if(lastName==null || lastName==""){
        document.getElementById("lastName_error").innerHTML="Last name field may not be the empty";
        return false;
    }else {
        document.getElementById("lastName_error").innerHTML="";
    }

    if(position==null || position==""){
        document.getElementById("position_error").innerHTML="Position name field may not be the empty";
        return false;
    }else {
        document.getElementById("position_error").innerHTML="";
    }

    return true;
}

