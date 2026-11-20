package com.transsion.audio.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class RecentListFragment extends BaseFragment<fr.b> implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f50796f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.audio.adapter.c f50797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f50798b = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.audio.fragment.RecentListFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50799c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f50800d = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.audio.adapter.c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.transsion.audio.adapter.c f50802b;

        public b(com.transsion.audio.adapter.c cVar) {
            this.f50802b = cVar;
        }

        @Override // com.transsion.audio.adapter.c.a
        public void a(AudioBean item) {
            Intrinsics.g(item, "item");
            RecentListFragment.this.k0(this.f50802b, item);
        }

        @Override // com.transsion.audio.adapter.c.a
        public void b(AudioBean item) {
            Intrinsics.g(item, "item");
            if (!AudioPlayer.f50830i.a().w(item)) {
                Long readProcess = item.getReadProcess();
                long jLongValue = readProcess != null ? readProcess.longValue() : 0L;
                Long duration = item.getDuration();
                boolean z11 = jLongValue >= (duration != null ? duration.longValue() : -500L);
                if (item.getStatus() == 6 || z11) {
                    item.setReadProcess(0L);
                }
                RecentListFragment.this.f50800d.set(false);
                item.setStatus(3);
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(item, false);
            } else if (item.getStatus() == 3) {
                RecentListFragment.this.f50800d.set(true);
                item.setStatus(4);
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).stop();
            } else {
                RecentListFragment.this.f50800d.set(false);
                item.setStatus(3);
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).prepare();
            }
            RecentListFragment recentListFragment = RecentListFragment.this;
            Long readProcess2 = item.getReadProcess();
            recentListFragment.onProgress(readProcess2 != null ? readProcess2.longValue() : 0L, new MediaSource(item.getAudioUrl(), item.getAudioUrl(), 0, null, null, 28, null));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f50803a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f50803a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f50803a;
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
            this.f50803a.invoke(obj);
        }
    }

    private final IAudioApi l0() {
        return (IAudioApi) this.f50798b.getValue();
    }

    private final void n0() {
        HistoryListManager.f50901e.b().i().j(this, new c(new Function1<List<? extends AudioBean>, Unit>() { // from class: com.transsion.audio.fragment.RecentListFragment$initData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AudioBean> list) {
                invoke2((List<AudioBean>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AudioBean> list) {
                this.this$0.r0(list);
            }
        }));
    }

    public static final void p0(BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof AudioBean) {
            AudioBean audioBean = (AudioBean) item;
            if (TextUtils.isEmpty(audioBean.getPostId())) {
                zp.b.f82110a.e("This page is unavailable");
            } else {
                com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, "audio_list").withString("id", audioBean.getPostId()).withString("media_type", MediaType.AUDIO.getValue()).withBoolean("video_load_more", true).navigation();
            }
        }
    }

    private final void q0() {
        HistoryListManager.f50901e.b().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(List<AudioBean> list) {
        com.transsion.audio.adapter.c cVar = null;
        if (list == null || list.isEmpty()) {
            com.transsion.audio.adapter.c cVar2 = this.f50797a;
            if (cVar2 == null) {
                Intrinsics.y("mAdapter");
                cVar2 = null;
            }
            h9.f.t(cVar2.Q(), false, 1, null);
            return;
        }
        com.transsion.audio.adapter.c cVar3 = this.f50797a;
        if (cVar3 == null) {
            Intrinsics.y("mAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.w0(list);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        o0();
        n0();
    }

    public final void k0(com.transsion.audio.adapter.c cVar, AudioBean audioBean) {
        if (audioBean.getStatus() == 3) {
            AudioPlayer.f50830i.a().R();
        }
        com.transsion.audio.adapter.c cVar2 = this.f50797a;
        if (cVar2 == null) {
            Intrinsics.y("mAdapter");
            cVar2 = null;
        }
        cVar2.notifyItemRemoved(cVar.P(audioBean));
        cVar.D().remove(audioBean);
        HistoryListManager.f50901e.b().h(audioBean);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        q0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public fr.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        fr.b bVarC = fr.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }

    public final void o0() {
        RecyclerView recyclerView;
        Fragment parentFragment = getParentFragment();
        Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.audio.fragment.AudioBottomSheetFragment");
        AudioBottomSheetFragment audioBottomSheetFragment = (AudioBottomSheetFragment) parentFragment;
        fr.b mViewBinding = getMViewBinding();
        com.transsion.audio.adapter.c cVar = null;
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (recyclerView = mViewBinding.f65228b) == null) ? null : recyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = audioBottomSheetFragment.B0() - f0.a(48.0f);
        }
        fr.b mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView2 = mViewBinding2 != null ? mViewBinding2.f65228b : null;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        com.transsion.audio.adapter.c cVar2 = new com.transsion.audio.adapter.c(new ArrayList());
        cVar2.B0(new f9.d() { // from class: com.transsion.audio.fragment.c
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RecentListFragment.p0(baseQuickAdapter, view, i11);
            }
        });
        cVar2.M0(new b(cVar2));
        this.f50797a = cVar2;
        fr.b mViewBinding3 = getMViewBinding();
        RecyclerView recyclerView3 = mViewBinding3 != null ? mViewBinding3.f65228b : null;
        if (recyclerView3 == null) {
            return;
        }
        com.transsion.audio.adapter.c cVar3 = this.f50797a;
        if (cVar3 == null) {
            Intrinsics.y("mAdapter");
        } else {
            cVar = cVar3;
        }
        recyclerView3.setAdapter(cVar);
    }

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
        com.transsion.audio.adapter.c cVar = this.f50797a;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i11 = 0;
        for (Object obj : cVar.D()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.equals(mediaSource != null ? mediaSource.j() : null, audioBean.getAudioUrl())) {
                audioBean.setStatus(6);
                com.transsion.audio.adapter.c cVar2 = this.f50797a;
                if (cVar2 == null) {
                    Intrinsics.y("mAdapter");
                    cVar2 = null;
                }
                cVar2.notifyItemChanged(i11, audioBean);
                this.f50799c = mediaSource != null ? mediaSource.j() : null;
            }
            i11 = i12;
        }
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

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IAudioApi iAudioApiL0 = l0();
        if (iAudioApiL0 != null) {
            iAudioApiL0.removePlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        zp.b.f82110a.e(String.valueOf(errorInfo.getErrorMessage()));
        com.transsion.audio.adapter.c cVar = this.f50797a;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i11 = 0;
        for (Object obj : cVar.D()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (audioBean.getStatus() == 3) {
                audioBean.setStatus(7);
                com.transsion.audio.adapter.c cVar2 = this.f50797a;
                if (cVar2 == null) {
                    Intrinsics.y("mAdapter");
                    cVar2 = null;
                }
                cVar2.notifyItemChanged(i11, audioBean);
            }
            i11 = i12;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        if (TextUtils.equals(this.f50799c, mediaSource != null ? mediaSource.j() : null)) {
            return;
        }
        com.transsion.audio.adapter.c cVar = this.f50797a;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i11 = 0;
        for (Object obj : cVar.D()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.equals(this.f50799c, audioBean.getAudioUrl())) {
                audioBean.setStatus(4);
                com.transsion.audio.adapter.c cVar2 = this.f50797a;
                if (cVar2 == null) {
                    Intrinsics.y("mAdapter");
                    cVar2 = null;
                }
                cVar2.notifyItemChanged(i11, audioBean);
                this.f50799c = mediaSource != null ? mediaSource.j() : null;
            }
            i11 = i12;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        com.transsion.audio.adapter.c cVar = this.f50797a;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i11 = 0;
        for (Object obj : cVar.D()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.isEmpty(this.f50799c)) {
                this.f50799c = mediaSource != null ? mediaSource.j() : null;
            }
            if (!TextUtils.equals(this.f50799c, mediaSource != null ? mediaSource.j() : null) && TextUtils.equals(this.f50799c, audioBean.getAudioUrl())) {
                audioBean.setStatus(4);
                com.transsion.audio.adapter.c cVar2 = this.f50797a;
                if (cVar2 == null) {
                    Intrinsics.y("mAdapter");
                    cVar2 = null;
                }
                cVar2.notifyItemChanged(i11, audioBean);
                this.f50799c = mediaSource != null ? mediaSource.j() : null;
            }
            if (TextUtils.equals(mediaSource != null ? mediaSource.j() : null, audioBean.getAudioUrl()) && !this.f50800d.get()) {
                audioBean.setReadProcess(Long.valueOf(j11));
                audioBean.setStatus(3);
                com.transsion.audio.adapter.c cVar3 = this.f50797a;
                if (cVar3 == null) {
                    Intrinsics.y("mAdapter");
                    cVar3 = null;
                }
                cVar3.notifyItemChanged(i11, audioBean);
            }
            i11 = i12;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IAudioApi iAudioApiL0 = l0();
        if (iAudioApiL0 != null) {
            iAudioApiL0.addPlayerListener(this);
        }
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }
}
