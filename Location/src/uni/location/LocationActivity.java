/*  LocationActivity.java
 *  @author octobershiner
 *  2011 7 22
 *  SE.HIT
 *  一个演示定位用户的位置并且监听位置变化的代码
 * */
package uni.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;

public class LocationActivity extends Activity {
    /** Called when the activity is first created. */
	//创建lcoationManager对象
	private LocationManager manager;
	private static final String TAG = "LOCATION DEMO";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //获取系统的服务，
        manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //第一次获得设备的位置
        updateLocation(location);   
        //重要函数，监听数据测试
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10,   
                       locationListener);   
                       
    }
    /*此处更新一下，当activity不处于活动状态时取消GPS的监听*/
      public void onPause(){
       super.onPause();
       manager.removeUpdates(locationListener);
}

    //创建一个事件监听器
   private final LocationListener locationListener = new LocationListener() {   
            public void onLocationChanged(Location location) {   
            updateLocation(location);   
            }   
            public void onProviderDisabled(String provider){
            	updateLocation(null);   
            	Log.i(TAG, "Provider now is disabled..");
            }   
            public void onProviderEnabled(String provider){
            	Log.i(TAG, "Provider now is enabled..");
            }   
            public void onStatusChanged(String provider, int status,Bundle extras){ }   
    };   
    
//获取用户位置的函数，利用Log显示
    private void updateLocation(Location location) {   
            String latLng;    
            if (location != null) {  
            double lat = location.getLatitude();   
            double lng = location.getLongitude();
            
            latLng = "Latitude:" + lat + "  Longitude:" + lng;   
            } else {   
            latLng = "Can't access your location"; 
            }
            Log.i(TAG, "The location has changed..");
            Log.i(TAG, "Your Location:" +latLng);
    }
    
}