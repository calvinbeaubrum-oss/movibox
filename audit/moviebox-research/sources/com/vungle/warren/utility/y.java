package com.vungle.warren.utility;

import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class y implements com.vungle.warren.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<com.vungle.warren.m> f62642a;

    public y(com.vungle.warren.m mVar) {
        this.f62642a = new WeakReference<>(mVar);
    }

    @Override // com.vungle.warren.m
    public void onAdLoad(String str) {
        com.vungle.warren.m mVar = this.f62642a.get();
        if (mVar != null) {
            mVar.onAdLoad(str);
        }
    }

    @Override // com.vungle.warren.m
    public void onError(String str, VungleException vungleException) {
        com.vungle.warren.m mVar = this.f62642a.get();
        if (mVar != null) {
            mVar.onError(str, vungleException);
        }
    }
}
