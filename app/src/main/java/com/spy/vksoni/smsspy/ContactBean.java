package com.spy.vksoni.smsspy;

/**
 * Created by Vksoni on 2/1/2018.
 */

public class ContactBean  {
   private String contact_name;
   private String contact_no;

    public ContactBean(String contact_name, String contact_no) {
        this.contact_name = contact_name;
        this.contact_no = contact_no;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
}
