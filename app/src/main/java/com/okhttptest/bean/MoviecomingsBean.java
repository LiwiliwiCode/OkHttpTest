package com.okhttptest.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hhmsw on 2017/9/29.
 */

public class MoviecomingsBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * actor1 : 成龙
     * actor2 : 皮尔斯·布鲁斯南
     * director : 马丁·坎贝尔
     * id : 226524
     * image : http://img5.mtime.cn/mt/2017/09/15/145930.13207094_1280X720X2.jpg
     * isFilter : false
     * isTicket : true
     * isVideo : true
     * locationName : 中国
     * rDay : 30
     * rMonth : 9
     * rYear : 2017
     * releaseDate : 9月30日上映
     * title : 英伦对决
     * type : 动作 / 惊悚
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/09/15/143707.94358002.jpg","length":128,"title":"英伦对决 终极版预告","url":"http://vfx.mtime.cn/Video/2017/09/15/mp4/170915143628064882.mp4","videoId":67677},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/08/18/093600.34408899.jpg","length":121,"title":"英伦对决 忍无可忍版预告","url":"http://vfx.mtime.cn/Video/2017/08/18/mp4/170818093543940345.mp4","videoId":67168},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/09/08/161031.51496518.jpg","length":100,"title":"英伦对决 复仇战火版预告","url":"http://vfx.mtime.cn/Video/2017/09/08/mp4/170908202118921806.mp4","videoId":67589}]
     * wantedCount : 5160
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
    private List<MoviecomingsBean.VideosBeanX> videos;

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

    public List<MoviecomingsBean.VideosBeanX> getVideos() {
        return videos;
    }

    public void setVideos(List<MoviecomingsBean.VideosBeanX> videos) {
        this.videos = videos;
    }

    public static class VideosBeanX implements  Serializable{
        /**
         * hightUrl :
         * image : http://img5.mtime.cn/mg/2017/09/15/143707.94358002.jpg
         * length : 128
         * title : 英伦对决 终极版预告
         * url : http://vfx.mtime.cn/Video/2017/09/15/mp4/170915143628064882.mp4
         * videoId : 67677
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
