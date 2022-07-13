package com.jmedia.converter.music;

import java.io.IOException;

public final class MusicConverter {

    public static void main(String[] args) {
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.ogg");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.wav");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.m4a");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.acc");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.flac");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.opus");
        new MusicConverter().convert("media/music/guitarsample.mp3", "media/music/guitarsample.webm");
    }

    public void convert(final String input, final String output) {
        final String ffmpegPath = "ffmpeg";

        String[] command={ffmpegPath,"-i", input, output};
        if (output.contains("m4a")) command=new String[]{ffmpegPath,"-i", input, "-c:a", "aac", "-vn", output};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
