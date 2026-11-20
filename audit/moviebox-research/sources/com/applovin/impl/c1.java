package com.applovin.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssetManager f18074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f18075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputStream f18076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18078i;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends j5 {
        public a(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public c1(Context context) {
        super(false);
        this.f18074e = context.getAssets();
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws a {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f18077h;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new a(e11, 2000);
            }
        }
        int i13 = ((InputStream) xp.a((Object) this.f18076g)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f18077h;
        if (j12 != -1) {
            this.f18077h = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws a {
        try {
            Uri uri = l5Var.f20336a;
            this.f18075f = uri;
            String strSubstring = (String) b1.a((Object) uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            b(l5Var);
            InputStream inputStreamOpen = this.f18074e.open(strSubstring, 1);
            this.f18076g = inputStreamOpen;
            if (inputStreamOpen.skip(l5Var.f20342g) < l5Var.f20342g) {
                throw new a(null, 2008);
            }
            long j11 = l5Var.f20343h;
            if (j11 != -1) {
                this.f18077h = j11;
            } else {
                long jAvailable = this.f18076g.available();
                this.f18077h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f18077h = -1L;
                }
            }
            this.f18078i = true;
            c(l5Var);
            return this.f18077h;
        } catch (a e11) {
            throw e11;
        } catch (IOException e12) {
            throw new a(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f18075f;
    }

    @Override // com.applovin.impl.i5
    public void close() {
        this.f18075f = null;
        try {
            try {
                InputStream inputStream = this.f18076g;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f18076g = null;
                if (this.f18078i) {
                    this.f18078i = false;
                    g();
                }
            } catch (IOException e11) {
                throw new a(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f18076g = null;
            if (this.f18078i) {
                this.f18078i = false;
                g();
            }
            throw th2;
        }
    }
}
