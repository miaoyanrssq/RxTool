package cn.zgy.rxtools.baseadapter.adapter;


import java.util.List;

import cn.zgy.baseadapter.BaseQuickAdapter;
import cn.zgy.baseadapter.BaseViewHolder;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.entity.HomeItem;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    public HomeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
