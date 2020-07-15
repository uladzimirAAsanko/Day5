package by.sanko.stringproject.service;

import by.sanko.stringproject.exception.ProjectException;

public interface ReplaceInText {

    String replaceLetterFromPosition(String text, char c, int position) throws ProjectException;

    String correctMisprint(String text) throws ProjectException;

    String replaceWordsOnSubstring(String text, int wordLength, String substring) throws ProjectException;
}
