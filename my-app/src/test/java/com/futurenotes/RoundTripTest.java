package com.futurenotes;

import java.time.LocalDateTime;
import java.util.*;

public class RoundTripTest {

    public static void main(String[] args) {

        // --- Step 1: build an original Note by hand, values we control ---
        LocalDateTime originalCreated = LocalDateTime.of(2025, 5, 18, 9, 15, 0);
        LocalDateTime originalModified = LocalDateTime.of(2025, 5, 20, 14, 30, 0);
        List<String> originalTags = new ArrayList<>(List.of("coursework", "algorithms"));

        NoteMetaData originalMeta = new NoteMetaData(
                "Data Structures Overview",
                "Student001",
                originalCreated,
                originalModified,
                originalTags
        );

        String originalId = UUID.randomUUID().toString();
        String originalContent = "# Data Structures Overview\n\n## Arrays\n- Contiguous memory allocation\n- O(1) access time";

        Note originalNote = new Note(originalMeta, originalId, originalContent);

        // --- Step 2: serialize it with noteToString ---
        NoteParser parser = new NoteParser();
        String serialized = parser.noteToString(originalNote);

        System.out.println("===== SERIALIZED OUTPUT (raw) =====");
        System.out.println(serialized);
        System.out.println("===== SERIALIZED OUTPUT (newlines visible) =====");
        System.out.println(serialized.replace("\n", "[NL]\n"));
        System.out.println();

        // --- Step 3: parse it back with stringToNote ---
        Note roundTrippedNote = parser.stringToNote(serialized, originalId);

        // --- Step 4: compare field by field, print PASS/FAIL for each ---
        System.out.println("===== FIELD-BY-FIELD COMPARISON =====");

        check("id", originalNote.getId(), roundTrippedNote.getId());
        check("title", originalMeta.getTitle(), roundTrippedNote.getMetaData().getTitle());
        check("author", originalMeta.getAuthor(), roundTrippedNote.getMetaData().getAuthor());
        check("created", originalMeta.getCreated(), roundTrippedNote.getMetaData().getCreated());
        check("modified", originalMeta.getModified(), roundTrippedNote.getMetaData().getModified());
        check("tags", originalMeta.getTags(), roundTrippedNote.getMetaData().getTags());
        check("content", originalNote.getContent(), roundTrippedNote.getContent());

        System.out.println();
        System.out.println("If any FAIL lines appear above, that field did not survive the round trip.");
        System.out.println("Compare the two printed values directly above each FAIL to see exactly how they differ.");
    }

    // Small helper: compares two values, prints PASS or FAIL with both values shown.
    // Not JUnit -- just visible proof, same spirit as the >...< marker trick.
    private static void check(String fieldName, Object expected, Object actual) {
        boolean same = Objects.equals(expected, actual);
        System.out.println((same ? "PASS" : "FAIL") + " -- " + fieldName);
        if (!same) {
            System.out.println("    expected: [" + expected + "]");
            System.out.println("    actual:   [" + actual + "]");
        }
    }
}