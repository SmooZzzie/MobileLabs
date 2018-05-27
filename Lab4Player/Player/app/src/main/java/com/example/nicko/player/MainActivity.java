package com.example.nicko.shchepetsplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.search_video)
    protected void searchVideo(){
        searchMedia("video/*", 123);
    }
    @OnClick(R.id.search_music)
    protected void searchMusic(){
        searchMedia("audio/*", 123);
    }

    private void searchMedia(String s, int requestCodeVideo) {
        Intent pickMedia = new Intent(Intent.ACTION_GET_CONTENT);
        pickMedia.setType(s);
        startActivityForResult(pickMedia, requestCodeVideo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK ){
            Intent intent= new Intent(this, MediaActivity.class);
            String dataString = data.getDataString();
            intent.putExtra("video", dataString);
            startActivity(intent);
        }
    }
}
