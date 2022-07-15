package com.jmedia.converter.video;

import com.jmedia.converter.MediaConverter;

import java.io.IOException;

public final class VideoResize extends MediaConverter {
    private final String newResolution;

    public VideoResize(final String input, final String output, final String newResolution) {
        super(input, output);
        this.newResolution = newResolution;
    }

    @Override
    public void make() {
        String[] command=new String[]{ffmpegPath(),"-i", input(), "-c:a", "copy", "-s", newResolution, output()};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new VideoResize("media/video/woman1.mp4", "media/video/woman1copy.mp4", "1280x720").make();
    }
}
