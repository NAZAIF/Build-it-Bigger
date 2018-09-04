package com.example.jokejavalib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokeProvider {

    private static List<String> jokes = asList(
            "I own the world’s worst thesaurus. Not only is it awful, it’s awful.",
            "What’s the difference between a good joke and a bad joke timing.",
            "Velcro – what a rip-off!",
            "I hate Russian dolls, they’re so full of themselves.");

    public static String getJokes() {
        int randNum = new Random().nextInt(jokes.size());
        return jokes.get(randNum);
    }

}
