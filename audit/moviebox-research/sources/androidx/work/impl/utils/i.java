package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f13538a;

    public i(WorkDatabase workDatabase) {
        Intrinsics.g(workDatabase, "workDatabase");
        this.f13538a = workDatabase;
    }

    public static final Integer d(i this$0) {
        Intrinsics.g(this$0, "this$0");
        return Integer.valueOf(j.d(this$0.f13538a, "next_alarm_manager_id"));
    }

    public static final Integer f(i this$0, int i11, int i12) {
        Intrinsics.g(this$0, "this$0");
        int iD = j.d(this$0.f13538a, "next_job_scheduler_id");
        if (i11 > iD || iD > i12) {
            j.e(this$0.f13538a, "next_job_scheduler_id", i11 + 1);
        } else {
            i11 = iD;
        }
        return Integer.valueOf(i11);
    }

    public final int c() {
        Object objC = this.f13538a.C(new Callable() { // from class: androidx.work.impl.utils.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return i.d(this.f13534a);
            }
        });
        Intrinsics.f(objC, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) objC).intValue();
    }

    public final int e(final int i11, final int i12) {
        Object objC = this.f13538a.C(new Callable() { // from class: androidx.work.impl.utils.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return i.f(this.f13535a, i11, i12);
            }
        });
        Intrinsics.f(objC, "workDatabase.runInTransa…            id\n        })");
        return ((Number) objC).intValue();
    }
}
