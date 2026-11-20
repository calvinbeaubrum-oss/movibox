package vh;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n extends com.google.android.exoplayer2.decoder.f implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public i f78878d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f78879f;

    @Override // com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        this.f78878d = null;
    }

    @Override // vh.i
    public List<b> getCues(long j11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f78878d)).getCues(j11 - this.f78879f);
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f78878d)).getEventTime(i11) + this.f78879f;
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f78878d)).getEventTimeCount();
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        return ((i) com.google.android.exoplayer2.util.a.e(this.f78878d)).getNextEventTimeIndex(j11 - this.f78879f);
    }

    public void n(long j11, i iVar, long j12) {
        this.f33074b = j11;
        this.f78878d = iVar;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.f78879f = j11;
    }
}
