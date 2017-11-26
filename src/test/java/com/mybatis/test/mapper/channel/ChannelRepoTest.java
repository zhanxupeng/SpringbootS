package com.mybatis.test.mapper.channel;

import com.mybatis.test.TestApplicationTests;
import com.mybatis.test.model.Channel;
import com.mybatis.test.repo.ChannelMapper;
import com.mybatis.test.common.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationTests.class)
public class ChannelRepoTest {
    @Autowired
    private ChannelMapper channelMapper;

    //写法流程：设置值 -> 插入 -> assert -> 查找 -> assert -> 设置新的值 -> 查找 -> assert -> 删除 -> assert -> 查找 -> assert
    @Test
    @Transactional
    public void testInsert_SelectById_Update_Delete() {
        //Arrange 每个字段都必须设值
        Channel channel = new Channel();
        channel.setId("42342342423fs33fz");
        channel.setName("工作渠道");
        channel.setValue("78");
        channel.setIosUrl("http://www.ios.com");
        channel.setAndroidUrl("http://www.android.com");
        channel.setDescription("描述信息");
        channel.setStatusType("1");
        channel.setChannelStatisticType("4");
        channel.setDeliveryCost(100);
        channel.setDelFlag("0");
        channel.setCreateBy("7bf3e87b90fbfb6c94435a8108612cc7");
        channel.setUpdateBy("7bf3e87b90fbfb6c94435a8108612cc7");
        channel.setCreateDate(DateUtil.convertStringToDate("20171108120000", DateUtil.YYYYMMDDHHMMSS));
        channel.setUpdateDate(DateUtil.convertStringToDate("20171108120000", DateUtil.YYYYMMDDHHMMSS));
        channel.setRemarks("");

        //Act
        int result = channelMapper.insert(channel);

        //Assert 每个字段都必须Assert
        assertEquals(1, result);

        Channel channelInDb = channelMapper.selectById("0000132a3e90f8dfc97204c09861c22e");
        assertEquals("0000132a3e90f8dfc97204c09861c22e", channelInDb.getId());
        assertEquals("工作渠道", channelInDb.getName());
        assertEquals("10", channelInDb.getValue());
        assertEquals("http://www.ios.com", channelInDb.getIosUrl());
        assertEquals("http://www.android.com", channelInDb.getAndroidUrl());
        assertEquals("描述信息", channelInDb.getDescription());
        assertEquals("1", channelInDb.getStatusType());
        assertEquals("4", channelInDb.getChannelStatisticType());
        assertTrue(100 == channelInDb.getDeliveryCost());
        assertEquals("0", channelInDb.getDelFlag());
        assertEquals("7bf3e87b90fbfb6c94435a8108612cc7", channelInDb.getCreateBy());
        assertEquals("7bf3e87b90fbfb6c94435a8108612cc7", channelInDb.getUpdateBy());
        assertEquals(DateUtil.convertStringToDate("20171108120000", DateUtil.YYYYMMDDHHMMSS), channelInDb.getCreateDate());
        assertEquals(DateUtil.convertStringToDate("20171108120000", DateUtil.YYYYMMDDHHMMSS), channelInDb.getUpdateDate());
        assertEquals("", channelInDb.getRemarks());

        //Arrange 每个字段都必须更新
        channelInDb.setName("工作渠道1");
        channelInDb.setValue("100");
        channelInDb.setIosUrl("http://www.ios1.com");
        channelInDb.setAndroidUrl("http://www.android1.com");
        channelInDb.setDescription("描述信息1");
        channelInDb.setStatusType("2");
        channelInDb.setChannelStatisticType("5");
        channelInDb.setDeliveryCost(1000);
        channelInDb.setCreateBy("7bf3e8b6c94435a8108617b90fbf2cc7");
        channelInDb.setUpdateBy("7bf3b90fbfb6c94435a8e87108612cc7");
        channelInDb.setCreateDate(DateUtil.convertStringToDate("20171109120000", DateUtil.YYYYMMDDHHMMSS));
        channelInDb.setUpdateDate(DateUtil.convertStringToDate("20171109120000", DateUtil.YYYYMMDDHHMMSS));
        channelInDb.setRemarks("remark");

        //Act
        int count = channelMapper.update(channelInDb);

        //Assert 每个字段都必须Assert
        assertEquals(1, count);

        Channel channelUpdate = channelMapper.selectById("0000132a3e90f8dfc97204c09861c22e");
        assertEquals("工作渠道1", channelUpdate.getName());
        assertEquals("100", channelUpdate.getValue());
        assertEquals("http://www.ios1.com", channelUpdate.getIosUrl());
        assertEquals("http://www.android1.com", channelUpdate.getAndroidUrl());
        assertEquals("描述信息1", channelUpdate.getDescription());
        assertEquals("2", channelUpdate.getStatusType());
        assertEquals("5", channelUpdate.getChannelStatisticType());
        assertTrue(1000 == channelUpdate.getDeliveryCost());
        assertEquals("7bf3e8b6c94435a8108617b90fbf2cc7", channelUpdate.getCreateBy());
        assertEquals("7bf3b90fbfb6c94435a8e87108612cc7", channelUpdate.getUpdateBy());
        assertEquals(DateUtil.convertStringToDate("20171109120000", DateUtil.YYYYMMDDHHMMSS), channelUpdate.getCreateDate());
        assertEquals(DateUtil.convertStringToDate("20171109120000", DateUtil.YYYYMMDDHHMMSS), channelUpdate.getUpdateDate());
        assertEquals("remark", channelUpdate.getRemarks());

        //Act
        int deleteCount = channelMapper.delete(Collections.singletonList("0000132a3e90f8dfc97204c09861c22e"));

        //Assert
        assertEquals(1, deleteCount);

        Channel channelAfterDelete = channelMapper.selectById("0000132a3e90f8dfc97204c09861c22e");
        Assert.assertNull(channelAfterDelete);

    }
}
