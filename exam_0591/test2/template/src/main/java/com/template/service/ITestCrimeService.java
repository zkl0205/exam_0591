package com.template.service;

import com.template.entity.TestCrime;
import com.baomidou.mybatisplus.extension.service.IService;
import com.template.vo.CrimeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkl
 * @since 2022-12-12
 */
public interface ITestCrimeService extends IService<TestCrime> {

    List<CrimeVo> listRank();

}
