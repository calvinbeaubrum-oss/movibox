package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e3 extends ya {
    public static final Parcelable.Creator<e3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18548d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f18549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f18550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ya[] f18551h;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e3 createFromParcel(Parcel parcel) {
            return new e3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e3[] newArray(int i11) {
            return new e3[i11];
        }
    }

    public e3(Parcel parcel) {
        super("CHAP");
        this.f18546b = (String) xp.a((Object) parcel.readString());
        this.f18547c = parcel.readInt();
        this.f18548d = parcel.readInt();
        this.f18549f = parcel.readLong();
        this.f18550g = parcel.readLong();
        int i11 = parcel.readInt();
        this.f18551h = new ya[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.f18551h[i12] = (ya) parcel.readParcelable(ya.class.getClassLoader());
        }
    }

    public e3(String str, int i11, int i12, long j11, long j12, ya[] yaVarArr) {
        super("CHAP");
        this.f18546b = str;
        this.f18547c = i11;
        this.f18548d = i12;
        this.f18549f = j11;
        this.f18550g = j12;
        this.f18551h = yaVarArr;
    }

    @Override // com.applovin.impl.ya, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e3.class != obj.getClass()) {
            return false;
        }
        e3 e3Var = (e3) obj;
        return this.f18547c == e3Var.f18547c && this.f18548d == e3Var.f18548d && this.f18549f == e3Var.f18549f && this.f18550g == e3Var.f18550g && xp.a((Object) this.f18546b, (Object) e3Var.f18546b) && Arrays.equals(this.f18551h, e3Var.f18551h);
    }

    public int hashCode() {
        int i11 = (((((((this.f18547c + 527) * 31) + this.f18548d) * 31) + ((int) this.f18549f)) * 31) + ((int) this.f18550g)) * 31;
        String str = this.f18546b;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f18546b);
        parcel.writeInt(this.f18547c);
        parcel.writeInt(this.f18548d);
        parcel.writeLong(this.f18549f);
        parcel.writeLong(this.f18550g);
        parcel.writeInt(this.f18551h.length);
        for (ya yaVar : this.f18551h) {
            parcel.writeParcelable(yaVar, 0);
        }
    }
}
