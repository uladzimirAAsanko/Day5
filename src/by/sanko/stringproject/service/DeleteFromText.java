package by.sanko.stringproject.service;

import by.sanko.stringproject.exception.ProjectException;

public interface DeleteFromText {

    String deleteNotLetters(String text) throws ProjectException;

    String deleteWordsSameLongStartedOnConsonant(String text, int wordLength) throws ProjectException;
}
