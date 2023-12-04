package org.example;

import java.util.*;

public class PasswortValidator {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            String value = createPassword();
            if(!validator(value)) System.out.println("problem!!!   " + value);
        }
    }

    public static String createPassword(){
        StringBuilder builder = new StringBuilder();
        int randomLength = new Random().nextInt(92) + 8;
        for (int i = 0; i < randomLength; i++) {
            char a = (char) new Random().nextInt(33, 126);
            builder.append(a);
        }

        Set<Integer> uniqueNumbersSet = new HashSet<>();
        while (uniqueNumbersSet.size() < 4) {
            int randomNumber = new Random().nextInt(randomLength - 1);
            uniqueNumbersSet.add(randomNumber);
        }
        Iterator<Integer> iterator = uniqueNumbersSet.iterator();
        while(iterator.hasNext()) {
            builder.setCharAt(iterator.next(), (char) (new Random().nextInt(122 - 97) + 97));
            builder.setCharAt(iterator.next(), (char) (new Random().nextInt(90 - 65) + 65));
            builder.setCharAt(iterator.next(), (char) (new Random().nextInt(63 - 58) + 58));
            builder.setCharAt(iterator.next(), (char) (new Random().nextInt(57 - 48) + 48));
        }
        return builder.toString();
    }
    public static boolean validator(String value){
        boolean[] conditions = {
                validateLength(value),
                validateDigits(value),
                validateUppperAndLowerCaseLetters(value),
                validateCommonlyUsedPasswords(value),
                validateSequence(value),
                validateSpecialCharacters(value),
                validateWhiteSpaces(value)
        };
        for(int i = 0; i < conditions.length; i++){
            if(!conditions[i]) System.out.println(i);
        }
        return true;
    }
    public static boolean validateLength(String value) {
        return value.length() >= 8 && value.length() < 100;
    }

    public static boolean validateDigits(String value) {
        for(char i: value.toCharArray()){
            if(Character.isDigit(i)) return true;
        }
        return false;
    }
    public static boolean validateWhiteSpaces(String value){
        for(char i: value.toCharArray()){
            if(Character.isWhitespace(i)) return false;
        }
        return true;
    }
    public static boolean validateSpecialCharacters(String value) {
        for(char i: value.toCharArray()){
            if(!Character.isDigit(i) && !Character.isAlphabetic(i)) return true;
        }
        return false;
    }

    public static boolean validateUppperAndLowerCaseLetters(String value) {
        boolean containsUpperCaseLetter = false;
        boolean containsLowerCaseLetter = false;

        for(char i: value.toCharArray()){
            if(Character.isUpperCase(i)) containsUpperCaseLetter = true;
            if(Character.isLowerCase(i)) containsLowerCaseLetter = true;
            if(containsLowerCaseLetter && containsUpperCaseLetter) return true;
        }
        return false;
    }


    public static boolean validateCommonlyUsedPasswords(String value) {
        String[] commonlyUsedPasswords = {"qwerty", "password", "1q2w3e"};
        for (String i : commonlyUsedPasswords) {
            if (value.toLowerCase().contains(i)) return false;
        }
        return true;
    }

    public static boolean validateSequence(String value) {
        char[] valueCharArray = value.toCharArray();
        for (int i = 0; i < valueCharArray.length; i++) {
            int detectSequence = 0;
            for (int j = i; j < valueCharArray.length; j++) {
                if(j == valueCharArray.length - 1) break;
                if(valueCharArray[j] + 1 == valueCharArray[j+1]) {
                    detectSequence++;
                } else{
                    detectSequence = 0;
                }
                if(detectSequence == 3) return false;
            }
        }
        return true;
    }
}