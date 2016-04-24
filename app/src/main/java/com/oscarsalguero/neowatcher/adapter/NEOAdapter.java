package com.oscarsalguero.neowatcher.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oscarsalguero.neowatcher.NEODetailsActivity;
import com.oscarsalguero.neowatcher.R;
import com.oscarsalguero.neowatcher.bean.PotentiallyHazardousAsteroid;

import java.util.List;

/**
 * Report Monitors data adapter
 * <p/>
 * Created by oscar on 10/26/15.
 */
public class NEOAdapter extends RecyclerView.Adapter<NEOAdapter.NEOViewHolder> {

    private static final String LOG_TAG = NEOAdapter.class.getName();
    private Context mContext;
    final List<PotentiallyHazardousAsteroid> mItems;

    public static class NEOViewHolder extends RecyclerView.ViewHolder {

        public PotentiallyHazardousAsteroid currentItem;
        private final Context context;

        public TextView textViewTitle;
        public TextView textViewSubtitle;

        public NEOViewHolder(View view) {
            super(view);
            context = view.getContext();

            textViewTitle = (TextView) view.findViewById(R.id.text_view_title);
            textViewSubtitle = (TextView) view.findViewById(R.id.text_view_subtitle);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showVisualizer(context, currentItem);
                }
            });
        }

        public Context getContext() {
            return context;
        }

    }

    public NEOAdapter(Context context, List<PotentiallyHazardousAsteroid> list) {
        this.mItems = list;
        this.mContext = context;
    }

    @Override
    public NEOAdapter.NEOViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        final View view = LayoutInflater.from(mContext).inflate(R.layout.view_neo, parent, false);
        return new NEOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NEOViewHolder viewHolder, int position) {
        viewHolder.currentItem = mItems.get(position);
        String name = viewHolder.currentItem.getName();
        if(TextUtils.isEmpty(name)){
            name = viewHolder.currentItem.getPrincipalDesignation();
        }
        viewHolder.textViewTitle.setText(name);
        viewHolder.textViewSubtitle.setText(viewHolder.currentItem.getArcYears());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private static void showVisualizer(Context context, PotentiallyHazardousAsteroid pha) {
        Intent intent = new Intent(context, NEODetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(NEODetailsActivity.PARAM_NEO, pha);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
