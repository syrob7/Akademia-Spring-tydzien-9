package pl.akademiaspring.week9.sql.controller;

public class FormObject {
    private long saveTime;
    private long readTime;

    public long getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(long saveTime) {
        this.saveTime = saveTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }
}
