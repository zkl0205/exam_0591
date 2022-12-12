package com.template.mapper;

import com.template.entity.TestCrime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.template.vo.CrimeRankVo;
import com.template.vo.CrimeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zkl
 * @since 2022-12-12
 */
public interface TestCrimeMapper extends BaseMapper<TestCrime> {

    List<CrimeRankVo> listRank();

    List<String> listCrimeName3(@Param("city") String city, @Param("year") String year);
}
