package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    @SuppressLint({"DiscouragedApi"})
    public static void a(cg.g<?> gVar, Priority priority) {
        if (!(gVar instanceof r)) {
            ig.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", gVar);
        } else {
            t.c().e().u(((r) gVar).d().f(priority), 1);
        }
    }
}
