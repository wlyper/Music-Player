package cheney.wang.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaylistCardAdapter playlistCardAdapter;
    private List<PlaylistCardModel> playlistCardModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.more_playlist);

        int[] images = {R.drawable.tianjin, R.drawable.jazz, R.drawable.at2021, R.drawable.summer};
        String[] names = {"Tianjin", "Jazz\nHipHop", "2021", "Summer"};

        playlistCardModelList = new ArrayList<>();

        playlistCardModelList.add(new PlaylistCardModel("Favorites",R.drawable.favorites_playlist_background,"532 songs",1));

        for (int i = 0; i < 4; i++) {
            int backgroundImage = images[i];
            String name = names[i];
            playlistCardModelList.add(new PlaylistCardModel(name, backgroundImage,2));
        }
        playlistCardAdapter = new PlaylistCardAdapter(playlistCardModelList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));


        playlistCardAdapter.setGridSpanSizeLookup((gridLayoutManager, viewType, position) -> {
            PlaylistCardModel playlistCardModel = playlistCardModelList.get(position);
            int spanSize = 0;
            switch (playlistCardModel.getType()) {
                case PlaylistCardModel.mainCard:
                    spanSize = 4;
                    break;
                case PlaylistCardModel.morePlaylist:
                    spanSize = 2;
                    break;
            }

            return spanSize;
        });

        recyclerView.addItemDecoration(new SpaceItemDecoration(30));

        recyclerView.setAdapter(playlistCardAdapter);

    }
}

