package com.example.demo;

public class FizzBuzz {
    public String play(int number){

        if(number <= 0){
            throw new IllegalArgumentException();
        }
        else if (number % 15 == 0){
            return "FizzBuzz";
        }
        else if(number % 3 == 0){
            return "Fizz";
        }
        else if (number % 5 == 0){
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
