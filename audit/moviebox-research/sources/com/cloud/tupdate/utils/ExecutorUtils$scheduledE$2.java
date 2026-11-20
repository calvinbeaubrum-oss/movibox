package com.cloud.tupdate.utils;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class ExecutorUtils$scheduledE$2 extends Lambda implements Function0<ScheduledThreadPoolExecutor> {
    public static final ExecutorUtils$scheduledE$2 INSTANCE = new ExecutorUtils$scheduledE$2();

    public ExecutorUtils$scheduledE$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Thread m143invoke$lambda0(final Runnable runnable) {
        return ThreadsKt.a((6 & 1) != 0, (6 & 2) != 0 ? false : false, (6 & 4) != 0 ? null : null, (6 & 8) != 0 ? null : Intrinsics.p("SCHEDULED ", Integer.valueOf(ExecutorUtils.f32230i.incrementAndGet())), (6 & 16) != 0 ? -1 : 1, new Function0<Unit>() { // from class: com.cloud.tupdate.utils.ExecutorUtils$scheduledE$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                runnable.run();
            }
        });
    }

    @Override // kotlin.jvm.functions.Function0
    public final ScheduledThreadPoolExecutor invoke() {
        return new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.cloud.tupdate.utils.t
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ExecutorUtils$scheduledE$2.m143invoke$lambda0(runnable);
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }
}
