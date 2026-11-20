package com.tn.lib.logger.impl;

import android.util.Log;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.d;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LogcatLoggerImpl implements uo.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f49375b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<LogcatLoggerImpl> f49376c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<LogcatLoggerImpl>() { // from class: com.tn.lib.logger.impl.LogcatLoggerImpl$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LogcatLoggerImpl invoke() {
            return new LogcatLoggerImpl();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f49377a = new Gson();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LogcatLoggerImpl a() {
            return (LogcatLoggerImpl) LogcatLoggerImpl.f49376c.getValue();
        }
    }

    @Override // uo.a
    public void a(String msg) {
        Intrinsics.g(msg, "msg");
        j("DefaultTag");
    }

    @Override // uo.a
    public void b(String msg) {
        Intrinsics.g(msg, "msg");
        if (j("DefaultTag")) {
            Log.e("DefaultTag", msg);
        }
    }

    @Override // uo.a
    public void c(String msg) {
        Intrinsics.g(msg, "msg");
        j("DefaultTag");
    }

    @Override // uo.a
    public void d(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        if (j(tag)) {
            d.i0(msg, " , ", null, null, 0, null, null, 62, null);
        }
    }

    @Override // uo.a
    public void e(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        if (j(tag)) {
            d.i0(msg, " , ", null, null, 0, null, null, 62, null);
        }
    }

    @Override // uo.a
    public void f(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        if (j(tag)) {
            Log.w(tag, d.i0(msg, " , ", null, null, 0, null, null, 62, null));
        }
    }

    @Override // uo.a
    public void g(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        if (j(tag)) {
            Log.e(tag, d.i0(msg, " , ", null, null, 0, null, null, 62, null));
        }
    }

    @Override // uo.a
    public void h(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        if (j(tag)) {
            Log.v(tag, d.i0(msg, " , ", null, null, 0, null, null, 62, null));
        }
    }

    public final boolean j(String str) {
        return uo.d.f78625a.e() || Log.isLoggable(str, 3);
    }
}
