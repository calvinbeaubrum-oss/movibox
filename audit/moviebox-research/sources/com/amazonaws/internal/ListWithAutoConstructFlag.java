package com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ListWithAutoConstructFlag<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1;
    private boolean autoConstruct;

    public ListWithAutoConstructFlag() {
    }

    public ListWithAutoConstructFlag(int i11) {
        super(i11);
    }

    public ListWithAutoConstructFlag(Collection<? extends T> collection) {
        super(collection);
    }

    public boolean isAutoConstruct() {
        return this.autoConstruct;
    }

    public void setAutoConstruct(boolean z11) {
        this.autoConstruct = z11;
    }
}
