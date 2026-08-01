package com.futurenotes;

import java.util.*;
import java.io.File;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.yaml.snakeyaml.Yaml;

public class NoteParser {

    
    public Note stringToNote(String rawContent, String id) {
        //Segments header
        int firstDelim = rawContent.indexOf("---");
        int lastDelim = rawContent.indexOf("---", firstDelim + 3);

        String yamlHeader = rawContent.substring(firstDelim + 3, lastDelim);

        //Segments body
        String body = rawContent.substring(lastDelim + 3);
        System.out.println(body.replace("\n", "[NL]")); // review this part later.

        //Using SnakeYAML to convert string header into a Map of key value pairs
        Yaml yaml = new Yaml();
        Map<String, Object> yamlHeaderMap = yaml.load(yamlHeader);

        String title = (String) yamlHeaderMap.get("title");
        String author = (String) yamlHeaderMap.get("author");

        String createdStr = (String) yamlHeaderMap.get("created");
        LocalDateTime created = LocalDateTime.parse(createdStr, DateTimeFormatter.ISO_DATE_TIME);

        String modifiedStr = (String) yamlHeaderMap.get("modified");
        LocalDateTime modified = LocalDateTime.parse(modifiedStr, DateTimeFormatter.ISO_DATE_TIME);

        List<String> tags = (List<String>) yamlHeaderMap.get("tags");

        //Constructing the meta data from the parsed header
        NoteMetaData metaData = new NoteMetaData(title, author, created, modified, tags);
        
        Note note = new Note(metaData, id, body);
        return note;

     }

    public String noteToString(Note note) {

        Map<String, Object> eYamlHeader = new LinkedHashMap<String, Object>(); //LinkedHashMap preservers the order you insert the keys in.
        
        eYamlHeader.put("title", note.getMetaData().getTitle());
        eYamlHeader.put("author", note.getMetaData().getAuthor());
        // eYamlHeader.put("created", note.getMetaData().getCreated());
        // eYamlHeader.put("modified", note.getMetaData().getModified());
    
        //Had to do it this way cause SnakYAML can't nativlely load LocalDateTime type. 
        eYamlHeader.put("created", note.getMetaData().getCreated().format(DateTimeFormatter.ISO_DATE_TIME));
        eYamlHeader.put("modified", note.getMetaData().getModified().format(DateTimeFormatter.ISO_DATE_TIME));
        eYamlHeader.put("tags", note.getMetaData().getTags());

        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(eYamlHeader, writer);

        String expectedHeader = "---\n" + writer.toString() + "---";

        String expectedNote = expectedHeader + note.getContent();
        return expectedNote;
        
     }   
 }
