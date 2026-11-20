package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AssetDataSource extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AssetManager f35213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f35214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public InputStream f35215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f35217i;

    /* JADX INFO: compiled from: source.java */
    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f35213e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws AssetDataSourceException {
        try {
            Uri uri = nVar.f35422a;
            this.f35214f = uri;
            String strSubstring = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            j(nVar);
            InputStream inputStreamOpen = this.f35213e.open(strSubstring, 1);
            this.f35215g = inputStreamOpen;
            if (inputStreamOpen.skip(nVar.f35428g) < nVar.f35428g) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j11 = nVar.f35429h;
            if (j11 != -1) {
                this.f35216h = j11;
            } else {
                long jAvailable = this.f35215g.available();
                this.f35216h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f35216h = -1L;
                }
            }
            this.f35217i = true;
            k(nVar);
            return this.f35216h;
        } catch (AssetDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new AssetDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws AssetDataSourceException {
        this.f35214f = null;
        try {
            try {
                InputStream inputStream = this.f35215g;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f35215g = null;
                if (this.f35217i) {
                    this.f35217i = false;
                    i();
                }
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f35215g = null;
            if (this.f35217i) {
                this.f35217i = false;
                i();
            }
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35214f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws AssetDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f35216h;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        }
        int i13 = ((InputStream) o0.j(this.f35215g)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f35216h;
        if (j12 != -1) {
            this.f35216h = j12 - ((long) i13);
        }
        h(i13);
        return i13;
    }
}
