package c3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, b3.e.c> f14582a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements b<androidx.core.provider.g.b> {
        public a() {
        }

        @Override // c3.l.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(androidx.core.provider.g.b bVar) {
            return bVar.e();
        }

        @Override // c3.l.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(androidx.core.provider.g.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        boolean a(T t11);

        int b(T t11);
    }

    public static <T> T e(T[] tArr, int i11, b<T> bVar) {
        return (T) f(tArr, (i11 & 1) == 0 ? LogSeverity.WARNING_VALUE : LogSeverity.ALERT_VALUE, (i11 & 2) != 0, bVar);
    }

    public static <T> T f(T[] tArr, int i11, boolean z11, b<T> bVar) {
        T t11 = null;
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (T t12 : tArr) {
            int iAbs = (Math.abs(bVar.b(t12) - i11) * 2) + (bVar.a(t12) == z11 ? 0 : 1);
            if (t11 == null || i12 > iAbs) {
                t11 = t12;
                i12 = iAbs;
            }
        }
        return t11;
    }

    @Nullable
    public Typeface a(Context context, b3.e.c cVar, Resources resources, int i11) {
        throw null;
    }

    @Nullable
    public Typeface b(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull androidx.core.provider.g.b[] bVarArr, int i11) {
        throw null;
    }

    public Typeface c(Context context, InputStream inputStream) {
        File fileE = m.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (m.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    @Nullable
    public Typeface d(Context context, Resources resources, int i11, String str, int i12) {
        File fileE = m.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (m.c(fileE, resources, i11)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public androidx.core.provider.g.b g(androidx.core.provider.g.b[] bVarArr, int i11) {
        return (androidx.core.provider.g.b) e(bVarArr, i11, new a());
    }
}
