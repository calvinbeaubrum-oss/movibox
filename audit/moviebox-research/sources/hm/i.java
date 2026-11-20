package hm;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f66521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f66522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Charset f66523c;

    public i() {
        this.f66523c = StandardCharsets.ISO_8859_1;
        this.f66521a = new StringBuilder();
    }

    public i(int i11) {
        this.f66523c = StandardCharsets.ISO_8859_1;
        this.f66521a = new StringBuilder(i11);
    }

    public void a(byte b11) {
        this.f66521a.append((char) (b11 & 255));
    }

    public void b(char c11) {
        this.f66521a.append((char) (c11 & 255));
    }

    public void c(int i11) {
        d(String.valueOf(i11));
    }

    public void d(String str) {
        this.f66521a.append(str);
    }

    public void e(StringBuilder sb2) {
        g();
        this.f66522b.append((CharSequence) sb2);
    }

    public void f(int i11) throws FormatException {
        g();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i11);
        if (characterSetECIByValue == null) {
            throw FormatException.getFormatInstance();
        }
        this.f66523c = characterSetECIByValue.getCharset();
    }

    public final void g() {
        Charset charset = this.f66523c;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (this.f66521a.length() > 0) {
                StringBuilder sb2 = this.f66522b;
                if (sb2 == null) {
                    this.f66522b = this.f66521a;
                    this.f66521a = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.f66521a);
                    this.f66521a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f66521a.length() > 0) {
            byte[] bytes = this.f66521a.toString().getBytes(charset2);
            this.f66521a = new StringBuilder();
            StringBuilder sb3 = this.f66522b;
            if (sb3 == null) {
                this.f66522b = new StringBuilder(new String(bytes, this.f66523c));
            } else {
                sb3.append(new String(bytes, this.f66523c));
            }
        }
    }

    public boolean h() {
        StringBuilder sb2;
        return this.f66521a.length() == 0 && ((sb2 = this.f66522b) == null || sb2.length() == 0);
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb2 = this.f66522b;
        return sb2 == null ? "" : sb2.toString();
    }
}
