package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswortValidatorTest {

    @Test
    public void validateLength_when_8characters_then_true(){
        //given
        String value = "hello123";
        //when
        boolean actual = PasswortValidator.validateLength(value);
        //then
        assertTrue(actual);
    }

    @Test
    public void validateLength_when_100characters_then_false(){
        //given
        String value = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //when
        boolean actual = PasswortValidator.validateLength(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateLengthTest_when_7characters_then_false(){
        //given
        String value = "hello12";
        //when
        boolean actual = PasswortValidator.validateLength(value);
        //then
        assertFalse(actual);
    }
    @Test
    public void validateDigits_when_dependency1_then_true(){
        //given
        String value = "dependency1";
        //when
        boolean actual = PasswortValidator.validateDigits(value);
        //then
        assertTrue(actual);
    }
    @Test
    public void validateDigits_when_dependency_then_false(){
        //given
        String value = "dependency";
        //when
        boolean actual = PasswortValidator.validateDigits(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateUppperAndLowerCaseLetters_when_depenDency1_then_true(){
        //given
        String value = "depenDency1";
        //when
        boolean actual = PasswortValidator.validateUppperAndLowerCaseLetters(value);
        //then
        assertTrue(actual);
    }

    @Test
    public void validateUppperAndLowerCaseLetters_when_dependency1_then_false(){
        //given
        String value = "dependency1";
        //when
        boolean actual = PasswortValidator.validateUppperAndLowerCaseLetters(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateCommonlyUsedPasswords_when_password_then_false(){
        //given
        String value = "password";
        //when
        boolean actual = PasswortValidator.validateCommonlyUsedPasswords(value);
        //then
        assertFalse(actual);
    }
    @Test
    public void validateCommonlyUsedPasswords_when_qwerty_then_false(){
        //given
        String value = "qwerty";
        //when
        boolean actual = PasswortValidator.validateCommonlyUsedPasswords(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateCommonlyUsedPasswords_when_1q2w3e_then_false(){
        //given
        String value = "1q2w3e";
        //when
        boolean actual = PasswortValidator.validateCommonlyUsedPasswords(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateSequence_when_12345_then_false(){
        //given
        String value = "12345";
        //when
        boolean actual = PasswortValidator.validateSequence(value);
        //then
        assertFalse(actual);
    }
    @Test
    public void validateSequence_when_abc12345_then_false(){
        //given
        String value = "abc12345";
        //when
        boolean actual = PasswortValidator.validateSequence(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateSequence_when_1234_then_true(){
        //given
        String value = "1234";
        //when
        boolean actual = PasswortValidator.validateSequence(value);
        //then
        assertTrue(actual);
    }
    @Test
    public void validateSequence_when_abc1234_then_true(){
        //given
        String value ="abc1234";
        //when
        boolean actual = PasswortValidator.validateSequence(value);
        //then
        assertTrue(actual);
    }

    @Test
    public void validateSpecialCharacters_when_dependencyWithDoubleColumn_then_true(){
        //given
        String value = "dependency:";
        //when
        boolean actual = PasswortValidator.validateSpecialCharacters(value);
        //then
        assertTrue(actual);
    }
    @Test
    public void validateSpecialCharacters_when_dependency_then_true(){
        //given
        String value = "dependency";
        //when
        boolean actual = PasswortValidator.validateSpecialCharacters(value);
        //then
        assertFalse(actual);
    }

    @Test
    public void validateWhiteSpaces_when_hello_hello_then_false(){
        //given
        String value = "hello hello";
        //when
        boolean actual = PasswortValidator.validateWhiteSpaces(value);
        //then
        assertFalse(actual);
    }
    @Test
    public void validateWhiteSpaces_when_dependency_then_true(){
        //given
        String value = "dependency";
        //when
        boolean actual = PasswortValidator.validateWhiteSpaces(value);
        //then
        assertTrue(actual);
    }

}