package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c4.g;
import c4.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class FileDataSource extends c4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public RandomAccessFile f9562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f9563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9565h;

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
    public static final class b implements androidx.media3.datasource.a.InterfaceC0090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public o f9566a;

        @Override // androidx.media3.datasource.a.InterfaceC0090a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            o oVar = this.f9566a;
            if (oVar != null) {
                fileDataSource.c(oVar);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile h(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) z3.a.e(uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e11, (u0.f81838a < 21 || !a.b(e11.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
        } catch (SecurityException e12) {
            throw new FileDataSourceException(e12, 2006);
        } catch (RuntimeException e13) {
            throw new FileDataSourceException(e13, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws FileDataSourceException {
        Uri uri = gVar.f14598a;
        this.f9563f = uri;
        f(gVar);
        RandomAccessFile randomAccessFileH = h(uri);
        this.f9562e = randomAccessFileH;
        try {
            randomAccessFileH.seek(gVar.f14604g);
            long length = gVar.f14605h;
            if (length == -1) {
                length = this.f9562e.length() - gVar.f14604g;
            }
            this.f9564g = length;
            if (length < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.f9565h = true;
            g(gVar);
            return this.f9564g;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() throws FileDataSourceException {
        this.f9563f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f9562e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f9562e = null;
                if (this.f9565h) {
                    this.f9565h = false;
                    e();
                }
            } catch (IOException e11) {
                throw new FileDataSourceException(e11, 2000);
            }
        } catch (Throwable th2) {
            this.f9562e = null;
            if (this.f9565h) {
                this.f9565h = false;
                e();
            }
            throw th2;
        }
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f9563f;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws FileDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.f9564g == 0) {
            return -1;
        }
        try {
            int i13 = ((RandomAccessFile) u0.i(this.f9562e)).read(bArr, i11, (int) Math.min(this.f9564g, i12));
            if (i13 > 0) {
                this.f9564g -= (long) i13;
                d(i13);
            }
            return i13;
        } catch (IOException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }
}
