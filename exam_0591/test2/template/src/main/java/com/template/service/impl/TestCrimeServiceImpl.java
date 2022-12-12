package com.template.service.impl;

import com.template.entity.TestCrime;
import com.template.mapper.TestCrimeMapper;
import com.template.service.ITestCrimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.template.vo.CrimeRankVo;
import com.template.vo.CrimeVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zkl
 * @since 2022-12-12
 */
@Service
public class TestCrimeServiceImpl extends ServiceImpl<TestCrimeMapper, TestCrime> implements ITestCrimeService {


    @Override
    public List<CrimeVo> listRank() {
        // 将数据按年，城市进行分组
        List<CrimeRankVo> crimeRankVos = this.baseMapper.listRank();
        List<CrimeVo> list = new ArrayList<>();
        Map<String, CrimeVo> map = new HashMap<>();
        // 取出每年前三的犯罪城市数据
        for (CrimeRankVo crimeRankVo : crimeRankVos) {
            CrimeVo crimeVo = map.get(crimeRankVo.getYear());
            if (crimeVo == null) {
                crimeVo = new CrimeVo();
                crimeVo.setYear(Integer.valueOf(crimeRankVo.getYear()));
                map.put(crimeRankVo.getYear(), crimeVo);
            }
            List<CrimeRankVo> rankTop3 = crimeVo.getRankTop3();
            if (rankTop3 == null) {
                rankTop3 = new ArrayList<>();
            }
            int rank = rankTop3.size() + 1;
            if (rank > 3) {
                continue;
            }
            crimeRankVo.setRank(rank);
            // 取出每个城市，每年 犯罪前三的罪名
            List<String> crimeName3 = this.baseMapper.listCrimeName3(crimeRankVo.getCity(), crimeRankVo.getYear());
            crimeRankVo.setCrimeTop3(crimeName3);

            // 計算風險係數
            double riskIndex = (0.8 * crimeRankVo.getCrimeSum() + 0.2 * crimeRankVo.getVictimsSum()) / 365;
            BigDecimal two = new BigDecimal(riskIndex);
            crimeRankVo.setRiskIndex(two.setScale(2, RoundingMode.HALF_UP).doubleValue());
            crimeRankVo.setCrimeSum(null);
            crimeRankVo.setVictimsSum(null);
            crimeRankVo.setYear(null);
            rankTop3.add(crimeRankVo);
            crimeVo.setRankTop3(rankTop3);

        }

        Set<String> strings = map.keySet();
        for (String key : strings) {
            CrimeVo crimeVo = map.get(key);
            list.add(crimeVo);
        }
        return list;
    }
}
