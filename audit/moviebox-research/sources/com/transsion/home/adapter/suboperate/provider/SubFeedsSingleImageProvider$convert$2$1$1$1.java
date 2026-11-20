package com.transsion.home.adapter.suboperate.provider;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.tn.lib.widget.R$string;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsSingleImageProvider$convert$2$1$1$1", f = "SubFeedsSingleImageProvider.kt", l = {}, m = "invokeSuspend")
public final class SubFeedsSingleImageProvider$convert$2$1$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ OperateItem $item;
    final /* synthetic */ Subject $subject;
    int label;
    final /* synthetic */ SubFeedsSingleImageProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFeedsSingleImageProvider$convert$2$1$1$1(SubFeedsSingleImageProvider subFeedsSingleImageProvider, OperateItem operateItem, Subject subject, Continuation<? super SubFeedsSingleImageProvider$convert$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = subFeedsSingleImageProvider;
        this.$item = operateItem;
        this.$subject = subject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubFeedsSingleImageProvider$convert$2$1$1$1(this.this$0, this.$item, this.$subject, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubFeedsSingleImageProvider$convert$2$1$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        MusicLikedFragmentViewModel musicLikedFragmentViewModelA = this.this$0.A();
        Subject feedsSubject = this.$item.getFeedsSubject();
        String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
        final Subject subject = this.$subject;
        final SubFeedsSingleImageProvider subFeedsSingleImageProvider = this.this$0;
        final OperateItem operateItem = this.$item;
        musicLikedFragmentViewModelA.B(subjectId, new Function1<Boolean, Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsSingleImageProvider$convert$2$1$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                List<OperateItem> listD;
                if (!z11) {
                    zp.b.f82110a.d(R$string.no_network_toast);
                    return;
                }
                HomeUtilsKt.b(subject, "opt_sub_feeds");
                SubFeedsSingleImageProvider subFeedsSingleImageProvider2 = subFeedsSingleImageProvider;
                BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = subFeedsSingleImageProvider2.c();
                subFeedsSingleImageProvider2.B((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? -1 : listD.indexOf(operateItem), subject, false);
            }
        });
        return Unit.f68710a;
    }
}
