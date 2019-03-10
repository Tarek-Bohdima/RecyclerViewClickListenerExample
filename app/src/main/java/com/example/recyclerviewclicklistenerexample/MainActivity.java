package com.example.recyclerviewclicklistenerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

// by https://hackernoon.com/android-recyclerview-onitemclicklistener-getadapterposition-a-better-way-3c789baab4db
// https://github.com/RohitSurwase/RvClickListenerExample

public class MainActivity extends AppCompatActivity {
    private ArrayList<TestItem> mTestItemList;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            TestItem thisItem = mTestItemList.get(position);
            Toast.makeText(MainActivity.this, "You Clicked " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        initDummyData();

        MyRecyclerAdapter recyclerViewAdapter = new MyRecyclerAdapter(mTestItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        //TODO: Step 1 of 4: Create and set OnItemClickListener to the adapter.
        recyclerViewAdapter.setOnItemClickListener(onItemClickListener);
    }

    private void initDummyData() {
        mTestItemList = new ArrayList<>();
        TestItem testItem;

        for (int i = 1; i < 17; i++) {
            testItem = new TestItem("Test Item " + i , "This is test item " + i);
            mTestItemList.add(testItem);
        }
    }
}
