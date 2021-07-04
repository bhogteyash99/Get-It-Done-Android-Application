package com.example.yash.finalone;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<Data> spacecrafts;
    CustomFilter filter;
    ArrayList<Data> filterList;
    createActivity obj=new createActivity();
    static String tmpName;
    static String tmpAddress;
    static String tmpMob;
    static String tmpVehicle;
    static String tmpAmount;
    static String tmpDate;
    static String tmpBatteryNo;
    static String tmpBatterytype;
    static String tmpWarrenty;
    public CustomAdapter(){}
    public CustomAdapter(Context c, ArrayList<Data> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
        this.filterList=spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.list, parent, false);
        }

        final TextView nameTxt = (TextView) convertView.findViewById(R.id.dataTmp);
        TextView mobTxt = (TextView) convertView.findViewById(R.id.dataTmp2);
        TextView addressTxt = (TextView) convertView.findViewById(R.id.dataTmp3);
        TextView vehTxt = (TextView) convertView.findViewById(R.id.dataTmp4);
        TextView batteryTxt = (TextView) convertView.findViewById(R.id.dataTmp5);
        TextView amtTxt = (TextView) convertView.findViewById(R.id.dataTmp6);
        TextView dateTxt=(TextView)convertView.findViewById(R.id.dataTmp7);
        TextView batteryTypeTxt=(TextView)convertView.findViewById(R.id.dataTmp8);
        TextView batteryWarrentyTxt=(TextView)convertView.findViewById(R.id.dataTmp10);

        final Data s = (Data) this.getItem(position);

        nameTxt.setText("Name:"+s.getName());
        mobTxt.setText("Mobile:"+s.getMob());
        addressTxt.setText("Address:"+s.getAddress());
        vehTxt.setText("Vehicle :"+s.getVehNo());
        batteryTypeTxt.setText("BatteryType:"+s.getBatteryType());
        batteryTxt.setText("BatterNo:"+s.getBatteryNo());
        amtTxt.setText("Amount:"+s.getAmt());
        dateTxt.setText("Date:"+s.getDate());
        batteryWarrentyTxt.setText("BatterWarrenty:"+s.getBatteryWarrenty());


        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmpName=s.getName().toString();
                tmpVehicle=s.getVehNo().toString();
                tmpAddress=s.getAddress();
                tmpMob=s.getMob();
                tmpAmount=s.getAmt();
                tmpBatteryNo=s.getBatteryNo();
                tmpBatterytype=s.getBatteryType();
                tmpDate=s.getDate();
                tmpWarrenty=s.getBatteryWarrenty();
                Intent Login=new Intent(c,createActivity.class);
                c.startActivity(Login);
                //  ViewActivity vObj=new ViewActivity();
                //  vObj.searchBar.setText(s.getName());

            }
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter();

        }
        return filter;
    }
    class CustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null&&constraint.length()>0)
            {
                constraint=constraint.toString().toUpperCase();


                ArrayList<Data>filters=new ArrayList<Data>();

                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        Data d=new Data(filterList.get(i).getName(),filterList.get(i).getAddress(),filterList.get(i).getMob(),filterList.get(i).getVehNo(),filterList.get(i).getBatteryNo(),filterList.get(i).getAmt(),filterList.get(i).getDate(),filterList.get(i).getBatteryType(),filterList.get(i).getBatteryWarrenty());

                        filters.add(d);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }
            else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            spacecrafts=(ArrayList<Data>)results.values;
            notifyDataSetChanged();
        }
    }
}