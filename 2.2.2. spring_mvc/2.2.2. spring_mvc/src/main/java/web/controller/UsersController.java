package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user")
    public String userPageGet() {
        return "userPage";
    }

    @GetMapping(value = "")
    public String loginUserGet() {
        return "starterPage";
    }

    @PostMapping(value = "")
    public String loginUserPost(WebRequest webRequest, ModelMap model) {
        String login = webRequest.getParameter("login");
        String password = webRequest.getParameter("password");
        if (userService.getUserByLogAndPass(login, password) == null) {
            model.addAttribute("errorText", "No user with this data exists");
            return "error";
        } else {
            return "redirect:user";
        }
    }


    @GetMapping(value = "admin")
    public String printUsers(ModelMap model) {
        List<User> userList = userService.getAllUsers();

        model.addAttribute("listUser", userList);
        return "admin/user-list";
    }

    @GetMapping(value = "/admin/new")
    public String addUserGet() {
        return "admin/user-form";
    }

    @PostMapping(value = "/admin/add")
    public String addUserPost(WebRequest webRequest, ModelMap model) {
        try {
            String name = webRequest.getParameter("name");
            int age = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("age")));
            if (name.isEmpty() || age < 0 || age > 150) {
                model.addAttribute("errorText", "Incorrect user fields.");
                return "error";
            }
            String login = webRequest.getParameter("login");
            String password = webRequest.getParameter("password");
            String role = webRequest.getParameter("role");

            if (userService.isExistLogin(login)) {
                model.addAttribute("errorText", "User with same login already exist.");
                return "error";
            }
            User user = new User(name, age, login, password, role);
            if (!userService.addUser(user)) {
                model.addAttribute("errorText", "Error while processing user edit.");
                return "error";
            }
            model.addAttribute("errorText", "User was added successfully!");
            return "error";
        } catch (Exception e) {
            model.addAttribute("errorText", "Error while processing user.");
            return "error";
        }
    }


    @GetMapping(value = "/admin/update")
    public String updateUserGet(@RequestParam(value = "id") String idStr, ModelMap model) {
        User user;
        try {
            int id = Integer.parseInt(idStr);
            user = userService.getUserById(id);
            if (user == null) {
                model.addAttribute("errorText", "This user doesn't exist.");
                return "error";
            }
            model.addAttribute("userForEdit", user);
            return "admin/user-form";
        } catch (Exception e) {
            model.addAttribute("errorText", "Error while processing user.");
            return "error";
        }
    }


    @PostMapping(value = "/admin/update")
    public String editUserPost(WebRequest webRequest, ModelMap model) {
        try {

            String name = webRequest.getParameter("name");
            int age = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("age")));
            int id = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("id")));
            String login = webRequest.getParameter("login");
            String password = webRequest.getParameter("password");
            String role = webRequest.getParameter("role");
            if (name.isEmpty() || age < 0 || age > 150) {
                model.addAttribute("errorText", "Incorrect user fields.");
                return "error";
            }
            User user = new User(id, name, age, login, password, role);
            model.addAttribute("user", user);
            if (!userService.updateUser(user)) {
                model.addAttribute("errorText", "Error while processing user edit.");
                return "error";
            }
            return "redirect:admin";
        } catch (Exception e) {
            model.addAttribute("errorText", "Error while processing user.");
            return "error";
        }
    }

    @GetMapping(value = "/admin/delete")
    public String deleteUserGet(WebRequest webRequest, ModelMap model) {
        try {
            int id = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("id")));
            if (!userService.deleteUser(id)) {
                model.addAttribute("errorText", "Error while processing user edit.");
                return "error";
            }
            model.addAttribute("errorText", "User was deleted successfully.");
            return "error";
        } catch (Exception e) {
            model.addAttribute("errorText", "Error while processing user.");
            return "error";
        }
    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        return "raw data";
    }
}