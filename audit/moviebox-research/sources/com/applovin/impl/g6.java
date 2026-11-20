package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g6 implements mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19162a;

    public g6() {
        this(-1);
    }

    public g6(int i11) {
        this.f19162a = i11;
    }

    @Override // com.applovin.impl.mc
    public int a(int i11) {
        int i12 = this.f19162a;
        if (i12 == -1) {
            return i11 == 7 ? 6 : 3;
        }
        return i12;
    }

    @Override // com.applovin.impl.mc
    public long a(mc.a aVar) {
        IOException iOException = aVar.f20654c;
        return ((iOException instanceof dh) || (iOException instanceof FileNotFoundException) || (iOException instanceof qa.a) || (iOException instanceof oc.h) || j5.a(iOException)) ? C.TIME_UNSET : Math.min((aVar.f20655d - 1) * 1000, 5000);
    }

    @Override // com.applovin.impl.mc
    public /* synthetic */ void a(long j11) {
        wz.a(this, j11);
    }
}
