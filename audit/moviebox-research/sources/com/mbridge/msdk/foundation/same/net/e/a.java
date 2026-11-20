package com.mbridge.msdk.foundation.same.net.e;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends i<Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f44579c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f44580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f44581e;

    public a(File file, String str) {
        super(0, str);
        this.f44580d = file;
        this.f44581e = new File(file + ".tmp");
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<Void> a(com.mbridge.msdk.foundation.same.net.f.c cVar) {
        if (q()) {
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(-2, cVar));
        }
        if (!this.f44581e.canRead() || this.f44581e.length() <= 0) {
            ad.c(f44579c, "Download temporary file was invalid!");
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(4, cVar));
        }
        if (this.f44581e.renameTo(this.f44580d)) {
            return k.a(null, cVar);
        }
        ad.c(f44579c, "Can't rename the download temporary file!");
        return k.a(new com.mbridge.msdk.foundation.same.net.b.a(4, cVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final byte[] a(com.mbridge.msdk.foundation.same.net.f.b bVar, com.mbridge.msdk.foundation.same.net.c cVar) throws Throwable {
        String strA = com.mbridge.msdk.foundation.same.net.g.b.a(bVar.b(), HttpHeaders.CONTENT_LENGTH);
        long j11 = 0;
        long jLongValue = !TextUtils.isEmpty(strA) ? Long.valueOf(strA).longValue() : 0L;
        if (jLongValue <= 0) {
            ad.c(f44579c, "Response doesn't present Content-Length!");
        }
        InputStream inputStream = null;
        if (jLongValue > 0 && this.f44580d.length() == jLongValue) {
            this.f44580d.renameTo(this.f44581e);
            cVar.a(this, jLongValue, jLongValue);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f44581e.getAbsolutePath(), "rw");
        randomAccessFile.setLength(0L);
        try {
            InputStream inputStreamA = bVar.a();
            try {
                InputStream gZIPInputStream = (!com.mbridge.msdk.foundation.same.net.g.b.b(bVar.b()) || (inputStreamA instanceof GZIPInputStream)) ? inputStreamA : new GZIPInputStream(inputStreamA);
                try {
                    byte[] bArr = new byte[6144];
                    while (true) {
                        int i11 = gZIPInputStream.read(bArr);
                        if (i11 == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, i11);
                        long j12 = j11 + ((long) i11);
                        cVar.a(this, jLongValue, j12);
                        if (q()) {
                            cVar.a(this);
                            break;
                        }
                        j11 = j12;
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused) {
                        ad.b(f44579c, "Error occured when calling InputStream.close");
                    }
                    randomAccessFile.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = gZIPInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                            ad.b(f44579c, "Error occured when calling InputStream.close");
                        }
                    }
                    randomAccessFile.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamA;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final int b() {
        return 1;
    }
}
