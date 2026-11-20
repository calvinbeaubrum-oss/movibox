package com.google.android.material.internal;

import android.widget.Checkable;
import androidx.annotation.Nullable;
import com.google.android.material.internal.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface l<T extends l<T>> extends Checkable {

    /* JADX INFO: compiled from: source.java */
    public interface a<C> {
        void a(C c11, boolean z11);
    }

    int getId();

    void setInternalOnCheckedChangeListener(@Nullable a<T> aVar);
}
