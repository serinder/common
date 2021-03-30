package com.jaydenxiao.common.commonutils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

public class PreferenceUtil {
//	private Context mContext;
	private static final int PRIVATE_MODE = ContextWrapper.MODE_PRIVATE;
//	private static SharedPreferences preferences;
	private static final String PREF = "meishi";

//	public PreferenceUtil(Context context) {
//		mContext = context;
//		preferences = new ContextWrapper(mContext).getSharedPreferences(PREF, PRIVATE_MODE);
//	}

	public static boolean savePreferenceLong(Context context,String PrefKey, long PrefValue) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putLong(PrefKey, PrefValue);
			editor.commit();
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	public static boolean savePreferenceInt(Context context,String PrefKey, Integer PrefValue) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt(PrefKey, PrefValue);
			editor.commit();
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	public static boolean savePreferenceBoolean(Context context,String PrefKey, boolean PrefValue) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putBoolean(PrefKey, PrefValue);
			editor.commit();
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	public static boolean savePreferenceStr(Context context,String PrefKey, String PrefValue) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putString(PrefKey, PrefValue);
			editor.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static long getPreferenceLong(Context context,String RefKey) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			return preferences.getLong(RefKey, 0);
		} catch (Exception ee) {
			return 0;
		}
	}

	public static Integer getPreferenceInt(Context context,String RefKey) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			return preferences.getInt(RefKey, 0);
		} catch (Exception ee) {
			return 0;
		}
	}

	public static boolean getPreferenceBoolean(Context context,String RefKey) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			return preferences.getBoolean(RefKey, false);
		} catch (Exception ee) {
			return false;
		}
	}

	public static String getPreferenceStr(Context context,String RefKey) {
		try {
			SharedPreferences preferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
			return preferences.getString(RefKey, "");
		} catch (Exception ee) {
			return "";
		}
	}
}
