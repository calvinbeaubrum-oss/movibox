package com.bytedance.sdk.openadsdk.core.Ol.sc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile pFF f28039sc;
    private final ArrayList<String> pFF = new ArrayList<>();
    private final AtomicBoolean zY = new AtomicBoolean(false);
    private long We = System.currentTimeMillis();
    private long ExN = 0;
    private long TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f28040qr = "";
    private String Qj = "";
    private String Ol = "";
    private boolean WH = false;
    private boolean UFX = false;

    private static int sc(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
        }
    }

    public static pFF sc(Application application) {
        if (f28039sc == null) {
            synchronized (pFF.class) {
                try {
                    if (f28039sc == null) {
                        pFF pff = new pFF();
                        f28039sc = pff;
                        pff.WH = sc((Context) application);
                        f28039sc.UFX = sc(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                        f28039sc.sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28039sc;
    }

    private void sc() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i11 = 0; i11 < size; i11++) {
                    Object objValueAt = arrayMap.valueAt(i11);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.pFF.contains(localClassName)) {
                            this.pFF.add(localClassName);
                        }
                    }
                }
                this.zY.set(this.pFF.size() <= 0);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean sc(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public void pFF(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.pFF.contains(localClassName)) {
            this.pFF.remove(localClassName);
        }
        if (this.pFF.size() == 0) {
            this.We = System.currentTimeMillis();
            this.zY.set(true);
            this.Qj = localClassName;
        }
    }

    public String sc(String str, long j11, int i11) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j12 = jCurrentTimeMillis - this.ExN;
        long j13 = jCurrentTimeMillis - j11;
        int i12 = j13 < 500 ? 1 : 0;
        if (this.zY.get() && this.UFX) {
            i12 |= 2;
        }
        if (!this.zY.get() && this.TRI >= 5000 && j12 < 1000) {
            i12 = this.Qj.equals(this.Ol) ? i12 | 4 : i12 | 8;
        }
        try {
            string = new JSONObject().put("rst", i12).put("adtag", str).put("bakdur", this.TRI).put("rit", i11).put("poptime", j12).put("unlocktime", j13).put("bakground", this.zY).put("alert", this.UFX).put(NotificationCompat.CATEGORY_SYSTEM, this.WH).put("actsize", this.pFF.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.pFF.zY()).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.f28040qr = "";
        this.TRI = 0L;
        this.ExN = 0L;
        this.We = System.currentTimeMillis();
        return string;
    }

    public void sc(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.pFF.size() == 0) {
            this.f28040qr = localClassName;
            this.ExN = System.currentTimeMillis();
            this.TRI = System.currentTimeMillis() - this.We;
            this.zY.set(false);
        }
        if (!this.pFF.contains(localClassName)) {
            this.pFF.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.Ol = localClassName;
    }
}
