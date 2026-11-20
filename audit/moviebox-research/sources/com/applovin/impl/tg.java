package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class tg extends gl {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f23377o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23378n;

    private long a(byte[] bArr) {
        int i11;
        int i12;
        byte b11 = bArr[0];
        int i13 = b11 & 255;
        int i14 = b11 & 3;
        if (i14 != 0) {
            i11 = 2;
            if (i14 != 1 && i14 != 2) {
                i11 = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i11 = 1;
        }
        int i15 = i13 >> 3;
        int i16 = i15 & 3;
        if (i15 >= 16) {
            i12 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i16;
        } else if (i15 >= 12) {
            i12 = 10000 << (i15 & 1);
        } else {
            i12 = i16 == 3 ? 60000 : 10000 << i16;
        }
        return ((long) i11) * ((long) i12);
    }

    public static boolean b(bh bhVar) {
        int iA = bhVar.a();
        byte[] bArr = f23377o;
        if (iA < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        bhVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.applovin.impl.gl
    public long a(bh bhVar) {
        return b(a(bhVar.c()));
    }

    @Override // com.applovin.impl.gl
    public void a(boolean z11) {
        super.a(z11);
        if (z11) {
            this.f23378n = false;
        }
    }

    @Override // com.applovin.impl.gl
    public boolean a(bh bhVar, long j11, gl.b bVar) {
        if (this.f23378n) {
            b1.a(bVar.f19260a);
            boolean z11 = bhVar.j() == 1332770163;
            bhVar.f(0);
            return z11;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bhVar.c(), bhVar.e());
        bVar.f19260a = new f9.b().f(MimeTypes.AUDIO_OPUS).c(ug.b(bArrCopyOf)).n(48000).a(ug.a(bArrCopyOf)).a();
        this.f23378n = true;
        return true;
    }
}
