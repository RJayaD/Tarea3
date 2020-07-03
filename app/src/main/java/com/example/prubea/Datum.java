package com.example.prubea;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Datum {
    private String ofertaLaboral;
    private String empresa;
    private String cargo;
    private String correo;
    private String descripcion;
    private String imagen;

    public Datum(JSONObject a)throws JSONException{
        ofertaLaboral = a.getString("OfertaLaboral").toString();
        empresa = a.getString("Empresa").toString();
        cargo = a.getString("Cargo").toString();
        correo = a.getString("Correo").toString();
        descripcion = a.getString("Descripcion").toString();
        imagen = a.getString("Imagen").toString();
    }

    public static  ArrayList<Datum> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Datum> data = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            data.add(new Datum(datos.getJSONObject(i)));
        }
        return data;
    }

    public String getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(String ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
