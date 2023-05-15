package com.geeks.salkynbek_uulu_almazbek_hw_3_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geeks.salkynbek_uulu_almazbek_hw_3_2.R;

public class SecondFragment extends Fragment {

    private Button secondButton;
    private EditText ageEditText;
    private EditText genderEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById();

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()) {
                    ThirdFragment thirdFragment = new ThirdFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("nameValue", getArguments().getString("nameValue"));
                    bundle.putString("surnameValue", getArguments().getString("surnameValue"));
                    bundle.putString("ageValue", ageEditText.getText().toString());
                    bundle.putString("genderValue", genderEditText.getText().toString());
                    thirdFragment.setArguments(bundle);
                    replaceFragment(thirdFragment);
                } else {
                    Toast.makeText(requireContext(), "Пожалуйста заполните все поля",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isNumeric(s.toString())) {
                    ageEditText.setError("Введите только число!");
                } else {
                    ageEditText.setError(null);
                }
            }
        });


        genderEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String gender = s.toString().toLowerCase();
                if (!gender.equals("male") && !gender.equals("female")) {
                    genderEditText.setError("Веедите только текст 'Male' or 'Female'");
                } else {
                    genderEditText.setError(null);
                }
            }
        });

    }
    protected void findViewById(){
        secondButton = requireActivity().findViewById(R.id.secondNextButton);
        ageEditText = requireActivity().findViewById(R.id.ageEditText);
        genderEditText = requireActivity().findViewById(R.id.genderEditText);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }


    private boolean validateFields() {
        String thirdValue = ageEditText.getText().toString();
        String fourthValue = genderEditText.getText().toString();
        return !TextUtils.isEmpty(thirdValue) && !TextUtils.isEmpty(fourthValue);
    }

    private void replaceFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondFragmentContainerView, fragment)
                .addToBackStack(null)
                .commit();
    }
}
