package com.devglan.userportal.Controllers;

import com.devglan.userportal.Enums.ProfileEnum;
import com.devglan.userportal.Models.User;
import org.junit.Test;

import static com.devglan.userportal.Enums.ProfileEnum.GERAL;
import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void seUserProfileNullTest() {
        User user = new User();
        user.setProfile(GERAL);

        User userCriado = new User();
        UserController userController = new UserController();

        assertEquals(user.getProfile(), userController.seUserProfileNull(userCriado).getProfile());
    }

    @Test
    public void seUserProfileNullTest2() {

        User userCriado = new User();
        userCriado.setProfile(ProfileEnum.CHEFE_DEPART);
        UserController userController = new UserController();

        assertNotEquals(ProfileEnum.valueOf("GERAL"), userController.seUserProfileNull(userCriado).getProfile());
    }

    @Test
    public void seUserProfileNullTest3() {

        User userCriado = new User();
        userCriado.setProfile(ProfileEnum.FUNCIONARIO);
        UserController userController = new UserController();

        assertNotEquals(GERAL, userController.seUserProfileNull(userCriado).getProfile());
    }

    @Test
    public void seUserProfileNullTest4() {

        User userCriado = new User();
        userCriado.setProfile(GERAL);
        UserController userController = new UserController();

        assertEquals(ProfileEnum.GERAL, userController.seUserProfileNull(userCriado).getProfile());
    }

}