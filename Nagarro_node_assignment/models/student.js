const mongoose = require("mongoose")
const { Schema } = mongoose;

//Student schema
const studentSchema = new Schema({
  roll: {
    type : Number,
    unique : true
  } ,
  name: String,     
  dob:{
    type:Date
  } ,
  score:Number 
});

//exporting the model
module.exports = mongoose.model("Student", studentSchema)