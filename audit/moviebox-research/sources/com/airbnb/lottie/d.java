package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15078a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15079b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15080c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f15081d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AsyncUpdates f15082e = AsyncUpdates.AUTOMATIC;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static e7.e f15083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e7.d f15084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile e7.g f15085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile e7.f f15086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ThreadLocal<g7.h> f15087j;

    public static void b(String str) {
        if (f15079b) {
            f().a(str);
        }
    }

    public static float c(String str) {
        if (f15079b) {
            return f().b(str);
        }
        return 0.0f;
    }

    public static AsyncUpdates d() {
        return f15082e;
    }

    public static boolean e() {
        return f15081d;
    }

    public static g7.h f() {
        g7.h hVar = f15087j.get();
        if (hVar != null) {
            return hVar;
        }
        g7.h hVar2 = new g7.h();
        f15087j.set(hVar2);
        return hVar2;
    }

    public static boolean g() {
        return f15079b;
    }

    public static /* synthetic */ File h(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    @Nullable
    public static e7.f i(@NonNull Context context) {
        if (!f15080c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        e7.f fVar = f15086i;
        if (fVar == null) {
            synchronized (e7.f.class) {
                try {
                    fVar = f15086i;
                    if (fVar == null) {
                        e7.d dVar = f15084g;
                        if (dVar == null) {
                            dVar = new e7.d() { // from class: com.airbnb.lottie.c
                                @Override // e7.d
                                public final File a() {
                                    return d.h(applicationContext);
                                }
                            };
                        }
                        fVar = new e7.f(dVar);
                        f15086i = fVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return fVar;
    }

    @NonNull
    public static e7.g j(@NonNull Context context) {
        e7.g gVar = f15085h;
        if (gVar == null) {
            synchronized (e7.g.class) {
                try {
                    gVar = f15085h;
                    if (gVar == null) {
                        e7.f fVarI = i(context);
                        e7.e bVar = f15083f;
                        if (bVar == null) {
                            bVar = new e7.b();
                        }
                        gVar = new e7.g(fVarI, bVar);
                        f15085h = gVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return gVar;
    }
}
