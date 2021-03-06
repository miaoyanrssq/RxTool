package cn.zgy.rxview.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import cn.zgy.rxtool.RxLocationTool;
import cn.zgy.rxtool.RxVibrateTool;
import cn.zgy.rxtool.model.Gps;
import cn.zgy.rxview.view.RxToast;
import cn.zgy.rxview.view.dialog.RxDialogGPSCheck;
import cn.zgy.rxview.view.dialog.RxDialogTool;


/**
 * @author vondear
 */
public abstract class ActivityBaseLocation extends ActivityBase {

    //经度
    public double mLongitude = 0;
    //纬度
    public double mLatitude = 0;

    public Gps mGps;

    public LocationManager mLocationManager;
    private LocationListener mLocationListener;

    public abstract void setGpsInfo(Location location);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGPS();//初始化GPS
        gpsCheck();//GPS开启状态检测
    }

    private void initGPS() {
        mLocationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
    }

    //----------------------------------------------------------------------------------------------检测GPS是否已打开 start
    protected void gpsCheck() {
        if (!RxLocationTool.isGpsEnabled(this)) {
            RxDialogGPSCheck rxDialogGPSCheck = new RxDialogGPSCheck(mContext);
            rxDialogGPSCheck.show();
        } else {
            getLocation();
        }
    }
    //==============================================================================================检测GPS是否已打开 end

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            RxDialogTool.initDialogSurePermission(mContext, "请先打开GPS定位权限");
            return;
        }
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                mLongitude = location.getLongitude();
                mLatitude = location.getLatitude();
                mGps = new Gps(mLongitude, mLatitude);
                setGpsInfo(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                switch (status) {
                    //GPS状态为可见时
                    case LocationProvider.AVAILABLE:

                        break;
                    //GPS状态为服务区外时
                    case LocationProvider.OUT_OF_SERVICE:
                        RxToast.normal("当前GPS信号弱");
                        RxVibrateTool.vibrateOnce(mContext, 3000);
                        break;
                    //GPS状态为暂停服务时
                    case LocationProvider.TEMPORARILY_UNAVAILABLE:

                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onProviderEnabled(String provider) {
                RxToast.normal("当前GPS设备已打开");
                RxVibrateTool.vibrateOnce(mContext, 800);
            }

            @Override
            public void onProviderDisabled(String provider) {
                RxToast.normal("当前GPS设备已关闭");
                RxVibrateTool.vibrateOnce(mContext, 800);
                gpsCheck();
            }
        };
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, mLocationListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLocationListener != null) {
            mLocationManager.removeUpdates(mLocationListener);
        }
    }
}
