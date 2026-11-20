package p007do;

import com.google.common.util.concurrent.b0;
import io.f;
import io.l;
import io.o;
import io.r;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f63451a = b0.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f63452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f63453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f63454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f63455e;

    public f0(boolean z11, long j11, Object obj, l lVar) {
        this.f63452b = z11;
        this.f63453c = j11;
        this.f63454d = obj;
        this.f63455e = lVar;
    }

    public final void a(o oVar) {
        ByteBuffer byteBufferAllocate = null;
        int iO = -1;
        while (oVar.b()) {
            try {
                int iN = oVar.n();
                if (iN == 1) {
                    iO = oVar.o();
                } else if (iN != 2) {
                    oVar.c();
                } else {
                    byteBufferAllocate = oVar.f();
                }
            } catch (Throwable th2) {
                this.f63451a.setException(th2);
                return;
            }
        }
        if (iO == -1) {
            this.f63451a.setException(new IllegalStateException("expected status"));
            return;
        }
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(0);
        }
        if (iO != 0) {
            this.f63451a.setException(new IllegalStateException("request failed: " + StandardCharsets.UTF_8.decode(byteBufferAllocate).toString()));
            return;
        }
        try {
            b0 b0Var = this.f63451a;
            l lVar = this.f63455e;
            b0Var.set(lVar == null ? byteBufferAllocate : lVar.b(new o(byteBufferAllocate)));
        } catch (Throwable th3) {
            this.f63451a.setException(th3);
        }
    }

    public final void b(r rVar) {
        ByteBuffer byteBufferF;
        rVar.n(1, this.f63453c);
        Object obj = this.f63454d;
        if (obj instanceof ByteBuffer) {
            byteBufferF = ((ByteBuffer) obj).duplicate();
        } else {
            if (!(obj instanceof l)) {
                return;
            }
            r rVar2 = new r();
            ((l) this.f63454d).a(rVar2);
            byteBufferF = rVar2.f();
        }
        if (this.f63452b) {
            try {
                byteBufferF = f.a(byteBufferF.duplicate());
                rVar.g(3, true);
            } catch (IOException unused) {
            }
        }
        rVar.j(2, byteBufferF);
    }
}
