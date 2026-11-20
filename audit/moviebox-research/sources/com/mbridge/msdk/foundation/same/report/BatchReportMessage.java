package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() { // from class: com.mbridge.msdk.foundation.same.report.BatchReportMessage.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BatchReportMessage[] newArray(int i11) {
            return new BatchReportMessage[i11];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f44732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f44733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44734c;

    public BatchReportMessage(Parcel parcel) {
        this.f44734c = parcel.readString();
        this.f44732a = parcel.readString();
        this.f44733b = parcel.readLong();
    }

    public BatchReportMessage(String str, String str2, long j11) {
        this.f44734c = str;
        this.f44732a = str2;
        this.f44733b = j11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f44732a;
    }

    public long getTimestamp() {
        return this.f44733b;
    }

    public String getUuid() {
        return this.f44734c;
    }

    public void setReportMessage(String str) {
        this.f44732a = str;
    }

    public void setTimestamp(long j11) {
        this.f44733b = j11;
    }

    public void setUuid(String str) {
        this.f44734c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f44734c);
        parcel.writeString(this.f44732a);
        parcel.writeLong(this.f44733b);
    }
}
