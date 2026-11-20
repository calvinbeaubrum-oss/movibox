package com.transsion.ad.middle.nativead;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
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
public abstract class a {
    public Integer a() {
        return null;
    }

    public abstract Integer b();

    public Integer c() {
        return null;
    }

    public Integer d() {
        return null;
    }

    public final View e(Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(r(), (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(viewContext ?: Util…late(getLayoutId(), null)");
        return viewInflate;
    }

    public final com.transsion.ad.strategy.c f(Context context) {
        int iR = r();
        View viewE = e(context);
        Integer numT = t();
        Integer numX = x();
        Integer numQ = q();
        Integer numK = k();
        Integer numL = l();
        Integer numB = b();
        Integer numG = g();
        Integer numC = c();
        return new com.transsion.ad.strategy.c(Integer.valueOf(iR), viewE, numX, numQ, numK, numT, numL, v(), u(), w(), s(), n(), d(), a(), numB, numC, numG, m(), o(), i(), j(), h());
    }

    public abstract Integer g();

    public Integer h() {
        return null;
    }

    public Integer i() {
        return null;
    }

    public Integer j() {
        return null;
    }

    public abstract Integer k();

    public abstract Integer l();

    public Integer m() {
        return null;
    }

    public Integer n() {
        return null;
    }

    public Integer o() {
        return null;
    }

    public abstract ViewBinder p(com.transsion.ad.strategy.c cVar, TAdNativeInfo tAdNativeInfo);

    public abstract Integer q();

    public abstract int r();

    public Integer s() {
        return null;
    }

    public abstract Integer t();

    public Integer u() {
        return null;
    }

    public abstract Integer v();

    public Integer w() {
        return null;
    }

    public abstract Integer x();
}
