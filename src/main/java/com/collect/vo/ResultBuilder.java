package com.collect.vo;

/**
 * Created by nina_nyang on 2018/5/11.
 */
public class ResultBuilder {

    public static ResponseVo success(){
        ResponseVo vo = new ResponseVo();
        vo.setSuccess(true);
        vo.setCode(200);
        return vo;
    }
}
