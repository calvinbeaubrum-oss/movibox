package com.facebook.ads.internal.exoplayer2.thirdparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.video.ColorInfo;
import com.facebook.ads.redexgen.uinode.IF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Format implements Parcelable {
    public static byte[] A0R;
    public static String[] A0S = {"GkCJdc4gcEDyhSrmAvmdIhMcpgWdcGAD", "P7wJti8h4DQilFv1", "JfTD4DJXTv4PkONbD5mKaVW4fPbL8TvR", "vxuFoFca8hdNpr1LxNr2zKx53RimwM0h", "bhZpzqqZQOeAHwzqKdvv0PgUhXvz16sV", "CbjUY4sgiKfKafV0T546ZMOdyjpyhZSd", "yWUjvB0PPIH7", "Rw2LdMGLtrNyL7BxoibJQnsrtGr9rdxr"};
    public static final Parcelable.Creator<Format> CREATOR;
    public int A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final int A0F;
    public final long A0G;
    public final DrmInitData A0H;
    public final Metadata A0I;
    public final ColorInfo A0J;
    public final String A0K;
    public final String A0L;
    public final String A0M;
    public final String A0N;
    public final String A0O;
    public final List<byte[]> A0P;
    public final byte[] A0Q;

    static {
        A0D();
        CREATOR = new Parcelable.Creator<Format>() { // from class: com.facebook.ads.redexgen.X.9n
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Format createFromParcel(Parcel parcel) {
                return new Format(parcel);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final Format[] newArray(int i11) {
                return new Format[i11];
            }
        };
    }

    public Format(Parcel parcel) {
        this.A0M = parcel.readString();
        this.A0L = parcel.readString();
        this.A0O = parcel.readString();
        this.A0K = parcel.readString();
        this.A04 = parcel.readInt();
        this.A09 = parcel.readInt();
        this.A0F = parcel.readInt();
        this.A08 = parcel.readInt();
        this.A01 = parcel.readFloat();
        this.A0B = parcel.readInt();
        this.A02 = parcel.readFloat();
        this.A0Q = IF.A0f(parcel) ? parcel.createByteArray() : null;
        this.A0E = parcel.readInt();
        this.A0J = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.A05 = parcel.readInt();
        this.A0C = parcel.readInt();
        this.A0A = parcel.readInt();
        this.A06 = parcel.readInt();
        this.A07 = parcel.readInt();
        this.A0D = parcel.readInt();
        this.A0N = parcel.readString();
        this.A03 = parcel.readInt();
        this.A0G = parcel.readLong();
        int i11 = parcel.readInt();
        this.A0P = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            this.A0P.add(parcel.createByteArray());
        }
        this.A0H = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.A0I = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public Format(String str, String str2, String str3, String str4, int i11, int i12, int i13, int i14, float f11, int i15, float f12, byte[] bArr, int i16, ColorInfo colorInfo, int i17, int i18, int i19, int i21, int i22, int i23, String str5, int i24, long j11, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        int i25 = i15;
        float f13 = f12;
        List<byte[]> list2 = list;
        int i26 = i22;
        int i27 = i21;
        this.A0M = str;
        this.A0L = str2;
        this.A0O = str3;
        this.A0K = str4;
        this.A04 = i11;
        this.A09 = i12;
        this.A0F = i13;
        this.A08 = i14;
        this.A01 = f11;
        this.A0B = i25 == -1 ? 0 : i25;
        this.A02 = f13 == -1.0f ? 1.0f : f13;
        this.A0Q = bArr;
        this.A0E = i16;
        this.A0J = colorInfo;
        this.A05 = i17;
        this.A0C = i18;
        this.A0A = i19;
        this.A06 = i27 == -1 ? 0 : i27;
        this.A07 = i26 == -1 ? 0 : i26;
        this.A0D = i23;
        this.A0N = str5;
        this.A03 = i24;
        this.A0G = j11;
        this.A0P = list2 == null ? Collections.emptyList() : list2;
        this.A0H = drmInitData;
        this.A0I = metadata;
    }

    public static Format A00(String str, String str2, int i11, String str3) {
        return A01(str, str2, i11, str3, null);
    }

    public static Format A01(String str, String str2, int i11, String str3, DrmInitData drmInitData) {
        return A09(str, str2, null, -1, i11, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format A02(String str, String str2, long j11) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j11, null, null, null);
    }

    public static Format A03(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, DrmInitData drmInitData) {
        return A04(str, str2, str3, i11, i12, i13, i14, f11, list, i15, f12, null, -1, null, drmInitData);
    }

    public static Format A04(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, byte[] bArr, int i16, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, i12, i13, i14, f11, i15, f12, bArr, i16, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format A05(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List<byte[]> list, DrmInitData drmInitData, int i18, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i11, i12, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i13, i14, i15, i16, i17, i18, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format A06(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, List<byte[]> list, DrmInitData drmInitData, int i16, String str4) {
        return A05(str, str2, str3, i11, i12, i13, i14, i15, -1, -1, list, drmInitData, i16, str4, null);
    }

    public static Format A07(String str, String str2, String str3, int i11, int i12, int i13, int i14, List<byte[]> list, DrmInitData drmInitData, int i15, String str4) {
        return A06(str, str2, str3, i11, i12, i13, i14, -1, list, drmInitData, i15, str4);
    }

    public static Format A08(String str, String str2, String str3, int i11, int i12, String str4, int i13, DrmInitData drmInitData) {
        return A09(str, str2, str3, i11, i12, str4, i13, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format A09(String str, String str2, String str3, int i11, int i12, String str4, int i13, DrmInitData drmInitData, long j11, List<byte[]> list) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str4, i13, j11, list, drmInitData, null);
    }

    public static Format A0A(String str, String str2, String str3, int i11, int i12, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format A0B(String str, String str2, String str3, int i11, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    public static String A0C(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0R, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0R = new byte[]{-64, -76, -91, -103, -44, -70, -29, -26, -31, -43, -24, -100, -4, -56, 7, -42, -54, 5};
    }

    public final int A0E() {
        int i11;
        int i12 = this.A0F;
        if (i12 == -1 || (i11 = this.A08) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public final Format A0F(int i11) {
        return new Format(this.A0M, this.A0L, this.A0O, this.A0K, this.A04, i11, this.A0F, this.A08, this.A01, this.A0B, this.A02, this.A0Q, this.A0E, this.A0J, this.A05, this.A0C, this.A0A, this.A06, this.A07, this.A0D, this.A0N, this.A03, this.A0G, this.A0P, this.A0H, this.A0I);
    }

    public final Format A0G(int i11, int i12) {
        return new Format(this.A0M, this.A0L, this.A0O, this.A0K, this.A04, this.A09, this.A0F, this.A08, this.A01, this.A0B, this.A02, this.A0Q, this.A0E, this.A0J, this.A05, this.A0C, this.A0A, i11, i12, this.A0D, this.A0N, this.A03, this.A0G, this.A0P, this.A0H, this.A0I);
    }

    public final Format A0H(long j11) {
        return new Format(this.A0M, this.A0L, this.A0O, this.A0K, this.A04, this.A09, this.A0F, this.A08, this.A01, this.A0B, this.A02, this.A0Q, this.A0E, this.A0J, this.A05, this.A0C, this.A0A, this.A06, this.A07, this.A0D, this.A0N, this.A03, j11, this.A0P, this.A0H, this.A0I);
    }

    public final Format A0I(DrmInitData drmInitData) {
        return new Format(this.A0M, this.A0L, this.A0O, this.A0K, this.A04, this.A09, this.A0F, this.A08, this.A01, this.A0B, this.A02, this.A0Q, this.A0E, this.A0J, this.A05, this.A0C, this.A0A, this.A06, this.A07, this.A0D, this.A0N, this.A03, this.A0G, this.A0P, drmInitData, this.A0I);
    }

    public final Format A0J(Metadata metadata) {
        return new Format(this.A0M, this.A0L, this.A0O, this.A0K, this.A04, this.A09, this.A0F, this.A08, this.A01, this.A0B, this.A02, this.A0Q, this.A0E, this.A0J, this.A05, this.A0C, this.A0A, this.A06, this.A07, this.A0D, this.A0N, this.A03, this.A0G, this.A0P, this.A0H, metadata);
    }

    public final boolean A0K(Format format) {
        if (this.A0P.size() != format.A0P.size()) {
            return false;
        }
        int i11 = 0;
        while (true) {
            List<byte[]> list = this.A0P;
            if (A0S[3].charAt(4) == '0') {
                throw new RuntimeException();
            }
            A0S[2] = "uHGTVrJUseEQDWcSJLRyHn1PY5AFGLRu";
            if (i11 >= list.size()) {
                return true;
            }
            if (!Arrays.equals(this.A0P.get(i11), format.A0P.get(i11))) {
                return false;
            }
            i11++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:59:0x0100  */
    /* JADX WARN: Code duplicated, block: B:61:0x010a  */
    /* JADX WARN: Code duplicated, block: B:69:0x013e  */
    /* JADX WARN: Code duplicated, block: B:71:0x014d  */
    /* JADX WARN: Code duplicated, block: B:76:0x015e  */
    public final boolean equals(Object obj) {
        String str;
        ColorInfo colorInfo;
        String[] strArr;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.A04 == format.A04 && this.A09 == format.A09) {
            int i11 = this.A0F;
            if (A0S[4].charAt(8) != '9') {
                A0S[3] = "YrEQPEqu2GB6vlsdXjmJSeOGWAWP5tGQ";
                if (i11 == format.A0F && this.A08 == format.A08 && this.A01 == format.A01 && this.A0B == format.A0B && this.A02 == format.A02 && this.A0E == format.A0E) {
                    int i12 = this.A05;
                    if (A0S[2].charAt(6) == 'J') {
                        A0S[5] = "dtmGMsl47Kb3ocf3vaQ48H6EwFmy0d0E";
                        if (i12 == format.A05 && this.A0C == format.A0C && this.A0A == format.A0A && this.A06 == format.A06 && this.A07 == format.A07 && this.A0G == format.A0G && this.A0D == format.A0D) {
                            String str2 = this.A0M;
                            String[] strArr2 = A0S;
                            if (strArr2[0].charAt(28) != strArr2[7].charAt(28)) {
                                A0S[6] = "6Jv3P6Xd4u6L";
                                if (IF.A0g(str2, format.A0M)) {
                                    if (IF.A0g(this.A0N, format.A0N) && this.A03 == format.A03) {
                                        str = this.A0L;
                                        if (A0S[6].length() != 12) {
                                            String[] strArr3 = A0S;
                                            strArr3[0] = "f4qynKSZGBMQmFS8yoPbqVTy60hYeCHe";
                                            strArr3[7] = "pyecG5gqeuRBtn7wAU0OCN03CmXuXhcb";
                                            if (IF.A0g(str, format.A0L)) {
                                                if (IF.A0g(this.A0O, format.A0O) && IF.A0g(this.A0K, format.A0K) && IF.A0g(this.A0H, format.A0H) && IF.A0g(this.A0I, format.A0I)) {
                                                    colorInfo = this.A0J;
                                                    strArr = A0S;
                                                    if (strArr[0].charAt(28) != strArr[7].charAt(28)) {
                                                        A0S[4] = "rye8QllKI3Tp3xq4xqdTraq6YPVl5KkX";
                                                        if (!IF.A0g(colorInfo, format.A0J) && Arrays.equals(this.A0Q, format.A0Q) && A0K(format)) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            A0S[2] = "P2mIdYJpvo0SLqii3TvA33Xjwdry7qiI";
                                            if (IF.A0g(str, format.A0L)) {
                                                if (IF.A0g(this.A0O, format.A0O)) {
                                                    colorInfo = this.A0J;
                                                    strArr = A0S;
                                                    if (strArr[0].charAt(28) != strArr[7].charAt(28)) {
                                                        A0S[4] = "rye8QllKI3Tp3xq4xqdTraq6YPVl5KkX";
                                                        if (!IF.A0g(colorInfo, format.A0J)) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                A0S[1] = "9bj8jGrex8FoihHu";
                                if (IF.A0g(str2, format.A0M)) {
                                    if (IF.A0g(this.A0N, format.A0N)) {
                                        str = this.A0L;
                                        if (A0S[6].length() != 12) {
                                            String[] strArr4 = A0S;
                                            strArr4[0] = "f4qynKSZGBMQmFS8yoPbqVTy60hYeCHe";
                                            strArr4[7] = "pyecG5gqeuRBtn7wAU0OCN03CmXuXhcb";
                                            if (IF.A0g(str, format.A0L)) {
                                                if (IF.A0g(this.A0O, format.A0O)) {
                                                    colorInfo = this.A0J;
                                                    strArr = A0S;
                                                    if (strArr[0].charAt(28) != strArr[7].charAt(28)) {
                                                        A0S[4] = "rye8QllKI3Tp3xq4xqdTraq6YPVl5KkX";
                                                        if (!IF.A0g(colorInfo, format.A0J)) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            A0S[2] = "P2mIdYJpvo0SLqii3TvA33Xjwdry7qiI";
                                            if (IF.A0g(str, format.A0L)) {
                                                if (IF.A0g(this.A0O, format.A0O)) {
                                                    colorInfo = this.A0J;
                                                    strArr = A0S;
                                                    if (strArr[0].charAt(28) != strArr[7].charAt(28)) {
                                                        A0S[4] = "rye8QllKI3Tp3xq4xqdTraq6YPVl5KkX";
                                                        if (!IF.A0g(colorInfo, format.A0J)) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i11 = 17 * 31;
            String str = this.A0M;
            int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.A0L;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.A0O;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.A0K;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.A04) * 31) + this.A0F) * 31) + this.A08) * 31) + this.A05) * 31) + this.A0C) * 31;
            String str5 = this.A0N;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.A03) * 31;
            DrmInitData drmInitData = this.A0H;
            int iHashCode6 = (iHashCode5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
            Metadata metadata = this.A0I;
            this.A00 = iHashCode6 + (metadata != null ? metadata.hashCode() : 0);
        }
        return this.A00;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(A0C(5, 7, 69)).append(this.A0M);
        String strA0C = A0C(0, 2, 101);
        return sbAppend.append(strA0C).append(this.A0L).append(strA0C).append(this.A0O).append(strA0C).append(this.A04).append(strA0C).append(this.A0N).append(A0C(2, 3, 74)).append(this.A0F).append(strA0C).append(this.A08).append(strA0C).append(this.A01).append(A0C(14, 4, 123)).append(this.A05).append(strA0C).append(this.A0C).append(A0C(12, 2, 112)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.A0M);
        parcel.writeString(this.A0L);
        parcel.writeString(this.A0O);
        parcel.writeString(this.A0K);
        parcel.writeInt(this.A04);
        parcel.writeInt(this.A09);
        parcel.writeInt(this.A0F);
        parcel.writeInt(this.A08);
        parcel.writeFloat(this.A01);
        parcel.writeInt(this.A0B);
        parcel.writeFloat(this.A02);
        IF.A0V(parcel, this.A0Q != null);
        byte[] bArr = this.A0Q;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.A0E);
        parcel.writeParcelable(this.A0J, i11);
        parcel.writeInt(this.A05);
        parcel.writeInt(this.A0C);
        parcel.writeInt(this.A0A);
        parcel.writeInt(this.A06);
        parcel.writeInt(this.A07);
        parcel.writeInt(this.A0D);
        parcel.writeString(this.A0N);
        parcel.writeInt(this.A03);
        parcel.writeLong(this.A0G);
        int size = this.A0P.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            parcel.writeByteArray(this.A0P.get(i12));
        }
        parcel.writeParcelable(this.A0H, 0);
        parcel.writeParcelable(this.A0I, 0);
    }
}
