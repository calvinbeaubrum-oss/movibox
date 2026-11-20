package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f39715a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k2 f39716b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k2 f39717c = new b(1);

    /* JADX INFO: compiled from: source.java */
    public static class a extends k2 {
        public a() {
            super(null);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k2
        public k2 d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k2
        public int e() {
            return 0;
        }

        public k2 g(int i11) {
            if (i11 < 0) {
                return k2.f39716b;
            }
            return i11 > 0 ? k2.f39717c : k2.f39715a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends k2 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f39718d;

        public b(int i11) {
            super(null);
            this.f39718d = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k2
        public k2 d(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.k2
        public int e() {
            return this.f39718d;
        }
    }

    public k2() {
    }

    public /* synthetic */ k2(a aVar) {
        this();
    }

    public static k2 f() {
        return f39715a;
    }

    public abstract k2 d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();
}
