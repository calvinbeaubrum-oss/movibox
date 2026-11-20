package com.google.android.gms.internal.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zza {
    public static final int zza;

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    static {
        int i11 = Build.VERSION.SDK_INT;
        int i12 = ASTNode.PCTX_STORED;
        if (i11 < 31) {
            if (i11 >= 30) {
                String str = Build.VERSION.CODENAME;
                if (str.length() != 1 || str.charAt(0) < 'S' || str.charAt(0) > 'Z') {
                    i12 = 0;
                }
            } else {
                i12 = 0;
            }
        }
        zza = i12;
    }

    public static PendingIntent zza(Context context, int i11, Intent intent, int i12) {
        return PendingIntent.getBroadcast(context, 0, intent, i12);
    }
}
