package com.apm.insight.l;

import androidx.annotation.NonNull;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageDigest f16940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Charset f16941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f16942c;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public boolean a(String str) {
            return true;
        }
    }

    public e(@NonNull OutputStream outputStream, MessageDigest messageDigest, a aVar) {
        super(outputStream);
        this.f16941b = null;
        this.f16940a = messageDigest;
        this.f16942c = aVar;
        if (messageDigest != null) {
            this.f16941b = Charset.defaultCharset();
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int i11) {
        super.write(i11);
        MessageDigest messageDigest = this.f16940a;
        if (messageDigest != null) {
            messageDigest.update((byte) i11);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(@NonNull String str, int i11, int i12) {
        super.write(str, i11, i12);
        if (this.f16940a != null) {
            a aVar = this.f16942c;
            if (aVar == null || aVar.a(str)) {
                this.f16940a.update(this.f16941b.encode(CharBuffer.wrap(str, i11, i12 + i11)).array());
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(@NonNull char[] cArr, int i11, int i12) {
        super.write(cArr, i11, i12);
        MessageDigest messageDigest = this.f16940a;
        if (messageDigest != null) {
            messageDigest.update(this.f16941b.encode(CharBuffer.wrap(cArr)).array());
        }
    }
}
