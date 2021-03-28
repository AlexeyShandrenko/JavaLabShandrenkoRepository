package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.models.UserPlaylist;
import ru.itis.javalab.repositories.TracksRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TracksRepository tracksRepository;

    public TrackServiceImpl(TracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    @Override
    public void saveTrack(Map pool) {

    }

    @Override
    public List<UserPlaylist> getAllTracks() {
        return tracksRepository.findAll();
    }

    @Override
    public void addTrack(Map pool) {
        UserPlaylist userPlaylist = UserPlaylist.builder()
                .user_id((Long) pool.get("user_id"))
//                .track_id((Long) pool.get("track_id"))
                .artist_name((String) pool.get("artist_name"))
                .track_name((String) pool.get("track_name"))
                .build();
        tracksRepository.add(userPlaylist);
    }

    @Override
    public List<UserPlaylist> findById(Long id) {
        return tracksRepository.findTracksById(id);
    }


}
