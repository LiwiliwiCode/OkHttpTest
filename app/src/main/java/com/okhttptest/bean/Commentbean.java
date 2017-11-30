package com.okhttptest.bean;

import java.util.List;

/**
 * Created by hhmsw on 2017/9/30.
 */

public class Commentbean {

    /**
     * code : 1
     * data : {"mini":{"list":[{"commentDate":1506761526,"commentId":44534465,"content":"很燃，想起汪峰问，你的梦想是什么😄","headImg":"http://img32.mtime.cn/up/2015/09/13/145052.37763774_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"M_1509131450513468906","praiseCount":1,"rating":9,"replyCount":0},{"commentDate":1506759222,"commentId":44534099,"content":"大鹏啊！长点心吧！好好拍你的屌丝男士，别搞电影找骂了！心疼你啊！","headImg":"http://img2.mtime.cn/u/1454/1567454/460bf2ee-127e-4c69-b978-e9999696f946/128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"重庆","nickname":"天天向上1567454","praiseCount":0,"rating":5,"replyCount":0},{"commentDate":1506758346,"commentId":44533916,"content":"非常好，摇滚不死，梦想无罪","headImg":"http://img32.mtime.cn/up/2016/07/02/213328.88136279_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"_218504584","praiseCount":0,"rating":10,"replyCount":0}],"total":300},"plus":{"list":[{"commentDate":1506599460,"commentId":8018613,"content":"文/梦里诗书\n\r\n用摇滚裹挟的梦想，在《缝纫机乐队》中并没有令人所见于何般真挚的情感，穷尽情怀与搞笑的拼凑，使其甚至于都没有能立住一个人物，在满是套路，甚至俨然就是快餐式的剧情下，那原属于梦想的光芒非但未能得以绽放，反而变得暗淡无光。\n\r\n\n\r\n虽然这一次的大鹏仍旧是聚焦于小人物的梦想，可相比于《煎饼侠》个人却觉得多了一份套路，少了一份新意，电影的整体剧情其实与《欢乐好声音》有着异曲同工之处，但不...","headImg":"http://img32.mtime.cn/up/2014/10/27/120847.82885479_128X128.jpg","isWantSee":false,"locationName":"","nickname":"梦里诗书","rating":5,"replyCount":1,"title":"《缝纫机乐队》：快餐式的情怀喜剧组合"}],"total":9}}
     * msg : 成功
     * showMsg :
     */

    private String code;
    private DataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static class DataBean {
        /**
         * mini : {"list":[{"commentDate":1506761526,"commentId":44534465,"content":"很燃，想起汪峰问，你的梦想是什么😄","headImg":"http://img32.mtime.cn/up/2015/09/13/145052.37763774_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"M_1509131450513468906","praiseCount":1,"rating":9,"replyCount":0},{"commentDate":1506759222,"commentId":44534099,"content":"大鹏啊！长点心吧！好好拍你的屌丝男士，别搞电影找骂了！心疼你啊！","headImg":"http://img2.mtime.cn/u/1454/1567454/460bf2ee-127e-4c69-b978-e9999696f946/128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"重庆","nickname":"天天向上1567454","praiseCount":0,"rating":5,"replyCount":0},{"commentDate":1506758346,"commentId":44533916,"content":"非常好，摇滚不死，梦想无罪","headImg":"http://img32.mtime.cn/up/2016/07/02/213328.88136279_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"_218504584","praiseCount":0,"rating":10,"replyCount":0}],"total":300}
         * plus : {"list":[{"commentDate":1506599460,"commentId":8018613,"content":"文/梦里诗书\n\r\n用摇滚裹挟的梦想，在《缝纫机乐队》中并没有令人所见于何般真挚的情感，穷尽情怀与搞笑的拼凑，使其甚至于都没有能立住一个人物，在满是套路，甚至俨然就是快餐式的剧情下，那原属于梦想的光芒非但未能得以绽放，反而变得暗淡无光。\n\r\n\n\r\n虽然这一次的大鹏仍旧是聚焦于小人物的梦想，可相比于《煎饼侠》个人却觉得多了一份套路，少了一份新意，电影的整体剧情其实与《欢乐好声音》有着异曲同工之处，但不...","headImg":"http://img32.mtime.cn/up/2014/10/27/120847.82885479_128X128.jpg","isWantSee":false,"locationName":"","nickname":"梦里诗书","rating":5,"replyCount":1,"title":"《缝纫机乐队》：快餐式的情怀喜剧组合"}],"total":9}
         */

        private MiniBean mini;
        private PlusBean plus;

        public MiniBean getMini() {
            return mini;
        }

        public void setMini(MiniBean mini) {
            this.mini = mini;
        }

        public PlusBean getPlus() {
            return plus;
        }

        public void setPlus(PlusBean plus) {
            this.plus = plus;
        }

        public static class MiniBean {
            /**
             * list : [{"commentDate":1506761526,"commentId":44534465,"content":"很燃，想起汪峰问，你的梦想是什么😄","headImg":"http://img32.mtime.cn/up/2015/09/13/145052.37763774_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"M_1509131450513468906","praiseCount":1,"rating":9,"replyCount":0},{"commentDate":1506759222,"commentId":44534099,"content":"大鹏啊！长点心吧！好好拍你的屌丝男士，别搞电影找骂了！心疼你啊！","headImg":"http://img2.mtime.cn/u/1454/1567454/460bf2ee-127e-4c69-b978-e9999696f946/128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"重庆","nickname":"天天向上1567454","praiseCount":0,"rating":5,"replyCount":0},{"commentDate":1506758346,"commentId":44533916,"content":"非常好，摇滚不死，梦想无罪","headImg":"http://img32.mtime.cn/up/2016/07/02/213328.88136279_128X128.jpg","img":"","isHot":false,"isPraise":false,"locationName":"","nickname":"_218504584","praiseCount":0,"rating":10,"replyCount":0}]
             * total : 300
             */

            private int total;
            private List<ListBean> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * commentDate : 1506761526
                 * commentId : 44534465
                 * content : 很燃，想起汪峰问，你的梦想是什么😄
                 * headImg : http://img32.mtime.cn/up/2015/09/13/145052.37763774_128X128.jpg
                 * img :
                 * isHot : false
                 * isPraise : false
                 * locationName :
                 * nickname : M_1509131450513468906
                 * praiseCount : 1
                 * rating : 9
                 * replyCount : 0
                 */

                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private String img;
                private boolean isHot;
                private boolean isPraise;
                private String locationName;
                private String nickname;
                private int praiseCount;
                private float rating;
                private int replyCount;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public boolean isIsHot() {
                    return isHot;
                }

                public void setIsHot(boolean isHot) {
                    this.isHot = isHot;
                }

                public boolean isIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(boolean isPraise) {
                    this.isPraise = isPraise;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getPraiseCount() {
                    return praiseCount;
                }

                public void setPraiseCount(int praiseCount) {
                    this.praiseCount = praiseCount;
                }

                public float getRating() {
                    return rating;
                }

                public void setRating(float rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }
        }

        public static class PlusBean {
            /**
             * list : [{"commentDate":1506599460,"commentId":8018613,"content":"文/梦里诗书\n\r\n用摇滚裹挟的梦想，在《缝纫机乐队》中并没有令人所见于何般真挚的情感，穷尽情怀与搞笑的拼凑，使其甚至于都没有能立住一个人物，在满是套路，甚至俨然就是快餐式的剧情下，那原属于梦想的光芒非但未能得以绽放，反而变得暗淡无光。\n\r\n\n\r\n虽然这一次的大鹏仍旧是聚焦于小人物的梦想，可相比于《煎饼侠》个人却觉得多了一份套路，少了一份新意，电影的整体剧情其实与《欢乐好声音》有着异曲同工之处，但不...","headImg":"http://img32.mtime.cn/up/2014/10/27/120847.82885479_128X128.jpg","isWantSee":false,"locationName":"","nickname":"梦里诗书","rating":5,"replyCount":1,"title":"《缝纫机乐队》：快餐式的情怀喜剧组合"}]
             * total : 9
             */

            private int total;
            private List<ListBeanX> list;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                /**
                 * commentDate : 1506599460
                 * commentId : 8018613
                 * content : 文/梦里诗书

                 用摇滚裹挟的梦想，在《缝纫机乐队》中并没有令人所见于何般真挚的情感，穷尽情怀与搞笑的拼凑，使其甚至于都没有能立住一个人物，在满是套路，甚至俨然就是快餐式的剧情下，那原属于梦想的光芒非但未能得以绽放，反而变得暗淡无光。



                 虽然这一次的大鹏仍旧是聚焦于小人物的梦想，可相比于《煎饼侠》个人却觉得多了一份套路，少了一份新意，电影的整体剧情其实与《欢乐好声音》有着异曲同工之处，但不...
                 * headImg : http://img32.mtime.cn/up/2014/10/27/120847.82885479_128X128.jpg
                 * isWantSee : false
                 * locationName :
                 * nickname : 梦里诗书
                 * rating : 5
                 * replyCount : 1
                 * title : 《缝纫机乐队》：快餐式的情怀喜剧组合
                 */

                private int commentDate;
                private int commentId;
                private String content;
                private String headImg;
                private boolean isWantSee;
                private String locationName;
                private String nickname;
                private float rating;
                private int replyCount;
                private String title;

                public int getCommentDate() {
                    return commentDate;
                }

                public void setCommentDate(int commentDate) {
                    this.commentDate = commentDate;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHeadImg() {
                    return headImg;
                }

                public void setHeadImg(String headImg) {
                    this.headImg = headImg;
                }

                public boolean isIsWantSee() {
                    return isWantSee;
                }

                public void setIsWantSee(boolean isWantSee) {
                    this.isWantSee = isWantSee;
                }

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public float getRating() {
                    return rating;
                }

                public void setRating(int rating) {
                    this.rating = rating;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
