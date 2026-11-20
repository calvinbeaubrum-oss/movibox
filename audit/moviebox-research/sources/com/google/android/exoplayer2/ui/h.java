package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static String a(String str) {
        return InstructionFileId.DOT + str + ",." + str + " *";
    }

    public static String b(int i11) {
        return com.google.android.exoplayer2.util.o0.C("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i11)), Integer.valueOf(Color.green(i11)), Integer.valueOf(Color.blue(i11)), Double.valueOf(((double) Color.alpha(i11)) / 255.0d));
    }
}
