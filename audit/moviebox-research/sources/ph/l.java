package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f73851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f73852k;

    public l(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i11, m1 m1Var, int i12, @Nullable Object obj, @Nullable byte[] bArr) {
        super(kVar, nVar, i11, m1Var, i12, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f73851j = bArr == null ? o0.f35613f : bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
        this.f73852k = true;
    }

    public abstract void e(byte[] bArr, int i11) throws IOException;

    public byte[] f() {
        return this.f73851j;
    }

    public final void g(int i11) {
        byte[] bArr = this.f73851j;
        if (bArr.length < i11 + 16384) {
            this.f73851j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() throws IOException {
        try {
            this.f73814i.a(this.f73807b);
            int i11 = 0;
            int i12 = 0;
            while (i11 != -1 && !this.f73852k) {
                g(i12);
                i11 = this.f73814i.read(this.f73851j, i12, 16384);
                if (i11 != -1) {
                    i12 += i11;
                }
            }
            if (!this.f73852k) {
                e(this.f73851j, i12);
            }
        } finally {
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
        }
    }
}
