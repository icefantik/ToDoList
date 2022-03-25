package com.example.todolist;

// класс для работы с записью
public class Task {
    public int id;
    public String title;
    public String desc;
    public String start;
    public String due;

    public Task(int id, String Title, String Desc, String Start, String Due) {
        this.id = id;
        this.title = Title;
        this.desc = Desc;
        this.start = Start;
        this.due = Due;
    }

    public void setId(int id) { this.id = id; }
    public int getId() {
        return id;
    }

    public void setTitle(String title) { this.title = title; }
    public String getTitle() {
        return title;
    }

    public void setDesc(String desc) { this.desc = desc; }
    public String getDesc() {
        return desc;
    }

    public void setStart(String start) { this.start = start; }
    public String getStart() {
        return start;
    }

    public void setDue(String desc) { this.desc = desc; }
    public String getDue() {
        return due;
    }

    public String getDataTaskStr()
    {
        return id + title + desc + start + due + "\n";
    }
}
