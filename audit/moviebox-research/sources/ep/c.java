package ep;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f64339a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<Interceptor> f64340b = new ArrayList<>();

    public final void a(Interceptor interceptor) {
        Intrinsics.g(interceptor, "interceptor");
        ArrayList<Interceptor> arrayList = f64340b;
        if (!arrayList.contains(interceptor)) {
            arrayList.add(interceptor);
            return;
        }
        uo.b.a.u(uo.b.f78622a, "InterceptorsManager", "add dump interceptor " + interceptor, false, 4, null);
    }

    public final ArrayList<Interceptor> b() {
        return f64340b;
    }
}
