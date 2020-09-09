package com.geo.example.materialsample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


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
    @BindView(R.id.floatingActionBtn)
    FloatingActionButton floatingActionBtn;

    private Flower[] flowers = {
            new Flower("梅花", R.drawable.ic_meihua), new Flower("牵牛花", R.drawable.ic_qianniuhua),
            new Flower("荷包花", R.drawable.ic_hebaohua), new Flower("睡莲", R.drawable.ic_shuilian),
            new Flower("洋绣球", R.drawable.ic_yangxiuqiu), new Flower("朱顶红", R.drawable.ic_zhudinghong),
            new Flower("宝莲灯", R.drawable.ic_baoliandeng), new Flower("波斯菊", R.drawable.ic_bosiju),
            new Flower("长寿花", R.drawable.ic_changshouhua), new Flower("石竹", R.drawable.ic_shizhu),
            new Flower("太阳花", R.drawable.ic_taiyanghua), new Flower("昙花", R.drawable.ic_tanhua),
            new Flower("仙客来", R.drawable.ic_xiankelai)
    };

    private List<Flower> flowerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initFlowers();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //解决item跳动
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        recyclerView.setLayoutManager(layoutManager);
        FlowerAdapter adapter = new FlowerAdapter(flowerList);
        recyclerView.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void initFlowers() {
        flowerList.clear();
        for (int i = 0; i < 50; i++) {
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
        switch (item.getItemId()) {
            case R.id.toolbar_setting:
                Toast.makeText(MainActivity.this, "show messagee", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_open:
                showToast("You Click open button");
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @OnClick(R.id.floatingActionBtn)
    public void onViewClicked(View view) {
        Snackbar.make(view,"Data Removed",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Data restored", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}