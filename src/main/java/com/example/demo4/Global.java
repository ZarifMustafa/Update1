package com.example.demo4;

public class Global
{
    public static Global global;

    int memoryIndex;
    int score;
    public Global()
    {
        this.memoryIndex = 0;
        this.score=0;
    }

    public static synchronized Global getInstance()
    {
        if(global==null) global = new Global();
        return global;
    }
    public static synchronized Global getScore()
    {
        if(global==null) global = new Global();
        return global;
    }
    public int getMemoryIndex() {
        return memoryIndex;
    }

    public void setMemoryIndex(int memoryIndex) {
        this.memoryIndex = memoryIndex;
    }
}
