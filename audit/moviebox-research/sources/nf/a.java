package nf;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f71889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71890b;

    public a() {
        this(false, 4000);
    }

    public a(boolean z11, int i11) {
        this.f71889a = z11;
        this.f71890b = i11;
    }

    public static int b(String str, int i11, int i12) {
        if (i12 == str.length() || str.charAt(i12) == '\n') {
            return i12;
        }
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            if (str.charAt(i13) == '\n') {
                return i13;
            }
        }
        return i12;
    }

    @Override // nf.c
    public void a(int i11, String str, String str2) {
        int length = str2.length();
        int i12 = 0;
        while (i12 < length) {
            if (str2.charAt(i12) == '\n') {
                i12++;
            } else {
                int iMin = Math.min(this.f71890b + i12, length);
                if (this.f71889a) {
                    int iIndexOf = str2.indexOf(10, i12);
                    if (iIndexOf != -1) {
                        iMin = iIndexOf;
                    }
                } else {
                    iMin = b(str2, i12, iMin);
                }
                c(i11, str, str2.substring(i12, iMin));
                i12 = iMin;
            }
        }
    }

    public void c(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }
}
