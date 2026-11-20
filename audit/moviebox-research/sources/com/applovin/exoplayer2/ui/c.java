package com.applovin.exoplayer2.ui;

import android.graphics.Color;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.xp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class c {
    public static String a(int i11) {
        return xp.a("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i11)), Integer.valueOf(Color.green(i11)), Integer.valueOf(Color.blue(i11)), Double.valueOf(((double) Color.alpha(i11)) / 255.0d));
    }

    public static String a(String str) {
        return InstructionFileId.DOT + str + ",." + str + " *";
    }
}
