package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0390b f38174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0390b f38175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f38176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f38177e;

        /* JADX INFO: compiled from: source.java */
        public static final class a extends C0390b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: com.google.common.base.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0390b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f38178a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f38179b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public C0390b f38180c;

            public C0390b() {
            }
        }

        public b(String str) {
            C0390b c0390b = new C0390b();
            this.f38174b = c0390b;
            this.f38175c = c0390b;
            this.f38176d = false;
            this.f38177e = false;
            this.f38173a = (String) m.p(str);
        }

        public static boolean k(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof Optional) {
                return !((Optional) obj).isPresent();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d11) {
            return i(str, String.valueOf(d11));
        }

        public b b(String str, int i11) {
            return i(str, String.valueOf(i11));
        }

        public b c(String str, long j11) {
            return i(str, String.valueOf(j11));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public final C0390b e() {
            C0390b c0390b = new C0390b();
            this.f38175c.f38180c = c0390b;
            this.f38175c = c0390b;
            return c0390b;
        }

        public final b f(Object obj) {
            e().f38179b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            C0390b c0390bE = e();
            c0390bE.f38179b = obj;
            c0390bE.f38178a = (String) m.p(str);
            return this;
        }

        public final a h() {
            a aVar = new a();
            this.f38175c.f38180c = aVar;
            this.f38175c = aVar;
            return aVar;
        }

        public final b i(String str, Object obj) {
            a aVarH = h();
            aVarH.f38179b = obj;
            aVarH.f38178a = (String) m.p(str);
            return this;
        }

        public b j(Object obj) {
            return f(obj);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0030  */
        /* JADX WARN: Code duplicated, block: B:14:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0041  */
        /* JADX WARN: Code duplicated, block: B:19:0x005e  */
        public String toString() {
            String str;
            boolean z11 = this.f38176d;
            boolean z12 = this.f38177e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f38173a);
            sb2.append('{');
            String str2 = "";
            for (C0390b c0390b = this.f38174b.f38180c; c0390b != null; c0390b = c0390b.f38180c) {
                Object obj = c0390b.f38179b;
                if (c0390b instanceof a) {
                    sb2.append(str2);
                    str = c0390b.f38178a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append('=');
                    }
                    if (obj == null && obj.getClass().isArray()) {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                } else if (obj == null) {
                    if (!z11) {
                        sb2.append(str2);
                        str = c0390b.f38178a;
                        if (str != null) {
                            sb2.append(str);
                            sb2.append('=');
                        }
                        if (obj == null) {
                            sb2.append(obj);
                        } else {
                            sb2.append(obj);
                        }
                        str2 = ", ";
                    }
                } else if (!z12 || !k(obj)) {
                    sb2.append(str2);
                    str = c0390b.f38178a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append('=');
                    }
                    if (obj == null) {
                        sb2.append(obj);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
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
