package xa;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.ChainType;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class m implements va.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f80463a;

    public m(Bundle dataBundle) {
        Intrinsics.g(dataBundle, "dataBundle");
        this.f80463a = dataBundle;
    }

    @Override // va.b
    public long a() {
        return va.b.a.a(this);
    }

    @Override // va.b
    public Bundle b() {
        return this.f80463a;
    }

    @Override // va.b
    public ChainType c() {
        return ChainType.TYPE_END;
    }

    @Override // va.b
    public int d() {
        return 9;
    }

    public void e() {
        va.b.a.b(this);
    }

    public void f(va.a aVar) {
        e();
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
