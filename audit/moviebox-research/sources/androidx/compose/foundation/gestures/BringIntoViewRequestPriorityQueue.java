package androidx.compose.foundation.gestures;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public final class BringIntoViewRequestPriorityQueue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2271b = androidx.compose.runtime.collection.b.f3357d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<ContentInViewNode.a> f2272a = new androidx.compose.runtime.collection.b<>(new ContentInViewNode.a[16], 0);

    public final void b(Throwable th2) {
        androidx.compose.runtime.collection.b<ContentInViewNode.a> bVar = this.f2272a;
        int iR = bVar.r();
        kotlinx.coroutines.n[] nVarArr = new kotlinx.coroutines.n[iR];
        for (int i11 = 0; i11 < iR; i11++) {
            nVarArr[i11] = bVar.q()[i11].a();
        }
        for (int i12 = 0; i12 < iR; i12++) {
            nVarArr[i12].cancel(th2);
        }
        if (!this.f2272a.t()) {
            throw new IllegalStateException("uncancelled requests present".toString());
        }
    }

    public final boolean c(final ContentInViewNode.a aVar) {
        y1.i iVarInvoke = aVar.b().invoke();
        if (iVarInvoke == null) {
            kotlinx.coroutines.n<Unit> nVarA = aVar.a();
            Result.Companion companion = Result.Companion;
            nVarA.resumeWith(Result.m163constructorimpl(Unit.f68710a));
            return false;
        }
        aVar.a().invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                this.this$0.f2272a.x(aVar);
            }
        });
        IntRange intRange = new IntRange(0, this.f2272a.r() - 1);
        int iG = intRange.g();
        int i11 = intRange.i();
        if (iG <= i11) {
            while (true) {
                y1.i iVarInvoke2 = this.f2272a.q()[i11].b().invoke();
                if (iVarInvoke2 != null) {
                    y1.i iVarM = iVarInvoke.m(iVarInvoke2);
                    if (!Intrinsics.b(iVarM, iVarInvoke)) {
                        if (!Intrinsics.b(iVarM, iVarInvoke2)) {
                            CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                            int iR = this.f2272a.r() - 1;
                            if (iR <= i11) {
                                while (true) {
                                    this.f2272a.q()[i11].a().cancel(cancellationException);
                                    if (iR == i11) {
                                        break;
                                    }
                                    iR++;
                                }
                            }
                        }
                    } else {
                        this.f2272a.a(i11 + 1, aVar);
                        return true;
                    }
                }
                if (i11 != iG) {
                    i11--;
                }
            }
        }
        this.f2272a.a(0, aVar);
        return true;
    }

    public final void d() {
        IntRange intRange = new IntRange(0, this.f2272a.r() - 1);
        int iG = intRange.g();
        int i11 = intRange.i();
        if (iG <= i11) {
            while (true) {
                this.f2272a.q()[iG].a().resumeWith(Result.m163constructorimpl(Unit.f68710a));
                if (iG == i11) {
                    break;
                } else {
                    iG++;
                }
            }
        }
        this.f2272a.i();
    }
}
