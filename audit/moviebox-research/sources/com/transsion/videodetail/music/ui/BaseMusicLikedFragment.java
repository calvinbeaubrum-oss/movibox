package com.transsion.videodetail.music.ui;

import android.graphics.Rect;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$string;
import com.transsion.videodetail.music.bean.MusicLikedItemStateEnum;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLikedUITypeEnum;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import com.transsion.videodetail.music.widget.MusicLikedListLoadingView;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public abstract class BaseMusicLikedFragment extends LazyFragment<rz.e> implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public tz.a f59925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59926p = FragmentViewModelLazyKt.a(this, Reflection.b(MusicLikedFragmentViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.BaseMusicLikedFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.BaseMusicLikedFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MediaSource f59927q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.f {
        public a() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.lifecycle.e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.lifecycle.e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.d(this, owner);
            BaseMusicLikedFragment.this.c1().u("Activity_onResume()");
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStop(u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                outRect.top = f0.a(10.0f);
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null || childAdapterPosition != adapter.getItemCount() - 1) {
                return;
            }
            outRect.bottom = f0.a(16.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59929a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59929a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59929a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59929a.invoke(obj);
        }
    }

    public static final void h1(View view) {
    }

    public static final void j1(BaseMusicLikedFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        MusicLikedMultiItemEntity musicLikedMultiItemEntity = item instanceof MusicLikedMultiItemEntity ? (MusicLikedMultiItemEntity) item : null;
        if (musicLikedMultiItemEntity != null) {
            MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
            String subjectId = musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null;
            MusicLikedDbBean musicLikedDbBean2 = musicLikedMultiItemEntity.getMusicLikedDbBean();
            this$0.n1(subjectId, musicLikedDbBean2 != null ? musicLikedDbBean2.getPath() : null, true);
        }
    }

    public static final void k1(BaseMusicLikedFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.m1(adapter, view, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u1() {
        rz.e eVar = (rz.e) getMViewBinding();
        MusicLikedListLoadingView musicLikedListLoadingView = eVar != null ? eVar.f75803f : null;
        if (musicLikedListLoadingView != null) {
            musicLikedListLoadingView.setVisibility(0);
        }
        rz.e eVar2 = (rz.e) getMViewBinding();
        MusicLikedListEmptyView musicLikedListEmptyView = eVar2 != null ? eVar2.f75800b : null;
        if (musicLikedListEmptyView != null) {
            musicLikedListEmptyView.setVisibility(8);
        }
        rz.e eVar3 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView = eVar3 != null ? eVar3.f75805h : null;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        rz.e eVar4 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView2 = eVar4 != null ? eVar4.f75804g : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(8);
        }
        rz.e eVar5 = (rz.e) getMViewBinding();
        RecyclerView recyclerView = eVar5 != null ? eVar5.f75802d : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
        u1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final MusicLikedMultiItemEntity W0() {
        List<MusicLikedMultiItemEntity> listD;
        MediaItem mediaItemH;
        tz.a aVar = this.f59925o;
        if (aVar != null && (listD = aVar.D()) != null) {
            int i11 = 0;
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                MusicLikedMultiItemEntity musicLikedMultiItemEntity = (MusicLikedMultiItemEntity) obj;
                MediaSource mediaSource = this.f59927q;
                String subjectId = (mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId();
                MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
                if (TextUtils.equals(subjectId, musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null)) {
                    return musicLikedMultiItemEntity;
                }
                i11 = i12;
            }
        }
        return null;
    }

    public final int X0() {
        List<MusicLikedMultiItemEntity> listD;
        MediaItem mediaItemH;
        tz.a aVar = this.f59925o;
        if (aVar == null || (listD = aVar.D()) == null) {
            return -1;
        }
        int i11 = 0;
        for (Object obj : listD) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            MusicLikedMultiItemEntity musicLikedMultiItemEntity = (MusicLikedMultiItemEntity) obj;
            MediaSource mediaSource = this.f59927q;
            String subjectId = (mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId();
            MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
            if (TextUtils.equals(subjectId, musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null)) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    public final int Y0(String str) {
        List<MusicLikedMultiItemEntity> listD;
        tz.a aVar = this.f59925o;
        int i11 = -1;
        if (aVar != null && (listD = aVar.D()) != null) {
            int i12 = 0;
            for (Object obj : listD) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                MusicLikedDbBean musicLikedDbBean = ((MusicLikedMultiItemEntity) obj).getMusicLikedDbBean();
                if (TextUtils.equals(str, musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null)) {
                    i11 = i12;
                }
                i12 = i13;
            }
        }
        return i11;
    }

    public final MusicLikedMultiItemEntity Z0() {
        tz.a aVar;
        List<MusicLikedMultiItemEntity> listD;
        List<MusicLikedMultiItemEntity> listD2;
        tz.a aVar2 = this.f59925o;
        if ((aVar2 != null && (listD2 = aVar2.D()) != null && listD2.isEmpty()) || (aVar = this.f59925o) == null || (listD = aVar.D()) == null) {
            return null;
        }
        return listD.get(0);
    }

    public final MediaSource a1() {
        return this.f59927q;
    }

    public final tz.a b1() {
        return this.f59925o;
    }

    public final MusicLikedFragmentViewModel c1() {
        return (MusicLikedFragmentViewModel) this.f59926p.getValue();
    }

    public final String d1() {
        Object objM163constructorimpl;
        List<MusicLikedMultiItemEntity> listD;
        MusicLikedMultiItemEntity musicLikedMultiItemEntity;
        MusicLikedDbBean musicLikedDbBean;
        List<MusicLikedMultiItemEntity> listD2;
        MusicLikedMultiItemEntity musicLikedMultiItemEntity2;
        MusicLikedDbBean musicLikedDbBean2;
        List<MusicLikedMultiItemEntity> listD3;
        List<MusicLikedMultiItemEntity> listD4;
        tz.a aVar = this.f59925o;
        Object obj = null;
        if (aVar != null && (listD4 = aVar.D()) != null && listD4.size() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            int iX0 = X0();
            if (iX0 < 0) {
                return null;
            }
            int i11 = iX0 + 1;
            tz.a aVar2 = this.f59925o;
            if (i11 >= ((aVar2 == null || (listD3 = aVar2.D()) == null) ? 0 : listD3.size())) {
                tz.a aVar3 = this.f59925o;
                if (aVar3 == null || (listD2 = aVar3.D()) == null || (musicLikedMultiItemEntity2 = listD2.get(0)) == null || (musicLikedDbBean2 = musicLikedMultiItemEntity2.getMusicLikedDbBean()) == null) {
                    return null;
                }
                return musicLikedDbBean2.getSubjectId();
            }
            tz.a aVar4 = this.f59925o;
            objM163constructorimpl = Result.m163constructorimpl((aVar4 == null || (listD = aVar4.D()) == null || (musicLikedMultiItemEntity = listD.get(i11)) == null || (musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean()) == null) ? null : musicLikedDbBean.getSubjectId());
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl == null) {
                obj = objM163constructorimpl;
            } else {
                sz.a.f76638a.b(j0() + " --> getNext() --> it = " + thM166exceptionOrNullimpl);
            }
            return (String) obj;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final String e1(String str) {
        Object objM163constructorimpl;
        List<MusicLikedMultiItemEntity> listD;
        MusicLikedMultiItemEntity musicLikedMultiItemEntity;
        MusicLikedDbBean musicLikedDbBean;
        List<MusicLikedMultiItemEntity> listD2;
        MusicLikedMultiItemEntity musicLikedMultiItemEntity2;
        MusicLikedDbBean musicLikedDbBean2;
        List<MusicLikedMultiItemEntity> listD3;
        List<MusicLikedMultiItemEntity> listD4;
        tz.a aVar = this.f59925o;
        Object obj = null;
        if (aVar != null && (listD4 = aVar.D()) != null && listD4.size() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            int iY0 = Y0(str);
            if (iY0 < 0) {
                return null;
            }
            int i11 = iY0 + 1;
            tz.a aVar2 = this.f59925o;
            if (i11 >= ((aVar2 == null || (listD3 = aVar2.D()) == null) ? 0 : listD3.size())) {
                tz.a aVar3 = this.f59925o;
                if (aVar3 == null || (listD2 = aVar3.D()) == null || (musicLikedMultiItemEntity2 = listD2.get(0)) == null || (musicLikedDbBean2 = musicLikedMultiItemEntity2.getMusicLikedDbBean()) == null) {
                    return null;
                }
                return musicLikedDbBean2.getSubjectId();
            }
            tz.a aVar4 = this.f59925o;
            objM163constructorimpl = Result.m163constructorimpl((aVar4 == null || (listD = aVar4.D()) == null || (musicLikedMultiItemEntity = listD.get(i11)) == null || (musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean()) == null) ? null : musicLikedDbBean.getSubjectId());
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl == null) {
                obj = objM163constructorimpl;
            } else {
                sz.a.f76638a.b(j0() + " --> getNext() --> it = " + thM166exceptionOrNullimpl);
            }
            return (String) obj;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public abstract MusicLikedUITypeEnum f1();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public rz.e getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.e eVarC = rz.e.c(getLayoutInflater());
        Intrinsics.f(eVarC, "inflate(layoutInflater)");
        return eVarC;
    }

    public abstract String getPageName();

    /* JADX WARN: Multi-variable type inference failed */
    public final void i1() {
        RecyclerView recyclerView;
        rz.e eVar = (rz.e) getMViewBinding();
        if (eVar == null || (recyclerView = eVar.f75802d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new b());
        tz.a aVar = new tz.a(f1());
        this.f59925o = aVar;
        aVar.B0(new f9.d() { // from class: com.transsion.videodetail.music.ui.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                BaseMusicLikedFragment.j1(this.f59974a, baseQuickAdapter, view, i11);
            }
        });
        aVar.i(R$id.ivNextPlay);
        aVar.z0(new f9.b() { // from class: com.transsion.videodetail.music.ui.b
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                BaseMusicLikedFragment.k1(this.f59975a, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        MusicLikedListEmptyView musicLikedListEmptyView;
        FragmentActivity activity = getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity != null) {
            appCompatActivity.getLifecycle().a(new a());
        }
        rz.e eVar = (rz.e) getMViewBinding();
        if (eVar == null || (musicLikedListEmptyView = eVar.f75800b) == null) {
            return;
        }
        musicLikedListEmptyView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMusicLikedFragment.h1(view);
            }
        });
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        c1().y().j(this, new c(new Function1<List<MusicLikedMultiItemEntity>, Unit>() { // from class: com.transsion.videodetail.music.ui.BaseMusicLikedFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<MusicLikedMultiItemEntity> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MusicLikedMultiItemEntity> list) {
                List<MusicLikedMultiItemEntity> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    BaseMusicLikedFragment.this.t1();
                    tz.a aVarB1 = BaseMusicLikedFragment.this.b1();
                    if (aVarB1 != null) {
                        aVarB1.w0(null);
                        return;
                    }
                    return;
                }
                BaseMusicLikedFragment.this.s1();
                sz.a.f76638a.a(BaseMusicLikedFragment.this.j0() + " --> initViewModel() --> 增量更新收藏列表");
                tz.a aVarB2 = BaseMusicLikedFragment.this.b1();
                if (aVarB2 != null) {
                    DiffUtil.d dVarB = DiffUtil.b(new tz.b(aVarB2.D(), list));
                    Intrinsics.f(dVarB, "calculateDiff(MusicLiked…llback(adapter.data, it))");
                    aVarB2.x0(list);
                    dVarB.c(aVarB2);
                }
                tz.a aVarB3 = BaseMusicLikedFragment.this.b1();
                if (aVarB3 != null) {
                    aVarB3.w0(list2);
                }
                String str = list.size() + " " + BaseMusicLikedFragment.this.getResources().getString(R$string.music_videos);
                rz.e eVar = (rz.e) BaseMusicLikedFragment.this.getMViewBinding();
                AppCompatTextView appCompatTextView = eVar != null ? eVar.f75805h : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(str);
                }
                BaseMusicLikedFragment.this.l1();
                BaseMusicLikedFragment baseMusicLikedFragment = BaseMusicLikedFragment.this;
                baseMusicLikedFragment.p1(baseMusicLikedFragment.a1());
            }
        }));
    }

    public abstract void l1();

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    public abstract void m1(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i11);

    public abstract void n1(String str, String str2, boolean z11);

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    public abstract void o1(MediaSource mediaSource);

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        c1().u("onConnected()");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sz.a.f76638a.a(j0() + " --> onCreate() --> 音乐收藏列表");
        MusicFloatManager.f51403i.b().i(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MusicFloatManager.f51403i.b().x(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        super.onDisconnected();
        c1().u("onDisconnected()");
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.p(this, playError, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
        sz.a.f76638a.a(j0() + " --> onPlayerRelease()");
        q1(null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        q1(mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        q1(null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        q1(mediaSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p1(MediaSource mediaSource) {
        List<MusicLikedMultiItemEntity> listD;
        RecyclerView recyclerView;
        RecyclerView.m layoutManager;
        List<MusicLikedMultiItemEntity> listD2;
        int i11 = 0;
        if (mediaSource == null) {
            tz.a aVar = this.f59925o;
            if (aVar == null || (listD2 = aVar.D()) == null) {
                return;
            }
            for (Object obj : listD2) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                MusicLikedMultiItemEntity musicLikedMultiItemEntity = (MusicLikedMultiItemEntity) obj;
                if (musicLikedMultiItemEntity.getState() == MusicLikedItemStateEnum.PLAYING) {
                    musicLikedMultiItemEntity.setState(MusicLikedItemStateEnum.NONE);
                    tz.a aVar2 = this.f59925o;
                    if (aVar2 != null) {
                        aVar2.notifyItemChanged(i11, musicLikedMultiItemEntity);
                    }
                }
                i11 = i12;
            }
            return;
        }
        tz.a aVar3 = this.f59925o;
        if (aVar3 == null || (listD = aVar3.D()) == null) {
            return;
        }
        for (Object obj2 : listD) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            MusicLikedMultiItemEntity musicLikedMultiItemEntity2 = (MusicLikedMultiItemEntity) obj2;
            MusicLikedItemStateEnum state = musicLikedMultiItemEntity2.getState();
            MusicLikedItemStateEnum musicLikedItemStateEnum = MusicLikedItemStateEnum.PLAYING;
            if (state == musicLikedItemStateEnum) {
                musicLikedMultiItemEntity2.setState(MusicLikedItemStateEnum.NONE);
                tz.a aVar4 = this.f59925o;
                if (aVar4 != null) {
                    aVar4.notifyItemChanged(i11, musicLikedMultiItemEntity2);
                }
            }
            MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity2.getMusicLikedDbBean();
            String subjectId = musicLikedDbBean != null ? musicLikedDbBean.getSubjectId() : null;
            MediaItem mediaItemH = mediaSource.h();
            if (TextUtils.equals(subjectId, mediaItemH != null ? mediaItemH.getSubjectId() : null)) {
                musicLikedMultiItemEntity2.setState(musicLikedItemStateEnum);
                tz.a aVar5 = this.f59925o;
                if (aVar5 != null) {
                    aVar5.notifyItemChanged(i11, musicLikedMultiItemEntity2);
                }
                rz.e eVar = (rz.e) getMViewBinding();
                if (eVar != null && (recyclerView = eVar.f75802d) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                    layoutManager.scrollToPosition(i11);
                }
            }
            i11 = i13;
        }
    }

    public final void q1(MediaSource mediaSource) {
        MediaItem mediaItemH;
        MediaItem mediaItemH2;
        String subjectId = null;
        String subjectId2 = (mediaSource == null || (mediaItemH2 = mediaSource.h()) == null) ? null : mediaItemH2.getSubjectId();
        MediaSource mediaSource2 = this.f59927q;
        if (mediaSource2 != null && (mediaItemH = mediaSource2.h()) != null) {
            subjectId = mediaItemH.getSubjectId();
        }
        if (TextUtils.equals(subjectId2, subjectId)) {
            return;
        }
        this.f59927q = mediaSource;
        sz.a.f76638a.a(j0() + " --> refreshStateView() --> 音乐切换了");
        o1(mediaSource);
        p1(mediaSource);
    }

    public final void r1(String pageName, boolean z11) {
        Intrinsics.g(pageName, "pageName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", z11 ? WebConstants.FIELD_ITEM : "play_all");
        com.transsion.baselib.report.m.f51277a.m(pageName, "click", linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s1() {
        AppCompatTextView appCompatTextView;
        rz.e eVar = (rz.e) getMViewBinding();
        MusicLikedListLoadingView musicLikedListLoadingView = eVar != null ? eVar.f75803f : null;
        if (musicLikedListLoadingView != null) {
            musicLikedListLoadingView.setVisibility(8);
        }
        rz.e eVar2 = (rz.e) getMViewBinding();
        MusicLikedListEmptyView musicLikedListEmptyView = eVar2 != null ? eVar2.f75800b : null;
        if (musicLikedListEmptyView != null) {
            musicLikedListEmptyView.setVisibility(8);
        }
        rz.e eVar3 = (rz.e) getMViewBinding();
        RecyclerView recyclerView = eVar3 != null ? eVar3.f75802d : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        if (f1() == MusicLikedUITypeEnum.MUSIC_DETAIL) {
            rz.e eVar4 = (rz.e) getMViewBinding();
            AppCompatTextView appCompatTextView2 = eVar4 != null ? eVar4.f75805h : null;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            rz.e eVar5 = (rz.e) getMViewBinding();
            appCompatTextView = eVar5 != null ? eVar5.f75804g : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setVisibility(8);
            return;
        }
        rz.e eVar6 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView3 = eVar6 != null ? eVar6.f75805h : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setVisibility(0);
        }
        rz.e eVar7 = (rz.e) getMViewBinding();
        appCompatTextView = eVar7 != null ? eVar7.f75804g : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t1() {
        rz.e eVar = (rz.e) getMViewBinding();
        MusicLikedListEmptyView musicLikedListEmptyView = eVar != null ? eVar.f75800b : null;
        if (musicLikedListEmptyView != null) {
            musicLikedListEmptyView.setVisibility(0);
        }
        rz.e eVar2 = (rz.e) getMViewBinding();
        MusicLikedListLoadingView musicLikedListLoadingView = eVar2 != null ? eVar2.f75803f : null;
        if (musicLikedListLoadingView != null) {
            musicLikedListLoadingView.setVisibility(8);
        }
        rz.e eVar3 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView = eVar3 != null ? eVar3.f75805h : null;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        rz.e eVar4 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView2 = eVar4 != null ? eVar4.f75804g : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(8);
        }
        rz.e eVar5 = (rz.e) getMViewBinding();
        RecyclerView recyclerView = eVar5 != null ? eVar5.f75802d : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        i1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
