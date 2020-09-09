package com.geo.example.materialsample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.geo.example.materialsample.share.OnResponseListener;
import com.geo.example.materialsample.share.WXShare;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlowerActivity extends BaseActivity {
    public static final String FLOWER_NAME = "flower_name";
    public static final String FLOWER_IMAGE_ID = "flower_image_id";
    private static final String TAG = "FlowerActivity";
    @BindView(R.id.app_bar_image)
    ImageView appBarImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.flower_content_text)
    TextView flowerContentText;
    @BindView(R.id.comment_share)
    FloatingActionButton commentShare;
    private WXShare wxShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String flowerName = intent.getStringExtra(FLOWER_NAME);
        int flowerImageId = intent.getIntExtra(FLOWER_IMAGE_ID, 0);
        Log.d(TAG, "flowerName: " + flowerName);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(flowerName);
        Glide.with(this).load(flowerImageId).into(appBarImage);
        String flowerContent = generateFruitContent(flowerName);
        flowerContentText.setText(flowerContent);
        wxShare = new WXShare(this);
        wxShare.setListener(new OnResponseListener() {
            @Override
            public void onSuccess() {
                showToast("WXShare Success");
            }

            @Override
            public void onCancel() {
                showToast("WXShare Cancel");
            }

            @Override
            public void onFail(String message) {
                showToast("WXShare failed: " + message);
            }
        });


    }

    private String generateFruitContent(String flowerName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(flowerName);
        }
        return fruitContent.toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        wxShare.register();
    }

    @Override
    protected void onDestroy() {
        wxShare.unregister();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.comment_share)
    public void onViewClicked() {
//        wxShare.share("分享到微信示例");
//        wxShare.shareImage(null);
        wxShare.shareVideo("http://www.baidu.com","标题","描述");
    }
}