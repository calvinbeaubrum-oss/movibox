package androidx.compose.foundation.relocation;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.g;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import y1.i;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class BringIntoViewResponderNode extends androidx.compose.ui.f.c implements androidx.compose.foundation.relocation.a, w, m1 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f2828r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f2829s = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f2830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f2831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2832q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BringIntoViewResponderNode(d dVar) {
        this.f2830o = dVar;
    }

    public static final i I1(BringIntoViewResponderNode bringIntoViewResponderNode, m mVar, Function0<i> function0) {
        i iVarInvoke;
        if (!bringIntoViewResponderNode.o1() || !bringIntoViewResponderNode.f2832q) {
            return null;
        }
        m mVarK = g.k(bringIntoViewResponderNode);
        if (!mVar.D()) {
            mVar = null;
        }
        if (mVar == null || (iVarInvoke = function0.invoke()) == null) {
            return null;
        }
        return c.c(mVarK, mVar, iVarInvoke);
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return f2828r;
    }

    public final d J1() {
        return this.f2830o;
    }

    @Override // androidx.compose.foundation.relocation.a
    public Object a0(final m mVar, final Function0<i> function0, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new BringIntoViewResponderNode$bringChildIntoView$2(this, mVar, function0, new Function0<i>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$parentRect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                i iVarI1 = BringIntoViewResponderNode.I1(this.this$0, mVar, function0);
                if (iVarI1 != null) {
                    return this.this$0.J1().R(iVarI1);
                }
                return null;
            }
        }, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void l(long j11) {
        v.b(this, j11);
    }

    @Override // androidx.compose.ui.node.w
    public void m(m mVar) {
        this.f2832q = true;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2831p;
    }
}
