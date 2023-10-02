package com.example.foodapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodapp.fragments.FirstFragment;
import com.example.foodapp.fragments.FourthFragment;
import com.example.foodapp.fragments.SecondFragment;
import com.example.foodapp.fragments.ThirdFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
        }

        return new FirstFragment();

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
