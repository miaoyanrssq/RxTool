package cn.zgy.rxtools.baseadapter.adapter;


import java.util.List;

import cn.zgy.baseadapter.BaseSectionQuickAdapter;
import cn.zgy.baseadapter.BaseViewHolder;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.entity.MySection;
import cn.zgy.rxtools.baseadapter.entity.Video;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param layoutResId      The layout resource id of each item.
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }


    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        Video video = (Video) item.t;
        switch (helper.getLayoutPosition() %
                2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;

        }
        helper.setText(R.id.tv, video.getName());
    }
}
