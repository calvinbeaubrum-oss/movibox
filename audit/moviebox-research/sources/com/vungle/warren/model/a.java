package com.vungle.warren.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f62125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f62126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f62128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f62129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f62131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f62132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f62133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f62134j;

    public a(@NonNull String str, @Nullable String str2, @NonNull String str3) {
        this(str, str2, str3, UUID.randomUUID().toString());
    }

    public a(@NonNull String str, @Nullable String str2, @NonNull String str3, String str4) {
        this.f62125a = str4;
        this.f62126b = str;
        this.f62128d = str2;
        this.f62129e = str3;
        this.f62132h = -1L;
        this.f62133i = 0;
        this.f62134j = 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f62130f != aVar.f62130f || this.f62131g != aVar.f62131g || this.f62132h != aVar.f62132h || this.f62133i != aVar.f62133i || this.f62134j != aVar.f62134j) {
            return false;
        }
        String str = this.f62125a;
        if (str == null ? aVar.f62125a != null : !str.equals(aVar.f62125a)) {
            return false;
        }
        String str2 = this.f62126b;
        if (str2 == null ? aVar.f62126b != null : !str2.equals(aVar.f62126b)) {
            return false;
        }
        String str3 = this.f62127c;
        if (str3 == null ? aVar.f62127c != null : !str3.equals(aVar.f62127c)) {
            return false;
        }
        String str4 = this.f62128d;
        if (str4 == null ? aVar.f62128d != null : !str4.equals(aVar.f62128d)) {
            return false;
        }
        String str5 = this.f62129e;
        String str6 = aVar.f62129e;
        if (str5 != null) {
            return str5.equals(str6);
        }
        return str6 == null;
    }

    public int hashCode() {
        String str = this.f62125a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f62126b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f62127c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f62128d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f62129e;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f62130f) * 31) + this.f62131g) * 31;
        long j11 = this.f62132h;
        return ((((iHashCode5 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f62133i) * 31) + this.f62134j;
    }

    public String toString() {
        return "AdAsset{identifier='" + this.f62125a + "', adIdentifier='" + this.f62126b + "', serverPath='" + this.f62128d + "', localPath='" + this.f62129e + "', status=" + this.f62130f + ", fileType=" + this.f62131g + ", fileSize=" + this.f62132h + ", retryCount=" + this.f62133i + ", retryTypeError=" + this.f62134j + '}';
    }
}
