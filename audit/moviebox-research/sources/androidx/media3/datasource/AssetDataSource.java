package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import c4.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class AssetDataSource extends c4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AssetManager f9551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f9552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public InputStream f9553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9555i;

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
        this.f9551e = context.getAssets();
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws AssetDataSourceException {
        try {
            Uri uri = gVar.f14598a;
            this.f9552f = uri;
            String strSubstring = (String) z3.a.e(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            f(gVar);
            InputStream inputStreamOpen = this.f9551e.open(strSubstring, 1);
            this.f9553g = inputStreamOpen;
            if (inputStreamOpen.skip(gVar.f14604g) < gVar.f14604g) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j11 = gVar.f14605h;
            if (j11 != -1) {
                this.f9554h = j11;
            } else {
                long jAvailable = this.f9553g.available();
                this.f9554h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f9554h = -1L;
                }
            }
            this.f9555i = true;
            g(gVar);
            return this.f9554h;
        } catch (AssetDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new AssetDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() throws AssetDataSourceException {
        this.f9552f = null;
        try {
            try {
                InputStream inputStream = this.f9553g;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f9553g = null;
                if (this.f9555i) {
                    this.f9555i = false;
                    e();
                }
            } catch (IOException e11) {
                throw new AssetDataSourceException(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f9553g = null;
            if (this.f9555i) {
                this.f9555i = false;
                e();
            }
            throw th2;
        }
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f9552f;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws AssetDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f9554h;
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
        int i13 = ((InputStream) u0.i(this.f9553g)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f9554h;
        if (j12 != -1) {
            this.f9554h = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }
}
