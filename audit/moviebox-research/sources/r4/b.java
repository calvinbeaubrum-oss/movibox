package r4;

import o5.j;
import o5.k;
import o5.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends j {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s f75116p;

    public b(String str, s sVar) {
        super(str);
        this.f75116p = sVar;
    }

    @Override // o5.j
    public k y(byte[] bArr, int i11, boolean z11) {
        if (z11) {
            this.f75116p.reset();
        }
        return this.f75116p.b(bArr, 0, i11);
    }
}
