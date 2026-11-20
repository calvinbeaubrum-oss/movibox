package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class wa implements bf.b {
    public static final Parcelable.Creator<wa> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f24077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24079c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wa createFromParcel(Parcel parcel) {
            return new wa(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wa[] newArray(int i11) {
            return new wa[i11];
        }
    }

    public wa(Parcel parcel) {
        this.f24077a = (byte[]) b1.a(parcel.createByteArray());
        this.f24078b = parcel.readString();
        this.f24079c = parcel.readString();
    }

    public wa(byte[] bArr, String str, String str2) {
        this.f24077a = bArr;
        this.f24078b = str;
        this.f24079c = str2;
    }

    @Override // com.applovin.impl.bf.b
    public void a(vd.b bVar) {
        String str = this.f24078b;
        if (str != null) {
            bVar.k(str);
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
        if (obj == null || wa.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f24077a, ((wa) obj).f24077a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f24077a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f24078b, this.f24079c, Integer.valueOf(this.f24077a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByteArray(this.f24077a);
        parcel.writeString(this.f24078b);
        parcel.writeString(this.f24079c);
    }
}
