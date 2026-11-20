package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.We.TRI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile We f26370sc;
    private com.bytedance.adsdk.ugeno.zY.sc ExN;
    private com.bytedance.adsdk.ugeno.core.pFF.zY TRI;
    private sc We;
    private List<com.bytedance.adsdk.ugeno.core.pFF> pFF;
    private com.bytedance.adsdk.ugeno.core.zY zY;

    private We() {
    }

    private void ExN() {
        ArrayList arrayList = new ArrayList();
        this.pFF = arrayList;
        com.bytedance.adsdk.ugeno.core.zY zYVar = this.zY;
        if (zYVar != null) {
            arrayList.addAll(zYVar.sc());
        }
        com.bytedance.adsdk.ugeno.core.We.sc(this.pFF);
    }

    public static We sc() {
        if (f26370sc == null) {
            synchronized (We.class) {
                try {
                    if (f26370sc == null) {
                        f26370sc = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26370sc;
    }

    public com.bytedance.adsdk.ugeno.core.pFF.zY We() {
        return this.TRI;
    }

    public sc pFF() {
        return this.We;
    }

    public void sc(Context context, com.bytedance.adsdk.ugeno.core.zY zYVar, sc scVar) {
        this.zY = zYVar;
        this.We = scVar;
        ExN();
    }

    public void sc(com.bytedance.adsdk.ugeno.We.We we2) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.We.sc().sc());
        if (we2 != null) {
            arrayList.addAll(we2.sc());
        }
        TRI.sc(arrayList);
    }

    public void sc(com.bytedance.adsdk.ugeno.zY.sc scVar) {
        this.ExN = scVar;
    }

    public com.bytedance.adsdk.ugeno.zY.sc zY() {
        return this.ExN;
    }
}
