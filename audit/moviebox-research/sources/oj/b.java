package oj;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzid;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f72437a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f72438b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f72439c = Arrays.asList("auto", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f72440d = Arrays.asList("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List f72441e = Arrays.asList((String[]) ArrayUtils.concat(zzgq.zza, zzgq.zzb));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f72442f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static Bundle a(nj.a.c cVar) {
        Bundle bundle = new Bundle();
        String str = cVar.f71997a;
        if (str != null) {
            bundle.putString("origin", str);
        }
        String str2 = cVar.f71998b;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = cVar.f71999c;
        if (obj != null) {
            zzgn.zzb(bundle, obj);
        }
        String str3 = cVar.f72000d;
        if (str3 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cVar.f72001e);
        String str4 = cVar.f72002f;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str4);
        }
        Bundle bundle2 = cVar.f72003g;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str5 = cVar.f72004h;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str5);
        }
        Bundle bundle3 = cVar.f72005i;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cVar.f72006j);
        String str6 = cVar.f72007k;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str6);
        }
        Bundle bundle4 = cVar.f72008l;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, cVar.f72009m);
        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, cVar.f72010n);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, cVar.f72011o);
        return bundle;
    }

    public static nj.a.c b(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        nj.a.c cVar = new nj.a.c();
        cVar.f71997a = (String) Preconditions.checkNotNull((String) zzgn.zza(bundle, "origin", String.class, null));
        cVar.f71998b = (String) Preconditions.checkNotNull((String) zzgn.zza(bundle, "name", String.class, null));
        cVar.f71999c = zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        cVar.f72000d = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        cVar.f72001e = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
        cVar.f72002f = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        cVar.f72003g = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        cVar.f72004h = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        cVar.f72005i = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        cVar.f72006j = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
        cVar.f72007k = (String) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        cVar.f72008l = (Bundle) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        cVar.f72010n = ((Boolean) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
        cVar.f72009m = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
        cVar.f72011o = ((Long) zzgn.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        return cVar;
    }

    public static String c(String str) {
        String strZza = zzgo.zza(str);
        return strZza != null ? strZza : str;
    }

    public static void d(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    public static boolean e(String str, String str2, Bundle bundle) {
        byte b11;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!i(str) || bundle == null) {
            return false;
        }
        Iterator it = f72440d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey((String) it.next())) {
                return false;
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 101200) {
            if (iHashCode != 101230) {
                if (iHashCode == 3142703 && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
            } else if (str.equals("fdl")) {
                b11 = 1;
            } else {
                b11 = -1;
            }
        } else if (str.equals(AppMeasurement.FCM_ORIGIN)) {
            b11 = 0;
        } else {
            b11 = -1;
        }
        if (b11 == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        if (b11 == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        if (b11 != 2) {
            return false;
        }
        bundle.putString("_cis", "fiam_integration");
        return true;
    }

    public static boolean f(nj.a.c cVar) {
        String str;
        if (cVar == null || (str = cVar.f71997a) == null || str.isEmpty()) {
            return false;
        }
        Object obj = cVar.f71999c;
        if ((obj != null && zzid.zza(obj) == null) || !i(str) || !j(str, cVar.f71998b)) {
            return false;
        }
        String str2 = cVar.f72007k;
        if (str2 != null && (!g(str2, cVar.f72008l) || !e(str, cVar.f72007k, cVar.f72008l))) {
            return false;
        }
        String str3 = cVar.f72004h;
        if (str3 != null && (!g(str3, cVar.f72005i) || !e(str, cVar.f72004h, cVar.f72005i))) {
            return false;
        }
        String str4 = cVar.f72002f;
        if (str4 != null) {
            return g(str4, cVar.f72003g) && e(str, cVar.f72002f, cVar.f72003g);
        }
        return true;
    }

    public static boolean g(String str, Bundle bundle) {
        if (f72438b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator it = f72440d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(String str) {
        return !f72437a.contains(str);
    }

    public static boolean i(String str) {
        return !f72439c.contains(str);
    }

    public static boolean j(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN);
        }
        if (f72441e.contains(str2)) {
            return false;
        }
        Iterator it = f72442f.iterator();
        while (it.hasNext()) {
            if (str2.matches((String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
