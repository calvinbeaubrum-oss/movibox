package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class n implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final File f40226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f40227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final String f40228c;

    public n(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f40227b = str;
        this.f40228c = str2;
        this.f40226a = file;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    private byte[] c() {
        byte[] bArr = new byte[8192];
        try {
            InputStream stream = getStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (stream == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (stream != null) {
                            stream.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int i11 = stream.read(bArr);
                            if (i11 <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                stream.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, i11);
                        } catch (Throwable th2) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    byteArrayOutputStream.close();
                    throw th5;
                }
            } catch (Throwable th6) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th7) {
                        th6.addSuppressed(th7);
                    }
                }
                throw th6;
            }
            if (stream != null) {
                stream.close();
            }
            throw th6;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @Nullable
    public CrashlyticsReport.d.b a() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return CrashlyticsReport.d.b.a().b(bArrC).c(this.f40227b).a();
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @NonNull
    public String b() {
        return this.f40228c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @Nullable
    public InputStream getStream() {
        if (this.f40226a.exists() && this.f40226a.isFile()) {
            try {
                return new FileInputStream(this.f40226a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
