package com.quickjs.plugin;

import com.quickjs.JSArray;
import com.quickjs.JSFunction;
import com.quickjs.JSObject;
import com.quickjs.c0;
import com.quickjs.e0;
import com.quickjs.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f extends e0 {
    public static /* synthetic */ void f(JSFunction jSFunction, y yVar) {
        if (jSFunction.getContext().h0()) {
            return;
        }
        jSFunction.u(null, new JSArray(yVar));
    }

    public static /* synthetic */ void g(long j11, final JSFunction jSFunction, final y yVar) {
        try {
            Thread.sleep(j11);
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        jSFunction.getQuickJS().i(new Runnable() { // from class: com.quickjs.plugin.e
            @Override // java.lang.Runnable
            public final void run() {
                f.f(jSFunction, yVar);
            }
        });
    }

    public static /* synthetic */ void h(final y yVar, JSObject jSObject, JSArray jSArray) {
        final JSFunction jSFunction = (JSFunction) jSArray.U(0);
        final long j11 = (long) jSArray.getDouble(1);
        new Thread(new Runnable() { // from class: com.quickjs.plugin.d
            @Override // java.lang.Runnable
            public final void run() {
                f.g(j11, jSFunction, yVar);
            }
        }).start();
    }

    @Override // com.quickjs.e0
    public void a(y yVar) {
    }

    @Override // com.quickjs.e0
    public void b(final y yVar) {
        yVar.p(new c0() { // from class: com.quickjs.plugin.c
            @Override // com.quickjs.c0
            public final void a(JSObject jSObject, JSArray jSArray) {
                f.h(yVar, jSObject, jSArray);
            }
        }, "setTimeout");
    }
}
