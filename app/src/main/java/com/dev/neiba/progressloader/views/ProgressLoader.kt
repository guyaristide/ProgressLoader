package com.dev.neiba.progressloader.views

import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.dev.neiba.progressloader.R


class ProgressLoader {

    var ll: LinearLayout
    var pb: ProgressBar
    var imageDraw: ImageView
    var tv: TextView

    constructor(parent: ViewGroup) {

        ll = LinearLayout(parent.context)
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER

        val llParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        ll.layoutParams = llParams
        ll.visibility = View.GONE

        pb = ProgressBar(parent.context)

        //val threeBounce = ThreeBounce()
        //threeBounce.color = parent.resources.getColor(R.color.colorPrimaryDark)
        //pb.indeterminateDrawable = threeBounce
        pb.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        ll.addView(pb)

        imageDraw = ImageView(parent.context)
        val imageParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        imageDraw.layoutParams = imageParams
        ll.addView(imageDraw)

        imageDraw.visibility = View.GONE

        tv = TextView(parent.context)
        val messageParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        messageParams.topMargin = 50
        tv.layoutParams = messageParams
        ll.addView(tv)

        parent.addView(ll, 0)

    }

    fun show(message: String = "Veuillez patienter ...") {

        imageDraw.visibility = View.GONE
        pb.visibility = View.VISIBLE
        tv.text = message
        ll.visibility = View.VISIBLE
    }

    fun setError(message: String = "Vérifiez votre connexion"){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageDraw.setImageDrawable(ll.resources.getDrawable(R.drawable.ic_warning, null))
        }else{
            imageDraw.setImageDrawable(ll.resources.getDrawable(R.drawable.ic_warning))
        }
        imageDraw.visibility = View.VISIBLE
        pb.visibility = View.GONE
        tv.text = message
        ll.visibility = View.VISIBLE
    }


    fun setEmpty(message: String = "Aucune données"){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageDraw.setImageDrawable(ll.resources.getDrawable(R.drawable.ic_empty, null))
        }else{
            imageDraw.setImageDrawable(ll.resources.getDrawable(R.drawable.ic_empty))
        }
        imageDraw.visibility = View.VISIBLE
        pb.visibility = View.GONE
        tv.text = message
        ll.visibility = View.VISIBLE
    }

    fun dismiss() {
        ll.visibility = View.GONE
    }

}

