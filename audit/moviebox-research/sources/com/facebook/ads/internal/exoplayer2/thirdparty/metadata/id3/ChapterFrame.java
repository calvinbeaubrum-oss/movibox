package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.redexgen.uinode.C1263De;
import com.facebook.ads.redexgen.uinode.IF;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ChapterFrame extends Id3Frame {
    public static byte[] A06;
    public static String[] A07 = {"QpJSSLL1pAOhHOIuNBRkrzmXt1j3kGrp", "YDXCC3i5xiwq8rKE5Vv8RtOzkk3qmOGu", "a9Dyegh0cUh2NB45defTztP9U1vgFmVz", "Fo5phTLuHzrdJakbpxdIKAmZ2lieOpY4", "dsZIUxvA4XNulUgaba6Xxwm2YLZaneQj", "tf5IGK9pdoxQzr6GjeVrhLEpaxS6glNY", "h51Nv655qNU0F3QlRFxqTHMWff2CX7Q9", "n0uNxI60"};
    public static final Parcelable.Creator<ChapterFrame> CREATOR;
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final String A04;
    public final Id3Frame[] A05;

    static {
        A01();
        CREATOR = new C1263De();
    }

    public ChapterFrame(Parcel parcel) {
        super(A00(0, 4, 102));
        this.A04 = parcel.readString();
        this.A01 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A03 = parcel.readLong();
        this.A02 = parcel.readLong();
        int i11 = parcel.readInt();
        this.A05 = new Id3Frame[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.A05[i12] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i11, int i12, long j11, long j12, Id3Frame[] id3FrameArr) {
        super(A00(0, 4, 102));
        this.A04 = str;
        this.A01 = i11;
        this.A00 = i12;
        this.A03 = j11;
        this.A02 = j12;
        this.A05 = id3FrameArr;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{Ascii.DLE, Ascii.NAK, Ascii.SO, Ascii.GS};
    }

    @Override // com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            String[] strArr = A07;
            if (strArr[4].charAt(30) != strArr[6].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[3] = "XcR91xLCiqA5sQGMKj3Ma8f7fza10VW6";
            strArr2[0] = "VJeBRgLHewbbeoWUsBxJyvYKkza9BVMl";
            if (cls == cls2) {
                ChapterFrame chapterFrame = (ChapterFrame) obj;
                return this.A01 == chapterFrame.A01 && this.A00 == chapterFrame.A00 && this.A03 == chapterFrame.A03 && this.A02 == chapterFrame.A02 && IF.A0g(this.A04, chapterFrame.A04) && Arrays.equals(this.A05, chapterFrame.A05);
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = ((((((((17 * 31) + this.A01) * 31) + this.A00) * 31) + ((int) this.A03)) * 31) + ((int) this.A02)) * 31;
        String str = this.A04;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.A04);
        parcel.writeInt(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A03);
        parcel.writeLong(this.A02);
        parcel.writeInt(this.A05.length);
        for (Id3Frame id3Frame : this.A05) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
