package com.media.server.repositories;

import com.media.server.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface SongRepository extends JpaRepository<Song, Long>, QueryByExampleExecutor<Song> {
}
