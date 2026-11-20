package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Objects;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class jk implements bf.b {
    public static final Parcelable.Creator<jk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19982a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jk createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new jk(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jk[] newArray(int i11) {
            return new jk[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator f19983d = new Comparator() { // from class: com.applovin.impl.bz
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return jk.b.a((jk.b) obj, (jk.b) obj2);
            }
        };
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(long j11, long j12, int i11) {
            b1.a(j11 < j12);
            this.f19984a = j11;
            this.f19985b = j12;
            this.f19986c = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            return y3.e().a(bVar.f19984a, bVar2.f19984a).a(bVar.f19985b, bVar2.f19985b).a(bVar.f19986c, bVar2.f19986c).d();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f19984a == bVar.f19984a && this.f19985b == bVar.f19985b && this.f19986c == bVar.f19986c;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f19984a), Long.valueOf(this.f19985b), Integer.valueOf(this.f19986c));
        }

        public String toString() {
            return xp.a("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f19984a), Long.valueOf(this.f19985b), Integer.valueOf(this.f19986c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeLong(this.f19984a);
            parcel.writeLong(this.f19985b);
            parcel.writeInt(this.f19986c);
        }
    }

    public jk(List list) {
        this.f19982a = list;
        b1.a(!a(list));
    }

    private static boolean a(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j11 = ((b) list.get(0)).f19985b;
        for (int i11 = 1; i11 < list.size(); i11++) {
            if (((b) list.get(i11)).f19984a < j11) {
                return true;
            }
            j11 = ((b) list.get(i11)).f19985b;
        }
        return false;
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
        if (obj == null || jk.class != obj.getClass()) {
            return false;
        }
        return this.f19982a.equals(((jk) obj).f19982a);
    }

    public int hashCode() {
        return this.f19982a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f19982a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeList(this.f19982a);
    }
}
