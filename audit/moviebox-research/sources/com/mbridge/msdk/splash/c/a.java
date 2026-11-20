package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.n;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public final void a(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.a.d dVar, com.mbridge.msdk.splash.b.a aVar) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, dVar);
            if (aVar != null) {
                aVar.a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.a("View render error.");
            }
        }
    }

    public final void a(MBSplashView mBSplashView, com.mbridge.msdk.splash.a.d dVar, com.mbridge.msdk.splash.b.a aVar) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = com.mbridge.msdk.foundation.controller.c.m().c();
        }
        if (dVar == null && aVar != null) {
            aVar.a("The render parameters is unavailable.");
            return;
        }
        String strA = (dVar == null || dVar.c() == null) ? "" : n.a(dVar.c().getAdZip());
        if (TextUtils.isEmpty(strA)) {
            a(context, mBSplashView, dVar, aVar);
            return;
        }
        if (dVar == null || dVar.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar.c().getAdZip())) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(strA);
                a(arrayList, mBSplashView, dVar, aVar);
                return;
            } catch (Exception unused) {
            }
        }
        a(context, mBSplashView, dVar, aVar);
    }

    public void a(List<String> list, MBSplashView mBSplashView, com.mbridge.msdk.splash.a.d dVar, com.mbridge.msdk.splash.b.a aVar) {
    }
}
