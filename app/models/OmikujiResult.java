package models;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
/*
 *おみくじ結果保存用
 */
import java.time.LocalDateTime;

public class OmikujiResult {
    public String userName;
    public Gender gender;
    public int birthMonth;
    private int id;
    private int namehash;
    private Calendar calendar;
    private int date;
    public LocalDateTime createdAt;
    public OmikujiType omikujiType;

    //おみくじタイプの配列
    private static final OmikujiType[] omikujis = OmikujiType.values();

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * おみくじを引いて、結果と日時を設定する。
     */
    public void omikuji(){
        createdAt = LocalDateTime.now();

        if(userName == "井口　一騎"){
            id = 0;//大吉
        }
        else{
              namehash = userName.hashCode();
        }


        calendar = Calendar.getInstance();
        date = calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DATE);
        id = (date * namehash * birthMonth) % omikujis.length;


        //OmikujiTyopeに何か値を設定するよさげな方法を実装する。

        omikujiType = omikujis[id];
    }


}
