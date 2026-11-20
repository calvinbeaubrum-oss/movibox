package com.transsion.transfer.androidasync.util;

import com.transsion.transfer.androidasync.ByteBufferList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58873b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58874c = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f58872a = ByteBufferList.f58477f;

    public ByteBuffer a() {
        return b(this.f58873b);
    }

    public ByteBuffer b(int i11) {
        return ByteBufferList.t(Math.min(Math.max(i11, this.f58874c), this.f58872a));
    }

    public int c() {
        return this.f58874c;
    }

    public a d(int i11) {
        this.f58874c = Math.max(0, i11);
        return this;
    }

    public void e(long j11) {
        this.f58873b = ((int) j11) * 2;
    }
}
