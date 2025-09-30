package com.dev.tp3arias.ui.cargar;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.tp3arias.Modelo.ProductoModelo;

import java.util.List;
import static com.dev.tp3arias.MainActivity.*;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutable;

    public CargarViewModel(@NonNull Application aplication) {
        super(aplication);
    }

    public LiveData getMutable(){
        if (mutable == null){
            mutable = new MutableLiveData<String>();
        }
        return mutable;
    }

    public void cargarProducto(String nombre, String codigo, String descripcion, String precioCad){

        if (nombre.isEmpty() || codigo.isEmpty() || descripcion.isEmpty() || precioCad.isEmpty()) {
            Toast.makeText(getApplication(), "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
            return;
        }
        double precio;
        try {
            precio = Double.parseDouble(precioCad);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplication(), "El precio debe ser un número válido", Toast.LENGTH_LONG).show();
            return;
        }

        ProductoModelo p = new ProductoModelo(nombre, codigo, descripcion, precio);

        if (productos.contains(p)){
            Toast.makeText(getApplication(), "El codigo del producto esta duplicado", Toast.LENGTH_LONG).show();
            return;
        }

        productos.add(p);
        Toast.makeText(getApplication(), "Producto cargado con exito", Toast.LENGTH_SHORT).show();

    }





}