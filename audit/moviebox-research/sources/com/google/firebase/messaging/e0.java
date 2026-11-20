package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.transsion.push.PushConstants;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e0 {
    public static boolean A(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return B(intent.getExtras());
    }

    public static boolean B(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    public static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            jj.e.k();
            Context contextJ = jj.e.k().j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            PackageManager packageManager = contextJ.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
            }
            return false;
        } catch (PackageManager.NameNotFoundException | IllegalStateException unused) {
        }
    }

    public static MessagingClientEvent b(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.a aVarH = MessagingClientEvent.p().m(p(extras)).e(event).f(f(extras)).i(m()).k(MessagingClientEvent.SDKPlatform.ANDROID).h(k(extras));
        String strH = h(extras);
        if (strH != null) {
            aVarH.g(strH);
        }
        String strO = o(extras);
        if (strO != null) {
            aVarH.l(strO);
        }
        String strC = c(extras);
        if (strC != null) {
            aVarH.c(strC);
        }
        String strI = i(extras);
        if (strI != null) {
            aVarH.b(strI);
        }
        String strE = e(extras);
        if (strE != null) {
            aVarH.d(strE);
        }
        long jN = n(extras);
        if (jN > 0) {
            aVarH.j(jN);
        }
        return aVarH.a();
    }

    @Nullable
    public static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    @Nullable
    public static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    @Nullable
    public static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    @NonNull
    public static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.await(com.google.firebase.installations.a.q(jj.e.k()).getId());
        } catch (InterruptedException | ExecutionException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Nullable
    public static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    @Nullable
    public static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_ID) : string;
    }

    @Nullable
    public static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    @Nullable
    public static String j(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    @NonNull
    public static MessagingClientEvent.MessageType k(Bundle bundle) {
        return (bundle == null || !g0.t(bundle)) ? MessagingClientEvent.MessageType.DATA_MESSAGE : MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    @NonNull
    public static String l(Bundle bundle) {
        return (bundle == null || !g0.t(bundle)) ? "data" : "display";
    }

    @NonNull
    public static String m() {
        return jj.e.k().j().getPackageName();
    }

    @Nullable
    public static long n(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e11) {
                Log.w("FirebaseMessaging", "error parsing project number", e11);
            }
        }
        jj.e eVarK = jj.e.k();
        String strD = eVarK.m().d();
        if (strD != null) {
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException e12) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e12);
            }
        }
        String strC = eVarK.m().c();
        if (strC.startsWith("1:")) {
            String[] strArrSplit = strC.split(":");
            if (strArrSplit.length < 2) {
                return 0L;
            }
            String str = strArrSplit[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e13) {
                Log.w("FirebaseMessaging", "error parsing app ID", e13);
            }
        } else {
            try {
                return Long.parseLong(strC);
            } catch (NumberFormatException e14) {
                Log.w("FirebaseMessaging", "error parsing app ID", e14);
            }
        }
        return 0L;
    }

    @Nullable
    public static String o(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    @NonNull
    public static int p(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    @Nullable
    public static String q(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    public static boolean r(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void s(Intent intent) {
        x("_nd", intent.getExtras());
    }

    public static void t(Intent intent) {
        x("_nf", intent.getExtras());
    }

    public static void u(Bundle bundle) {
        y(bundle);
        x("_no", bundle);
    }

    public static void v(Intent intent) {
        if (A(intent)) {
            x("_nr", intent.getExtras());
        }
        if (z(intent)) {
            w(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.r());
        }
    }

    public static void w(MessagingClientEvent.Event event, Intent intent, @Nullable cg.h hVar) {
        if (hVar == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        MessagingClientEvent messagingClientEventB = b(event, intent);
        if (messagingClientEventB == null) {
            return;
        }
        try {
            hVar.b("FCM_CLIENT_EVENT_LOGGING", jl.a.class, cg.c.b("proto"), new cg.f() { // from class: com.google.firebase.messaging.d0
                @Override // cg.f
                public final Object apply(Object obj) {
                    return ((jl.a) obj).c();
                }
            }).a(cg.d.e(jl.a.b().b(messagingClientEventB).a()));
        } catch (RuntimeException e11) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e11);
        }
    }

    public static void x(String str, Bundle bundle) {
        try {
            jj.e.k();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String strD = d(bundle);
            if (strD != null) {
                bundle2.putString("_nmid", strD);
            }
            String strE = e(bundle);
            if (strE != null) {
                bundle2.putString("_nmn", strE);
            }
            String strI = i(bundle);
            if (!TextUtils.isEmpty(strI)) {
                bundle2.putString("label", strI);
            }
            String strG = g(bundle);
            if (!TextUtils.isEmpty(strG)) {
                bundle2.putString("message_channel", strG);
            }
            String strO = o(bundle);
            if (strO != null) {
                bundle2.putString("_nt", strO);
            }
            String strJ = j(bundle);
            if (strJ != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(strJ));
                } catch (NumberFormatException e11) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e11);
                }
            }
            String strQ = q(bundle);
            if (strQ != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(strQ));
                } catch (NumberFormatException e12) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e12);
                }
            }
            String strL = l(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", strL);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Logging to scion event=");
                sb2.append(str);
                sb2.append(" scionPayload=");
                sb2.append(bundle2);
            }
            nj.a aVar = (nj.a) jj.e.k().i(nj.a.class);
            if (aVar != null) {
                aVar.b(AppMeasurement.FCM_ORIGIN, str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public static void y(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!"1".equals(bundle.getString("google.c.a.tc"))) {
            Log.isLoggable("FirebaseMessaging", 3);
            return;
        }
        nj.a aVar = (nj.a) jj.e.k().i(nj.a.class);
        Log.isLoggable("FirebaseMessaging", 3);
        if (aVar == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        aVar.d(AppMeasurement.FCM_ORIGIN, "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString("source", "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString("campaign", string);
        aVar.b(AppMeasurement.FCM_ORIGIN, "_cmp", bundle2);
    }

    public static boolean z(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return a();
    }
}
