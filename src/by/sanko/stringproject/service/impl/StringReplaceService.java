package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.ReplaceInText;

public class StringReplaceService implements ReplaceInText {
    private final static String BOUND = "\\b";
    private final static String WORD = "\\p{L}+";

    @Override
    public String replaceLetterFromPosition(String text, char c, int position) throws ProjectException {
        if(text == null || position <= 0){
            throw new ProjectException("Invalid data ");
        }

        String[] words = text.split(BOUND);
        for(int i = 0; i < words.length; i++){
            if(words[i].length() >= position - 1 && words[i].matches(WORD)){
                String correctWord = words[i].substring(0, position-1) + c + words[i].substring(position);
                text.replace(words[i], correctWord);
            }
        }
        return text;
    }

    @Override
    public String correctMisprint(String text) throws ProjectException {
        return null;
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String substring) throws ProjectException {
        return null;
    }
}
