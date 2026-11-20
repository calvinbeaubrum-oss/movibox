package pb;

import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class d implements qb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f73729b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bc.a f73730a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // qb.a
    public String a() {
        return "InnerBackIntercept";
    }

    @Override // qb.a
    public qb.a.d b(App app, boolean z11, qb.a aVar, boolean z12) {
        return qb.a.b.a(this, app, z11, aVar, z12);
    }

    @Override // qb.a
    public qb.a.d c(qb.a.InterfaceC0816a chain) {
        Intrinsics.g(chain, "chain");
        TmcLogger.k("InnerBackIntercept", "InnerBackIntercept: " + chain.a());
        if (chain.a().c() == null) {
            return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
        }
        bc.a aVar = this.f73730a;
        if (aVar != null) {
            aVar.g();
        }
        return qb.a.b.b(this, chain.a().a(), this.f73730a != null, this, false, 8, null);
    }

    public final bc.a d() {
        return this.f73730a;
    }

    public final void e(bc.a aVar) {
        this.f73730a = aVar;
    }

    @Override // qb.a
    public int getPriority() {
        return 8;
    }
}
