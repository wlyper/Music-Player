package cheney.wang.musicplayer;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaylistCardAdapter extends BaseMultiItemQuickAdapter<PlaylistCardModel, BaseViewHolder> {

    public PlaylistCardAdapter(@Nullable List<PlaylistCardModel> data) {
        super(data);
        addItemType(PlaylistCardModel.mainCard, R.layout.item_main_card);
        addItemType(PlaylistCardModel.morePlaylist, R.layout.item_playlist);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PlaylistCardModel playlistCardModel) {
        switch (baseViewHolder.getItemViewType()) {
            case PlaylistCardModel.mainCard:
                Glide.with(MyApplication.getContext()).load(playlistCardModel.getBackgroundImage()).into((ImageView) baseViewHolder.getView(R.id.main_card_background));
                baseViewHolder.setText(R.id.favorites_playlist_name, playlistCardModel.getPlaylistName())
                        .setText(R.id.favorites_playlist_songs_number, playlistCardModel.getSongsNumber());
                break;
            case PlaylistCardModel.morePlaylist:
                Glide.with(MyApplication.getContext()).load(playlistCardModel.getBackgroundImage()).into((ImageView) baseViewHolder.getView(R.id.card_background));
                baseViewHolder.setText(R.id.card_name, playlistCardModel.getPlaylistName());
                break;
        }
    }
}
