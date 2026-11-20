package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class s {
    public static void a(@Nullable InputStream inputStream, @NonNull File file) throws Throwable {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i11 = inputStream.read(bArr);
                    if (i11 <= 0) {
                        gZIPOutputStream2.finish();
                        CommonUtils.f(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i11);
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.f(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void b(File file, List<r> list) {
        for (r rVar : list) {
            InputStream stream = null;
            try {
                stream = rVar.getStream();
                if (stream != null) {
                    a(stream, new File(file, rVar.b()));
                }
            } catch (IOException unused) {
            } finally {
                CommonUtils.f(null);
            }
        }
    }
}
