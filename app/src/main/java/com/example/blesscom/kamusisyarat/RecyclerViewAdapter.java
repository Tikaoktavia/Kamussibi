package com.example.blesscom.kamusisyarat;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable{

        Context context;

        private ArrayList<GetDataAdapter> mArrayList;
        private ArrayList<GetDataAdapter> getDataAdapter;

        ImageLoader imageLoader1;


//    public RecyclerViewAdapter(List<GetDataAdapter> getDataAdapter, Context context){
//
//        super();
//        //this.getDataAdapter = getDataAdapter;
//        this.context = context;
//    }

        public RecyclerViewAdapter(ArrayList<GetDataAdapter> arrayList, Context context) {
            super();
            mArrayList = arrayList;
            getDataAdapter = arrayList;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

            ViewHolder viewHolder = new ViewHolder(v);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder Viewholder, int position) {

            GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);

            imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

            imageLoader1.get(getDataAdapter1.getImageServerUrl(),
                    ImageLoader.getImageListener(
                            Viewholder.networkImageView,//Server Image
                            R.mipmap.ic_launcher,//Before loading server image the default showing image.
                            android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                    )
            );

            Viewholder.networkImageView.setImageUrl(getDataAdapter1.getImageServerUrl(), imageLoader1);

            Viewholder.ImageTitleNameView.setText(getDataAdapter1.getImageTitleName());

        }

        @Override
        public int getItemCount() {

            return getDataAdapter.size();
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {

                    String charString = charSequence.toString();

                    if (charString.isEmpty()) {

                        getDataAdapter = mArrayList;

                    } else {

                        ArrayList<GetDataAdapter> filteredList = new ArrayList<>();

                        for (GetDataAdapter androidVersion : mArrayList) {

                            if (
                                //androidVersion.getApi().toLowerCase().contains(charString) ||
                                    androidVersion.getImageTitleName().toLowerCase().contains(charString)
                                //|| androidVersion.getVer().toLowerCase().contains(charString)
                                    )
                            {

                                filteredList.add(androidVersion);
                            }
                        }

                        getDataAdapter = filteredList;
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = getDataAdapter;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    getDataAdapter = (ArrayList<GetDataAdapter>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            public TextView ImageTitleNameView;
            public NetworkImageView networkImageView ;

            public ViewHolder(View itemView) {

                super(itemView);

                ImageTitleNameView = (TextView) itemView.findViewById(R.id.textView_item) ;

                networkImageView = (NetworkImageView) itemView.findViewById(R.id.VollyNetworkImageView1) ;

            }
        }
    }
