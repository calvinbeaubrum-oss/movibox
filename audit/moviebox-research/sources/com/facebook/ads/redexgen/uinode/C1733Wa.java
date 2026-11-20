package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.PrivateCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceInsertCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceNullCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.SpliceScheduleCommand;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1733Wa implements DW {
    public IB A00;
    public final C1376Hz A02 = new C1376Hz();
    public final C1375Hy A01 = new C1375Hy();

    @Override // com.facebook.ads.redexgen.uinode.DW
    public final Metadata A51(E3 e11) throws DX {
        if (this.A00 == null || e11.A00 != this.A00.A05()) {
            IB ib2 = new IB(((C1773Xr) e11).A00);
            this.A00 = ib2;
            ib2.A06(((C1773Xr) e11).A00 - e11.A00);
        }
        ByteBuffer byteBuffer = e11.A01;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.A02.A0b(bArrArray, iLimit);
        this.A01.A0C(bArrArray, iLimit);
        this.A01.A08(39);
        long jA04 = (((long) this.A01.A04(1)) << 32) | ((long) this.A01.A04(32));
        this.A01.A08(20);
        int iA04 = this.A01.A04(12);
        int iA05 = this.A01.A04(8);
        Metadata.Entry spliceNullCommand = null;
        this.A02.A0Z(14);
        switch (iA05) {
            case 0:
                spliceNullCommand = new SpliceNullCommand();
                break;
            case 4:
                spliceNullCommand = SpliceScheduleCommand.A00(this.A02);
                break;
            case 5:
                spliceNullCommand = SpliceInsertCommand.A00(this.A02, jA04, this.A00);
                break;
            case 6:
                spliceNullCommand = TimeSignalCommand.A01(this.A02, jA04, this.A00);
                break;
            case 255:
                spliceNullCommand = PrivateCommand.A00(this.A02, iA04, jA04);
                break;
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
