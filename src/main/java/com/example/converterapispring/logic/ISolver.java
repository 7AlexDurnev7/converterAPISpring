package com.example.converterapispring.logic;

import com.example.converterapispring.service.ClassMessages;

public interface ISolver {
    // метод решения
    ClassMessages.OutputMessage solve(ClassMessages.InputMessage input);
}
