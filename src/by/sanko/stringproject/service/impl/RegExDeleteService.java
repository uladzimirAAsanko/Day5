package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.DeleteFromText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDeleteService  implements DeleteFromText {
    private static final String WORD = "\\p{L}+";
    private static final String NOT_LETTERS = "(?u)[^a-zA-z]";
    private static final String WORD_SAME_LENGTH = "\\b\\w{0,0}\\b";
    private static final String STARTED_ON_CONSONANT  = "^(?i:[^aeiouy]).*";
    private static final String BOUND = "\\b";

    @Override
    public String deleteNotLetters(String text) throws ProjectException {
        if(text == null){
            throw new ProjectException();
        }
        Pattern pattern = Pattern.compile(NOT_LETTERS);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        return text.trim().replaceAll(" +", " ");
    }

    @Override
    public String deleteWordsSameLongStartedOnConsonant(String text, int wordLength) throws ProjectException {

        String findWordsLength = WORD_SAME_LENGTH;
        String sizeOfNeededLength = "" + wordLength;
        findWordsLength = findWordsLength.replaceAll("0", sizeOfNeededLength);
        String[] words = text.split(BOUND);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(words[i].matches(STARTED_ON_CONSONANT) && words[i].matches(WORD)){
                if(!words[i].matches(findWordsLength)){
                    stringBuilder.append(words[i]).append(" ");
                }
            }else{
                stringBuilder.append(words[i]).append(" ");
            }
        }
        return stringBuilder.toString().trim().replaceAll(" +", " ");
    }
}
