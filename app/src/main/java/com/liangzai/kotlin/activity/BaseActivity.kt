package com.liangzai.kotlin.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.liangzai.kotlin.R
import kotlinx.android.synthetic.main.activity_base.*

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.抽象初始化布局
 */
 abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
        setContentView(R.layout.activity_base)
        fl_content.addView(layoutInflater.inflate(getLayoutId(), null))

        initData()
    }


    abstract fun getLayoutId(): Int


    //每个具体的加载数据
    abstract fun initData()


    //是否设置状态栏字体颜色light
    open fun setStatusTopTextLightColor(): Boolean {
        return true
    }

    private fun getStatusTopColor(): Int {
        return Color.TRANSPARENT
    }

    //设置状态栏
    private fun setStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            if(setStatusTopTextLightColor()){
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            }
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = getStatusTopColor()
        }
    }


}