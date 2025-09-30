package com.dev.tp3arias.ui.listar;

import static androidx.lifecycle.AndroidViewModel_androidKt.getApplication;
import static com.dev.tp3arias.MainActivity.productos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dev.tp3arias.Modelo.ProductoModelo;

import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends ViewModel {
    private MutableLiveData<List<ProductoModelo>> mutable;


    public ListarViewModel() {
        mutable = new MutableLiveData<>();

    }

    public LiveData<List<ProductoModelo>> getMutable() {
        if (mutable == null) {
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    public void cargarLista() {
        productos.sort(new Comparator<ProductoModelo>() {
            @Override
            public int compare(ProductoModelo o1, ProductoModelo o2) {
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }
        });
        mutable.setValue(productos);
    }

}