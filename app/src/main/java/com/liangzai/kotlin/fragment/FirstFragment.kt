package com.liangzai.kotlin.fragment

import android.graphics.Paint
import com.liangzai.kotlin.R
import com.socks.library.KLog
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.第一个Fragment
 */
class FirstFragment : BaseFragment(){

    private var page = 1
    private var pageSize = 10

    override fun getLayoutId(): Int {
       return R.layout.fragment_first
    }


    companion object{
        fun getInstance(): FirstFragment? {
            return FirstFragment()
        }
    }

    override fun initData() {
        recommendlist()
    }

    private fun recommendlist() {
       getTestData()

    }

    private fun getTestData() {


    }

    private fun initLayout() {

        initRyLayout(recyclerView)
    }




}