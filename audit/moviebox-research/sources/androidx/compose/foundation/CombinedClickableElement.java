package androidx.compose.foundation;

import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class CombinedClickableElement extends l0<CombinedClickableNodeImpl> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.i f2213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f2214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.i f2217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f2218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f2220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f2221j;

    public CombinedClickableElement(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0, String str2, Function0<Unit> function1, Function0<Unit> function2) {
        this.f2213b = iVar;
        this.f2214c = b0Var;
        this.f2215d = z11;
        this.f2216e = str;
        this.f2217f = iVar2;
        this.f2218g = function0;
        this.f2219h = str2;
        this.f2220i = function1;
        this.f2221j = function2;
    }

    public /* synthetic */ CombinedClickableElement(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0 function0, String str2, Function0 function1, Function0 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, b0Var, z11, str, iVar2, function0, str2, function1, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return Intrinsics.b(this.f2213b, combinedClickableElement.f2213b) && Intrinsics.b(this.f2214c, combinedClickableElement.f2214c) && this.f2215d == combinedClickableElement.f2215d && Intrinsics.b(this.f2216e, combinedClickableElement.f2216e) && Intrinsics.b(this.f2217f, combinedClickableElement.f2217f) && this.f2218g == combinedClickableElement.f2218g && Intrinsics.b(this.f2219h, combinedClickableElement.f2219h) && this.f2220i == combinedClickableElement.f2220i && this.f2221j == combinedClickableElement.f2221j;
    }

    public int hashCode() {
        o1.i iVar = this.f2213b;
        int iHashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        b0 b0Var = this.f2214c;
        int iHashCode2 = (((iHashCode + (b0Var != null ? b0Var.hashCode() : 0)) * 31) + e.a(this.f2215d)) * 31;
        String str = this.f2216e;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        androidx.compose.ui.semantics.i iVar2 = this.f2217f;
        int iL = (((iHashCode3 + (iVar2 != null ? androidx.compose.ui.semantics.i.l(iVar2.n()) : 0)) * 31) + this.f2218g.hashCode()) * 31;
        String str2 = this.f2219h;
        int iHashCode4 = (iL + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.f2220i;
        int iHashCode5 = (iHashCode4 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function1 = this.f2221j;
        return iHashCode5 + (function1 != null ? function1.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public CombinedClickableNodeImpl a() {
        return new CombinedClickableNodeImpl(this.f2218g, this.f2219h, this.f2220i, this.f2221j, this.f2213b, this.f2214c, this.f2215d, this.f2216e, this.f2217f, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(CombinedClickableNodeImpl combinedClickableNodeImpl) {
        combinedClickableNodeImpl.i2(this.f2218g, this.f2219h, this.f2220i, this.f2221j, this.f2213b, this.f2214c, this.f2215d, this.f2216e, this.f2217f);
    }
}
