package cn.zgy.rxtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vise.log.ViseLog;
import com.vise.log.inner.ConsoleTree;
import com.vise.log.inner.FileTree;
import com.vise.log.inner.LogcatTree;

import cn.zgy.rxtool.RxAppTool;
import cn.zgy.rxtool.RxDataTool;
import cn.zgy.rxtool.RxTool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG){
            ViseLog.getLogConfig().configAllowLog(true)
                    .configShowBorders(true);
            ViseLog.plant(new FileTree(this, "Log"));
            ViseLog.plant(new ConsoleTree());
            ViseLog.plant(new LogcatTree());
        }
        test();
    }

    private void test() {
        ViseLog.e(RxTool.Md5("我的电脑"));
        ViseLog.e(RxAppTool.isSystemApp(this));
        ViseLog.e(RxDataTool.formatCard("384596845691"));
    }
}
