package com.applovin.impl;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class li extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Resources f20467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Uri f20469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AssetFileDescriptor f20470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InputStream f20471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f20472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20473k;

    /* JADX INFO: compiled from: source.java */
    public static class a extends j5 {
        public a(String str, Throwable th2, int i11) {
            super(str, th2, i11);
        }
    }

    public li(Context context) {
        super(false);
        this.f20467e = context.getResources();
        this.f20468f = context.getPackageName();
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws a {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f20472j;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new a(null, e11, 2000);
            }
        }
        int i13 = ((InputStream) xp.a((Object) this.f20471i)).read(bArr, i11, i12);
        if (i13 == -1) {
            if (this.f20472j == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j12 = this.f20472j;
        if (j12 != -1) {
            this.f20472j = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws a {
        int identifier;
        String str;
        Uri uri = l5Var.f20336a;
        this.f20469g = uri;
        if (TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) b1.a((Object) uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) b1.a((Object) uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new a("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String strSubstring = (String) b1.a((Object) uri.getPath());
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb2.append(str);
            sb2.append(strSubstring);
            identifier = this.f20467e.getIdentifier(sb2.toString(), "raw", this.f20468f);
            if (identifier == 0) {
                throw new a("Resource not found.", null, 2005);
            }
        }
        b(l5Var);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f20467e.openRawResourceFd(identifier);
            this.f20470h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new a("Resource is compressed: " + uri, null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f20471i = fileInputStream;
            if (length != -1) {
                try {
                    if (l5Var.f20342g > length) {
                        throw new a(null, null, 2008);
                    }
                } catch (a e11) {
                    throw e11;
                } catch (IOException e12) {
                    throw new a(null, e12, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(l5Var.f20342g + startOffset) - startOffset;
            if (jSkip != l5Var.f20342g) {
                throw new a(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f20472j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f20472j = size;
                    if (size < 0) {
                        throw new a(null, null, 2008);
                    }
                }
            } else {
                long j11 = length - jSkip;
                this.f20472j = j11;
                if (j11 < 0) {
                    throw new j5(2008);
                }
            }
            long jMin = l5Var.f20343h;
            if (jMin != -1) {
                long j12 = this.f20472j;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f20472j = jMin;
            }
            this.f20473k = true;
            c(l5Var);
            long j13 = l5Var.f20343h;
            return j13 != -1 ? j13 : this.f20472j;
        } catch (Resources.NotFoundException e13) {
            throw new a(null, e13, 2005);
        }
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f20469g;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // com.applovin.impl.i5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() {
        this.f20469g = null;
        try {
            InputStream inputStream = this.f20471i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f20471i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f20470h;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f20470h = null;
                    if (this.f20473k) {
                        this.f20473k = false;
                        g();
                    }
                } catch (IOException e11) {
                    throw new a(null, e11, 2000);
                }
            } catch (Throwable th2) {
                this.f20470h = null;
                if (this.f20473k) {
                    this.f20473k = false;
                    g();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new a(null, e12, 2000);
        }
    }
}
