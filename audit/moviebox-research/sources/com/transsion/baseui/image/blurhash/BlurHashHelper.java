package com.transsion.baseui.image.blurhash;

import android.app.Application;
import android.graphics.drawable.BitmapDrawable;
import com.blankj.utilcode.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class BlurHashHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BlurHashHelper f51391a = new BlurHashHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51392b = LazyKt__LazyJVMKt.b(new Function0<BlurHash>() { // from class: com.transsion.baseui.image.blurhash.BlurHashHelper$blurHash$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BlurHash invoke() {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return new BlurHash(applicationA, 10, 0.6f);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f51393c = 8;

    public static /* synthetic */ void b(BlurHashHelper blurHashHelper, String str, int i11, int i12, Function1 function1, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 20;
        }
        if ((i13 & 4) != 0) {
            i12 = 20;
        }
        blurHashHelper.a(str, i11, i12, function1);
    }

    public final void a(String blurString, int i11, int i12, Function1<? super BitmapDrawable, Unit> response) {
        Intrinsics.g(blurString, "blurString");
        Intrinsics.g(response, "response");
        c().f(blurString, i11, i12, response);
    }

    public final BlurHash c() {
        return (BlurHash) f51392b.getValue();
    }
}
