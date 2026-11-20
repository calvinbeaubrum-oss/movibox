package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.d0;
import androidx.media3.common.e0;
import androidx.media3.common.y;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Mp4TimestampData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4TimestampData> CREATOR = new a();
    public static final int TIMESCALE_UNSET = -1;
    public final long creationTimestampSeconds;
    public final long modificationTimestampSeconds;
    public final long timescale;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<Mp4TimestampData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mp4TimestampData createFromParcel(Parcel parcel) {
            return new Mp4TimestampData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Mp4TimestampData[] newArray(int i11) {
            return new Mp4TimestampData[i11];
        }
    }

    public Mp4TimestampData(long j11) {
        this.creationTimestampSeconds = j11;
        this.modificationTimestampSeconds = C.TIME_UNSET;
        this.timescale = -1L;
    }

    public Mp4TimestampData(long j11, long j12, long j13) {
        this.creationTimestampSeconds = j11;
        this.modificationTimestampSeconds = j12;
        this.timescale = j13;
    }

    private Mp4TimestampData(Parcel parcel) {
        this.creationTimestampSeconds = parcel.readLong();
        this.modificationTimestampSeconds = parcel.readLong();
        this.timescale = parcel.readLong();
    }

    public /* synthetic */ Mp4TimestampData(Parcel parcel, a aVar) {
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
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.creationTimestampSeconds == mp4TimestampData.creationTimestampSeconds && this.modificationTimestampSeconds == mp4TimestampData.modificationTimestampSeconds && this.timescale == mp4TimestampData.timescale;
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
        return ((((527 + Longs.e(this.creationTimestampSeconds)) * 31) + Longs.e(this.modificationTimestampSeconds)) * 31) + Longs.e(this.timescale);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public /* synthetic */ void populateMediaMetadata(d0.b bVar) {
        e0.c(this, bVar);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.creationTimestampSeconds + ", modification time=" + this.modificationTimestampSeconds + ", timescale=" + this.timescale;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.creationTimestampSeconds);
        parcel.writeLong(this.modificationTimestampSeconds);
        parcel.writeLong(this.timescale);
    }
}
