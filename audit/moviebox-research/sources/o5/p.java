package o5;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends androidx.media3.decoder.h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public k f72349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f72350b;

    public void a(long j11, k kVar, long j12) {
        this.timeUs = j11;
        this.f72349a = kVar;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.f72350b = j11;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        this.f72349a = null;
    }

    @Override // o5.k
    public List<y3.a> getCues(long j11) {
        return ((k) z3.a.e(this.f72349a)).getCues(j11 - this.f72350b);
    }

    @Override // o5.k
    public long getEventTime(int i11) {
        return ((k) z3.a.e(this.f72349a)).getEventTime(i11) + this.f72350b;
    }

    @Override // o5.k
    public int getEventTimeCount() {
        return ((k) z3.a.e(this.f72349a)).getEventTimeCount();
    }

    @Override // o5.k
    public int getNextEventTimeIndex(long j11) {
        return ((k) z3.a.e(this.f72349a)).getNextEventTimeIndex(j11 - this.f72350b);
    }
}
