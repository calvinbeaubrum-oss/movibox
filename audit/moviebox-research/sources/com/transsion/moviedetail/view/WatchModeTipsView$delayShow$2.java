package com.transsion.moviedetail.view;

import com.transsion.baselib.report.launch.RoomAppMMKV;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
public final class WatchModeTipsView$delayShow$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ WatchModeTipsView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView$delayShow$2(WatchModeTipsView watchModeTipsView) {
        super(0);
        this.this$0 = watchModeTipsView;
    }

    public static final void b(WatchModeTipsView this$0) {
        Intrinsics.g(this$0, "this$0");
        so.c.k(this$0);
        RoomAppMMKV.f51271a.a().putBoolean("watch_mode_tips", true);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Runnable invoke() {
        final WatchModeTipsView watchModeTipsView = this.this$0;
        return new Runnable() { // from class: com.transsion.moviedetail.view.p
            @Override // java.lang.Runnable
            public final void run() {
                WatchModeTipsView$delayShow$2.b(watchModeTipsView);
            }
        };
    }
}
