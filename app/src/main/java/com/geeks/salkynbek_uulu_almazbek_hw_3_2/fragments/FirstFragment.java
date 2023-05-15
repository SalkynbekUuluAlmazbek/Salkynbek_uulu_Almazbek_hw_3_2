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
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class FirstFragment extends Fragment {

    Button firstButton;
    EditText nameEditText;
    EditText surnameEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById();

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()) {
                    SecondFragment secondFragment = new SecondFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("nameValue", nameEditText.getText().toString());
                    bundle.putString("surnameValue", surnameEditText.getText().toString());
                    secondFragment.setArguments(bundle);
                    replaceFragment(secondFragment);
                } else {
                    Toast.makeText(requireContext(), "Пожалуйста заполните все поля",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void findViewById() {
        firstButton = requireActivity().findViewById(R.id.firstNextButton);
        nameEditText = requireActivity().findViewById(R.id.nameEditText);
        surnameEditText = requireActivity().findViewById(R.id.surnameEditText);
    }

    private boolean validateFields() {
        String nameValue = nameEditText.getText().toString();
        String surnameValue = surnameEditText.getText().toString();
        return !TextUtils.isEmpty(nameValue) && !TextUtils.isEmpty(surnameValue);
    }

    private void replaceFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.firstFragmentContainerView, fragment)
                .addToBackStack(null)
                .commit();
    }
}
