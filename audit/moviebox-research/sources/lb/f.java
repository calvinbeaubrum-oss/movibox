package lb;

import android.os.Bundle;
import com.cloud.tmc.integration.activity.StartAction;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.structure.AppLoadResult;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f70180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public StartAction f70181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public AppModel f70182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public AppLoadResult f70183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f70184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f70185f;

    public f() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(g context) {
        this();
        Intrinsics.g(context, "context");
        this.f70182c = context.e();
        this.f70184e = context.q();
    }

    public final String a() {
        return this.f70185f;
    }

    public final void b(String str) {
        this.f70185f = str;
    }

    public String toString() {
        return "PrepareCallbackParam{, needWaitIpc=" + this.f70180a + ", action=" + this.f70181b + '}';
    }
}
