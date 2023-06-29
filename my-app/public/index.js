
function setError(id, error) {
  element = document.getElementById(id);
  element.getElementsByClassName('formerror')[0].innerHTML = error;
}
function clearerrors(){
  errors= document.getElementsByClassName('formerror');
 for(let itmes of errors){
  itmes.innerHTML="";
 }
}
function formValidation() {
  var returnval = true;
  clearerrors();
  var firstName = document.forms['myform']["firstname"].value;
  if (firstName.length < 3 || firstName.length > 20) {
    setError("firstname", "*Length is too short or too long!");
    returnval = false;
  }
  if (containsSpecialChars(firstName)) {
    setError("firstname", "*Digit and Special character not allowed!");
    returnval = false;
  }
  var lastName = document.forms['myform']["lastname"].value;
  if (lastName.length < 3 || lastName.length > 20) {
    setError("lastname", "*Length is too short or too long!");
    returnval = false;
  }

  if (containsSpecialChars(lastName)) {
    setError("lastname", "*Digit and Special character not allowed!");
    returnval = false;

  }

  var emaile = document.forms['myform']["femail"].value;
  if (emaile.length > 40){
    setError("email", "*email Length is  too long!");
    returnval = false;
  }
  if (!isGmailOrYahoo(emaile)){
    setError("email", "*Only gmail and yahoo formate allowed!");
    returnval = false;
  }
  var pass = document.forms['myform']["fpass"].value;
  var cpass = document.forms['myform']["fcpass"].value;
  if (pass.length < 6) {
    setError("passd", "*Password length should be greater then!");
    returnval = false;
  }
  if (!CheckPassword(pass)) {
    setError("passd", "*please check password formate[0-9,A-Z,a-z,@-&]!");
    returnval = false;
  }

  if (pass != cpass) {
    setError("passd", "*password and confirm passord should be same!");
    returnval = false;
  }

  return returnval;
}

function CheckPassword(inpute) {
  const passw = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
  return passw.test(inpute);
}
function containsSpecialChars(str) {
  const specialChars = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
  return specialChars.test(str);
}
function isGmailOrYahoo(mailaddr) {
  return mailaddr.endsWith('@gmail.com') || mailaddr.endsWith('@yahoo.com');
}

