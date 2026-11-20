package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile zY f26784sc;

    private zY() {
    }

    public static zY sc() {
        if (f26784sc == null) {
            synchronized (zY.class) {
                try {
                    if (f26784sc == null) {
                        f26784sc = new zY();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26784sc;
    }

    public We sc(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        if (scVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(scVar.Ol())) {
            return new UFX(view, scVar);
        }
        if ("translate".equals(scVar.Ol())) {
            return new BT(view, scVar);
        }
        if ("ripple".equals(scVar.Ol())) {
            return new Qj(view, scVar);
        }
        if ("marquee".equals(scVar.Ol())) {
            return new qr(view, scVar);
        }
        if ("waggle".equals(scVar.Ol())) {
            return new dE(view, scVar);
        }
        if ("shine".equals(scVar.Ol())) {
            return new Tf(view, scVar);
        }
        if ("swing".equals(scVar.Ol())) {
            return new SR(view, scVar);
        }
        if ("fade".equals(scVar.Ol())) {
            return new sc(view, scVar);
        }
        if ("rubIn".equals(scVar.Ol())) {
            return new WH(view, scVar);
        }
        if ("rotate".equals(scVar.Ol())) {
            return new Ol(view, scVar);
        }
        if ("cutIn".equals(scVar.Ol())) {
            return new TRI(view, scVar);
        }
        if ("stretch".equals(scVar.Ol())) {
            return new Ql(view, scVar);
        }
        if ("bounce".equals(scVar.Ol())) {
            return new ExN(view, scVar);
        }
        return null;
    }
}
