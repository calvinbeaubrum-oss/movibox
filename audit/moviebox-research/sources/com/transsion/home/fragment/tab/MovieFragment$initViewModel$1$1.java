package com.transsion.home.fragment.tab;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.FilterItems;
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
public final class MovieFragment$initViewModel$1$1 extends Lambda implements Function1<BaseDto<FilterItems>, Unit> {
    final /* synthetic */ MovieFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieFragment$initViewModel$1$1(MovieFragment movieFragment) {
        super(1);
        this.this$0 = movieFragment;
    }

    public static final void b(MovieFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.hideLoading();
        this$0.L1();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BaseDto<FilterItems> baseDto) {
        invoke2(baseDto);
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BaseDto<FilterItems> baseDto) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (baseDto == null) {
            return;
        }
        if (!Intrinsics.b(baseDto.getCode(), "0")) {
            lt.l lVar = (lt.l) this.this$0.getMViewBinding();
            if (lVar == null || (swipeRefreshLayout = lVar.f70475h) == null) {
                return;
            }
            final MovieFragment movieFragment = this.this$0;
            swipeRefreshLayout.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.r
                @Override // java.lang.Runnable
                public final void run() {
                    MovieFragment$initViewModel$1$1.b(movieFragment);
                }
            }, 200L);
            return;
        }
        MovieFragment movieFragment2 = this.this$0;
        movieFragment2.f52514m = baseDto.getData();
        movieFragment2.f1(0);
        movieFragment2.w1();
        movieFragment2.u1();
        com.transsion.home.adapter.a aVar = movieFragment2.f52510i;
        if (aVar == null) {
            return;
        }
        aVar.I0(movieFragment2.k1(movieFragment2.f52515n));
    }
}
