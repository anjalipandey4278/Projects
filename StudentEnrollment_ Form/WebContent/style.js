
function tableUpdate()
{  
    if ($("#name").val() != '' && $("#email").val() != '' && $("#website").val() != '' && $("#imageLink").val() != '') {

    		 tableAdd();
             formClear();
             $("#name").focus();
    	
           
     
    }
    else {
        document.getElementById("errorMsg").innerHTML = "Please Fill all the fields of the form";
    }
}
let count = 0;
function tableAdd()

{
    var genderOutput = genderChoice();
    var skillOutput  = skillChoices();
    if ($("#productTable tbody").length == 0) {
        $("#productTable").append("<tbody></tbody>");
    }
    // Odd row elements have different styling than even row
    if (count % 2 == 0) {
        $("#productTable tbody").append("<tr>" + "<td id='newData' class='animated fadeIn' style='height:100px'>" + "<b>" + $("#name").val() + "</b>" + "<br>" +
            genderOutput + "<br>" + $("#email").val() + "<br>" + '<a href="' + $("#website").val() + '" target="_blank">' + $("#website").val()+"</a>" + "<br>" + skillOutput
            + "</td>" + "<td id='newData' class='animated fadeIn'>" + '<a href="' + $("#imageLink").val() + '" target="_blank">' + '<img src="'
            + $("#imageLink").val() + '" alt="Photo" title="Click to open in new tab" style="width:125px;height:100px"></a>' + "</td>" + "</tr>");

    }
    // Even Row elements 
    else {
        $("#productTable tbody").append("<tr>" + "<td id='newData' class='animated fadeIn' >" + "<b>" + $("#name").val() + "</b>" + "<br>" +
            genderOutput + "<br>" +  '<a href="' + $("#website").val() + '" target="_blank">'+ $("#website").val()+"</a>"  + "<br>" + $("#email").val() +"<br>" + skillOutput
            + "</td>" + "<td id='newData' class='animated fadeIn'>" + '<a href="' + $("#imageLink").val() + '" target="_blank">' + '<img src="'
            + $("#imageLink").val() + '" alt="Photo" title="Click to open in new tab" style="width:125px;height:100px"></a>' + "</td>" + "</tr>");
    }
    count += 1;
}

function genderChoice()
{
    const choices = document.querySelectorAll('input[name="genderchoice"]'); // choices=male/female
    let selectedValue;
    for (const r of choices) {
        if (r.checked) {
            selectedValue = r.value;
            break;
        }
    }
    return selectedValue;
}

function skillChoices()
{
    const choices = document.querySelectorAll('input[name="skillchoice"]'); // java,cpp,c
    let selectedValue = [];
    for (const r of choices) {
        if (r.checked) {
            selectedValue.push(r.value);
        }
    }
    return selectedValue.toString(); // java cpp c.html
}

// Clears the form fields
function formClear()
{
    $("#name").val("");
    $("#email").val("") ;
    $("#website").val("") ;
    $("#imageLink").val("");
    document.getElementById("male").checked = true;
    document.getElementById("java").checked = true;
    document.getElementById("html").checked = false;
    document.getElementById("css").checked = false;
    document.getElementById("errorMsg").innerHTML = "<br>";

}