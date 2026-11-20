package t30;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f76852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f76855d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f76856f;

    public s() {
        this.f76854c = 0;
        this.f76853b = 15;
        this.f76852a = new char[15];
    }

    public s(String str) {
        this.f76854c = 0;
        char[] charArray = str.toCharArray();
        this.f76852a = charArray;
        int length = charArray.length;
        this.f76854c = length;
        this.f76853b = length;
    }

    public s a(char c11) {
        int i11 = this.f76854c;
        if (i11 >= this.f76853b) {
            f(i11);
        }
        char[] cArr = this.f76852a;
        int i12 = this.f76854c;
        this.f76854c = i12 + 1;
        cArr[i12] = c11;
        return this;
    }

    public s b(CharSequence charSequence) {
        if (charSequence.length() > this.f76853b - this.f76854c) {
            f(charSequence.length());
        }
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            this.f76852a[this.f76854c] = charSequence.charAt(i11);
            this.f76854c++;
        }
        return this;
    }

    public s c(Object obj) {
        return d(String.valueOf(obj));
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f76852a[i11];
    }

    public s d(String str) {
        if (str == null) {
            return this;
        }
        int length = str.length();
        if (length > this.f76853b - this.f76854c) {
            f(length);
        }
        str.getChars(0, length, this.f76852a, this.f76854c);
        this.f76854c += length;
        return this;
    }

    public s e(char[] cArr, int i11, int i12) {
        if (i12 > this.f76853b - this.f76854c) {
            f(i12);
        }
        int i13 = i12 + i11;
        while (i11 < i13) {
            char[] cArr2 = this.f76852a;
            int i14 = this.f76854c;
            this.f76854c = i14 + 1;
            cArr2[i14] = cArr[i11];
            i11++;
        }
        return this;
    }

    public final void f(int i11) {
        if (this.f76853b == 0) {
            this.f76853b = 15;
        }
        int i12 = this.f76853b + (i11 * 2);
        this.f76853b = i12;
        char[] cArr = new char[i12];
        System.arraycopy(this.f76852a, 0, cArr, 0, this.f76854c);
        this.f76852a = cArr;
    }

    public CharSequence g(int i11, int i12) {
        return new String(this.f76852a, i11, i12 - i11);
    }

    public char[] h() {
        String str;
        if (this.f76855d == null) {
            int i11 = this.f76854c;
            char[] cArr = new char[i11];
            System.arraycopy(this.f76852a, 0, cArr, 0, i11);
            return cArr;
        }
        if (this.f76856f == null) {
            this.f76856f = System.getProperty("file.encoding");
        }
        try {
            str = new String(this.f76855d, this.f76856f);
        } catch (UnsupportedEncodingException unused) {
            str = new String(this.f76855d);
        }
        return str.toCharArray();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f76854c;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i11, int i12) {
        return g(i11, i12);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.f76855d == null) {
            int i11 = this.f76854c;
            return i11 == this.f76853b ? new String(this.f76852a) : new String(this.f76852a, 0, i11);
        }
        if (this.f76856f == null) {
            this.f76856f = System.getProperty("file.encoding");
        }
        try {
            return new String(this.f76855d, 0, this.f76854c, this.f76856f);
        } catch (UnsupportedEncodingException unused) {
            return new String(this.f76855d, 0, this.f76854c);
        }
    }
}
