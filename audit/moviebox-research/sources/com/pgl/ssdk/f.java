package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: compiled from: source.java */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static h a(o oVar, c.a aVar, int i11) throws IOException, a {
        try {
            return g.a(oVar, aVar, i11);
        } catch (i e11) {
            throw new a(e11.getMessage());
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.b(byteBuffer);
    }

    public static byte[] b(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.c(byteBuffer);
    }
}
