package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? extends Map<?, ?>, ? extends Map<?, ?>> f39609a = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        public ImmutableCell(R r11, C c11, V v11) {
            this.rowKey = r11;
            this.columnKey = c11;
            this.value = v11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public V getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Map<Object, Object>, Map<Object, Object>> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<R, C, V> implements p7.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof p7.a)) {
                return false;
            }
            p7.a aVar = (p7.a) obj;
            return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getRowKey(), aVar.getRowKey()) && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getColumnKey(), aVar.getColumnKey()) && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static boolean a(p7<?, ?, ?> p7Var, Object obj) {
        if (obj == p7Var) {
            return true;
        }
        if (obj instanceof p7) {
            return p7Var.cellSet().equals(((p7) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> p7.a<R, C, V> b(R r11, C c11, V v11) {
        return new ImmutableCell(r11, c11, v11);
    }
}
