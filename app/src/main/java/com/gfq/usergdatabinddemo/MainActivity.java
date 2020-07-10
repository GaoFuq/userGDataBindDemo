package com.gfq.usergdatabinddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import com.gfq.gdatabind.RVBindingAdapter;
import com.gfq.gdatabind.SuperBindingViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userGDataBind();
    }

    private void userGDataBind() {
        //1.创建adapter
        RVBindingAdapter<TestBean> adapter = new RVBindingAdapter<TestBean>(this, BR.data) {
            @Override
            public void onBinding(SuperBindingViewHolder holder, TestBean currentPositionData, int position) {
                holder.itemView.setOnClickListener(v -> doClick());

//                ItemRvBinding binding = (ItemRvBinding) holder.getBinding();
//                binding.tvTitle.setText(currentPositionData.getTitle());
//                binding.ivImg.setImageURI(Uri.parse(currentPositionData.getUrl()));
            }

            @Override
            public int getLayoutId() {
                return R.layout.item_rv;
            }
        };

        //2.获取数据源
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestBean bean = new TestBean();
            bean.setTitle("xxx");
            bean.setTime(System.currentTimeMillis()+i*100);
//            bean.setUrl("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            bean.setUrl("http://t7.baidu.com/it/u=3269613503,3467228865&fm=193");
            list.add(bean);
        }
        adapter.setDataList(list);

        //设置适配器
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);

    }

    private void doClick() {

    }

}