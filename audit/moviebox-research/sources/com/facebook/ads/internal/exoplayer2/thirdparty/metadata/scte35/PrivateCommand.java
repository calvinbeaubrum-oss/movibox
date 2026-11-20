package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.uinode.C1269Do;
import com.facebook.ads.redexgen.uinode.C1376Hz;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new C1269Do();
    public final long A00;
    public final long A01;
    public final byte[] A02;

    public PrivateCommand(long j11, byte[] bArr, long j12) {
        this.A01 = j12;
        this.A00 = j11;
        this.A02 = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.A01 = parcel.readLong();
        this.A00 = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.A02 = bArr;
        parcel.readByteArray(bArr);
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, C1269Do c1269Do) {
        this(parcel);
    }

    public static PrivateCommand A00(C1376Hz c1376Hz, int i11, long j11) {
        long jA0M = c1376Hz.A0M();
        byte[] bArr = new byte[i11 - 4];
        c1376Hz.A0c(bArr, 0, bArr.length);
        return new PrivateCommand(jA0M, bArr, j11);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
        parcel.writeInt(this.A02.length);
        parcel.writeByteArray(this.A02);
    }
}
