package com.transsion.audio.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$mipmap;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import io.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class EnFloatingView extends FloatingMagnetView implements View.OnClickListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fr.d f50869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<AudioBean> f50870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f50872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f50873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f50874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DownloadListBean f50875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final tr.a f50876p;

    /* JADX INFO: compiled from: source.java */
    public class a extends tr.a {
        public a() {
        }

        @Override // tr.a, tr.g
        public void e(@NonNull DownloadBean downloadBean, @Nullable String str) throws InterruptedException {
            if (downloadBean.isVideo()) {
                return;
            }
            AudioBean audioBeanM = com.transsion.audio.view.d.k().m();
            if (TextUtils.equals(audioBeanM.getResourceId(), downloadBean.getResourceId()) && audioBeanM.getUrl() != null && downloadBean.getPath() != null && audioBeanM.getUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                audioBeanM.setUrl(downloadBean.getPath());
                audioBeanM.setChangeToLocalPath(true);
                HistoryListManager.f50901e.b().f(audioBeanM);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            EnFloatingView.this.f50869i.f65238c.setVisibility(8);
            EnFloatingView.this.f50874n = Boolean.FALSE;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.f50874n = Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.f50869i.f65237b.setVisibility(0);
            EnFloatingView enFloatingView = EnFloatingView.this;
            enFloatingView.setLayoutParams(enFloatingView.q(true));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.f50869i.f65238c.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            EnFloatingView.this.f50869i.f65237b.setVisibility(8);
            EnFloatingView enFloatingView = EnFloatingView.this;
            enFloatingView.setLayoutParams(enFloatingView.q(false));
            EnFloatingView.this.f50874n = Boolean.FALSE;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.f50874n = Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(ViewGroup viewGroup);

        void b(ViewGroup viewGroup);
    }

    public EnFloatingView(@NonNull Context context) {
        this(context, R$layout.new_en_floating_view);
    }

    public EnFloatingView(@NonNull Context context, int i11) {
        super(context, null);
        this.f50870j = new ArrayList();
        this.f50871k = 0;
        this.f50874n = Boolean.FALSE;
        this.f50875o = null;
        this.f50876p = new a();
        View.inflate(context, i11, this);
        this.f50869i = fr.d.a((ConstraintLayout) findViewById(R$id.clRoot));
        r();
        s();
        setLayoutParams(q(true));
    }

    public final void A() {
        if (this.f50869i == null) {
            return;
        }
        CenterInside centerInside = new CenterInside();
        Glide.with(getContext().getApplicationContext()).load(Integer.valueOf(R$mipmap.libui_audio_playing_2)).optionalTransform(centerInside).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(centerInside)).into(this.f50869i.f65242h);
        this.f50869i.f65243i.setImageResource(R$mipmap.ic_audio_ctl_play);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.audio.view.FloatingMagnetView
    public void attach(Context context) {
        if (this.f50869i == null) {
            return;
        }
        HistoryListManager.a aVar = HistoryListManager.f50901e;
        aVar.b().i().j((u) context, new d0() { // from class: com.transsion.audio.view.a
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                this.f50889a.t((List) obj);
            }
        });
        aVar.b().o().j((u) getContext(), new d0() { // from class: com.transsion.audio.view.b
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                this.f50890a.u((DownloadListBean) obj);
            }
        });
        aVar.b().k();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void expanded() {
        fr.d dVar = this.f50869i;
        if (dVar == null) {
            return;
        }
        dVar.f65238c.setVisibility(8);
        this.f50869i.f65237b.setVisibility(0);
        setLayoutParams(q(true));
    }

    public void expandedAnimation() {
        if (this.f50869i == null || this.f50874n.booleanValue()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new b());
        this.f50869i.f65238c.setAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(-tp.f.f77260a.e(getContext()), 0.0f, 0.0f, 0.0f);
        translateAnimation.setAnimationListener(new c());
        translateAnimation.setDuration(300L);
        this.f50869i.f65237b.startAnimation(translateAnimation);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.startNow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public boolean isPackUp() {
        fr.d dVar = this.f50869i;
        return dVar != null && dVar.f65237b.getVisibility() == 8;
    }

    public final void o() {
        if (this.f50869i == null) {
            return;
        }
        AudioPlayer.a aVar = AudioPlayer.f50830i;
        if (aVar.a().H()) {
            aVar.a().R();
            this.f50869i.f65243i.setImageResource(R$mipmap.ic_audio_ctl_pause);
            return;
        }
        AudioBean audioBeanM = com.transsion.audio.view.d.k().m();
        if (audioBeanM.isChangeToLocalPath()) {
            audioBeanM.setChangeToLocalPath(false);
            aVar.a().J(audioBeanM);
        } else {
            aVar.a().I();
        }
        this.f50869i.f65243i.setImageResource(R$mipmap.ic_audio_ctl_play);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.iv_play) {
            o();
            return;
        }
        if (view.getId() == R$id.iv_next) {
            w();
            return;
        }
        if (view.getId() == R$id.iv_history) {
            z();
        } else if (view.getId() == R$id.iv_remove) {
            x();
        } else if (view.getId() == R$id.clPackUp) {
            expandedAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onProgress(int i11) {
        fr.d dVar = this.f50869i;
        if (dVar == null) {
            return;
        }
        dVar.f65245k.setProgress(i11);
        y(false);
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onSlideTheLeft() {
        packUpAnimation();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onStateChanged(int i11) {
        if (i11 == 3) {
            A();
            return;
        }
        if (i11 == 4 || i11 == 5) {
            v();
        } else {
            if (i11 != 6) {
                return;
            }
            v();
            w();
        }
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onViewClick() {
        AudioBean audioBeanM;
        Activity activityG = RoomActivityLifecycleCallbacks.f51239a.g();
        if (activityG == null || activityG.getClass().getSimpleName().contains("PostDetailActivity") || (audioBeanM = com.transsion.audio.view.d.k().m()) == null) {
            return;
        }
        if (TextUtils.isEmpty(audioBeanM.getPostId())) {
            zp.b.f82110a.e("This page is unavailable");
        } else {
            com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, "audio_list").withString("id", audioBeanM.getPostId()).withString("media_type", MediaType.AUDIO.getValue()).withBoolean("from_comment", false).navigation();
        }
    }

    public final int p() {
        return (int) TypedValue.applyDimension(1, 80.0f, Resources.getSystem().getDisplayMetrics());
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void packUp() {
        fr.d dVar = this.f50869i;
        if (dVar == null) {
            return;
        }
        dVar.f65238c.setVisibility(0);
        this.f50869i.f65237b.setVisibility(8);
        setLayoutParams(q(false));
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void packUpAnimation() {
        fr.d dVar = this.f50869i;
        if (dVar == null || dVar.f65237b.getVisibility() == 8 || this.f50874n.booleanValue() || com.transsion.audio.view.d.k().o().booleanValue()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new d());
        this.f50869i.f65238c.setAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -tp.f.f77260a.e(getContext()), 0.0f, 0.0f);
        translateAnimation.setAnimationListener(new e());
        translateAnimation.setDuration(300L);
        this.f50869i.f65237b.startAnimation(translateAnimation);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.startNow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void prepare() {
        AudioBean audioBeanM = com.transsion.audio.view.d.k().m();
        if (audioBeanM == null || this.f50869i == null) {
            return;
        }
        this.f50873m = audioBeanM.getCover();
        Long readProcess = audioBeanM.getReadProcess();
        Long duration = audioBeanM.getDuration();
        if (readProcess == null || duration == null) {
            return;
        }
        if (duration.longValue() <= 0) {
            duration = 1L;
        }
        this.f50869i.f65245k.setProgress(n.a((readProcess.longValue() / duration.longValue()) * 100));
        this.f50869i.f65241g.setImageResource(this.f50870j.size() - 1 > this.f50871k ? R$mipmap.ic_audio_next_enable : R$mipmap.ic_audio_next_disable);
        y(true);
    }

    public final FrameLayout.LayoutParams q(boolean z11) {
        FrameLayout.LayoutParams layoutParams = z11 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        layoutParams.setMargins(0, layoutParams.topMargin, layoutParams.rightMargin, p());
        return layoutParams;
    }

    public final void r() {
        HistoryListManager.f50901e.b().k();
    }

    public final void s() {
        fr.d dVar = this.f50869i;
        if (dVar != null) {
            dVar.f65243i.setOnClickListener(this);
            this.f50869i.f65241g.setOnClickListener(this);
            this.f50869i.f65240f.setOnClickListener(this);
            this.f50869i.f65244j.setOnClickListener(this);
            this.f50869i.f65238c.setOnClickListener(this);
        }
        com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).f(this.f50876p);
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void setOnOptionListener(f fVar) {
        this.f50872l = fVar;
    }

    public final /* synthetic */ void t(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.f50870j = list;
        this.f50871k = 0;
        this.f50869i.f65241g.setImageResource(list.size() + (-1) > this.f50871k ? R$mipmap.ic_audio_next_enable : R$mipmap.ic_audio_next_disable);
    }

    public final /* synthetic */ void u(DownloadListBean downloadListBean) {
        if (downloadListBean == null || downloadListBean.getItems() == null || downloadListBean.getItems().size() <= 0) {
            return;
        }
        this.f50875o = downloadListBean;
    }

    public final void v() {
        fr.d dVar = this.f50869i;
        if (dVar == null) {
            return;
        }
        dVar.f65243i.setImageResource(R$mipmap.ic_audio_ctl_pause);
        this.f50869i.f65242h.setImageResource(R$mipmap.ic_audio_right);
    }

    public final void w() {
        DownloadListBean downloadListBean;
        AudioPlayer.f50830i.a().R();
        AudioBean audioBeanM = com.transsion.audio.view.d.k().m();
        if (audioBeanM == null || TextUtils.isEmpty(audioBeanM.getSubjectId()) || (downloadListBean = this.f50875o) == null || downloadListBean.getItems().isEmpty()) {
            int size = this.f50870j.size() - 1;
            int i11 = this.f50871k;
            if (size > i11) {
                List<AudioBean> list = this.f50870j;
                int i12 = i11 + 1;
                this.f50871k = i12;
                AudioBean audioBean = list.get(i12);
                if (audioBean != null) {
                    ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(audioBean, true);
                    return;
                }
                return;
            }
            return;
        }
        List<DownloadItem> items = this.f50875o.getItems();
        int i13 = 0;
        while (true) {
            if (i13 >= items.size()) {
                i13 = -1;
                break;
            } else if (TextUtils.equals(audioBeanM.getPostId(), items.get(i13).getPostId())) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 == -1 || i13 >= items.size() - 2) {
            return;
        }
        DownloadItem downloadItem = items.get(i13 + 1);
        String url = downloadItem.getUrl();
        String url2 = this.f50875o.getCover().getUrl();
        if (TextUtils.isEmpty(url)) {
            url = "";
        }
        ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(new AudioBean(url, url2, 0L, downloadItem.getSize(), downloadItem.getUrl(), downloadItem.getName(), "", 0, 0L, 0L, "", "", downloadItem.getResourceId(), downloadItem.getPostId(), this.f50875o.getSubjectId(), this.f50875o.getGroupId(), 0, "", downloadItem.getSe(), downloadItem.getEp()), true);
    }

    public final void x() {
        f fVar = this.f50872l;
        if (fVar != null) {
            fVar.a(this);
        }
        AudioPlayer.f50830i.a().p();
        com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).v(this.f50876p);
    }

    public final void y(boolean z11) {
        String str;
        AudioBean audioBeanM = com.transsion.audio.view.d.k().m();
        if (audioBeanM == null || this.f50869i == null) {
            return;
        }
        try {
            String title = audioBeanM.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = audioBeanM.getDesc();
            }
            this.f50869i.f65246l.setText(title);
            Long readProcess = audioBeanM.getReadProcess();
            Long duration = audioBeanM.getDuration();
            if (readProcess != null && duration != null) {
                if (z11) {
                    str = "00:00/00:00";
                } else {
                    str = hr.a.a(readProcess.longValue()) + "/" + hr.a.a(duration.longValue());
                }
                this.f50869i.f65247m.setText(str);
            }
        } catch (Exception unused) {
        }
    }

    public final void z() {
        f fVar = this.f50872l;
        if (fVar != null) {
            fVar.b(this);
        }
    }
}
