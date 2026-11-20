package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class aa extends ya {
    public static final Parcelable.Creator<aa> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17495d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f17496f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public aa createFromParcel(Parcel parcel) {
            return new aa(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public aa[] newArray(int i11) {
            return new aa[i11];
        }
    }

    public aa(Parcel parcel) {
        super("GEOB");
        this.f17493b = (String) xp.a((Object) parcel.readString());
        this.f17494c = (String) xp.a((Object) parcel.readString());
        this.f17495d = (String) xp.a((Object) parcel.readString());
        this.f17496f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public aa(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f17493b = str;
        this.f17494c = str2;
        this.f17495d = str3;
        this.f17496f = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || aa.class != obj.getClass()) {
            return false;
        }
        aa aaVar = (aa) obj;
        return xp.a((Object) this.f17493b, (Object) aaVar.f17493b) && xp.a((Object) this.f17494c, (Object) aaVar.f17494c) && xp.a((Object) this.f17495d, (Object) aaVar.f17495d) && Arrays.equals(this.f17496f, aaVar.f17496f);
    }

    public int hashCode() {
        String str = this.f17493b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f17494c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17495d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f17496f);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": mimeType=" + this.f17493b + ", filename=" + this.f17494c + ", description=" + this.f17495d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f17493b);
        parcel.writeString(this.f17494c);
        parcel.writeString(this.f17495d);
        parcel.writeByteArray(this.f17496f);
    }
}
