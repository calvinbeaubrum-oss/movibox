package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: compiled from: source.java */
    public static final class ArrayListSupplier<V> implements com.google.common.base.q<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i11) {
            this.expectedValuesPerKey = l.b(i11, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: get */
        public List<V> get2() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends d<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f38531a;

        public a(int i11) {
            this.f38531a = i11;
        }

        @Override // com.google.common.collect.MultimapBuilder.d
        public <K, V> Map<K, Collection<V>> c() {
            return p0.d(this.f38531a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends d<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f38532a;

        public b(Comparator comparator) {
            this.f38532a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.d
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f38532a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        public c() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> g0<K, V> e();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<K0> {

        /* JADX INFO: compiled from: source.java */
        public class a extends c<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f38533a;

            public a(int i11) {
                this.f38533a = i11;
            }

            @Override // com.google.common.collect.MultimapBuilder.c
            public <K extends K0, V> g0<K, V> e() {
                return Multimaps.b(d.this.c(), new ArrayListSupplier(this.f38533a));
            }
        }

        public c<K0, Object> a() {
            return b(2);
        }

        public c<K0, Object> b(int i11) {
            l.b(i11, "expectedValuesPerKey");
            return new a(i11);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    public MultimapBuilder() {
    }

    public /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static d<Object> a() {
        return b(8);
    }

    public static d<Object> b(int i11) {
        l.b(i11, "expectedKeys");
        return new a(i11);
    }

    public static d<Comparable> c() {
        return d(Ordering.natural());
    }

    public static <K0> d<K0> d(Comparator<K0> comparator) {
        com.google.common.base.m.p(comparator);
        return new b(comparator);
    }
}
