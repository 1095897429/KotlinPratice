package com.liangzai.kotlin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.liangzai.kotlin.R
import com.liangzai.kotlin.utils.ToolUtils
import com.liangzai.kotlin.widget.webview.JSBridge
import kotlinx.android.synthetic.main.activity_webview.*

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 */
class AAA :AppCompatActivity() {

//    val url = "https://www.12306.cn/"
    val url = "file:///android_asset/web.html"


    @SuppressLint("JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        ToolUtils.initWebViewSetting(webview)
        webview.webViewClient = WebViewClient()
        webview.webChromeClient = WebChromeClient()

        webview.addJavascriptInterface(JSBridge(this), "NgbjAndroid")
        webview.loadUrl(url)
    }

}