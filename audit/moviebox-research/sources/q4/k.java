package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f74367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f74368k;

    public k(androidx.media3.datasource.a aVar, c4.g gVar, int i11, y yVar, int i12, @Nullable Object obj, @Nullable byte[] bArr) {
        super(aVar, gVar, i11, yVar, i12, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f74367j = bArr == null ? u0.f81843f : bArr;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
        this.f74368k = true;
    }

    public abstract void e(byte[] bArr, int i11) throws IOException;

    public byte[] f() {
        return this.f74367j;
    }

    public final void g(int i11) {
        byte[] bArr = this.f74367j;
        if (bArr.length < i11 + 16384) {
            this.f74367j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() throws IOException {
        try {
            this.f74330i.a(this.f74323b);
            int i11 = 0;
            int i12 = 0;
            while (i11 != -1 && !this.f74368k) {
                g(i12);
                i11 = this.f74330i.read(this.f74367j, i12, 16384);
                if (i11 != -1) {
                    i12 += i11;
                }
            }
            if (!this.f74368k) {
                e(this.f74367j, i12);
            }
        } finally {
            c4.f.a(this.f74330i);
        }
    }
}
