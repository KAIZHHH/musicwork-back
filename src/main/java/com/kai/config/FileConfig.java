package com.kai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位头像地址
 *
 * @author kai
 * @date 2021/8/30 下午6:06
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //歌手头像地址                    每当前端访问"/img/singerPic/**": 跳转到file:/music-server[user.dir]/img/singerPic/     图片路径
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                        + System.getProperty("file.separator") + "singerPic" + System.getProperty("file.separator")
        );
        //歌曲图片地址
        registry.addResourceHandler("/img/songPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                        + System.getProperty("file.separator") + "songPic" + System.getProperty("file.separator")
        );
        //歌单图片地址
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                        + System.getProperty("file.separator") + "songListPic" + System.getProperty("file.separator")
        );
        //歌曲地址
        registry.addResourceHandler("/song/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "song" + System.getProperty("file.separator")
        );
        //用户头像地址
        registry.addResourceHandler("/avatorImages/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "avatorImages" + System.getProperty("file.separator")
        );
    }
}