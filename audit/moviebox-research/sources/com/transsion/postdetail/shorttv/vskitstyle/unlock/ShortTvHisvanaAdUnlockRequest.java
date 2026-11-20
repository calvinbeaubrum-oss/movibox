package com.transsion.postdetail.shorttv.vskitstyle.unlock;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import rx.d;
import rx.e;
import rx.f;

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
public final class ShortTvHisvanaAdUnlockRequest implements d {
    @Override // rx.d
    public void a(Context context, f params, e callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
        Intrinsics.g(callback, "callback");
        j.d(v.a((FragmentActivity) context), null, null, new ShortTvHisvanaAdUnlockRequest$unlock$1(context, callback, params, null), 3, null);
    }
}
