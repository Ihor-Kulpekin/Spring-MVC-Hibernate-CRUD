function validateEditNameService() {
    let kindService = document.getElementById('kindService').value;
    let price = document.getElementById('price').value;


    if(kindService=="" && price==""){
        document.getElementById('kindService_error').innerHTML = "Field must be filled";
        document.getElementById('price_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('kindService_error').innerHTML = "";
        document.getElementById('price_error').innerHTML = "";
    }


    if(kindService==""){
        document.getElementById('kindService_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('kindService_error').innerHTML = "";
    }

    if(price==""){
        document.getElementById('price_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('price_error').innerHTML = "";
    }

    return true;
}



function validateNameService() {

    let nameService = document.getElementById('selectValue');
    let kindService = document.getElementById('kindService').value;
    let price = document.getElementById('price').value;

    if(nameService.options[nameService.selectedIndex].value =="" && kindService=="" && price==""){
        document.getElementById('nameService_error').innerHTML = "Field must be filled";
        document.getElementById('kindService_error').innerHTML = "Field must be filled";
        document.getElementById('price_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('nameService_error').innerHTML = "";
        document.getElementById('kindService_error').innerHTML = "";
        document.getElementById('price_error').innerHTML = "";
    }

    if(kindService=="" && price==""){
        document.getElementById('kindService_error').innerHTML = "Field must be filled";
        document.getElementById('price_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('kindService_error').innerHTML = "";
        document.getElementById('price_error').innerHTML = "";
    }

    if(nameService.options[nameService.selectedIndex].value ==""){
        document.getElementById('nameService_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('nameService_error').innerHTML = "";
    }

    if(kindService==""){
        document.getElementById('kindService_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('kindService_error').innerHTML = "";
    }

    if(price==""){
        document.getElementById('price_error').innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementById('price_error').innerHTML = "";
    }

    return true;
}

