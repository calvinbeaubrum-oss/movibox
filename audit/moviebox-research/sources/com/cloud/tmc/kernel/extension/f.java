package com.cloud.tmc.kernel.extension;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface f {
    jc.a a(String str);

    void b(Class<? extends c> cls, Class<? extends com.cloud.tmc.kernel.node.d> cls2);

    Class<? extends com.cloud.tmc.kernel.node.d> c(Class<? extends c> cls);

    int d();

    @Nullable
    List<Class<? extends c>> e(String str);
}
