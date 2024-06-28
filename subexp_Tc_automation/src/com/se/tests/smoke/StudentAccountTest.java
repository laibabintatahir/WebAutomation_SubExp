package com.se.tests.smoke;

import com.se.rolesbase.StudentLoginBase;
import org.testng.annotations.Test;

public class StudentAccountTest extends StudentLoginBase {


    @Test
    public void verifyStudentIsLoggedIn(){


        System.out.println("A Student is now logged in");
    }

    @Test
    public void verifyWelcomeToTrainStudent(){

    }
}
