package com.mf.spring.springmvsboot.database;

import com.mf.spring.springmvsboot.model.Role;
import com.mf.spring.springmvsboot.model.User;
import com.mf.spring.springmvsboot.service.RoleService;
import com.mf.spring.springmvsboot.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInit {

    private final UserService userService;
    private final RoleService roleService;

    public DataBaseInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void addUsersInDB() {
        User admin = new User("root", "root", 99, "root");
        User user = new User("user", "user", 15, "user");
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        admin.setOneRole(adminRole);
        user.setOneRole(userRole);
        userService.addUser(admin);
        userService.addUser(user);
    }
}