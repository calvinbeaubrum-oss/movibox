package com.transsion.baseui.image;

import com.bumptech.glide.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f51399a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer[] f51400b = {120, 180, 240, 360, 540, 720, 1080};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LruCache<String, Integer> f51401c = new LruCache<>(600);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51402d = 8;

    public final String a(String url, int i11, boolean z11, boolean z12, int i12, boolean z13, boolean z14, int i13) {
        Intrinsics.g(url, "url");
        if (g(url)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(url);
        if (StringsKt__StringsKt.Q(url, "?", false, 2, null)) {
            sb2.append("&x-oss-process=image");
        } else {
            sb2.append("?x-oss-process=image");
        }
        sb2.append("/resize,w_");
        sb2.append(i11);
        if (z13) {
            sb2.append(",h_");
            sb2.append(i12);
        }
        if (z11) {
            sb2.append("/format,webp");
        }
        if (z12) {
            sb2.append("/quality,Q_50");
        }
        if (z14) {
            sb2.append("/blur,r_" + i13 + ",s_" + i13);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sBuilder.toString()");
        return string;
    }

    public final int c(String url) {
        Intrinsics.g(url, "url");
        Integer num = f51401c.get(url);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final String d(String url, int i11, boolean z11, boolean z12, int i12, boolean z13, boolean z14, boolean z15, int i13) {
        Intrinsics.g(url, "url");
        if (g(url)) {
            return url;
        }
        int iF = f(i11);
        Integer num = f51401c.get(url);
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue();
        if (iIntValue >= iF) {
            iF = iIntValue;
        }
        int i14 = (int) (((iF * 1.0f) / i11) * i12);
        if (iIntValue != iF && !z14) {
            f51401c.put(url, Integer.valueOf(iF));
        }
        return a(url, iF, z11, z12, i14, z13, z15, i13);
    }

    public final int f(int i11) {
        int iIntValue = ((Number) kotlin.collections.d.j0(f51400b)).intValue();
        for (Integer num : f51400b) {
            int iIntValue2 = num.intValue();
            if (i11 <= iIntValue2) {
                return iIntValue2;
            }
        }
        return iIntValue;
    }

    public final boolean g(String str) {
        return StringsKt__StringsKt.Q(str, "?x-oss-process=image", false, 2, null) || StringsKt__StringsKt.Q(str, "x-server-image=1", false, 2, null);
    }

    public final void h(String originUrl, int i11) {
        Intrinsics.g(originUrl, "originUrl");
        if (g(originUrl)) {
            return;
        }
        int iF = f(i11);
        Integer num = f51401c.get(originUrl);
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue();
        if (iIntValue >= iF) {
            iF = iIntValue;
        }
        if (iIntValue != iF) {
            f51401c.put(originUrl, Integer.valueOf(iF));
        }
    }
}
