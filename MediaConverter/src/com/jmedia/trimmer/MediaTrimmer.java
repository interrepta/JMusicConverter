package com.jmedia.trimmer;

import com.jmedia.MediaConverter;

import javax.print.attribute.standard.Media;

public final class MediaTrimmer extends MediaConverter {
    private final String start;
    private final String end;

    public MediaTrimmer(final String input, final String output, final String start, final String end) {
        super(input, output);
        this.start = start;
        this.end = end;
    }

    @Override
    public void make() {
        String[] command={ffmpegPath(),"-i", input(), "-ss", start, "-to", end, output(), "-c:v", "copy", "-c:a", "copy" };
        run(command);
    }

    public static void main(String[] args) {
        new MediaTrimmer("media/video/woman1.mp4", "media/video/woman1copy.mp4", "00:00:00", "00:00:05").make();
    }
}
