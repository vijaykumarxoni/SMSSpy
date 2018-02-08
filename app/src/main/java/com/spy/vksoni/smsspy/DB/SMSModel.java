package com.spy.vksoni.smsspy.DB;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vksoni on 1/15/2018.
 */

@Table(name="Messages")
public class SMSModel extends Model {
    @Column(name="msg_id",unique = true)
    public int msg_id;

    @Column(name="msg",notNull = true)
    public String msg_body ;


    @Column(name="msg_type",notNull = true)
    public String msg_type ;


    @Column(name="phone_no",notNull = true)
    public String phone_no ;
    @Column(name="msg_rec_date",notNull = true)
    public String msg_rec_date;

    @Column(name="msg_rec_time",notNull = true)
    public String msg_rec_time;
// foriegn key
    @Column(name="conver_id")
    public int conver_id;




}
