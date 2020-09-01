package com.geo.example.materialsample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Flower[] flowers = {
            new Flower("梅花", R.drawable.ic_meihua), new Flower("牵牛花", R.drawable.ic_qianniuhua),
            new Flower("荷包花",R.drawable.ic_hebaohua),new Flower("睡莲",R.drawable.ic_shuilian),
            new Flower("洋绣球",R.drawable.ic_yangxiuqiu),new Flower("朱顶红",R.drawable.ic_zhudinghong),
            new Flower("宝莲灯",R.drawable.ic_baoliandeng),new Flower("波斯菊",R.drawable.ic_bosiju),
            new Flower("长寿花",R.drawable.ic_changshouhua),new Flower("石竹",R.drawable.ic_shizhu),
            new Flower("太阳花",R.drawable.ic_taiyanghua),new Flower("昙花",R.drawable.ic_tanhua),
            new Flower("仙客来",R.drawable.ic_xiankelai)
    };

    private List<Flower> flowerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initFlowers();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        FlowerAdapter adapter = new FlowerAdapter(flowerList);
        recyclerView.setAdapter(adapter);

    }

    private void initFlowers(){
        flowerList.clear();
        for (int i = 0;i < 50;i++){
            Random random = new Random();
            int index = random.nextInt(flowers.length);
            flowerList.add(flowers[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}