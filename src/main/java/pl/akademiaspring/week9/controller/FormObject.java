package pl.akademiaspring.week9.controller;

public class FormObject {
    private long saveTime;
    private long readTime;
    private long saveTimeMongoDb;
    private long readTimeMongoDb;

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

    public long getSaveTimeMongoDb() {
        return saveTimeMongoDb;
    }

    public void setSaveTimeMongoDb(long saveTimeMongoDb) {
        this.saveTimeMongoDb = saveTimeMongoDb;
    }

    public long getReadTimeMongoDb() {
        return readTimeMongoDb;
    }

    public void setReadTimeMongoDb(long readTimeMongoDb) {
        this.readTimeMongoDb = readTimeMongoDb;
    }
}
