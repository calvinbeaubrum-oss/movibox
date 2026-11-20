package com.bytedance.sdk.component.TRI.sc.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {
    private final zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final We f26634sc;
    private final Queue<String> zY;

    public pFF() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.zY = concurrentLinkedQueue;
        this.f26634sc = new TRI(concurrentLinkedQueue);
        this.pFF = new zY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public synchronized List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(int i11, int i12, List<String> list) {
        List list2;
        try {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc = this.f26634sc.sc(i11, i12, list);
            if (listSc == null || listSc.size() == 0) {
                ArrayList<String> arrayList = new ArrayList(this.zY);
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
                List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc2 = this.pFF.sc(i11, i12, arrayList);
                if (listSc2 != null && listSc2.size() != 0) {
                    HashMap map = new HashMap();
                    for (com.bytedance.sdk.component.TRI.sc.We.sc scVar : listSc2) {
                        map.put(scVar.zY(), scVar);
                    }
                    arrayList.size();
                    if (arrayList.size() != 0) {
                        for (String str : arrayList) {
                            if (map.get(str) != null) {
                                map.remove(str);
                            }
                        }
                    }
                    listSc2.clear();
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        listSc2.add(map.get((String) it.next()));
                    }
                }
                list2 = listSc2;
            } else {
                listSc.size();
                if (i11 == 1 || i11 == 2) {
                    list2 = listSc;
                    List<com.bytedance.sdk.component.TRI.sc.We.sc> listPFF = this.pFF.pFF((com.bytedance.sdk.component.TRI.sc.We.sc) listSc.get(0), listSc.size());
                    list2 = listSc;
                    if (listPFF != null && listPFF.size() != 0) {
                        list2 = listSc;
                        listPFF.size();
                        HashMap map2 = new HashMap();
                        for (com.bytedance.sdk.component.TRI.sc.We.sc scVar2 : listPFF) {
                            map2.put(scVar2.zY(), scVar2);
                        }
                        ArrayList arrayList2 = new ArrayList(this.zY);
                        for (com.bytedance.sdk.component.TRI.sc.We.sc scVar3 : listPFF) {
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                if (TextUtils.equals(scVar3.zY(), (String) it2.next())) {
                                    map2.remove(scVar3.zY());
                                    break;
                                }
                            }
                        }
                        for (com.bytedance.sdk.component.TRI.sc.We.sc scVar4 : listSc) {
                            map2.put(scVar4.zY(), scVar4);
                        }
                        listSc.clear();
                        Iterator it3 = map2.keySet().iterator();
                        while (it3.hasNext()) {
                            listSc.add(map2.get((String) it3.next()));
                        }
                        listPFF.clear();
                        list2 = listSc;
                    }
                }
            }
            if (list2 != null && !list2.isEmpty()) {
                Iterator it4 = list2.iterator();
                while (it4.hasNext()) {
                    this.zY.offer(((com.bytedance.sdk.component.TRI.sc.We.sc) it4.next()).zY());
                }
                return list2;
            }
            return new ArrayList();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public void sc(int i11, long j11) {
        this.pFF.sc(i11, j11);
        this.f26634sc.sc(i11, j11);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public synchronized void sc(int i11, List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        try {
            Iterator<com.bytedance.sdk.component.TRI.sc.We.sc> it = list.iterator();
            while (it.hasNext()) {
                this.zY.remove(it.next().zY());
            }
            We we2 = this.f26634sc;
            if (we2 != null) {
                we2.sc(i11, list);
            }
            zY zYVar = this.pFF;
            if (zYVar != null) {
                zYVar.sc(i11, list);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public synchronized void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        We we2;
        if (i11 != 5) {
            try {
                if (Qj.qr().dE().sc(Qj.qr().TRI()) && (we2 = this.f26634sc) != null && scVar != null) {
                    we2.sc(scVar, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        zY zYVar = this.pFF;
        if (zYVar != null && scVar != null) {
            zYVar.sc(scVar, i11);
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public synchronized boolean sc(int i11, boolean z11) {
        if (this.f26634sc.sc(i11, z11)) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.cD(), 1);
            return true;
        }
        if ((i11 != 1 && i11 != 2) || !this.pFF.sc(i11, z11)) {
            return false;
        }
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Cb(), 1);
        return true;
    }
}
