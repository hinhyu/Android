package com.example.taphost

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec

@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        tabSpecSong.setContent(R.id.tabSong)
        tabHost.addTab(tabSpecSong)

        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tabArtist)
        tabHost.addTab(tabSpecArtist)

        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0
    }
}
