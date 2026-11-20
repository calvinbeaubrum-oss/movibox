package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e, RippleHostView> f3176a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<RippleHostView, e> f3177b = new LinkedHashMap();

    public final e a(RippleHostView rippleHostView) {
        return this.f3177b.get(rippleHostView);
    }

    public final RippleHostView b(e eVar) {
        return this.f3176a.get(eVar);
    }

    public final void c(e eVar) {
        RippleHostView rippleHostView = this.f3176a.get(eVar);
        if (rippleHostView != null) {
            this.f3177b.remove(rippleHostView);
        }
        this.f3176a.remove(eVar);
    }

    public final void d(e eVar, RippleHostView rippleHostView) {
        this.f3176a.put(eVar, rippleHostView);
        this.f3177b.put(rippleHostView, eVar);
    }
}
