package com.learn.springelasticsearch;

import com.learn.springelasticsearch.entity.User;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;

import javax.annotation.Resource;

@SpringBootTest
class EsDemoApplicationTests {

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Resource
    private RestHighLevelClient restHighLevelClient; // 原生客户端, 结合kb 调试方便

    @Test
    void contextLoads() {
        // 索引库的操作对象
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(User.class);
        // 初始化索引库
        indexOperations.create();  // 相当于 put /user
        // 初始化映射
        indexOperations.putMapping(indexOperations.createMapping()); // put /user/_mapping

    }

    //文档操作
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("John");
        user.setAge(20);
        user.setPassword("123456");
        // 新增 修改
        elasticsearchRestTemplate.save(user);
    }
@Test
    public void testDelete(){
        // 删除
        elasticsearchRestTemplate.delete(User.class);
    }
}
