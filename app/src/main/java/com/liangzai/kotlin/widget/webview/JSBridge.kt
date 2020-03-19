package com.liangzai.kotlin.widget.webview

import android.annotation.SuppressLint
import android.app.Activity
import android.webkit.JavascriptInterface
import android.widget.Toast
import com.liangzai.kotlin.bean.BaseBean
import com.socks.library.KLog

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:Js交互对象
 */

class JSBridge(act:Activity) : BaseBean(){

    var act = act

    @JavascriptInterface
    fun toastMessage(){
        KLog.d("tag","1111" + "")
        Toast.makeText(act, "通过Natvie传递的Toast:" , Toast.LENGTH_SHORT).show();
    }

}