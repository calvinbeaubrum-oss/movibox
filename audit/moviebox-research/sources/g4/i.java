package g4;

import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.t1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import p4.e0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f65396a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f65398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f65399d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h4.f f65400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f65401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f65402h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e5.b f65397b = new e5.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f65403i = C.TIME_UNSET;

    public i(h4.f fVar, y yVar, boolean z11) {
        this.f65396a = yVar;
        this.f65400f = fVar;
        this.f65398c = fVar.f66283b;
        d(fVar, z11);
    }

    public String a() {
        return this.f65400f.a();
    }

    public void b(long j11) {
        int iD = u0.d(this.f65398c, j11, true, false);
        this.f65402h = iD;
        if (!this.f65399d || iD != this.f65398c.length) {
            j11 = C.TIME_UNSET;
        }
        this.f65403i = j11;
    }

    @Override // p4.e0
    public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int i12 = this.f65402h;
        boolean z11 = i12 == this.f65398c.length;
        if (z11 && !this.f65399d) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i11 & 2) != 0 || !this.f65401g) {
            t1Var.f11382b = this.f65396a;
            this.f65401g = true;
            return -5;
        }
        if (z11) {
            return -3;
        }
        if ((i11 & 1) == 0) {
            this.f65402h = i12 + 1;
        }
        if ((i11 & 4) == 0) {
            byte[] bArrA = this.f65397b.a(this.f65400f.f66282a[i12]);
            decoderInputBuffer.b(bArrA.length);
            decoderInputBuffer.f9780c.put(bArrA);
        }
        decoderInputBuffer.f9782f = this.f65398c[i12];
        decoderInputBuffer.setFlags(1);
        return -4;
    }

    public void d(h4.f fVar, boolean z11) {
        int i11 = this.f65402h;
        long j11 = i11 == 0 ? -9223372036854775807L : this.f65398c[i11 - 1];
        this.f65399d = z11;
        this.f65400f = fVar;
        long[] jArr = fVar.f66283b;
        this.f65398c = jArr;
        long j12 = this.f65403i;
        if (j12 != C.TIME_UNSET) {
            b(j12);
        } else if (j11 != C.TIME_UNSET) {
            this.f65402h = u0.d(jArr, j11, false, false);
        }
    }

    @Override // p4.e0
    public boolean isReady() {
        return true;
    }

    @Override // p4.e0
    public void maybeThrowError() throws IOException {
    }

    @Override // p4.e0
    public int skipData(long j11) {
        int iMax = Math.max(this.f65402h, u0.d(this.f65398c, j11, true, false));
        int i11 = iMax - this.f65402h;
        this.f65402h = iMax;
        return i11;
    }
}
