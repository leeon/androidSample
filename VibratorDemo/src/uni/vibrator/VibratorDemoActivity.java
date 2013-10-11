/*
 * @author octobershiner
 * 2011 7 25
 * SE.HIT
 * 一个使用android手机震动的demo
 * */
package uni.vibrator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;

public class VibratorDemoActivity extends Activity {
	private Vibrator vibrator;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
         * 想设置震动大小可以通过改变pattern来设定，如果开启时间太短，震动效果可能感觉不到
         * */
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        long [] pattern = {100,400,100,400};   // 停止 开启 停止 开启 
        vibrator.vibrate(pattern,2);           //重复两次上面的pattern 如果只想震动一次，index设为-1 
    }
    
    public void onStop(){
    	super.onStop();
    	vibrator.cancel();
    }
}