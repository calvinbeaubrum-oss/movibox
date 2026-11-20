package ai;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545e;

    public b(int i11, int i12, int i13, int i14, int i15) {
        this.f541a = i11;
        this.f542b = i12;
        this.f543c = i13;
        this.f544d = i14;
        this.f545e = i15;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    @Nullable
    public static b a(String str) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < strArrSplit.length; i15++) {
            String strE = com.google.common.base.a.e(strArrSplit[i15].trim());
            strE.hashCode();
            switch (strE) {
                case "end":
                    i12 = i15;
                    break;
                case "text":
                    i14 = i15;
                    break;
                case "start":
                    i11 = i15;
                    break;
                case "style":
                    i13 = i15;
                    break;
            }
        }
        if (i11 == -1 || i12 == -1 || i14 == -1) {
            return null;
        }
        return new b(i11, i12, i13, i14, strArrSplit.length);
    }
}
