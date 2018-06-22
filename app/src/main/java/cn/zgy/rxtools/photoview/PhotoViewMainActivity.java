package cn.zgy.rxtools.photoview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.zgy.rxtools.R;


/**
 * Created by liuheng on 2015/6/21.
 */
public class PhotoViewMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoviewmain);
    }

    public void img(View view) {
        startActivity(new Intent(this, ImgActivity.class));
    }

    public void viewpager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void imgclick(View view) {
        startActivity(new Intent(this, ImgClick.class));
    }

    public void photobrowse(View view) {
        startActivity(new Intent(this, PhotoBrowse.class));
    }

    public void imageview(View view) {
        startActivity(new Intent(this, ImageViewActivity.class));
    }
}
