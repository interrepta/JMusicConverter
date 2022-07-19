package com.jmedia.filters;

import com.jmedia.converter.MediaConverter;


/**
 * Blend videos with filter.
 *
 * Filter options:
 * - addition
 * - grainmerge
 * - and
 * - average
 * - burn
 * - darken
 * - difference
 * - grainextract
 * - divide
 * - dodge
 * - freeze
 * - exclusion
 * - extremity
 * - glow
 * - hardlight
 * - hardmix
 * - heat
 * - lighten
 * - linearlight
 * - multiply
 * - multiply128
 * - negation
 * - normal
 * - or
 * - overlay
 * - phoenix
 * - pinlight
 * - reflect
 * - screen
 * - softlight
 * - subtract
 * - vividlight
 * - xor
 */
public final class Blend extends MediaConverter {

    public Blend(final String input, final String secondInput, final String output) {
        super(input,secondInput, output);
    }

    @Override
    public void make() {
        final String filterOption = "softlight";
        String[] command=new String[]{ffmpegPath(),"-i", input(),"-i", secondInput(), "-filter_complex", "blend=" + filterOption, output()};
        run(command);

    }

    public static void main(String[] args) {
        new Blend("media/video/woman1.mp4", "media/video/sunset.mp4", "media/video/output.mp4").make();
    }

}
