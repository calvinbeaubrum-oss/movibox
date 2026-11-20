package i5;

import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.scte35.PrivateCommand;
import androidx.media3.extractor.metadata.scte35.SpliceInsertCommand;
import androidx.media3.extractor.metadata.scte35.SpliceNullCommand;
import androidx.media3.extractor.metadata.scte35.SpliceScheduleCommand;
import androidx.media3.extractor.metadata.scte35.TimeSignalCommand;
import c5.b;
import c5.c;
import java.nio.ByteBuffer;
import z3.b0;
import z3.c0;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f67145a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f67146b = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f67147c;

    @Override // c5.c
    public Metadata b(b bVar, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        i0 i0Var = this.f67147c;
        if (i0Var == null || bVar.f14632j != i0Var.f()) {
            i0 i0Var2 = new i0(bVar.f9782f);
            this.f67147c = i0Var2;
            i0Var2.a(bVar.f9782f - bVar.f14632j);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f67145a.S(bArrArray, iLimit);
        this.f67146b.o(bArrArray, iLimit);
        this.f67146b.r(39);
        long jH = (((long) this.f67146b.h(1)) << 32) | ((long) this.f67146b.h(32));
        this.f67146b.r(20);
        int iH = this.f67146b.h(12);
        int iH2 = this.f67146b.h(8);
        this.f67145a.V(14);
        if (iH2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iH2 == 255) {
            spliceNullCommand = PrivateCommand.parseFromSection(this.f67145a, iH, jH);
        } else if (iH2 == 4) {
            spliceNullCommand = SpliceScheduleCommand.parseFromSection(this.f67145a);
        } else if (iH2 != 5) {
            spliceNullCommand = iH2 != 6 ? null : TimeSignalCommand.parseFromSection(this.f67145a, jH, this.f67147c);
        } else {
            spliceNullCommand = SpliceInsertCommand.parseFromSection(this.f67145a, jH, this.f67147c);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
