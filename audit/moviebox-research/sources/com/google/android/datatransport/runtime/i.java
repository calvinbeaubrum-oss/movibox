package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public final a a(String str, int i11) {
            e().put(str, String.valueOf(i11));
            return this;
        }

        public final a b(String str, long j11) {
            e().put(str, String.valueOf(j11));
            return this;
        }

        public final a c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract i d();

        public abstract Map<String, String> e();

        public abstract a f(Map<String, String> map);

        public abstract a g(Integer num);

        public abstract a h(h hVar);

        public abstract a i(long j11);

        public abstract a j(Integer num);

        public abstract a k(String str);

        public abstract a l(long j11);
    }

    public static a a() {
        return new b.C0355b().f(new HashMap());
    }

    public final String b(String str) {
        String str2 = c().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> c();

    @Nullable
    public abstract Integer d();

    public abstract h e();

    public abstract long f();

    public final int g(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long h(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> i() {
        return Collections.unmodifiableMap(c());
    }

    @Nullable
    public abstract Integer j();

    public abstract String k();

    public abstract long l();

    public a m() {
        return new b.C0355b().k(k()).g(d()).j(j()).h(e()).i(f()).l(l()).f(new HashMap(c()));
    }
}
