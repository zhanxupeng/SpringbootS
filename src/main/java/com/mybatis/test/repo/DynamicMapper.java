package com.mybatis.test.repo;

import com.mybatis.test.common.base.BaseMapper;
import com.mybatis.test.domain.DynamicIntroduction;
import com.mybatis.test.domain.LatestDynamic;
import com.mybatis.test.domain.MyDynamic;
import com.mybatis.test.model.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DynamicMapper extends BaseMapper<Dynamic> {

    /**
     * 获取某分类下动态的数目
     */
    int getCountByAppointCategory(@Param("firstTitle") String firstTitle,
                                  @Param("secondTitle") String secondTitle);

    /**
     * 获取某分类下的动态（仅仅用于话题）
     */
    List<DynamicIntroduction> findPage(@Param("firstTitle") String firstTitle,
                                       @Param("secondTitle") String secondTitle);

    /**
     * 获取好友圈数据
     */
    List<DynamicIntroduction> findFriendPage(@Param("customerId") String customerId);

    /**
     * 获取附近数据(可以查看朋友的朋友发在附近或校园的动态)
     */
    List<DynamicIntroduction> findNearbyPage(@Param("customerId") String customerId);

    /**
     * 获取校园数据
     */
    List<DynamicIntroduction> findSchoolPage();

    /**
     * 获取校园推荐数据按热度排序
     */
    List<DynamicIntroduction> findRecommendByPopularity(@Param("count") int count);

    /**
     * 获取校园推荐数据按时间倒序
     */
    List<DynamicIntroduction> findRecommendByDate(@Param("count") int count);

    /**
     * 根据用户id获取动态，按时间降序
     */
    List<MyDynamic> findDynamicByCustomer(@Param("customerId") String customerId);

    /**
     * 根据用户id查询动态数量
     */
    int getCountByCustomerId(@Param("customerId") String customerId);

    /**
     * 限制数目查询动态
     */
    List<LatestDynamic> getLatestDynamicByCount(@Param("customerId") String customerId,
                                                @Param("count") int count);

    /**
     * 查询某天的动态数量
     */
    int getDayCount(@Param("createDate") Date createDate);
}