package com.transsion.web.activity;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.web.api.WebPageIdentity;
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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = WebPageIdentity.REPLACE_SERVICE)
@Metadata
public final class ARouterPathReplaceService implements PathReplaceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f60145a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.PathReplaceService
    public String forString(String path) {
        Intrinsics.g(path, "path");
        return path;
    }

    @Override // com.alibaba.android.arouter.facade.service.PathReplaceService
    public Uri forUri(Uri uri) {
        Intrinsics.g(uri, "uri");
        if (!Intrinsics.b(uri.getScheme(), GifImagePreviewActivity.PICTURE_SAVE)) {
            return uri;
        }
        String queryParameter = uri.getQueryParameter("type");
        if (queryParameter == null) {
            queryParameter = "";
        }
        if (!Intrinsics.b(uri.getScheme(), GifImagePreviewActivity.PICTURE_SAVE) || queryParameter.length() <= 0) {
            return uri;
        }
        Uri uriBuild = uri.buildUpon().path(queryParameter).build();
        Intrinsics.f(uriBuild, "uri.buildUpon().path(realPath).build()");
        return uriBuild;
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }
}
