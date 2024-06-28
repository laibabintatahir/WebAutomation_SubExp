package com.se.rolesbase;

import com.se.LoginAsUserTestBase;
import com.se.config.Constants;

public class TeacherLoginBase extends LoginAsUserTestBase {

    public TeacherLoginBase() {
        this(false);
    }

    public TeacherLoginBase(boolean tearDownBrowserAfterEachTest) {
        super(Constants.TEACHER_LOGIN_DETAILS, tearDownBrowserAfterEachTest);
    }

}
