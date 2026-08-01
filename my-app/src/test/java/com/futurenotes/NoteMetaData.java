package com.futurenotes;

import java.time.LocalDateTime;
import java.util.*;

public class NoteMetaData {
    private String title; //required
    private String author; //required
    private LocalDateTime created;
    private LocalDateTime modified;
    private List<String> tags;
    

    public NoteMetaData(String title, String author, LocalDateTime created, LocalDateTime modified, List<String> tags) {
        if (author == null) {
        throw new IllegalArgumentException("Author required"); //IllegalArgumentException is appropriate because per the contract set it my constructor null isn't a valid argument value.
    }

        if (title == null) {
            throw new IllegalArgumentException("Title required");
        }

        if (created == null) {
            throw new IllegalArgumentException("Created date not found");
        }

        if (modified == null) {
            throw new IllegalArgumentException("Modified date not found");
        }



    this.title = title;
    this.author = author;
    this.created = created;
    this.modified = modified;
    this.tags = (tags == null) ? new ArrayList<>() : tags;
    } //end recipe A

   // For creating a brand new note (create command uses this)
    public NoteMetaData(String title, String author, List<String> tags) {
        this(title, author, LocalDateTime.now(), LocalDateTime.now(), tags); //Recipe B. //functionall works as this.id = id etc etc. 
        //Provides defaults for created and modified everytime someone makes a new note. 

    }

    public String getTitle() {
        return this.title;
     }

    public void setTitle(String title) {
         if (title == null) {
            throw new IllegalArgumentException("All notes need a title"); 
        }
            this.title = title;
            this.touch();
        }

    public String getAuthor() {
            return this.author;
        }

     public void setAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("All notes need an author");
        }
            this.author = author;
            this.touch();
        }

    public List<String> getTags() {
            return this.tags;
        }
     public void setTags(List tags) {
        if (tags == null) {
            this.tags = new ArrayList<>();
        } else {
            this.tags = tags;
        }
            
            this.touch();
        }

    public LocalDateTime getCreated() {
        return this.created;
    }

    // public void setCreated(LocalDateTime created) {

    // }

    public LocalDateTime getModified() {
        return this.modified;
    }

    //this is solving a problem I noteiced. Before modified would only change if something in the header changed, but now...
    public void touch() {
       this.touch();
}

    
    }

