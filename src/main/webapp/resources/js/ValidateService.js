function validateForm() {
    let name = document.getElementById('name').value;
    if(name==null){
        document.getElementById("textMessageError").innerHTML="Name field may not be the empty";
        return false;
    }
}

