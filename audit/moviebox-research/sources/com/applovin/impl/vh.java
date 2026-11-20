package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class vh extends ya {
    public static final Parcelable.Creator<vh> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f23907c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vh createFromParcel(Parcel parcel) {
            return new vh(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vh[] newArray(int i11) {
            return new vh[i11];
        }
    }

    public vh(Parcel parcel) {
        super("PRIV");
        this.f23906b = (String) xp.a((Object) parcel.readString());
        this.f23907c = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public vh(String str, byte[] bArr) {
        super("PRIV");
        this.f23906b = str;
        this.f23907c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vh.class != obj.getClass()) {
            return false;
        }
        vh vhVar = (vh) obj;
        return xp.a((Object) this.f23906b, (Object) vhVar.f23906b) && Arrays.equals(this.f23907c, vhVar.f23907c);
    }

    public int hashCode() {
        String str = this.f23906b;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f23907c);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": owner=" + this.f23906b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f23906b);
        parcel.writeByteArray(this.f23907c);
    }
}
