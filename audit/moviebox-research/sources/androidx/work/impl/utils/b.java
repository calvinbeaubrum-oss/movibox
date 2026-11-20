package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class b {
    public static final s6.u a(s6.u workSpec) throws Throwable {
        Intrinsics.g(workSpec, "workSpec");
        androidx.work.b bVar = workSpec.f76208j;
        String str = workSpec.f76201c;
        if (Intrinsics.b(str, ConstraintTrackingWorker.class.getName())) {
            return workSpec;
        }
        if (!bVar.f() && !bVar.i()) {
            return workSpec;
        }
        androidx.work.d dVarA = new androidx.work.d.a().c(workSpec.f76203e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str).a();
        Intrinsics.f(dVarA, "Builder().putAll(workSpe…ame)\n            .build()");
        String name = ConstraintTrackingWorker.class.getName();
        Intrinsics.f(name, "name");
        return workSpec.d((1048574 & 1) != 0 ? workSpec.f76199a : null, (1048574 & 2) != 0 ? workSpec.f76200b : null, (1048574 & 4) != 0 ? workSpec.f76201c : name, (1048574 & 8) != 0 ? workSpec.f76202d : null, (1048574 & 16) != 0 ? workSpec.f76203e : dVarA, (1048574 & 32) != 0 ? workSpec.f76204f : null, (1048574 & 64) != 0 ? workSpec.f76205g : 0L, (1048574 & 128) != 0 ? workSpec.f76206h : 0L, (1048574 & 256) != 0 ? workSpec.f76207i : 0L, (1048574 & 512) != 0 ? workSpec.f76208j : null, (1048574 & 1024) != 0 ? workSpec.f76209k : 0, (1048574 & 2048) != 0 ? workSpec.f76210l : null, (1048574 & 4096) != 0 ? workSpec.f76211m : 0L, (1048574 & 8192) != 0 ? workSpec.f76212n : 0L, (1048574 & 16384) != 0 ? workSpec.f76213o : 0L, (1048574 & 32768) != 0 ? workSpec.f76214p : 0L, (1048574 & 65536) != 0 ? workSpec.f76215q : false, (131072 & 1048574) != 0 ? workSpec.f76216r : null, (1048574 & 262144) != 0 ? workSpec.f76217s : 0, (1048574 & 524288) != 0 ? workSpec.f76218t : 0);
    }

    public static final boolean b(List<? extends androidx.work.impl.s> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            List<? extends androidx.work.impl.s> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((androidx.work.impl.s) it.next()).getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static final s6.u c(List<? extends androidx.work.impl.s> schedulers, s6.u workSpec) {
        Intrinsics.g(schedulers, "schedulers");
        Intrinsics.g(workSpec, "workSpec");
        int i11 = Build.VERSION.SDK_INT;
        if (23 > i11 || i11 >= 26) {
            return (i11 > 22 || !b(schedulers, "androidx.work.impl.background.gcm.GcmScheduler")) ? workSpec : a(workSpec);
        }
        return a(workSpec);
    }
}
