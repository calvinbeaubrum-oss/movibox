package com.bytedance.sdk.component.TRI.sc;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile List<Object> f26607sc = new ArrayList();

    public static void ExN() {
        We we2 = We.f26595sc;
    }

    public static void We() {
        We.f26595sc.pFF();
    }

    public static boolean pFF() {
        return Qj.qr().dE() == null || Qj.qr().TRI() == null;
    }

    public static List<Object> sc() {
        return f26607sc;
    }

    public static void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        We.f26595sc.sc(scVar);
    }

    public static void sc(sc scVar, Context context) {
        We.f26595sc.sc(scVar, context);
    }

    public static void sc(String str, List<String> list, boolean z11, int i11, String str2) {
        sc(str, list, z11, null, i11, str2);
    }

    public static void sc(String str, List<String> list, boolean z11, Map<String, String> map, int i11, String str2) {
        We.f26595sc.sc(str, list, z11, map, i11, str2);
    }

    public static void sc(String str, boolean z11) {
        We.f26595sc.sc(str, z11);
    }

    public static void sc(boolean z11) {
        We.f26595sc.sc(z11);
    }

    public static void zY() {
        sc(false);
        We.f26595sc.sc();
    }
}
