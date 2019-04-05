package ru.job4j.tracker;

public class SubInput {
    private String[] answers;
    private  int position = 0;

    public SubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask (String question) {
        System.out.print(question);
        return answers[position++];
    }
}
