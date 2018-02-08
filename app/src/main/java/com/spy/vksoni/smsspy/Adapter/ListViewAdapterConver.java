package com.spy.vksoni.smsspy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.spy.vksoni.smsspy.DB.ConversationModel;
import com.spy.vksoni.smsspy.R;

import java.util.List;

/**
 * Created by Vksoni on 1/31/2018.
 */

public class ListViewAdapterConver extends BaseAdapter {

    public Context context;
    public List<ConversationModel> conversationList;



    public ListViewAdapterConver(Context context, List <ConversationModel> conversationList){
        this.context = context;
        this.conversationList = conversationList;
    }

    @Override
    public int getCount() {
        return conversationList.size();
    }

    @Override
    public ConversationModel getItem(int i) {
        return conversationList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.row_conversation_listview, viewGroup, false);
        }

        ConversationModel con = conversationList.get(position);

        TextView SenderName = (TextView)view.findViewById(R.id.textViewName);
        TextView msgTime = (TextView)view.findViewById(R.id.textViewTime);
        TextView msgDate = (TextView)view.findViewById(R.id.textViewDate);
        ImageView friendImage=(ImageView)view.findViewById(R.id.imageViewPic);

        SenderName.setText(""+con.sender_name_number);
        msgDate.setText(""+con.msg_rec_date);
        msgTime.setText(""+con.msg_rec_time);
        friendImage.setImageResource(R.drawable.profile);

        return view;


    }





}
