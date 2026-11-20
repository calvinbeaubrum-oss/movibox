package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class k extends c {
    public k(Context context, b bVar, d dVar) {
        super(CrashType.LAUNCH, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i11, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a aVarA = super.a(i11, aVar);
        if (i11 == 0) {
            Header headerA = Header.a(this.f17044b);
            headerA.c();
            aVarA.a(headerA);
            com.apm.insight.a.a(aVarA, headerA, this.f17043a);
        } else if (i11 == 1) {
            Header headerD = aVarA.d();
            headerD.d();
            headerD.e();
        } else if (i11 == 2) {
            Header.a(aVarA.d());
            try {
                aVarA.d().f().put("launch_did", com.apm.insight.i.a.a(this.f17044b));
            } catch (Throwable unused) {
            }
        } else if (i11 == 5) {
            Header.b(aVarA.d());
        }
        return aVarA;
    }
}
