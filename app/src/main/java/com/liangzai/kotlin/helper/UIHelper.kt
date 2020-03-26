package com.liangzai.kotlin.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.liangzai.kotlin.activity.SettingActivity

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-21
 * 描述:
 */
class UIHelper {

    companion object{
        /** 打开设置界面  */
        fun toSettingActivity(ctx: Context) {
            val intent = Intent(ctx, SettingActivity::class.java)
            ctx.startActivity(intent)
        }

    }
}