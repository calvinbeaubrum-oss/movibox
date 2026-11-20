package com.applovin.impl;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class yr extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f24716o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ur f24717p;

    public yr() {
        super("WebvttDecoder");
        this.f24716o = new bh();
        this.f24717p = new ur();
    }

    private static int a(bh bhVar) {
        int i11 = -1;
        int iD = 0;
        while (i11 == -1) {
            iD = bhVar.d();
            String strL = bhVar.l();
            if (strL == null) {
                i11 = 0;
            } else if ("STYLE".equals(strL)) {
                i11 = 2;
            } else {
                i11 = strL.startsWith("NOTE") ? 1 : 3;
            }
        }
        bhVar.f(iD);
        return i11;
    }

    private static void b(bh bhVar) {
        while (!TextUtils.isEmpty(bhVar.l())) {
        }
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) throws pl {
        wr wrVarA;
        this.f24716o.a(bArr, i11);
        ArrayList arrayList = new ArrayList();
        try {
            zr.b(this.f24716o);
            while (!TextUtils.isEmpty(this.f24716o.l())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iA = a(this.f24716o);
                if (iA == 0) {
                    return new as(arrayList2);
                }
                if (iA == 1) {
                    b(this.f24716o);
                } else if (iA == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new pl("A style block was found after the first cue.");
                    }
                    this.f24716o.l();
                    arrayList.addAll(this.f24717p.c(this.f24716o));
                } else if (iA == 3 && (wrVarA = xr.a(this.f24716o, arrayList)) != null) {
                    arrayList2.add(wrVarA);
                }
            }
        } catch (dh e11) {
            throw new pl(e11);
        }
    }
}
