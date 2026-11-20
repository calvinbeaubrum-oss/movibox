package mh;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.k0;
import gh.d;
import gh.f;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f71101a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f71102b = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f71103c;

    @Override // gh.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        k0 k0Var = this.f71103c;
        if (k0Var == null || dVar.f65501j != k0Var.e()) {
            k0 k0Var2 = new k0(dVar.f33032f);
            this.f71103c = k0Var2;
            k0Var2.a(dVar.f33032f - dVar.f65501j);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f71101a.N(bArrArray, iLimit);
        this.f71102b.o(bArrArray, iLimit);
        this.f71102b.r(39);
        long jH = (((long) this.f71102b.h(1)) << 32) | ((long) this.f71102b.h(32));
        this.f71102b.r(20);
        int iH = this.f71102b.h(12);
        int iH2 = this.f71102b.h(8);
        this.f71101a.Q(14);
        if (iH2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iH2 == 255) {
            spliceNullCommand = PrivateCommand.parseFromSection(this.f71101a, iH, jH);
        } else if (iH2 == 4) {
            spliceNullCommand = SpliceScheduleCommand.parseFromSection(this.f71101a);
        } else if (iH2 != 5) {
            spliceNullCommand = iH2 != 6 ? null : TimeSignalCommand.parseFromSection(this.f71101a, jH, this.f71103c);
        } else {
            spliceNullCommand = SpliceInsertCommand.parseFromSection(this.f71101a, jH, this.f71103c);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
