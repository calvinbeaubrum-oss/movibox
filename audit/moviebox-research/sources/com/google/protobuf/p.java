package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f41384b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile p f41385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f41386d = new p(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.e<?, ?>> f41387a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f41388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41389b;

        public a(Object obj, int i11) {
            this.f41388a = obj;
            this.f41389b = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f41388a == aVar.f41388a && this.f41389b == aVar.f41389b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f41388a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f41389b;
        }
    }

    public p() {
        this.f41387a = new HashMap();
    }

    public p(boolean z11) {
        this.f41387a = Collections.emptyMap();
    }

    public static p b() {
        p pVarA = f41385c;
        if (pVarA == null) {
            synchronized (p.class) {
                try {
                    pVarA = f41385c;
                    if (pVarA == null) {
                        pVarA = f41384b ? o.a() : f41386d;
                        f41385c = pVarA;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pVarA;
    }

    public <ContainingType extends n0> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i11) {
        return (GeneratedMessageLite.e) this.f41387a.get(new a(containingtype, i11));
    }
}
