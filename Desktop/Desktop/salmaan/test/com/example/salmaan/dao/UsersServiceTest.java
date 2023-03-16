package com.example.salmaan.dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {

    @Test
    void users() throws SQLException {

        System.out.println(UsersService.users());
        System.out.println(UsersService.users().hashCode());

        System.out.println(UsersService.users().hashCode());

        System.out.println(UsersService.users().hashCode());

    }
}