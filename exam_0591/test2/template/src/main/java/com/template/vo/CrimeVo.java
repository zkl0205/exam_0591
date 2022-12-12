package com.template.vo;

import java.util.List;

public class CrimeVo {
    private Integer year;

    private List<CrimeRankVo> rankTop3;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<CrimeRankVo> getRankTop3() {
        return rankTop3;
    }

    public void setRankTop3(List<CrimeRankVo> rankTop3) {
        this.rankTop3 = rankTop3;
    }
}
