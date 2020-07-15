package by.sanko.stringproject.service;

import java.util.ArrayList;

public class HandlingCharService {

    public char[][] allWordsFromText(String text) {
        ArrayList<char[]> charList = new ArrayList<>();
        char[] charText = text.toCharArray();
        int indexOfLastBound = -1;
        for(int i = 0; i < charText.length; i++){
            if(charText[i] == ' ' || charText[i] == '.' || charText[i] == ',' || charText[i] == '\n'){
                charList.add(text.substring(indexOfLastBound+1, i).toCharArray());
                indexOfLastBound = i;
            }
        }
        charList.add(text.substring(indexOfLastBound+1).toCharArray());
        char[][] words = new char[charList.size()][];
        for(int i = 0; i < words.length; i++){
            words[i] = charList.get(i);
        }
        return words;
    }

    public boolean isItWord(char[] word) {
        for(int i = 0; i < word.length; i++){
            if(!Character.isAlphabetic(word[i]) && word[i] != ' '){
                return  false;
            }
        }
        return true;
    }
}
