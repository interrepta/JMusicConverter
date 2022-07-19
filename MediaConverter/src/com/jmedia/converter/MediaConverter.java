package com.jmedia.converter;

import com.jmedia.MediaTask;

import java.io.IOException;

public abstract class MediaConverter implements MediaTask {

    private final String input;
    private final String output;
    private final String secondInput;

    private String ffmpegPath = "ffmpeg";

    public MediaConverter(final String input, final String output) {
        this.input = input;
        this.output = output;
        secondInput = "";
    }

    public MediaConverter(final String input, final String secondInput, final String output) {
        this.input = input;
        this.secondInput = secondInput;
        this.output = output;
    }

    public String input() { return input; }

    public String secondInput() { return secondInput; }

    public String output() { return output; }

    public String ffmpegPath() { return ffmpegPath; }

    @Override
    public void make() {

    }

    protected void run(final String [] command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
