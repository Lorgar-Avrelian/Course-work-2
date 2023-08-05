package course_2.course_work_2.controllers;

import course_2.course_work_2.exceptions.BadRequestException;
import course_2.course_work_2.exceptions.MethodNotAllowed;
import course_2.course_work_2.exceptions.RandomGeneratorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CourseWorkExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequestException(BadRequestException e) {
        System.out.println(e.getMessage());
    }

    @ExceptionHandler(MethodNotAllowed.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void methodNotAllowed(MethodNotAllowed e) {
        System.out.println(e.getMessage());
    }
    @ExceptionHandler(RandomGeneratorException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public void randomGeneratorException(RandomGeneratorException e) {
        System.out.println(e.getMessage());
    }
}
