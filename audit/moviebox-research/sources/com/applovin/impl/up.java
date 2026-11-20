package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class up extends ya {
    public static final Parcelable.Creator<up> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23699c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public up createFromParcel(Parcel parcel) {
            return new up(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public up[] newArray(int i11) {
            return new up[i11];
        }
    }

    public up(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f23698b = parcel.readString();
        this.f23699c = (String) xp.a((Object) parcel.readString());
    }

    public up(String str, String str2, String str3) {
        super(str);
        this.f23698b = str2;
        this.f23699c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || up.class != obj.getClass()) {
            return false;
        }
        up upVar = (up) obj;
        return this.f24575a.equals(upVar.f24575a) && xp.a((Object) this.f23698b, (Object) upVar.f23698b) && xp.a((Object) this.f23699c, (Object) upVar.f23699c);
    }

    public int hashCode() {
        int iHashCode = (this.f24575a.hashCode() + 527) * 31;
        String str = this.f23698b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f23699c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": url=" + this.f23699c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24575a);
        parcel.writeString(this.f23698b);
        parcel.writeString(this.f23699c);
    }
}
