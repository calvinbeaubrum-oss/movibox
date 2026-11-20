package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import k1.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.mvel2.ast.ASTNode;
import z3.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzd {
    static zzd zzk;
    private final Context zzl;
    private String zzm;
    private final AtomicInteger zzn = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        this.zzl = context.getApplicationContext();
    }

    public static synchronized zzd zzd(Context context) {
        try {
            if (zzk == null) {
                zzk = new zzd(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzk;
    }

    public static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final String zze(Bundle bundle, String str) {
        String strZzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(strZzd)) {
            return strZzd;
        }
        String strValueOf = String.valueOf(str);
        String strZzd2 = zzd(bundle, "_loc_key".length() != 0 ? strValueOf.concat("_loc_key") : new String(strValueOf));
        if (TextUtils.isEmpty(strZzd2)) {
            return null;
        }
        Resources resources = this.zzl.getResources();
        int identifier = resources.getIdentifier(strZzd2, "string", this.zzl.getPackageName());
        if (identifier == 0) {
            String strValueOf2 = String.valueOf(str);
            String strSubstring = ("_loc_key".length() != 0 ? strValueOf2.concat("_loc_key") : new String(strValueOf2)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(strZzd2).length());
            sb2.append(strSubstring);
            sb2.append(" resource not found: ");
            sb2.append(strZzd2);
            sb2.append(" Default value will be used.");
            Log.w("GcmNotification", sb2.toString());
            return null;
        }
        String strValueOf3 = String.valueOf(str);
        String strZzd3 = zzd(bundle, "_loc_args".length() != 0 ? strValueOf3.concat("_loc_args") : new String(strValueOf3));
        if (TextUtils.isEmpty(strZzd3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strZzd3);
            int length = jSONArray.length();
            Object[] objArr = new String[length];
            for (int i11 = 0; i11 < length; i11++) {
                objArr[i11] = jSONArray.opt(i11);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e11) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(strZzd2).length() + 58 + String.valueOf(strZzd3).length());
            sb3.append("Missing format argument for ");
            sb3.append(strZzd2);
            sb3.append(": ");
            sb3.append(strZzd3);
            sb3.append(" Default value will be used.");
            Log.w("GcmNotification", sb3.toString(), e11);
            return null;
        } catch (JSONException unused) {
            String strValueOf4 = String.valueOf(str);
            String strSubstring2 = ("_loc_args".length() != 0 ? strValueOf4.concat("_loc_args") : new String(strValueOf4)).substring(6);
            StringBuilder sb4 = new StringBuilder(String.valueOf(strSubstring2).length() + 41 + String.valueOf(strZzd3).length());
            sb4.append("Malformed ");
            sb4.append(strSubstring2);
            sb4.append(": ");
            sb4.append(strZzd3);
            sb4.append("  Default value will be used.");
            Log.w("GcmNotification", sb4.toString());
            return null;
        }
    }

    private final Bundle zzf() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = this.zzl.getPackageManager().getApplicationInfo(this.zzl.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? Bundle.EMPTY : bundle;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0081  */
    /* JADX WARN: Code duplicated, block: B:17:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x019b  */
    /* JADX WARN: Code duplicated, block: B:51:0x01a1 A[PHI: r8
  0x01a1: PHI (r8v25 java.lang.String) = (r8v16 java.lang.String), (r8v21 java.lang.String), (r8v12 java.lang.String) binds: [B:54:0x01c8, B:66:0x020d, B:50:0x019f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:53:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:56:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:58:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:60:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:61:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:65:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:69:0x0226  */
    /* JADX WARN: Code duplicated, block: B:72:0x022f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0244  */
    /* JADX WARN: Code duplicated, block: B:77:0x024d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0252  */
    /* JADX WARN: Code duplicated, block: B:81:0x0257  */
    /* JADX WARN: Code duplicated, block: B:84:0x0277  */
    public final boolean zze(Bundle bundle) {
        int i11;
        int identifier;
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        String strZzd;
        NotificationCompat.m mVarK;
        String strZzd2;
        NotificationManager notificationManager;
        String string;
        CharSequence charSequenceZze = zze(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(charSequenceZze)) {
            charSequenceZze = this.zzl.getApplicationInfo().loadLabel(this.zzl.getPackageManager());
        }
        String strZze = zze(bundle, "gcm.n.body");
        String strZzd3 = zzd(bundle, "gcm.n.icon");
        if (TextUtils.isEmpty(strZzd3)) {
            i11 = this.zzl.getApplicationInfo().icon;
            if (i11 == 0) {
                identifier = android.R.drawable.sym_def_app_icon;
            } else {
                identifier = i11;
            }
        } else {
            Resources resources = this.zzl.getResources();
            identifier = resources.getIdentifier(strZzd3, "drawable", this.zzl.getPackageName());
            if (identifier == 0 && (identifier = resources.getIdentifier(strZzd3, "mipmap", this.zzl.getPackageName())) == 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(strZzd3).length() + 57);
                sb2.append("Icon resource ");
                sb2.append(strZzd3);
                sb2.append(" not found. Notification will use app icon.");
                Log.w("GcmNotification", sb2.toString());
                i11 = this.zzl.getApplicationInfo().icon;
                if (i11 == 0) {
                    identifier = android.R.drawable.sym_def_app_icon;
                } else {
                    identifier = i11;
                }
            }
        }
        String strZzd4 = zzd(bundle, "gcm.n.color");
        String strZzd5 = zzd(bundle, "gcm.n.sound2");
        String str = null;
        if (TextUtils.isEmpty(strZzd5)) {
            defaultUri = null;
        } else if (TmcEngineFactory.ENGINE_TYPE_DEFAULT.equals(strZzd5) || this.zzl.getResources().getIdentifier(strZzd5, "raw", this.zzl.getPackageName()) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            String packageName = this.zzl.getPackageName();
            StringBuilder sb3 = new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(strZzd5).length());
            sb3.append("android.resource://");
            sb3.append(packageName);
            sb3.append("/raw/");
            sb3.append(strZzd5);
            defaultUri = Uri.parse(sb3.toString());
        }
        String strZzd6 = zzd(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(strZzd6)) {
            launchIntentForPackage = this.zzl.getPackageManager().getLaunchIntentForPackage(this.zzl.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                activity = null;
            }
            strZzd = zzd(bundle, "gcm.n.android_channel_id");
            if (PlatformVersion.isAtLeastO() && this.zzl.getApplicationInfo().targetSdkVersion >= 26) {
                notificationManager = (NotificationManager) this.zzl.getSystemService(NotificationManager.class);
                if (TextUtils.isEmpty(strZzd)) {
                    strZzd = this.zzm;
                    if (strZzd != null) {
                        str = strZzd;
                    } else {
                        string = zzf().getString("com.google.android.gms.gcm.default_notification_channel_id");
                        this.zzm = string;
                        if (!TextUtils.isEmpty(string)) {
                            Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(this.zzm) != null) {
                            str = this.zzm;
                        } else {
                            Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strZzd = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            z.a();
                            notificationManager.createNotificationChannel(h.a("fcm_fallback_notification_channel", this.zzl.getString(R.string.gcm_fallback_notification_channel_label), 3));
                        }
                        this.zzm = "fcm_fallback_notification_channel";
                        str = strZzd;
                    }
                } else if (notificationManager.getNotificationChannel(strZzd) != null) {
                    str = strZzd;
                } else {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(strZzd).length() + 122);
                    sb4.append("Notification Channel requested (");
                    sb4.append(strZzd);
                    sb4.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                    Log.w("GcmNotification", sb4.toString());
                    strZzd = this.zzm;
                    if (strZzd != null) {
                        str = strZzd;
                    } else {
                        string = zzf().getString("com.google.android.gms.gcm.default_notification_channel_id");
                        this.zzm = string;
                        if (!TextUtils.isEmpty(string)) {
                            Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(this.zzm) != null) {
                            str = this.zzm;
                        } else {
                            Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strZzd = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            z.a();
                            notificationManager.createNotificationChannel(h.a("fcm_fallback_notification_channel", this.zzl.getString(R.string.gcm_fallback_notification_channel_label), 3));
                        }
                        this.zzm = "fcm_fallback_notification_channel";
                        str = strZzd;
                    }
                }
            }
            mVarK = new NotificationCompat.m(this.zzl).l(true).K(identifier);
            if (!TextUtils.isEmpty(charSequenceZze)) {
                mVarK.r(charSequenceZze);
            }
            if (!TextUtils.isEmpty(strZze)) {
                mVarK.q(strZze);
                mVarK.M(new NotificationCompat.k().q(strZze));
            }
            if (!TextUtils.isEmpty(strZzd4)) {
                mVarK.o(Color.parseColor(strZzd4));
            }
            if (defaultUri != null) {
                mVarK.L(defaultUri);
            }
            if (activity != null) {
                mVarK.p(activity);
            }
            if (str != null) {
                mVarK.n(str);
            }
            Notification notificationC = mVarK.c();
            strZzd2 = zzd(bundle, "gcm.n.tag");
            Log.isLoggable("GcmNotification", 3);
            NotificationManager notificationManager2 = (NotificationManager) this.zzl.getSystemService("notification");
            if (TextUtils.isEmpty(strZzd2)) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                StringBuilder sb5 = new StringBuilder(37);
                sb5.append("GCM-Notification:");
                sb5.append(jUptimeMillis);
                strZzd2 = sb5.toString();
            }
            notificationManager2.notify(strZzd2, 0, notificationC);
            return true;
        }
        launchIntentForPackage = new Intent(strZzd6);
        launchIntentForPackage.setPackage(this.zzl.getPackageName());
        launchIntentForPackage.setFlags(ASTNode.DEOP);
        Bundle bundle2 = new Bundle(bundle);
        GcmListenerService.zzd(bundle2);
        launchIntentForPackage.putExtras(bundle2);
        for (String str2 : bundle2.keySet()) {
            if (str2.startsWith("gcm.n.") || str2.startsWith("gcm.notification.")) {
                launchIntentForPackage.removeExtra(str2);
            }
        }
        activity = PendingIntent.getActivity(this.zzl, this.zzn.getAndIncrement(), launchIntentForPackage, 1073741824);
        strZzd = zzd(bundle, "gcm.n.android_channel_id");
        if (PlatformVersion.isAtLeastO()) {
            notificationManager = (NotificationManager) this.zzl.getSystemService(NotificationManager.class);
            if (TextUtils.isEmpty(strZzd)) {
                strZzd = this.zzm;
                if (strZzd != null) {
                    str = strZzd;
                } else {
                    string = zzf().getString("com.google.android.gms.gcm.default_notification_channel_id");
                    this.zzm = string;
                    if (!TextUtils.isEmpty(string)) {
                        Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                    } else if (notificationManager.getNotificationChannel(this.zzm) != null) {
                        str = this.zzm;
                    } else {
                        Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                    }
                    strZzd = "fcm_fallback_notification_channel";
                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                        z.a();
                        notificationManager.createNotificationChannel(h.a("fcm_fallback_notification_channel", this.zzl.getString(R.string.gcm_fallback_notification_channel_label), 3));
                    }
                    this.zzm = "fcm_fallback_notification_channel";
                    str = strZzd;
                }
            } else if (notificationManager.getNotificationChannel(strZzd) != null) {
                str = strZzd;
            } else {
                StringBuilder sb6 = new StringBuilder(String.valueOf(strZzd).length() + 122);
                sb6.append("Notification Channel requested (");
                sb6.append(strZzd);
                sb6.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("GcmNotification", sb6.toString());
                strZzd = this.zzm;
                if (strZzd != null) {
                    str = strZzd;
                } else {
                    string = zzf().getString("com.google.android.gms.gcm.default_notification_channel_id");
                    this.zzm = string;
                    if (!TextUtils.isEmpty(string)) {
                        Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                    } else if (notificationManager.getNotificationChannel(this.zzm) != null) {
                        str = this.zzm;
                    } else {
                        Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                    }
                    strZzd = "fcm_fallback_notification_channel";
                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                        z.a();
                        notificationManager.createNotificationChannel(h.a("fcm_fallback_notification_channel", this.zzl.getString(R.string.gcm_fallback_notification_channel_label), 3));
                    }
                    this.zzm = "fcm_fallback_notification_channel";
                    str = strZzd;
                }
            }
        }
        mVarK = new NotificationCompat.m(this.zzl).l(true).K(identifier);
        if (!TextUtils.isEmpty(charSequenceZze)) {
            mVarK.r(charSequenceZze);
        }
        if (!TextUtils.isEmpty(strZze)) {
            mVarK.q(strZze);
            mVarK.M(new NotificationCompat.k().q(strZze));
        }
        if (!TextUtils.isEmpty(strZzd4)) {
            mVarK.o(Color.parseColor(strZzd4));
        }
        if (defaultUri != null) {
            mVarK.L(defaultUri);
        }
        if (activity != null) {
            mVarK.p(activity);
        }
        if (str != null) {
            mVarK.n(str);
        }
        Notification notificationC2 = mVarK.c();
        strZzd2 = zzd(bundle, "gcm.n.tag");
        Log.isLoggable("GcmNotification", 3);
        NotificationManager notificationManager3 = (NotificationManager) this.zzl.getSystemService("notification");
        if (TextUtils.isEmpty(strZzd2)) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            StringBuilder sb7 = new StringBuilder(37);
            sb7.append("GCM-Notification:");
            sb7.append(jUptimeMillis2);
            strZzd2 = sb7.toString();
        }
        notificationManager3.notify(strZzd2, 0, notificationC2);
        return true;
    }
}
