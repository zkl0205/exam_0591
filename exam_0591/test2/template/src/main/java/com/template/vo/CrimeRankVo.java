package com.template.vo;

import java.util.List;

public class CrimeRankVo {

    private String year;

    private String city;

    private Double riskIndex;

    private Integer rank;

    private List<String> crimeTop3;

    private Integer victimsSum;

    private Integer crimeSum;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getRiskIndex() {
        return riskIndex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRiskIndex(Double riskIndex) {
        this.riskIndex = riskIndex;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<String> getCrimeTop3() {
        return crimeTop3;
    }

    public void setCrimeTop3(List<String> crimeTop3) {
        this.crimeTop3 = crimeTop3;
    }

    public Integer getVictimsSum() {
        return victimsSum;
    }

    public void setVictimsSum(Integer victimsSum) {
        this.victimsSum = victimsSum;
    }

    public Integer getCrimeSum() {
        return crimeSum;
    }

    public void setCrimeSum(Integer crimeSum) {
        this.crimeSum = crimeSum;
    }
}
