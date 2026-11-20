package com.transsion.postdetail.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.control.SubjectVideoPagerChangeControl;
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
public final class ShortTvVideoFragment$observeRemoveVideo$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ShortTvVideoFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoFragment$observeRemoveVideo$1(ShortTvVideoFragment shortTvVideoFragment) {
        super(1);
        this.this$0 = shortTvVideoFragment;
    }

    public static final void b(ShortTvVideoFragment this$0, Integer it) {
        RecyclerView.a0 a0VarFindViewHolderForAdapterPosition;
        RecyclerView recyclerView;
        Integer numValueOf;
        Intrinsics.g(this$0, "this$0");
        tv.s mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77925d) == null) {
            a0VarFindViewHolderForAdapterPosition = null;
        } else {
            com.transsion.postdetail.ui.adapter.g gVar = this$0.f55818m;
            if (gVar != null) {
                int iK = gVar.K();
                Intrinsics.f(it, "it");
                numValueOf = Integer.valueOf(iK + it.intValue());
            } else {
                numValueOf = it;
            }
            Intrinsics.f(numValueOf, "mAdapter?.headerLayoutCount?.plus(it) ?: it");
            a0VarFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(numValueOf.intValue());
        }
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this$0.f55817l;
        if (subjectVideoPagerChangeControl != null) {
            Intrinsics.f(it, "it");
            subjectVideoPagerChangeControl.d(it.intValue(), true, a0VarFindViewHolderForAdapterPosition != null ? a0VarFindViewHolderForAdapterPosition.itemView : null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Integer it) {
        RecyclerView recyclerView;
        try {
            Intrinsics.f(it, "it");
            if (it.intValue() >= 0) {
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.this$0.f55817l;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.p();
                }
                com.transsion.postdetail.ui.adapter.g gVar = this.this$0.f55818m;
                if (gVar != null) {
                    gVar.k0(it.intValue());
                }
                tv.s mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding == null || (recyclerView = mViewBinding.f77925d) == null) {
                    return;
                }
                final ShortTvVideoFragment shortTvVideoFragment = this.this$0;
                recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortTvVideoFragment$observeRemoveVideo$1.b(shortTvVideoFragment, it);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
