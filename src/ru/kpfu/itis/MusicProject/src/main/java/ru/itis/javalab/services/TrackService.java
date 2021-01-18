package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.Track;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TrackService {

    void saveTrack(Map pool);
    List<Track> getAllTracks();
    void addTrack(Track track);

//    List<UserDto> getAllUser(int page, int size);
//    Optional<User> findTracksByEmailAndPassword(String email, String password);
//    Optional<User> findUserByEmail(String email);
//    Optional<User> findUserByPassword(String password);
//    UserDto getUser(Long userId);
}
