package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.d0;
import androidx.media3.common.e0;
import androidx.media3.common.y;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class XmpData implements Metadata.Entry {
    public static final Parcelable.Creator<XmpData> CREATOR = new a();
    public final byte[] data;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<XmpData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public XmpData createFromParcel(Parcel parcel) {
            return new XmpData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public XmpData[] newArray(int i11) {
            return new XmpData[i11];
        }
    }

    private XmpData(Parcel parcel) {
        this.data = (byte[]) u0.i(parcel.createByteArray());
    }

    public /* synthetic */ XmpData(Parcel parcel, a aVar) {
        this(parcel);
    }

    public XmpData(byte[] bArr) {
        this.data = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.data, ((XmpData) obj).data);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return e0.a(this);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ y getWrappedMetadataFormat() {
        return e0.b(this);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(d0.b bVar) {
        e0.c(this, bVar);
    }

    public String toString() {
        return "XMP: " + u0.w1(this.data);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByteArray(this.data);
    }
}
