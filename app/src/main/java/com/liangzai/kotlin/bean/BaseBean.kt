package com.liangzai.kotlin.bean

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1. 内存开销小，没有利用反射，使用复杂
 */
open class BaseBean() : Parcelable{

    constructor(parcel: Parcel) : this() {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseBean> {
        override fun createFromParcel(parcel: Parcel): BaseBean {
            return BaseBean(parcel)
        }

        override fun newArray(size: Int): Array<BaseBean?> {
            return arrayOfNulls(size)
        }
    }
}