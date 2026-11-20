package androidx.work.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13547a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<s6.m, u> f13548b = new LinkedHashMap();

    public final boolean a(s6.m id2) {
        boolean zContainsKey;
        Intrinsics.g(id2, "id");
        synchronized (this.f13547a) {
            zContainsKey = this.f13548b.containsKey(id2);
        }
        return zContainsKey;
    }

    public final u b(s6.m id2) {
        u uVarRemove;
        Intrinsics.g(id2, "id");
        synchronized (this.f13547a) {
            uVarRemove = this.f13548b.remove(id2);
        }
        return uVarRemove;
    }

    public final List<u> c(String workSpecId) {
        List<u> listJ0;
        Intrinsics.g(workSpecId, "workSpecId");
        synchronized (this.f13547a) {
            try {
                Map<s6.m, u> map = this.f13548b;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<s6.m, u> entry : map.entrySet()) {
                    if (Intrinsics.b(entry.getKey().b(), workSpecId)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    this.f13548b.remove((s6.m) it.next());
                }
                listJ0 = CollectionsKt___CollectionsKt.J0(linkedHashMap.values());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return listJ0;
    }

    public final u d(s6.m id2) {
        u uVar;
        Intrinsics.g(id2, "id");
        synchronized (this.f13547a) {
            try {
                Map<s6.m, u> map = this.f13548b;
                u uVar2 = map.get(id2);
                if (uVar2 == null) {
                    uVar2 = new u(id2);
                    map.put(id2, uVar2);
                }
                uVar = uVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return uVar;
    }

    public final u e(s6.u spec) {
        Intrinsics.g(spec, "spec");
        return d(s6.x.a(spec));
    }
}
