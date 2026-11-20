package qm;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f74849c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f74850a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f74851b = new v();

    public com.google.zxing.j a(int i11, hm.a aVar, int i12) throws NotFoundException {
        int[] iArrN = x.n(aVar, i12, false, f74849c);
        try {
            return this.f74851b.b(i11, aVar, iArrN);
        } catch (ReaderException unused) {
            return this.f74850a.b(i11, aVar, iArrN);
        }
    }
}
