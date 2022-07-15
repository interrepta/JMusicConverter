package com.jmedia.converter.music;

import com.jmedia.MediaConverter;

public final class MusicConverter extends MediaConverter {

    public MusicConverter(String input, String output) {
        super(input, output);
    }

    public static void main(String[] args) {
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.ogg").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.wav").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.m4a").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.acc").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.flac").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.opus").make();
        new MusicConverter("media/music/guitarsample.mp3", "media/music/guitarsample.webm").make();

        new MusicConverter("media/music/guitarsample.m4a", "media/music/guitarsample.mp3").make();
    }

    @Override
    public void make() {
        String[] command={ffmpegPath(),"-i", input(), output()};
        if (output().contains("m4a")) command=new String[]{ffmpegPath(),"-i", input(), "-c:a", "aac", "-vn", output()};
        run(command);
    }

}
