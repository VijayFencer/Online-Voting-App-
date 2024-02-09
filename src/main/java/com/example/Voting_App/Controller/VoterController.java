package com.example.Voting_App.Controller;

import com.example.Voting_App.DTO.UserDto;
import com.example.Voting_App.Entity.User;
import com.example.Voting_App.Service.Voter_Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class VoterController {
    @Autowired
    private Voter_Service service;

    @ModelAttribute("voter")
    public User create()
    {
        return new User();
    }

    @GetMapping({"/", "/index"})
    public String hello(){
        return "index";
    }

    @GetMapping("/user")
    public String userpage(){
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, HttpSession session)
    {

        if(service.saveVoter(user)) {
            session.setAttribute("registrationMessage", "User registered successfully!");
            return "index";
        }
        else {
            session.setAttribute("ExistUser", "User already Exist");
            return "index";
        }
    }
    @GetMapping("/remove-registration-message")
    @ResponseBody
    public void removeRegistrationMessage(HttpSession session) {

        session.removeAttribute("registrationMessage");

    }
    @GetMapping("/remove-exist")
    @ResponseBody
    public void removeExist(HttpSession session) {

        session.removeAttribute("ExistUser");

    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,Model model,HttpSession session)
    {
        User exist=service.login(user.getVoterName(),user.getPassword());
        if(exist==null)
        {
            session.setAttribute("wronglog","Invalid Credinals");
            return "index";
        }
        else{
            model.addAttribute("user",exist);
            return "user";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }

    @GetMapping("/remove-loginfail")
    @ResponseBody
    public void removeloger(HttpSession session)
    {
        session.removeAttribute("wronglog");
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users)
    {

        return service.saveVoters(users);
    }

    @GetMapping("/getUser/{id}")
    public User findVoter(@PathVariable(value="id") int id){
       return service.getVoterById(id);
    }

    @GetMapping("getUserByName/{name}")
    public User findVoter(@PathVariable(value="name") String name)
    {
        return service.getVoterByName(name);
    }
    @GetMapping("/getUsers")
    public List<User> findAllVoters(){
        return service.getVoters();
    }

    @PutMapping("/update")
    public User updateVoter(@RequestBody User user)
    {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delteVoter(@PathVariable int id)
    {
        return service.deleteVoter(id);
    }

}