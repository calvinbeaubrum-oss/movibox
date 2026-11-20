package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class uk extends sk {
    public static final Parcelable.Creator<uk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23615d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f23616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f23617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f23618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f23619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f23620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f23621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f23622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f23623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f23624n;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public uk createFromParcel(Parcel parcel) {
            return new uk(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public uk[] newArray(int i11) {
            return new uk[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f23626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f23627c;

        private b(int i11, long j11, long j12) {
            this.f23625a = i11;
            this.f23626b = j11;
            this.f23627c = j12;
        }

        public /* synthetic */ b(int i11, long j11, long j12, a aVar) {
            this(i11, j11, j12);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f23625a);
            parcel.writeLong(this.f23626b);
            parcel.writeLong(this.f23627c);
        }
    }

    private uk(long j11, boolean z11, boolean z12, boolean z13, boolean z14, long j12, long j13, List list, boolean z15, long j14, int i11, int i12, int i13) {
        this.f23612a = j11;
        this.f23613b = z11;
        this.f23614c = z12;
        this.f23615d = z13;
        this.f23616f = z14;
        this.f23617g = j12;
        this.f23618h = j13;
        this.f23619i = Collections.unmodifiableList(list);
        this.f23620j = z15;
        this.f23621k = j14;
        this.f23622l = i11;
        this.f23623m = i12;
        this.f23624n = i13;
    }

    private uk(Parcel parcel) {
        this.f23612a = parcel.readLong();
        this.f23613b = parcel.readByte() == 1;
        this.f23614c = parcel.readByte() == 1;
        this.f23615d = parcel.readByte() == 1;
        this.f23616f = parcel.readByte() == 1;
        this.f23617g = parcel.readLong();
        this.f23618h = parcel.readLong();
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(b.a(parcel));
        }
        this.f23619i = Collections.unmodifiableList(arrayList);
        this.f23620j = parcel.readByte() == 1;
        this.f23621k = parcel.readLong();
        this.f23622l = parcel.readInt();
        this.f23623m = parcel.readInt();
        this.f23624n = parcel.readInt();
    }

    public /* synthetic */ uk(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static uk a(bh bhVar, long j11, ho hoVar) {
        List list;
        boolean z11;
        boolean z12;
        long j12;
        boolean z13;
        long j13;
        int iC;
        int iW;
        int iW2;
        boolean z14;
        boolean z15;
        long jY;
        long jY2 = bhVar.y();
        boolean z16 = (bhVar.w() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z16) {
            list = listEmptyList;
            z11 = false;
            z12 = false;
            j12 = C.TIME_UNSET;
            z13 = false;
            j13 = C.TIME_UNSET;
            iC = 0;
            iW = 0;
            iW2 = 0;
            z14 = false;
        } else {
            int iW3 = bhVar.w();
            boolean z17 = (iW3 & 128) != 0;
            boolean z18 = (iW3 & 64) != 0;
            boolean z19 = (iW3 & 32) != 0;
            boolean z21 = (iW3 & 16) != 0;
            long jA = (!z18 || z21) ? C.TIME_UNSET : Cdo.a(bhVar, j11);
            if (!z18) {
                int iW4 = bhVar.w();
                ArrayList arrayList = new ArrayList(iW4);
                for (int i11 = 0; i11 < iW4; i11++) {
                    int iW5 = bhVar.w();
                    long jA2 = !z21 ? Cdo.a(bhVar, j11) : C.TIME_UNSET;
                    arrayList.add(new b(iW5, jA2, hoVar.b(jA2), null));
                }
                listEmptyList = arrayList;
            }
            if (z19) {
                long jW = bhVar.w();
                boolean z22 = (128 & jW) != 0;
                jY = ((((jW & 1) << 32) | bhVar.y()) * 1000) / 90;
                z15 = z22;
            } else {
                z15 = false;
                jY = C.TIME_UNSET;
            }
            iC = bhVar.C();
            z14 = z18;
            iW = bhVar.w();
            iW2 = bhVar.w();
            list = listEmptyList;
            long j14 = jA;
            z13 = z15;
            j13 = jY;
            z12 = z21;
            z11 = z17;
            j12 = j14;
        }
        return new uk(jY2, z16, z11, z14, z12, j12, hoVar.b(j12), list, z13, j13, iC, iW, iW2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f23612a);
        parcel.writeByte(this.f23613b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23614c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23615d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23616f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f23617g);
        parcel.writeLong(this.f23618h);
        int size = this.f23619i.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            ((b) this.f23619i.get(i12)).b(parcel);
        }
        parcel.writeByte(this.f23620j ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f23621k);
        parcel.writeInt(this.f23622l);
        parcel.writeInt(this.f23623m);
        parcel.writeInt(this.f23624n);
    }
}
