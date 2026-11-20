package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: compiled from: source.java */
    public static final class ArrayListSupplier<V> implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i11) {
            this.expectedValuesPerKey = n1.b(i11, "expectedValuesPerKey");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q, java.util.function.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class LinkedHashSetSupplier<V> implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i11) {
            this.expectedValuesPerKey = n1.b(i11, "expectedValuesPerKey");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q, java.util.function.Supplier
        public Set<V> get() {
            return r6.e(this.expectedValuesPerKey);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends c<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f39524a;

        public a(int i11) {
            this.f39524a = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MultimapBuilder.c
        public <K, V> Map<K, Collection<V>> c() {
            return r6.d(this.f39524a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<K0, V0> extends MultimapBuilder<K0, V0> {
        public b() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> q5<K, V> c();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c<K0> {

        /* JADX INFO: compiled from: source.java */
        public class a extends b<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f39525a;

            public a(int i11) {
                this.f39525a = i11;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MultimapBuilder.b
            public <K extends K0, V> q5<K, V> c() {
                return Multimaps.g(c.this.c(), new ArrayListSupplier(this.f39525a));
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends d<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f39527a;

            public b(int i11) {
                this.f39527a = i11;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MultimapBuilder.d
            public <K extends K0, V> z6<K, V> c() {
                return Multimaps.h(c.this.c(), new LinkedHashSetSupplier(this.f39527a));
            }
        }

        public b<K0, Object> a() {
            return b(2);
        }

        public b<K0, Object> b(int i11) {
            n1.b(i11, "expectedValuesPerKey");
            return new a(i11);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public d<K0, Object> d() {
            return e(2);
        }

        public d<K0, Object> e(int i11) {
            n1.b(i11, "expectedValuesPerKey");
            return new b(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<K0, V0> extends MultimapBuilder<K0, V0> {
        public d() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> z6<K, V> c();
    }

    public MultimapBuilder() {
    }

    public /* synthetic */ MultimapBuilder(a6 a6Var) {
        this();
    }

    public static c<Object> a() {
        return b(8);
    }

    public static c<Object> b(int i11) {
        n1.b(i11, "expectedKeys");
        return new a(i11);
    }
}
