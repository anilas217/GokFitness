package com.example.gokfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class gridviewimage extends AppCompatActivity {
    GridView gridview;
    String[] ArmMove={"move1","move1","move2","move2"};
    int[] armimages={R.drawable.aaaaaa,R.drawable.aaaaaa,R.drawable.deluxe_oda_1, R.drawable.deluxe_oda_1};
    String[] chestmove={"move1","move1"};
    int[] chestimages={R.drawable.deluxe_oda_1,R.drawable.deluxe_oda_1};

    String[] shouldermove={"move1","move1"};
    int[] shoulderimages={R.drawable.deluxe_oda_1,R.drawable.deluxe_oda_1};

    String[] legmove={"move1","move1"};
    int[] legimages={R.drawable.deluxe_oda_1,R.drawable.deluxe_oda_1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridviewimage);
        gridview=findViewById(R.id.gridviewid);
        String type = getIntent().getStringExtra("TYPE");
           Customadapter customadapter=new Customadapter(type);
           gridview.setAdapter(customadapter);

    }

    private class Customadapter extends BaseAdapter {
       String tip;

        public Customadapter(String type) {
            tip=type;
        }

        @Override
        public int getCount() {
            if(tip.contentEquals("arm")){
                return armimages.length;
            }
            else if(tip.contentEquals("chest")){
                return chestimages.length;
            }
            else if(tip.contentEquals("shoulder")){
                return shoulderimages.length;
            }
            else if(tip.contentEquals("leg")){
                return legimages.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name=view1.findViewById(R.id.movetext);
            ImageView image=view1.findViewById(R.id.moveimage);
            if(tip.contentEquals("arm")){
                name.setText(ArmMove[i]);
                image.setImageResource(armimages[i]);
                return view1;
            }
            else if(tip.contentEquals("chest")){
                name.setText(chestmove[i]);
                image.setImageResource(chestimages[i]);
                return view1;
            }
            else if(tip.contentEquals("shoulder")){
                name.setText(shouldermove[i]);
                image.setImageResource(shoulderimages[i]);
                return view1;
            }
            else if(tip.contentEquals("leg")){
                name.setText(legmove[i]);
                image.setImageResource(legimages[i]);
                return view1;
            }


           return view1;

        }
    }
}