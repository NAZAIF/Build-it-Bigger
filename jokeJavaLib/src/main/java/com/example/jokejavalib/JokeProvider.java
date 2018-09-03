package com.example.jokejavalib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokeProvider {

    List<String> jokes = asList(
            "I own the world’s worst thesaurus. Not only is it awful, it’s awful.",
            "What’s the difference between a good joke and a bad joke timing.",
            "Velcro – what a rip-off!",
            "I hate Russian dolls, they’re so full of themselves.");

    public String getJokes() {
        int randNum = new Random().nextInt(3);
        return jokes.get(randNum);
    }

}
