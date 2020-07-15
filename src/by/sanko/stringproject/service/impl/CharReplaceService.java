package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.HandlingCharService;
import by.sanko.stringproject.service.ReplaceInText;

public class CharReplaceService  implements ReplaceInText {


    @Override
    public String replaceLetterFromPosition(String text, char c, int position) throws ProjectException {
        if(text == null || position < 1){
            throw new ProjectException();
        }

        HandlingCharService handler = new HandlingCharService();
        StringBuilder builder = new StringBuilder();
        char[][] words = handler.allWordsFromText(text);
        for(int i = 0; i < words.length; i++){
            if(words[i].length > position - 1 && handler.isItWord(words[i])){
                words[i][position-1] = c;
            }
            builder.append(words[i]).append(" ");
        }
        return builder.toString().substring(0,builder.toString().length() - 1);
    }

    @Override
    public String correctMisprint(String text) throws ProjectException {
        if(text == null){
            throw new ProjectException();
        }

        HandlingCharService handler = new HandlingCharService();
        StringBuilder builder = new StringBuilder();
        char[][] words = handler.allWordsFromText(text);
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length; j++){
                if(words[i][j] == 'P' && j < words[i].length - 1){
                    if(words[i][j + 1] == 'A'){
                        words[i][j + 1] = 'O';
                        j++;
                    }
                }
            }
            builder.append(words[i]).append(" ");
        }
        return builder.toString().substring(0,builder.toString().length() - 1);
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String substring) throws ProjectException {
        if(text == null || wordLength < 1 || substring == null){
            throw new ProjectException();
        }

        HandlingCharService handler = new HandlingCharService();
        StringBuilder builder = new StringBuilder();
        char[][] words = handler.allWordsFromText(text);
        char[] charSubstring = substring.toCharArray();
        for(int i = 0; i < words.length; i++){
            if(words[i].length == wordLength && handler.isItWord(words[i])){
                builder.append(charSubstring);
            }else{
                builder.append(words[i]);
            }
            builder.append(" ");
        }
        return builder.toString().substring(0,builder.toString().length() - 1);
    }


}
