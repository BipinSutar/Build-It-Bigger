package com.example;

import java.util.ArrayList;
import java.util.List;

public class JokeTeller {

    private static List<String> jokes;

    public JokeTeller() {
        //Create jokes
        jokes = new ArrayList<String>();

        jokes.add("Ordinarily, staring is creepy. But if you spread your attention across many individuals, then it's just people watching.");
        jokes.add("A neutron walks into a bar and orders a drink. When the neutron gets his drink, he asks, \"Bartender, how much do I owe you?\"\n" +
                "The bartender replies, \"For you, neutron, no charge.\"");
        jokes.add("Q: What did the baby digital watch say to the mommy analog watch?\n" +
                "\n" +
                "A: \"Look Ma, no hands!\"");
    }

    public void addJoke(String joke) {
        jokes.add(joke);
    }

    public String getJoke() {
        double random = Math.random();
        double interval = 1.0 / jokes.size();
        int index = (int) Math.floor(random / interval);

        return jokes.get(index);
    }
}