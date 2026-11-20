package androidx.media3.exoplayer.hls;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.t1;
import java.io.IOException;
import p4.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f10460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10461c = -1;

    public m(q qVar, int i11) {
        this.f10460b = qVar;
        this.f10459a = i11;
    }

    public void a() {
        z3.a.a(this.f10461c == -1);
        this.f10461c = this.f10460b.j(this.f10459a);
    }

    public final boolean b() {
        int i11 = this.f10461c;
        return (i11 == -1 || i11 == -3 || i11 == -2) ? false : true;
    }

    @Override // p4.e0
    public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (this.f10461c == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (b()) {
            return this.f10460b.S(this.f10461c, t1Var, decoderInputBuffer, i11);
        }
        return -3;
    }

    public void d() {
        if (this.f10461c != -1) {
            this.f10460b.d0(this.f10459a);
            this.f10461c = -1;
        }
    }

    @Override // p4.e0
    public boolean isReady() {
        return this.f10461c == -3 || (b() && this.f10460b.E(this.f10461c));
    }

    @Override // p4.e0
    public void maybeThrowError() throws IOException {
        int i11 = this.f10461c;
        if (i11 == -2) {
            throw new SampleQueueMappingException(this.f10460b.getTrackGroups().b(this.f10459a).a(0).f9501m);
        }
        if (i11 == -1) {
            this.f10460b.I();
        } else if (i11 != -3) {
            this.f10460b.J(i11);
        }
    }

    @Override // p4.e0
    public int skipData(long j11) {
        if (b()) {
            return this.f10460b.c0(this.f10461c, j11);
        }
        return 0;
    }
}
