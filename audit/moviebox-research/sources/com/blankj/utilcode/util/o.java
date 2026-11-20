package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.Uri;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static Intent a(Intent intent, boolean z11) {
        return z11 ? intent.addFlags(ASTNode.DEOP) : intent;
    }

    public static Intent b(String str, boolean z11) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return a(intent, z11);
    }

    public static boolean c(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
