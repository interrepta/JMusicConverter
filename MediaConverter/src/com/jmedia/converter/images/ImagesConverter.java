package com.jmedia.converter.images;

import com.jmedia.converter.MediaConverter;

import java.io.IOException;

public final class ImagesConverter extends MediaConverter {

    public static void main(String[] args) {
        new ImagesConverter("media/images/wheat.jpg", "media/images/wheat.png").make();
        new ImagesConverter("media/images/wheat.jpg", "media/images/wheat.webp").make();
        new ImagesConverter("media/images/wheat.jpg", "media/images/wheat.gif").make();
        new ImagesConverter("media/images/wheat.jpg", "media/images/wheat.bpm").make();
        new ImagesConverter("media/images/wheat.jpg", "media/images/wheat.tif").make();
    }

    public ImagesConverter(final String input, final String output) {
        super(input, output);
    }

    @Override
    public void make() {
        String[] command={ffmpegPath(),"-i", input(), output()};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
