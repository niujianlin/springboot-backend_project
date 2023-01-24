package com.example.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

// 表的名称与类不对应
@TableName("t_user")
public class User {
    // mybatisplus会将自增属性在传给数据库前自增
    @TableId(type = IdType.AUTO)
    private int id;
    private  String username;
    private String password;
    private  String birthday;
    //    描述用户都有哪些订单，表里本身不存在（mybatis不存在这个问题，因为自己在mapper里写sql语句。mybatisplus需要告诉他类里哪些表字段不存在）
    @TableField(exist = false)
    private List<Order> orders;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
