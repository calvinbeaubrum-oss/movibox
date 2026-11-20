package nh;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.source.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tg.r f71893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public tg.l f71894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public tg.m f71895c;

    public a(tg.r rVar) {
        this.f71893a = rVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a() {
        tg.l lVar = this.f71894b;
        if (lVar instanceof ah.f) {
            ((ah.f) lVar).i();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public long b() {
        tg.m mVar = this.f71895c;
        if (mVar != null) {
            return mVar.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    @Override // com.google.android.exoplayer2.source.l
    public void c(com.google.android.exoplayer2.upstream.g gVar, Uri uri, Map<String, List<String>> map, long j11, long j12, tg.n nVar) throws IOException {
        tg.f fVar = new tg.f(gVar, j11, j12);
        this.f71895c = fVar;
        if (this.f71894b != null) {
            return;
        }
        tg.l[] lVarArrB = this.f71893a.b(uri, map);
        if (lVarArrB.length == 1) {
            this.f71894b = lVarArrB[0];
        } else {
            for (tg.l lVar : lVarArrB) {
                try {
                    if (lVar.b(fVar)) {
                        this.f71894b = lVar;
                        com.google.android.exoplayer2.util.a.g(true);
                        fVar.resetPeekPosition();
                        break;
                    } else {
                        boolean z11 = this.f71894b != null || fVar.getPosition() == j11;
                        com.google.android.exoplayer2.util.a.g(z11);
                        fVar.resetPeekPosition();
                    }
                } catch (EOFException unused) {
                    if (this.f71894b != null || fVar.getPosition() == j11) {
                    }
                } catch (Throwable th2) {
                    com.google.android.exoplayer2.util.a.g(this.f71894b != null || fVar.getPosition() == j11);
                    fVar.resetPeekPosition();
                    throw th2;
                }
                com.google.android.exoplayer2.util.a.g(z11);
                fVar.resetPeekPosition();
            }
            if (this.f71894b == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + o0.M(lVarArrB) + ") could read the stream.", (Uri) com.google.android.exoplayer2.util.a.e(uri));
            }
        }
        this.f71894b.d(nVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public int d(tg.a0 a0Var) throws IOException {
        return ((tg.l) com.google.android.exoplayer2.util.a.e(this.f71894b)).c((tg.m) com.google.android.exoplayer2.util.a.e(this.f71895c), a0Var);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void release() {
        tg.l lVar = this.f71894b;
        if (lVar != null) {
            lVar.release();
            this.f71894b = null;
        }
        this.f71895c = null;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void seek(long j11, long j12) {
        ((tg.l) com.google.android.exoplayer2.util.a.e(this.f71894b)).seek(j11, j12);
    }
}
