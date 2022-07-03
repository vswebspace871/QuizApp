package com.example.quizapp;

public class QuizModel {

    public static String[] question = {
            "Effiel Tower Located in Which City",
            "Statue of Liberty located in which City",
            "statue of The Thinker located in which city",
            "This Famous statue located in which city",
            "What is the Name of Famous Monument"
    };
    public static int[] imgArray = {
        R.drawable.eiffeltower,
            R.drawable.liberty,
            R.drawable.thinker,
            R.drawable.adiyogi,
            R.drawable.sphinx
    };

    public static String[][] choices = {
            {"Cannes", "Lyon","Paris", "Capetown"},
            {"Paris", "NewYork", "Delhi", "Colombo"},
            {"Colombo", "Tokyo", "NewYork", "Paris"},
            {"Coimbatore", "Pune", "Chennai", "Kashmir"},
            {"The Great Jinx", "The Great Quink", "The Great Sphinx", "The Great Hinx"}


    };

    public static String[] correctAnswers = {
            "Paris",
            "NewYork",
            "Paris",
            "Coimbatore",
            "The Great Sphinx"
    };
}
