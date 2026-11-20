package com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.common.base.f<? extends Map<?, ?>, ? extends Map<?, ?>> f38619a = new a();

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

        @Override // com.google.common.collect.b1.a
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.b1.a
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.b1.a
        public V getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements com.google.common.base.f<Map<Object, Object>, Map<Object, Object>> {
        @Override // com.google.common.base.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<R, C, V> implements b1.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b1.a)) {
                return false;
            }
            b1.a aVar = (b1.a) obj;
            return com.google.common.base.j.a(getRowKey(), aVar.getRowKey()) && com.google.common.base.j.a(getColumnKey(), aVar.getColumnKey()) && com.google.common.base.j.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return com.google.common.base.j.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static boolean a(b1<?, ?, ?> b1Var, Object obj) {
        if (obj == b1Var) {
            return true;
        }
        if (obj instanceof b1) {
            return b1Var.cellSet().equals(((b1) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> b1.a<R, C, V> b(R r11, C c11, V v11) {
        return new ImmutableCell(r11, c11, v11);
    }
}
