package androidx.compose.foundation.lazy.layout;

import androidx.collection.n0;
import androidx.collection.o0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class NearestRangeKeyIndexMap implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0<Object> f2671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f2672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2673d;

    public NearestRangeKeyIndexMap(IntRange intRange, j<?> jVar) {
        b<Interval> bVarC = jVar.c();
        final int iG = intRange.g();
        if (iG < 0) {
            throw new IllegalStateException("negative nearestRange.first".toString());
        }
        final int iMin = Math.min(intRange.i(), bVarC.getSize() - 1);
        if (iMin < iG) {
            this.f2671b = o0.a();
            this.f2672c = new Object[0];
            this.f2673d = 0;
        } else {
            int i11 = (iMin - iG) + 1;
            this.f2672c = new Object[i11];
            this.f2673d = iG;
            final androidx.collection.i0 i0Var = new androidx.collection.i0(i11);
            bVarC.a(iG, iMin, new Function1<b.a<? extends j.a>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(b.a<? extends j.a> aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0039  */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(b.a<? extends j.a> aVar) {
                    Object objA;
                    Function1<Integer, Object> key = aVar.c().getKey();
                    int iMax = Math.max(iG, aVar.b());
                    int iMin2 = Math.min(iMin, (aVar.b() + aVar.a()) - 1);
                    if (iMax > iMin2) {
                        return;
                    }
                    while (true) {
                        if (key == null) {
                            objA = b0.a(iMax);
                        } else {
                            objA = key.invoke(Integer.valueOf(iMax - aVar.b()));
                            if (objA == null) {
                                objA = b0.a(iMax);
                            }
                        }
                        i0Var.s(objA, iMax);
                        this.f2672c[iMax - this.f2673d] = objA;
                        if (iMax == iMin2) {
                            return;
                        } else {
                            iMax++;
                        }
                    }
                }
            });
            this.f2671b = i0Var;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.p
    public int a(Object obj) {
        n0<Object> n0Var = this.f2671b;
        int iB = n0Var.b(obj);
        if (iB >= 0) {
            return n0Var.f1958c[iB];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.p
    public Object b(int i11) {
        Object[] objArr = this.f2672c;
        int i12 = i11 - this.f2673d;
        if (i12 < 0 || i12 > kotlin.collections.d.U(objArr)) {
            return null;
        }
        return objArr[i12];
    }
}
