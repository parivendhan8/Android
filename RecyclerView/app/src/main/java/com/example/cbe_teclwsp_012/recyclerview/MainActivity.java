package com.example.cbe_teclwsp_012.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList_name;
    RecyclerView recyclerView;
    private CheckBox checkBox;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList_name = new ArrayList<String>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        for (int i = 1; i < 50; i++) {
            arrayList_name.add(" Name :" + i);
        }

        adapter = new Adapter(MainActivity.this, arrayList_name, new Adapter.Myinterface() {
            @Override
            public void onClick(Boolean pos) {

                if (pos) {
                    int count = recyclerView.getChildCount();

                    for (int i = 0; i < count; i++) {
                        checkBox = (CheckBox) recyclerView.getChildAt(i).findViewById(R.id.checkbox);

                        if (checkBox.getVisibility() == View.VISIBLE) {
                            checkBox.setVisibility(View.INVISIBLE);
                        } else {
                            checkBox.setVisibility(View.VISIBLE);
                        }

                    }

                }

            }
        });
        recyclerView.setAdapter(adapter);


    }


    static class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

        Context context;
        ArrayList<String> list;
        Myinterface myinterface;


        public Adapter(Context context, ArrayList<String> list, Myinterface myinterface) {
            this.context = context;
            this.list = list;
            this.myinterface = myinterface;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(context).inflate(R.layout.custom_listview, null);
            return new Adapter.MyViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {

            holder.name.setText(list.get(i));
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myinterface.onClick(true);
                    int count = Adapter.this.getItemCount();

//                    for (int i = 0; i < count; i++) {
//                        if (holder.checkbox.getVisibility() == View.VISIBLE) {
//                            holder.checkbox.setVisibility(View.GONE);
//                        } else {
//                            holder.checkbox.setVisibility(View.VISIBLE);
//                        }
//                    }

                }
            });


        }


        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            CheckBox checkbox;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                name = (TextView) itemView.findViewById(R.id.name);
                checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);

            }
        }

        interface Myinterface {
            void onClick(Boolean pos);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.list_menu:
//                for(int i = 0;  i < recyclerView.getChildCount(); i++)
//                {
//                    checkBox = (CheckBox)recyclerView.getChildAt(i).findViewById(R.id.checkbox);
//                    checkBox.setVisibility(View.INVISIBLE);
//                }


        }

        return super.onOptionsItemSelected(item);
    }
}
