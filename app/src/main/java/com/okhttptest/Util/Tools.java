package com.okhttptest.Util;

/**
 * Created by hhmsw on 2017/9/19.
 */

public class Tools {

    // 短信注册，随机产生头像
    public static final String[] AVATARS = {
            "http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
            "http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
            "http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
            "http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
            "http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
            "http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg",
            "http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
            "http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
            "http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg",
            "http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg"
    };

    /**
     * 引导页
     */
    public static String picPath[] = {
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506341087700&di=343faf30156b1b8ed041babc0f18ef4d&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2Fd31b0ef41bd5ad6e03ada00d86cb39dbb7fd3c85.jpg"
    ,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=845222027,3304604687&fm=27&gp=0.jpg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506341273549&di=6fc454e894adff0d77ec6b0e5ac8bc3e&imgtype=0&src=http%3A%2F%2Fwww.taopic.com%2Fuploads%2Fallimg%2F140627%2F240407-14062F6441141.jpg"};

    /**
     * 正在售票(包括正在热映和即将上映)
     * Time 时光 App
     * url：https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=?
     示例 url：https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=290
     */

    /**
     * 正在热映
     * url：https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=?
     示例 url：https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=290
     */

    public static String WELLRE_URL = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=290";

    /**
     * 即将上映
     url：`https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=?`
     示例 url：https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=290
     */
    public static String SOONSHOW_URL = "https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=290";
    /**
     * 影片详情
     url：https://ticket-api-m.mtime.cn/movie/detail.api?locationId=290&movieId=246526

     */
    public static String FLIMDESC_URL = "https://ticket-api-m.mtime.cn/movie/detail.api?";
    /**
     * 演职员表
     url：https://api-m.mtime.cn/Movie/MovieCreditsWithTypes.api?movieId=?
     */

    /**
     * 影片评论
     url：https://ticket-api-m.mtime.cn/movie/hotComment.api?movieId=?
     */

    /**
     * 预告片&拍摄花絮
     url：https://api-m.mtime.cn/Movie/Video.api?pageIndex=?&movieId=?
     */

    /**
     * 剧照
     url：https://api-m.mtime.cn/Movie/ImageAll.api?movieId=?
     */

}
