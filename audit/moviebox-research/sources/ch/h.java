package ch;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.c0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;
import tg.h0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f14826o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f14827p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14828n;

    public static boolean o(c0 c0Var, byte[] bArr) {
        if (c0Var.a() < bArr.length) {
            return false;
        }
        int iE = c0Var.e();
        byte[] bArr2 = new byte[bArr.length];
        c0Var.j(bArr2, 0, bArr.length);
        c0Var.P(iE);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean p(c0 c0Var) {
        return o(c0Var, f14826o);
    }

    @Override // ch.i
    public long f(c0 c0Var) {
        return c(n(c0Var.d()));
    }

    @Override // ch.i
    public boolean h(c0 c0Var, long j11, i.b bVar) throws ParserException {
        if (o(c0Var, f14826o)) {
            byte[] bArrCopyOf = Arrays.copyOf(c0Var.d(), c0Var.f());
            int iC = com.google.android.exoplayer2.audio.c0.c(bArrCopyOf);
            List<byte[]> listA = com.google.android.exoplayer2.audio.c0.a(bArrCopyOf);
            if (bVar.f14842a != null) {
                return true;
            }
            bVar.f14842a = new m1.b().e0(MimeTypes.AUDIO_OPUS).H(iC).f0(48000).T(listA).E();
            return true;
        }
        byte[] bArr = f14827p;
        if (!o(c0Var, bArr)) {
            com.google.android.exoplayer2.util.a.i(bVar.f14842a);
            return false;
        }
        com.google.android.exoplayer2.util.a.i(bVar.f14842a);
        if (this.f14828n) {
            return true;
        }
        this.f14828n = true;
        c0Var.Q(bArr.length);
        Metadata metadataC = h0.c(ImmutableList.copyOf(h0.j(c0Var, false, false).f77039b));
        if (metadataC == null) {
            return true;
        }
        bVar.f14842a = bVar.f14842a.b().X(metadataC.copyWithAppendedEntriesFrom(bVar.f14842a.f33443k)).E();
        return true;
    }

    @Override // ch.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f14828n = false;
        }
    }

    public final long n(byte[] bArr) {
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
}
