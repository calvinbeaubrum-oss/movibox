package com.google.firebase.perf.util;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ql.a f41023b = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f41024a;

    public d() {
        this(new Bundle());
    }

    public d(Bundle bundle) {
        this.f41024a = (Bundle) bundle.clone();
    }

    public boolean a(String str) {
        return str != null && this.f41024a.containsKey(str);
    }

    public e<Boolean> b(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Boolean) this.f41024a.get(str));
        } catch (ClassCastException e11) {
            f41023b.b("Metadata key %s contains type other than boolean: %s", str, e11.getMessage());
            return e.a();
        }
    }

    public e<Float> c(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Float) this.f41024a.get(str));
        } catch (ClassCastException e11) {
            f41023b.b("Metadata key %s contains type other than float: %s", str, e11.getMessage());
            return e.a();
        }
    }

    public final e<Integer> d(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Integer) this.f41024a.get(str));
        } catch (ClassCastException e11) {
            f41023b.b("Metadata key %s contains type other than int: %s", str, e11.getMessage());
            return e.a();
        }
    }

    public e<Long> e(String str) {
        e<Integer> eVarD = d(str);
        return eVarD.d() ? e.e(Long.valueOf(eVarD.c().intValue())) : e.a();
    }
}
