package com.example.cbe_teclwsp026.customlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Model> arrayList = new ArrayList<Model>();

    public static Boolean isSeleted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 50; i++)
        {
            Model model = new Model();
            model.setName("Title - " + i);
            model.setChecked(false);
            arrayList.add(model);
        }


        final Adapter adapter=new Adapter(this, arrayList);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

//        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
//        listView.setMultiChoiceModeListener(modeListener);


        adapter.notifyDataSetChanged();

        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_listview, null);





        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                isSeleted = true;
                adapter.notifyDataSetChanged();

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

//                for(int i =0 ; i < parent.getChildCount(); i++ )
//                {
//                    View cb = parent.getChildAt(i).findViewById(R.id.checkbox);
//
//                    if (cb.getVisibility() == View.VISIBLE)
//                        cb.setVisibility(View.GONE);
//                    else
//                        cb.setVisibility(View.VISIBLE);
//                }



                return true;
            }
        });



    }


//    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
//        @Override
//        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//
//
//        }
//
//        @Override
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            isSeleted = true;
//
//            return false;
//        }
//
//        @Override
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            return false;
//        }
//
//        @Override
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            return false;
//        }
//
//        @Override
//        public void onDestroyActionMode(ActionMode mode) {
//
//            isSeleted = false;
//
//        }
//    };


    class Adapter extends BaseAdapter{

        private Context context;
        private ArrayList<Model> maintitle;
        MyViewHolder holder;
        Boolean check_TAG = false;


        public Adapter(Context context, ArrayList<Model> maintitle) {
            this.context = context;
            this.maintitle = maintitle;
        }

        @Override
        public int getCount() {
            return maintitle.size();
        }

        @Override
        public Object getItem(int position) {
            return maintitle.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public int getItemViewType(int position) {

            if (maintitle.get(position).getChecked())
            {
                check_TAG = true;
            }

            return position;
        }

        @Override
        public View getView(final int position, View v, final ViewGroup parent) {

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


            holder.title.setText(maintitle.get(position).getName());

            final MyViewHolder finalHolder = holder;

            if (isSeleted){
                holder.checkBox.setVisibility(View.VISIBLE);
            }else {
                holder.checkBox.setVisibility(View.GONE);
            }


            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked)
                        maintitle.get(position).setChecked(true);

                    for (int i = 0; i < parent.getChildCount(); i++)
                    {
                         CheckBox cb = (CheckBox) parent.getChildAt(i).findViewById(R.id.checkbox);

                    }

                }
            });




            if (maintitle.get(position).getChecked())
            {
//                CheckBox cb = (CheckBox) parent.getChildAt(position).findViewById(R.id.checkbox);
//                cb.setChecked(true);
            }




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
