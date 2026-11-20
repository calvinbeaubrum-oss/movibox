package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u3 extends ya {
    public static final Parcelable.Creator<u3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23511d;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u3 createFromParcel(Parcel parcel) {
            return new u3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u3[] newArray(int i11) {
            return new u3[i11];
        }
    }

    public u3(Parcel parcel) {
        super("COMM");
        this.f23509b = (String) xp.a((Object) parcel.readString());
        this.f23510c = (String) xp.a((Object) parcel.readString());
        this.f23511d = (String) xp.a((Object) parcel.readString());
    }

    public u3(String str, String str2, String str3) {
        super("COMM");
        this.f23509b = str;
        this.f23510c = str2;
        this.f23511d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u3.class != obj.getClass()) {
            return false;
        }
        u3 u3Var = (u3) obj;
        return xp.a((Object) this.f23510c, (Object) u3Var.f23510c) && xp.a((Object) this.f23509b, (Object) u3Var.f23509b) && xp.a((Object) this.f23511d, (Object) u3Var.f23511d);
    }

    public int hashCode() {
        String str = this.f23509b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f23510c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f23511d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": language=" + this.f23509b + ", description=" + this.f23510c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24575a);
        parcel.writeString(this.f23509b);
        parcel.writeString(this.f23511d);
    }
}
