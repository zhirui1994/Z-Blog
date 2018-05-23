package com.zhirui.zblog.utils;

import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.model.Vo.ContentVo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Component
public final class Commons {
    public static  String THEME = "themes/default";

    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isEmpty(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

    public static String site_url() {
        return site_url("");
    }

    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    public static String site_option(String key) {
        return site_option(key, "");
    }

    public static String site_option(String key, String defaultValue) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (!StringUtils.isEmpty(str)) {
            return str;
        } else {
            return defaultValue;
        }
    }

    public static String permalink(Integer cid, String slug) {
        return site_url("/article/" + cid.toString());
    }

    public static String permalink(ContentVo content) {
        return permalink(content.getCid(), content.getSlug());
    }

    public static String show_categories(String categories) throws UnsupportedEncodingException {
        if (!StringUtils.isEmpty(categories)) {
            String[] arr = categories.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<a href=\"/category/" + URLEncoder.encode(c, "UTF-8") + "\">" + c + "<a>");
            }
            return sbuf.toString();
        }
        return show_categories("默认分类");
    }

    public static String show_tags(String tags) throws UnsupportedEncodingException {
        if (!StringUtils.isEmpty(tags)) {
            String[] arr = tags.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<a href=\"/tag/" + URLEncoder.encode(c, "UTF-8") + "\">" + c + "</a>");
            }
            return sbuf.toString();
        }
        return "";
    }

    /**
     * 显示文章缩略图，顺序为：文章第一张图 -> 随机获取
     *
     * @return
     */
    public static String show_thumb(ContentVo contents) {
        int cid = contents.getCid();
        int size = cid % 20;
        size = size == 0 ? 1 : size;
        return "/user/img/rand/" + size + ".jpg";
    }

    /**
     * 获取文章第一张图片
     *
     * @return
     */
    public static String show_thumb(String content) {
        return "";
    }

    private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

    /**
     * 显示文章图标
     *
     * @param cid
     * @return
     */
    public static String show_icon(int cid) {
        return ICONS[cid % ICONS.length];
    }

    /**
     * 获取社交的链接地址
     *
     * @return
     */
    public static Map<String, String> social() {
        final String prefix = "social_";
        Map<String, String> map = new HashMap<>();
        map.put("weibo", WebConst.initConfig.get(prefix + "weibo"));
        map.put("zhihu", WebConst.initConfig.get(prefix + "zhihu"));
        map.put("github", WebConst.initConfig.get(prefix + "github"));
        map.put("twitter", WebConst.initConfig.get(prefix + "twitter"));
        return map;
    }

    /**
     * 网站标题
     *
     * @return
     */
    public static String site_title() {
        return site_option("site_title");
    }

    public static String fmtdate(Integer unixTime) {
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    public static String fmtdate(Integer unixTime, String patten) {
        if (unixTime != null && StringUtils.isEmpty(patten.trim())) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    public static String article(String value) {
        if (!StringUtils.isEmpty(value)) {
            value = value.replace("<!--more-->", "\r\n");
            return TaleUtils.mdToHtml(value);
        }
        return "";
    }
}
