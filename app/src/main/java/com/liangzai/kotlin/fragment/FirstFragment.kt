package com.liangzai.kotlin.fragment

import com.liangzai.kotlin.R

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.第一个Fragment
 */
class FirstFragment : BaseFragment(){

    override fun getLayoutId(): Int {
       return R.layout.fragment_first
    }


    companion object{
        fun getInstance(): FirstFragment? {
            return FirstFragment()
        }
    }


}