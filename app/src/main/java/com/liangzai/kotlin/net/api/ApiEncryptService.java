package com.liangzai.kotlin.net.api;


import com.liangzai.kotlin.bean.RecommendBean;
import com.liangzai.kotlin.net.response.HttpResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.List;

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2019-09-12
 * 描述:restful格式
 * aes 加密  post 请求方式params = 加密字符串
 *
 */
public interface ApiEncryptService {



    /* 2019.12.16 首页干货   */
    @FormUrlEncoded
    @POST("app/article/recommendlist")
    Observable<HttpResponse<RecommendBean>> recommendlist(@Field("params") String param);


}
