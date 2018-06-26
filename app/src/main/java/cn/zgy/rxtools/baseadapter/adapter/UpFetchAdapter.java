package cn.zgy.rxtools.baseadapter.adapter;


import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.base.BaseDataBindingAdapter;
import cn.zgy.rxtools.baseadapter.entity.Movie;
import cn.zgy.rxtools.databinding.ItemMovieBinding;

/**
 * Created by tysheng
 * Date: 2017/5/25 10:47.
 * Email: tyshengsx@gmail.com
 */

public class UpFetchAdapter extends BaseDataBindingAdapter<Movie, ItemMovieBinding> {
    public UpFetchAdapter() {
        super(R.layout.item_movie, null);
    }

    @Override
    protected void convert(ItemMovieBinding binding, Movie item) {
        binding.setMovie(item);
    }
}
