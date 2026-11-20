package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c4.g;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class RawResourceDataSource extends c4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f9569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public g f9570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f9571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public InputStream f9572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9574j;

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
        this.f9569e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i11) {
        return Uri.parse("rawresource:///" + i11);
    }

    public static AssetFileDescriptor h(Context context, g gVar) throws RawResourceDataSourceException {
        Resources resources;
        int identifier;
        Uri uriNormalizeScheme = gVar.f14598a.normalizeScheme();
        if (TextUtils.equals(com.mbridge.msdk.playercommon.exoplayer2.upstream.RawResourceDataSource.RAW_RESOURCE_SCHEME, uriNormalizeScheme.getScheme()) || (TextUtils.equals("android.resource", uriNormalizeScheme.getScheme()) && uriNormalizeScheme.getPathSegments().size() == 1 && ((String) z3.a.e(uriNormalizeScheme.getLastPathSegment())).matches("\\d+"))) {
            resources = context.getResources();
            try {
                identifier = Integer.parseInt((String) z3.a.e(uriNormalizeScheme.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new RawResourceDataSourceException("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String strSubstring = (String) z3.a.e(uriNormalizeScheme.getPath());
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resources = context.getResources();
            } else {
                try {
                    resources = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e11) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e11, 2005);
                }
            }
            identifier = resources.getIdentifier(packageName + ":" + strSubstring, "raw", null);
            if (identifier == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, 2005);
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + uriNormalizeScheme, null, 2000);
        } catch (Resources.NotFoundException e12) {
            throw new RawResourceDataSourceException(null, e12, 2005);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws RawResourceDataSourceException {
        this.f9570f = gVar;
        f(gVar);
        AssetFileDescriptor assetFileDescriptorH = h(this.f9569e, gVar);
        this.f9571g = assetFileDescriptorH;
        long length = assetFileDescriptorH.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f9571g.getFileDescriptor());
        this.f9572h = fileInputStream;
        if (length != -1) {
            try {
                if (gVar.f14604g > length) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
            } catch (RawResourceDataSourceException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RawResourceDataSourceException(null, e12, 2000);
            }
        }
        long startOffset = this.f9571g.getStartOffset();
        long jSkip = fileInputStream.skip(gVar.f14604g + startOffset) - startOffset;
        if (jSkip != gVar.f14604g) {
            throw new RawResourceDataSourceException(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.f9573i = -1L;
            } else {
                long size = channel.size() - channel.position();
                this.f9573i = size;
                if (size < 0) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
            }
        } else {
            long j11 = length - jSkip;
            this.f9573i = j11;
            if (j11 < 0) {
                throw new DataSourceException(2008);
            }
        }
        long jMin = gVar.f14605h;
        if (jMin != -1) {
            long j12 = this.f9573i;
            if (j12 != -1) {
                jMin = Math.min(j12, jMin);
            }
            this.f9573i = jMin;
        }
        this.f9574j = true;
        g(gVar);
        long j13 = gVar.f14605h;
        return j13 != -1 ? j13 : this.f9573i;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // androidx.media3.datasource.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws RawResourceDataSourceException {
        this.f9570f = null;
        try {
            InputStream inputStream = this.f9572h;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f9572h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f9571g;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f9571g = null;
                    if (this.f9574j) {
                        this.f9574j = false;
                        e();
                    }
                } catch (IOException e11) {
                    throw new RawResourceDataSourceException(null, e11, 2000);
                }
            } catch (Throwable th2) {
                this.f9571g = null;
                if (this.f9574j) {
                    this.f9574j = false;
                    e();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new RawResourceDataSourceException(null, e12, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        g gVar = this.f9570f;
        if (gVar != null) {
            return gVar.f14598a;
        }
        return null;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws RawResourceDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f9573i;
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
        int i13 = ((InputStream) u0.i(this.f9572h)).read(bArr, i11, i12);
        if (i13 == -1) {
            if (this.f9573i == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j12 = this.f9573i;
        if (j12 != -1) {
            this.f9573i = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }
}
