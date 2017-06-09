package com.meiling.mvp.module.dbentity;

import android.provider.CallLog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class RecordEntity {
    private String name;
    private String number;
    private int type;
    private long lDate;
    private long duration;//记录单位是second
    private int _new;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getlDate() {
        return lDate;
    }

    public void setlDate(long lDate) {
        this.lDate = lDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int get_new() {
        return _new;
    }

    public void set_new(int _new) {
        this._new = _new;
    }

    public String getTypeValue(){
        switch (type){
            case CallLog.Calls.INCOMING_TYPE:
                return "INCOMING_TYPE";
            case CallLog.Calls.OUTGOING_TYPE:
                return "OUTGOING_TYPE";
            case CallLog.Calls.MISSED_TYPE:
                return "MISSED_TYPE";
            case CallLog.Calls.VOICEMAIL_TYPE:
                return "VOICEMAIL_TYPE";
            case CallLog.Calls.REJECTED_TYPE:
                return "REJECTED_TYPE";
            case CallLog.Calls.BLOCKED_TYPE:
                return "BLOCKED_TYPE";
            default:
                return "null";
        }
    }
    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String getFormatData(){
        return simpleDateFormat.format(new Date(lDate));
    }

    @Override
    public String toString() {
        return "RecordEntity{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", type=" + getTypeValue() +
                ", lDate=" + getFormatData() +
                ", duration=" + duration +
                ", _new=" + _new +
                '}';
    }
}
