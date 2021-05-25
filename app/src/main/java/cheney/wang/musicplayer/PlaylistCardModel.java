package cheney.wang.musicplayer;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class PlaylistCardModel implements MultiItemEntity {
    public static final int mainCard=1;
    public static final int morePlaylist=2;

    private String playlistName;
    private int backgroundImage;
    private String songsNumber;
    private int type;

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(int backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getSongsNumber() {
        return songsNumber;
    }

    public void setSongsNumber(String songsNumber) {
        this.songsNumber = songsNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PlaylistCardModel(String playlistName, int backgroundImage, int type) {
        this.playlistName = playlistName;
        this.backgroundImage = backgroundImage;
        this.type = type;
    }

    public PlaylistCardModel(String playlistName, int backgroundImage, String songsNumber, int type) {
        this.playlistName = playlistName;
        this.backgroundImage = backgroundImage;
        this.songsNumber = songsNumber;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
