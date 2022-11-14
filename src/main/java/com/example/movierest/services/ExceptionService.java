package com.example.movierest.services;

import com.example.movierest.exceptionHandlers.MyException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void methodThrowsException() {
        throw new MyException("СУПЕРОШИБКА!!!");
    }
}
