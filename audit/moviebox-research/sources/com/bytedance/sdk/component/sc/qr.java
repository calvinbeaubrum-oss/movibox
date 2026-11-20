package com.bytedance.sdk.component.sc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class qr implements uEA.sc {
    private final boolean Ol;
    private final boolean Qj;
    private final com.bytedance.sdk.component.sc.sc WH;
    private final YIK pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Ql f27011qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Qj f27012sc;
    private final Map<String, pFF> zY = new HashMap();
    private final Map<String, We.pFF> We = new HashMap();
    private final List<dE> ExN = new ArrayList();
    private final Set<We> TRI = new HashSet();

    /* JADX INFO: compiled from: source.java */
    public static final class sc {
        String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        boolean f27015sc;

        private sc(boolean z11, String str) {
            this.f27015sc = z11;
            this.pFF = str;
        }
    }

    public qr(WH wh2, com.bytedance.sdk.component.sc.sc scVar, Dl dl2) {
        this.WH = scVar;
        this.f27012sc = wh2.We;
        YIK yik = new YIK(dl2, wh2.Tf, wh2.Ql);
        this.pFF = yik;
        yik.sc(this);
        yik.sc(wh2.dE);
        this.f27011qr = wh2.Ol;
        this.Qj = wh2.Qj;
        this.Ol = wh2.BT;
    }

    private JPJ pFF(String str, pFF pff) {
        return this.Ol ? JPJ.PRIVATE : this.pFF.sc(this.Qj, str, pff);
    }

    private sc sc(dE dEVar, ExN exN, TRI tri) throws Exception {
        return new sc(true, FI.sc(this.f27012sc.sc(exN.sc(sc(dEVar.ExN, (pFF) exN), tri))));
    }

    private sc sc(final dE dEVar, final We we2, TRI tri) throws Exception {
        this.TRI.add(we2);
        we2.sc(sc(dEVar.ExN, we2), tri, new We.sc() { // from class: com.bytedance.sdk.component.sc.qr.1
            @Override // com.bytedance.sdk.component.sc.We.sc
            public void sc(Object obj) {
                if (qr.this.WH == null) {
                    return;
                }
                qr.this.WH.pFF(FI.sc(qr.this.f27012sc.sc(obj)), dEVar);
                qr.this.TRI.remove(we2);
            }

            @Override // com.bytedance.sdk.component.sc.We.sc
            public void sc(Throwable th2) {
                if (qr.this.WH == null) {
                    return;
                }
                qr.this.WH.pFF(FI.sc(th2), dEVar);
                qr.this.TRI.remove(we2);
            }
        });
        return new sc(false, FI.sc());
    }

    private sc sc(final dE dEVar, zY zYVar, JPJ jpj) throws Exception {
        new Sfl(dEVar.We, jpj, new Sfl.sc() { // from class: com.bytedance.sdk.component.sc.qr.2
        });
        return new sc(false, FI.sc());
    }

    private Object sc(String str, pFF pff) throws JSONException {
        return this.f27012sc.sc(str, sc(pff)[0]);
    }

    private static Type[] sc(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }

    public sc sc(dE dEVar, TRI tri) throws Exception {
        pFF pff = this.zY.get(dEVar.We);
        if (pff != null) {
            try {
                JPJ jpjPFF = pFF(tri.pFF, pff);
                tri.We = jpjPFF;
                if (jpjPFF == null) {
                    dEVar.toString();
                    throw new wjp(-1);
                }
                if (pff instanceof ExN) {
                    dEVar.toString();
                    return sc(dEVar, (ExN) pff, tri);
                }
                if (pff instanceof zY) {
                    dEVar.toString();
                    return sc(dEVar, (zY) pff, jpjPFF);
                }
            } catch (Dl.sc unused) {
                dEVar.toString();
                this.ExN.add(dEVar);
                return new sc(false, FI.sc());
            }
        }
        We.pFF pff2 = this.We.get(dEVar.We);
        if (pff2 == null) {
            dEVar.toString();
            return null;
        }
        We weSc = pff2.sc();
        weSc.sc(dEVar.We);
        JPJ jpjPFF2 = pFF(tri.pFF, weSc);
        tri.We = jpjPFF2;
        if (jpjPFF2 != null) {
            dEVar.toString();
            return sc(dEVar, weSc, tri);
        }
        dEVar.toString();
        weSc.We();
        throw new wjp(-1);
    }

    public void sc() {
        Iterator<We> it = this.TRI.iterator();
        while (it.hasNext()) {
            it.next().ExN();
        }
        this.TRI.clear();
        this.zY.clear();
        this.We.clear();
        this.pFF.pFF(this);
    }

    public void sc(String str, ExN<?, ?> exN) {
        exN.sc(str);
        this.zY.put(str, exN);
    }

    public void sc(String str, We.pFF pff) {
        this.We.put(str, pff);
    }
}
