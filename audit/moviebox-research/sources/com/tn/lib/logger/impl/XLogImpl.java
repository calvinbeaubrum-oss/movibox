package com.tn.lib.logger.impl;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ze.e;

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
public final class XLogImpl implements uo.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f49378b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<XLogImpl> f49379c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<XLogImpl>() { // from class: com.tn.lib.logger.impl.XLogImpl$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final XLogImpl invoke() {
            return new XLogImpl();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f49380a = new Gson();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final XLogImpl a() {
            return (XLogImpl) XLogImpl.f49379c.getValue();
        }
    }

    @Override // uo.a
    public void a(String msg) {
        Intrinsics.g(msg, "msg");
        e.d(msg);
    }

    @Override // uo.a
    public void b(String msg) {
        Intrinsics.g(msg, "msg");
        e.c(msg);
    }

    @Override // uo.a
    public void c(String msg) {
        Intrinsics.g(msg, "msg");
        e.b(msg);
    }

    @Override // uo.a
    public void d(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        e.g(tag).w(msg);
    }

    @Override // uo.a
    public void e(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        e.g(tag).u(msg);
    }

    @Override // uo.a
    public void f(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        e.g(tag).z(msg);
    }

    @Override // uo.a
    public void g(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        e.g(tag).v(msg);
    }

    @Override // uo.a
    public void h(String tag, String... msg) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        e.g(tag).y(msg);
    }
}
