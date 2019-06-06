package com.vogella.projet_prog_mobile_lalaorr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

public class Detailed_amiibogoss extends AppCompatActivity {

    private static final String SelectedAmiibogoss = "incoming Amiibo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_amiibogoss);
        AmiibogossYoupi();
    }

    public void AmiibogossYoupi() {
        TextView characterView = findViewById(R.id.amiibogoss_header);
        TextView gameSeriesView = findViewById(R.id.amiibogoss_gameseries);
        TextView amiiboSeriesView = findViewById(R.id.amiibogoss_detail);

        ArrayList<String> AmiibogossFiesta = getIntent().getStringArrayListExtra(SelectedAmiibogoss);

        characterView.setText(AmiibogossFiesta.get(0));
        gameSeriesView.setText(AmiibogossFiesta.get(1));
        amiiboSeriesView.setText(AmiibogossFiesta.get(2));
    }
}
