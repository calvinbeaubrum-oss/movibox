package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f48846a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f48847b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f48848c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f48849d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f48850e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f48851f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f48852g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static InputManager f48853h;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f48854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f48855b;

        public a(Context context, int i11) {
            this.f48854a = context;
            this.f48855b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputManager inputManagerB = w.b(this.f48854a);
            if (inputManagerB == null) {
                return;
            }
            InputDevice inputDevice = inputManagerB.getInputDevice(this.f48855b);
            w.h();
            if (inputDevice == null) {
                w.b();
                w.c();
                w.c("nihc");
            } else if (inputDevice.isVirtual()) {
                w.d();
                w.e();
                w.c("vihc");
            } else {
                if (Build.VERSION.SDK_INT < 29 || !inputDevice.isExternal()) {
                    return;
                }
                w.f();
                w.g();
                w.c("eihc");
            }
        }
    }

    public static void a(MotionEvent motionEvent, Context context) {
        if (motionEvent == null || context == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            o0.b(new a(context, motionEvent.getDeviceId()));
        }
    }

    public static void a(JSONObject jSONObject) {
        h();
        try {
            jSONObject.put("vihc", f48849d);
            jSONObject.put("eihc", f48850e);
            jSONObject.put("nihc", f48851f);
            jSONObject.put("vic", f48846a);
            jSONObject.put("nic", f48848c);
            jSONObject.put("eic", f48847b);
        } catch (JSONException unused) {
        }
    }

    public static /* synthetic */ int b() {
        int i11 = f48848c;
        f48848c = i11 + 1;
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000e  */
    public static int b(String str) {
        h();
        str.hashCode();
        switch (str) {
            case "eic":
                return f48847b;
            case "nic":
                return f48848c;
            case "vic":
                return f48846a;
            case "eihc":
                return f48850e;
            case "nihc":
                return f48851f;
            case "vihc":
                return f48849d;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (f48853h == null) {
            f48853h = (InputManager) context.getSystemService("input");
        }
        return f48853h;
    }

    public static /* synthetic */ int c() {
        int i11 = f48851f;
        f48851f = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt(str, sharedPreferencesA.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ int d() {
        int i11 = f48846a;
        f48846a = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int e() {
        int i11 = f48849d;
        f48849d = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int f() {
        int i11 = f48847b;
        f48847b = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int g() {
        int i11 = f48850e;
        f48850e = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (f48852g) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                f48851f = sharedPreferencesA.getInt("nihc", 0);
                f48850e = sharedPreferencesA.getInt("eihc", 0);
                f48849d = sharedPreferencesA.getInt("vihc", 0);
                f48852g = true;
            }
        } catch (Throwable unused) {
        }
    }
}
