package com.transsion.http.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class BitmapCallback extends r {
    public final Bitmap D(byte[] bArr) {
        return BitmapFactory.decodeStream(bu.a.f(ByteBuffer.wrap(bArr)));
    }

    public abstract void E(int i11, Bitmap bitmap, Throwable th2);

    public abstract void F(int i11, Bitmap bitmap);

    @Override // com.transsion.http.impl.r
    public void o(int i11, byte[] bArr, Throwable th2) {
        j(new c(this, i11, th2));
    }

    @Override // com.transsion.http.impl.r
    public void v(int i11, byte[] bArr) {
        b bVar = new b(this, bArr, i11);
        if (m() || l()) {
            bVar.run();
        } else {
            new Thread(bVar).start();
        }
    }
}
