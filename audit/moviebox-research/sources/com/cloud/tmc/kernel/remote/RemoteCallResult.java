package com.cloud.tmc.kernel.remote;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class RemoteCallResult implements Parcelable {
    public static final Parcelable.Creator<RemoteCallResult> CREATOR = new a();
    private boolean isError;
    private Object value;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<RemoteCallResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteCallResult createFromParcel(Parcel parcel) {
            return new RemoteCallResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RemoteCallResult[] newArray(int i11) {
            return new RemoteCallResult[i11];
        }
    }

    public RemoteCallResult(Parcel parcel) {
        this.isError = false;
        this.isError = parcel.readByte() != 0;
        this.value = parcel.readValue(getClass().getClassLoader());
    }

    public RemoteCallResult(Object obj) {
        this.isError = false;
        if (obj instanceof Throwable) {
            this.isError = true;
        }
        this.value = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isError() {
        return this.isError;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.isError ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.value);
    }
}
