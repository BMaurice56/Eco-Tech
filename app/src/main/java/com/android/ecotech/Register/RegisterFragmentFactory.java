package com.android.ecotech.Register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.android.ecotech.Register.FragmentFactory;

public class RegisterFragmentFactory implements FragmentFactory {
    @Override
    public Fragment createFragment(String text) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }
}
