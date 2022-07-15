package com.jmedia.merger;

import com.jmedia.converter.MediaConverter;

import java.util.ArrayList;
import java.util.List;

public class VideoMerger extends MediaConverter {
    public VideoMerger(final String input, final String output) {
        super(input, output);
    }

    @Override
    public void make() {

        final StringBuilder mediaString = new StringBuilder();

        final String [] command = {ffmpegPath(), "-f", "concat", "-safe", "0", "-i", input(), "-c", "copy", output()};
        run(command);
    }

    public static void main(String[] args) {
        new VideoMerger("media/video/videos.txt", "media/video/output.mp4").make();
    }
}
