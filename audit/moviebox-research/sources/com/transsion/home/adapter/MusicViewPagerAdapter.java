package com.transsion.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.videodetail.music.ui.MusicTabLikedFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class MusicViewPagerAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewPager2 f52000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f52001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f52002k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicViewPagerAdapter(ViewPager2 viewPager2, int i11, String str, Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f52000i = viewPager2;
        this.f52001j = i11;
        this.f52002k = str;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        if (i11 == 0) {
            return SubTabFragment.f52541r.b(this.f52001j, this.f52002k);
        }
        if (i11 != 1) {
            return new MusicTabLikedFragment();
        }
        MusicTabLikedFragment musicTabLikedFragment = new MusicTabLikedFragment();
        musicTabLikedFragment.S1(new Function0<Unit>() { // from class: com.transsion.home.adapter.MusicViewPagerAdapter$createFragment$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewPager2 viewPager2 = this.this$0.f52000i;
                if (viewPager2 == null) {
                    return;
                }
                viewPager2.setCurrentItem(0);
            }
        });
        return musicTabLikedFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
