package com.example.nicko.shchepetsplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MediaActivity extends AppCompatActivity {
    @BindView(R.id.media)
    protected VideoView mediaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ButterKnife.bind(this);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mediaView);
        mediaView.setMediaController(mediaController);

        String video = getIntent().getStringExtra("video");
        Uri parse = Uri.parse(video);

        mediaView.setVideoURI(parse);
        mediaView.start();
    }
}
