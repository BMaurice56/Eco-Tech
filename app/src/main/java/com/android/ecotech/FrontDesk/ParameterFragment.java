package com.android.ecotech.FrontDesk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.android.ecotech.R;
import com.google.android.material.snackbar.Snackbar;

public class ParameterFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ParameterFragment() {}

    public static ParameterFragment newInstance(String param1, String param2) {
        ParameterFragment fragment = new ParameterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parameter, container, false);


        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(requireContext(), R.array.languages, android.R.layout.simple_list_item_1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        TextView textViewPol_Of_Conf = view.findViewById(R.id.textViewPol_Of_Conf);
        TextView textViewParamData = view.findViewById(R.id.textViewParamData);
        TextView textViewDelivery_Returns = view.findViewById(R.id.textViewDelivery_Returns);
        TextView textViewFAQ = view.findViewById(R.id.textViewFAQ);
        TextView textViewGeneral_Conditions = view.findViewById(R.id.textViewGeneral_Conditions);
        TextView textViewLegalNotice = view.findViewById(R.id.textViewLegalNotice);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "Vous avez bien cliqué sur le lien", Snackbar.LENGTH_LONG).show();
            }
        };

        textViewPol_Of_Conf.setOnClickListener(clickListener);
        textViewParamData.setOnClickListener(clickListener);
        textViewDelivery_Returns.setOnClickListener(clickListener);
        textViewFAQ.setOnClickListener(clickListener);
        textViewGeneral_Conditions.setOnClickListener(clickListener);
        textViewLegalNotice.setOnClickListener(clickListener);



        return view;
    }
}