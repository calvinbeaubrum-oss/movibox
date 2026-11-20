package com.cloud.hisavana.net.disklrucache.impl;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.disklrucache.DiskLruCache;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.disklrucache.utils.SafeKeyUtils;
import com.cloud.sdk.commonutil.util.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.Response;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DiskCacheImpl implements IDiskCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiskLruCache f29001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f29002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f29003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29004d;

    public DiskCacheImpl(File file, long j11, int i11) {
        this.f29002b = file;
        this.f29003c = j11;
        this.f29004d = i11;
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public void a(ImageCacheURL imageCacheURL) {
        try {
            g().Z(SafeKeyUtils.b(imageCacheURL));
        } catch (Exception unused) {
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String b(ImageCacheURL imageCacheURL, byte[] bArr) {
        String strE = "";
        String strB = SafeKeyUtils.b(imageCacheURL);
        OutputStream outputStreamG = null;
        try {
            try {
                if (g().q(strB) != null) {
                    DiskLruCacheUtil.b(null);
                    return null;
                }
                DiskLruCache.Editor editorO = this.f29001a.o(strB);
                if (editorO == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                }
                try {
                    outputStreamG = editorO.g(0);
                    outputStreamG.write(bArr);
                    outputStreamG.flush();
                    editorO.f();
                    this.f29001a.flush();
                    strE = DiskLruCacheUtil.e(imageCacheURL.c(), this.f29004d);
                    if (Log.isLoggable("ADSDK", 3)) {
                        c.netLog("url :" + imageCacheURL.c() + " cacheToDisk with buff: " + strE);
                    }
                    editorO.b();
                    DiskLruCacheUtil.b(outputStreamG);
                    return strE;
                } catch (Throwable th2) {
                    editorO.b();
                    throw th2;
                }
            } catch (IOException unused) {
                c.netLog("put: fail");
            }
        } catch (Throwable th3) {
            DiskLruCacheUtil.b(null);
            throw th3;
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public File c(ImageCacheURL imageCacheURL) {
        return h(imageCacheURL);
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String d(ImageCacheURL imageCacheURL, Response response) {
        return (response == null || response.body() == null) ? "" : e(imageCacheURL, response.body().byteStream());
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String e(ImageCacheURL imageCacheURL, InputStream inputStream) {
        String strE = "";
        if (imageCacheURL == null || inputStream == null) {
            return "";
        }
        String strB = SafeKeyUtils.b(imageCacheURL);
        OutputStream outputStreamG = null;
        try {
            try {
                if (g().q(strB) != null) {
                    DiskLruCacheUtil.b(null);
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                DiskLruCache.Editor editorO = this.f29001a.o(strB);
                if (editorO == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                }
                try {
                    outputStreamG = editorO.g(0);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i11 = inputStream.read(bArr);
                        if (i11 == -1) {
                            break;
                        }
                        outputStreamG.write(bArr, 0, i11);
                    }
                    outputStreamG.flush();
                    editorO.f();
                    this.f29001a.flush();
                    strE = DiskLruCacheUtil.e(imageCacheURL.c(), this.f29004d);
                    if (Log.isLoggable("ADSDK", 3)) {
                        c.netLog("url :" + imageCacheURL.c() + " cacheToDisk with response: " + strE);
                    }
                    editorO.b();
                    DiskLruCacheUtil.b(outputStreamG);
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                    return strE;
                } catch (Throwable th2) {
                    editorO.b();
                    throw th2;
                }
            } catch (Throwable th3) {
                DiskLruCacheUtil.b(null);
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th3;
            }
        } catch (Exception unused4) {
            c.netLog("put: fail");
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public boolean f(String str) {
        try {
            return g().q(SafeKeyUtils.b(new ImageCacheURL(str))) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final DiskLruCache g() throws IOException {
        DiskLruCache diskLruCacheU = this.f29001a;
        if (diskLruCacheU == null) {
            synchronized (DiskCacheImpl.class) {
                try {
                    diskLruCacheU = this.f29001a;
                    if (diskLruCacheU == null) {
                        File fileD = DiskLruCacheUtil.d(this.f29004d);
                        if (Log.isLoggable("ADSDK", 3)) {
                            c.netLog(" ----- getDiskLruCache: directory = " + this.f29002b + " , cacheFile = " + fileD);
                        }
                        File file = this.f29002b;
                        if (file != null) {
                            fileD = file;
                        }
                        this.f29002b = fileD;
                        diskLruCacheU = DiskLruCache.u(fileD, 1, 1, this.f29003c);
                        this.f29001a = diskLruCacheU;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return diskLruCacheU;
    }

    public File h(ImageCacheURL imageCacheURL) {
        File fileD;
        if (TextUtils.isEmpty(imageCacheURL.c()) || (fileD = DiskLruCacheUtil.d(this.f29004d)) == null) {
            return null;
        }
        String str = SafeKeyUtils.b(imageCacheURL) + ".0";
        try {
            g().q(str);
        } catch (Exception unused) {
        }
        return new File(fileD + File.separator + str);
    }
}
