package ru.itis.javalab.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;
import ru.itis.javalab.models.UserPlaylist;

import java.util.*;

public class TracksRepositoryJdbcTemplateImpl implements TracksRepository {

    //language=SQL
    private static final String SQL_SELECT_TRACKS = "select * from users_playlist";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users_playlist order by track_id limit :limit offset :offset;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users_playlist where user_id = :user_id";

    //language=SQL
    private static final String SQL_ADD_TRACK = "insert into users_playlist (user_id, artist_name, track_name) values (:user_id, :artist_name, :track_name)";

    private NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper<UserPlaylist> trackRowMapper = (row, i) -> UserPlaylist.builder()
            .user_playlist_id(row.getLong("user_playlist_id"))
            .user_id(row.getLong("user_id"))
//            .track_id(row.getLong("track_id"))
            .artist_name(row.getString("artist_name"))
            .track_name(row.getString("track_name"))
            .build();

    public TracksRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<UserPlaylist> findAll() {
        return jdbcTemplate.query(SQL_SELECT_TRACKS, trackRowMapper);
    }

    @Override
    public List<UserPlaylist> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return jdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, trackRowMapper);
    }

    @Override
    public void save(UserPlaylist entity) {

    }

    @Override
    public void add(UserPlaylist entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", entity.getUser_id());
//        params.put("track_id", entity.getTrack_id());
        params.put("artist_name", entity.getArtist_name());
        params.put("track_name", entity.getTrack_name());
        jdbcTemplate.update(SQL_ADD_TRACK, params);
    }

    @Override
    public void update(UserPlaylist entity, Long aLong) {

    }

    @Override
    public void delete(UserPlaylist entity) {

    }

    @Override
    public Optional<UserPlaylist> findById(Long aLong) {
        UserPlaylist userPlaylist;
        try {
            userPlaylist = (UserPlaylist) jdbcTemplate.query(SQL_SELECT_BY_ID, Collections.singletonMap("user_id", aLong), trackRowMapper);
        } catch (EmptyResultDataAccessException e) {
            userPlaylist = null;
        }

        return Optional.ofNullable(userPlaylist);
    }

    @Override
    public List<UserPlaylist> findTracksById(Long id) {
        return jdbcTemplate.query(SQL_SELECT_BY_ID, Collections.singletonMap("user_id", id),trackRowMapper);
    }
}
