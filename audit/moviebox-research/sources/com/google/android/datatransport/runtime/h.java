package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cg.c f32645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f32646b;

    public h(@NonNull cg.c cVar, @NonNull byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f32645a = cVar;
        this.f32646b = bArr;
    }

    public byte[] a() {
        return this.f32646b;
    }

    public cg.c b() {
        return this.f32645a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f32645a.equals(hVar.f32645a)) {
            return Arrays.equals(this.f32646b, hVar.f32646b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f32645a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f32646b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f32645a + ", bytes=[...]}";
    }
}
