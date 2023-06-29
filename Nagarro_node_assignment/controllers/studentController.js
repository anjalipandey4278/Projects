const Student = require('../models/student');

const student_login_get = (req, res) => {
       res.render("student/login");
    };

const student_login_post = async (req, res) => {

        const Studetails = req.body.roll;   
        const studob = req.body.dob;
        const studentser = await Student.findOne({roll :Studetails , dob :studob }); 
         console.log(studentser)  
        if(studentser == null){
          console.log("------------------------------------------------------------------------")
         
          res.render("student/login", {
            error : "Login with correct roll number"
            
          });
        }   
         else{
          res.render("student/view", { gett : studentser});
         }
       
    };

//exporting student controller functions
module.exports={
    student_login_get,
    student_login_post
}