package com.manage.bean;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Arrays;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:
 */
public class Manage {

    private int id;

    private String img;

    private MultipartFile[] imgFile;

    private String title;

    private int downSalary;

    private int upSalary;

    private String content;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDownSalary() {
        return downSalary;
    }

    public void setDownSalary(int downSalary) {
        this.downSalary = downSalary;
    }

    public int getUpSalary() {
        return upSalary;
    }

    public void setUpSalary(int upSalary) {
        this.upSalary = upSalary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public MultipartFile[] getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile[] imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", imgFile=" + Arrays.toString(imgFile) +
                ", title='" + title + '\'' +
                ", downSalary=" + downSalary +
                ", upSalary=" + upSalary +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
