package aiven_s.example.dto;

import aiven_s.example.entity.Role;
import aiven_s.example.entity.User;

public record UserDTO(
        Long id,
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        RoleDTO role
) {
    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRole(role.toRole());
        return user;
    }
    public static UserDTO fromUser(User user){
        Role role = user.getRole() !=null ? user.getRole() : new Role();
        return new UserDTO(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                RoleDTO.fromRole(role));
    }
}
