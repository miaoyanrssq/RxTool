package cn.zgy.rxtools.baseadapter.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import cn.zgy.baseadapter.BaseQuickAdapter;
import cn.zgy.baseadapter.BaseViewHolder;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.data.DataServer;
import cn.zgy.rxtools.baseadapter.entity.Status;
import cn.zgy.rxtools.baseadapter.util.ClickableMovementMethod;
import cn.zgy.rxtools.baseadapter.util.SpannableStringUtils;
import cn.zgy.rxtools.baseadapter.util.ToastUtils;
import cn.zgy.rxtools.baseadapter.util.Utils;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public AnimationAdapter() {
        super(R.layout.layout_animation, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.tweetText)).setFocusable(false);
        ((TextView) helper.getView(R.id.tweetText)).setClickable(false);
        ((TextView) helper.getView(R.id.tweetText)).setLongClickable(false);
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
