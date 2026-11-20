package com.google.android.gms.internal.p001authapi;

import android.os.Build;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zbbk {
    public static final int zba;

    static {
        zba = Build.VERSION.SDK_INT >= 31 ? ASTNode.PCTX_STORED : 0;
    }
}
