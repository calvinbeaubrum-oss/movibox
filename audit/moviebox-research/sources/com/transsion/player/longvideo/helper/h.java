package com.transsion.player.longvideo.helper;

import com.blankj.utilcode.util.d0;
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
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f54416e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.i f54417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54420d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(mv.i viewBinding) {
        Intrinsics.g(viewBinding, "viewBinding");
        this.f54417a = viewBinding;
        this.f54418b = d0.c();
        int iE = d0.e();
        this.f54419c = iE;
        int i11 = this.f54418b;
        if (iE < i11) {
            this.f54419c = i11;
            this.f54418b = iE;
        }
        int iA = com.blankj.utilcode.util.d.a();
        if (iA > 10) {
            this.f54419c -= iA;
        }
    }

    public final int a() {
        return this.f54420d;
    }

    public final void b(int i11, int i12) {
        com.blankj.utilcode.util.d.c();
    }

    public final void c() {
        this.f54420d = 0;
    }
}
