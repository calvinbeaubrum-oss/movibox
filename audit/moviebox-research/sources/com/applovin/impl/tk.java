package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class tk extends dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f23385a = new bh();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f23386b = new ah();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ho f23387c;

    @Override // com.applovin.impl.dk
    public bf a(ef efVar, ByteBuffer byteBuffer) {
        bf.b vkVar;
        ho hoVar = this.f23387c;
        if (hoVar == null || efVar.f18693j != hoVar.c()) {
            ho hoVar2 = new ho(efVar.f21657f);
            this.f23387c = hoVar2;
            hoVar2.a(efVar.f21657f - efVar.f18693j);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f23385a.a(bArrArray, iLimit);
        this.f23386b.a(bArrArray, iLimit);
        this.f23386b.d(39);
        long jA = (((long) this.f23386b.a(1)) << 32) | ((long) this.f23386b.a(32));
        this.f23386b.d(20);
        int iA = this.f23386b.a(12);
        int iA2 = this.f23386b.a(8);
        this.f23385a.g(14);
        if (iA2 == 0) {
            vkVar = new vk();
        } else if (iA2 == 255) {
            vkVar = yh.a(this.f23385a, iA, jA);
        } else if (iA2 == 4) {
            vkVar = wk.a(this.f23385a);
        } else if (iA2 != 5) {
            vkVar = iA2 != 6 ? null : Cdo.a(this.f23385a, jA, this.f23387c);
        } else {
            vkVar = uk.a(this.f23385a, jA, this.f23387c);
        }
        return vkVar == null ? new bf(new bf.b[0]) : new bf(vkVar);
    }
}
