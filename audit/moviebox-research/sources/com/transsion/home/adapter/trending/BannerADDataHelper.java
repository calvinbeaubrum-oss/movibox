package com.transsion.home.adapter.trending;

import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class BannerADDataHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AdPlans f52220b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BannerADDataHelper f52219a = new BannerADDataHelper();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f52221c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f52222d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f52223e = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(BannerADDataHelper bannerADDataHelper, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function2 = null;
        }
        bannerADDataHelper.e(function2);
    }

    public final void e(Function2<? super AdPlans, ? super Integer, Unit> function2) {
        j.d(l0.a(w0.b()), null, null, new BannerADDataHelper$fetchData$1(null), 3, null);
        if (function2 != null) {
            function2.invoke(f52220b, Integer.valueOf(f52221c));
        }
    }

    public final String g() {
        return f52222d;
    }

    public final void h(String str) {
        Intrinsics.g(str, "<set-?>");
        f52222d = str;
    }
}
