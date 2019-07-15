function validateFields() {
    let generalPrice = document.getElementById('generalPrice').value;
    let dateOrdering = document.getElementById('dateOrdering').value;
    let numberService = document.getElementById('numberService').value;

    if(generalPrice=="" ||!(generalPrice.isNumeric()) &&dateOrdering=="" && numberService=="" || !(numberService.isNumeric())){
        document.getElementsByClassName('message_error').item(0).innerHTML = "Field must be filled";
        document.getElementsByClassName('message_error').item(1).innerHTML = "Field must be filled";
        document.getElementsByClassName('message_error').item(2).innerHTML = "Error!!! Check the field";
        return false;
    }else {
        document.getElementsByClassName('message_error').item(0).innerHTML = "";
        document.getElementsByClassName('message_error').item(1).innerHTML = "";
        document.getElementsByClassName('message_error').item(2).innerHTML = "";
    }



    if(generalPrice=="" ||!(generalPrice.isNumeric())){
        document.getElementsByClassName('message_error').item(0).innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementsByClassName('message_error').item(0).innerHTML = "";
    }

    if(dateOrdering==""){
        document.getElementsByClassName('message_error').item(1).innerHTML = "Field must be filled";
        return false;
    }else {
        document.getElementsByClassName('message_error').item(1).innerHTML = "";
    }

    if(dateOrdering=="" && numberService=="" || !(numberService.isNumeric())){
        document.getElementsByClassName('message_error').item(1).innerHTML = "Field must be filled";
        document.getElementsByClassName('message_error').item(2).innerHTML = "Error!!! Check the field";
        return false;
    }else {
        document.getElementsByClassName('message_error').item(1).innerHTML = "";
        document.getElementsByClassName('message_error').item(2).innerHTML = "";
    }



    if(numberService=="" || !(numberService.isNumeric())){
        document.getElementsByClassName('message_error').item(2).innerHTML = "Error!!! Check the field";
        return false;
    }else {
        document.getElementsByClassName('message_error').item(2).innerHTML = "";
    }

    return true;
}


