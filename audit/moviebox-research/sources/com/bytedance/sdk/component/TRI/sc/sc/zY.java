package com.bytedance.sdk.component.TRI.sc.sc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.bytedance.sdk.component.TRI.sc.sc.sc.sc.qr;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements We {
    private com.bytedance.sdk.component.TRI.sc.sc.sc.sc.TRI ExN;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc Ol;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc Qj;
    private com.bytedance.sdk.component.TRI.sc.sc.sc.sc.ExN TRI;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc Tf;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc UFX;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc WH;
    private qr We;
    private com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc f26647qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.TRI.sc.sc.sc.sc.We f26648sc;
    private com.bytedance.sdk.component.TRI.sc.sc.sc.sc.pFF zY;

    public zY() {
        Context contextTRI = Qj.qr().TRI();
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.sc()) {
            com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVarTf = Qj.qr().Tf();
            this.f26647qr = scVarTf;
            this.f26648sc = new com.bytedance.sdk.component.TRI.sc.sc.sc.sc.We(contextTRI, scVarTf);
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN()) {
            if (Qj.qr().WH() != null) {
                this.Ol = Qj.qr().WH();
            } else {
                this.Ol = Qj.qr().Ql();
            }
            this.zY = new com.bytedance.sdk.component.TRI.sc.sc.sc.sc.pFF(contextTRI, this.Ol);
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF()) {
            com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVarQl = Qj.qr().Ql();
            this.Qj = scVarQl;
            this.pFF = new com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc(contextTRI, scVarQl);
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.zY()) {
            com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVarQl2 = Qj.qr().Ql();
            this.WH = scVarQl2;
            this.We = new qr(contextTRI, scVarQl2);
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.We()) {
            com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVarSR = Qj.qr().SR();
            this.UFX = scVarSR;
            this.ExN = new com.bytedance.sdk.component.TRI.sc.sc.sc.sc.TRI(contextTRI, scVarSR);
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI()) {
            com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVarBT = Qj.qr().BT();
            this.Tf = scVarBT;
            this.TRI = new com.bytedance.sdk.component.TRI.sc.sc.sc.sc.ExN(contextTRI, scVarBT);
        }
    }

    private boolean sc(List<com.bytedance.sdk.component.TRI.sc.We.sc> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.TRI.sc.We.sc> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.TRI.sc.We.sc next = it.next();
                    if (next != null) {
                        String strZY = next.zY();
                        if (!TextUtils.isEmpty(strZY) && list2.contains(strZY)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    public List<com.bytedance.sdk.component.TRI.sc.We.sc> pFF(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        if (scVar.We() == 0 && scVar.ExN() == 1 && com.bytedance.sdk.component.TRI.sc.pFF.sc.sc()) {
            if (this.f26647qr.pFF() <= i11) {
                return null;
            }
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc = this.f26648sc.sc(this.f26647qr.pFF() - i11, "_id");
            if (listSc != null && listSc.size() != 0) {
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.II(), 1);
            }
            return listSc;
        }
        if (scVar.We() == 3 && scVar.ExN() == 2 && com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN()) {
            if (this.Ol.pFF() > i11) {
                return this.zY.sc(this.Ol.pFF() - i11, "_id");
            }
        } else if (scVar.We() == 0 && scVar.ExN() == 2 && com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF()) {
            if (this.Qj.pFF() > i11) {
                List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc2 = this.pFF.sc(this.Qj.pFF() - i11, "_id");
                if (listSc2 != null && listSc2.size() != 0) {
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.McK(), 1);
                }
                return listSc2;
            }
        } else if (scVar.We() == 1 && scVar.ExN() == 2 && com.bytedance.sdk.component.TRI.sc.pFF.sc.zY()) {
            if (this.WH.pFF() > i11) {
                List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc3 = this.We.sc(this.WH.pFF() - i11, "_id");
                if (listSc3 != null && listSc3.size() != 0) {
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.HJN(), 1);
                }
                return listSc3;
            }
        } else if (scVar.We() == 1 && scVar.ExN() == 3 && com.bytedance.sdk.component.TRI.sc.pFF.sc.We()) {
            if (this.UFX.pFF() > i11) {
                List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc4 = this.ExN.sc(this.UFX.pFF() - i11, "_id");
                if (listSc4 != null && listSc4.size() != 0) {
                    com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Gb(), 1);
                }
                return listSc4;
            }
        } else if (scVar.We() == 2 && scVar.ExN() == 3 && com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI() && this.Tf.pFF() > i11) {
            return this.TRI.sc(this.Tf.pFF() - i11, "_id");
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(int i11, int i12, List<String> list) {
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.sc()) {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc = this.f26648sc.sc("_id");
            if (sc(listSc, list)) {
                listSc.size();
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.JPJ(), 1);
                return listSc;
            }
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN()) {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc2 = this.zY.sc("_id");
            if (sc(listSc2, list)) {
                listSc2.size();
                return listSc2;
            }
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF()) {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listSc3 = this.pFF.sc("_id");
            if (sc(listSc3, list)) {
                listSc3.size();
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.FI(), 1);
                return listSc3;
            }
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.zY()) {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listPFF = this.We.pFF("_id");
            if (sc(listPFF, list)) {
                listPFF.size();
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.WP(), 1);
                return listPFF;
            }
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.We()) {
            List<com.bytedance.sdk.component.TRI.sc.We.sc> listPFF2 = this.ExN.pFF("_id");
            if (sc(listPFF2, list)) {
                listPFF2.size();
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.cvk(), 1);
                return listPFF2;
            }
        }
        if (!com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI()) {
            return null;
        }
        List<com.bytedance.sdk.component.TRI.sc.We.sc> listPFF3 = this.TRI.pFF("_id");
        if (!sc(listPFF3, list)) {
            return null;
        }
        listPFF3.size();
        return listPFF3;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public void sc(int i11, long j11) {
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.We we2 = this.f26648sc;
        if (we2 != null) {
            we2.sc(i11, j11);
        }
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.pFF pff = this.zY;
        if (pff != null) {
            pff.sc(i11, j11);
        }
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc scVar = this.pFF;
        if (scVar != null) {
            scVar.sc(i11, j11);
        }
        qr qrVar = this.We;
        if (qrVar != null) {
            qrVar.sc(i11, j11);
        }
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.TRI tri = this.ExN;
        if (tri != null) {
            tri.sc(i11, j11);
        }
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.ExN exN = this.TRI;
        if (exN != null) {
            exN.sc(i11, j11);
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public void sc(int i11, List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.We.sc scVar = list.get(0);
        if (i11 == 200 || i11 == -1) {
            com.bytedance.sdk.component.TRI.sc.pFF.sc.sc scVar2 = com.bytedance.sdk.component.TRI.sc.pFF.We.We;
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar2.ht(), list.size());
            if (i11 != 200) {
                com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(scVar2.idT(), list.size());
            }
            if (scVar.We() == 0 && scVar.ExN() == 1) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.sc()) {
                    this.f26648sc.pFF(list);
                    return;
                }
                return;
            }
            if (scVar.We() == 3 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN()) {
                    this.zY.pFF(list);
                    return;
                }
                return;
            }
            if (scVar.We() == 0 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF()) {
                    this.pFF.pFF(list);
                    return;
                }
                return;
            }
            if (scVar.We() == 1 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.zY()) {
                    this.We.pFF(list);
                }
            } else if (scVar.We() == 1 && scVar.ExN() == 3) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.We()) {
                    this.ExN.pFF(list);
                }
            } else if (scVar.We() == 2 && scVar.ExN() == 3 && com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI()) {
                this.TRI.pFF(list);
            }
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar, int i11) {
        if (scVar == null) {
            return;
        }
        try {
            scVar.pFF(System.currentTimeMillis());
            if (scVar.We() == 0 && scVar.ExN() == 1) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.sc()) {
                    this.f26648sc.sc(scVar);
                    return;
                }
                return;
            }
            if (scVar.We() == 3 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN()) {
                    this.zY.sc(scVar);
                    return;
                }
                return;
            }
            if (scVar.We() == 0 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF()) {
                    this.pFF.sc(scVar);
                    return;
                }
                return;
            }
            if (scVar.We() == 1 && scVar.ExN() == 2) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.zY()) {
                    this.We.sc(scVar);
                }
            } else if (scVar.We() == 1 && scVar.ExN() == 3) {
                if (com.bytedance.sdk.component.TRI.sc.pFF.sc.We()) {
                    this.ExN.sc(scVar);
                }
            } else if (scVar.We() == 2 && scVar.ExN() == 3 && com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI()) {
                this.TRI.sc(scVar);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.OXF(), 1);
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.We
    public boolean sc(int i11, boolean z11) {
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.ExN exN;
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.TRI tri;
        qr qrVar;
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.sc scVar;
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.pFF pff;
        com.bytedance.sdk.component.TRI.sc.sc.sc.sc.We we2;
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.sc() && (we2 = this.f26648sc) != null && we2.sc(i11)) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.SR(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.ExN() && (pff = this.zY) != null && pff.sc(i11)) {
            return true;
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.pFF() && (scVar = this.pFF) != null && scVar.sc(i11)) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.BT(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.TRI.sc.pFF.sc.zY() && (qrVar = this.We) != null && qrVar.sc(i11)) {
            com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.dE(), 1);
            return true;
        }
        if (!com.bytedance.sdk.component.TRI.sc.pFF.sc.We() || (tri = this.ExN) == null || !tri.sc(i11)) {
            return com.bytedance.sdk.component.TRI.sc.pFF.sc.TRI() && (exN = this.TRI) != null && exN.sc(i11);
        }
        com.bytedance.sdk.component.TRI.sc.zY.pFF.sc(com.bytedance.sdk.component.TRI.sc.pFF.We.We.Xc(), 1);
        return true;
    }
}
