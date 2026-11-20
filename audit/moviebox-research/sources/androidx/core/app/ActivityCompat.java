package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends z2.a {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class a {
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(23)
    public static class b {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i11) {
            activity.requestPermissions(strArr, i11);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class c {
        public static boolean a(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(32)
    public static class d {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface e {
        void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface f {
        void validateRequestPermissionsRequestCode(int i11);
    }

    public static void b(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void c(@NonNull Activity activity) {
        a.a(activity);
    }

    public static /* synthetic */ void d(Activity activity) {
        if (activity.isFinishing() || ActivityRecreator.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void e(@NonNull Activity activity) {
        a.b(activity);
    }

    public static void f(@NonNull final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityCompat.d(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(@NonNull final Activity activity, @NonNull String[] strArr, final int i11) {
        HashSet hashSet = new HashSet();
        for (int i12 = 0; i12 < strArr.length; i12++) {
            if (TextUtils.isEmpty(strArr[i12])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i12], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i12));
            }
        }
        int size = hashSet.size();
        final String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i13 = 0;
            for (int i14 = 0; i14 < strArr.length; i14++) {
                if (!hashSet.contains(Integer.valueOf(i14))) {
                    strArr2[i13] = strArr[i14];
                    i13++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof f) {
                ((f) activity).validateRequestPermissionsRequestCode(i11);
            }
            b.b(activity, strArr, i11);
        } else if (activity instanceof e) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr2.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr2.length;
                    for (int i15 = 0; i15 < length; i15++) {
                        iArr[i15] = packageManager.checkPermission(strArr2[i15], packageName);
                    }
                    ((e) activity).onRequestPermissionsResult(i11, strArr2, iArr);
                }
            });
        }
    }

    public static void h(@NonNull Activity activity, @Nullable e0 e0Var) {
        a.c(activity, null);
    }

    public static void i(@NonNull Activity activity, @Nullable e0 e0Var) {
        a.d(activity, null);
    }

    public static boolean j(@NonNull Activity activity, @NonNull String str) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i11 >= 32) {
            return d.a(activity, str);
        }
        if (i11 == 31) {
            return c.b(activity, str);
        }
        if (i11 >= 23) {
            return b.c(activity, str);
        }
        return false;
    }

    public static void k(@NonNull Activity activity, @NonNull Intent intent, int i11, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i11, bundle);
    }

    public static void l(@NonNull Activity activity, @NonNull IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
    }

    public static void m(@NonNull Activity activity) {
        a.e(activity);
    }
}
