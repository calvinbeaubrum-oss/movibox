package com.transsion.lib_web.zip.loader;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f53091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f53092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f53094e;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context context, List<? extends c> loaders) {
        Intrinsics.g(context, "context");
        Intrinsics.g(loaders, "loaders");
        this.f53090a = context;
        this.f53091b = loaders;
        this.f53092c = "";
        this.f53093d = "";
        this.f53094e = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebResourceResponse e(d dVar, String str, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = dVar.a();
        }
        return dVar.d(str, map);
    }

    public final Map<String, String> a() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.f53092c)) {
            map.put("Origin", this.f53092c);
        }
        if (!TextUtils.isEmpty(this.f53093d)) {
            map.put("Referer", this.f53093d);
        }
        if (!TextUtils.isEmpty(this.f53094e)) {
            map.put("User-Agent", this.f53094e);
        }
        return map;
    }

    public final String b() {
        Object next;
        Iterator<T> it = this.f53091b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((c) next) instanceof a));
        c cVar = (c) next;
        if (cVar != null) {
            return ((a) cVar).e();
        }
        return null;
    }

    public final WebResourceResponse c(WebResourceRequest webResourceRequest) {
        String strValueOf = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        Map<String, String> requestHeaders = webResourceRequest != null ? webResourceRequest.getRequestHeaders() : null;
        if (requestHeaders == null) {
            requestHeaders = a();
        }
        return d(strValueOf, requestHeaders);
    }

    public final WebResourceResponse d(String str, Map<String, String> headers) {
        Intrinsics.g(headers, "headers");
        if (str == null) {
            return null;
        }
        Iterator<T> it = this.f53091b.iterator();
        while (it.hasNext()) {
            WebResourceResponse webResourceResponseA = ((c) it.next()).a(str, headers);
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        }
        return null;
    }

    public final boolean f() {
        Object next;
        Iterator<T> it = this.f53091b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((c) next) instanceof a));
        c cVar = (c) next;
        if (cVar != null) {
            return ((a) cVar).d();
        }
        return false;
    }
}
