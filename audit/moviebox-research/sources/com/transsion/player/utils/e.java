package com.transsion.player.utils;

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
    public static final e f54871a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer[] f54872b = {120, 180, 240, 360, 540, 720, 1080};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LruCache<String, Integer> f54873c = new LruCache<>(600);

    public final String a(String url, int i11, boolean z11, boolean z12, int i12, boolean z13) {
        Intrinsics.g(url, "url");
        if (e(url)) {
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
        String string = sb2.toString();
        Intrinsics.f(string, "sBuilder.toString()");
        return string;
    }

    public final String b(String url, int i11, boolean z11, boolean z12, int i12, boolean z13, boolean z14) {
        Intrinsics.g(url, "url");
        if (e(url)) {
            return url;
        }
        int iD = d(i11);
        Integer num = f54873c.get(url);
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue();
        if (iIntValue >= iD) {
            iD = iIntValue;
        }
        int i13 = (int) (((iD * 1.0f) / i11) * i12);
        if (iIntValue != iD && !z14) {
            f54873c.put(url, Integer.valueOf(iD));
        }
        return a(url, iD, z11, z12, i13, z13);
    }

    public final int d(int i11) {
        int iIntValue = ((Number) kotlin.collections.d.j0(f54872b)).intValue();
        for (Integer num : f54872b) {
            int iIntValue2 = num.intValue();
            if (i11 <= iIntValue2) {
                return iIntValue2;
            }
        }
        return iIntValue;
    }

    public final boolean e(String str) {
        return StringsKt__StringsKt.Q(str, "?x-oss-process=image", false, 2, null) || StringsKt__StringsKt.Q(str, "x-server-image=1", false, 2, null);
    }
}
