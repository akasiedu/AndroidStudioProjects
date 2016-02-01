package com.example.kwame.noteapp;

import com.parse.ParseObject;

/**
 * Created by kwame on 11/13/15.
 */
public class Note {
    private String id;
    private String title;
    private String content;

    Note(String noteId, String noteTitle, String noteContent){
       id = noteId;
        title = noteTitle;
        content = noteContent;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }


}


