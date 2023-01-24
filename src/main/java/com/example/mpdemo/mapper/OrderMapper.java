package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.Order;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);

    //  查询所有的订单，同时查询对应订单的用户
    @Select("select * from t_order")
    @Results({
            @Result(column = "id",property = "id"),
            // 数据库中的表用下划线，实体类中要用驼峰命名！！！！！！！！！！！！！
            @Result(column = "orderTime",property = "order_time"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one=@One(select = "com.example.mpdemo.mapper.UserMapper.selectById")
            )
    })
    List<Order> selectAllOrdersAndUser();
}
