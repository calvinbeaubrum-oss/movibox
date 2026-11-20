package an;

import com.google.zxing.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f584a;

    public e(boolean z11) {
        this.f584a = z11;
    }

    public void a(k[] kVarArr) {
        if (!this.f584a || kVarArr == null || kVarArr.length < 3) {
            return;
        }
        k kVar = kVarArr[0];
        kVarArr[0] = kVarArr[2];
        kVarArr[2] = kVar;
    }
}
