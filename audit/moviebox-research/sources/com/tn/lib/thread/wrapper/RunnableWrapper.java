package com.tn.lib.thread.wrapper;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp.d;
import lp.f;
import mp.i;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RunnableWrapper implements Runnable {
    private Callable<?> callable;
    private i dispatcher;
    private Runnable runnable;
    private String threadName;

    public RunnableWrapper(d localConfigs) {
        Intrinsics.g(localConfigs, "localConfigs");
        this.threadName = localConfigs.e();
        this.dispatcher = new i(localConfigs.d(), localConfigs.c(), localConfigs.a());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002b, B:15:0x0031, B:17:0x0035), top: B:26:0x002b }] */
    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        Thread currentThread = Thread.currentThread();
        f.a aVar = f.f70369a;
        Intrinsics.f(currentThread, "currentThread");
        aVar.b(currentThread, this.threadName, this.dispatcher);
        i iVar2 = this.dispatcher;
        if (iVar2 != null) {
            iVar2.a(this.threadName);
        }
        Runnable runnable = this.runnable;
        if (runnable == null) {
            Callable<?> callable = this.callable;
            if (callable != null) {
                if (callable != null) {
                    try {
                        callable.call();
                        iVar = this.dispatcher;
                        if (iVar != null) {
                            iVar.onSuccess();
                        }
                    } catch (Exception e11) {
                        i iVar3 = this.dispatcher;
                        if (iVar3 != null) {
                            iVar3.b(this.threadName, e11);
                        }
                    }
                } else {
                    iVar = this.dispatcher;
                    if (iVar != null) {
                        iVar.onSuccess();
                    }
                }
            }
        } else if (runnable != null) {
            runnable.run();
        }
        i iVar4 = this.dispatcher;
        if (iVar4 != null) {
            iVar4.onCompleted(this.threadName);
        }
    }

    public final RunnableWrapper setCallable(Callable<?> callable) {
        this.callable = callable;
        return this;
    }

    public final RunnableWrapper setRunnable(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        this.runnable = runnable;
        return this;
    }
}
