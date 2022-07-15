package com.jmedia.converter.video;

import com.jmedia.converter.MediaConverter;

import java.io.IOException;

public final class VideoConverter extends MediaConverter {

    public static void main(String[] args) {
        new VideoConverter("media/video/woman1.mp4", "media/video/woman1.mkv").make();
        new VideoConverter("media/video/woman1.mp4", "media/video/woman1.avi").make();
    }

    public VideoConverter(final String input, final String output) {
        super(input, output);
    }

    @Override
    public void make() {

        String[] command=new String[]{ffmpegPath(),"-i", input(), "-c:v", "h264", "-c:a", "libvorbis", output()};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
