package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wf {

    /* JADX INFO: compiled from: source.java */
    public class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f24091a;

        public a(Comparator comparator) {
            this.f24091a = comparator;
        }

        @Override // com.applovin.impl.wf.d
        public Map b() {
            return new TreeMap(this.f24091a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Supplier, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24092a;

        public b(int i11) {
            this.f24092a = p3.a(i11, "expectedValuesPerKey");
        }

        @Override // com.applovin.exoplayer2.common.base.Supplier
        public List get() {
            return new ArrayList(this.f24092a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends wf {
        public c() {
            super(null);
        }

        public abstract fc b();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d {

        /* JADX INFO: compiled from: source.java */
        public class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f24093a;

            public a(int i11) {
                this.f24093a = i11;
            }

            @Override // com.applovin.impl.wf.c
            public fc b() {
                return xf.a(d.this.b(), new b(this.f24093a));
            }
        }

        public c a() {
            return a(2);
        }

        public c a(int i11) {
            p3.a(i11, "expectedValuesPerKey");
            return new a(i11);
        }

        public abstract Map b();
    }

    private wf() {
    }

    public /* synthetic */ wf(vf vfVar) {
        this();
    }

    public static d a() {
        return a(wg.a());
    }

    public static d a(Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        return new a(comparator);
    }
}
