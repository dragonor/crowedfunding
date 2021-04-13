package com.dragon.crowdfunding.test;

import com.dragon.crowd.entity.Admin;
import com.dragon.crowd.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description 在webui中，测试数据库的连接，测试模块之间的关联性
 * @Author Dragon
 * @Date 2021/4/13
 * @Version 1.0.0
 */
// spring 整合 Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-persist-mybatis.xml")  //指定配置文件使用 locations 参数
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Autowired
    private AdminMapper adminMapper;
//    private AdminService adminService;

    @Test
    public void testAdminMapperAutowired() {
//        Admin admin = adminService.getAdminById(1);
//        System.out.println(admin);
        Admin admin = new Admin(null, "zwl", "123", "dragon", "zwl@163.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("影响条数"+ count);
    }

}
