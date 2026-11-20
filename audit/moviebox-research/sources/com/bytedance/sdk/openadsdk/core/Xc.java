package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc {
    private static volatile Sfl<com.bytedance.sdk.openadsdk.We.sc> pFF = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f28324sc = null;
    private static int zY = -1;

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f28325sc;

        static {
            try {
                Object objPFF = pFF();
                f28325sc = (Application) objPFF.getClass().getMethod("getApplication", new Class[0]).invoke(objPFF, new Object[0]);
                com.bytedance.sdk.component.utils.Tf.sc("MyApplication", "application get success");
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("MyApplication", "application get failed", th2);
            }
        }

        private static Object pFF() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th2);
                return null;
            }
        }

        @Nullable
        public static Application sc() {
            return f28325sc;
        }
    }

    public static com.bytedance.sdk.openadsdk.SR.zY.pFF ExN() {
        return !com.bytedance.sdk.openadsdk.core.settings.Tf.sc() ? com.bytedance.sdk.openadsdk.SR.zY.zY.sc() : com.bytedance.sdk.openadsdk.We.sc.We.sc();
    }

    public static com.bytedance.sdk.openadsdk.core.settings.TRI We() {
        return com.bytedance.sdk.openadsdk.core.settings.dE.ef();
    }

    public static int pFF() {
        Context contextSc;
        if (zY < 0 && (contextSc = sc()) != null) {
            zY = ViewConfiguration.get(contextSc).getScaledTouchSlop();
        }
        return zY;
    }

    public static void pFF(Context context) {
        if (f28324sc == null) {
            synchronized (Xc.class) {
                try {
                    if (f28324sc == null) {
                        if (context != null) {
                            f28324sc = context;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                f28324sc = applicationContext;
                            }
                            return;
                        }
                        try {
                            Application applicationSc = sc.sc();
                            if (applicationSc != null) {
                                f28324sc = applicationSc;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static Context sc() {
        if (f28324sc == null) {
            pFF(null);
        }
        return f28324sc;
    }

    public static Context sc(Context context) {
        if (context == null) {
            context = sc();
        }
        if (context instanceof Application) {
            return context;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static Sfl<com.bytedance.sdk.openadsdk.We.sc> zY() {
        if (pFF == null) {
            synchronized (Xc.class) {
                try {
                    if (pFF == null) {
                        pFF = new YIK(f28324sc);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }
}
