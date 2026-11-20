package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class qf extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f21931o;

    public qf() {
        super("Mp4WebvttDecoder");
        this.f21931o = new bh();
    }

    private static b5 a(bh bhVar, int i11) throws pl {
        CharSequence charSequenceA = null;
        b5.b bVarC = null;
        while (i11 > 0) {
            if (i11 < 8) {
                throw new pl("Incomplete vtt cue box header found.");
            }
            int iJ = bhVar.j();
            int iJ2 = bhVar.j();
            int i12 = iJ - 8;
            String strA = xp.a(bhVar.c(), bhVar.d(), i12);
            bhVar.g(i12);
            i11 = (i11 - 8) - i12;
            if (iJ2 == 1937011815) {
                bVarC = xr.c(strA);
            } else if (iJ2 == 1885436268) {
                charSequenceA = xr.a((String) null, strA.trim(), Collections.emptyList());
            }
        }
        if (charSequenceA == null) {
            charSequenceA = "";
        }
        return bVarC != null ? bVarC.a(charSequenceA).a() : xr.a(charSequenceA);
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) throws pl {
        this.f21931o.a(bArr, i11);
        ArrayList arrayList = new ArrayList();
        while (this.f21931o.a() > 0) {
            if (this.f21931o.a() < 8) {
                throw new pl("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iJ = this.f21931o.j();
            if (this.f21931o.j() == 1987343459) {
                arrayList.add(a(this.f21931o, iJ - 8));
            } else {
                this.f21931o.g(iJ - 8);
            }
        }
        return new rf(arrayList);
    }
}
