package com.vogella.projet_prog_mobile_lalaorr;

import java.util.ArrayList;
import java.util.List;
import com.vogella.projet_prog_mobile_lalaorr.MainActivity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Amiibogoss> values;
    private Intent detailAmiibogoss;
    private MainActivity mainActivity;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view hold
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, Amiibogoss item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Amiibogoss> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private static final String SelectedAmiibogoss = "incoming Amiibo";
    public void DetailAmiibogoss(int position)
    {
        Intent detailAmiibogoss = new Intent(mainActivity, Detailed_amiibogoss.class);
        final Amiibogoss selectedAmiibogoss = values.get(position);

        ArrayList<String> AmiibogossFiesta = new ArrayList<>();
        AmiibogossFiesta.add(selectedAmiibogoss.getCharacter());
        AmiibogossFiesta.add(selectedAmiibogoss.getGameSeries());
        AmiibogossFiesta.add(selectedAmiibogoss.getAmiiboSeries());

        detailAmiibogoss.putStringArrayListExtra(SelectedAmiibogoss, AmiibogossFiesta);
        mainActivity.startActivity(detailAmiibogoss);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Amiibogoss selectedAmiibogoss = values.get(position);
        holder.txtHeader.setText(selectedAmiibogoss.getCharacter()/*+selectedAmiibogoss.getAmiiboSeries()*/);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    DetailAmiibogoss(position);
                                                }
                                            }
        );

        holder.txtFooter.setText("Game : " + selectedAmiibogoss.getGameSeries());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}