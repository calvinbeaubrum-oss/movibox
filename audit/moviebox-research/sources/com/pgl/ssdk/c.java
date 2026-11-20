package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    /* JADX INFO: compiled from: source.java */
    public static class a extends r {
        public a(long j11, long j12, int i11, long j13, ByteBuffer byteBuffer) {
            super(j11, j12, i11, j13, byteBuffer);
        }
    }

    public static a a(o oVar) throws q, IOException {
        r rVarA = d.a(oVar);
        return new a(rVarA.a(), rVarA.c(), rVarA.b(), rVarA.e(), rVarA.d());
    }
}
