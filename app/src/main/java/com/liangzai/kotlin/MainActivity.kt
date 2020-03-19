package com.liangzai.kotlin

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.*
import com.socks.library.KLog
import java.io.File
import java.io.IOException

import kotlinx.android.synthetic.main. activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x : HashMap<String,String>
        getStartInfo()

        hello.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

            }

        })

    }




     fun getStartInfo() {
        KLog.d("tag", "应用的Id  " + AppUtils.getAppUid())
        KLog.d("tag", "应用的签名MD5  " + AppUtils.getAppSignatureMD5())
        KLog.d("tag", "应用的签名SHA256  " + AppUtils.getAppSignatureSHA256())
        KLog.d("tag", "状态栏的高度  " + BarUtils.getStatusBarHeight())
        KLog.d("tag", "内部缓存路径  " + Utils.getApp().cacheDir.absolutePath)
        val string = "中文"
        KLog.d("tag", "字节是  " + string.toByteArray())
        ConvertUtils.bytes2Bits(string.toByteArray())
        KLog.d("tag", "当前设备是否root过，通过是否有/system/su文件判断  " + DeviceUtils.isDeviceRooted())
        KLog.d("tag", "应用ADB是否可用 [设置中关闭调试即可] " + DeviceUtils.isAdbEnabled())
        KLog.d("tag", "设备的Android系统版本  " + DeviceUtils.getSDKVersionName())
        KLog.d("tag", "设备的Android系统API  " + DeviceUtils.getSDKVersionCode())
        KLog.d("tag", "设备当前的AndroidID [此值改变情况有：恢复出厂设置/刷机/root等] " + DeviceUtils.getAndroidID())
        KLog.d("tag", "应用的MAC地址  " + DeviceUtils.getMacAddress())
        KLog.d("tag", "手机的厂商  " + DeviceUtils.getManufacturer())
        KLog.d("tag", "手机的型号  " + DeviceUtils.getModel())
        KLog.d("tag", "是否是平板  " + DeviceUtils.isTablet())
        KLog.d("tag", "是否是模拟器【他的方法不能用，主要是有个unkwon,去掉即可】  " + DeviceUtils.isEmulator())
        val url = "http://www.baidu.com?wd="
        KLog.d("tag", "编码url [You don't encode the entire URL]" + EncodeUtils.urlEncode("中文"))
        KLog.d(
            "tag",
            "解码url [NoWrap 略去所有的换行符  NoPadding 略去编码字符串最后的“=”]" + EncodeUtils.urlDecode(EncodeUtils.urlEncode("中文"))
        )
        val s = "ABC"
        KLog.d("tag", "截取的字符串是【利用fastSubstring】 " + s.substring(1))
        KLog.d("tag", "网络是否连接 " + NetworkUtils.isConnected())
        NetworkUtils.isAvailableAsync { data: Boolean ->
            KLog.d(
                "tag",
                "网络是否可用 $data"
            )
        }
        KLog.d("tag", "移动数据是否打开 " + NetworkUtils.getMobileDataEnabled())
        KLog.d("tag", "wifi数据是否(可用)打开 " + NetworkUtils.getWifiEnabled())
        KLog.d("tag", "wifi数据是否链接 " + NetworkUtils.isWifiConnected())
        KLog.d("tag", "使用的是否是 移动数据 " + NetworkUtils.isMobileData())
        KLog.d("tag", "移动数据是否打开 " + NetworkUtils.getMobileDataEnabled())
        KLog.d("tag", "移动数据的运营商 " + NetworkUtils.getNetworkOperatorName())
        KLog.d("tag", "网络的类型 " + NetworkUtils.getNetworkType())
        KLog.d("tag", "ip地址(不使用 ipV4) " + NetworkUtils.getIPAddress(false))
        KLog.d("tag", "ip地址(使用 ipV4) " + NetworkUtils.getIPAddress(true))
        KLog.d("tag", "ip地址(wifi) " + NetworkUtils.getIpAddressByWifi())
        KLog.d("tag", "广播ip地址() " + NetworkUtils.getBroadcastIpAddress())
        KLog.d("tag", "设置是否是手机 " + PhoneUtils.isPhone())
        //        KLog.d("tag","IMIE " +  PhoneUtils.getIMEI());
//        KLog.d("tag","IMSI " +  PhoneUtils.getIMSI());
        KLog.d("tag", "SIM卡是否准备好 " + PhoneUtils.isSimCardReady())
        KLog.d("tag", "SIM卡运营商 " + PhoneUtils.getSimOperatorName())
        //        KLog.d("tag","手机状态信息 " +  PhoneUtils.getPhoneStatus());
        KLog.d("tag", "获取当前线程包名 " + ProcessUtils.getForegroundProcessName())
        KLog.d("tag", "屏幕的宽度 " + ScreenUtils.getScreenWidth())
        KLog.d("tag", "屏幕的高度 " + ScreenUtils.getScreenHeight())
        KLog.d("tag", "当前屏幕方向是否是竖屏 " + ScreenUtils.isPortrait())
        val bitmap = ScreenUtils.screenShot(this)
        val bitmap1 = ScreenUtils.screenShot(this, true)
        KLog.d("tag", "屏幕的截屏对象是否为null $bitmap bitmap1 $bitmap1")
        val baseDir = Environment.getExternalStorageDirectory().absolutePath + "/laopai/"
        val filePath = baseDir + "zl_jieping.jpg"
        val dir = File(baseDir)
        if (!dir.exists()) {
            dir.mkdir()
        }
        val f = File(filePath)
        try {
            f.createNewFile()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }
        val isSave = ImageUtils.save(bitmap, f, Bitmap.CompressFormat.JPEG)
        KLog.d("tag", "屏幕的截屏是否成功 $isSave")
        KLog.d("tag", "是否锁屏 " + ScreenUtils.isScreenLock())
        KLog.d("tag", "SD卡是否可用 " + SDCardUtils.isSDCardEnableByEnvironment())
        KLog.d("tag", "SD卡的存储目录 " + SDCardUtils.getSDCardPathByEnvironment())
        KLog.d("tag", "dp2px 1dp =  " + SizeUtils.dp2px(1f) + "px")
        val `is` = ""
        val is2 = " "
        KLog.d("tag", "字符串是否为null 或者 长度为0 " + StringUtils.isEmpty(`is`))
        KLog.d("tag", "字符串是否为null 或者 为空格 " + StringUtils.isTrimEmpty(is2))
        val is3 = "ab"
        val is4 = "AB"
        KLog.d("tag", "AB ab 字符串忽略大小写 " + StringUtils.equalsIgnoreCase(is3, is4))
        val is5 = "我爱中国"
        KLog.d("tag", "字符串反转 一个正序 一个倒叙 " + StringUtils.reverse(is5))
        KLog.d("tag", "用半角字符显示 " + StringUtils.toDBC(is5))
        KLog.d("tag", "用全角字符显示 " + StringUtils.toSBC(is5))
        val time = TimeUtils.getNowMills()
        val sTime = " 2020-03-12 21:48:14"
        KLog.d("tag", "系统的毫秒数 $time")
        KLog.d("tag", "当前时间戳的字符串格式 " + TimeUtils.getNowString())
        KLog.d("tag", "当前日期 " + TimeUtils.getNowDate())
        KLog.d(
            "tag",
            "时间戳转字符串 【利用时间戳 创建 Date 对象，在利用DateFormat 去 format 日期 】 " + TimeUtils.millis2String(
                time
            )
        )
        KLog.d("tag", "字符串转 时间戳 " + TimeUtils.string2Millis(sTime))
        KLog.d("tag", "字符串转 Date类型 " + TimeUtils.string2Date(sTime))
        KLog.d(
            "tag",
            "是不是今天 【00:00 -- 00:00 + 86400000 判断时间戳是否在这个范围内】 " + TimeUtils.isToday("1584022716018")
        )
        KLog.d("tag", "是否是闰年 【能被4整除并且不能被100整除 或者 能被400整除】" + TimeUtils.isLeapYear(time))
        KLog.d("tag", "时间戳对应的星期 " + TimeUtils.getChineseWeek(time))
        KLog.d("tag", "生肖  " + TimeUtils.getChineseZodiac(time))
        KLog.d("tag", "CUP的数量  " + Runtime.getRuntime().availableProcessors())
        KLog.d(
            "tag",
            "线程池 ExecutorSercvice  " + "的创建方式有两种 1.一种是工厂方法 Executors.newFixedThreadPool  2.一种是直接创建 new ThreadPoolExecutor"
        )
    }


}
