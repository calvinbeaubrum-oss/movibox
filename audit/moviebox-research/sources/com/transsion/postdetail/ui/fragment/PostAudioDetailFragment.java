package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.postdetail.R$dimen;
import com.transsion.postdetail.R$drawable;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public final class PostAudioDetailFragment extends PostDetailCommonFragment implements com.transsion.player.orplayer.e, IFloatingApi.a {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AudioBean f55721u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f55722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f55723w = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.postdetail.ui.fragment.PostAudioDetailFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f55724x = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsion.postdetail.ui.fragment.PostAudioDetailFragment$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f55725y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f55726z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PostAudioDetailFragment a(String str, boolean z11, String str2, PostSubjectItem postSubjectItem) {
            PostAudioDetailFragment postAudioDetailFragment = new PostAudioDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putBoolean("from_comment", z11);
            bundle.putString("rec_ops", str2);
            postAudioDetailFragment.setArguments(bundle);
            return postAudioDetailFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f55727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PostAudioDetailFragment f55728b;

        public b(Ref.LongRef longRef, PostAudioDetailFragment postAudioDetailFragment) {
            this.f55727a = longRef;
            this.f55728b = postAudioDetailFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
            if (z11) {
                this.f55727a.element = (long) (this.f55728b.f55722v * ((long) 1000) * (i11 / 100));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            IAudioApi iAudioApiO1 = this.f55728b.O1();
            if (iAudioApiO1 != null) {
                iAudioApiO1.seekTo(this.f55727a.element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi O1() {
        return (IAudioApi) this.f55723w.getValue();
    }

    private final IFloatingApi P1() {
        return (IFloatingApi) this.f55724x.getValue();
    }

    public static final void Q1(float f11, PostAudioDetailFragment this$0, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        if (i11 == 0 || Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            return;
        }
        if (Math.abs(i11) <= f11) {
            if (this$0.f55726z) {
                return;
            }
            this$0.f55726z = true;
            this$0.f55725y = false;
            this$0.X1();
            return;
        }
        if (this$0.f55725y) {
            return;
        }
        this$0.f55725y = true;
        this$0.f55726z = false;
        tv.m mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null) {
            if (com.transsion.baselib.utils.o.f51321a.a()) {
                mViewBinding.f77852v.setBackgroundResource(R$color.bg_01);
                mViewBinding.f77846p.setImageResource(R$mipmap.icon_white_back);
                mViewBinding.B.setTextColor(z2.a.getColor(this$0.requireActivity(), R$color.cl38));
            } else {
                mViewBinding.f77852v.setBackgroundResource(R$color.bg_01);
                mViewBinding.f77846p.setImageResource(R$mipmap.libui_ic_back_black);
                mViewBinding.B.setTextColor(z2.a.getColor(this$0.requireActivity(), R$color.text_01));
                mViewBinding.f77852v.setBackgroundResource(R$color.white);
            }
        }
    }

    public static final void R1(PostAudioDetailFragment this$0, AppCompatImageView this_apply, View view) {
        Unit unit;
        IAudioApi iAudioApiO1;
        IAudioApi iAudioApiO2;
        IAudioApi iAudioApiO3;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        AudioBean audioBean = this$0.f55721u;
        if (audioBean != null) {
            IAudioApi iAudioApiO4 = this$0.O1();
            boolean zD = iAudioApiO4 != null ? iAudioApiO4.D(audioBean) : false;
            IFloatingApi iFloatingApiP1 = this$0.P1();
            if (iFloatingApiP1 != null) {
                iFloatingApiP1.y(new WeakReference<>(this$0.getActivity()), audioBean);
            }
            if (zD) {
                IAudioApi iAudioApiO5 = this$0.O1();
                if (iAudioApiO5 == null || !iAudioApiO5.p1()) {
                    IAudioApi iAudioApiO6 = this$0.O1();
                    if (iAudioApiO6 == null || !iAudioApiO6.L()) {
                        IAudioApi iAudioApiO7 = this$0.O1();
                        if (iAudioApiO7 != null) {
                            iAudioApiO7.prepare();
                        }
                    } else {
                        AudioBean audioBean2 = this$0.f55721u;
                        if (audioBean2 != null && (iAudioApiO3 = this$0.O1()) != null) {
                            IAudioApi.a.a(iAudioApiO3, audioBean2, false, 2, null);
                        }
                    }
                    this_apply.setImageResource(R$drawable.post_icon_pro_pause);
                    com.transsion.postdetail.helper.a.t(com.transsion.postdetail.helper.a.f55063a, this$0.l1(), this$0.getPageName(), null, 4, null);
                } else {
                    IAudioApi iAudioApiO8 = this$0.O1();
                    if (iAudioApiO8 != null) {
                        iAudioApiO8.pause();
                    }
                    this_apply.setImageResource(R$drawable.post_icon_pro_play);
                    com.transsion.postdetail.helper.a.r(com.transsion.postdetail.helper.a.f55063a, this$0.l1(), this$0.getPageName(), null, 4, null);
                }
            } else {
                AudioBean audioBean3 = this$0.f55721u;
                if (audioBean3 != null && (iAudioApiO2 = this$0.O1()) != null) {
                    IAudioApi.a.a(iAudioApiO2, audioBean3, false, 2, null);
                }
                this_apply.setImageResource(R$drawable.post_icon_pro_pause);
                com.transsion.postdetail.helper.a.t(com.transsion.postdetail.helper.a.f55063a, this$0.l1(), this$0.getPageName(), null, 4, null);
            }
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            IAudioApi iAudioApiO9 = this$0.O1();
            if (iAudioApiO9 != null && iAudioApiO9.p1()) {
                IAudioApi iAudioApiO10 = this$0.O1();
                if (iAudioApiO10 != null) {
                    iAudioApiO10.pause();
                }
                this_apply.setImageResource(R$drawable.post_icon_pro_play);
                com.transsion.postdetail.helper.a.r(com.transsion.postdetail.helper.a.f55063a, this$0.l1(), this$0.getPageName(), null, 4, null);
                return;
            }
            IAudioApi iAudioApiO11 = this$0.O1();
            if (iAudioApiO11 == null || !iAudioApiO11.L()) {
                IAudioApi iAudioApiO12 = this$0.O1();
                if (iAudioApiO12 != null) {
                    iAudioApiO12.prepare();
                }
            } else {
                AudioBean audioBean4 = this$0.f55721u;
                if (audioBean4 != null && (iAudioApiO1 = this$0.O1()) != null) {
                    IAudioApi.a.a(iAudioApiO1, audioBean4, false, 2, null);
                }
            }
            this_apply.setImageResource(R$drawable.post_icon_pro_pause);
            com.transsion.postdetail.helper.a.t(com.transsion.postdetail.helper.a.f55063a, this$0.l1(), this$0.getPageName(), null, 4, null);
        }
    }

    private final void T1() {
        AppCompatSeekBar appCompatSeekBar;
        Ref.LongRef longRef = new Ref.LongRef();
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatSeekBar = mViewBinding.f77836f) == null) {
            return;
        }
        appCompatSeekBar.setOnSeekBarChangeListener(new b(longRef, this));
    }

    public final void S1() {
        Media media;
        List<Audio> audio;
        Group group;
        Subject subject;
        Subject subject2;
        PostSubjectItem postSubjectItemL1 = l1();
        if (postSubjectItemL1 == null || (media = postSubjectItemL1.getMedia()) == null || (audio = media.getAudio()) == null || audio.size() <= 0) {
            return;
        }
        Audio audio2 = audio.get(0);
        Long duration = audio2.getDuration();
        this.f55722v = duration != null ? duration.longValue() : 0L;
        String url = audio2.getUrl();
        if (url == null) {
            url = "";
        }
        String str = url;
        PostSubjectItem postSubjectItemL2 = l1();
        String coverUrl$default = postSubjectItemL2 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItemL2, false, 1, null) : null;
        Long duration2 = audio2.getDuration();
        Integer size = audio2.getSize();
        Long lValueOf = size != null ? Long.valueOf(size.intValue()) : null;
        String url2 = audio2.getUrl();
        PostSubjectItem postSubjectItemL3 = l1();
        String title = postSubjectItemL3 != null ? postSubjectItemL3.getTitle() : null;
        PostSubjectItem postSubjectItemL4 = l1();
        String content = postSubjectItemL4 != null ? postSubjectItemL4.getContent() : null;
        Integer bitrate = audio2.getBitrate();
        PostSubjectItem postSubjectItemL5 = l1();
        String rec_ops = postSubjectItemL5 != null ? postSubjectItemL5.getRec_ops() : null;
        PostSubjectItem postSubjectItemL6 = l1();
        String postId = postSubjectItemL6 != null ? postSubjectItemL6.getPostId() : null;
        PostSubjectItem postSubjectItemL7 = l1();
        String subjectId = (postSubjectItemL7 == null || (subject2 = postSubjectItemL7.getSubject()) == null) ? null : subject2.getSubjectId();
        PostSubjectItem postSubjectItemL8 = l1();
        String title2 = (postSubjectItemL8 == null || (subject = postSubjectItemL8.getSubject()) == null) ? null : subject.getTitle();
        PostSubjectItem postSubjectItemL9 = l1();
        AudioBean audioBean = new AudioBean(str, coverUrl$default, duration2, lValueOf, url2, title, content, bitrate, null, null, null, rec_ops, null, postId, subjectId, (postSubjectItemL9 == null || (group = postSubjectItemL9.getGroup()) == null) ? null : group.getGroupId(), 0, title2, 0, 0, 857856, null);
        this.f55721u = audioBean;
        IFloatingApi iFloatingApiP1 = P1();
        if (iFloatingApiP1 != null) {
            iFloatingApiP1.y(new WeakReference<>(getActivity()), audioBean);
        }
        IFloatingApi iFloatingApiP2 = P1();
        if (iFloatingApiP2 != null) {
            iFloatingApiP2.L0();
        }
        IFloatingApi iFloatingApiP3 = P1();
        if (iFloatingApiP3 != null) {
            iFloatingApiP3.h0(this);
        }
        IAudioApi iAudioApiO1 = O1();
        if (iAudioApiO1 != null) {
            IAudioApi.a.a(iAudioApiO1, audioBean, false, 2, null);
        }
        com.transsion.postdetail.helper.a.b(com.transsion.postdetail.helper.a.f55063a, l1(), getPageName(), null, 4, null);
    }

    public final void U1() {
        String thumbnail;
        Integer width;
        String url;
        AppCompatImageView appCompatImageView;
        Media media;
        Subject subject;
        Cover cover;
        Subject subject2;
        Cover cover2;
        Subject subject3;
        Cover cover3;
        Subject subject4;
        Cover cover4;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        PostSubjectItem postSubjectItemL1 = l1();
        Integer height = null;
        if (TextUtils.isEmpty(postSubjectItemL1 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItemL1, false, 1, null) : null)) {
            tv.m mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatImageView3 = mViewBinding.f77847q) != null) {
                appCompatImageView3.setImageResource(com.transsion.baseui.R$mipmap.default_audio_ic_9_16);
            }
            tv.m mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (appCompatImageView2 = mViewBinding2.f77844n) == null) {
                return;
            }
            so.c.g(appCompatImageView2);
            return;
        }
        PostSubjectItem postSubjectItemL2 = l1();
        if (postSubjectItemL2 == null || (media = postSubjectItemL2.getMedia()) == null) {
            thumbnail = "";
            width = 0;
            height = null;
            url = thumbnail;
        } else {
            Cover cover5 = media.getCover();
            url = cover5 != null ? cover5.getUrl() : null;
            Cover cover6 = media.getCover();
            thumbnail = cover6 != null ? cover6.getThumbnail() : null;
            Cover cover7 = media.getCover();
            Integer width2 = cover7 != null ? cover7.getWidth() : null;
            Cover cover8 = media.getCover();
            Integer height2 = cover8 != null ? cover8.getHeight() : null;
            if (TextUtils.isEmpty(url)) {
                PostSubjectItem postSubjectItemL3 = l1();
                url = (postSubjectItemL3 == null || (subject4 = postSubjectItemL3.getSubject()) == null || (cover4 = subject4.getCover()) == null) ? null : cover4.getUrl();
                PostSubjectItem postSubjectItemL4 = l1();
                thumbnail = (postSubjectItemL4 == null || (subject3 = postSubjectItemL4.getSubject()) == null || (cover3 = subject3.getCover()) == null) ? null : cover3.getThumbnail();
                PostSubjectItem postSubjectItemL5 = l1();
                width = (postSubjectItemL5 == null || (subject2 = postSubjectItemL5.getSubject()) == null || (cover2 = subject2.getCover()) == null) ? null : cover2.getWidth();
                PostSubjectItem postSubjectItemL6 = l1();
                if (postSubjectItemL6 != null && (subject = postSubjectItemL6.getSubject()) != null && (cover = subject.getCover()) != null) {
                    height = cover.getHeight();
                }
            } else {
                height = height2;
                width = width2;
            }
        }
        tv.m mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (appCompatImageView = mViewBinding3.f77847q) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = appCompatImageView.getContext();
        Intrinsics.f(context, "it.context");
        companion.o(context, appCompatImageView, url == null ? "" : url, (32704 & 8) != 0 ? R$color.skeleton : R$color.cl37, (32704 & 16) != 0 ? companion.d() : width != null ? width.intValue() : companion.d(), (32704 & 32) != 0 ? companion.c() : height != null ? height.intValue() : companion.c(), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : thumbnail == null ? "" : thumbnail, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    public final void V1() {
        IAudioApi iAudioApiO1 = O1();
        if (iAudioApiO1 == null || !iAudioApiO1.p1()) {
            return;
        }
        W1(null, this.f55721u);
    }

    public final void W1(String str, AudioBean audioBean) {
        Intent intent = new Intent();
        intent.putExtra(MimeTypes.BASE_TYPE_AUDIO, audioBean);
        intent.putExtra("id", str);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
    }

    public final void X1() {
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f77846p.setImageResource(R$mipmap.icon_white_back);
            mViewBinding.B.setTextColor(z2.a.getColor(requireActivity(), R$color.cl38));
            mViewBinding.f77852v.setBackgroundResource(com.tn.lib.widget.R$drawable.libui_mask_cl45_0p_to_30p);
        }
    }

    public final void Y1(long j11) {
        AppCompatImageView appCompatImageView;
        long j12 = this.f55722v * ((long) 1000);
        int i11 = (int) ((j11 / j12) * 100);
        tv.m mViewBinding = getMViewBinding();
        AppCompatSeekBar appCompatSeekBar = mViewBinding != null ? mViewBinding.f77836f : null;
        if (appCompatSeekBar != null) {
            appCompatSeekBar.setProgress(i11);
        }
        tv.m mViewBinding2 = getMViewBinding();
        AppCompatSeekBar appCompatSeekBar2 = mViewBinding2 != null ? mViewBinding2.f77836f : null;
        if (appCompatSeekBar2 != null) {
            appCompatSeekBar2.setProgress(i11);
        }
        String str = com.transsion.postdetail.util.i.d(j11) + "/" + com.transsion.postdetail.util.i.d(j12);
        tv.m mViewBinding3 = getMViewBinding();
        TextView textView = mViewBinding3 != null ? mViewBinding3.f77833b : null;
        if (textView != null) {
            textView.setText(str);
        }
        tv.m mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (appCompatImageView = mViewBinding4.f77835d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
    }

    @Override // com.transsion.room.api.IFloatingApi.a
    public void c() {
        AppCompatImageView appCompatImageView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77835d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_pro_play);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public String getPageName() {
        return "postdetail_audio";
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
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
        tv.m mViewBinding;
        AppCompatImageView appCompatImageView;
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        AudioBean audioBean = this.f55721u;
        if (audioBean != null) {
            IAudioApi iAudioApiO1 = O1();
            if (!Intrinsics.b(iAudioApiO1 != null ? Boolean.valueOf(iAudioApiO1.D(audioBean)) : null, Boolean.TRUE) || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f77835d) == null) {
                return;
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IAudioApi iAudioApiO1 = O1();
        if (iAudioApiO1 != null) {
            iAudioApiO1.removePlayerListener(this);
        }
        IFloatingApi iFloatingApiP1 = P1();
        if (iFloatingApiP1 != null) {
            iFloatingApiP1.m1(this);
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

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.p(this, playError, mediaSource);
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        AppCompatImageView appCompatImageView;
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        AudioBean audioBean = this.f55721u;
        if (audioBean != null) {
            IAudioApi iAudioApiO1 = O1();
            if (Intrinsics.b(iAudioApiO1 != null ? Boolean.valueOf(iAudioApiO1.D(audioBean)) : null, Boolean.TRUE)) {
                Y1(j11);
                return;
            }
        }
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77835d) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.post_icon_play);
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
        tv.m mViewBinding;
        AppCompatImageView appCompatImageView;
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        AudioBean audioBean = this.f55721u;
        if (audioBean != null) {
            IAudioApi iAudioApiO1 = O1();
            if (!Intrinsics.b(iAudioApiO1 != null ? Boolean.valueOf(iAudioApiO1.D(audioBean)) : null, Boolean.TRUE) || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f77835d) == null) {
                return;
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        tv.m mViewBinding;
        AppCompatImageView appCompatImageView;
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        AudioBean audioBean = this.f55721u;
        if (audioBean != null) {
            IAudioApi iAudioApiO1 = O1();
            if (!Intrinsics.b(iAudioApiO1 != null ? Boolean.valueOf(iAudioApiO1.D(audioBean)) : null, Boolean.TRUE) || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f77835d) == null) {
                return;
            }
            appCompatImageView.setImageResource(R$drawable.post_icon_pro_pause);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void p1() {
        Media media;
        List<Audio> audio;
        AppCompatImageView appCompatImageView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77847q) != null) {
            so.c.k(appCompatImageView);
        }
        PostSubjectItem postSubjectItemL1 = l1();
        if (postSubjectItemL1 != null && (media = postSubjectItemL1.getMedia()) != null && (audio = media.getAudio()) != null && (!audio.isEmpty())) {
            S1();
            U1();
        }
        tv.m mViewBinding2 = getMViewBinding();
        View view = mViewBinding2 != null ? mViewBinding2.D : null;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void q1() {
        AppBarLayout appBarLayout;
        tv.m mViewBinding = getMViewBinding();
        androidx.constraintlayout.widget.Group group = mViewBinding != null ? mViewBinding.f77843m : null;
        if (group != null) {
            group.setVisibility(0);
        }
        X1();
        final float dimension = getResources().getDimension(R$dimen.post_surface_height);
        tv.m mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appBarLayout = mViewBinding2.f77837g) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.postdetail.ui.fragment.w
            @Override // com.google.android.material.appbar.AppBarLayout.b
            public final void a(AppBarLayout appBarLayout2, int i11) {
                PostAudioDetailFragment.Q1(dimension, this, appBarLayout2, i11);
            }
        });
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void r1() {
        final AppCompatImageView appCompatImageView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77835d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostAudioDetailFragment.R1(this.f55936a, appCompatImageView, view);
                }
            });
        }
        IAudioApi iAudioApiO1 = O1();
        if (iAudioApiO1 != null) {
            iAudioApiO1.addPlayerListener(this);
        }
        T1();
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }
}
