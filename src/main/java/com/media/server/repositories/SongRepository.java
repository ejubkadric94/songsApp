package com.media.server.repositories;

import com.media.server.models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SongRepository extends CrudRepository<Song, UUID> {

}
