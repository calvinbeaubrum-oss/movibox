package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class RawResourceDataSource extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Resources f35238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f35239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Uri f35240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f35241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public InputStream f35242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f35243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f35244k;

    /* JADX INFO: compiled from: source.java */
    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th2) {
            super(th2, 2000);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f35238e = context.getResources();
        this.f35239f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i11) {
        return Uri.parse("rawresource:///" + i11);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws RawResourceDataSourceException {
        int identifier;
        String str;
        Uri uri = nVar.f35422a;
        this.f35240g = uri;
        if (TextUtils.equals(com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String strSubstring = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
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
            identifier = this.f35238e.getIdentifier(sb2.toString(), "raw", this.f35239f);
            if (identifier == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, 2005);
            }
        }
        j(nVar);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f35238e.openRawResourceFd(identifier);
            this.f35241h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new RawResourceDataSourceException("Resource is compressed: " + uri, null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f35242i = fileInputStream;
            if (length != -1) {
                try {
                    if (nVar.f35428g > length) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                } catch (RawResourceDataSourceException e11) {
                    throw e11;
                } catch (IOException e12) {
                    throw new RawResourceDataSourceException(null, e12, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(nVar.f35428g + startOffset) - startOffset;
            if (jSkip != nVar.f35428g) {
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f35243j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f35243j = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                }
            } else {
                long j11 = length - jSkip;
                this.f35243j = j11;
                if (j11 < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long jMin = nVar.f35429h;
            if (jMin != -1) {
                long j12 = this.f35243j;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f35243j = jMin;
            }
            this.f35244k = true;
            k(nVar);
            long j13 = nVar.f35429h;
            return j13 != -1 ? j13 : this.f35243j;
        } catch (Resources.NotFoundException e13) {
            throw new RawResourceDataSourceException(null, e13, 2005);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // com.google.android.exoplayer2.upstream.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws RawResourceDataSourceException {
        this.f35240g = null;
        try {
            InputStream inputStream = this.f35242i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f35242i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f35241h;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f35241h = null;
                    if (this.f35244k) {
                        this.f35244k = false;
                        i();
                    }
                } catch (IOException e11) {
                    throw new RawResourceDataSourceException(null, e11, 2000);
                }
            } catch (Throwable th2) {
                this.f35241h = null;
                if (this.f35244k) {
                    this.f35244k = false;
                    i();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new RawResourceDataSourceException(null, e12, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35240g;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws RawResourceDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f35243j;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new RawResourceDataSourceException(null, e11, 2000);
            }
        }
        int i13 = ((InputStream) o0.j(this.f35242i)).read(bArr, i11, i12);
        if (i13 == -1) {
            if (this.f35243j == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j12 = this.f35243j;
        if (j12 != -1) {
            this.f35243j = j12 - ((long) i13);
        }
        h(i13);
        return i13;
    }
}
