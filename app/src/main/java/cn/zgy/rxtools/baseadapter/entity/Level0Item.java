package cn.zgy.rxtools.baseadapter.entity;


import cn.zgy.baseadapter.entity.AbstractExpandableItem;
import cn.zgy.baseadapter.entity.MultiItemEntity;
import cn.zgy.rxtools.baseadapter.adapter.ExpandableItemAdapter;

/**
 * Created by luoxw on 2016/8/10.
 */
public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    public String title;
    public String subTitle;

    public Level0Item( String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
