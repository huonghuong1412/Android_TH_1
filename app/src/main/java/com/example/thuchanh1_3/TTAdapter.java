package com.example.thuchanh1_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

public class TTAdapter  extends BaseAdapter {

    private List<Thathinh> list;
    private Context context;

    public TTAdapter(List<Thathinh> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView txtId, txtName, txtDate;
        RatingBar ratingBar;
        Button btnDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.thathinh_item, null);
            viewHolder.txtId = convertView.findViewById(R.id.textView);
            viewHolder.txtName = convertView.findViewById(R.id.textView2);
            viewHolder.txtDate = convertView.findViewById(R.id.textView3);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.ratingBar = convertView.findViewById(R.id.ratingBar);
            viewHolder.btnDelete = convertView.findViewById(R.id.button);

            Thathinh tt  = list.get(position);
            viewHolder.imageView.setImageResource(tt.getImage());
            viewHolder.txtId.setText(tt.getId());
            viewHolder.txtName.setText(tt.getName());
            viewHolder.txtDate.setText(tt.getDate());
            viewHolder.ratingBar.setRating(tt.getRate());
            viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
