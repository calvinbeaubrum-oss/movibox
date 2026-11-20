package com.facebook.ads.internal.androidx.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbsSavedState implements Parcelable {
    public static byte[] A01;
    public static final AbsSavedState A02;
    public static final Parcelable.Creator<AbsSavedState> CREATOR;
    public final Parcelable A00;

    static {
        A01();
        A02 = new AbsSavedState() { // from class: com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState.1
        };
        CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() { // from class: com.facebook.ads.redexgen.X.32
            public static byte[] A00;

            static {
                A03();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final AbsSavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.A02;
                }
                throw new IllegalStateException(A02(0, 23, 119));
            }

            public static String A02(int i11, int i12, int i13) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
                for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                    bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 92);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A03() {
                A00 = new byte[]{88, 94, 91, 78, 89, 120, 95, 74, 95, 78, Ascii.VT, 70, 94, 88, 95, Ascii.VT, 73, 78, Ascii.VT, 69, 94, 71, 71};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
            public final AbsSavedState[] newArray(int i11) {
                return new AbsSavedState[i11];
            }
        };
    }

    public AbsSavedState() {
        this.A00 = null;
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.A00 = parcelable == null ? A02 : parcelable;
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException(A00(0, 27, 105));
        }
        this.A00 = parcelable == A02 ? null : parcelable;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{49, 55, 50, 39, 48, 17, 54, 35, 54, 39, 98, 47, 55, 49, 54, 98, 44, 45, 54, 98, 32, 39, 98, 44, 55, 46, 46};
    }

    public final Parcelable A02() {
        return this.A00;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.A00, i11);
    }
}
