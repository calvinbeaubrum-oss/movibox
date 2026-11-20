package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.internal.c;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S[] f69406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f69407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f69408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f69409d;

    public final f1<Integer> c() {
        q qVar;
        synchronized (this) {
            qVar = this.f69409d;
            if (qVar == null) {
                qVar = new q(this.f69407b);
                this.f69409d = qVar;
            }
        }
        return qVar;
    }

    public final S i() {
        S s11;
        q qVar;
        synchronized (this) {
            try {
                S[] sArr = this.f69406a;
                if (sArr == null) {
                    sArr = (S[]) k(2);
                    this.f69406a = sArr;
                } else if (this.f69407b >= sArr.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    Intrinsics.f(objArrCopyOf, "copyOf(...)");
                    this.f69406a = (S[]) ((c[]) objArrCopyOf);
                    sArr = (S[]) ((c[]) objArrCopyOf);
                }
                int i11 = this.f69408c;
                do {
                    s11 = sArr[i11];
                    if (s11 == null) {
                        s11 = (S) j();
                        sArr[i11] = s11;
                    }
                    i11++;
                    if (i11 >= sArr.length) {
                        i11 = 0;
                    }
                    Intrinsics.e(s11, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s11.a(this));
                this.f69408c = i11;
                this.f69407b++;
                qVar = this.f69409d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (qVar != null) {
            qVar.a0(1);
        }
        return s11;
    }

    public abstract S j();

    public abstract S[] k(int i11);

    public final void l(S s11) {
        q qVar;
        int i11;
        Continuation<Unit>[] continuationArrB;
        synchronized (this) {
            try {
                int i12 = this.f69407b - 1;
                this.f69407b = i12;
                qVar = this.f69409d;
                if (i12 == 0) {
                    this.f69408c = 0;
                }
                Intrinsics.e(s11, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArrB = s11.b(this);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (Continuation<Unit> continuation : continuationArrB) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
            }
        }
        if (qVar != null) {
            qVar.a0(-1);
        }
    }

    public final int m() {
        return this.f69407b;
    }

    public final S[] n() {
        return this.f69406a;
    }
}
