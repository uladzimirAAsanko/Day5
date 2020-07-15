package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.DeleteFromText;

public class StringDeleteService implements DeleteFromText {

    private final static String BOUND = "\\b";
    private final static String NOT_LETTER = "[^\\p{L}]";
    private final static String WORD = "\\p{L}+";
    private final static String VOWELS = "AOUIE&&aoeui";

    @Override
    public String deleteNotLetters(String text) throws ProjectException {
        if(text == null) {
            throw new ProjectException();
        }

        StringBuilder correctText = new StringBuilder();
        String[] words = text.split(BOUND);
        for(int i = 0; i < words.length; i++){
            if(words[i].matches(WORD)){
                correctText.append(words[i]);
            }else{
                String correctWord = words[i].replaceAll(NOT_LETTER, " ");
                correctWord = correctWord.replaceAll(" +", " ");
                correctText.append(correctWord);
            }
        }

        return correctText.toString();
    }

    @Override
    public String deleteWordsSameLongStartedOnConsonant(String text, int wordLength) throws ProjectException {
        if(text == null || wordLength < 1){
            throw new ProjectException();
        }

        StringBuilder correctText = new StringBuilder();
        String[] words = text.split(BOUND);
        for(int i = 0; i < words.length; i++){
            if(words[i].length() != wordLength){
                correctText.append(words[i]);
            }else {
                if(VOWELS.contains(String.valueOf(words[i].charAt(0))) || !words[i].matches(WORD)) {
                    correctText.append(words[i]);
                }
            }
        }
        return correctText.toString();
    }
}
