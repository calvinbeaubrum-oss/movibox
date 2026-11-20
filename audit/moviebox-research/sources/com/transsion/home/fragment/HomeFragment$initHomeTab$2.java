package com.transsion.home.fragment;

import android.os.Handler;
import android.os.Looper;
import com.transsion.home.bean.AppTab;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class HomeFragment$initHomeTab$2 extends Lambda implements Function1<AppTab, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initHomeTab$2(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public static final void b(HomeFragment this$0, AppTab appTab) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.L0(appTab);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppTab appTab) {
        invoke2(appTab);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final AppTab appTab) {
        uo.b.a.f(uo.b.f78622a, "HomeFragment", "LanguageRestart homeTabFromNet2 = " + appTab, false, 4, null);
        Handler handler = new Handler(Looper.getMainLooper());
        final HomeFragment homeFragment = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment$initHomeTab$2.b(homeFragment, appTab);
            }
        }, 100L);
    }
}
