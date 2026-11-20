package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class CrashlyticsReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f40240a = Charset.forName("UTF-8");

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class a {

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static abstract class AbstractC0425a {
            @NonNull
            public abstract a a();

            @NonNull
            public abstract AbstractC0425a b(@NonNull int i11);

            @NonNull
            public abstract AbstractC0425a c(@NonNull int i11);

            @NonNull
            public abstract AbstractC0425a d(@NonNull String str);

            @NonNull
            public abstract AbstractC0425a e(@NonNull long j11);

            @NonNull
            public abstract AbstractC0425a f(@NonNull int i11);

            @NonNull
            public abstract AbstractC0425a g(@NonNull long j11);

            @NonNull
            public abstract AbstractC0425a h(@NonNull long j11);

            @NonNull
            public abstract AbstractC0425a i(@Nullable String str);
        }

        @NonNull
        public static AbstractC0425a a() {
            return new com.google.firebase.crashlytics.internal.model.c.b();
        }

        @NonNull
        public abstract int b();

        @NonNull
        public abstract int c();

        @NonNull
        public abstract String d();

        @NonNull
        public abstract long e();

        @NonNull
        public abstract int f();

        @NonNull
        public abstract long g();

        @NonNull
        public abstract long h();

        @Nullable
        public abstract String i();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class b {
        @NonNull
        public abstract CrashlyticsReport a();

        @NonNull
        public abstract b b(@NonNull String str);

        @NonNull
        public abstract b c(@NonNull String str);

        @NonNull
        public abstract b d(@NonNull String str);

        @NonNull
        public abstract b e(@NonNull String str);

        @NonNull
        public abstract b f(d dVar);

        @NonNull
        public abstract b g(int i11);

        @NonNull
        public abstract b h(@NonNull String str);

        @NonNull
        public abstract b i(@NonNull e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class c {

        /* JADX INFO: compiled from: source.java */
        public static abstract class a {
            @NonNull
            public abstract c a();

            @NonNull
            public abstract a b(@NonNull String str);

            @NonNull
            public abstract a c(@NonNull String str);
        }

        @NonNull
        public static a a() {
            return new com.google.firebase.crashlytics.internal.model.d.b();
        }

        @NonNull
        public abstract String b();

        @NonNull
        public abstract String c();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class d {

        /* JADX INFO: compiled from: source.java */
        public static abstract class a {
            public abstract d a();

            public abstract a b(kk.e<b> eVar);

            public abstract a c(String str);
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class b {

            /* JADX INFO: compiled from: source.java */
            public static abstract class a {
                public abstract b a();

                public abstract a b(byte[] bArr);

                public abstract a c(String str);
            }

            @NonNull
            public static a a() {
                return new f.b();
            }

            @NonNull
            public abstract byte[] b();

            @NonNull
            public abstract String c();
        }

        @NonNull
        public static a a() {
            return new com.google.firebase.crashlytics.internal.model.e.b();
        }

        @NonNull
        public abstract kk.e<b> b();

        @Nullable
        public abstract String c();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class e {

        /* JADX INFO: compiled from: source.java */
        public static abstract class a {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public static abstract class AbstractC0426a {
                @NonNull
                public abstract a a();

                @NonNull
                public abstract AbstractC0426a b(@Nullable String str);

                @NonNull
                public abstract AbstractC0426a c(@Nullable String str);

                @NonNull
                public abstract AbstractC0426a d(@NonNull String str);

                @NonNull
                public abstract AbstractC0426a e(@NonNull String str);

                @NonNull
                public abstract AbstractC0426a f(@NonNull String str);

                @NonNull
                public abstract AbstractC0426a g(@NonNull String str);
            }

            /* JADX INFO: compiled from: source.java */
            public static abstract class b {
                @NonNull
                public abstract String a();
            }

            @NonNull
            public static AbstractC0426a a() {
                return new h.b();
            }

            @Nullable
            public abstract String b();

            @Nullable
            public abstract String c();

            @Nullable
            public abstract String d();

            @NonNull
            public abstract String e();

            @Nullable
            public abstract String f();

            @Nullable
            public abstract b g();

            @NonNull
            public abstract String h();
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class b {
            @NonNull
            public abstract e a();

            @NonNull
            public abstract b b(@NonNull a aVar);

            @NonNull
            public abstract b c(boolean z11);

            @NonNull
            public abstract b d(@NonNull c cVar);

            @NonNull
            public abstract b e(@NonNull Long l11);

            @NonNull
            public abstract b f(@NonNull kk.e<d> eVar);

            @NonNull
            public abstract b g(@NonNull String str);

            @NonNull
            public abstract b h(int i11);

            @NonNull
            public abstract b i(@NonNull String str);

            @NonNull
            public b j(@NonNull byte[] bArr) {
                return i(new String(bArr, CrashlyticsReport.f40240a));
            }

            @NonNull
            public abstract b k(@NonNull AbstractC0439e abstractC0439e);

            @NonNull
            public abstract b l(long j11);

            @NonNull
            public abstract b m(@NonNull f fVar);
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class c {

            /* JADX INFO: compiled from: source.java */
            public static abstract class a {
                @NonNull
                public abstract c a();

                @NonNull
                public abstract a b(int i11);

                @NonNull
                public abstract a c(int i11);

                @NonNull
                public abstract a d(long j11);

                @NonNull
                public abstract a e(@NonNull String str);

                @NonNull
                public abstract a f(@NonNull String str);

                @NonNull
                public abstract a g(@NonNull String str);

                @NonNull
                public abstract a h(long j11);

                @NonNull
                public abstract a i(boolean z11);

                @NonNull
                public abstract a j(int i11);
            }

            @NonNull
            public static a a() {
                return new j.b();
            }

            @NonNull
            public abstract int b();

            public abstract int c();

            public abstract long d();

            @NonNull
            public abstract String e();

            @NonNull
            public abstract String f();

            @NonNull
            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class d {

            /* JADX INFO: compiled from: source.java */
            public static abstract class a {

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: source.java */
                public static abstract class AbstractC0427a {
                    @NonNull
                    public abstract a a();

                    @NonNull
                    public abstract AbstractC0427a b(@Nullable Boolean bool);

                    @NonNull
                    public abstract AbstractC0427a c(@NonNull kk.e<c> eVar);

                    @NonNull
                    public abstract AbstractC0427a d(@NonNull b bVar);

                    @NonNull
                    public abstract AbstractC0427a e(@NonNull kk.e<c> eVar);

                    @NonNull
                    public abstract AbstractC0427a f(int i11);
                }

                /* JADX INFO: compiled from: source.java */
                public static abstract class b {

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$a, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    public static abstract class AbstractC0428a {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$a$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: source.java */
                        public static abstract class AbstractC0429a {
                            @NonNull
                            public abstract AbstractC0428a a();

                            @NonNull
                            public abstract AbstractC0429a b(long j11);

                            @NonNull
                            public abstract AbstractC0429a c(@NonNull String str);

                            @NonNull
                            public abstract AbstractC0429a d(long j11);

                            @NonNull
                            public abstract AbstractC0429a e(@Nullable String str);

                            @NonNull
                            public AbstractC0429a f(@NonNull byte[] bArr) {
                                return e(new String(bArr, CrashlyticsReport.f40240a));
                            }
                        }

                        @NonNull
                        public static AbstractC0429a a() {
                            return new n.b();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        public abstract long d();

                        @Nullable
                        public abstract String e();

                        @Nullable
                        public byte[] f() {
                            String strE = e();
                            if (strE != null) {
                                return strE.getBytes(CrashlyticsReport.f40240a);
                            }
                            return null;
                        }
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$b, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    public static abstract class AbstractC0430b {
                        @NonNull
                        public abstract b a();

                        @NonNull
                        public abstract AbstractC0430b b(@NonNull a aVar);

                        @NonNull
                        public abstract AbstractC0430b c(@NonNull kk.e<AbstractC0428a> eVar);

                        @NonNull
                        public abstract AbstractC0430b d(@NonNull c cVar);

                        @NonNull
                        public abstract AbstractC0430b e(@NonNull AbstractC0432d abstractC0432d);

                        @NonNull
                        public abstract AbstractC0430b f(@NonNull kk.e<AbstractC0434e> eVar);
                    }

                    /* JADX INFO: compiled from: source.java */
                    public static abstract class c {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$c$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: source.java */
                        public static abstract class AbstractC0431a {
                            @NonNull
                            public abstract c a();

                            @NonNull
                            public abstract AbstractC0431a b(@NonNull c cVar);

                            @NonNull
                            public abstract AbstractC0431a c(@NonNull kk.e<AbstractC0434e.AbstractC0436b> eVar);

                            @NonNull
                            public abstract AbstractC0431a d(int i11);

                            @NonNull
                            public abstract AbstractC0431a e(@NonNull String str);

                            @NonNull
                            public abstract AbstractC0431a f(@NonNull String str);
                        }

                        @NonNull
                        public static AbstractC0431a a() {
                            return new o.b();
                        }

                        @Nullable
                        public abstract c b();

                        @NonNull
                        public abstract kk.e<AbstractC0434e.AbstractC0436b> c();

                        public abstract int d();

                        @Nullable
                        public abstract String e();

                        @NonNull
                        public abstract String f();
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$d, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    public static abstract class AbstractC0432d {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$d$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: source.java */
                        public static abstract class AbstractC0433a {
                            @NonNull
                            public abstract AbstractC0432d a();

                            @NonNull
                            public abstract AbstractC0433a b(long j11);

                            @NonNull
                            public abstract AbstractC0433a c(@NonNull String str);

                            @NonNull
                            public abstract AbstractC0433a d(@NonNull String str);
                        }

                        @NonNull
                        public static AbstractC0433a a() {
                            return new p.b();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        @NonNull
                        public abstract String d();
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    public static abstract class AbstractC0434e {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: source.java */
                        public static abstract class AbstractC0435a {
                            @NonNull
                            public abstract AbstractC0434e a();

                            @NonNull
                            public abstract AbstractC0435a b(@NonNull kk.e<AbstractC0436b> eVar);

                            @NonNull
                            public abstract AbstractC0435a c(int i11);

                            @NonNull
                            public abstract AbstractC0435a d(@NonNull String str);
                        }

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$b, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: source.java */
                        public static abstract class AbstractC0436b {

                            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$b$a, reason: collision with other inner class name */
                            /* JADX INFO: compiled from: source.java */
                            public static abstract class AbstractC0437a {
                                @NonNull
                                public abstract AbstractC0436b a();

                                @NonNull
                                public abstract AbstractC0437a b(@NonNull String str);

                                @NonNull
                                public abstract AbstractC0437a c(int i11);

                                @NonNull
                                public abstract AbstractC0437a d(long j11);

                                @NonNull
                                public abstract AbstractC0437a e(long j11);

                                @NonNull
                                public abstract AbstractC0437a f(@NonNull String str);
                            }

                            @NonNull
                            public static AbstractC0437a a() {
                                return new r.b();
                            }

                            @Nullable
                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            @NonNull
                            public abstract String f();
                        }

                        @NonNull
                        public static AbstractC0435a a() {
                            return new q.b();
                        }

                        @NonNull
                        public abstract kk.e<AbstractC0436b> b();

                        public abstract int c();

                        @NonNull
                        public abstract String d();
                    }

                    @NonNull
                    public static AbstractC0430b a() {
                        return new m.b();
                    }

                    @Nullable
                    public abstract a b();

                    @NonNull
                    public abstract kk.e<AbstractC0428a> c();

                    @Nullable
                    public abstract c d();

                    @NonNull
                    public abstract AbstractC0432d e();

                    @Nullable
                    public abstract kk.e<AbstractC0434e> f();
                }

                @NonNull
                public static AbstractC0427a a() {
                    return new l.b();
                }

                @Nullable
                public abstract Boolean b();

                @Nullable
                public abstract kk.e<c> c();

                @NonNull
                public abstract b d();

                @Nullable
                public abstract kk.e<c> e();

                public abstract int f();

                @NonNull
                public abstract AbstractC0427a g();
            }

            /* JADX INFO: compiled from: source.java */
            public static abstract class b {
                @NonNull
                public abstract d a();

                @NonNull
                public abstract b b(@NonNull a aVar);

                @NonNull
                public abstract b c(@NonNull c cVar);

                @NonNull
                public abstract b d(@NonNull AbstractC0438d abstractC0438d);

                @NonNull
                public abstract b e(long j11);

                @NonNull
                public abstract b f(@NonNull String str);
            }

            /* JADX INFO: compiled from: source.java */
            public static abstract class c {

                /* JADX INFO: compiled from: source.java */
                public static abstract class a {
                    @NonNull
                    public abstract c a();

                    @NonNull
                    public abstract a b(Double d11);

                    @NonNull
                    public abstract a c(int i11);

                    @NonNull
                    public abstract a d(long j11);

                    @NonNull
                    public abstract a e(int i11);

                    @NonNull
                    public abstract a f(boolean z11);

                    @NonNull
                    public abstract a g(long j11);
                }

                @NonNull
                public static a a() {
                    return new s.b();
                }

                @Nullable
                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$d, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public static abstract class AbstractC0438d {

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$d$a */
                /* JADX INFO: compiled from: source.java */
                public static abstract class a {
                    @NonNull
                    public abstract AbstractC0438d a();

                    @NonNull
                    public abstract a b(@NonNull String str);
                }

                @NonNull
                public static a a() {
                    return new t.b();
                }

                @NonNull
                public abstract String b();
            }

            @NonNull
            public static b a() {
                return new k.b();
            }

            @NonNull
            public abstract a b();

            @NonNull
            public abstract c c();

            @Nullable
            public abstract AbstractC0438d d();

            public abstract long e();

            @NonNull
            public abstract String f();

            @NonNull
            public abstract b g();
        }

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static abstract class AbstractC0439e {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$e$a */
            /* JADX INFO: compiled from: source.java */
            public static abstract class a {
                @NonNull
                public abstract AbstractC0439e a();

                @NonNull
                public abstract a b(@NonNull String str);

                @NonNull
                public abstract a c(boolean z11);

                @NonNull
                public abstract a d(int i11);

                @NonNull
                public abstract a e(@NonNull String str);
            }

            @NonNull
            public static a a() {
                return new u.b();
            }

            @NonNull
            public abstract String b();

            public abstract int c();

            @NonNull
            public abstract String d();

            public abstract boolean e();
        }

        /* JADX INFO: compiled from: source.java */
        public static abstract class f {

            /* JADX INFO: compiled from: source.java */
            public static abstract class a {
                @NonNull
                public abstract f a();

                @NonNull
                public abstract a b(@NonNull String str);
            }

            @NonNull
            public static a a() {
                return new v.b();
            }

            @NonNull
            public abstract String b();
        }

        @NonNull
        public static b a() {
            return new g.b().c(false);
        }

        @NonNull
        public abstract a b();

        @Nullable
        public abstract c c();

        @Nullable
        public abstract Long d();

        @Nullable
        public abstract kk.e<d> e();

        @NonNull
        public abstract String f();

        public abstract int g();

        @NonNull
        public abstract String h();

        @NonNull
        public byte[] i() {
            return h().getBytes(CrashlyticsReport.f40240a);
        }

        @Nullable
        public abstract AbstractC0439e j();

        public abstract long k();

        @Nullable
        public abstract f l();

        public abstract boolean m();

        @NonNull
        public abstract b n();

        @NonNull
        public e o(@NonNull kk.e<d> eVar) {
            return n().f(eVar).a();
        }

        @NonNull
        public e p(long j11, boolean z11, @Nullable String str) {
            b bVarN = n();
            bVarN.e(Long.valueOf(j11));
            bVarN.c(z11);
            if (str != null) {
                bVarN.m(f.a().b(str).a());
            }
            return bVarN.a();
        }
    }

    @NonNull
    public static b b() {
        return new com.google.firebase.crashlytics.internal.model.b.C0441b();
    }

    @NonNull
    public abstract String c();

    @NonNull
    public abstract String d();

    @NonNull
    public abstract String e();

    @NonNull
    public abstract String f();

    @Nullable
    public abstract d g();

    public abstract int h();

    @NonNull
    public abstract String i();

    @Nullable
    public abstract e j();

    @NonNull
    public abstract b k();

    @NonNull
    public CrashlyticsReport l(@NonNull kk.e<e.d> eVar) {
        if (j() != null) {
            return k().i(j().o(eVar)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    @NonNull
    public CrashlyticsReport m(@NonNull d dVar) {
        return k().i(null).f(dVar).a();
    }

    @NonNull
    public CrashlyticsReport n(long j11, boolean z11, @Nullable String str) {
        b bVarK = k();
        if (j() != null) {
            bVarK.i(j().p(j11, z11, str));
        }
        return bVarK.a();
    }
}
