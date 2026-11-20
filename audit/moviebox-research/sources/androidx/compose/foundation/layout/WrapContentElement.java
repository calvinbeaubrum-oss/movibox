package androidx.compose.foundation.layout;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class WrapContentElement extends l0<WrapContentNode> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f2464g = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Direction f2465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<q2.t, LayoutDirection, q2.p> f2467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2469f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WrapContentElement a(final androidx.compose.ui.b.c cVar, boolean z11) {
            return new WrapContentElement(Direction.Vertical, z11, new Function2<q2.t, LayoutDirection, q2.p>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$height$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ q2.p invoke(q2.t tVar, LayoutDirection layoutDirection) {
                    return q2.p.b(m26invoke5SAbXVA(tVar.j(), layoutDirection));
                }

                /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m26invoke5SAbXVA(long j11, LayoutDirection layoutDirection) {
                    return q2.q.a(0, cVar.a(0, q2.t.f(j11)));
                }
            }, cVar, "wrapContentHeight");
        }

        public final WrapContentElement b(final androidx.compose.ui.b bVar, boolean z11) {
            return new WrapContentElement(Direction.Both, z11, new Function2<q2.t, LayoutDirection, q2.p>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$size$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ q2.p invoke(q2.t tVar, LayoutDirection layoutDirection) {
                    return q2.p.b(m27invoke5SAbXVA(tVar.j(), layoutDirection));
                }

                /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m27invoke5SAbXVA(long j11, LayoutDirection layoutDirection) {
                    return bVar.a(q2.t.f74253b.a(), j11, layoutDirection);
                }
            }, bVar, "wrapContentSize");
        }

        public final WrapContentElement c(final androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, boolean z11) {
            return new WrapContentElement(Direction.Horizontal, z11, new Function2<q2.t, LayoutDirection, q2.p>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ q2.p invoke(q2.t tVar, LayoutDirection layoutDirection) {
                    return q2.p.b(m28invoke5SAbXVA(tVar.j(), layoutDirection));
                }

                /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m28invoke5SAbXVA(long j11, LayoutDirection layoutDirection) {
                    return q2.q.a(interfaceC0052b.a(0, q2.t.g(j11), layoutDirection), 0);
                }
            }, interfaceC0052b, "wrapContentWidth");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentElement(Direction direction, boolean z11, Function2<? super q2.t, ? super LayoutDirection, q2.p> function2, Object obj, String str) {
        this.f2465b = direction;
        this.f2466c = z11;
        this.f2467d = function2;
        this.f2468e = obj;
        this.f2469f = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.f2465b == wrapContentElement.f2465b && this.f2466c == wrapContentElement.f2466c && Intrinsics.b(this.f2468e, wrapContentElement.f2468e);
    }

    public int hashCode() {
        return (((this.f2465b.hashCode() * 31) + androidx.compose.foundation.e.a(this.f2466c)) * 31) + this.f2468e.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public WrapContentNode a() {
        return new WrapContentNode(this.f2465b, this.f2466c, this.f2467d);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(WrapContentNode wrapContentNode) {
        wrapContentNode.J1(this.f2465b);
        wrapContentNode.K1(this.f2466c);
        wrapContentNode.I1(this.f2467d);
    }
}
