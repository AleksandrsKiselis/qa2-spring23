package model.weather;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Alerts {
    @JsonProperty("sender_name")
    private java.lang.String senderName;

    private java.lang.String event;
    private long start;
    private long end;
    private java.lang.String description;

    @JsonProperty("tags")
    private List<String> tags;

    public java.lang.String getSenderName() {
        return senderName;
    }

    public void setSenderName(java.lang.String senderName) {
        this.senderName = senderName;
    }

    public java.lang.String getEvent() {
        return event;
    }

    public void setEvent(java.lang.String event) {
        this.event = event;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
