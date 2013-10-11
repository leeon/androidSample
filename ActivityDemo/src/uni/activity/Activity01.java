/*
 * @author octobershiner
 * 2011 07 29
 * SE.HIT
 * 演示完整的activity的声明周期，以及isFinish方法的调用 
 * 此activity可由ActivityDemoActivity启动
 * */

package uni.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Activity01 extends Activity{
    private static final String TAG = "demo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		Log.d(TAG, "The activity01 state---->onStart");
	}
	
	
	 protected void onStart(){
	    	super.onStart();
	    	Log.d(TAG, "The activity01 state---->onStart");
	    }
	    
	    protected void onRestart(){
	    	super.onRestart();
	    	Log.d(TAG, "The activity01 state---->onReatart");
	    }

	    protected void onResume(){
	    	super.onResume();
	    	Log.d(TAG, "The activity01 state---->onResume");
	    }

	    protected void onPause(){
	    	super.onPause();
	    	Log.d(TAG, "The activity01 state---->onPause");
	    	//调用isFinishing方法，判断activity是否要销毁
	    	if(isFinishing()){
	    		Log.w(TAG, "The activity01 will be destroyed!");
	    	}else{
	    		Log.w(TAG, "The activity01 is just pausing!");
	    	}
	    	
	    }

	    protected void onStop(){
	    	super.onStop();

	    	Log.d(TAG, "The activity01 state---->onStop");
	    }

	    protected void onDestroy(){
	    	super.onDestroy();
	    	Log.d(TAG, "The activity01 state---->onDestroy");
	    }
	    

}
