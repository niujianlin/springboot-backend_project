package com.example.mpdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;


//    查询所有用户
    @GetMapping("/user/findAll")
    public List<User> query(){
//        mybatis的用法
//        List<User> list = userMapper.find();
        // mybatisplus用法
//        List<User> list = userMapper.selectList(null);
//        List users = userMapper.selectAllUserAndOrders();
//        System.out.println(users);
        return userMapper.selectAllUserAndOrders();
    }

    //  条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username","zhangsan");
        return userMapper.selectList(queryWrapper);
    }

    //  分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        //设置起始值及每页条数
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

//    插入用户信息
    @PostMapping("/user")
    public String save(User user) {
        int i = userMapper.insert(user);
                        // mybatisplus会将自增属性在传给数据库前自增
                        System.out.println(user);
        if(i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    // 返回json字符串
    @GetMapping("/json")
    public String goodsinfo() {
        String t = "{\"status\":200,\"message\":\"获取购物车列表数据成功！\",\"list\":[{\"id\":1,\"goods_name\":\"班俏BANQIAO超火ins潮卫衣女士2020秋季新款韩版宽松慵懒风薄款外套带帽上衣\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/1.png\",\"goods_price\":108,\"goods_count\":1,\"goods_state\":true},{\"id\":2,\"goods_name\":\"嘉叶希连帽卫衣女春秋薄款2020新款宽松bf韩版字母印花中长款外套ins潮\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/2.png\",\"goods_price\":129,\"goods_count\":1,\"goods_state\":true},{\"id\":3,\"goods_name\":\"思蜜怡2020休闲运动套装女春秋季新款时尚大码宽松长袖卫衣两件套\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/3.png\",\"goods_price\":198,\"goods_count\":1,\"goods_state\":false},{\"id\":4,\"goods_name\":\"思蜜怡卫衣女加绒加厚2020秋冬装新款韩版宽松上衣连帽中长款外套\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/4.png\",\"goods_price\":99,\"goods_count\":1,\"goods_state\":false},{\"id\":5,\"goods_name\":\"幂凝早秋季卫衣女春秋装韩版宽松中长款假两件上衣薄款ins盐系外套潮\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/5.png\",\"goods_price\":156,\"goods_count\":1,\"goods_state\":true},{\"id\":6,\"goods_name\":\"ME&CITY女装冬季新款针织抽绳休闲连帽卫衣女\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/6.png\",\"goods_price\":142.8,\"goods_count\":1,\"goods_state\":true},{\"id\":7,\"goods_name\":\"幂凝假两件女士卫衣秋冬女装2020年新款韩版宽松春秋季薄款ins潮外套\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/7.png\",\"goods_price\":219,\"goods_count\":2,\"goods_state\":true},{\"id\":8,\"goods_name\":\"依魅人2020休闲运动衣套装女秋季新款秋季韩版宽松卫衣 时尚两件套\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/8.png\",\"goods_price\":178,\"goods_count\":1,\"goods_state\":true},{\"id\":9,\"goods_name\":\"芷臻(zhizhen)加厚卫衣2020春秋季女长袖韩版宽松短款加绒春秋装连帽开衫外套冬\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/9.png\",\"goods_price\":128,\"goods_count\":1,\"goods_state\":false},{\"id\":10,\"goods_name\":\"Semir森马卫衣女冬装2019新款可爱甜美大撞色小清新连帽薄绒女士套头衫\",\"goods_img\":\"https://www.escook.cn/vuebase/pics/10.png\",\"goods_price\":153,\"goods_count\":1,\"goods_state\":false}]}";
        return t;
    }

}
