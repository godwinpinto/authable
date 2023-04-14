package com.github.godwinpinto.authable.application;

import com.github.godwinpinto.authable.orchestration.AuthableApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuthableApplicationTest {


    @Test
    public static void main(String[] args) {
        AuthableApplication.main(new String[]{});
    }

}
