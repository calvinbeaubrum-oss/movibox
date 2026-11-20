package c3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class g extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f14566b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Constructor<?> f14567c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f14568d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f14569e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f14570f = false;

    public static boolean h(Object obj, String str, int i11, boolean z11) {
        k();
        try {
            return ((Boolean) f14568d.invoke(obj, str, Integer.valueOf(i11), Boolean.valueOf(z11))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static Typeface i(Object obj) {
        k();
        try {
            Object objNewInstance = Array.newInstance(f14566b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f14569e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static void k() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f14570f) {
            return;
        }
        f14570f = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi21Impl", e11.getClass().getName(), e11);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f14567c = constructor;
        f14566b = cls;
        f14568d = method2;
        f14569e = method;
    }

    private static Object l() {
        k();
        try {
            return f14567c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // c3.l
    public Typeface a(Context context, b3.e.c cVar, Resources resources, int i11) {
        Object objL = l();
        for (b3.e.d dVar : cVar.a()) {
            File fileE = m.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!m.c(fileE, resources, dVar.b())) {
                    return null;
                }
                if (!h(objL, fileE.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return i(objL);
    }

    @Override // c3.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull androidx.core.provider.g.b[] bVarArr, int i11) {
        if (bVarArr.length < 1) {
            return null;
        }
        androidx.core.provider.g.b bVarG = g(bVarArr, i11);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarG.d(), CampaignEx.JSON_KEY_AD_R, cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileJ = j(parcelFileDescriptorOpenFileDescriptor);
                if (fileJ != null && fileJ.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileJ);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceC = super.c(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceC;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final File j(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
