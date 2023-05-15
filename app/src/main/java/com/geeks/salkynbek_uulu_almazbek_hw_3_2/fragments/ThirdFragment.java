package com.geeks.salkynbek_uulu_almazbek_hw_3_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geeks.salkynbek_uulu_almazbek_hw_3_2.R;


public class ThirdFragment extends Fragment {

    private Button thirdButton;
    private EditText studyEditText;
    private EditText workEditText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById();

        thirdButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validateFields()) {
                    FourthFragment fourthFragment = new FourthFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("nameValue", getArguments().getString("nameValue"));
                    bundle.putString("surnameValue", getArguments().getString("surnameValue"));
                    bundle.putString("ageValue", getArguments().getString("ageValue"));
                    bundle.putString("genderValue", getArguments().getString("genderValue"));
                    bundle.putString("studyValue", studyEditText.getText().toString());
                    bundle.putString("workValue", workEditText.getText().toString());
                    fourthFragment.setArguments(bundle);
                    replaceFragment(fourthFragment);
                } else {
                    Toast.makeText(requireContext(), "Пожалуйста заполните все поля",
                            Toast.LENGTH_SHORT).show();
                }
            }



            private boolean validateFields() {
                String thirdValue = studyEditText.getText().toString();
                String fourthValue = workEditText.getText().toString();
                return !TextUtils.isEmpty(thirdValue) && !TextUtils.isEmpty(fourthValue);
            }



            private void replaceFragment(Fragment fragment) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.thirdFragmentContainerView, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
    protected void findViewById(){
        thirdButton = requireActivity().findViewById(R.id.thirdNextButton);
        studyEditText = requireActivity().findViewById(R.id.studyPlaceEditText);
        workEditText = requireActivity().findViewById(R.id.workPlaceEditText);
    }
}