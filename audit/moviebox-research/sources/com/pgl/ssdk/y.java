package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f48861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f48862b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f48863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f48864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f48865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static DisplayManager f48866f;

    /* JADX INFO: compiled from: source.java */
    public static class a implements DisplayManager.DisplayListener {
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
            y.b(i11, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            y.b(i11, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
            y.b(i11, 2);
        }
    }

    private static String a(int i11) {
        Display display = f48866f.getDisplay(i11);
        return display != null ? a(display) : "pd";
    }

    public static String a(Context context) {
        Display[] displays;
        if (f48866f == null) {
            f48866f = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = f48866f;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < displays.length; i11++) {
            Display display = displays[i11];
            if (display != null && display.getDisplayId() != 0) {
                stringBuffer.append(a(displays[i11]));
                if (i11 != displays.length - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String a(Display display) {
        String name = display.getName();
        Object objA = s0.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object objA2 = s0.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object objA3 = s0.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        return String.format("%s#%s#%b", objA2, name, Boolean.valueOf((objA == null || objA3 == null || ((Integer) objA).intValue() != ((Integer) objA3).intValue()) ? false : true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i11, int i12) {
        if (i11 == 0) {
            return;
        }
        try {
            String strA = a(i11);
            if (i12 == 1) {
                if (strA.equals(f48863c)) {
                    return;
                }
                f48863c = strA;
            } else if (i12 == 2) {
                if (strA.equals(f48864d)) {
                    return;
                }
                f48864d = strA;
            } else {
                if (i12 != 3 || strA.equals(f48865e)) {
                    return;
                }
                f48865e = strA;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context) {
        if (f48863c == null && f48864d == null && f48865e == null) {
            return (context == null || TextUtils.isEmpty(a(context))) ? false : true;
        }
        return true;
    }

    public static void c(Context context) {
        Handler handlerB;
        if (f48862b) {
            return;
        }
        f48862b = true;
        if (f48861a == null) {
            f48861a = new a();
        }
        if (f48866f == null) {
            f48866f = (DisplayManager) context.getSystemService("display");
        }
        if (f48866f == null || (handlerB = o0.b()) == null) {
            return;
        }
        try {
            f48866f.registerDisplayListener(f48861a, handlerB);
        } catch (Exception unused) {
        }
    }
}
