package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w7 implements bf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f24070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24071d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f24072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final f9 f24066h = new f9.b().f(MimeTypes.APPLICATION_ID3).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final f9 f24067i = new f9.b().f(MimeTypes.APPLICATION_SCTE35).a();
    public static final Parcelable.Creator<w7> CREATOR = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public w7 createFromParcel(Parcel parcel) {
            return new w7(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public w7[] newArray(int i11) {
            return new w7[i11];
        }
    }

    public w7(Parcel parcel) {
        this.f24068a = (String) xp.a((Object) parcel.readString());
        this.f24069b = (String) xp.a((Object) parcel.readString());
        this.f24070c = parcel.readLong();
        this.f24071d = parcel.readLong();
        this.f24072f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public w7(String str, String str2, long j11, long j12, byte[] bArr) {
        this.f24068a = str;
        this.f24069b = str2;
        this.f24070c = j11;
        this.f24071d = j12;
        this.f24072f = bArr;
    }

    @Override // com.applovin.impl.bf.b
    public /* synthetic */ void a(vd.b bVar) {
        jt.a(this, bVar);
    }

    @Override // com.applovin.impl.bf.b
    public byte[] a() {
        if (b() != null) {
            return this.f24072f;
        }
        return null;
    }

    @Override // com.applovin.impl.bf.b
    public f9 b() {
        String str = this.f24068a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f24067i;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f24066h;
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w7.class != obj.getClass()) {
            return false;
        }
        w7 w7Var = (w7) obj;
        return this.f24070c == w7Var.f24070c && this.f24071d == w7Var.f24071d && xp.a((Object) this.f24068a, (Object) w7Var.f24068a) && xp.a((Object) this.f24069b, (Object) w7Var.f24069b) && Arrays.equals(this.f24072f, w7Var.f24072f);
    }

    public int hashCode() {
        if (this.f24073g == 0) {
            String str = this.f24068a;
            int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.f24069b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j11 = this.f24070c;
            int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f24071d;
            this.f24073g = ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + Arrays.hashCode(this.f24072f);
        }
        return this.f24073g;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f24068a + ", id=" + this.f24071d + ", durationMs=" + this.f24070c + ", value=" + this.f24069b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24068a);
        parcel.writeString(this.f24069b);
        parcel.writeLong(this.f24070c);
        parcel.writeLong(this.f24071d);
        parcel.writeByteArray(this.f24072f);
    }
}
