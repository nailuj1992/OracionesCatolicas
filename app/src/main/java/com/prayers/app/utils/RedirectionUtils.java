package com.prayers.app.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RedirectionUtils {

    private RedirectionUtils() {
    }

    public static void redirectToAnotherActivity(Activity activity, Class<? extends Activity> clazz) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void redirectToAnotherActivityWithExtras(Activity activity, Bundle bundle, Class<? extends Activity> clazz) {
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.finish();
    }

}
