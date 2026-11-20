package lp;

import java.util.concurrent.Executor;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f70362a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kp.b f70363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f70364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f70365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kp.a f70366e;

    public final kp.a a() {
        return this.f70366e;
    }

    public final long b() {
        return this.f70364c;
    }

    public final Executor c() {
        return this.f70365d;
    }

    public final kp.b d() {
        return this.f70363b;
    }

    public final String e() {
        return this.f70362a;
    }

    public final void f(Executor executor) {
        this.f70365d = executor;
    }

    public final void g(kp.b bVar) {
        this.f70363b = bVar;
    }

    public final void h(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f70362a = str;
    }
}
