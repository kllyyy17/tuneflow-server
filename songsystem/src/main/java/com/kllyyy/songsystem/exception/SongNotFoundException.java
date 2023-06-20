package com.kllyyy.songsystem.exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Long id){
        super("Could not found the song with id "+ id);
    }
}
