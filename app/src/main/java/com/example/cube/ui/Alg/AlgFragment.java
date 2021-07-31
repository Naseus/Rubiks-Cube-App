package com.example.cube.ui.Alg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cube.databinding.FragmentAlgBinding;
import com.example.cube.models.Algorithm;

public class AlgFragment extends Fragment {

    private AlgModel galleryViewModel;
    private FragmentAlgBinding binding;

    private RecyclerView rvAlgs = binding.rvAlgs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(AlgModel.class);

        binding = FragmentAlgBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.Adapter algs_adapter = new AlgorithmAdapter();
        rvAlgs.setAdapter(algs_adapter);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}