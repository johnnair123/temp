package com.example.adapterdisplay;
import android.os.Bundle;
import android.view.LayoutInflater; import android.view.View;
import android.view.ViewGroup; import android.widget.TextView;
import androidx.activity.EdgeToEdge; import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity; import
androidx.recyclerview.widget.LinearLayoutManager; import
androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList; import java.util.List;
class City {
private String name; private String temp;
public City(String name, String temp){ this.name=name;
this.temp=temp; }
public String getName(){ return name; }
public String getTemp(){ return temp; }}
class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> { private
List<City> cities;
public CityAdapter(List<City> cities){ this.cities=cities; }
@NonNull @Override
public CityAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
viewType) { View v= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent,false);
return new CityViewHolder(v); }
public void onBindViewHolder(CityViewHolder holder, int p){ City c=cities.get(p);
holder.c_name.setText(c.getName());
try{
String t=c.getTemp(); holder.c_temp.setText(t);
} catch (Exception e) { holder.c_temp.setText("Temperature missing"); } }
public int getItemCount() { return cities.size(); }
static class CityViewHolder extends RecyclerView.ViewHolder{ TextView c_name, c_temp;
public CityViewHolder(@NonNull View itemView) { super(itemView);
c_name=itemView.findViewById(android.R.id.text1);
c_temp=itemView.findViewById(android.R.id.text2); } }}
public class MainActivity extends AppCompatActivity { RecyclerView rv;
CityAdapter ca;
List<City> cl = new ArrayList<>();
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
EdgeToEdge.enable(this); setContentView(R.layout.activity_main);
rv=findViewById(R.id.recycleview); rv.setLayoutManager(new
LinearLayoutManager(this));
cl.add(new City("Pune", "31°C"));
cl.add(new City("Gurgaon", "30°C"));
cl.add(new City("Alappuzha", "29°C"));
cl.add(new City("Kochi", "30°C"));
cl.add(new City("Chennai", "28°C"));
ca=new CityAdapter(cl); rv.setAdapter(ca); }}
