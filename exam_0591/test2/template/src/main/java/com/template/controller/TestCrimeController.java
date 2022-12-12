package com.template.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.template.entity.TestCrime;
import com.template.enums.ResultEnum;
import com.template.form.Crime;
import com.template.service.ITestCrimeService;
import com.template.vo.CrimeVo;
import com.template.vo.ResultVo;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zkl
 * @since 2022-12-12
 */
@RestController
@RequestMapping("/")
public class TestCrimeController {

    @Autowired
    ITestCrimeService testCrimeService;

    @GetMapping("/api/crime/stat")
    public ResultVo stat(@RequestParam("token") String token) {
        if (!checkToken(token)) {
            return ResultVo.error(ResultEnum.TOKEN_CHECK_FAIL, "");
        }
        List<CrimeVo> list = testCrimeService.listRank();
        return ResultVo.success(list);
    }

    @PostMapping("/api/crime")
    public ResultVo crime(@RequestBody Crime crime, @RequestParam("token") String token) {
        if (!checkToken(token)) {
            return ResultVo.error(ResultEnum.TOKEN_CHECK_FAIL, "");
        }
        if (crime == null) {
            return ResultVo.error(ResultEnum.ARGUMENT_TYPE_MISMATCH, "");
        }
        if (StringUtils.isEmpty(crime.getCity()) || StringUtils.isEmpty(crime.getOffenceCode())
                || crime.getStartDateTime() == null || crime.getVictims() == null || crime.getVictims() <= 0) {
            return ResultVo.error(ResultEnum.ARGUMENT_TYPE_MISMATCH, "");

        }
        if (crime.getDispatchTime() == null) {
            crime.setDispatchTime(crime.getStartDateTime());
        }
        TestCrime testCrime = new TestCrime();
        BeanUtils.copyProperties(crime, testCrime);
        boolean save = testCrimeService.save(testCrime);

        if (save) {
            Map<String, Integer> map = new HashMap<>();
            map.put("incidentID", testCrime.getIncidentId());
            return ResultVo.success(map);
        }
        return ResultVo.error(ResultEnum.ADD_FAIL, "");
    }

    private boolean checkToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        MessageDigest messageDigest;
        String encdeStr = "";
        String str = "crimeTest3";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            encdeStr = Hex.encodeHexString(hash);
            System.out.println(encdeStr);
            return token.endsWith(encdeStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}
