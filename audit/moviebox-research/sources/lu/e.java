package lu;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l.p;

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
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f70544a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, List<b<?>>> f70545b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f70546c = new ConcurrentHashMap<>();

    public final List<b<?>> a(int i11) {
        return f70545b.remove(Integer.valueOf(i11));
    }

    public final int b(List<? extends b<?>> preloadList) {
        ConcurrentHashMap<Integer, List<b<?>>> concurrentHashMap;
        Intrinsics.g(preloadList, "preloadList");
        int iHashCode = preloadList.hashCode();
        while (true) {
            concurrentHashMap = f70545b;
            if (!concurrentHashMap.containsKey(Integer.valueOf(iHashCode))) {
                break;
            }
            iHashCode = (iHashCode << 1) | p.a(SystemClock.elapsedRealtimeNanos());
        }
        concurrentHashMap.put(Integer.valueOf(iHashCode), preloadList);
        Iterator<T> it = preloadList.iterator();
        while (it.hasNext()) {
            b.g((b) it.next(), null, 1, null);
        }
        return iHashCode;
    }

    public final int c(b<?>... preload) {
        Intrinsics.g(preload, "preload");
        return b(kotlin.collections.d.A0(preload));
    }

    public final void d(String str, Bundle bundle) {
        List<b<?>> listA;
        c cVar = f70546c.get(str);
        if (cVar == null || (listA = cVar.a(str, bundle)) == null) {
            return;
        }
        int iB = f70544a.b(listA);
        if (bundle != null) {
            bundle.putInt("yy_preload_id", iB);
        }
    }

    public final void e(c interceptor) {
        Intrinsics.g(interceptor, "interceptor");
        uo.b.a.f(uo.b.f78622a, "IPreload", "regInterceptor", false, 4, null);
        f70546c.put(interceptor.getPath(), interceptor);
    }
}
