package com.epicodus.doddt;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created by Guest on 11/6/15.
 */
public class DoDDTApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Vxv8qecwJWkD7MPuAwvuA4HGX1CMtUMJFoNIIGau", "EfmoeJ9fzNAnG3OM4AnslNlon8HtCdqI6BscdUH1");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
