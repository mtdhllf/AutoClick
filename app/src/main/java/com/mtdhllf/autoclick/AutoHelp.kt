package com.mtdhllf.autoclick

import android.accessibilityservice.GestureDescription
import android.accessibilityservice.GestureDescription.StrokeDescription
import android.graphics.Path
import android.os.Build
import com.mtdhllf.autoclick.service.AutoService
import kotlin.random.Random


/**
 * author: mtdhllf
 * time  : 2020/05/07 17:15
 * desc  :
 */
object AutoHelp {

    var service: AutoService? = null

    fun redy(): Boolean = service != null

    fun dispatch(x: Int, y: Int) {

        if (service == null) {
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dispatchGestureClick(x, y)
        }

    }

    fun dispatchGestureClick(x: Int, y: Int) {
        service?.let {
            val path = Path()
            path.moveTo(x.toFloat(), y.toFloat())
            val click: Boolean = it.dispatchGesture(
                GestureDescription.Builder()
                    .addStroke(StrokeDescription(path, 0, 100)).build(), null, null
            )
        }
    }

    fun dispatchGestureClick(x: Int, y: Int, count: Int, space: Long) {
        //抖动模拟
        val random = Random(5)
        service?.let {
            val path = Path()
            for (i in 0 until count) {
                path.moveTo(random.nextInt() + x.toFloat(), random.nextInt() + y.toFloat())
            }
            val click: Boolean = it.dispatchGesture(GestureDescription.Builder().addStroke(StrokeDescription(path, 0, space * count)).build(), null, null)
        }
    }


}