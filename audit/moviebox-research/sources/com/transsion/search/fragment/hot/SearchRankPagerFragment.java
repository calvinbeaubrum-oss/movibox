package com.transsion.search.fragment.hot;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.search.R$drawable;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.HotSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class SearchRankPagerFragment extends BaseFragment<bx.f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f57530b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57531a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchRankPagerFragment a(HotRankItem hotRankItem) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("hotRankItem", hotRankItem);
            SearchRankPagerFragment searchRankPagerFragment = new SearchRankPagerFragment();
            searchRankPagerFragment.setArguments(bundle);
            return searchRankPagerFragment;
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public bx.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.f fVarC = bx.f.c(inflater);
        Intrinsics.f(fVarC, "inflate(inflater)");
        return fVarC;
    }

    public final void h0() {
        List<GroupInfo> groups;
        List<HotSubject> items;
        if (this.f57531a) {
            return;
        }
        boolean zB = com.transsion.baselib.utils.g.f51315a.b();
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        if (hotRankItem2 != null && (items = hotRankItem2.getItems()) != null) {
            int i11 = 0;
            for (Object obj : items) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                jx.b.f68176a.m((HotSubject) obj, i11, hotRankItem2.getCategory(), hotRankItem2.getIndex(), zB);
                i11 = i12;
            }
        }
        if (hotRankItem2 != null && (groups = hotRankItem2.getGroups()) != null) {
            int i13 = 0;
            for (Object obj2 : groups) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    kotlin.collections.g.u();
                }
                jx.b.f68176a.l((GroupInfo) obj2, i13, hotRankItem2.getCategory(), hotRankItem2.getIndex(), zB);
                i13 = i14;
            }
        }
        this.f57531a = true;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        BaseQuickAdapter hVar;
        ImageView imageView;
        int i11;
        List<GroupInfo> groups;
        List<HotSubject> items;
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        if (hotRankItem2 == null) {
            return;
        }
        boolean zB = Intrinsics.b(hotRankItem2.getCategory(), HotRankItem.CATE_GROUP);
        if (zB || !((items = hotRankItem2.getItems()) == null || items.isEmpty())) {
            if (zB && ((groups = hotRankItem2.getGroups()) == null || groups.isEmpty())) {
                return;
            }
            bx.f mViewBinding = getMViewBinding();
            if (mViewBinding != null && (imageView = mViewBinding.f14481c) != null) {
                String category = hotRankItem2.getCategory();
                int iHashCode = category.hashCode();
                if (iHashCode != 2690) {
                    if (iHashCode != 74534672) {
                        if (iHashCode == 74710533 && category.equals(HotRankItem.CATE_MUSIC)) {
                            i11 = R$drawable.rank_type_music;
                        } else {
                            i11 = R$drawable.rank_type_community;
                        }
                    } else if (category.equals(HotRankItem.CATE_MOVIE)) {
                        i11 = R$drawable.rank_type_movie;
                    } else {
                        i11 = R$drawable.rank_type_community;
                    }
                } else if (category.equals(HotRankItem.CATE_TV)) {
                    i11 = R$drawable.rank_type_tv;
                } else {
                    i11 = R$drawable.rank_type_community;
                }
                imageView.setImageResource(i11);
            }
            bx.f mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (recyclerView = mViewBinding2.f14480b) == null) {
                return;
            }
            Resources resources = recyclerView.getResources();
            Intrinsics.f(resources, "resources");
            boolean zE = xw.f.e(resources);
            recyclerView.setLayoutManager(zE ? new NpaGridLayoutManager(recyclerView.getContext(), 2) : new LinearLayoutManager(recyclerView.getContext()));
            if (!Intrinsics.b(hotRankItem2.getCategory(), HotRankItem.CATE_TV) && !Intrinsics.b(hotRankItem2.getCategory(), HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                recyclerView.addItemDecoration(new ro.e(0.0f, 8.0f, 0.0f, 5, null));
            }
            if (zB) {
                hVar = new ex.c(hotRankItem2.getCategory(), hotRankItem2.getIndex());
                hVar.w0(hotRankItem2.getGroups());
            } else {
                hVar = new ex.h(hotRankItem2.getCategory(), hotRankItem2.getIndex(), zE);
                hVar.w0(hotRankItem2.getItems());
            }
            recyclerView.setAdapter(hVar);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
