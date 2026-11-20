package tg;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class w implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f77094a;

    public w(m mVar) {
        this.f77094a = mVar;
    }

    @Override // tg.m
    public void advancePeekPosition(int i11) throws IOException {
        this.f77094a.advancePeekPosition(i11);
    }

    @Override // tg.m
    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        return this.f77094a.advancePeekPosition(i11, z11);
    }

    @Override // tg.m
    public int b(byte[] bArr, int i11, int i12) throws IOException {
        return this.f77094a.b(bArr, i11, i12);
    }

    @Override // tg.m
    public long getLength() {
        return this.f77094a.getLength();
    }

    @Override // tg.m
    public long getPeekPosition() {
        return this.f77094a.getPeekPosition();
    }

    @Override // tg.m
    public long getPosition() {
        return this.f77094a.getPosition();
    }

    @Override // tg.m
    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        this.f77094a.peekFully(bArr, i11, i12);
    }

    @Override // tg.m
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.f77094a.peekFully(bArr, i11, i12, z11);
    }

    @Override // tg.m, com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f77094a.read(bArr, i11, i12);
    }

    @Override // tg.m
    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        this.f77094a.readFully(bArr, i11, i12);
    }

    @Override // tg.m
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.f77094a.readFully(bArr, i11, i12, z11);
    }

    @Override // tg.m
    public void resetPeekPosition() {
        this.f77094a.resetPeekPosition();
    }

    @Override // tg.m
    public int skip(int i11) throws IOException {
        return this.f77094a.skip(i11);
    }

    @Override // tg.m
    public void skipFully(int i11) throws IOException {
        this.f77094a.skipFully(i11);
    }
}
