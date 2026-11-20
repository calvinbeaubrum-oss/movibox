package org.lsposed.hiddenapibypass;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(28)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f73263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f73264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f73265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f73266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f73267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f73268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f73269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f73270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f73271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f73272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f73273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f73274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f73275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set f73276n = new HashSet();

    static {
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            f73263a = unsafe;
            f73264b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
            f73265c = unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
            long jObjectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
            f73266d = jObjectFieldOffset;
            f73267e = unsafe.objectFieldOffset(g.class.getDeclaredField("info"));
            long jObjectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
            f73268f = jObjectFieldOffset2;
            long jObjectFieldOffset3 = unsafe.objectFieldOffset(b.class.getDeclaredField("iFields"));
            f73269g = jObjectFieldOffset3;
            f73270h = unsafe.objectFieldOffset(b.class.getDeclaredField("sFields"));
            f73271i = unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
            Method declaredMethod = h.class.getDeclaredMethod("a", new Class[0]);
            Method declaredMethod2 = h.class.getDeclaredMethod(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j11 = unsafe.getLong(methodHandleUnreflect, jObjectFieldOffset);
            long j12 = unsafe.getLong(methodHandleUnreflect2, jObjectFieldOffset);
            long j13 = unsafe.getLong(h.class, jObjectFieldOffset2);
            long j14 = j12 - j11;
            f73272j = j14;
            f73273k = (j11 - j13) - j14;
            Field declaredField = h.class.getDeclaredField("i");
            Field declaredField2 = h.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            long j15 = unsafe.getLong(methodHandleUnreflectGetter, jObjectFieldOffset);
            long j16 = unsafe.getLong(methodHandleUnreflectGetter2, jObjectFieldOffset);
            long j17 = unsafe.getLong(h.class, jObjectFieldOffset3);
            f73274l = j16 - j15;
            f73275m = j15 - j17;
        } catch (ReflectiveOperationException e11) {
            Log.e("HiddenApiBypass", "Initialize error", e11);
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (clsArr[i11].isPrimitive()) {
                Class cls = clsArr[i11];
                if (cls == Integer.TYPE && !(objArr[i11] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i11] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i11] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i11] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i11] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i11] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i11] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i11] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i11];
                if (obj != null && !clsArr[i11].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        Set set = f73276n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return d(strArr2);
    }

    public static Object c(@NonNull Class cls, @Nullable Object obj, @NonNull String str, Object... objArr) throws NoSuchMethodException {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = f73263a;
        long j11 = unsafe.getLong(cls, f73268f);
        if (j11 == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i11 = unsafe.getInt(j11);
        for (int i12 = 0; i12 < i11; i12++) {
            f73263a.putLong(declaredMethod, f73264b, (((long) i12) * f73272j) + j11 + f73273k);
            if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean d(@NonNull String... strArr) {
        try {
            c(VMRuntime.class, c(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th2) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th2);
            return false;
        }
    }
}
