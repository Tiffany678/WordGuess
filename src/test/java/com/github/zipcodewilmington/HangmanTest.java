package com.github.zipcodewilmington;

import com.github.zipcodewilmington.sample.Person;
import com.github.zipcodewilmington.sample.PersonInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
    @Test
    public void testFindWordTest(){
        String expect ="giving";
        String[] arrayOfWords = {"happy","thanks","thaanks","giving"};
        Hangman hangmanGame =new Hangman();
        Assert.assertEquals(expect, hangmanGame.findWord(arrayOfWords,"g"));

    }
    @Test
    public void testPlayGame1(){
        String expect="ha___";
        Hangman hangmanGame =new Hangman();
        Assert.assertEquals(expect, hangmanGame.chartRelease("happy","h____",'a'));

    }
    @Test
    public void testPlayGame2(){
        String expect="thaa___";
        Hangman hangmanGame =new Hangman();
        Assert.assertEquals(expect, hangmanGame.chartRelease("thaanks","th_____",'a'));

    }
    @Test
    public void testPlayGame3(){
        String expect="g_v___";
        Hangman hangmanGame =new Hangman();
        Assert.assertEquals(expect, hangmanGame.chartRelease("giving","g_v___",'a'));

    }
@Test
    public void testWinOrLose() {
        Hangman hangmanGame =new Hangman();
        String[] arrayOfWords = {"happy", "thanks", "thaanks", "giving"};

        // then
        Assertions.assertEquals(true, hangmanGame.winOrLose(arrayOfWords, "giving"));
    }
}
