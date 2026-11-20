package com.transsion.moviedetail.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.helper.PreloadHelperKt;
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
public final class SubjectListFragment$initLiveData$1$2 extends Lambda implements Function1<PostSubjectBean, Unit> {
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$initLiveData$1$2(SubjectListFragment subjectListFragment) {
        super(1);
        this.this$0 = subjectListFragment;
    }

    public static final void b(SubjectListFragment this$0, PostSubjectBean postSubjectBean) {
        Intrinsics.g(this$0, "this$0");
        this$0.V1(postSubjectBean);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PostSubjectBean postSubjectBean) {
        invoke2(postSubjectBean);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final PostSubjectBean postSubjectBean) {
        RecyclerView recyclerView;
        com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        this.this$0.F0();
        this.this$0.f53565p = postSubjectBean;
        PreloadHelperKt.c(this.this$0.getContext(), postSubjectBean != null ? postSubjectBean.getItems() : null);
        if (!this.this$0.f53575z) {
            this.this$0.f53575z = true;
            this.this$0.V1(postSubjectBean);
            return;
        }
        tu.g mViewBinding = this.this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77481b) == null) {
            return;
        }
        final SubjectListFragment subjectListFragment = this.this$0;
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.q0
            @Override // java.lang.Runnable
            public final void run() {
                SubjectListFragment$initLiveData$1$2.b(subjectListFragment, postSubjectBean);
            }
        }, 300L);
    }
}
