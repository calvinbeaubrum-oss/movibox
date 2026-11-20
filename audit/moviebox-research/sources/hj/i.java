package hj;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f66474a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f66475b;

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public void a(char[] cArr, int i11, int i12) throws IOException {
        int i13;
        if (!this.f66475b || i12 <= 0) {
            i13 = i11;
        } else {
            if (c(cArr[i11] == '\n')) {
                i13 = i11 + 1;
            } else {
                i13 = i11;
            }
        }
        int i14 = i11 + i12;
        int i15 = i13;
        while (i13 < i14) {
            char c11 = cArr[i13];
            if (c11 != '\n') {
                if (c11 == '\r') {
                    this.f66474a.append(cArr, i15, i13 - i15);
                    this.f66475b = true;
                    int i16 = i13 + 1;
                    if (i16 < i14) {
                        if (c(cArr[i16] == '\n')) {
                            i13 = i16;
                        }
                    }
                }
                i13++;
            } else {
                this.f66474a.append(cArr, i15, i13 - i15);
                c(true);
            }
            i15 = i13 + 1;
            i13++;
        }
        this.f66474a.append(cArr, i15, i14 - i15);
    }

    public void b() throws IOException {
        if (this.f66475b || this.f66474a.length() > 0) {
            c(false);
        }
    }

    public final boolean c(boolean z11) throws IOException {
        String str;
        if (this.f66475b) {
            str = z11 ? "\r\n" : "\r";
        } else {
            str = z11 ? "\n" : "";
        }
        d(this.f66474a.toString(), str);
        this.f66474a = new StringBuilder();
        this.f66475b = false;
        return z11;
    }

    public abstract void d(String str, String str2) throws IOException;
}
