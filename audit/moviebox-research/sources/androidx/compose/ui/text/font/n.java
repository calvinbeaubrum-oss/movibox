package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class n {
    public static final Pair<List<h>, Object> b(List<? extends h> list, n0 n0Var, AsyncTypefaceCache asyncTypefaceCache, a0 a0Var, Function1<? super n0, ? extends Object> function1) {
        Object objA;
        Object objM163constructorimpl;
        int size = list.size();
        List listQ = null;
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = list.get(i11);
            int iC = hVar.c();
            o.a aVar = o.f5843a;
            if (o.e(iC, aVar.b())) {
                synchronized (asyncTypefaceCache.f5796d) {
                    try {
                        AsyncTypefaceCache.b bVar = new AsyncTypefaceCache.b(hVar, a0Var.b());
                        AsyncTypefaceCache.a aVar2 = (AsyncTypefaceCache.a) asyncTypefaceCache.f5794b.d(bVar);
                        if (aVar2 == null) {
                            aVar2 = (AsyncTypefaceCache.a) asyncTypefaceCache.f5795c.b(bVar);
                        }
                        if (aVar2 != null) {
                            objA = aVar2.g();
                        } else {
                            Unit unit = Unit.f68710a;
                            try {
                                objA = a0Var.a(hVar);
                                AsyncTypefaceCache.f(asyncTypefaceCache, hVar, a0Var, objA, false, 8, null);
                            } catch (Exception e11) {
                                throw new IllegalStateException("Unable to load font " + hVar, e11);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (objA != null) {
                    return TuplesKt.a(listQ, s.a(n0Var.e(), objA, hVar, n0Var.f(), n0Var.d()));
                }
                throw new IllegalStateException("Unable to load font " + hVar);
            }
            if (o.e(iC, aVar.c())) {
                synchronized (asyncTypefaceCache.f5796d) {
                    try {
                        AsyncTypefaceCache.b bVar2 = new AsyncTypefaceCache.b(hVar, a0Var.b());
                        AsyncTypefaceCache.a aVar3 = (AsyncTypefaceCache.a) asyncTypefaceCache.f5794b.d(bVar2);
                        if (aVar3 == null) {
                            aVar3 = (AsyncTypefaceCache.a) asyncTypefaceCache.f5795c.b(bVar2);
                        }
                        if (aVar3 != null) {
                            objM163constructorimpl = aVar3.g();
                        } else {
                            Unit unit2 = Unit.f68710a;
                            try {
                                Result.Companion companion = Result.Companion;
                                objM163constructorimpl = Result.m163constructorimpl(a0Var.a(hVar));
                            } catch (Throwable th3) {
                                Result.Companion companion2 = Result.Companion;
                                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th3));
                            }
                            if (Result.m169isFailureimpl(objM163constructorimpl)) {
                                objM163constructorimpl = null;
                            }
                            AsyncTypefaceCache.f(asyncTypefaceCache, hVar, a0Var, objM163constructorimpl, false, 8, null);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                if (objM163constructorimpl != null) {
                    return TuplesKt.a(listQ, s.a(n0Var.e(), objM163constructorimpl, hVar, n0Var.f(), n0Var.d()));
                }
            } else {
                if (!o.e(iC, aVar.a())) {
                    throw new IllegalStateException("Unknown font type " + hVar);
                }
                AsyncTypefaceCache.a aVarD = asyncTypefaceCache.d(hVar, a0Var);
                if (aVarD != null) {
                    if (!AsyncTypefaceCache.a.e(aVarD.g()) && aVarD.g() != null) {
                        return TuplesKt.a(listQ, s.a(n0Var.e(), aVarD.g(), hVar, n0Var.f(), n0Var.d()));
                    }
                } else if (listQ == null) {
                    listQ = kotlin.collections.g.q(hVar);
                } else {
                    listQ.add(hVar);
                }
            }
        }
        return TuplesKt.a(listQ, function1.invoke(n0Var));
    }
}
