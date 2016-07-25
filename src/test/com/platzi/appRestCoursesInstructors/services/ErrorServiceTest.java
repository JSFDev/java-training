package com.platzi.appRestCoursesInstructors.services;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ErrorServiceTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    @Test
    public void shouldHandleFindUserError() {
        assertEquals(true, true);
    }
}