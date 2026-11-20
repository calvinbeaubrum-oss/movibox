package com.transsion.postdetail.viewmodel;

import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okio.Okio;

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
public final class RoomBuiltInHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56291a = "room_recommend.json";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56292b = "post_list.json";

    public final boolean b(String str, String str2, String str3) {
        try {
            if (new File(str + "/" + str2).exists()) {
                return true;
            }
            InputStream inputStreamOpen = Utils.a().getAssets().open(str3);
            Intrinsics.f(inputStreamOpen, "getApp().assets.open(assetsName)");
            FileOutputStream fileOutputStream = new FileOutputStream(str + "/" + str2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i11 = inputStreamOpen.read(bArr);
                if (i11 <= 0) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i11);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final void c(List<PostSubjectItem> list) {
        Intrinsics.g(list, "list");
        j.d(l0.a(w0.b()), null, null, new RoomBuiltInHelper$copyVideoFiles$1(list, this, null), 3, null);
    }

    public final String d(Context context) {
        Intrinsics.g(context, "context");
        try {
            InputStream it = context.getAssets().open(this.f56292b);
            Intrinsics.f(it, "it");
            return Okio.buffer(Okio.source(it)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }
}
