package aiven_s.example.dto;

import aiven_s.example.entity.Role;
import aiven_s.example.entity.User;

public record UserFormDTO (
        Long id,
        String username,
        String password,
        String confirmPassword,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        RoleDTO role
){
    public User toUser(){
        Role role = new Role();
        Long roleId = this.role != null
                ? this.role.id()
                : null;
        String roleName = this.role != null
                ? this.role.name()
                : null;
        role.setId(roleId);
        role.setName(roleName);

        User user = new User();
        user.setId(this.id);
        user.setRole(role);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPhoneNumber(this.phoneNumber);
        return user;
    }
    public static UserFormDTO fromUser(User user){
        return new UserFormDTO(
                user.getId(),
                user.getUsername(),
                "",
                "",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                RoleDTO.fromRole(user.getRole()));
    }

}
