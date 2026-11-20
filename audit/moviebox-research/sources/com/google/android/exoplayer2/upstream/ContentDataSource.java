package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ContentDataSource extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContentResolver f35218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f35219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f35220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public FileInputStream f35221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f35222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35223j;

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
        this.f35218e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = nVar.f35422a;
            this.f35219f = uri;
            j(nVar);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(nVar.f35422a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f35218e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f35218e.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            }
            this.f35220g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f35221h = fileInputStream;
            if (length != -1 && nVar.f35428g > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(nVar.f35428g + startOffset) - startOffset;
            if (jSkip != nVar.f35428g) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f35222i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f35222i = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j11 = length - jSkip;
                this.f35222i = j11;
                if (j11 < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long jMin = nVar.f35429h;
            if (jMin != -1) {
                long j12 = this.f35222i;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f35222i = jMin;
            }
            this.f35223j = true;
            k(nVar);
            long j13 = nVar.f35429h;
            return j13 != -1 ? j13 : this.f35222i;
        } catch (ContentDataSourceException e11) {
            throw e11;
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // com.google.android.exoplayer2.upstream.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws ContentDataSourceException {
        this.f35219f = null;
        try {
            FileInputStream fileInputStream = this.f35221h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f35221h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f35220g;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f35220g = null;
                    if (this.f35223j) {
                        this.f35223j = false;
                        i();
                    }
                } catch (IOException e11) {
                    throw new ContentDataSourceException(e11, 2000);
                }
            } catch (Throwable th2) {
                this.f35220g = null;
                if (this.f35223j) {
                    this.f35223j = false;
                    i();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new ContentDataSourceException(e12, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35219f;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws ContentDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f35222i;
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
        int i13 = ((FileInputStream) o0.j(this.f35221h)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f35222i;
        if (j12 != -1) {
            this.f35222i = j12 - ((long) i13);
        }
        h(i13);
        return i13;
    }
}
