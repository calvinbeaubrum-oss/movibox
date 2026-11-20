package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.c0 f78289a = new z3.c0(10);

    @Nullable
    public Metadata a(t tVar, @Nullable g5.b.a aVar) throws IOException {
        Metadata metadataE = null;
        int i11 = 0;
        while (true) {
            try {
                tVar.peekFully(this.f78289a.e(), 0, 10);
                this.f78289a.U(0);
                if (this.f78289a.K() != 4801587) {
                    break;
                }
                this.f78289a.V(3);
                int iG = this.f78289a.G();
                int i12 = iG + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.f78289a.e(), 0, bArr, 0, 10);
                    tVar.peekFully(bArr, 10, iG);
                    metadataE = new g5.b(aVar).e(bArr, i12);
                } else {
                    tVar.advancePeekPosition(iG);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        tVar.resetPeekPosition();
        tVar.advancePeekPosition(i11);
        return metadataE;
    }
}
