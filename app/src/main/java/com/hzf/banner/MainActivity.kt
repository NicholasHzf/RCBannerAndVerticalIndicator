package com.hzf.banner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.youth.banner.Banner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 要轮播的图片地址
        val urls = mutableListOf(
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.img3
        )
        // 垂直指示器
        val indicator = findViewById<CircleVerticalIndicator>(R.id.indicator)
        // Banner 基本设置
        findViewById<Banner<Int,RoundedBannerAdapter>>(R.id.banner).apply {
            setAdapter(RoundedBannerAdapter(urls)) // 设置图片的适配器
            addBannerLifecycleObserver(this@MainActivity) // 添加生命周期监听
            setIndicator(indicator,false) // 设置指示器，false 表示指示器不放在 Banner 内
            setLoopTime(1500) // 轮播间隔时间
            setIndicatorSpace(20) // 指示器圆圈之间的间隔
            setIndicatorNormalWidth(12) // 未选中状态下，指示器圆圈的宽大小
            setIndicatorSelectedWidth(12) // 选中状态下，指示器圆圈的宽大小
            setIndicatorNormalColor(ContextCompat.getColor(this@MainActivity, R.color.black)) // 未选中状态下，指示器圆圈的颜色
            setIndicatorSelectedColor(ContextCompat.getColor(this@MainActivity, R.color.red)) // 选中状态下，指示器圆圈的颜色
        }
    }

}