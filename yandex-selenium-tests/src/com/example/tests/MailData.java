package com.example.tests;

/**
 * Created by yulia on 1/28/15.
 */
public class MailData implements Comparable<MailData> {
    private String date;
    private String topic;
    private String content;
    private String recipient;

    @Override
    //generated to see in logs
    public String toString() {
        return "MailData{" +
                "topic='" + topic + '\'' +
                '}';
    }
//generated to compare objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailData mailData = (MailData) o;

        if (topic != null ? !topic.equals(mailData.topic) : mailData.topic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return topic != null ? topic.hashCode() : 0;
    }

    @Override
    public int compareTo(MailData other) {
        return this.topic.compareTo(other.topic);
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getRecipient() {
        return recipient;
    }

    public MailData withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MailData withContent(String content) {
        this.content = content;
        return this;
    }

    public MailData withRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }
}
