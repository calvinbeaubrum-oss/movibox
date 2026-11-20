package com.applovin.impl;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p8 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RandomAccessFile f21669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f21670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f21671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f21672h;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Throwable th2) {
            return (th2 instanceof ErrnoException) && ((ErrnoException) th2).errno == OsConstants.EACCES;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends j5 {
        public b(String str, Throwable th2, int i11) {
            super(str, th2, i11);
        }

        public b(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public p8() {
        super(false);
    }

    private static RandomAccessFile a(Uri uri) throws b {
        try {
            return new RandomAccessFile((String) b1.a((Object) uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new b(e11, (xp.f24372a < 21 || !a.b(e11.getCause())) ? 2005 : 2006);
            }
            throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
        } catch (SecurityException e12) {
            throw new b(e12, 2006);
        } catch (RuntimeException e13) {
            throw new b(e13, 2000);
        }
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws b {
        if (i12 == 0) {
            return 0;
        }
        if (this.f21671g == 0) {
            return -1;
        }
        try {
            int i13 = ((RandomAccessFile) xp.a((Object) this.f21669e)).read(bArr, i11, (int) Math.min(this.f21671g, i12));
            if (i13 > 0) {
                this.f21671g -= (long) i13;
                d(i13);
            }
            return i13;
        } catch (IOException e11) {
            throw new b(e11, 2000);
        }
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws b {
        Uri uri = l5Var.f20336a;
        this.f21670f = uri;
        b(l5Var);
        RandomAccessFile randomAccessFileA = a(uri);
        this.f21669e = randomAccessFileA;
        try {
            randomAccessFileA.seek(l5Var.f20342g);
            long length = l5Var.f20343h;
            if (length == -1) {
                length = this.f21669e.length() - l5Var.f20342g;
            }
            this.f21671g = length;
            if (length < 0) {
                throw new b(null, null, 2008);
            }
            this.f21672h = true;
            c(l5Var);
            return this.f21671g;
        } catch (IOException e11) {
            throw new b(e11, 2000);
        }
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f21670f;
    }

    @Override // com.applovin.impl.i5
    public void close() {
        this.f21670f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f21669e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f21669e = null;
                if (this.f21672h) {
                    this.f21672h = false;
                    g();
                }
            } catch (IOException e11) {
                throw new b(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f21669e = null;
            if (this.f21672h) {
                this.f21672h = false;
                g();
            }
            throw th2;
        }
    }
}
