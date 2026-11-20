package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class sb extends ya {
    public static final Parcelable.Creator<sb> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22323d;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sb createFromParcel(Parcel parcel) {
            return new sb(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sb[] newArray(int i11) {
            return new sb[i11];
        }
    }

    public sb(Parcel parcel) {
        super("----");
        this.f22321b = (String) xp.a((Object) parcel.readString());
        this.f22322c = (String) xp.a((Object) parcel.readString());
        this.f22323d = (String) xp.a((Object) parcel.readString());
    }

    public sb(String str, String str2, String str3) {
        super("----");
        this.f22321b = str;
        this.f22322c = str2;
        this.f22323d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || sb.class != obj.getClass()) {
            return false;
        }
        sb sbVar = (sb) obj;
        return xp.a((Object) this.f22322c, (Object) sbVar.f22322c) && xp.a((Object) this.f22321b, (Object) sbVar.f22321b) && xp.a((Object) this.f22323d, (Object) sbVar.f22323d);
    }

    public int hashCode() {
        String str = this.f22321b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f22322c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22323d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": domain=" + this.f22321b + ", description=" + this.f22322c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24575a);
        parcel.writeString(this.f22321b);
        parcel.writeString(this.f22323d);
    }
}
