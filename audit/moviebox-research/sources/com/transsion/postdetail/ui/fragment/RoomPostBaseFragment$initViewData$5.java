package com.transsion.postdetail.ui.fragment;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
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
public final class RoomPostBaseFragment$initViewData$5 extends Lambda implements Function1<PostSubjectItem, Unit> {
    final /* synthetic */ RoomPostBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostBaseFragment$initViewData$5(RoomPostBaseFragment roomPostBaseFragment) {
        super(1);
        this.this$0 = roomPostBaseFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(RoomPostBaseFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        tv.p pVar = (tv.p) this$0.getMViewBinding();
        if (pVar == null || (recyclerView = pVar.f77888b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PostSubjectItem postSubjectItem) {
        invoke2(postSubjectItem);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PostSubjectItem postSubjectItem) {
        uo.b.a.f(uo.b.f78622a, this.this$0.l1(), this.this$0.getClass().getSimpleName() + "--Publish get detail result,  id:" + (postSubjectItem != null ? postSubjectItem.getPostId() : null), false, 4, null);
        if (postSubjectItem == null) {
            return;
        }
        postSubjectItem.setDistanceStr("<1m");
        com.transsion.postdetail.ui.adapter.d dVarB1 = this.this$0.b1();
        if (dVarB1 != null) {
            dVarB1.j(0, postSubjectItem);
        }
        Handler handlerE1 = this.this$0.e1();
        final RoomPostBaseFragment roomPostBaseFragment = this.this$0;
        handlerE1.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.q0
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostBaseFragment$initViewData$5.b(roomPostBaseFragment);
            }
        });
    }
}
