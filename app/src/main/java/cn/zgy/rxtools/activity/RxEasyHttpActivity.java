package cn.zgy.rxtools.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zgy.rxtool.RxLogTool;
import cn.zgy.rxtools.LoginEntity;
import cn.zgy.rxtools.R;
import cn.zgy.rxview.activity.ActivityBase;

public class RxEasyHttpActivity extends ActivityBase {


    @BindView(R.id.login)
    Button login;
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxeasyhttp);
        ButterKnife.bind(this);

    }

    private void login() {

        EasyHttp.post("/login")
                .params("username","yyf")
                .params("password", encode("jnvm4639"))
                .execute(new SimpleCallBack<LoginEntity>() {
                    @Override
                    public void onError(ApiException e) {
                        RxLogTool.e("error" + e);
                    }

                    @Override
                    public void onSuccess(LoginEntity loginEntity) {

                        RxLogTool.e(loginEntity.toString());
                        result.setText(loginEntity.toString());
                    }
                });


    }


    /**
     * 加密登录参数
     *
     * @param password
     */
    private String encode(String password) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (int i = 0; i < password.length(); i++) {
                String item = password.charAt(i) + "";
                String output = URLEncoder.encode(item.trim(), "UTF-8");
                if (output.equals(item)) {
                    output = Integer.toHexString(password.charAt(i));
                }
                stringBuilder.append(output);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        password = stringBuilder.toString().replaceAll("\\%", "").toUpperCase();
        return password;
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        login();
    }


}
