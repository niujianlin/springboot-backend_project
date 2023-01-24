package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//extends BaseMapper<User> ：mybatisplus自动实现curd，不用自己写，在控制器传参就行了
public interface UserMapper extends BaseMapper<User> {
// mybatis写sql方式
//    @Select("select * from user")
//    public List<User> find();
//
//    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);

    @Select("select * from t_user where id = #{id}")
    User selectByIdUser(int id);

//    mybatisplus的方法
//   查询所有用户及其他们拥有的订单
@Select("select * from t_user")
@Results(
        {
                @Result(column = "id",property = "id"),
                @Result(column = "username",property = "username"),
                @Result(column = "password",property = "password"),
                @Result(column = "birthday",property = "birthday"),
                // 根据用户表（t_user）的id查询订单表（t_order:uid）的数据，orders是user实体中的订单属性
                @Result(column = "id",property = "orders",javaType = List.class,
                        many=@Many(select = "com.example.mpdemo.mapper.OrderMapper.selectByUid")
                )
        }
)
//    mybatisplus的方式,查询用户及其所有的订单,上面都是给这个方法的注解
List<User> selectAllUserAndOrders();

}
