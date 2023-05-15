package com.geeks.salkynbek_uulu_almazbek_hw_3_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geeks.salkynbek_uulu_almazbek_hw_3_2.R;


public class FourthFragment extends Fragment {

    private TextView nameValueTextView;
    private TextView surnameValueTextView;
    private TextView ageValueTextView;
    private TextView genderValueTextView;
    private TextView studyValueTextView;
    private TextView workValueTextView;

    private String nameValue;
    private String surnameValue;
    private String ageValue;
    private String genderValue;
    private String studyValue;
    private String workValue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById();
        getString();

    }
    protected void findViewById(){
        nameValueTextView = requireActivity().findViewById(R.id.nameTextView);
        surnameValueTextView = requireActivity().findViewById(R.id.surnameTextView);
        ageValueTextView = requireActivity().findViewById(R.id.ageTextView);
        genderValueTextView = requireActivity().findViewById(R.id.genderTextView);
        studyValueTextView = requireActivity().findViewById(R.id.studyPlaceTextView);
        workValueTextView = requireActivity().findViewById(R.id.workPlaceTextView);
    }

    private void getString(){
        Bundle bundle = getArguments();
        if (bundle != null) {
            nameValue = bundle.getString("nameValue");
            surnameValue = bundle.getString("surnameValue");
            ageValue = bundle.getString("ageValue");
            genderValue = bundle.getString("genderValue");
            studyValue = bundle.getString("studyValue");
            workValue = bundle.getString("workValue");
        }

        updateTextViews();

    }

    private void updateTextViews() {
        nameValueTextView.setText(nameValue);
        surnameValueTextView.setText(surnameValue);
        ageValueTextView.setText(ageValue);
        genderValueTextView.setText(genderValue);
        studyValueTextView.setText(studyValue);
        workValueTextView.setText(workValue);
    }

    private void replaceFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fourthFragmentContainerView, fragment)
                .addToBackStack(null)
                .commit();
    }
}


