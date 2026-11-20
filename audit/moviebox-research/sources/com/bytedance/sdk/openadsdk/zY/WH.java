package com.bytedance.sdk.openadsdk.zY;

import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {
    private String BT;
    private String Ql;
    private String SR;
    protected IListenerManager TRI;
    private String Tf;
    private String UFX;
    private int Xc;
    private int dE;
    private FilterWord wjp;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static FilterWord f28815sc = new FilterWord("", "");
    public static int pFF = 1;
    public static int zY = 2;
    public static int We = 3;
    public static int ExN = 4;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Set<zY> f28816qr = new HashSet();
    private final Set<pFF> Qj = new HashSet();
    private final Set<We> Ol = new HashSet();
    private final Set<sc> WH = new HashSet();

    /* JADX INFO: compiled from: source.java */
    public interface We {
        void sc(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void sc(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(List<FilterWord> list);
    }

    /* JADX INFO: compiled from: source.java */
    public interface zY {
        void sc(FilterWord filterWord);
    }

    private void ExN(final String str) {
        Cb.zY(new com.bytedance.sdk.component.Qj.Qj("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.zY.WH.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(WH.this.Ql)) {
                        return;
                    }
                    WH.this.sc(6).executeDisLikeClosedCallback(WH.this.Ql, str);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTDislikeManager", "executeRewardVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    private void WH() {
        Iterator<zY> it = this.f28816qr.iterator();
        while (it.hasNext()) {
            it.next().sc(this.wjp);
        }
    }

    public static void sc(final int i11, final String str) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Cb.zY(new com.bytedance.sdk.component.Qj.Qj("DislikeClosed_unregisterMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.zY.WH.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc scVarSc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc();
                    if (i11 == 6) {
                        try {
                            IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(scVarSc.sc(6));
                            if (iListenerManagerAsInterface != null) {
                                iListenerManagerAsInterface.unregisterDisLikeClosedListener(str);
                            }
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }, 5);
        }
    }

    public static void sc(final int i11, final String str, final com.bytedance.sdk.openadsdk.core.zY.We.sc scVar) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Cb.zY(new com.bytedance.sdk.component.Qj.Qj("DislikeClosed_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.zY.WH.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc scVarSc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc();
                    if (i11 != 6 || scVar == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.openadsdk.multipro.aidl.pFF.pFF pff = new com.bytedance.sdk.openadsdk.multipro.aidl.pFF.pFF(str, scVar);
                        IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(scVarSc.sc(6));
                        if (iListenerManagerAsInterface != null) {
                            iListenerManagerAsInterface.registerDisLikeClosedListener(str, pff);
                        }
                    } catch (RemoteException e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTDislikeManager", e11.getMessage());
                    }
                }
            }, 5);
        }
    }

    public void ExN() {
        Iterator<pFF> it = this.Qj.iterator();
        while (it.hasNext()) {
            it.next().sc(zY);
        }
    }

    public boolean Ol() {
        return this.dE < this.Xc;
    }

    public int Qj() {
        return this.dE;
    }

    public void TRI() {
        Iterator<pFF> it = this.Qj.iterator();
        while (it.hasNext()) {
            it.next().sc(ExN);
        }
    }

    public void We() {
        if (!zY() && !TextUtils.isEmpty(this.SR)) {
            this.wjp = new FilterWord("0:00", this.SR);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.wjp);
        if (!TextUtils.isEmpty(this.UFX)) {
            if (TextUtils.isEmpty(this.SR)) {
                com.bytedance.sdk.openadsdk.zY.pFF.sc().sc(this.UFX, arrayList, this.Tf);
            } else {
                com.bytedance.sdk.openadsdk.zY.pFF.sc().sc(this.UFX, arrayList, this.BT, this.SR, this.Tf);
            }
        }
        if (!TextUtils.isEmpty(this.Ql)) {
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                ExN("onItemClickClosed");
            } else {
                com.bytedance.sdk.openadsdk.core.zY.We.sc scVarExN = com.bytedance.sdk.openadsdk.core.Ol.pFF().ExN(this.Ql);
                if (scVarExN != null) {
                    scVarExN.sc();
                    com.bytedance.sdk.openadsdk.core.Ol.pFF().TRI(this.Ql);
                }
            }
        }
        Iterator<pFF> it = this.Qj.iterator();
        while (it.hasNext()) {
            it.next().sc(pFF);
        }
        sc(f28815sc);
        zY("");
    }

    public void We(String str) {
        this.BT = str;
    }

    public FilterWord pFF() {
        return this.wjp;
    }

    public void pFF(String str) {
        this.Tf = str;
    }

    public String qr() {
        return this.SR;
    }

    public IListenerManager sc(int i11) {
        if (this.TRI == null) {
            this.TRI = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(i11));
        }
        return this.TRI;
    }

    public void sc() {
        this.f28816qr.clear();
        this.Qj.clear();
        this.Ol.clear();
        this.WH.clear();
    }

    public void sc(int i11, int i12) {
        this.dE = i11;
        this.Xc = i12;
    }

    public void sc(FilterWord filterWord) {
        this.wjp = filterWord;
        WH();
    }

    public void sc(We we2) {
        this.Ol.add(we2);
    }

    public void sc(pFF pff) {
        this.Qj.add(pff);
    }

    public void sc(sc scVar) {
        this.WH.add(scVar);
    }

    public void sc(zY zYVar) {
        this.f28816qr.add(zYVar);
    }

    public void sc(String str) {
        this.UFX = str;
    }

    public void sc(List<FilterWord> list) {
        Iterator<sc> it = this.WH.iterator();
        while (it.hasNext()) {
            it.next().sc(list);
        }
    }

    public void zY(String str) {
        this.SR = str;
        Iterator<We> it = this.Ol.iterator();
        while (it.hasNext()) {
            it.next().sc(this.SR);
        }
    }

    public boolean zY() {
        FilterWord filterWord = this.wjp;
        return (filterWord == null || filterWord.equals(f28815sc)) ? false : true;
    }
}
