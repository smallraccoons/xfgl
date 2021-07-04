package com.cc.demomptest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.demomptest.entity.User;
import com.cc.demomptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemomptestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //复杂逻辑查询
    @Test
    public void test'Wrapper'(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //ge、gt、le、lt  大于等于、大于，小于等于、小于
        //queryWrapper.ge("age",21);
        //eq,ne 等于，不等于
        //queryWrapper.eq("name","Tom");
        //isNull,between,notBetween
        //queryWrapper.between("age",21,24);
        //queryWrapper.isNull("age",21,24);
        //queryWrapper.like("name","皮");
        //orderBy、orderByDesc、orderByAsc
        queryWrapper.orderByDesc("id");

        //queryWrapper.likeLeft("name","j");
        // like、notLike、likeLeft、likeRight


        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    //逻辑删除查询
    @Test
    public void testLogicDeleteSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    //简单条件删除
    @Test
    public  void testDeleteByMap(){
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","jack");
        columnMap.put("age",18);
        int result = userMapper.deleteByMap(columnMap);
        System.out.println(result);
    }
    //批量删除
    @Test
    public void testDeleteByBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1,2,3));
        System.out.println(result);
    }
    //根据Id删除
    @Test
    public void testDeleteById(){
        int Result = userMapper.deleteById(1383629723542417409L);
        System.out.println(Result);

    }

//    //分页查询2
//    @Test
//    public void testSelectMapsPage() {
//        //Page不需要泛型
//        Page<Map<String, Object>> page = newPage<>(1, 5);
//        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
//        List<Map<String, Object>> records = pageParam.getRecords();
//        records.forEach(System.out::println);
//        System.out.println(pageParam.getCurrent());
//        System.out.println(pageParam.getPages());
//        System.out.println(pageParam.getSize());
//        System.out.println(pageParam.getTotal());
//        System.out.println(pageParam.hasNext());
//        System.out.println(pageParam.hasPrevious());
//    }


    //分页查询
    @Test
    public void testSelectPage(){
        Page<User> page =new Page(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到所有数据
        long pages = userPage.getPages();//总页数
        long current = userPage.getCurrent();//当前页
        List<User> records = userPage.getRecords();//数据集合
        long total = userPage.getTotal();//总记录数
        boolean hasNext = userPage.hasNext();//是否有下一页
        boolean hasPrevious = userPage.hasPrevious();//是否有上一页
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }

    //根据名称查询
    @Test
    public void testByName(){
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
    }
    //多个id批量查询
    @Test
    public void testByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }


    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1383335256356745217L);
        user.setName("皮卡丘");
        userMapper.updateById(user);
    }

    //修改
    @Test
    public void userUpdate(){
        User user = new User();
        user.setId(1383276367217098753L);
        user.setName("cc");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    //添加
    @Test
    public void userInsert(){
        User user = new User();
        user.setName("王五");
        user.setAge(21);
        user.setEmail("123@cc.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findAll() {
        List<User> user = userMapper.selectList(null);
        System.out.println(user);
    }

}
