package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class y5 {
    public static void a(z5 z5Var, final BiConsumer biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        z5Var.entries().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                biConsumer.accept(entry.getKey(), entry.getValue());
            }
        });
    }
}
