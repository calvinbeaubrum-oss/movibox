package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24688e;

    private yk(int i11, int i12, int i13, int i14, int i15) {
        this.f24684a = i11;
        this.f24685b = i12;
        this.f24686c = i13;
        this.f24687d = i14;
        this.f24688e = i15;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    public static yk a(String str) {
        b1.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < strArrSplit.length; i15++) {
            String lowerCase = Ascii.toLowerCase(strArrSplit[i15].trim());
            lowerCase.hashCode();
            switch (lowerCase) {
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
        return new yk(i11, i12, i13, i14, strArrSplit.length);
    }
}
