package db;

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
public final class o implements va.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f63011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChainType f63012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f63013c;

    public o(Bundle dataBundle) {
        Intrinsics.g(dataBundle, "dataBundle");
        this.f63011a = dataBundle;
        this.f63012b = ChainType.TYPE_START;
        this.f63013c = 10;
    }

    @Override // va.b
    public long a() {
        return va.b.a.a(this);
    }

    @Override // va.b
    public Bundle b() {
        return this.f63011a;
    }

    @Override // va.b
    public ChainType c() {
        return this.f63012b;
    }

    @Override // va.b
    public int d() {
        return this.f63013c;
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
