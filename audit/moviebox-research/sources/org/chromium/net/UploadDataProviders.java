package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class UploadDataProviders {
    private UploadDataProviders() {
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return b30.a.a(parcelFileDescriptor);
    }

    public static UploadDataProvider create(File file) {
        return b30.a.b(file);
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return b30.a.c(byteBuffer);
    }

    public static UploadDataProvider create(byte[] bArr) {
        return b30.a.d(bArr);
    }

    public static UploadDataProvider create(byte[] bArr, int i11, int i12) {
        return b30.a.e(bArr, i11, i12);
    }
}
