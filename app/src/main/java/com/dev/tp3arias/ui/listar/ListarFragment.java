package com.dev.tp3arias.ui.listar;

import static com.dev.tp3arias.MainActivity.productos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Grid;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.dev.tp3arias.Modelo.ProductoModelo;
import com.dev.tp3arias.ProductoAdapter;
import com.dev.tp3arias.databinding.FragmentListarBinding;

import java.util.List;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel lvm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListarViewModel lvm =
                new ViewModelProvider(this).get(ListarViewModel.class);

        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        lvm.getMutable().observe(getViewLifecycleOwner(), new Observer<List<ProductoModelo>>() {
            @Override
            public void onChanged(List<ProductoModelo> productoModelos) {
                ProductoAdapter productoAdapter = new ProductoAdapter(getContext(), productos, getLayoutInflater());
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.lista.setLayoutManager(glm);
                binding.lista.setAdapter(productoAdapter);

            }
        });
        lvm.cargarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}