package com.reactnativenavigation.utils

import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

val hitRect = Rect()

fun MotionEvent.coordinatesInsideView(view: View?): Boolean {
    view ?: return false
    
    val viewGroup = (view as ViewGroup).getChildAt(0) as ViewGroup
    return if (viewGroup.childCount > 0) {
        val content = viewGroup.getChildAt(0)
        content.getHitRect(hitRect)
        hitRect.contains(x.toInt(), y.toInt())
    } else {
        false
    }
}
