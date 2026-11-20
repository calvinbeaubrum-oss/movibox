package com.bytedance.sdk.component.ExN.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX extends sc {
    private void sc(int i11, String str, Throwable th2, com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        zYVar.sc(new Qj(i11, str, th2));
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(final com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        final com.bytedance.sdk.component.ExN.zY.TRI triSfl = zYVar.Sfl();
        com.bytedance.sdk.component.ExN.We We = triSfl.We();
        zYVar.sc(false);
        try {
            com.bytedance.sdk.component.ExN.TRI triSc = We.sc(new com.bytedance.sdk.component.ExN.pFF.zY(zYVar.sc(), zYVar.Ql(), zYVar.SR(), zYVar.uEA()));
            int iPFF = triSc.pFF();
            zYVar.sc(triSc.sc());
            if (triSc.pFF() != 200) {
                triSfl.Qj();
                String.valueOf(triSc);
                Object objZY = triSc.zY();
                sc(iPFF, triSc.We(), objZY instanceof Throwable ? (Throwable) objZY : null, zYVar);
                return;
            }
            final byte[] bArr = (byte[]) triSc.zY();
            zYVar.sc(new pFF(bArr, triSc));
            final String strWH = zYVar.WH();
            final com.bytedance.sdk.component.ExN.pFF pffYIK = zYVar.YIK();
            if (pffYIK.zY()) {
                triSfl.pFF(zYVar.YIK()).sc(strWH, bArr);
            }
            triSfl.TRI().submit(new Runnable() { // from class: com.bytedance.sdk.component.ExN.We.UFX.1
                @Override // java.lang.Runnable
                public void run() {
                    if (pffYIK.We()) {
                        triSfl.zY(zYVar.YIK()).sc(strWH, bArr);
                    }
                }
            });
        } catch (Throwable th2) {
            sc(1004, "net request failed!", th2, zYVar);
        }
    }
}
