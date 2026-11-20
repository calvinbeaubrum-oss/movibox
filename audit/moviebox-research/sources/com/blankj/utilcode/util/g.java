package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ClipboardManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static void a(CharSequence charSequence) {
        ((ClipboardManager) Utils.a().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(Utils.a().getPackageName(), charSequence));
    }
}
