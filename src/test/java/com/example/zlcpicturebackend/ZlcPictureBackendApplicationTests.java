package com.example.zlcpicturebackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ZlcPictureBackendApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        String key="testKey";
        String value="testValue";

        //新增或更新
        valueOps.set(key,value);
        String storedValue = valueOps.get(key);
        assertEquals(value,storedValue,"存储的值与预期不一致");

        //修改
        String updateValue="updateValue";
        valueOps.set(key,updateValue);
        storedValue = valueOps.get(key);
        assertEquals(updateValue,storedValue,"更新后的值与预期不一致");
        //查询
        storedValue = valueOps.get(key);
        assertNotNull(storedValue,"查询的值为空");
        assertEquals(updateValue,storedValue,"查询的值与预期不一致");
        //删除
        stringRedisTemplate.delete(key);
        storedValue=valueOps.get(key);
        assertNull(storedValue,"删除后的值不为空");
    }

}
