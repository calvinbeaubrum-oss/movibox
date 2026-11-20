package p4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import u4.l0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements androidx.media3.exoplayer.source.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.y f73525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public u4.s f73526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public u4.t f73527c;

    public a(u4.y yVar) {
        this.f73525a = yVar;
    }

    @Override // androidx.media3.exoplayer.source.o
    public void a() {
        u4.s sVar = this.f73526b;
        if (sVar == null) {
            return;
        }
        u4.s sVarC = sVar.c();
        if (sVarC instanceof k5.f) {
            ((k5.f) sVarC).j();
        }
    }

    @Override // androidx.media3.exoplayer.source.o
    public long b() {
        u4.t tVar = this.f73527c;
        if (tVar != null) {
            return tVar.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    @Override // androidx.media3.exoplayer.source.o
    public void c(androidx.media3.common.l lVar, Uri uri, Map<String, List<String>> map, long j11, long j12, u4.u uVar) throws IOException {
        u4.j jVar = new u4.j(lVar, j11, j12);
        this.f73527c = jVar;
        if (this.f73526b != null) {
            return;
        }
        u4.s[] sVarArrB = this.f73525a.b(uri, map);
        if (sVarArrB.length == 1) {
            this.f73526b = sVarArrB[0];
        } else {
            for (u4.s sVar : sVarArrB) {
                try {
                    if (sVar.b(jVar)) {
                        this.f73526b = sVar;
                        z3.a.g(true);
                        jVar.resetPeekPosition();
                        break;
                    } else {
                        boolean z11 = this.f73526b != null || jVar.getPosition() == j11;
                        z3.a.g(z11);
                        jVar.resetPeekPosition();
                    }
                } catch (EOFException unused) {
                    if (this.f73526b != null || jVar.getPosition() == j11) {
                    }
                } catch (Throwable th2) {
                    z3.a.g(this.f73526b != null || jVar.getPosition() == j11);
                    jVar.resetPeekPosition();
                    throw th2;
                }
                z3.a.g(z11);
                jVar.resetPeekPosition();
            }
            if (this.f73526b == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + u0.R(sVarArrB) + ") could read the stream.", (Uri) z3.a.e(uri));
            }
        }
        this.f73526b.f(uVar);
    }

    @Override // androidx.media3.exoplayer.source.o
    public int d(l0 l0Var) throws IOException {
        return ((u4.s) z3.a.e(this.f73526b)).d((u4.t) z3.a.e(this.f73527c), l0Var);
    }

    @Override // androidx.media3.exoplayer.source.o
    public void release() {
        u4.s sVar = this.f73526b;
        if (sVar != null) {
            sVar.release();
            this.f73526b = null;
        }
        this.f73527c = null;
    }

    @Override // androidx.media3.exoplayer.source.o
    public void seek(long j11, long j12) {
        ((u4.s) z3.a.e(this.f73526b)).seek(j11, j12);
    }
}
