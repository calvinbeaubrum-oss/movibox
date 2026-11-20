package c3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.v0;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public class h extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f14571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f14572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f14573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f14574e;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi24Impl", e11.getClass().getName(), e11);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f14572c = constructor;
        f14571b = cls;
        f14573d = method2;
        f14574e = method;
    }

    public static boolean h(Object obj, ByteBuffer byteBuffer, int i11, int i12, boolean z11) {
        try {
            return ((Boolean) f14573d.invoke(obj, byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Boolean.valueOf(z11))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f14571b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f14574e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = f14573d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f14572c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // c3.l
    @Nullable
    public Typeface a(Context context, b3.e.c cVar, Resources resources, int i11) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (b3.e.d dVar : cVar.a()) {
            ByteBuffer byteBufferB = m.b(context, resources, dVar.b());
            if (byteBufferB == null || !h(objK, byteBufferB, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // c3.l
    @Nullable
    public Typeface b(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull androidx.core.provider.g.b[] bVarArr, int i11) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        v0 v0Var = new v0();
        for (androidx.core.provider.g.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) v0Var.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = m.f(context, cancellationSignal, uriD);
                v0Var.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i11);
    }
}
