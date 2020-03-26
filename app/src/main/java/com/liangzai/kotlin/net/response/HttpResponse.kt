package com.liangzai.kotlin.net.response

import com.liangzai.kotlin.bean.BaseBean


/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2019-07-03
 * 描述:处理后台数据
 */
class HttpResponse<T> : BaseBean() {
    /**
     * 基本上后台返回的数据格式如下：
     * {
     * "success":true,
     * "code":200,
     * "msg":"成功",
     * "Data":[]
     * }
     * 或
     *
     * {
     * "success":true,
     * "code":200,
     * "msg":"成功",
     * "Data":{} -- 默认没有数据返回的时候
     * }
     *
     * T 泛型是在运行时动态的获取传递过来的参数
     *
     */
    var return_code: String? = null
    var return_msg: String? = null
    var return_data: T? = null
        private set

    fun setReturn_data(return_data: T) {
        this.return_data = return_data
    }
}