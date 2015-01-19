package com.user.mylistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2015/1/16.
 */
public class MyAdapter extends BaseAdapter {
    private List<Integer> StateColor ;
    private List<String>  VacationType , DueDay , Remain , Reason ;
    private Context mContext ;
    private Button Use , Delete ;
    private float x , ux ;
    public MyAdapter(Context mContext , List<Integer> StateColor , List<String> VacationType , List<String> DueDay , List<String> Remain , List<String> Reason){
        this.mContext = mContext  ;
        this.StateColor = StateColor ;
        this.VacationType = VacationType ;
        this.DueDay = DueDay ;
        this.Remain = Remain ;
        this.Reason = Reason ;
    }

    public int getCount(){
        return this.StateColor.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null ;
        if(view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            viewHolder.StateColor_Button = (Button) view.findViewById(R.id.StateColor_Button);
            viewHolder.VacationType_TextView = (TextView) view.findViewById(R.id.VacationType_TextView);
            viewHolder.Reason_TextView = (TextView) view.findViewById(R.id.Reason_TextView);
            viewHolder.DueDay_TextView = (TextView) view.findViewById(R.id.DueDay_TextView);
            viewHolder.Remain_TextView = (TextView) view.findViewById(R.id.Remain_TextView);
            viewHolder.Use_Button = (Button) view.findViewById(R.id.Use_Button);
            viewHolder.Delete_Button = (Button) view.findViewById(R.id.Delete_Button);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag() ;
        }

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final ViewHolder holder = (ViewHolder)v.getTag() ;
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //v.setBackgroundResource();
                    x = event.getX();
                    if (Use != null) {
                        Use.setVisibility(View.GONE);
                    }
                    if (Delete != null) {
                        Delete.setVisibility(View.GONE);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    ux = event.getX();
                    if(holder.Use_Button != null) {
                        if (Math.abs(x - ux) > 20) {
                            holder.Use_Button.setVisibility(View.VISIBLE);
                            Use = holder.Use_Button;
                        }
                        if (Math.abs(x - ux) > 20) {
                            holder.Delete_Button.setVisibility(View.VISIBLE);
                            Delete = holder.Delete_Button;
                        }
                    }
                }else if(event.getAction() == MotionEvent.ACTION_MOVE){

                }else{

                }
                return true ;
            }
        });
        //viewHolder.StateColor_TextView.setText(this.StateColor.get(position));
        viewHolder.StateColor_Button.setBackgroundColor(Color.GRAY);
        viewHolder.VacationType_TextView.setText(this.VacationType.get(position));
        viewHolder.Reason_TextView.setText(this.Reason.get(position)) ;
        viewHolder.DueDay_TextView.setText(this.DueDay.get(position));
        viewHolder.Remain_TextView.setText(this.Remain.get(position));

        viewHolder.Use_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.Delete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    final static class ViewHolder {
        TextView StateColor_Button , VacationType_TextView , Reason_TextView , Remain_TextView , DueDay_TextView ;
        Button Use_Button , Delete_Button ;
    }


}
