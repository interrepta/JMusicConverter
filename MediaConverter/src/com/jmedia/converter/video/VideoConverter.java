package com.jmedia.converter.video;

import java.io.IOException;

public final class VideoConverter {

    public static void main(String[] args) {
        new VideoConverter().convert("media/video/woman1.mp4", "media/video/woman1.mkv");
        new VideoConverter().convert("media/video/woman1.mp4", "media/video/woman1.avi");
    }

    public void convert(final String input, final String output) {
        final String ffmpegPath = "ffmpeg";

        String[] command=new String[]{ffmpegPath,"-i", input, "-c:v", "h264", "-c:a", "libvorbis", output};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
