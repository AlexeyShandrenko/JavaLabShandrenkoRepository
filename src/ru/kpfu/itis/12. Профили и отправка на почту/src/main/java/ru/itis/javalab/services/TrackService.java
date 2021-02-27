package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.models.UserPlaylist;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TrackService {

    void saveTrack(Map pool);
    List<UserPlaylist> getAllTracks();
    void addTrack(Map pool);
    List<UserPlaylist> findById(Long id);

//    List<UserDto> getAllUser(int page, int size);
//    Optional<User> findTracksByEmailAndPassword(String email, String password);
//    Optional<User> findUserByEmail(String email);
//    Optional<User> findUserByPassword(String password);
//    UserDto getUser(Long userId);
}
