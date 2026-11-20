package androidx.compose.ui.focus;

import androidx.collection.l0;
import androidx.collection.t0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0<FocusTargetNode, FocusStateImpl> f3938a = t0.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<Function0<Unit>> f3939b = new androidx.compose.runtime.collection.b<>(new Function0[16], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3940c;

    public final void f() {
        this.f3940c = true;
    }

    public final void g() {
        this.f3938a.h();
        int i11 = 0;
        this.f3940c = false;
        androidx.compose.runtime.collection.b<Function0<Unit>> bVar = this.f3939b;
        int iR = bVar.r();
        if (iR > 0) {
            Function0<Unit>[] function0ArrQ = bVar.q();
            do {
                function0ArrQ[i11].invoke();
                i11++;
            } while (i11 < iR);
        }
        this.f3939b.i();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x0044 A[LOOP:0: B:5:0x000d->B:15:0x0044, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[EDGE_INSN: B:19:0x0047->B:16:0x0047 BREAK  A[LOOP:0: B:5:0x000d->B:15:0x0044], SYNTHETIC] */
    public final void h() {
        l0<FocusTargetNode, FocusStateImpl> l0Var = this.f3938a;
        Object[] objArr = l0Var.f1983b;
        long[] jArr = l0Var.f1982a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                } else {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            ((FocusTargetNode) objArr[(i11 << 3) + i13]).L1();
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    } else if (i11 != length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        this.f3938a.h();
        this.f3940c = false;
        this.f3939b.i();
    }

    public final FocusStateImpl i(FocusTargetNode focusTargetNode) {
        return this.f3938a.b(focusTargetNode);
    }

    public final void j(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        l0<FocusTargetNode, FocusStateImpl> l0Var = this.f3938a;
        if (focusStateImpl != null) {
            l0Var.r(focusTargetNode, focusStateImpl);
        } else {
            h2.a.c("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }
}
