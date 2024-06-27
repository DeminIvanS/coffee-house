package aiven_s.example.controller;

import aiven_s.example.dto.RoleDTO;
import aiven_s.example.dto.UserDTO;
import aiven_s.example.dto.UserFormDTO;
import aiven_s.example.entity.User;
import aiven_s.example.service.RoleService;
import aiven_s.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("api/v1/users")
public class UsersController {
    private final UserService userService;
    private final RoleService roleService;

    public UsersController(UserService userService,
                           RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }
    @RequestMapping("")
    public String getUsers(Model model){
        List<UserDTO> users = userService.findAll()
                .stream()
                .map(UserDTO::fromUser)
                .toList();
        model.addAttribute("users", users);
        return "user/list";
    }
    @GetMapping("/{id}")
    public String editUser(@PathVariable("id")Long id,Model model){
        User user = userService.findById(id);
        List<RoleDTO> roles = roleService.findAll()
                        .stream()
                        .map(RoleDTO::fromRole)
                        .toList();
        model.addAttribute("user", UserFormDTO.fromUser(user));
        model.addAttribute("roles", roles);
        return "user/form";
    }
    @GetMapping("/new")
    public String createUser(Model model){
        List<RoleDTO> roles = roleService.findAll()
                .stream()
                .map(RoleDTO::fromRole)
                .toList();
        model.addAttribute("user", UserFormDTO.fromUser(new User()));
        model.addAttribute("roles",roles);
        return "user/form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute UserFormDTO user){
        userService.save(user.toUser());
        return "redirect:/api/v1/users";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/api/v1/users";
    }

}
