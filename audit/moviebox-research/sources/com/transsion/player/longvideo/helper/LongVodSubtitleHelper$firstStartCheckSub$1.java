package com.transsion.player.longvideo.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

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
public final class LongVodSubtitleHelper$firstStartCheckSub$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ LongVodSubtitleHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodSubtitleHelper$firstStartCheckSub$1(LongVodSubtitleHelper longVodSubtitleHelper) {
        super(1);
        this.this$0 = longVodSubtitleHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f68710a;
    }

    public final void invoke(boolean z11) {
        if (z11 || !this.this$0.f54374g.isEmpty()) {
            return;
        }
        this.this$0.f54368a.getRoot().post(new Runnable() { // from class: com.transsion.player.longvideo.helper.v
            @Override // java.lang.Runnable
            public final void run() {
                LongVodSubtitleHelper$firstStartCheckSub$1.c();
            }
        });
    }
}
