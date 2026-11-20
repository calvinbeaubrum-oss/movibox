package je;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f67996a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<a> f67997b = new ConcurrentLinkedQueue<>();

    public final void a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f67997b;
        if (concurrentLinkedQueue.size() >= 100) {
            concurrentLinkedQueue.poll();
            a();
        }
    }

    public final void b() {
        f67997b.clear();
    }

    public final List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f67997b);
        return arrayList;
    }

    public final void d(a athenaDataBean) {
        Intrinsics.g(athenaDataBean, "athenaDataBean");
        a();
        f67997b.add(athenaDataBean);
    }
}
