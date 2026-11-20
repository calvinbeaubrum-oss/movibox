package com.tn.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0538a f49428d = new C0538a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f49429f = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f49430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f49431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49432c;

    /* JADX INFO: renamed from: com.tn.lib.thread.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0538a {
        public C0538a() {
        }

        public /* synthetic */ C0538a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String pre) {
        ThreadGroup threadGroup;
        String str;
        Intrinsics.g(pre, "pre");
        this.f49431b = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
            str = "s.threadGroup";
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
            str = "currentThread().threadGroup";
        }
        Intrinsics.f(threadGroup, str);
        this.f49430a = threadGroup;
        this.f49432c = pre + "-pool-" + f49429f.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r11) {
        Intrinsics.g(r11, "r");
        Thread thread = new Thread(this.f49430a, r11, this.f49432c + this.f49431b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
