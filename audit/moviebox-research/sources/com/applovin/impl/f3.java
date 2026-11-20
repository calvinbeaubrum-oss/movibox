package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f3 extends ya {
    public static final Parcelable.Creator<f3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18853d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f18854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ya[] f18855g;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f3 createFromParcel(Parcel parcel) {
            return new f3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f3[] newArray(int i11) {
            return new f3[i11];
        }
    }

    public f3(Parcel parcel) {
        super("CTOC");
        this.f18851b = (String) xp.a((Object) parcel.readString());
        this.f18852c = parcel.readByte() != 0;
        this.f18853d = parcel.readByte() != 0;
        this.f18854f = (String[]) xp.a((Object) parcel.createStringArray());
        int i11 = parcel.readInt();
        this.f18855g = new ya[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            this.f18855g[i12] = (ya) parcel.readParcelable(ya.class.getClassLoader());
        }
    }

    public f3(String str, boolean z11, boolean z12, String[] strArr, ya[] yaVarArr) {
        super("CTOC");
        this.f18851b = str;
        this.f18852c = z11;
        this.f18853d = z12;
        this.f18854f = strArr;
        this.f18855g = yaVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f3.class != obj.getClass()) {
            return false;
        }
        f3 f3Var = (f3) obj;
        return this.f18852c == f3Var.f18852c && this.f18853d == f3Var.f18853d && xp.a((Object) this.f18851b, (Object) f3Var.f18851b) && Arrays.equals(this.f18854f, f3Var.f18854f) && Arrays.equals(this.f18855g, f3Var.f18855g);
    }

    public int hashCode() {
        int i11 = ((((this.f18852c ? 1 : 0) + 527) * 31) + (this.f18853d ? 1 : 0)) * 31;
        String str = this.f18851b;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f18851b);
        parcel.writeByte(this.f18852c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18853d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f18854f);
        parcel.writeInt(this.f18855g.length);
        for (ya yaVar : this.f18855g) {
            parcel.writeParcelable(yaVar, 0);
        }
    }
}
