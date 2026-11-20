package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f7768a = versionedParcel.p(iconCompat.f7768a, 1);
        iconCompat.f7770c = versionedParcel.j(iconCompat.f7770c, 2);
        iconCompat.f7771d = versionedParcel.r(iconCompat.f7771d, 3);
        iconCompat.f7772e = versionedParcel.p(iconCompat.f7772e, 4);
        iconCompat.f7773f = versionedParcel.p(iconCompat.f7773f, 5);
        iconCompat.f7774g = (ColorStateList) versionedParcel.r(iconCompat.f7774g, 6);
        iconCompat.f7776i = versionedParcel.t(iconCompat.f7776i, 7);
        iconCompat.f7777j = versionedParcel.t(iconCompat.f7777j, 8);
        iconCompat.v();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.w(versionedParcel.f());
        int i11 = iconCompat.f7768a;
        if (-1 != i11) {
            versionedParcel.F(i11, 1);
        }
        byte[] bArr = iconCompat.f7770c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f7771d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i12 = iconCompat.f7772e;
        if (i12 != 0) {
            versionedParcel.F(i12, 4);
        }
        int i13 = iconCompat.f7773f;
        if (i13 != 0) {
            versionedParcel.F(i13, 5);
        }
        ColorStateList colorStateList = iconCompat.f7774g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f7776i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f7777j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
