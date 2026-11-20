package ca;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.i;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushConstants;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14738a;

    public static Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("session_id", d.n());
        bundle.putString("sdk_version", d.l());
        bundle.putInt("sdk_version_int", d.m());
        bundle.putString("user_agent", d.p());
        bundle.putInt("type", d.o());
        bundle.putString("make", d.c());
        bundle.putString("ostype", "Android");
        bundle.putInt("screen_width", d.k());
        bundle.putInt("screen_height", d.j());
        bundle.putInt("screen_density", d.i());
        bundle.putString("base_station", DeviceUtil.g());
        bundle.putDouble("latitude", com.cloud.sdk.commonutil.util.e.d());
        bundle.putDouble("longitude", com.cloud.sdk.commonutil.util.e.f());
        bundle.putLong("coordtime", com.cloud.sdk.commonutil.util.e.b());
        bundle.putString("oneid", DeviceUtil.j());
        bundle.putInt("turn_off_per_ads", DeviceUtil.f());
        if (TextUtils.isEmpty(f14738a)) {
            try {
                f14738a = AthenaAnalytics.x(com.cloud.sdk.commonutil.util.f.a(), true);
            } catch (Exception e11) {
                com.cloud.sdk.commonutil.util.c.Log().e("ssp", "getAppVAID " + Log.getStackTraceString(e11));
            }
        }
        bundle.putString(PushConstants.PROVIDER_VAID, f14738a);
        bundle.putString("gaid", DeviceUtil.e());
        return bundle;
    }

    public static boolean b(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.contains(str);
    }

    public static void c(Runnable runnable) {
        i.f30292a.e(runnable);
    }
}
