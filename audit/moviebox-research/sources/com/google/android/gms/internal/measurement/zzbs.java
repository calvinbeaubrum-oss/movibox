package com.google.android.gms.internal.measurement;

import android.os.Build;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbs {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? ASTNode.PCTX_STORED : 0;
    }
}
