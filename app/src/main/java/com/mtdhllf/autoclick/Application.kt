package com.mtdhllf.autoclick

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * author: mtdhllf
 * time  : 2020/05/07 11:56
 * desc  :
 */
class Application:Application(){

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }

}