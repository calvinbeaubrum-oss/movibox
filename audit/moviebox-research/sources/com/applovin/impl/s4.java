package com.applovin.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s4 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f22237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f22238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f22239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileInputStream f22240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f22241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22242j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(Bundle bundle) {
            bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", b50.a().addSupportedVideoMimeType(MimeTypes.VIDEO_H265).addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends j5 {
        public b(IOException iOException, int i11) {
            super(iOException, i11);
        }
    }

    public s4(Context context) {
        super(false);
        this.f22237e = context.getContentResolver();
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws b {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f22241i;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new b(e11, 2000);
            }
        }
        int i13 = ((FileInputStream) xp.a((Object) this.f22240h)).read(bArr, i11, i12);
        if (i13 == -1) {
            return -1;
        }
        long j12 = this.f22241i;
        if (j12 != -1) {
            this.f22241i = j12 - ((long) i13);
        }
        d(i13);
        return i13;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws b {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = l5Var.f20336a;
            this.f22238f = uri;
            b(l5Var);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(l5Var.f20336a.getScheme())) {
                Bundle bundle = new Bundle();
                if (xp.f24372a >= 31) {
                    a.a(bundle);
                }
                assetFileDescriptorOpenAssetFileDescriptor = this.f22237e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f22237e.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            }
            this.f22239g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new b(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f22240h = fileInputStream;
            if (length != -1 && l5Var.f20342g > length) {
                throw new b(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(l5Var.f20342g + startOffset) - startOffset;
            if (jSkip != l5Var.f20342g) {
                throw new b(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f22241i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f22241i = jPosition;
                    if (jPosition < 0) {
                        throw new b(null, 2008);
                    }
                }
            } else {
                long j11 = length - jSkip;
                this.f22241i = j11;
                if (j11 < 0) {
                    throw new b(null, 2008);
                }
            }
            long jMin = l5Var.f20343h;
            if (jMin != -1) {
                long j12 = this.f22241i;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f22241i = jMin;
            }
            this.f22242j = true;
            c(l5Var);
            long j13 = l5Var.f20343h;
            return j13 != -1 ? j13 : this.f22241i;
        } catch (b e11) {
            throw e11;
        } catch (IOException e12) {
            throw new b(e12, e12 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f22238f;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // com.applovin.impl.i5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() {
        this.f22238f = null;
        try {
            FileInputStream fileInputStream = this.f22240h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f22240h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f22239g;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f22239g = null;
                    if (this.f22242j) {
                        this.f22242j = false;
                        g();
                    }
                } catch (IOException e11) {
                    throw new b(e11, 2000);
                }
            } catch (Throwable th2) {
                this.f22239g = null;
                if (this.f22242j) {
                    this.f22242j = false;
                    g();
                }
                throw th2;
            }
        } catch (IOException e12) {
            throw new b(e12, 2000);
        }
    }
}
