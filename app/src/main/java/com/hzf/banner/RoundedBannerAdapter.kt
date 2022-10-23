package com.hzf.banner

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter

/**
 * @ClassName: RoundedBannerAdapter
 * @Description: banner 适配器
 * @Author: Nicholas.hzf
 * @Date: 2022/9/27 00:06 Created
 */
class RoundedBannerAdapter(urls: MutableList<Int>) : BannerAdapter<Int, RoundedBannerAdapter.BannerViewHolder>(urls) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent!!.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder?, data: Int?, position: Int, size: Int) {
        data?.let {
            holder?.imageView?.setImageResource(it)
        }
    }

    class BannerViewHolder(var imageView: ImageView) :
        RecyclerView.ViewHolder(imageView)
}