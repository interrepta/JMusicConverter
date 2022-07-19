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
 * - all_expr='A*(if(gte(T,10),1,T/10))+B*(1-(if(gte(T,10),1,T/10)))'
 * - all_expr='A*(X/W)+B*(1-X/W)'
 * - all_expr='if(eq(mod(X,2),mod(Y,2)),A,B)'
 * - all_expr='if(gte(N*SW+X,W),A,B)'
 * - all_expr='if(gte(Y-N*SH,0),A,B)'
 * - all_expr='if(gt(X,Y*(W/H)),A,B)'
 */
public final class Blend extends MediaConverter {

    public Blend(final String input, final String secondInput, final String output) {
        super(input,secondInput, output);
    }

    @Override
    public void make() {
        final String filterOption = "all_expr='if(gt(X,Y*(W/H)),A,B)'";
        String[] command=new String[]{ffmpegPath(),"-i", input(),"-i", secondInput(), "-filter_complex", "blend=" + filterOption, output()};
        run(command);

    }

    public static void main(String[] args) {
        new Blend("media/video/woman1.mp4", "media/video/sunset.mp4", "media/video/output.mp4").make();
    }

}
