package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class TrackDataWrapper implements Parcelable {
    public static final Parcelable.Creator<TrackDataWrapper> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f50755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TrackData f50756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f50757c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<TrackDataWrapper> {
        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper createFromParcel(Parcel parcel) {
            return new TrackDataWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper[] newArray(int i11) {
            return new TrackDataWrapper[i11];
        }
    }

    public TrackDataWrapper(Parcel parcel) {
        this.f50755a = parcel.readString();
        this.f50756b = (TrackData) parcel.readParcelable(TrackData.class.getClassLoader());
        this.f50757c = parcel.readLong();
    }

    public TrackDataWrapper(String str, TrackData trackData, long j11) {
        this.f50755a = str;
        this.f50756b = trackData;
        this.f50757c = j11;
    }

    public String a() {
        String str = this.f50755a;
        return str == null ? "" : str;
    }

    public long b() {
        return this.f50757c;
    }

    public TrackData c() {
        return this.f50756b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f50755a);
        parcel.writeParcelable(this.f50756b, i11);
        parcel.writeLong(this.f50757c);
    }
}
