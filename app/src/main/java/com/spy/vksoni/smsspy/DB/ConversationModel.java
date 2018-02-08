package com.spy.vksoni.smsspy.DB;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vksoni on 1/15/2018.
 */

@Table(name="Conversation")
public class ConversationModel extends Model {
    public ConversationModel(int conver_id, String sender_name_number, String msg_rec_date, String msg_rec_time) {
        this.conver_id = conver_id;
        this.sender_name_number = sender_name_number;
        this.msg_rec_date = msg_rec_date;
        this.msg_rec_time = msg_rec_time;
    }

    public ConversationModel() {
    }

    @Column(name="conver_id",unique = true)
    public int conver_id;

    @Column(name="sender_name_number",notNull = true)
    public String sender_name_number ;


    @Column(name="msg_rec_date",notNull = true)
    public String msg_rec_date;

    @Column(name="msg_rec_time",notNull = true)
    public String msg_rec_time;

    public int getConver_id() {
        return conver_id;
    }

    public void setConver_id(int conver_id) {
        this.conver_id = conver_id;
    }

    public String getSender_name_number() {
        return sender_name_number;
    }

    public void setSender_name_number(String sender_name_number) {
        this.sender_name_number = sender_name_number;
    }

    public String getMsg_rec_date() {
        return msg_rec_date;
    }

    public void setMsg_rec_date(String msg_rec_date) {
        this.msg_rec_date = msg_rec_date;
    }

    public String getMsg_rec_time() {
        return msg_rec_time;
    }

    public void setMsg_rec_time(String msg_rec_time) {
        this.msg_rec_time = msg_rec_time;
    }

}
