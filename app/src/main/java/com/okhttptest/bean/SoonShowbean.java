package com.okhttptest.bean;

import java.util.List;

/**
 * 即将上映
 * Created by hhmsw on 2017/9/21.
 */

public class SoonShowbean extends BeanInfo {

    private List<AttentionBean> attention;
    private List<MoviecomingsBean> moviecomings;

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public List<MoviecomingsBean> getMoviecomings() {
        return moviecomings;
    }

    public void setMoviecomings(List<MoviecomingsBean> moviecomings) {
        this.moviecomings = moviecomings;
    }

    public static class AttentionBean {
        /**
         * actor1 : 瑞安·雷诺兹
         * actor2 : 塞缪尔·杰克逊
         * director : 派特里克·休斯
         * id : 232197
         * image : http://img5.mtime.cn/mt/2017/09/03/160335.97264088_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 美国
         * rDay : 22
         * rMonth : 9
         * rYear : 2017
         * releaseDate : 9月22日上映
         * title : 王牌保镖
         * type : 动作 / 喜剧
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/30/160827.43530939.jpg","length":30,"title":"王牌保镖 中文版预告片","url":"http://vfx.mtime.cn/Video/2017/08/30/mp4/170830160834952961.mp4","videoId":67397},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/04/13/200135.19166609.jpg","length":116,"title":"王牌保镖 先行版预告片","url":"http://vfx.mtime.cn/Video/2017/04/13/mp4/170413195807452006.mp4","videoId":65295},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/05/27/084905.68291562.jpg","length":124,"title":"杀手的保镖 正式预告","url":"http://vfx.mtime.cn/Video/2017/05/27/mp4/170527082419103944.mp4","videoId":65935}]
         * wantedCount : 1044
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<VideosBean> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            /**
             * hightUrl :
             * image : http://img5.mtime.cn/mg/2017/08/30/160827.43530939.jpg
             * length : 30
             * title : 王牌保镖 中文版预告片
             * url : http://vfx.mtime.cn/Video/2017/08/30/mp4/170830160834952961.mp4
             * videoId : 67397
             */

            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }

    public static class MoviecomingsBean {
        /**
         * actor1 : 陈保元
         * actor2 : 苗侨伟
         * director : 汪洋
         * id : 250580
         * image : http://img5.mtime.cn/mt/2017/09/06/150142.65289796_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 中国
         * rDay : 22
         * rMonth : 9
         * rYear : 2017
         * releaseDate : 9月22日上映
         * title : 谜证
         * type : 剧情 / 悬疑
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/29/163314.31218099.jpg","length":15,"title":"谜证 15s预告片","url":"http://vfx.mtime.cn/Video/2017/09/06/mp4/170906145729636053.mp4","videoId":67372},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/29/163512.96008582.jpg","length":30,"title":"谜证 30s预告片","url":"http://vfx.mtime.cn/Video/2017/09/06/mp4/170906145749824250.mp4","videoId":67373},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/29/163713.11466567.jpg","length":60,"title":"谜证 60s预告片","url":"http://vfx.mtime.cn/Video/2017/09/06/mp4/170906145810089649.mp4","videoId":67374}]
         * wantedCount : 1092
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<VideosBeanX> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBeanX> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBeanX> videos) {
            this.videos = videos;
        }

        public static class VideosBeanX {
            /**
             * hightUrl :
             * image : http://img5.mtime.cn/mg/2017/08/29/163314.31218099.jpg
             * length : 15
             * title : 谜证 15s预告片
             * url : http://vfx.mtime.cn/Video/2017/09/06/mp4/170906145729636053.mp4
             * videoId : 67372
             */

            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }
}
