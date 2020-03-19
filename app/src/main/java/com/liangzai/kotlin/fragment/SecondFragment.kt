package com.liangzai.kotlin.fragment

import com.liangzai.kotlin.R

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 */
class SecondFragment : BaseFragment(){

    override fun getLayoutId(): Int {
       return R.layout.fragment_second
    }

    companion object{
        fun getInstance(): SecondFragment? {
            return SecondFragment()
        }
    }
}