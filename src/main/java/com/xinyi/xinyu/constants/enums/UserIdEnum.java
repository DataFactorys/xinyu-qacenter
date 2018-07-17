package com.xinyi.xinyu.constants.enums;

/**
 * Created by 10067610 on 2018/7/17.
 */
public enum UserIdEnum {
    WANGYINGUANG("0b613362b82f44448fa9851ec53a4740", 10067610L),
    ZHAOYINGGANG("2f4e8f5d30174133a46a0a1ff2cb951e", 10066193L),
    WANGHUA("922981d1b17b4a969e04b0a9f7d63007", 10065676L),
    LIJIE("bafba807064541739ab6d8db1a20aab2", 10067133L);

    private String val;
    private Long note;

    private UserIdEnum(String val, Long note) {
        this.val = val;
        this.note = note;
    }

    public String getVal() {
        return this.val;
    }

    public Long getNote() {
        return this.note;
    }

    public static UserIdEnum getEnumByStatus(String status){
        for(UserIdEnum evalStatus : UserIdEnum.values()){
            if(evalStatus.getVal()== status){
                return evalStatus;
            }
        }
        return null;
    }
}
