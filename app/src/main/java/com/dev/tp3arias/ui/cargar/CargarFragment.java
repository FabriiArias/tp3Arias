package com.dev.tp3arias.ui.cargar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.dev.tp3arias.databinding.FragmentCargarBinding;



public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel vm; // Variable de instancia para tu ViewModel

    @Nullable // Buena práctica
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, // Buena práctica
                             @Nullable Bundle savedInstanceState) { // Buena práctica

        // Inicializa el ViewModel y asígnalo a la variable de instancia 'vm'
        vm = new ViewModelProvider(this).get(CargarViewModel.class); // <--- CORRECCIÓN AQUÍ

        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.etNombre.getText().toString();
                String codigo = binding.etCodigo.getText().toString();
                String descripcion = binding.etDescripcion.getText().toString();
                String precioCad = binding.etPrecio.getText().toString();

                vm.cargarProducto(nombre, codigo, descripcion, precioCad);
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
