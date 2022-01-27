package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.config.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getAllUsers(Model model) {
        List<User> listUser = userService.getAllUsers();
        model.addAttribute("allUsers", listUser);
        return "allUsers-view";
    }
    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("User", user);
        return "user-info";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateInfo")
    public String edit(@RequestParam("userId") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("User",user);
        return "edit-user";
    }


    @RequestMapping("/update")
    public String update(@ModelAttribute("User") User user,Model model){
        model.addAttribute("User", userService.updateUser(user));
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String removeUser(@RequestParam("userId") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
