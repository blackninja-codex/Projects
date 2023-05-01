//jshint esversion:6
const express = require("express");
const bodyParser = require("body-parser");
const ejs = require("ejs");
const mongoose = require("mongoose");
const session = require('express-session');
const passport = require("passport");
const passportLocalMongoose = require("passport-local-mongoose");
const port = process.env.PORT || 3000;
const app = express();

app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({extended: true}));

app.use(session({
  secret: "Our little secret.",
  resave: false,
  saveUninitialized: false
}));

app.use(passport.initialize());
app.use(passport.session());

mongoose.connect("mongodb+srv://akshatpathak:<password>@cluster0.oragqyq.mongodb.net/userDB", {useNewUrlParser: true});


const userSchema = new mongoose.Schema({
    username: String,
    password: String,
    offHours: [String]
});

const appointmentSchema = new mongoose.Schema({
    title: String,
    agenda: String,
    time: String,
    guest: String
});

userSchema.plugin(passportLocalMongoose);

const User = new mongoose.model("User", userSchema);
const Appointment = new mongoose.model("Appointment", appointmentSchema);

passport.use(User.createStrategy());

passport.serializeUser(function(user, done) {
  done(null, user.id);
});

passport.deserializeUser(function(id, done) {
  User.findById(id, function(err, user) {
    done(err, user);
  });
});

app.get("/", function(req, res){
    res.render("home");
});

app.get("/login", function(req, res){
    res.render("login");
});
  
app.get("/register", function(req, res){
    res.render("register");
});

app.get("/update",function(req,res){
    res.render("update");
});

app.get("/logout", function(req, res){
    req.logout();
    res.redirect("/");
  });
  
app.post("/register", function(req, res){
  
    User.register({username: req.body.username}, req.body.password, function(err, user){
      if (err) {
        console.log(err);
        res.redirect("/register");
      } else {
        passport.authenticate("local")(req, res, function(){
          res.redirect("/profile");
        });
      }
    });
  
});
  
app.post("/login", function(req, res){
  
    const user = new User({
      username: req.body.username,
      password: req.body.password
    });
  
    req.login(user, function(err){
      if (err) {
        console.log(err);
      } else {
        passport.authenticate("local")(req, res, function(){
          res.redirect("/profile");
        });
      }
    });
});

app.get("/update", function(req, res){
  if (req.isAuthenticated()){
    res.render("update");
  } else {
    res.redirect("/login");
  }
});

app.post("/update", function(req, res){
    User.findByIdAndUpdate(req.user.id,{name:req.body.username,password:req.body.password}, function(err){
      if(err){
        console.log(err);
      }else{
        console.log("Updated");
        res.redirect("/profile");
      }
    });
});

app.get("/offHours", function(req, res){
  if (req.isAuthenticated()){
    res.render("offHours");
  } else {
    res.redirect("/login");
  }
});

app.post("/offhours", function(req, res){
  const { start, end } = req.body;
  User.findByIdAndUpdate(req.user.id, { offhours: { start, end } }, function(err){
    if (err) {
      console.log(err);
    }
    res.redirect('/profile');
  });
});

app.get("/appointment", function(req, res){
  if (req.isAuthenticated()){
    res.render("appointment");
  } else {
    res.redirect("/login");
  }
});

app.post("/appointment", async (req, res) => {
  const { title, agenda, time, guest } = req.body;

  const guestUser = await User.findOne({ name: guest });
  if (!guestUser || guestUser.offHours.includes(time)) {
    res.write("Guest is not available at this time");
    res.redirect("/appointment")
  }

  const appointment = new Appointment({ title, agenda, time, guest });
  appointment.save(function(){
    res.write("Appointment scheduled successfully");
    res.redirect("/appointment");
  });
});


app.listen(port, function(){
    console.log(`App listening on port ${port}`);
})