package com.example.hwk2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LabelColumnGenerator(val ctx : Context) {

    fun generate() : LinearLayout {
        val layout = LinearLayout(ctx)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layout.layoutParams = layoutParams
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.topMargin = 5
        lbParams.bottomMargin = 5
        lbParams.rightMargin = 5
        var label = TextView(ctx)
        label.text = "Claim Name"
        label.gravity = Gravity.CENTER
        label.setTextColor(Color.BLACK)
        label.setBackgroundColor(Color.WHITE)
        layout.addView(label, lbParams)
        label = TextView(ctx)
        label.text = "Date"
        label.gravity = Gravity.CENTER
        label.setTextColor(Color.BLACK)
        label.setBackgroundColor(Color.WHITE)
        layout.addView(label, lbParams)

        return layout
    }
}