package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bf implements Parcelable {
    public static final Parcelable.Creator<bf> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f17917a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bf createFromParcel(Parcel parcel) {
            return new bf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bf[] newArray(int i11) {
            return new bf[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b extends Parcelable {
        void a(vd.b bVar);

        byte[] a();

        f9 b();
    }

    public bf(Parcel parcel) {
        this.f17917a = new b[parcel.readInt()];
        int i11 = 0;
        while (true) {
            b[] bVarArr = this.f17917a;
            if (i11 >= bVarArr.length) {
                return;
            }
            bVarArr[i11] = (b) parcel.readParcelable(b.class.getClassLoader());
            i11++;
        }
    }

    public bf(List list) {
        this.f17917a = (b[]) list.toArray(new b[0]);
    }

    public bf(b... bVarArr) {
        this.f17917a = bVarArr;
    }

    public b a(int i11) {
        return this.f17917a[i11];
    }

    public bf a(bf bfVar) {
        return bfVar == null ? this : a(bfVar.f17917a);
    }

    public bf a(b... bVarArr) {
        return bVarArr.length == 0 ? this : new bf((b[]) xp.a((Object[]) this.f17917a, (Object[]) bVarArr));
    }

    public int c() {
        return this.f17917a.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bf.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f17917a, ((bf) obj).f17917a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f17917a);
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.f17917a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f17917a.length);
        for (b bVar : this.f17917a) {
            parcel.writeParcelable(bVar, 0);
        }
    }
}
