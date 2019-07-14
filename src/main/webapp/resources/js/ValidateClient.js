function validateClientFields() {
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let mobile = document.getElementById('mobile').value;
    let email = document.getElementById('email').value;

    let emailPattern = /[0-9a-z_-]+@[0-9a-z_-]+\.[a-z]{2,5}/i;

        if(firstName=="" && lastName=="" && mobile=="" && emailPattern.test(email)==false){
            document.getElementById('firstName_error').innerHTML = "Field must be filled";
            document.getElementById('lastName_error').innerHTML = "Field must be filled";
            document.getElementById('mobile_error').innerHTML = "Field must be filled";
            document.getElementById('email_error').innerHTML = "Email must be correct. Example: aaaaa@aaaa.aaa";
            return false;
        }else {
            document.getElementById('firstName_error').innerHTML = "";
            document.getElementById('lastName_error').innerHTML = "";
            document.getElementById('mobile_error').innerHTML = "";
            document.getElementById('email_error').innerHTML = "";
        }

        if(lastName=="" && mobile=="" && emailPattern.test(email)==false){
            document.getElementById('lastName_error').innerHTML = "Field must be filled";
            document.getElementById('mobile_error').innerHTML = "Field must be filled";
            document.getElementById('email_error').innerHTML = "Email must be correct. Example: aaaaa@aaaa.aaa";
            return false;
        }else {
            document.getElementById('lastName_error').innerHTML = "";
            document.getElementById('mobile_error').innerHTML = "";
            document.getElementById('email_error').innerHTML = "";
        }
        if(mobile=="" && emailPattern.test(email)==false){
            document.getElementById('mobile_error').innerHTML = "Field must be filled";
            document.getElementById('email_error').innerHTML = "Email must be correct. Example: aaaaa@aaaa.aaa";
            return false;
        }else {
            document.getElementById('mobile_error').innerHTML = "";
            document.getElementById('email_error').innerHTML = "";
        }

        if(firstName=="" ){
            document.getElementById('firstName_error').innerHTML = "Field must be filled";
            return false;
        }
        else {
            document.getElementById('firstName_error').innerHTML = "";
        }

        if(lastName==""){
            document.getElementById('lastName_error').innerHTML = "Field must be filled";
            return false;
        }else {
            document.getElementById('lastName_error').innerHTML = "";
        }

        if(mobile==""){
            document.getElementById('mobile_error').innerHTML = "Field must be filled";
            return false;
        }else {
            document.getElementById('mobile_error').innerHTML = "";
        }

        if(emailPattern.test(email)==false){
            document.getElementById('email_error').innerHTML = "Email must be correct. Example: aaaaa@aaaa.aaa";
            return false;
        }else {
            document.getElementById('email_error').innerHTML = "";
        }


    return true;
}