package com.jmedia.metadata;

import com.jmedia.converter.MediaConverter;

public final class Metadata extends MediaConverter {

    private MetadataLabels metadataLabels = new MetadataLabels();

    public Metadata(final String input, final String output) {
        super(input, output);
    }

    public Metadata title(final String title) {
        metadataLabels.title(title);
        return this;
    }

    @Override
    public void make() {
        final String [] command = {ffmpegPath(), "-i", input(), "-metadata", "title=" + metadataLabels.title(), "-c", "copy", output()};
        run(command);
    }

    public static void main(String[] args) {
        new Metadata("media/music/guitarsample2.mp3", "media/music/output.mp3" )
                .title("somemusic")
                .make();
    }

}
