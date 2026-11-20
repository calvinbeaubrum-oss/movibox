package o5;

import com.google.common.collect.ImmutableList;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r {
    public static void a(s sVar, byte[] bArr, s.b bVar, z3.h hVar) {
        sVar.c(bArr, 0, bArr.length, bVar, hVar);
    }

    public static k b(s sVar, byte[] bArr, int i11, int i12) {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        s.b bVar = s.b.f72353c;
        Objects.requireNonNull(aVarBuilder);
        sVar.c(bArr, i11, i12, bVar, new z3.h() { // from class: o5.q
            @Override // z3.h
            public final void accept(Object obj) {
                aVarBuilder.a((e) obj);
            }
        });
        return new g(aVarBuilder.m());
    }

    public static void c(s sVar) {
    }
}
