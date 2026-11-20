package tg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f77098a = new com.google.android.exoplayer2.util.c0(10);

    @Nullable
    public Metadata a(m mVar, @Nullable kh.b.a aVar) throws IOException {
        Metadata metadataE = null;
        int i11 = 0;
        while (true) {
            try {
                mVar.peekFully(this.f77098a.d(), 0, 10);
                this.f77098a.P(0);
                if (this.f77098a.G() != 4801587) {
                    break;
                }
                this.f77098a.Q(3);
                int iC = this.f77098a.C();
                int i12 = iC + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.f77098a.d(), 0, bArr, 0, 10);
                    mVar.peekFully(bArr, 10, iC);
                    metadataE = new kh.b(aVar).e(bArr, i12);
                } else {
                    mVar.advancePeekPosition(iC);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        return metadataE;
    }
}
