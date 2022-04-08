package com.example.android2hm1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2hm1.R;
import com.example.android2hm1.ui.adapter.BoardAdapter;
import com.example.android2hm1.databinding.FragmentOnBoardBinding;
import com.example.android2hm1.utils.interfaces.ItemClickListener;
import com.example.android2hm1.data.model.BoardClient;
import com.example.android2hm1.data.model.BoardModel;

import java.util.ArrayList;

public class OnBoardFragment extends Fragment {
    FragmentOnBoardBinding binding;
    BoardAdapter adapter;
    ArrayList<BoardModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
    }

    private void initAdapter() {
        list = BoardClient.getList();
        adapter = new BoardAdapter(list, new ItemClickListener() {
            @Override
            public void itemClick(int position) {
                if (position == 0 || position == 1) {
                    binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
                } else {
                    Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
                }
            }
        });
        binding.pager.setAdapter(adapter);
        binding.wormDot.setViewPager2(binding.pager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        list.clear();
    }
}