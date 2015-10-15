package com.example.dm2.listview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ItemWeb[] datos =
            new ItemWeb[]{
                    new ItemWeb("Google", "http://www.google.es", R.drawable.googlelogo),
                    new ItemWeb("Yahoo", "http://www.yahoo.es", R.drawable.yahoo)
            };

    AdaptadorItemWeb adaptador;
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptador = new AdaptadorItemWeb(this, datos);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String URL_destino = ((TextView)view.findViewById(R.id.enlace)).getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_destino));

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class AdaptadorItemWeb extends ArrayAdapter<ItemWeb> {

        public AdaptadorItemWeb(Context context, ItemWeb[] datos) {
            super(context, R.layout.list_itemweb, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_itemweb, null);

            TextView titulo = (TextView)item.findViewById(R.id.titulo);
            titulo.setText(datos[position].getTitulo());

            TextView enlace = (TextView)item.findViewById(R.id.enlace);
            enlace.setText(datos[position].getEnlace());

            ImageView logo = (ImageView)item.findViewById(R.id.logo);
            logo.setImageResource(datos[position].getLogo());

            return(item);
        }
    }
}
