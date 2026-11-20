package com.facebook.ads.internal.exoplayer2.thirdparty.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.redexgen.uinode.AbstractC1351Ha;
import com.facebook.ads.redexgen.uinode.FJ;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TrackGroup implements Parcelable {
    public static String[] A03 = {"", "NMittKxTOqnCpR0XVNiGFQTgWBdVnSBQ", "6q2S2IWbxt3Au5KHDEjHre", "yesKExk412D9rxhfpJlSlvbFBwA7zIdr", "", "HTCNZO0GmLRgbnlHCzceXp", "rqCvvFRkFLctqovtMSwPdniKfX3FbXhx", "eUM"};
    public static final Parcelable.Creator<TrackGroup> CREATOR = new FJ();
    public int A00;
    public final int A01;
    public final Format[] A02;

    public TrackGroup(Parcel parcel) {
        int i11 = parcel.readInt();
        this.A01 = i11;
        this.A02 = new Format[i11];
        for (int i12 = 0; i12 < this.A01; i12++) {
            this.A02[i12] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format... formatArr) {
        AbstractC1351Ha.A04(formatArr.length > 0);
        this.A02 = formatArr;
        this.A01 = formatArr.length;
    }

    public final int A00(Format format) {
        int i11 = 0;
        while (true) {
            Format[] formatArr = this.A02;
            if (i11 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public final Format A01(int i11) {
        return this.A02[i11];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.A01 == trackGroup.A01 && Arrays.equals(this.A02, trackGroup.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            if (A03[0].length() == 29) {
                throw new RuntimeException();
            }
            A03[6] = "7PEwa6COELc4k3zf5JXJInB5hEQAk2SR";
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        return this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.A01);
        int i12 = 0;
        while (true) {
            int i13 = this.A01;
            String[] strArr = A03;
            if (strArr[2].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A03[6] = "BrTDzXvstLX2a3jCZEwFRrav1URrTsvk";
            if (i12 >= i13) {
                return;
            }
            parcel.writeParcelable(this.A02[i12], 0);
            i12++;
        }
    }
}
