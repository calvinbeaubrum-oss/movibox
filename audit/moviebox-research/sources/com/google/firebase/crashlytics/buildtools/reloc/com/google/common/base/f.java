package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f39084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f39085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f39086d;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f39087a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f39088b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public a f39089c;

            public a() {
            }
        }

        public b(String str) {
            a aVar = new a();
            this.f39084b = aVar;
            this.f39085c = aVar;
            this.f39086d = false;
            this.f39083a = (String) l.n(str);
        }

        public b a(String str, double d11) {
            return g(str, String.valueOf(d11));
        }

        public b b(String str, int i11) {
            return g(str, String.valueOf(i11));
        }

        public b c(String str, long j11) {
            return g(str, String.valueOf(j11));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public final a e() {
            a aVar = new a();
            this.f39085c.f39089c = aVar;
            this.f39085c = aVar;
            return aVar;
        }

        public final b f(Object obj) {
            e().f39088b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            a aVarE = e();
            aVarE.f39088b = obj;
            aVarE.f39087a = (String) l.n(str);
            return this;
        }

        public b h(Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z11 = this.f39086d;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f39083a);
            sb2.append('{');
            String str = "";
            for (a aVar = this.f39084b.f39089c; aVar != null; aVar = aVar.f39089c) {
                Object obj = aVar.f39088b;
                if (!z11 || obj != null) {
                    sb2.append(str);
                    String str2 = aVar.f39087a;
                    if (str2 != null) {
                        sb2.append(str2);
                        sb2.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static <T> T a(T t11, T t12) {
        if (t11 != null) {
            return t11;
        }
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
