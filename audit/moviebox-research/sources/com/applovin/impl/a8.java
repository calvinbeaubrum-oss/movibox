package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a8 extends nh {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o2.a f17469l = new o2.a() { // from class: com.applovin.impl.qs
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return a8.c(bundle);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17470d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f9 f17473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f17474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final yd f17475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f17476k;

    private a8(int i11, Throwable th2, int i12) {
        this(i11, th2, null, i12, null, -1, null, 4, false);
    }

    private a8(int i11, Throwable th2, String str, int i12, String str2, int i13, f9 f9Var, int i14, boolean z11) {
        this(a(i11, str, str2, i13, f9Var, i14), th2, i12, i11, str2, i13, f9Var, i14, null, SystemClock.elapsedRealtime(), z11);
    }

    private a8(Bundle bundle) {
        super(bundle);
        this.f17470d = bundle.getInt(nh.b(1001), 2);
        this.f17471f = bundle.getString(nh.b(1002));
        this.f17472g = bundle.getInt(nh.b(1003), -1);
        this.f17473h = (f9) p2.a(f9.I, bundle.getBundle(nh.b(1004)));
        this.f17474i = bundle.getInt(nh.b(1005), 4);
        this.f17476k = bundle.getBoolean(nh.b(PointerIconCompat.TYPE_CELL), false);
        this.f17475j = null;
    }

    private a8(String str, Throwable th2, int i11, int i12, String str2, int i13, f9 f9Var, int i14, yd ydVar, long j11, boolean z11) {
        super(str, th2, i11, j11);
        b1.a(!z11 || i12 == 1);
        b1.a(th2 != null || i12 == 3);
        this.f17470d = i12;
        this.f17471f = str2;
        this.f17472g = i13;
        this.f17473h = f9Var;
        this.f17474i = i14;
        this.f17475j = ydVar;
        this.f17476k = z11;
    }

    public static a8 a(IOException iOException, int i11) {
        return new a8(0, iOException, i11);
    }

    public static a8 a(RuntimeException runtimeException) {
        return a(runtimeException, 1000);
    }

    public static a8 a(RuntimeException runtimeException, int i11) {
        return new a8(2, runtimeException, i11);
    }

    public static a8 a(Throwable th2, String str, int i11, f9 f9Var, int i12, boolean z11, int i13) {
        return new a8(1, th2, null, i13, str, i11, f9Var, f9Var == null ? 4 : i12, z11);
    }

    private static String a(int i11, String str, String str2, int i12, f9 f9Var, int i13) {
        String str3;
        if (i11 == 0) {
            str3 = "Source error";
        } else if (i11 != 1) {
            str3 = i11 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i12 + ", format=" + f9Var + ", format_supported=" + t2.b(i13);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    public static /* synthetic */ a8 c(Bundle bundle) {
        return new a8(bundle);
    }

    public a8 a(yd ydVar) {
        return new a8((String) xp.a((Object) getMessage()), getCause(), this.f21333a, this.f17470d, this.f17471f, this.f17472g, this.f17473h, this.f17474i, ydVar, this.f21334b, this.f17476k);
    }
}
