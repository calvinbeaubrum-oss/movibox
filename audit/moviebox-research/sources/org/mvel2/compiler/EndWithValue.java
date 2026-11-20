package org.mvel2.compiler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class EndWithValue extends RuntimeException {
    private Object value;

    public EndWithValue(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }
}
