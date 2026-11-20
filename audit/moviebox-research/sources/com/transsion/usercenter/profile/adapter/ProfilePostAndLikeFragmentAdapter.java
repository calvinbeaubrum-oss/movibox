package com.transsion.usercenter.profile.adapter;

import android.os.Bundle;
import androidx.collection.a;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class ProfilePostAndLikeFragmentAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f59568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a<Integer, Fragment> f59569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f59570k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilePostAndLikeFragmentAdapter(String str, Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f59568i = str;
        this.f59569j = new a<>();
        this.f59570k = LazyKt__LazyJVMKt.b(new Function0<IMovieDetailService>() { // from class: com.transsion.usercenter.profile.adapter.ProfilePostAndLikeFragmentAdapter$mMovieDetailService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IMovieDetailService invoke() {
                return (IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class);
            }
        });
    }

    private final IMovieDetailService e() {
        return (IMovieDetailService) this.f59570k.getValue();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("source", i11);
        bundle.putString("userId", this.f59568i);
        Fragment fragmentQ1 = e().q1(bundle, ProfileSubjectListViewModel.class);
        this.f59569j.put(Integer.valueOf(i11), fragmentQ1);
        return fragmentQ1;
    }

    public final void d(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("source", i11);
        bundle.putString("userId", this.f59568i);
        Fragment fragment = this.f59569j.get(Integer.valueOf(i11));
        if (fragment == null || fragment.isStateSaved()) {
            return;
        }
        fragment.setArguments(bundle);
        e().o0(fragment);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
