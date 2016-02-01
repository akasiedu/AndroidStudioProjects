package akasiedu.com.weathergh;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by kwame on 4/23/15.
 */
public class CityPreference {
    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCity(){
        return prefs.getString("city", "Accra, GH");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
