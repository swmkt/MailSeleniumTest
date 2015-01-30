package com.example.tests;

/**
 * Created by yulia on 1/28/15.
 */
public class MailData implements Comparable<MailData> {
    public String date;
    public String text;
    public String content;

    public MailData(String text, String content) {
        this.date = null;
        this.text = text;
        this.content = content;
    }

    @Override
    //generated to see in logs
    public String toString() {
        return "MailData{" +
                "text='" + text + '\'' +
                '}';
    }
//generated to compare objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailData mailData = (MailData) o;

        if (text != null ? !text.equals(mailData.text) : mailData.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public int compareTo(MailData other) {
        return this.text.compareTo(other.text);
    }
}
