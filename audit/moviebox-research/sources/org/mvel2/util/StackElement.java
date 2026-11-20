package org.mvel2.util;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class StackElement implements Serializable {
    public StackElement next;
    public Object value;

    public StackElement(StackElement stackElement, Object obj) {
        this.next = stackElement;
        this.value = obj;
    }
}
