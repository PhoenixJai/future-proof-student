package com.futurenotes;

import java.time.LocalDateTime;
import java.util.*;

public class Note {


    private NoteMetaData metaData;
    private String content;
    private String id;

   // Pass id="" to generate a new UUID (new note). Pass a real UUID string to load an existing note.
    public Note(NoteMetaData metaData, String id, String content) {

        if (metaData == null) {
            throw new NullPointerException("All notes need a YAML header.");
        }

        this.metaData = metaData;

        if (id == null) {
            throw new NullPointerException("All notes need an ID.");
        }


        if (id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        } else {
            try {
                UUID.fromString(id);  // throws if invalid, don't need the result, just the validation
                this.id = id;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("id is not a valid UUID: " + id);
            }
        }

        // if (id.isEmpty()) {
        //     UUID uuid = UUID.randomUUID();
        //     this.id = uuid.toString();
        // } else if (!id.isEmpty() && UUID.fromString(id).equals(false)) {
        //     UUID uuid = UUID.randomUUID();
        //     this.id = uuid.toString();
        // } else if (!id.isEmpty() && UUID.fromString(id).equals(true)) {
        //     this.id = id;
        // } else {
        //     return null; //don't know what to put here
        // }

       
        
        this.content = (content == null) ? "" : content;
}




    //GETTERS
        public NoteMetaData getMetaData() {
            return this.metaData;
        }
      
        public String getId() {
            return this.id;
        }

        public String getContent() {
            return this.content;
        }
            

    //SETTERS
   
       

        public void setContent(String content) {
            this.content = (content == null) ? "" : content; // this.content = check if content equals null if yes then content = "", else this.content = content.
            this.metaData.touch();
        }

       
    
}
