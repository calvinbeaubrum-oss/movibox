package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y6 implements Comparator, Parcelable {
    public static final Parcelable.Creator<y6> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f24555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24558d;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public y6 createFromParcel(Parcel parcel) {
            return new y6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public y6[] newArray(int i11) {
            return new y6[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f24560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f24561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f24562d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f24563f;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(Parcel parcel) {
            this.f24560b = new UUID(parcel.readLong(), parcel.readLong());
            this.f24561c = parcel.readString();
            this.f24562d = (String) xp.a((Object) parcel.readString());
            this.f24563f = parcel.createByteArray();
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.f24560b = (UUID) b1.a(uuid);
            this.f24561c = str;
            this.f24562d = (String) b1.a((Object) str2);
            this.f24563f = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public b a(byte[] bArr) {
            return new b(this.f24560b, this.f24561c, this.f24562d, bArr);
        }

        public boolean a(UUID uuid) {
            return t2.f23167a.equals(this.f24560b) || uuid.equals(this.f24560b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return xp.a((Object) this.f24561c, (Object) bVar.f24561c) && xp.a((Object) this.f24562d, (Object) bVar.f24562d) && xp.a(this.f24560b, bVar.f24560b) && Arrays.equals(this.f24563f, bVar.f24563f);
        }

        public int hashCode() {
            if (this.f24559a == 0) {
                int iHashCode = this.f24560b.hashCode() * 31;
                String str = this.f24561c;
                this.f24559a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f24562d.hashCode()) * 31) + Arrays.hashCode(this.f24563f);
            }
            return this.f24559a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeLong(this.f24560b.getMostSignificantBits());
            parcel.writeLong(this.f24560b.getLeastSignificantBits());
            parcel.writeString(this.f24561c);
            parcel.writeString(this.f24562d);
            parcel.writeByteArray(this.f24563f);
        }
    }

    public y6(Parcel parcel) {
        this.f24557c = parcel.readString();
        b[] bVarArr = (b[]) xp.a(parcel.createTypedArray(b.CREATOR));
        this.f24555a = bVarArr;
        this.f24558d = bVarArr.length;
    }

    private y6(String str, boolean z11, b... bVarArr) {
        this.f24557c = str;
        bVarArr = z11 ? (b[]) bVarArr.clone() : bVarArr;
        this.f24555a = bVarArr;
        this.f24558d = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public y6(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public y6(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public y6(b... bVarArr) {
        this(null, bVarArr);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = t2.f23167a;
        if (uuid.equals(bVar.f24560b)) {
            return uuid.equals(bVar2.f24560b) ? 0 : 1;
        }
        return bVar.f24560b.compareTo(bVar2.f24560b);
    }

    public b a(int i11) {
        return this.f24555a[i11];
    }

    public y6 a(String str) {
        return xp.a((Object) this.f24557c, (Object) str) ? this : new y6(str, false, this.f24555a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y6.class != obj.getClass()) {
            return false;
        }
        y6 y6Var = (y6) obj;
        return xp.a((Object) this.f24557c, (Object) y6Var.f24557c) && Arrays.equals(this.f24555a, y6Var.f24555a);
    }

    public int hashCode() {
        if (this.f24556b == 0) {
            String str = this.f24557c;
            this.f24556b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f24555a);
        }
        return this.f24556b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24557c);
        parcel.writeTypedArray(this.f24555a, 0);
    }
}
