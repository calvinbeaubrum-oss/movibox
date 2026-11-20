package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import c4.g;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ContentDataSource extends c4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContentResolver f9556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f9557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f9558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public FileInputStream f9559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9561j;

    /* JADX INFO: compiled from: source.java */
    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i11) {
            super(iOException, i11);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f9556e = context.getContentResolver();
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uriNormalizeScheme = gVar.f14598a.normalizeScheme();
            this.f9557f = uriNormalizeScheme;
            f(gVar);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(uriNormalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f9556e.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f9556e.openAssetFileDescriptor(uriNormalizeScheme, CampaignEx.JSON_KEY_AD_R);
            }
            this.f9558g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f9559h = fileInputStream;
            if (length != -1 && gVar.f14604g > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(gVar.f14604g + startOffset) - startOffset;
            if (jSkip != gVar.f14604g) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f9560i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f9560i = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j11 = length - jSkip;
                this.f9560i = j11;
                if (j11 < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long jMin = gVar.f14605h;
            if (jMin != -1) {
                long j12 = this.f9560i;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f9560i = jMin;
            }
            this.f9561j = true;
            g(gVar);
            long j13 = gVar.f14605h;
            return j13 != -1 ? j13 : this.f9560i;
        } catch (ContentDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // androidx.media3.datasource.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws ContentDataSourceException {
        this.f9557f = null;
        try {
            FileInputStream fileInputStream = this.f9559h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f9559h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f9558g;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f9558g = null;
                    if (this.f9561j) {
                        this.f9561j = false;
                        e();
                    }
                } catch (IOException e11) {
                    throw new ContentDataSourceException(e11, 2000);
                }
            } catch (Throwable th2) {
                this.f9558g = null;
                if (this.f9561j) {
                    this.f9561j = false;
                    e();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, 2000);
        }
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f9557f;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws ContentDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f9560i;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11, 2000);
            }
        }
        int i13 = ((FileInputStream) u0.i(this.f9559h)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f9560i;
        if (j12 != -1) {
            this.f9560i = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }
}
