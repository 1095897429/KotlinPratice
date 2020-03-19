package com.liangzai.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liangzai.kotlin.R

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
        setContentView(R.layout.activity_base)
        initView()

        initData()
    }



    //每个具体的加载View
    abstract fun initView()

    //每个具体的加载数据
    abstract fun initData()


}