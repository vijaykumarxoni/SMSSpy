package com.spy.vksoni.smsspy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.spy.vksoni.smsspy.DB.ConversationModel;
import com.spy.vksoni.smsspy.DB.SMSModel;
import com.spy.vksoni.smsspy.R;

import java.util.List;

/**
 * Created by Vksoni on 1/31/2018.
 */

public class ListViewAdapterMsg extends BaseAdapter {

    public Context context;
    public List<SMSModel> smsList;



    public ListViewAdapterMsg(Context context, List <SMSModel> smsList){
        this.context = context;
        this.smsList = smsList;
    }

    @Override
    public int getCount() {
        return smsList.size();
    }

    @Override
    public SMSModel getItem(int i) {
        return smsList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        SMSModel sms = smsList.get(position);
if(sms.msg_type.equalsIgnoreCase("Received")){
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.received_row, viewGroup, false);
        }


        TextView SenderName = (TextView)view.findViewById(R.id.textViewName);
        TextView msgTime = (TextView)view.findViewById(R.id.textViewTime);
        TextView msgDate = (TextView)view.findViewById(R.id.textViewDate);
        TextView msgBody = (TextView)view.findViewById(R.id.textViewMsgBody);
        ImageView friendImage=(ImageView)view.findViewById(R.id.imageViewGrid);

        SenderName.setText(""+sms.phone_no);
        msgDate.setText(""+sms.msg_rec_date);
        msgTime.setText(""+sms.msg_rec_time);
        msgBody.setText(""+sms.msg_body);
        friendImage.setImageResource(R.drawable.profile);

        return view;}
        else{

    if(view == null){
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.send_row, viewGroup, false);
    }


    TextView msgTime = (TextView)view.findViewById(R.id.textViewSendTime);
    TextView msgDate = (TextView)view.findViewById(R.id.textViewSendDate);
    TextView msgBody = (TextView)view.findViewById(R.id.textViewMsgSendBody);

    msgDate.setText(""+sms.msg_rec_date);
    msgTime.setText(""+sms.msg_rec_time);
    msgBody.setText(""+sms.msg_body);

    return view;}


    }


    }






