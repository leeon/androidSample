/*
 * @author octobershiner
 * 2011 07 29
 * SE.HIT
 * 演示完整的activity的声明周期，以及isFinish方法的调用 
 * 此activity为程序入口activity
 * */
package uni.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ActivityDemoActivity extends Activity {
    /** Called when the activity is first created. */
	
	private static final String TAG = "demo";
	private Button button_A;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button_A = (Button)this.findViewById(R.id.Button_A);
        button_A.setOnClickListener(new myButtonListener());
    }

    
   private class myButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(ActivityDemoActivity.this, Activity01.class);
			ActivityDemoActivity.this.startActivity(intent);
			
			//感兴趣的朋友可以取消下面的代码注释，来测试finish方法的使用，会发现第一个activity会被强制终止
			//ActivityDemoActivity.this.finish();
		}
    	
    };
    
    protected void onStart(){
    	super.onStart();
    	Log.i(TAG, "The activityDemo state---->onStart");
    }
    
    protected void onRestart(){
    	super.onRestart();
    	Log.i(TAG, "The activityDemo state---->onReatart");
    }

    protected void onResume(){
    	super.onResume();
    	Log.i(TAG, "The activityDemo state---->onResume");
    }

    protected void onPause(){
    	super.onPause();
    	//调用isFinishing方法，判断activity是否要销毁
    	Log.i(TAG, "The activityDemo state---->onPause");
    	if(isFinishing()){
    		Log.w(TAG, "The activityDemo will be destroyed!");
    	}else{
    		Log.w(TAG, "The activityDemo is just pausing!");
    	}
    	
    }

    protected void onStop(){
    	super.onStop();

    	Log.i(TAG, "The activityDemo state---->onStop");
    }

    protected void onDestroy(){
    	super.onDestroy();
    	Log.i(TAG, "The activityDemo state---->onDestroy");
    }

    
}