package com.jmedia.metadata;

public final class MetadataLabels {

    private String title = "";
    private String author = "";
    private String album_artist = "";
    private String album = "";
    private String grouping = "";
    private String composer = "";
    private String year = "";
    private String track = "";
    private String comment = "";
    private String genre = "";
    private String copyright = "";
    private String description = "";
    private String synopsis = "";
    private String show = "";
    private String episode_id = "";
    private String network = "";
    private String lyrics = "";

    public MetadataLabels title(final String title) {
        this.title = title;
        return this;
    }

    public String title() { return title; }

}
