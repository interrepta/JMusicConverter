package com.jmedia.merger;

import com.jmedia.MediaTask;

import java.io.IOException;
import java.util.List;

public abstract class MediaMerger implements MediaTask {

    private final List<String> mediaList;
    private final String output;
    private String ffmpegPath = "ffmpeg";

    public MediaMerger(final List <String> mediaList, final String output) {
        this.mediaList = mediaList;
        this.output = output;
    }

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

    protected List <String> mediaList() {
        return mediaList;
    }

    protected String output() {
        return output;
    }

    protected String ffmpegPath() {
        return ffmpegPath;
    }

}
