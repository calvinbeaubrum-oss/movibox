package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.w1;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p4.e0;
import p4.k0;
import s4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f11168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f11170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f11171d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f11172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Throwable> f11173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.google.common.util.concurrent.s<?> f11174h;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.google.common.util.concurrent.o<Object> {
        public a() {
        }

        @Override // com.google.common.util.concurrent.o
        public void a(Throwable th2) {
            f.this.f11173g.set(th2);
        }

        @Override // com.google.common.util.concurrent.o
        public void onSuccess(@Nullable Object obj) {
            f.this.f11172f.set(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11176a = 0;

        public b() {
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            int i12 = this.f11176a;
            if (i12 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i11 & 2) != 0 || i12 == 0) {
                t1Var.f11382b = f.this.f11170c.b(0).a(0);
                this.f11176a = 1;
                return -5;
            }
            if (!f.this.f11172f.get()) {
                return -3;
            }
            int length = f.this.f11171d.length;
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.f9782f = 0L;
            if ((i11 & 4) == 0) {
                decoderInputBuffer.b(length);
                decoderInputBuffer.f9780c.put(f.this.f11171d, 0, length);
            }
            if ((i11 & 1) == 0) {
                this.f11176a = 2;
            }
            return -4;
        }

        @Override // p4.e0
        public boolean isReady() {
            return f.this.f11172f.get();
        }

        @Override // p4.e0
        public void maybeThrowError() throws IOException {
            Throwable th2 = (Throwable) f.this.f11173g.get();
            if (th2 != null) {
                throw new IOException(th2);
            }
        }

        @Override // p4.e0
        public int skipData(long j11) {
            return 0;
        }
    }

    public f(Uri uri, String str, e eVar) {
        this.f11168a = uri;
        y yVarI = new y.b().k0(str).I();
        this.f11169b = eVar;
        this.f11170c = new k0(new n0(yVarI));
        this.f11171d = uri.toString().getBytes(com.google.common.base.c.f38165c);
        this.f11172f = new AtomicBoolean();
        this.f11173g = new AtomicReference<>();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        return !this.f11172f.get();
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            if (e0VarArr[i11] != null && (zVarArr[i11] == null || !zArr[i11])) {
                e0VarArr[i11] = null;
            }
            if (e0VarArr[i11] == null && zVarArr[i11] != null) {
                e0VarArr[i11] = new b();
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        aVar.f(this);
        com.google.common.util.concurrent.s<?> sVarA = this.f11169b.a(new e.a(this.f11168a));
        this.f11174h = sVarA;
        Futures.a(sVarA, new a(), MoreExecutors.a());
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return this.f11172f.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return this.f11172f.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return this.f11170c;
    }

    public void i() {
        com.google.common.util.concurrent.s<?> sVar = this.f11174h;
        if (sVar != null) {
            sVar.cancel(false);
        }
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return !this.f11172f.get();
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        return j11;
    }
}
