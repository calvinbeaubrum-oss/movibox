package com.transsion.player.longvideo.helper;

import com.blankj.utilcode.util.f0;
import com.transsion.player.longvideo.ui.LongVodUiType;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.i f54400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f54401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f54404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f54405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LongVodUiType f54408i;

    public c(mv.i viewBinding) {
        Intrinsics.g(viewBinding, "viewBinding");
        this.f54400a = viewBinding;
        this.f54401b = 200L;
        this.f54402c = f0.a(24.0f);
        this.f54403d = f0.a(16.0f);
        this.f54404e = f0.a(20.0f);
        this.f54405f = 1.0f;
        this.f54407h = true;
        this.f54408i = LongVodUiType.MIDDLE;
    }

    public final void a() {
    }

    public final boolean b() {
        return this.f54406g;
    }

    public final void c(LongVodUiType uiType) {
        Intrinsics.g(uiType, "uiType");
    }

    public final void d() {
    }

    public final void e(long j11, long j12) {
    }

    public final void f() {
    }
}
