package com.transsion.postdetail.ui.fragment;

import com.transsion.player.ui.ORPlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
public final class LocalVideoDetailFragment$prepare$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $progress;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$prepare$1(LocalVideoDetailFragment localVideoDetailFragment, Ref.LongRef longRef) {
        super(0);
        this.this$0 = localVideoDetailFragment;
        this.$progress = longRef;
    }

    public static final void b(LocalVideoDetailFragment this$0, Ref.LongRef progress) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(progress, "$progress");
        this$0.s3(progress.element);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        uo.b.a.f(uo.b.f78622a, this.this$0.f55673k, "-----> showStartAd end", false, 4, null);
        this.this$0.f55680n0 = System.currentTimeMillis();
        if (this.this$0.M.isEmpty()) {
            this.this$0.s3(this.$progress.element);
            return;
        }
        ORPlayerView oRPlayerView = this.this$0.f55677m;
        if (oRPlayerView != null) {
            final LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
            final Ref.LongRef longRef = this.$progress;
            oRPlayerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.p
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment$prepare$1.b(localVideoDetailFragment, longRef);
                }
            }, 200L);
        }
    }
}
