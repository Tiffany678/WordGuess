package com.github.zipcodewilmington;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    /** main method: declare an instant
     *  methods: 1. findWord    : declare the arrayList of words => take character parameter and return the word that contains that character
     *           2. charRelease    : the word will hide at first. if the user enter the right character, that character will release with its index as well.
     *                                      the other characters will remain hidden
     *           3. check winning   : return true if the user guess the word right
     *  run(): findWord()+ charRelease() + check winning()
     * */
    public static void main (String[] arg){
        Hangman hangmanGame =new Hangman();
        hangmanGame.run();
    }
    public String findWord(String[] arrayOfWords, String str){

        for(int i=0; i<arrayOfWords.length; i++){
            if(arrayOfWords[i].contains(str)){
                return arrayOfWords[i];
            }
        }
        return null;
    }
    public String chartRelease(String word, String hiddenWord, char characterEnter){
        // create array for the hiddenWord
        char[] newHiddenWord = new char[hiddenWord.length()];
        for(int i=0; i<hiddenWord.length(); i++){
            newHiddenWord[i]=hiddenWord.charAt(i);
        }

        // Look for the guessed character in the word and replace "_" with the character if found
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==(characterEnter)){
                newHiddenWord[i]=characterEnter;
            }
        }
        return new String(newHiddenWord);
    }

    public boolean winOrLose(String[] arrayOfWords, String word){
        return Arrays.asList(arrayOfWords).contains(word);
    }

    public void run(){
        Boolean play = true;
        String[] arrayOfWords = {"cat", "chicken","dog", "bird", "snake","pig"};
        Scanner in = new Scanner(System.in);
        String wordEnter;


        while(play) {
            System.out.println("Enter a lower case character to start the game: ");
            wordEnter = in.nextLine();
            String word = findWord(arrayOfWords, wordEnter);

            while (word==null) {
                System.out.println("Could not find any words contain " + wordEnter + ". Please enter another character.");
                wordEnter=in.nextLine();
                word = findWord(arrayOfWords,wordEnter);
            }
            String hiddenCharactersOfWord = "";
            for (int i = 0; i < word.length(); i++) {
                hiddenCharactersOfWord += "_";
            }

            String newCharRelease = chartRelease(word, hiddenCharactersOfWord, wordEnter.charAt(0));
            System.out.println(newCharRelease);
            for (int i = 0; i < word.length()-1; i++) {
                if (!newCharRelease.contains("_")) break;

                newCharRelease = chartRelease(word, newCharRelease, wordEnter.charAt(0));
                System.out.println("Enter the next character to guess the word: ");
                wordEnter = in.nextLine();
                newCharRelease = chartRelease(word, newCharRelease, wordEnter.charAt(0));
                System.out.println(newCharRelease);


            }
            if (winOrLose(arrayOfWords, newCharRelease)) {
                System.out.println("congratulation! You won.");
            } else System.out.println("What a pity! You lost. The mystery word is "+ word);

            System.out.println("Play again? y for Yes || n for No");
            if(in.nextLine().equals("n")){
                play=false;
            }
        }

    }

}
