package xh;

import com.google.android.exoplayer2.util.c0;
import java.util.List;
import vh.h;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f80506o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        c0 c0Var = new c0(list.get(0));
        this.f80506o = new b(c0Var.J(), c0Var.J());
    }

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) {
        if (z11) {
            this.f80506o.r();
        }
        return new c(this.f80506o.b(bArr, i11));
    }
}
