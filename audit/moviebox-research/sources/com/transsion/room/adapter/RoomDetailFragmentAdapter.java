package com.transsion.room.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.room.viewmodel.RoomHotViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.PublishEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class RoomDetailFragmentAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f57122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f57123j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDetailFragmentAdapter(String str, Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f57122i = str;
        this.f57123j = LazyKt__LazyJVMKt.b(new Function0<IMovieDetailService>() { // from class: com.transsion.room.adapter.RoomDetailFragmentAdapter$mMovieDetailService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IMovieDetailService invoke() {
                return (IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class);
            }
        });
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        Bundle bundle = new Bundle();
        PostRankType postRankType = i11 == 0 ? PostRankType.POST_RANK_TYPE_HOT : PostRankType.POST_RANK_TYPE_NEW;
        bundle.putString("subject_id", this.f57122i);
        bundle.putSerializable("rank_type", postRankType);
        Fragment fragmentQ1 = d().q1(bundle, RoomHotViewModel.class);
        AnonymousClass1 anonymousClass1 = new Function1<PublishEvent, Unit>() { // from class: com.transsion.room.adapter.RoomDetailFragmentAdapter.createFragment.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                invoke2(publishEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishEvent value) {
                Intrinsics.g(value, "value");
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(fragmentQ1, name, Lifecycle.State.CREATED, w0.c().q(), false, anonymousClass1);
        return fragmentQ1;
    }

    public final IMovieDetailService d() {
        return (IMovieDetailService) this.f57123j.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
