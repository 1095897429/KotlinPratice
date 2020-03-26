package com.liangzai.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socks.library.KLog

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.抽象初始化布局
 */
abstract class BaseFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        KLog.e("tag", this.javaClass.getSimpleName() + " onCreateView")
        val view: View = inflater.inflate(getLayoutId(), null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    open fun initData(){}


    abstract fun getLayoutId():Int


    open fun initRyLayout(recyclerView : RecyclerView){
        var mLinearLayoutManager = LinearLayoutManager(activity)
        //设置默认垂直布局
        //设置默认垂直布局
        mLinearLayoutManager.setOrientation(RecyclerView.VERTICAL)
        //设置布局管理器
        //设置布局管理器
        recyclerView.setLayoutManager(mLinearLayoutManager)
    }


}