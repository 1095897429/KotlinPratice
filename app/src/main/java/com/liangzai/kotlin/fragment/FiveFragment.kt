package com.liangzai.kotlin.fragment

import android.view.View
import com.liangzai.kotlin.R


/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 */
class FiveFragment : BaseFragment(){


    override fun getLayoutId(): Int {
       return R.layout.fragment_five
    }

    override fun initData() {
        //获取到包管理类实例
    }

    companion object{
        fun getInstance():FiveFragment{
            return FiveFragment()
        }
    }


    /** 点击事件 */
    fun click(v: View?){
        when(v?.id){
        }
    }


}