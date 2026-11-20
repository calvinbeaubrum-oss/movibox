package com.transsion.transfer.wifi.ui;

import androidx.appcompat.widget.LinearLayoutCompat;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WifiCreateActivity$loadDefaultData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WifiCreateActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiCreateActivity$loadDefaultData$1(WifiCreateActivity wifiCreateActivity) {
        super(0);
        this.this$0 = wifiCreateActivity;
    }

    public static final void b(WifiCreateActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.B0();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinearLayoutCompat root = ((ky.d) this.this$0.getMViewBinding()).getRoot();
        final WifiCreateActivity wifiCreateActivity = this.this$0;
        root.post(new Runnable() { // from class: com.transsion.transfer.wifi.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                WifiCreateActivity$loadDefaultData$1.b(wifiCreateActivity);
            }
        });
    }
}
