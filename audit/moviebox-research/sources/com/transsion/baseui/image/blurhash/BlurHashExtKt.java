package com.transsion.baseui.image.blurhash;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.RequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BlurHashExtKt {
    public static final void a(final RequestBuilder<Drawable> requestBuilder, String blurString, int i11, int i12, BlurHash blurHash, final Function1<? super RequestBuilder<Drawable>, Unit> response) {
        Intrinsics.g(requestBuilder, "<this>");
        Intrinsics.g(blurString, "blurString");
        Intrinsics.g(blurHash, "blurHash");
        Intrinsics.g(response, "response");
        if (i11 == 0 || i12 == 0) {
            return;
        }
        blurHash.f(blurString, i11, i12, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.baseui.image.blurhash.BlurHashExtKt$blurPlaceHolder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BitmapDrawable bitmapDrawable) {
                invoke2(bitmapDrawable);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BitmapDrawable drawable) {
                Intrinsics.g(drawable, "drawable");
                requestBuilder.placeholder(drawable);
                response.invoke(requestBuilder);
            }
        });
    }
}
