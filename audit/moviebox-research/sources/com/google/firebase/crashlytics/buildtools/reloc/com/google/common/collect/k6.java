package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class k6 {
    public static void a(l6 l6Var, final Consumer consumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
        l6Var.entrySet().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                k6.d(consumer, (l6.a) obj);
            }
        });
    }

    public static void b(l6 l6Var, final ObjIntConsumer objIntConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objIntConsumer);
        l6Var.entrySet().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                l6.a aVar = (l6.a) obj;
                objIntConsumer.accept(aVar.getElement(), aVar.getCount());
            }
        });
    }

    public static Spliterator c(l6 l6Var) {
        return Multisets.o(l6Var);
    }

    public static /* synthetic */ void d(Consumer consumer, l6.a aVar) {
        Object element = aVar.getElement();
        int count = aVar.getCount();
        for (int i11 = 0; i11 < count; i11++) {
            consumer.accept(element);
        }
    }
}
