package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import dg.d;
import fg.c;
import fg.f;
import fg.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory implements c {
    @Override // fg.c
    public k create(f fVar) {
        return new d(fVar.b(), fVar.e(), fVar.d());
    }
}
