package com.kllyyy.songsystem.repository;

import com.kllyyy.songsystem.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
