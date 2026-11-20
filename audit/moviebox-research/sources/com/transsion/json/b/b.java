package com.transsion.json.b;

import com.transsion.json.x;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        x xVarG = b().G();
        int length = Array.getLength(obj);
        for (int i11 = 0; i11 < length; i11++) {
            if (xVarG.e()) {
                b().E();
            }
            xVarG.d();
            b().j(Array.get(obj, i11));
        }
        b().C();
    }
}
