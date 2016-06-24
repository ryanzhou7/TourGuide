package com.ryanzhou.company.tourguide.startupTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryanzhou.company.tourguide.R;
import com.ryanzhou.company.tourguide.model.Startup;

import java.util.List;

public class MyStartupRecyclerViewAdapter extends RecyclerView.Adapter<MyStartupRecyclerViewAdapter.ViewHolder> {

    private final List<Startup> mValues;
    private final StartupFragment.OnListFragmentInteractionListener mListener;

    public MyStartupRecyclerViewAdapter(List<Startup> items, StartupFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_startup, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTextViewName.setText(holder.mItem.getName());
        holder.mLogo.setImageResource(holder.mItem.getImageResource());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onClickStartup(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mLogo;
        public final TextView mTextViewName;
        public Startup mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLogo = (ImageView) mView.findViewById(R.id.imageViewLogo);
            mTextViewName = (TextView) mView.findViewById(R.id.textViewName);
        }
    }
}
