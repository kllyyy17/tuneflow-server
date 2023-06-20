package com.kllyyy.songsystem.controller;

import com.kllyyy.songsystem.exception.SongNotFoundException;
import com.kllyyy.songsystem.model.Song;
import com.kllyyy.songsystem.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/song")
    Song newSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    @GetMapping("/songs")
    List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/song/{id}")
    Song getSongById(@PathVariable Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @PutMapping("/song/{id}")
    Song updateSong(@RequestBody Song newSong, @PathVariable Long id) {
        return songRepository.findById(id)
                .map(song -> {
                    song.setTitle(newSong.getTitle());
                    song.setArtist(newSong.getArtist());
                    song.setSource(newSong.getSource());
                    return songRepository.save(song);
                }).orElseThrow(() -> new SongNotFoundException(id));
    }

    @DeleteMapping("/song/{id}")
    String deleteSong(@PathVariable Long id){
        if(!songRepository.existsById(id)){
            throw new SongNotFoundException(id);
        }
        songRepository.deleteById(id);
        return  "Song with id "+id+" has been deleted success.";
    }

}
