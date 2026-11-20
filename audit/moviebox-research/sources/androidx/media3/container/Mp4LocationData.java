package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.d0;
import androidx.media3.common.e0;
import androidx.media3.common.y;
import com.google.common.primitives.Floats;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Mp4LocationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4LocationData> CREATOR = new a();
    public final float latitude;
    public final float longitude;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<Mp4LocationData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mp4LocationData createFromParcel(Parcel parcel) {
            return new Mp4LocationData(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Mp4LocationData[] newArray(int i11) {
            return new Mp4LocationData[i11];
        }
    }

    public Mp4LocationData(float f11, float f12) {
        z3.a.b(f11 >= -90.0f && f11 <= 90.0f && f12 >= -180.0f && f12 <= 180.0f, "Invalid latitude or longitude");
        this.latitude = f11;
        this.longitude = f12;
    }

    private Mp4LocationData(Parcel parcel) {
        this.latitude = parcel.readFloat();
        this.longitude = parcel.readFloat();
    }

    public /* synthetic */ Mp4LocationData(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Mp4LocationData.class != obj.getClass()) {
            return false;
        }
        Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
        return this.latitude == mp4LocationData.latitude && this.longitude == mp4LocationData.longitude;
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
        return ((527 + Floats.a(this.latitude)) * 31) + Floats.a(this.longitude);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(d0.b bVar) {
        e0.c(this, bVar);
    }

    public String toString() {
        return "xyz: latitude=" + this.latitude + ", longitude=" + this.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.latitude);
        parcel.writeFloat(this.longitude);
    }
}
