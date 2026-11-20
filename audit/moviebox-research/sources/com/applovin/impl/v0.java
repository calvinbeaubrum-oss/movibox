package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends ya {
    public static final Parcelable.Creator<v0> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23722d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f23723f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0 createFromParcel(Parcel parcel) {
            return new v0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0[] newArray(int i11) {
            return new v0[i11];
        }
    }

    public v0(Parcel parcel) {
        super("APIC");
        this.f23720b = (String) xp.a((Object) parcel.readString());
        this.f23721c = parcel.readString();
        this.f23722d = parcel.readInt();
        this.f23723f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public v0(String str, String str2, int i11, byte[] bArr) {
        super("APIC");
        this.f23720b = str;
        this.f23721c = str2;
        this.f23722d = i11;
        this.f23723f = bArr;
    }

    @Override // com.applovin.impl.ya, com.applovin.impl.bf.b
    public void a(vd.b bVar) {
        bVar.a(this.f23723f, this.f23722d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f23722d == v0Var.f23722d && xp.a((Object) this.f23720b, (Object) v0Var.f23720b) && xp.a((Object) this.f23721c, (Object) v0Var.f23721c) && Arrays.equals(this.f23723f, v0Var.f23723f);
    }

    public int hashCode() {
        int i11 = (this.f23722d + 527) * 31;
        String str = this.f23720b;
        int iHashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f23721c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f23723f);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": mimeType=" + this.f23720b + ", description=" + this.f23721c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f23720b);
        parcel.writeString(this.f23721c);
        parcel.writeInt(this.f23722d);
        parcel.writeByteArray(this.f23723f);
    }
}
