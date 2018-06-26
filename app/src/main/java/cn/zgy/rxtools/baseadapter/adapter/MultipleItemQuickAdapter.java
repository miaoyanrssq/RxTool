package cn.zgy.rxtools.baseadapter.adapter;

import android.content.Context;

import java.util.List;

import cn.zgy.baseadapter.BaseMultiItemQuickAdapter;
import cn.zgy.baseadapter.BaseViewHolder;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.entity.MultipleItem;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 * modify by AllenCoder
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    public MultipleItemQuickAdapter(Context context, List data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
        addItemType(MultipleItem.IMG, R.layout.item_image_view);
        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG_TEXT:
                switch (helper.getLayoutPosition() %
                        2) {
                    case 0:
//                        helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                        helper.setImageUrl(R.id.iv, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529920283889&di=5f054a6a8121fde4d0a74ff0b6df371a&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8718367adab44aed5b24056fbf1c8701a08bfbd7.jpg");
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                        break;

                }
                break;
        }
    }

}
