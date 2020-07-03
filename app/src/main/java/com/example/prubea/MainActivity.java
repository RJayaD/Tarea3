package com.example.prubea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Clase();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
   public void Clase() throws JSONException {
       String myJsonString= "{\n" +
               "   \"data\":[\n" +
               "      {\n" +
               "         \"OfertaLaboral\":\"Limpieza y desinfección\",\n" +
               "         \"Empresa\":\"Produaseo\",\n" +
               "         \"Cargo\":\"Conserje\",\n" +
               "         \"Correo\":\"produaseo@gmail.com\",\n" +
               "         \"Descripcion\":\"Se requiere personal para limpieza de las oficinas para los diferentes departamentos de un edificio de 4 pisos\",\n" +
               "         \"Imagen\":\"https://i.ibb.co/0jgvzMN/produaseo-opt.jpg\"\n" +
               "      },\n" +
               "      {\n" +
               "         \"OfertaLaboral\":\"Desarrollo de programas en cualquier lenguaje web\",\n" +
               "         \"Empresa\":\"Grupo Manobanda\",\n" +
               "         \"Cargo\":\"Tecnólogo o Ingeniero de sistemas\",\n" +
               "         \"Correo\":\"rrhh@grupomanobanda.com\",\n" +
               "         \"Descripcion\":\"Soporte al usuario en hardware y software, conocimientos en utilitarios microsoft, lenguajes de programación, base de datos, contabilidad básica, redes.\",\n" +
               "         \"Imagen\":\"https://i.ibb.co/FVX6gPd/delindecsa-opt.png\"\n" +
               "      },\n" +
               "      {\n" +
               "         \"OfertaLaboral\":\"Contador - Finanzas\",\n" +
               "         \"Empresa\":\"Multiglobal\",\n" +
               "         \"Cargo\":\"Administrador de Sistema Contable Fenix\",\n" +
               "         \"Correo\":\"sin correo\",\n" +
               "         \"Descripcion\":\"Requerimos una persona que lleve la contabilidad diaria, lleve las cuentas de toda la activad de la empresa un registo ordenado, planificado , detallado en un sistema contable propio llamado FENIX\",\n" +
               "         \"Imagen\":\"https://i.ibb.co/7K1sLxS/multiglobal-opt.jpg\"\n" +
               "      },\n" +
               "      {\n" +
               "         \"OfertaLaboral\":\"Supervisor de Control de Calidad\",\n" +
               "         \"Empresa\":\"dianafood\",\n" +
               "         \"Cargo\":\"Bioquimico Farmacéutico\",\n" +
               "         \"Correo\":\"sin correo\",\n" +
               "         \"Descripcion\":\"Desempeñará funciones de Supervisor en el área de Control de Calidad para el proceso de validación, inspección y control de materias primas, material de envase-empaque, entre otras funciones\",\n" +
               "         \"Imagen\":\"https://i.ibb.co/V30fVzx/dianafood-opt.png\"\n" +
               "      },\n" +
               "      {\n" +
               "         \"OfertaLaboral\":\"Gerente de producción de salsas\",\n" +
               "         \"Empresa\":\"Embuandes\",\n" +
               "         \"Cargo\":\"Ingeniería en Alimentos\",\n" +
               "         \"Correo\":\"sin correo\",\n" +
               "         \"Descripcion\":\"Técnico con experiencia para la elaboración de salsas y aderezos, mínimo experiencia 8 años, debe conocer sobre la compra de maquinaria, formulación y mas.\",\n" +
               "         \"Imagen\":\"https://i.ibb.co/TtDD6YX/embuandes-opt.jpg\"\n" +
               "      }\n" +
               "   ]\n" +
               "}";
       JSONObject JSONlista =  new JSONObject();
       JSONlista = new JSONObject(myJsonString);
       JSONArray JSONArray=  JSONlista.getJSONArray("data");
       ArrayList<Datum> data = Datum.JsonObjectsBuild(JSONArray);
       recyclerView=(RecyclerView)findViewById(R.id.Rec_Anuncio);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapterRecycler= new AdapterRecycler(data);
       recyclerView.setAdapter(adapterRecycler);
   }
}