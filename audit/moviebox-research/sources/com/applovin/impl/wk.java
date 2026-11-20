package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class wk extends sk {
    public static final Parcelable.Creator<wk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24098a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wk createFromParcel(Parcel parcel) {
            return new wk(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wk[] newArray(int i11) {
            return new wk[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f24100b;

        private b(int i11, long j11) {
            this.f24099a = i11;
            this.f24100b = j11;
        }

        public /* synthetic */ b(int i11, long j11, a aVar) {
            this(i11, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f24099a);
            parcel.writeLong(this.f24100b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f24101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f24104d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f24105e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f24106f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f24107g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f24108h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f24109i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f24110j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f24111k;

        private c(long j11, boolean z11, boolean z12, boolean z13, List list, long j12, boolean z14, long j13, int i11, int i12, int i13) {
            this.f24101a = j11;
            this.f24102b = z11;
            this.f24103c = z12;
            this.f24104d = z13;
            this.f24106f = Collections.unmodifiableList(list);
            this.f24105e = j12;
            this.f24107g = z14;
            this.f24108h = j13;
            this.f24109i = i11;
            this.f24110j = i12;
            this.f24111k = i13;
        }

        private c(Parcel parcel) {
            this.f24101a = parcel.readLong();
            this.f24102b = parcel.readByte() == 1;
            this.f24103c = parcel.readByte() == 1;
            this.f24104d = parcel.readByte() == 1;
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(b.b(parcel));
            }
            this.f24106f = Collections.unmodifiableList(arrayList);
            this.f24105e = parcel.readLong();
            this.f24107g = parcel.readByte() == 1;
            this.f24108h = parcel.readLong();
            this.f24109i = parcel.readInt();
            this.f24110j = parcel.readInt();
            this.f24111k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(bh bhVar) {
            ArrayList arrayList;
            boolean z11;
            long j11;
            boolean z12;
            long j12;
            int i11;
            int i12;
            int iW;
            boolean z13;
            boolean z14;
            long jY;
            long jY2 = bhVar.y();
            boolean z15 = (bhVar.w() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z15) {
                arrayList = arrayList2;
                z11 = false;
                j11 = C.TIME_UNSET;
                z12 = false;
                j12 = C.TIME_UNSET;
                i11 = 0;
                i12 = 0;
                iW = 0;
                z13 = false;
            } else {
                int iW2 = bhVar.w();
                boolean z16 = (iW2 & 128) != 0;
                boolean z17 = (iW2 & 64) != 0;
                boolean z18 = (iW2 & 32) != 0;
                long jY3 = z17 ? bhVar.y() : C.TIME_UNSET;
                if (!z17) {
                    int iW3 = bhVar.w();
                    ArrayList arrayList3 = new ArrayList(iW3);
                    for (int i13 = 0; i13 < iW3; i13++) {
                        arrayList3.add(new b(bhVar.w(), bhVar.y(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z18) {
                    long jW = bhVar.w();
                    boolean z19 = (128 & jW) != 0;
                    jY = ((((jW & 1) << 32) | bhVar.y()) * 1000) / 90;
                    z14 = z19;
                } else {
                    z14 = false;
                    jY = C.TIME_UNSET;
                }
                int iC = bhVar.C();
                int iW4 = bhVar.w();
                z13 = z17;
                iW = bhVar.w();
                j12 = jY;
                arrayList = arrayList2;
                long j13 = jY3;
                i11 = iC;
                i12 = iW4;
                j11 = j13;
                boolean z21 = z16;
                z12 = z14;
                z11 = z21;
            }
            return new c(jY2, z15, z11, z13, arrayList, j11, z12, j12, i11, i12, iW);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeLong(this.f24101a);
            parcel.writeByte(this.f24102b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f24103c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f24104d ? (byte) 1 : (byte) 0);
            int size = this.f24106f.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f24106f.get(i11)).c(parcel);
            }
            parcel.writeLong(this.f24105e);
            parcel.writeByte(this.f24107g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f24108h);
            parcel.writeInt(this.f24109i);
            parcel.writeInt(this.f24110j);
            parcel.writeInt(this.f24111k);
        }
    }

    private wk(Parcel parcel) {
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(c.b(parcel));
        }
        this.f24098a = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ wk(Parcel parcel, a aVar) {
        this(parcel);
    }

    private wk(List list) {
        this.f24098a = Collections.unmodifiableList(list);
    }

    public static wk a(bh bhVar) {
        int iW = bhVar.w();
        ArrayList arrayList = new ArrayList(iW);
        for (int i11 = 0; i11 < iW; i11++) {
            arrayList.add(c.b(bhVar));
        }
        return new wk(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        int size = this.f24098a.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            ((c) this.f24098a.get(i12)).c(parcel);
        }
    }
}
