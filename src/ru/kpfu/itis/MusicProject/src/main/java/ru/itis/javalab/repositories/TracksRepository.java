package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;
import ru.itis.javalab.models.UserPlaylist;

import java.util.List;
import java.util.Optional;


public interface TracksRepository extends CrudRepository<UserPlaylist, Long> {
    List<UserPlaylist> findTracksById(Long id);
}
