package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j7 extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final k7 f19872o;

    public j7(List list) {
        super("DvbDecoder");
        bh bhVar = new bh((byte[]) list.get(0));
        this.f19872o = new k7(bhVar.C(), bhVar.C());
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) {
        if (z11) {
            this.f19872o.d();
        }
        return new l7(this.f19872o.a(bArr, i11));
    }
}
