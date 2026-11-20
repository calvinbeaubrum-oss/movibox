package com.transsion.postdetail.ui.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
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
public final class LocalVideoDetailFragment$setSubtitle$1$1$1$3$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ List<vx.a> $subtitleList;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$setSubtitle$1$1$1$3$1(List<vx.a> list, LocalVideoDetailFragment localVideoDetailFragment) {
        super(1);
        this.$subtitleList = list;
        this.this$0 = localVideoDetailFragment;
    }

    public static final void b(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.O2();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f68710a;
    }

    public final void invoke(boolean z11) {
        tv.j mViewBinding;
        ConstraintLayout root;
        if (z11) {
            return;
        }
        List<vx.a> list = this.$subtitleList;
        if ((list != null && !list.isEmpty()) || (mViewBinding = this.this$0.getMViewBinding()) == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        final LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
        root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.s
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment$setSubtitle$1$1$1$3$1.b(localVideoDetailFragment);
            }
        });
    }
}
