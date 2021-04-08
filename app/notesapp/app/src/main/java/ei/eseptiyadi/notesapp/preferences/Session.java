package ei.eseptiyadi.notesapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    static final String USERNAME_KEY = "sesi_username";
    static final String PASSWORD_KEY = "sesi_pwd";
    static final String HASH_KEY = "sesi_hash";
    static final String LVL_KEY = "sesi_lvl";

    // Instanstiate Shared Preferences
    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    // Set Username
    public static void setRegisesi_User(Context context, String usrname) {
        SharedPreferences.Editor editorSession = getSharedPreferences(context).edit();
        editorSession.putString(USERNAME_KEY, usrname);
        editorSession.apply();
    }

    public static String getRegisesi_User(Context context) {
        return getSharedPreferences(context).getString(USERNAME_KEY, "");
    }

    // Set Password
    public static void setRegisesi_Pass(Context context, String pswd) {
        SharedPreferences.Editor editorSession = getSharedPreferences(context).edit();
        editorSession.putString(PASSWORD_KEY, pswd);
        editorSession.apply();
    }

    public static String getRegisesi_Pass(Context context) {
        return getSharedPreferences(context).getString(PASSWORD_KEY, "");
    }

    // Set Hash
    public static void setRegisesi_Hash(Context context, String hsh) {
        SharedPreferences.Editor editorSession = getSharedPreferences(context).edit();
        editorSession.putString(HASH_KEY, hsh);
        editorSession.apply();
    }

    public static String getRegisesi_Hash(Context context) {
        return getSharedPreferences(context).getString(HASH_KEY, "");
    }

    // Set Hash
    public static void setRegisesi_Lvl(Context context, String lvl) {
        SharedPreferences.Editor editorSession = getSharedPreferences(context).edit();
        editorSession.putString(LVL_KEY, lvl);
        editorSession.apply();
    }

    public static String getRegisesi_Lvl(Context context) {
        return getSharedPreferences(context).getString(LVL_KEY, "");
    }

    static final String IDENTIFY_USER_LOG = "user_identified";
    static final String STATUS_USER_LOG = "user_status";

    public static void setIdentify_Userlog(Context context, String usrname) {
        SharedPreferences.Editor editorIdentify = getSharedPreferences(context).edit();
        editorIdentify.putString(IDENTIFY_USER_LOG, usrname);
        editorIdentify.apply();
    }

    public static String getIdentify_Userlog(Context context) {
        return getSharedPreferences(context).getString(IDENTIFY_USER_LOG, "");
    }

    public static void setStatus_Userlog(Context context, boolean status) {
        SharedPreferences.Editor editorStatus = getSharedPreferences(context).edit();
        editorStatus.putBoolean(STATUS_USER_LOG, status);
        editorStatus.apply();
    }

    public static Boolean getStatus_Userlog(Context context) {
        return getSharedPreferences(context).getBoolean(STATUS_USER_LOG, false);
    }

    public static void clearLogSessionUser(Context context) {
        SharedPreferences.Editor editorClearsession = getSharedPreferences(context).edit();
        editorClearsession.remove(USERNAME_KEY);
        editorClearsession.remove(PASSWORD_KEY);
        editorClearsession.remove(HASH_KEY);
        editorClearsession.remove(LVL_KEY);
        editorClearsession.apply();
    }
}
