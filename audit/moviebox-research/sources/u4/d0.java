package u4;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f78244a;

    public d0(t tVar) {
        this.f78244a = tVar;
    }

    @Override // u4.t
    public void advancePeekPosition(int i11) throws IOException {
        this.f78244a.advancePeekPosition(i11);
    }

    @Override // u4.t
    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        return this.f78244a.advancePeekPosition(i11, z11);
    }

    @Override // u4.t
    public int b(byte[] bArr, int i11, int i12) throws IOException {
        return this.f78244a.b(bArr, i11, i12);
    }

    @Override // u4.t
    public long getLength() {
        return this.f78244a.getLength();
    }

    @Override // u4.t
    public long getPeekPosition() {
        return this.f78244a.getPeekPosition();
    }

    @Override // u4.t
    public long getPosition() {
        return this.f78244a.getPosition();
    }

    @Override // u4.t
    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        this.f78244a.peekFully(bArr, i11, i12);
    }

    @Override // u4.t
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.f78244a.peekFully(bArr, i11, i12, z11);
    }

    @Override // u4.t, androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f78244a.read(bArr, i11, i12);
    }

    @Override // u4.t
    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        this.f78244a.readFully(bArr, i11, i12);
    }

    @Override // u4.t
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.f78244a.readFully(bArr, i11, i12, z11);
    }

    @Override // u4.t
    public void resetPeekPosition() {
        this.f78244a.resetPeekPosition();
    }

    @Override // u4.t
    public int skip(int i11) throws IOException {
        return this.f78244a.skip(i11);
    }

    @Override // u4.t
    public void skipFully(int i11) throws IOException {
        this.f78244a.skipFully(i11);
    }
}
