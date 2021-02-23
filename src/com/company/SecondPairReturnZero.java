package com.company;

import java.util.NoSuchElementException;

public class SecondPairReturnZero {

    private final int theXValue;
    private final int theYValue;

    public SecondPairReturnZero(int x, int y)
    {
        this.theXValue = x;
        this.theYValue = y;
        int sum = this.theXValue + this.theYValue;
        if (sum != 0)
        {
            throw new NoSuchElementException("Not available");
        }
    }

    //ToString method for the Pair class.

    @Override
    public String toString() {
        return ("Pair[{"+ this.theXValue +", " + this.theYValue + "]");
    }

    static SecondPairReturnZero[] MakePairs(int[] givenArray)
    {
        SecondPairReturnZero[] listOfPairs = new SecondPairReturnZero[givenArray.length];

        int count = 0;
        while (count < givenArray.length)
        {
            var resultOfThePair = new SecondPairReturnZero(givenArray[count], -1 * givenArray[count]);

            listOfPairs[count]= resultOfThePair;

            count++;

        }

        return listOfPairs;
    }


    public static void main(String[] args) {


        // declare array
        int[] GivenArray = { 709, 683, 42, 30, 83, 97, 11, 77, 55, 33, -99};

        //use rhe method to create the pairs
        var result = MakePairs(GivenArray);

        System.out.println("\nQuestion 1 Content of the Pair number that add up to zero\n");

        // loop and display the values
        for (var pair :result) {
            System.out.println(pair);
        }


        System.out.println("\n/////////////////////////////////////////////////////////////////");

    }


}
