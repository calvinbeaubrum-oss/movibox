package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfxy {
    private static final Object zza;
    private static final Method zzb;
    private static final Method zzc;

    static {
        Object objZza = zza();
        zza = objZza;
        zzb = objZza == null ? null : zzb("getStackTraceElement", Throwable.class, Integer.TYPE);
        zzc = objZza != null ? zzc(objZza) : null;
    }

    private static Object zza() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzb(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzc(Object obj) {
        try {
            Method methodZzb = zzb("getStackTraceDepth", Throwable.class);
            if (methodZzb == null) {
                return null;
            }
            methodZzb.invoke(obj, new Throwable());
            return methodZzb;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}
