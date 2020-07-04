package com.aib.lib.base.image

import android.widget.ImageView
import com.aib.lib.base.net.NetConstants
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GlideManager {
    companion object {
        val getInstance: GlideManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            GlideManager()
        }
    }

    /**
     * 从网络加载图片，并用于普通显示
     */
    fun loadCommonNetPath(view: ImageView, url: String) {
        Glide.with(view.context)
                .load(NetConstants.BASE_URL + url).into(view)
    }
}