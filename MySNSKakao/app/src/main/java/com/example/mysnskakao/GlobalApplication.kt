package com.example.mysnskakao

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //카카오 sdk 초기화
        KakaoSdk.init(this,"80654ab4d030a876f0c4beef737cb164")
    }
}