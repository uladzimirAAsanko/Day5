package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.DeleteFromText;
import by.sanko.stringproject.service.HandlingCharService;

import java.util.ArrayList;

public class CharDeleteService implements DeleteFromText {


    @Override
    public String deleteNotLetters(String text) throws ProjectException {
        if(text == null) {
            throw new ProjectException();
        }
        char[] charText = text.toCharArray();
        ArrayList<Character> correctedText = new ArrayList<>();
        correctedText.add(' ');
        for(int i = 0; i < charText.length; i++){
            if(Character.isAlphabetic(charText[i]) || charText[i] == ' '){
                correctedText.add(charText[i]);
            }else{
                if(i > 0 && i < charText.length - 1 ){
                    if(Character.isAlphabetic(correctedText.get(correctedText.size() - 1 )) && Character.isAlphabetic(charText[i +1])){
                        correctedText.add(' ');
                    }
                }
            }
        }
        char[] tmp = new char[correctedText.size() - 1];
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = correctedText.get(i + 1);
        }
        return new String(tmp);
    }

    @Override
    public String deleteWordsSameLongStartedOnConsonant(String text, int wordLength) throws ProjectException {
        if(text == null || wordLength < 1){
            throw new ProjectException();
        }
        HandlingCharService handler = new HandlingCharService();
        StringBuilder builder = new StringBuilder();
        char[][] words = handler.allWordsFromText(text);
        for(int i = 0; i < words.length; i++){
            if(words[i].length == wordLength && handler.isItWord(words[i])){
                if(words[i][0] == 'a' || words[i][0] == 'A' || words[i][0] == 'O' || words[i][0] == 'o' || words[i][0] == 'i' || words[i][0] == 'I' || words[i][0] == 'u' || words[i][0] == 'U' || words[i][0] == 'e' || words[i][0] == 'E'){
                    builder.append(words[i]).append(" ");
                }
            }else{
                builder.append(words[i]).append(" ");
            }
        }
        return builder.toString().substring(0,builder.toString().length() - 1);
    }
}
