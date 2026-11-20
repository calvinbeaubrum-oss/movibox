package m5;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;
import u4.k0;
import u4.u0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f70830o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f70831p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f70832n;

    public static boolean n(c0 c0Var, byte[] bArr) {
        if (c0Var.a() < bArr.length) {
            return false;
        }
        int iF = c0Var.f();
        byte[] bArr2 = new byte[bArr.length];
        c0Var.l(bArr2, 0, bArr.length);
        c0Var.U(iF);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(c0 c0Var) {
        return n(c0Var, f70830o);
    }

    @Override // m5.i
    public long f(c0 c0Var) {
        return c(k0.e(c0Var.e()));
    }

    @Override // m5.i
    public boolean i(c0 c0Var, long j11, i.b bVar) throws ParserException {
        if (n(c0Var, f70830o)) {
            byte[] bArrCopyOf = Arrays.copyOf(c0Var.e(), c0Var.g());
            int iC = k0.c(bArrCopyOf);
            List<byte[]> listA = k0.a(bArrCopyOf);
            if (bVar.f70846a != null) {
                return true;
            }
            bVar.f70846a = new y.b().k0(MimeTypes.AUDIO_OPUS).L(iC).l0(48000).Y(listA).I();
            return true;
        }
        byte[] bArr = f70831p;
        if (!n(c0Var, bArr)) {
            z3.a.i(bVar.f70846a);
            return false;
        }
        z3.a.i(bVar.f70846a);
        if (this.f70832n) {
            return true;
        }
        this.f70832n = true;
        c0Var.V(bArr.length);
        Metadata metadataD = u0.d(ImmutableList.copyOf(u0.k(c0Var, false, false).f78397b));
        if (metadataD == null) {
            return true;
        }
        bVar.f70846a = bVar.f70846a.b().d0(metadataD.copyWithAppendedEntriesFrom(bVar.f70846a.f9499k)).I();
        return true;
    }

    @Override // m5.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f70832n = false;
        }
    }
}
