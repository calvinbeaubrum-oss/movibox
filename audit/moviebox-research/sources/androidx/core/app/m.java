package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    @Nullable
    public static Intent a(@NonNull Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String strC = c(activity);
        if (strC == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strC);
        try {
            return d(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strC + "' in manifest");
            return null;
        }
    }

    @Nullable
    public static Intent b(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strD = d(context, componentName);
        if (strD == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strD);
        return d(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @Nullable
    public static String c(@NonNull Activity activity) {
        try {
            return d(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @Nullable
    public static String d(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i11;
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            i11 = 269222528;
        } else {
            i11 = i12 >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i11);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void e(@NonNull Activity activity, @NonNull Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static boolean f(@NonNull Activity activity, @NonNull Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
