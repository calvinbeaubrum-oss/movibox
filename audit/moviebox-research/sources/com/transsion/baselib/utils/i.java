package com.transsion.baselib.utils;

import android.app.Application;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
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
public final class i {
    public static final String a(long j11) {
        if (1 <= j11 && j11 < 1000) {
            return String.valueOf(j11);
        }
        if (1000 <= j11 && j11 < 1000000) {
            return (j11 / ((long) 1000)) + CampaignEx.JSON_KEY_AD_K;
        }
        if (j11 < 1000000) {
            return "0";
        }
        return (j11 / ((long) 1000000)) + "m";
    }

    public static final <T> int b(List<? extends T> list, T t11) {
        Intrinsics.g(list, "<this>");
        Iterator<? extends T> it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            if (it.next() == t11) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    public static final boolean c(Uri uri) {
        Intrinsics.g(uri, "<this>");
        return Intrinsics.b(uri.getScheme(), "https") || Intrinsics.b(uri.getScheme(), HttpHost.DEFAULT_SCHEME_NAME);
    }

    public static final void d(String str, String extraParam) {
        Intrinsics.g(str, "<this>");
        Intrinsics.g(extraParam, "extraParam");
        Uri uri = Uri.parse(str + extraParam);
        Intrinsics.f(uri, "uri");
        if (c(uri)) {
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", str).navigation();
            return;
        }
        try {
            String queryParameter = uri.getQueryParameter("miniapp_deeplink");
            if (queryParameter != null && queryParameter.length() != 0) {
                uo.b.f78622a.c(WebConstants.FIELD_DEEPLINK, "openDeeplink--Deeplink is mini app, " + queryParameter, true);
                cs.a aVar = cs.a.f62808a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                aVar.b(applicationA, queryParameter);
                return;
            }
        } catch (Throwable th2) {
            uo.b.a.j(uo.b.f78622a, "Deeplink", "openMiniApp:" + th2, false, 4, null);
            th2.printStackTrace();
        }
        try {
            com.alibaba.android.arouter.launcher.a.d().a(com.transsion.baselib.helper.b.f51184a.d(uri)).navigation();
        } catch (Throwable th3) {
            uo.b.a.j(uo.b.f78622a, "Deeplink", "openDeeplink:" + th3, false, 4, null);
            th3.printStackTrace();
        }
    }

    public static /* synthetic */ void e(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "";
        }
        d(str, str2);
    }

    public static final String f(String str) {
        Intrinsics.g(str, "<this>");
        try {
            URI uri = new URI(str);
            return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
        } catch (Throwable unused) {
            return str;
        }
    }
}
