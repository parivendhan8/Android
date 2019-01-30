package com.example.cbe_teclwsp026.customlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] maintitle ={
            "Title 1","Title 2", "Title 3","Title 4", "Title 5", "Title 3","Title 4",
            "Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5"
    ,"Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5"
    ,"Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5", "Title 3","Title 4", "Title 5"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Adapter adapter=new Adapter(this, maintitle);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_listview, null);





        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


//                view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                    @Override
//                    public void onFocusChange(View v, boolean hasFocus) {
//                        v = v.findViewById(R.id.checkbox);
//                        if (v.getVisibility() == View.VISIBLE)
//                        {
//                            v.setVisibility(View.GONE);
//                        }
//                        else
//                        {
//                            v.setVisibility(View.VISIBLE);
//                        }
//                    }
//                });




                for(int i =0 ; i < parent.getChildCount(); i++ )
                {
                    View cb = parent.getChildAt(i).findViewById(R.id.checkbox);

                    if (cb.getVisibility() == View.VISIBLE)
                        cb.setVisibility(View.GONE);
                    else
                        cb.setVisibility(View.VISIBLE);
                }



                return true;
            }
        });



    }

    class Adapter extends BaseAdapter{

        private Context context;
        private String[] maintitle;
        MyViewHolder holder;

        public Adapter(Context context, String[] maintitle) {
            this.context = context;
            this.maintitle = maintitle;
        }

        @Override
        public int getCount() {
            return maintitle.length;
        }

        @Override
        public Object getItem(int position) {
            return maintitle[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public View getView(int position, View v, final ViewGroup parent) {



            if (v == null)
            {
                v = LayoutInflater.from(context).inflate(R.layout.custom_listview, null);
                holder = new MyViewHolder(v);
                v.setTag(holder);
            }
            else
            {
                holder = (MyViewHolder) v.getTag();
            }

            holder.title.setText(maintitle[position]);

            final MyViewHolder finalHolder = holder;

//            holder.title.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View w) {
//
//                    finalHolder.checkBox.setVisibility(View.VISIBLE);
//
//                for(int i =0 ; i < parent.getChildCount(); i++ )
//                {
//                    View cb = parent.getChildAt(i).findViewById(R.id.checkbox);
//
//                    if (cb.getVisibility() == View.VISIBLE)
//                        cb.setVisibility(View.GONE);
//                    else
//                        cb.setVisibility(View.VISIBLE);
//                }
//
//                notifyDataSetChanged();


//                    return true;
//                }
//            });


            return v;
        }



        class MyViewHolder{

            TextView title;
            CheckBox checkBox;

            MyViewHolder(View view)
            {
                title = (TextView) view.findViewById(R.id.title);
                checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            }

        }
    }




}
