package androidx.compose.foundation;

import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class t extends androidx.compose.ui.f.c implements m1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f2857q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2858r = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super androidx.compose.ui.layout.m, Unit> f2859o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f2860p = f2857q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t(Function1<? super androidx.compose.ui.layout.m, Unit> function1) {
        this.f2859o = function1;
    }

    public final void H1(androidx.compose.ui.layout.m mVar) {
        this.f2859o.invoke(mVar);
        t tVar = (t) n1.b(this);
        if (tVar != null) {
            tVar.H1(mVar);
        }
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return this.f2860p;
    }
}
