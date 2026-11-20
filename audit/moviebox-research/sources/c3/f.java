package c3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x<String, Typeface> f14564b;

    /* JADX INFO: compiled from: source.java */
    public static class a extends androidx.core.provider.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public b3.h.e f14565a;

        public a(@Nullable b3.h.e eVar) {
            this.f14565a = eVar;
        }

        @Override // androidx.core.provider.g.c
        public void a(int i11) {
            b3.h.e eVar = this.f14565a;
            if (eVar != null) {
                eVar.f(i11);
            }
        }

        @Override // androidx.core.provider.g.c
        public void b(@NonNull Typeface typeface) {
            b3.h.e eVar = this.f14565a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            f14563a = new k();
        } else if (i11 >= 28) {
            f14563a = new j();
        } else if (i11 >= 26) {
            f14563a = new i();
        } else if (i11 < 24 || !h.j()) {
            f14563a = new g();
        } else {
            f14563a = new h();
        }
        f14564b = new x<>(16);
    }

    @NonNull
    public static Typeface a(@NonNull Context context, @Nullable Typeface typeface, int i11) {
        if (context != null) {
            return Typeface.create(typeface, i11);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    public static Typeface b(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull androidx.core.provider.g.b[] bVarArr, int i11) {
        return f14563a.b(context, cancellationSignal, bVarArr, i11);
    }

    @Nullable
    public static Typeface c(@NonNull Context context, @NonNull b3.e.b bVar, @NonNull Resources resources, int i11, @Nullable String str, int i12, int i13, @Nullable b3.h.e eVar, @Nullable Handler handler, boolean z11) {
        Typeface typefaceA;
        if (bVar instanceof b3.e.C0139e) {
            b3.e.C0139e c0139e = (b3.e.C0139e) bVar;
            Typeface typefaceG = g(c0139e.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = androidx.core.provider.g.c(context, c0139e.b(), i13, !z11 ? eVar != null : c0139e.a() != 0, z11 ? c0139e.d() : -1, b3.h.e.e(handler), new a(eVar));
        } else {
            typefaceA = f14563a.a(context, (b3.e.c) bVar, resources, i13);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f14564b.put(e(resources, i11, str, i12, i13), typefaceA);
        }
        return typefaceA;
    }

    @Nullable
    public static Typeface d(@NonNull Context context, @NonNull Resources resources, int i11, String str, int i12, int i13) {
        Typeface typefaceD = f14563a.d(context, resources, i11, str, i13);
        if (typefaceD != null) {
            f14564b.put(e(resources, i11, str, i12, i13), typefaceD);
        }
        return typefaceD;
    }

    public static String e(Resources resources, int i11, String str, int i12, int i13) {
        return resources.getResourcePackageName(i11) + '-' + str + '-' + i12 + '-' + i11 + '-' + i13;
    }

    @Nullable
    public static Typeface f(@NonNull Resources resources, int i11, @Nullable String str, int i12, int i13) {
        return f14564b.get(e(resources, i11, str, i12, i13));
    }

    public static Typeface g(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
