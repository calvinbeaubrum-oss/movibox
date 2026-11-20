package p007do;

import android.os.Handler;
import android.os.Looper;
import com.polygamma.ogm.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e0 extends x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f63449g;

    public e0(Looper looper) {
        this.f63449g = new Handler(looper);
    }

    @Override // p007do.x
    public final boolean d(m mVar, long j11) {
        return j11 == 0 ? this.f63449g.post(mVar) : this.f63449g.postAtTime(mVar, j11);
    }
}
