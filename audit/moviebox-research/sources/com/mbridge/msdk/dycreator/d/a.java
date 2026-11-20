package com.mbridge.msdk.dycreator.d;

import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f43665a;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.d.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43666a;

        static {
            int[] iArr = new int[EnumC0481a.values().length];
            f43666a = iArr;
            try {
                iArr[EnumC0481a.VIEW_OBSERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43666a[EnumC0481a.CLICK_OBSERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43666a[EnumC0481a.EFFECT_OBSERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43666a[EnumC0481a.REPORT_OBSERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public enum EnumC0481a {
        VIEW_OBSERVER,
        CLICK_OBSERVER,
        EFFECT_OBSERVER,
        REPORT_OBSERVER
    }

    private a() {
    }

    public static a a() {
        if (f43665a == null) {
            synchronized (a.class) {
                try {
                    if (f43665a == null) {
                        f43665a = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43665a;
    }

    public final <T extends com.mbridge.msdk.dycreator.g.a> T a(EnumC0481a enumC0481a) {
        int i11 = AnonymousClass1.f43666a[enumC0481a.ordinal()];
        if (i11 == 1) {
            return new d();
        }
        if (i11 == 2) {
            return new c();
        }
        if (i11 == 3) {
            return new f();
        }
        if (i11 != 4) {
            return null;
        }
        return new h();
    }
}
