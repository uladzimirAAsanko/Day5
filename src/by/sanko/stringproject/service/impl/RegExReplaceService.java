package by.sanko.stringproject.service.impl;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.ReplaceInText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceService implements ReplaceInText {
    private static final String WORD_SAME_LENGTH = "\\b\\p{L}{%d}\\b";
    private static final String ORDINAL_LETTER = "\\b(\\p{L}{%d})(\\p{L})(\\p{L}*)";
    private static final String REPLACE_GROUP = "$1%s$3";
    @Override
    public String replaceLetterFromPosition(String text, char c, int position) throws ProjectException {
        if(text == null || position < 1){
            throw new ProjectException();
        }
        Pattern pattern = Pattern.compile(String.format(ORDINAL_LETTER, position - 1));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(String.format(REPLACE_GROUP, c));

        return text;
    }

    @Override
    public String correctMisprint(String text) throws ProjectException {
        if(text == null){
            throw new ProjectException();
        }
        Pattern pattern = Pattern.compile("PA");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("PO");

        return text;
    }

    @Override
    public String replaceWordsOnSubstring(String text, int wordLength, String substring) throws ProjectException {
        if(text == null || wordLength < 1 || substring == null){
            throw new ProjectException();
        }
        Pattern pattern = Pattern.compile(String.format(WORD_SAME_LENGTH, wordLength));
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(substring);

        return text;
    }
}
