package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class dr implements bf.b {
    public static final Parcelable.Creator<dr> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18502b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public dr createFromParcel(Parcel parcel) {
            return new dr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public dr[] newArray(int i11) {
            return new dr[i11];
        }
    }

    public dr(Parcel parcel) {
        this.f18501a = (String) xp.a((Object) parcel.readString());
        this.f18502b = (String) xp.a((Object) parcel.readString());
    }

    public dr(String str, String str2) {
        this.f18501a = str;
        this.f18502b = str2;
    }

    @Override // com.applovin.impl.bf.b
    public void a(vd.b bVar) {
        String str = this.f18501a;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.b(this.f18502b);
                break;
            case "TITLE":
                bVar.k(this.f18502b);
                break;
            case "DESCRIPTION":
                bVar.g(this.f18502b);
                break;
            case "ALBUMARTIST":
                bVar.a(this.f18502b);
                break;
            case "ARTIST":
                bVar.c(this.f18502b);
                break;
        }
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ byte[] a() {
        return jt.b(this);
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ f9 b() {
        return jt.c(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dr.class != obj.getClass()) {
            return false;
        }
        dr drVar = (dr) obj;
        return this.f18501a.equals(drVar.f18501a) && this.f18502b.equals(drVar.f18502b);
    }

    public int hashCode() {
        return ((this.f18501a.hashCode() + 527) * 31) + this.f18502b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f18501a + "=" + this.f18502b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f18501a);
        parcel.writeString(this.f18502b);
    }
}
