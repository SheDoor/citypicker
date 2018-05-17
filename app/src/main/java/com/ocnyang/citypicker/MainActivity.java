package com.ocnyang.citypicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ocnyang.citypicker.activity.CitypickerListActivity;
import com.ocnyang.citypicker.activity.CitypickerThreeListActivity;
import com.ocnyang.citypicker.activity.CitypickerWheelActivity;
import com.ocnyang.citypicker.adapter.CityPickerAdapter;
import com.ocnyang.citypicker.model.CityPickerStyleBean;
import com.ocnyang.citypicker.utils.ActivityUtils;
import com.ocnyang.citypicker.widget.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mCitypickerRv;

    CityPickerAdapter mCityPickerAdapter;

    String[] mTitle = new String[] { "城市列表", "ios选择器", "三级列表"/*, "仿京东"*/ };

    Integer[] mIcon = new Integer[] { R.drawable.ic_citypicker_onecity, R.drawable.ic_citypicker_ios,
            R.drawable.ic_citypicker_three_city/*, R.drawable.ic_citypicker_jingdong*/ };

    private List<CityPickerStyleBean> mCityPickerStyleBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setData();
        initRecyclerView();

    }

    private void findView() {
        mCitypickerRv = (RecyclerView) findViewById(R.id.citypicker_rv);
    }

    private void setData() {
        for (int i = 0; i < mTitle.length; i++) {
            CityPickerStyleBean cityPickerStyleBean = new CityPickerStyleBean();
            cityPickerStyleBean.setTitle(mTitle[i]);
            cityPickerStyleBean.setResourId(mIcon[i]);
            mCityPickerStyleBeanList.add(cityPickerStyleBean);
        }
    }

    private void initRecyclerView() {

        mCitypickerRv.addItemDecoration(new DividerGridItemDecoration(this));
        mCitypickerRv.setLayoutManager(new GridLayoutManager(this, 3));

        mCityPickerAdapter = new CityPickerAdapter(MainActivity.this, mCityPickerStyleBeanList);
        mCitypickerRv.setAdapter(mCityPickerAdapter);
        mCityPickerAdapter.setmOnItemClickListener(new CityPickerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (null != mCityPickerAdapter && null != mCityPickerAdapter.getData()
                        && !mCityPickerAdapter.getData().isEmpty()
                        && null != mCityPickerAdapter.getData().get(position)) {
                    gotoDetail(mCityPickerAdapter.getData().get(position).getResourId());
                }
            }
        });

    }

    /**
     * 选择相关样式
     * @param resourId
     */
    private void gotoDetail(int resourId) {
        switch (resourId) {
            case R.drawable.ic_citypicker_onecity:
                ActivityUtils.getInstance().showActivity(MainActivity.this, CitypickerListActivity.class);
                break;

            case R.drawable.ic_citypicker_ios:
                ActivityUtils.getInstance().showActivity(MainActivity.this, CitypickerWheelActivity.class);
                break;

            case R.drawable.ic_citypicker_three_city:
                ActivityUtils.getInstance().showActivity(MainActivity.this, CitypickerThreeListActivity.class);
                break;
            /*
            case R.drawable.ic_citypicker_jingdong:
                ActivityUtils.getInstance().showActivity(MainActivity.this, ProvinceActivity.class);
                break;
            */
            default:
                break;
        }
    }
}
