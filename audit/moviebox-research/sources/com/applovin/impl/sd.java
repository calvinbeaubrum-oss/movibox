package com.applovin.impl;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sd {
    public static void a(MediaFormat mediaFormat, r3 r3Var) {
        if (r3Var != null) {
            a(mediaFormat, "color-transfer", r3Var.f22033c);
            a(mediaFormat, "color-standard", r3Var.f22031a);
            a(mediaFormat, "color-range", r3Var.f22032b);
            a(mediaFormat, "hdr-static-info", r3Var.f22034d);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, float f11) {
        if (f11 != -1.0f) {
            mediaFormat.setFloat(str, f11);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i11) {
        if (i11 != -1) {
            mediaFormat.setInteger(str, i11);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void a(MediaFormat mediaFormat, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            mediaFormat.setByteBuffer("csd-" + i11, ByteBuffer.wrap((byte[]) list.get(i11)));
        }
    }
}
