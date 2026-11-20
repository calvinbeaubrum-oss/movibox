package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class FileDataSource extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public RandomAccessFile f35224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f35225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f35227h;

    /* JADX INFO: compiled from: source.java */
    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
            super(str, th2, i11);
        }

        public FileDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(@Nullable Throwable th2) {
            return (th2 instanceof ErrnoException) && ((ErrnoException) th2).errno == OsConstants.EACCES;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public k0 f35228a;

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            k0 k0Var = this.f35228a;
            if (k0Var != null) {
                fileDataSource.e(k0Var);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile l(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) com.google.android.exoplayer2.util.a.e(uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e11, (o0.f35608a < 21 || !a.b(e11.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
        } catch (SecurityException e12) {
            throw new FileDataSourceException(e12, 2006);
        } catch (RuntimeException e13) {
            throw new FileDataSourceException(e13, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws FileDataSourceException {
        Uri uri = nVar.f35422a;
        this.f35225f = uri;
        j(nVar);
        RandomAccessFile randomAccessFileL = l(uri);
        this.f35224e = randomAccessFileL;
        try {
            randomAccessFileL.seek(nVar.f35428g);
            long length = nVar.f35429h;
            if (length == -1) {
                length = this.f35224e.length() - nVar.f35428g;
            }
            this.f35226g = length;
            if (length < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.f35227h = true;
            k(nVar);
            return this.f35226g;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws FileDataSourceException {
        this.f35225f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f35224e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f35224e = null;
                if (this.f35227h) {
                    this.f35227h = false;
                    i();
                }
            } catch (IOException e11) {
                throw new FileDataSourceException(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f35224e = null;
            if (this.f35227h) {
                this.f35227h = false;
                i();
            }
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35225f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws FileDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.f35226g == 0) {
            return -1;
        }
        try {
            int i13 = ((RandomAccessFile) o0.j(this.f35224e)).read(bArr, i11, (int) Math.min(this.f35226g, i12));
            if (i13 > 0) {
                this.f35226g -= (long) i13;
                h(i13);
            }
            return i13;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }
}
