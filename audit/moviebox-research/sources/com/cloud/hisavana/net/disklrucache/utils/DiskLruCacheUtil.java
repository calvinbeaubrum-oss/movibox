package com.cloud.hisavana.net.disklrucache.utils;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.DiskCacheProvider;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.f;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheUtil {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IDiskCache f29012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IDiskCache f29013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IDiskCache f29014e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f29010a = StandardCharsets.US_ASCII;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f29011b = StandardCharsets.UTF_8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f29015f = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char[] f29016g = new char[64];

    private DiskLruCacheUtil() {
    }

    public static String a(byte[] bArr, char[] cArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            int i12 = i11 * 2;
            char[] cArr2 = f29015f;
            cArr[i12] = cArr2[(b11 & 255) >>> 4];
            cArr[i12 + 1] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                c.netLog("closeQuietly --> " + Log.getStackTraceString(e11));
            }
        }
    }

    public static void c(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                c(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public static File d(int i11) {
        if (i11 != 3) {
            return i11 != 4 ? StorageUtils.a(f.a()) : StorageUtils.c(f.a(), true);
        }
        return StorageUtils.f(f.a(), true);
    }

    public static String e(String str, int i11) {
        File fileD;
        if (TextUtils.isEmpty(str) || (fileD = d(i11)) == null) {
            return "";
        }
        return fileD + File.separator + (SafeKeyUtils.b(new ImageCacheURL(str)) + ".0");
    }

    public static IDiskCache f() {
        if (f29014e == null) {
            HttpRequest httpRequest = HttpRequest.f28935a;
            f29014e = new DiskCacheProvider().b(httpRequest.f() <= 0 ? 209715200L : ((long) (httpRequest.f() * 1024)) * 1024, 4);
        }
        return f29014e;
    }

    public static IDiskCache g(int i11) {
        if (i11 != 3) {
            return i11 != 4 ? h() : f();
        }
        return i();
    }

    public static IDiskCache h() {
        if (f29012c == null) {
            HttpRequest httpRequest = HttpRequest.f28935a;
            f29012c = new DiskCacheProvider().b(httpRequest.e() <= 0 ? 314572800L : ((long) (httpRequest.e() * 1024)) * 1024, 1);
        }
        return f29012c;
    }

    public static IDiskCache i() {
        if (f29013d == null) {
            HttpRequest httpRequest = HttpRequest.f28935a;
            f29013d = new DiskCacheProvider().b(httpRequest.i() <= 0 ? 104857600L : ((long) (httpRequest.i() * 1024)) * 1024, 3);
        }
        return f29013d;
    }

    public static String j(byte[] bArr) {
        String strA;
        char[] cArr = f29016g;
        synchronized (cArr) {
            strA = a(bArr, cArr);
        }
        return strA;
    }
}
