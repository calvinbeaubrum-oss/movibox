package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fd implements bf.b {
    public static final Parcelable.Creator<fd> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f18964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18966d;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public fd createFromParcel(Parcel parcel) {
            return new fd(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public fd[] newArray(int i11) {
            return new fd[i11];
        }
    }

    private fd(Parcel parcel) {
        this.f18963a = (String) xp.a((Object) parcel.readString());
        this.f18964b = (byte[]) xp.a((Object) parcel.createByteArray());
        this.f18965c = parcel.readInt();
        this.f18966d = parcel.readInt();
    }

    public /* synthetic */ fd(Parcel parcel, a aVar) {
        this(parcel);
    }

    public fd(String str, byte[] bArr, int i11, int i12) {
        this.f18963a = str;
        this.f18964b = bArr;
        this.f18965c = i11;
        this.f18966d = i12;
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ void a(vd.b bVar) {
        jt.a(this, bVar);
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
        if (obj == null || fd.class != obj.getClass()) {
            return false;
        }
        fd fdVar = (fd) obj;
        return this.f18963a.equals(fdVar.f18963a) && Arrays.equals(this.f18964b, fdVar.f18964b) && this.f18965c == fdVar.f18965c && this.f18966d == fdVar.f18966d;
    }

    public int hashCode() {
        return ((((((this.f18963a.hashCode() + 527) * 31) + Arrays.hashCode(this.f18964b)) * 31) + this.f18965c) * 31) + this.f18966d;
    }

    public String toString() {
        return "mdta: key=" + this.f18963a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f18963a);
        parcel.writeByteArray(this.f18964b);
        parcel.writeInt(this.f18965c);
        parcel.writeInt(this.f18966d);
    }
}
