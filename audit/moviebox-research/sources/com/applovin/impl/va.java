package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class va implements bf.b {
    public static final Parcelable.Creator<va> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23814d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f23815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f23816g;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public va createFromParcel(Parcel parcel) {
            return new va(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public va[] newArray(int i11) {
            return new va[i11];
        }
    }

    public va(int i11, String str, String str2, String str3, boolean z11, int i12) {
        b1.a(i12 == -1 || i12 > 0);
        this.f23811a = i11;
        this.f23812b = str;
        this.f23813c = str2;
        this.f23814d = str3;
        this.f23815f = z11;
        this.f23816g = i12;
    }

    public va(Parcel parcel) {
        this.f23811a = parcel.readInt();
        this.f23812b = parcel.readString();
        this.f23813c = parcel.readString();
        this.f23814d = parcel.readString();
        this.f23815f = xp.a(parcel);
        this.f23816g = parcel.readInt();
    }

    public static va a(Map map) {
        boolean z11;
        int i11;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i12;
        int i13;
        List list = (List) map.get("icy-br");
        boolean z12 = true;
        int i14 = -1;
        if (list != null) {
            String str4 = (String) list.get(0);
            try {
                i13 = Integer.parseInt(str4) * 1000;
                if (i13 > 0) {
                    i11 = i13;
                    z11 = true;
                } else {
                    try {
                        pc.d("IcyHeaders", "Invalid bitrate: " + str4);
                        z11 = false;
                        i11 = -1;
                    } catch (NumberFormatException unused) {
                        pc.d("IcyHeaders", "Invalid bitrate header: " + str4);
                        i11 = i13;
                        z11 = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i13 = -1;
            }
        } else {
            z11 = false;
            i11 = -1;
        }
        List list2 = (List) map.get("icy-genre");
        if (list2 != null) {
            str = (String) list2.get(0);
            z11 = true;
        } else {
            str = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str2 = (String) list3.get(0);
            z11 = true;
        } else {
            str2 = null;
        }
        List list4 = (List) map.get("icy-url");
        if (list4 != null) {
            str3 = (String) list4.get(0);
            z11 = true;
        } else {
            str3 = null;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals("1");
            z11 = true;
        } else {
            zEquals = false;
        }
        List list6 = (List) map.get("icy-metaint");
        if (list6 != null) {
            String str5 = (String) list6.get(0);
            try {
                int i15 = Integer.parseInt(str5);
                if (i15 > 0) {
                    i12 = i15;
                } else {
                    try {
                        pc.d("IcyHeaders", "Invalid metadata interval: " + str5);
                        z12 = z11;
                        i12 = -1;
                    } catch (NumberFormatException unused3) {
                        i14 = i15;
                        pc.d("IcyHeaders", "Invalid metadata interval: " + str5);
                        z12 = z11;
                        i12 = i14;
                    }
                }
            } catch (NumberFormatException unused4) {
            }
        } else {
            z12 = z11;
            i12 = -1;
        }
        if (z12) {
            return new va(i11, str, str2, str3, zEquals, i12);
        }
        return null;
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
        if (obj == null || va.class != obj.getClass()) {
            return false;
        }
        va vaVar = (va) obj;
        return this.f23811a == vaVar.f23811a && xp.a((Object) this.f23812b, (Object) vaVar.f23812b) && xp.a((Object) this.f23813c, (Object) vaVar.f23813c) && xp.a((Object) this.f23814d, (Object) vaVar.f23814d) && this.f23815f == vaVar.f23815f && this.f23816g == vaVar.f23816g;
    }

    public int hashCode() {
        int i11 = (this.f23811a + 527) * 31;
        String str = this.f23812b;
        int iHashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f23813c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f23814d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f23815f ? 1 : 0)) * 31) + this.f23816g;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f23813c + "\", genre=\"" + this.f23812b + "\", bitrate=" + this.f23811a + ", metadataInterval=" + this.f23816g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f23811a);
        parcel.writeString(this.f23812b);
        parcel.writeString(this.f23813c);
        parcel.writeString(this.f23814d);
        xp.a(parcel, this.f23815f);
        parcel.writeInt(this.f23816g);
    }
}
