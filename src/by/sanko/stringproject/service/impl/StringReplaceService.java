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

        StringBuilder correctText = new StringBuilder();
        String[] words = text.split(BOUND);
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > position - 1 && words[i].matches(WORD)){
                String correctWord = words[i].substring(0, position-1) + c + words[i].substring(position);
                correctText.append(correctWord);
            }else{
                correctText.append(words[i]);
            }
        }
        return correctText.toString();
    }

    @Override
    public String correctMisprint(String text) throws ProjectException {
        if(text == null){
            throw new ProjectException();
        }

        StringBuilder correctText = new StringBuilder();
        String[] words = text.split(BOUND);
        for(int i = 0; i < words.length; i++){
            String correctWord = words[i];
            int indexOfCharP = correctWord.indexOf('P');
            while(indexOfCharP >= 0 && indexOfCharP < correctWord.length() - 1){
                if(correctWord.charAt(indexOfCharP + 1) == 'A'){
                    correctWord = correctWord.substring(0,indexOfCharP + 1) + 'O' + correctWord.substring(indexOfCharP + 2);
                }
                indexOfCharP = correctWord.indexOf('P', indexOfCharP + 1);
            }
            correctText.append(correctWord);
        }
        return correctText.toString();
    }


    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String substring) throws ProjectException {
        if(text == null || wordLength < 1 || substring == null){
            throw new ProjectException();
        }

        StringBuilder correctText = new StringBuilder();
        String[] words = text.split(BOUND);

        for(int i = 0; i < words.length; i++){
            if(words[i].matches(WORD) && words[i].length() == wordLength){
                correctText.append(substring);
            }else{
                correctText.append(words[i]);
            }
        }
        return correctText.toString();
    }
}
