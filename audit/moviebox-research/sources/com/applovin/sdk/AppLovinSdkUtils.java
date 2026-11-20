package com.applovin.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tn;
import com.applovin.impl.uj;
import com.applovin.impl.vj;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.google.logging.type.LogSeverity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinSdkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f25062a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public static final class Size {
        public static final Size ZERO = new Size(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f25064b;

        public Size(int i11, int i12) {
            this.f25063a = i11;
            this.f25064b = i12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f25063a == size.getWidth() && this.f25064b == size.getHeight();
        }

        public int getHeight() {
            return this.f25064b;
        }

        public int getWidth() {
            return this.f25063a;
        }

        public int hashCode() {
            int i11 = this.f25064b;
            int i12 = this.f25063a;
            return i11 ^ ((i12 >>> 16) | (i12 << 16));
        }

        public String toString() {
            return this.f25063a + "x" + this.f25064b;
        }
    }

    private static boolean a(String str, String str2) {
        return StringUtils.startsWithAtLeastOnePrefix(str, CollectionUtils.explode(str2));
    }

    public static int dpToPx(Context context, int i11) {
        return (int) TypedValue.applyDimension(1, i11, context.getResources().getDisplayMetrics());
    }

    @Nullable
    @Deprecated
    public static Boolean getAdditionalConsentStatus(int i11, Context context) {
        return tn.a(i11, (String) vj.a(uj.f23603t, (Object) null, PreferenceManager.getDefaultSharedPreferences(context), false));
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    @Nullable
    @Deprecated
    public static Boolean getTcfConsentStatus(int i11, Context context) {
        String str = (String) vj.a(uj.f23604u, (Object) null, PreferenceManager.getDefaultSharedPreferences(context), false);
        if (str != null) {
            return Boolean.valueOf(tn.a(str, i11 - 1));
        }
        return null;
    }

    public static boolean isEmulator() {
        return a(Build.DEVICE, "goldfish,vbox") || a(Build.HARDWARE, "ranchu,generic,vbox") || a(Build.MANUFACTURER, "Genymotion") || a(Build.MODEL, "Android SDK built for x86");
    }

    public static boolean isFireOS(Context context) {
        return "amazon".equalsIgnoreCase(Build.MANUFACTURER) || isFireTv(context);
    }

    public static boolean isFireTv(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= yp.f(str);
    }

    public static boolean isTablet(Context context) {
        Point pointB = z3.b(context);
        return Math.min(pointB.x, pointB.y) >= dpToPx(context, LogSeverity.CRITICAL_VALUE);
    }

    public static boolean isTv(Context context) {
        if (isFireTv(context)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        return z3.f() ? packageManager.hasSystemFeature("android.software.leanback") : packageManager.hasSystemFeature("android.hardware.type.television");
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i11) {
        return (int) Math.ceil(i11 / context.getResources().getDisplayMetrics().density);
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z11, Runnable runnable) {
        if (z11 || !yp.h()) {
            f25062a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j11) {
        runOnUiThreadDelayed(runnable, j11, f25062a);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j11, Handler handler) {
        if (j11 > 0) {
            handler.postDelayed(runnable, j11);
        } else if (yp.h()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void setImageUrl(String str, ImageView imageView, AppLovinSdk appLovinSdk) {
        ImageViewUtils.setImageUri(imageView, Uri.parse(str), appLovinSdk.a());
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return JsonUtils.toStringMap(jSONObject);
    }
}
