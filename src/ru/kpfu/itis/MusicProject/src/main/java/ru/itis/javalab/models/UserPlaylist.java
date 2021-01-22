package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPlaylist {
    private Long user_playlist_id;
    private Long user_id;
//    private Long track_id;
    private String artist_name;
    private String track_name;
}
