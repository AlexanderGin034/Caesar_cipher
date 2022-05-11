package com.example.caesar_cipher.Model;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarCipherFile {
    private Path file;

    public CaesarCipherFile(String file) {
        this.file = Path.of(file);
    }

    public void addFile(String text) throws IOException {
        Files.createFile(file);
        byte[] allBytes = text.getBytes(StandardCharsets.UTF_8);
        Files.write(file, allBytes);
    }
}
