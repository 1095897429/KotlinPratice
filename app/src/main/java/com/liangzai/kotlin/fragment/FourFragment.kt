package com.liangzai.kotlin.fragment

import com.liangzai.kotlin.R

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 */
class FourFragment : BaseFragment(){

    override fun getLayoutId(): Int {
       return R.layout.fragment_four
    }

    companion object{
        fun getInstance():FourFragment{
            return FourFragment()
        }
    }
}