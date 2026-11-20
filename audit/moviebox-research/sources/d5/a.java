package d5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTable;
import c5.b;
import c5.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import z3.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {
    @Nullable
    public static Metadata c(b0 b0Var) {
        b0Var.r(12);
        int iD = (b0Var.d() + b0Var.h(12)) - 4;
        b0Var.r(44);
        b0Var.s(b0Var.h(12));
        b0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (b0Var.d() >= iD) {
                break;
            }
            b0Var.r(48);
            int iH = b0Var.h(8);
            b0Var.r(4);
            int iD2 = b0Var.d() + b0Var.h(12);
            String strL2 = null;
            while (b0Var.d() < iD2) {
                int iH2 = b0Var.h(8);
                int iH3 = b0Var.h(8);
                int iD3 = b0Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = b0Var.h(16);
                    b0Var.r(8);
                    if (iH4 == 3) {
                        while (b0Var.d() < iD3) {
                            strL = b0Var.l(b0Var.h(8), com.google.common.base.c.f38163a);
                            int iH5 = b0Var.h(8);
                            for (int i11 = 0; i11 < iH5; i11++) {
                                b0Var.s(b0Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = b0Var.l(iH3, com.google.common.base.c.f38163a);
                }
                b0Var.p(iD3 * 8);
            }
            b0Var.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new AppInfoTable(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // c5.c
    @Nullable
    public Metadata b(b bVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new b0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
