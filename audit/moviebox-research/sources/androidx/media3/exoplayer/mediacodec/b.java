package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import java.io.IOException;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f10747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10748b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10749c = true;

    public b(Context context) {
        this.f10747a = context;
    }

    @Override // androidx.media3.exoplayer.mediacodec.c.b
    public c a(c.a aVar) throws IOException {
        int i11;
        if (u0.f81838a < 23 || !((i11 = this.f10748b) == 1 || (i11 == 0 && c()))) {
            return new g.b().a(aVar);
        }
        int iK = f0.k(aVar.f10752c.f9501m);
        o.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + u0.v0(iK));
        a.b bVar = new a.b(iK);
        bVar.e(this.f10749c);
        return bVar.a(aVar);
    }

    public b b() {
        this.f10748b = 1;
        return this;
    }

    public final boolean c() {
        int i11 = u0.f81838a;
        if (i11 >= 31) {
            return true;
        }
        Context context = this.f10747a;
        return context != null && i11 >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }
}
