package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final byte[] f40190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f40191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final String f40192c;

    public d(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f40191b = str;
        this.f40192c = str2;
        this.f40190a = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @Nullable
    public CrashlyticsReport.d.b a() {
        byte[] bArrC = c();
        if (bArrC == null) {
            return null;
        }
        return CrashlyticsReport.d.b.a().b(bArrC).c(this.f40191b).a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @NonNull
    public String b() {
        return this.f40192c;
    }

    @Nullable
    public final byte[] c() {
        if (d()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f40190a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th2) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean d() {
        byte[] bArr = this.f40190a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.common.r
    @Nullable
    public InputStream getStream() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f40190a);
    }
}
