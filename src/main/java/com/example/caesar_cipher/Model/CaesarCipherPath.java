package com.example.caesar_cipher.Model;
import com.example.caesar_cipher.CaesarCipherApplication;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Locale;

public class CaesarCipherPath {
    private Path path;

    public CaesarCipherPath(String path) {
        this.path = Path.of(path);
    }

    public char[] getTextChar() throws IOException {
        String str;
        try (FileChannel fileChannel = FileChannel.open(path)){
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(buffer);
            buffer.flip();
            str = new String(buffer.array(), StandardCharsets.UTF_8).toLowerCase(Locale.ROOT);
        }
        return str.toCharArray();
    }

    public String getTextString() throws IOException {
        String str;
        try (FileChannel fileChannel = FileChannel.open(path)){
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(buffer);
            buffer.flip();
            str = new String(buffer.array(), StandardCharsets.UTF_8);
        }
        return str;
    }

}
