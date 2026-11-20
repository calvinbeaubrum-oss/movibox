package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f35724c;

    public d(int i11, int i12, String str) {
        this.f35722a = i11;
        this.f35723b = i12;
        this.f35724c = str;
    }

    @Nullable
    public static d a(c0 c0Var) {
        String str;
        c0Var.Q(2);
        int iD = c0Var.D();
        int i11 = iD >> 1;
        int iD2 = ((c0Var.D() >> 3) & 31) | ((iD & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else {
            if (i11 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(iD2 >= 10 ? InstructionFileId.DOT : ".0");
        sb2.append(iD2);
        return new d(i11, iD2, sb2.toString());
    }
}
