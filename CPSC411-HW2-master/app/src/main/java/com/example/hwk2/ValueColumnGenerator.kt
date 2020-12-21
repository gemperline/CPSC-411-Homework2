package com.example.hwk2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layout = LinearLayout(ctx)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layout.layoutParams = layoutParams
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.WHITE)
        val viewVals = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        viewVals.topMargin = 5
        viewVals.bottomMargin = 5
        var input = EditText(ctx)
        input.id = (R.id.claim_title)
        input.setHint("Enter the name")
        input.setBackgroundColor(Color.LTGRAY)
        layout.addView(input, viewVals)
        input = EditText(ctx)
        input.id = (R.id.claim_date)
        input.setHint("Format: YYYY-MM-DD")
        input.setBackgroundColor(Color.LTGRAY)
        layout.addView(input, viewVals)

        return layout
    }
}