package com.natura.android.expansionPanel


import android.annotation.SuppressLint
import android.content.Context
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R


@SuppressLint("CustomViewStyleable")
class ExpansionPanel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val panel by lazy { findViewById<ConstraintLayout>(R.id.ds_expansion_panel) }
    private val icon by lazy { findViewById<ImageView>(R.id.ds_expansion_panel_icon) }
    private val content by lazy { findViewById<ConstraintLayout>(R.id.ds_expansion_panel_content) }
    private val subtitle by lazy { findViewById<TextView>(R.id.ds_expansion_panel_subtitle) }

    init {
        View.inflate(context, R.layout.ds_expansion_panel, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_expansion_panel)
        val subtitleText = typedArray.getString(R.styleable.ds_expansion_panel_subtitle)

        typedArray.recycle()

        subtitle.text = subtitleText

        panel.setOnClickListener {
            toggleContent()
        }

        icon.setOnClickListener {
            toggleContent()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        moveChildrenToContentArea()
    }

    private fun toggleContent() {
        if (content.visibility == View.GONE) {
            TransitionManager.beginDelayedTransition(panel, AutoTransition())
            content.visibility = View.VISIBLE
            icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowtop)
            panel.setBackgroundResource(R.drawable.ds_expansion_panel_border_expanded)
        } else {
            TransitionManager.beginDelayedTransition(panel, AutoTransition())
            content.visibility = View.GONE
            icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowbottom)
            panel.setBackgroundResource(R.drawable.ds_expansion_panel_border_collapsed)
        }
    }

    private fun moveChildrenToContentArea() {
        while (haveChildren()) {
            val view = getFirstGivenChild()
            removeView(view)
            content.addView(view)
        }
    }

    private fun haveChildren(): Boolean = getChildAt(1) != null

    private fun getFirstGivenChild(): View? = getChildAt(1)

}