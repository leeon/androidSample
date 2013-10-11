package com.yui;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;


/**
 * @author Octobershiner
 * 2012 5 2 
 * 
 * */

public class PreferenceDemoActivity extends PreferenceActivity implements OnPreferenceChangeListener,OnPreferenceClickListener{

	/** Called when the activity is first created. */
	
	CheckBoxPreference isRemember ;
	EditTextPreference login ;
	ListPreference userType;
	PreferenceScreen check;
	Toast toast;
	Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.conf);
        
        context= this.getApplicationContext();
        
        /*get the wiget*/
        isRemember = (CheckBoxPreference)findPreference("isRemember");
        login = (EditTextPreference)findPreference("login");
        userType = (ListPreference)findPreference("userType");
        check = (PreferenceScreen)findPreference("check");
        
        /*set the listener*/
        isRemember.setOnPreferenceChangeListener(this);
        login.setOnPreferenceChangeListener(this);
        userType.setOnPreferenceChangeListener(this);
        check.setOnPreferenceClickListener(this);
    }

	public boolean onPreferenceChange(Preference preference, Object oValue) {
		// TODO Auto-generated method stub
		
		CharSequence message ="未监听事件";
		if(preference.equals(isRemember)){
			if(oValue.equals(Boolean.TRUE)){
				message = "您勾选了该选项";
			}else{
				message = "您取消了该选项";
			}
		

		}else if(preference.equals(login)){
			message = "您输入了"+oValue;
			
		}else if(preference.equals(userType)){
			message = "您选择的登录类型是"+oValue;
		}
		toast= Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.show();
		return true;
	}
    
    /* (non-Javadoc)
	 * @see android.preference.Preference.OnPreferenceClickListener#onPreferenceClick(android.preference.Preference)
	 */
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		if(preference.equals(check)){
			CharSequence message = "您点击了该选项";
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			toast.show();
		}
		return true;
	}
	
    
    
    
}