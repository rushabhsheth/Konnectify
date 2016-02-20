package com.konnectify.www.konnectify;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import swipecard.FlingCardListener;
import com.bumptech.glide.Glide;

/**
 * Created by rushabh.a.sheth on 17-02-2016.
 */
public class card_adapter extends BaseAdapter implements FlingCardListener.ActionDownInterface {

    public static ViewHolder viewHolder;
    public List<card_data> parkingList;
    public Context mContext;

    public card_adapter(List<card_data> apps, Context context) {
        parkingList = apps;
        mContext = context;
    }

    @Override
    public void onActionDownPerform() {
        Log.e("action", "bingo");
    }

    public static class ViewHolder {
        public static FrameLayout background;
        public TextView DataText;
        public ImageView cardImage;

    }

    public static void removeBackground() {


        viewHolder.background.setVisibility(View.GONE);

    }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = LayoutInflater.from(mContext.getApplicationContext());
                rowView = inflater.inflate(R.layout.slide_card, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.DataText.setText(parkingList.get(position).getName() + "");
            Glide
                    .with(mContext)
                    .load(parkingList.get(position).getImage())
                    .into(viewHolder.cardImage);


            return rowView;
        }

    }

