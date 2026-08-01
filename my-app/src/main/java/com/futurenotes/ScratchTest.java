package com.futurenotes;

public class ScratchTest {
    public static void main(String[] args) {
        String rawContent = "---\n" + //
                        "title: Data Structures Overview\n" + //
                        "created: 2025-05-18T09:15:00Z\n" + //
                        "modified: 2025-05-20T14:30:00Z\n" + //
                        "tags: [coursework, computer science, algorithms]\n" + //
                        "author: Student001\n" + //
                        "status: complete\n" + //
                        "priority: 2\n" + //
                        "---\n" + //
                        "\n" + //
                        "# Data Structures Overview\n" + //
                        "\n" + //
                        "## Arrays\n" + //
                        "- Contiguous memory allocation\n" + //
                        "- O(1) access time\n" + //
                        "- Fixed size in many languages\n" + //
                        "- Dynamic arrays (e.g., ArrayList in Java, List in C#) can resize automatically\n" + //
                        "\n" + //
                        "## Linked Lists\n" + //
                        "- Non-contiguous memory allocation\n" + //
                        "- O(n) access time\n" + //
                        "- O(1) insertion/deletion at known positions\n" + //
                        "- Types: Singly linked, Doubly linked, Circular\n" + //
                        "\n" + //
                        "## Stacks\n" + //
                        "- LIFO (Last In, First Out) principle\n" + //
                        "- Operations: push, pop, peek\n" + //
                        "- Applications: Function calls, Undo mechanisms, Expression evaluation\n" + //
                        "\n" + //
                        "## Queues\n" + //
                        "- FIFO (First In, First Out) principle\n" + //
                        "- Operations: enqueue, dequeue, peek\n" + //
                        "- Applications: Job scheduling, Print spooling, Message queues\n" + //
                        "\n" + //
                        "## Hash Tables\n" + //
                        "- Key-value pairs\n" + //
                        "- O(1) average case for insertion, deletion, lookup\n" + //
                        "- Collision resolution: Chaining, Open addressing\n" + //
                        "- Load factor affects performance\n" + //
                        "\n" + //
                        "## Trees\n" + //
                        "- Hierarchical structure\n" + //
                        "- Binary trees, AVL trees, Red-Black trees, B-trees\n" + //
                        "- Tree traversals: Inorder, Preorder, Postorder, Level order\n" + //
                        "\n" + //
                        "### Study Questions\n" + //
                        "1. Compare and contrast arrays vs. linked lists\n" + //
                        "2. When would you choose a hash table over a binary search tree?\n" + //
                        "3. Implement a stack using arrays and linked lists\n" + //
                        "\n" + //
                        "**Note to self**: Prepare implementation examples for midterm project";

        int firstDelim = rawContent.indexOf("---");
        int lastDelim = rawContent.indexOf("---", firstDelim + 3);

        String yamlHeader = rawContent.substring(firstDelim + 3, lastDelim);
        String body = rawContent.substring(lastDelim + 3);

        System.out.println("HEADER START>" + yamlHeader + "<HEADER END");
        System.out.println("BODY START>" + body + "<BODY END");
    }
}