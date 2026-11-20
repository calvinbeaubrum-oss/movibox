package com.tn.lib.thread;

import android.os.Build;
import android.os.Looper;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f49437a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Runnable> f49438b = new ArrayList();

    public static final void c(b uiTask) {
        Intrinsics.g(uiTask, "$uiTask");
        Looper.myQueue().addIdleHandler(uiTask);
    }

    public final void b(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        final f fVar = new f(runnable);
        b.f49433a.a().add(fVar);
        if (Intrinsics.b(Looper.getMainLooper(), Looper.myLooper())) {
            Looper.myQueue().addIdleHandler(fVar);
        } else if (Build.VERSION.SDK_INT >= 23) {
            Looper.getMainLooper().getQueue().addIdleHandler(fVar);
        } else {
            ThreadUtils.j(new Runnable() { // from class: com.tn.lib.thread.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.c(fVar);
                }
            });
        }
    }
}
