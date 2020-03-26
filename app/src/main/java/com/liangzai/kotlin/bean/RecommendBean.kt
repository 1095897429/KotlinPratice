package com.liangzai.kotlin.bean

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2019-12-16
 * 描述:干货就是之前的首页推荐列表
 */
class RecommendBean : BaseBean() {
    var article_list: List<Article_list>? = null
    var adv_list: Adv_list? = null
    //是否有新文章
    var desc_notice: String? = null

    //广告
    class Adv_list {
        var id: String? = null
        var title: String? = null
        var platform: String? = null
        var position: String? = null
        var porder: String? = null
        var show_time: String? = null
        var end_time: String? = null
        var pic: String? = null
        var type: String? = null
        var relatedid: String? = null
        var link: String? = null
        var offline: String? = null
        var pv: String? = null
        var uv: String? = null
        var author: String? = null
        var show_title: String? = null
        var show_author: String? = null
        var created_at: String? = null
        var updated_at: String? = null

    }

    //文章列表
    class Article_list {
        var aid: String? = null
        var catid: String? = null
        var title: String? = null
        var author_id: String? = null
        var author: String? = null
        var author_flag: String? = null
        var fromsource: String? = null
        var fromurl: String? = null
        var summary: String? = null
        var pic: String? = null
        var search_keywords: String? = null
        var showindex: String? = null
        var status: String? = null
        var viewnum: String? = null
        var commentnum: String? = null
        var favnum: String? = null
        var sharenum: String? = null
        var pointnum: String? = null
        var totalpoint: String? = null
        var pub_type: String? = null
        var published_at: String? = null
        var upnum: String? = null
        var relate: List<Relate>? = null
        var dl_link: String? = null
        var dl_link_code: String? = null
        var dl_point: String? = null
        var que_title: String? = null
        var que_answer_json: List<Que_answer_json>? = null
        var right_answer: String? = null
        //文章主图2（主要APP使用）
        var pic2: String? = null
        var pic3: String? = null
        //1-单图小，2-单图大，3-三图
        var pic_type: String? = null
        var act_state = 0
        var video: String? = null
        var app_content_url: String? = null
        var share_url: String? = null
        var share_title: String? = null
        var share_summary: String? = null
        var share_pic: String? = null
        var article_point: String? = null
        var dl_times: String? = null

    }

    inner class Que_answer_json {
        var answer_id = 0
        var answer_title: String? = null

    }

    inner class Relate {
        var aid: String? = null
        var title: String? = null
        var pic: String? = null
        var author: String? = null
        var created_at: String? = null
        var published_at: String? = null

    }
}