package org.mvel2.ast;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ReduceableCodeException extends RuntimeException {
    private Object literal;

    public ReduceableCodeException(Object obj) {
        this.literal = obj;
    }

    public Object getLiteral() {
        return this.literal;
    }
}
