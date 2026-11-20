package androidx.compose.material.ripple;

import androidx.collection.l0;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class CommonRippleNode extends RippleNode {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l0<o1.k.b, RippleAnimation> f3117z;

    public CommonRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0<c> function0) {
        super(gVar, z11, f11, z1Var, function0, null);
        this.f3117z = new l0<>(0, 1, null);
    }

    public /* synthetic */ CommonRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z11, f11, z1Var, function0);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x004e A[LOOP:0: B:5:0x0013->B:15:0x004e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[EDGE_INSN: B:23:0x0051->B:16:0x0051 BREAK  A[LOOP:0: B:5:0x0013->B:15:0x004e], SYNTHETIC] */
    @Override // androidx.compose.material.ripple.RippleNode
    public void M1(o1.k.b bVar, long j11, float f11) {
        l0<o1.k.b, RippleAnimation> l0Var = this.f3117z;
        Object[] objArr = l0Var.f1983b;
        Object[] objArr2 = l0Var.f1984c;
        long[] jArr = l0Var.f1982a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j12 = jArr[i11];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                } else {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j12) < 128) {
                            int i14 = (i11 << 3) + i13;
                            ((RippleAnimation) objArr2[i14]).h();
                        }
                        j12 >>= 8;
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
        RippleAnimation rippleAnimation = new RippleAnimation(O1() ? y1.g.d(bVar.a()) : null, f11, O1(), null);
        this.f3117z.r(bVar, rippleAnimation);
        kotlinx.coroutines.j.d(h1(), null, null, new CommonRippleNode$addRipple$2(rippleAnimation, this, bVar, null), 3, null);
        o.a(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void N1(z1.g gVar) {
        float f11;
        char c11;
        float fD = P1().invoke().d();
        if (fD == 0.0f) {
            return;
        }
        l0<o1.k.b, RippleAnimation> l0Var = this.f3117z;
        Object[] objArr = l0Var.f1983b;
        Object[] objArr2 = l0Var.f1984c;
        long[] jArr = l0Var.f1982a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                long j12 = j11;
                int i13 = 0;
                while (i13 < i12) {
                    if ((j12 & 255) < 128) {
                        int i14 = (i11 << 3) + i13;
                        float f12 = fD;
                        c11 = '\b';
                        ((RippleAnimation) objArr2[i14]).e(gVar, w1.k(Q1(), f12, 0.0f, 0.0f, 0.0f, 14, null));
                    } else {
                        c11 = '\b';
                    }
                    j12 >>= c11;
                    i13++;
                    fD = fD;
                    i12 = i12;
                }
                f11 = fD;
                if (i12 != 8) {
                    return;
                }
            } else {
                f11 = fD;
            }
            if (i11 == length) {
                return;
            }
            i11++;
            fD = f11;
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void T1(o1.k.b bVar) {
        RippleAnimation rippleAnimationB = this.f3117z.b(bVar);
        if (rippleAnimationB != null) {
            rippleAnimationB.h();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        this.f3117z.h();
    }
}
