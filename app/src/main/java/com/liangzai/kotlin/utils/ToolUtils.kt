package com.liangzai.kotlin.utils

import android.os.Build
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.多处用到的类
 */
class ToolUtils {

    // 包裹范围内 属于静态方法
    companion object{


        //① 统一设置setting
        fun initWebViewSetting(webview: WebView) {
            val webSettings = webview.settings ?: return
            //开启 js交互功能
            webSettings.javaScriptEnabled = true
            webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
            webSettings.defaultTextEncodingName = "utf-8"
            webSettings.allowContentAccess = true
            webSettings.allowFileAccess = true
            //不因手机修改字体变化
            webSettings.textZoom = 100
            webSettings.javaScriptCanOpenWindowsAutomatically = true
            //开启 database storage API 功能
            webSettings.databaseEnabled = true
            //开启DomStorage缓存
            webSettings.domStorageEnabled = true
            //开启 H5缓存 功能
            webSettings.setAppCacheEnabled(true)
            webSettings.setGeolocationEnabled(true)
            //兼容所有的手机界面,使网页始终按照webview宽度设定(如果设置为true,此项功能为失效,导致部分手机网页如淘宝显示为PC样式,但能完整显示PC网页)
            webSettings.useWideViewPort = true
            webSettings.loadWithOverviewMode = true
            //加快内容加载速度
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
            //阻止图片网络加载
            webSettings.blockNetworkImage = false
            webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            //视频播放需要
            webSettings.pluginState = WebSettings.PluginState.ON
            //在安卓5.0之后，默认不允许加载http与https混合内容，需要设置webview允许其加载混合网络协议内容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
            if (Build.VERSION.SDK_INT >= 19) {
                webview.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            } else {
                webview.setLayerType(View.LAYER_TYPE_NONE, null)
            }
            //获取手势焦点
            webview.requestFocusFromTouch()
        }
    }




}