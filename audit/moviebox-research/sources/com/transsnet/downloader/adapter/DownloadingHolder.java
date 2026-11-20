package com.transsnet.downloader.adapter;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@Deprecated
@Metadata
public final class DownloadingHolder extends BaseViewHolder implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f60330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f60331d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f60332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f60333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f60334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f60335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ShapeableImageView f60336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f60337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TnTextView f60338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f60339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f60340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f60341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f60342p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f60343q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f60344r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f60345s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f60346t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f60347u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f60348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f60349w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d0.b f60350x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f60351y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f60352z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingHolder(View view, String pageFrom, float f11) {
        super(view);
        Intrinsics.g(view, "view");
        Intrinsics.g(pageFrom, "pageFrom");
        this.f60329b = pageFrom;
        this.f60330c = f11;
        this.f60341o = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.adapter.DownloadingHolder$downloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.manager.a invoke() {
                return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            }
        });
        this.f60342p = R$string.downloading_time_left;
        this.f60343q = R$string.download_status_waiting;
        this.f60344r = R$string.download_status_paused;
        this.f60345s = R$string.download_status_failed;
        this.f60346t = R$string.download_status_no_net;
        this.f60347u = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.adapter.DownloadingHolder$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f60348v = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.adapter.DownloadingHolder$mFloatApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFloatingApi invoke() {
                return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
            }
        });
        this.f60349w = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.adapter.DownloadingHolder$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).D0();
            }
        });
        this.f60340n = view;
        this.f60331d = (ConstraintLayout) getView(R$id.cl_root);
        this.f60336j = (ShapeableImageView) getView(R$id.iv_cover);
        this.f60335i = (TextView) getView(R$id.tv_name);
        this.f60332f = (ImageView) getView(R$id.iv_type);
        this.f60339m = (TextView) getView(R$id.tv_ep);
        this.f60334h = (ProgressBar) getView(R$id.pb_download);
        this.f60333g = (TextView) getView(R$id.tv_state_progress);
        this.f60337k = (ImageView) getView(R$id.iv_state_bg);
    }

    private final void A(DownloadBean downloadBean) {
        if (downloadBean.isShotTV()) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(downloadBean)).withInt("ep", downloadBean.getEp()).withLong("ms", downloadBean.getReadProgress()).navigation();
            return;
        }
        q().j(downloadBean);
        String strH = q().h(downloadBean);
        com.danikula.videocache.q.a("proxyUrl = " + strH);
        View view = this.f60340n;
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withString("extra_local_path", downloadBean.getPath()).withString("extra_url", downloadBean.getUrl()).withString("extra_proxy_url", strH).withString("extra_resource_id", downloadBean.getResourceId()).withString("extra_subject_id", downloadBean.getSubjectId()).withString("extra_name", downloadBean.getName()).withString("extra_post_id", downloadBean.getPostId()).withBoolean("extra_completed", false).withBoolean("extra_is_series", downloadBean.isSeries()).withString("extra_page_from", this.f60329b).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth()).navigation(appCompatActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a p() {
        return (rr.a) this.f60349w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a q() {
        return (com.transsnet.downloader.manager.a) this.f60341o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi r() {
        Object value = this.f60347u.getValue();
        Intrinsics.f(value, "<get-mAudioApi>(...)");
        return (IAudioApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi s() {
        Object value = this.f60348v.getValue();
        Intrinsics.f(value, "<get-mFloatApi>(...)");
        return (IFloatingApi) value;
    }

    public static final void t(e9.a aVar, DownloadBean downloadBean, DownloadingHolder this$0, int i11, View v11) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(this$0, "this$0");
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        DownloadBean downloadBean2 = (DownloadBean) aVar;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        Intrinsics.f(v11, "v");
        this$0.C(i11, v11, downloadBean);
    }

    public static final boolean u(e9.a aVar, DownloadBean downloadBean, DownloadingHolder this$0, int i11, View v11) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(this$0, "this$0");
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        DownloadBean downloadBean2 = (DownloadBean) aVar;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        Intrinsics.f(v11, "v");
        this$0.C(i11, v11, downloadBean);
        return true;
    }

    public static final boolean v(e9.a aVar, DownloadBean downloadBean, DownloadingHolder this$0, int i11, View v11) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(this$0, "this$0");
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        DownloadBean downloadBean2 = (DownloadBean) aVar;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        Intrinsics.f(v11, "v");
        this$0.C(i11, v11, downloadBean);
        return true;
    }

    public static final void w(e9.a aVar, DownloadBean downloadBean, DownloadingHolder this$0, View view) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(this$0, "this$0");
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        DownloadBean downloadBean2 = (DownloadBean) aVar;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        int status = downloadBean.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            this$0.q().F(downloadBean);
        } else {
            if (this$0.y(downloadBean)) {
                return;
            }
            com.transsnet.downloader.manager.a.C0624a.a(this$0.q(), downloadBean, false, 2, null);
        }
    }

    public static final void x(e9.a aVar, DownloadBean downloadBean, DownloadingHolder this$0, View view) {
        Intrinsics.g(downloadBean, "$downloadBean");
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        DownloadBean downloadBean2 = (DownloadBean) aVar;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        if (downloadBean.isVideo()) {
            this$0.A(downloadBean);
        } else {
            this$0.z(downloadBean);
        }
    }

    private final boolean y(DownloadBean downloadBean) {
        long jA;
        String rootPath = downloadBean.getRootPath();
        if (rootPath == null || rootPath.length() <= 0) {
            jA = com.blankj.utilcode.util.b0.a();
        } else {
            try {
                jA = com.blankj.utilcode.util.m.l(downloadBean.getRootPath());
            } catch (Throwable unused) {
                return false;
            }
        }
        Long size = downloadBean.getSize();
        if ((size != null ? size.longValue() : 0L) - downloadBean.getProgress() < jA) {
            return false;
        }
        zp.b.f82110a.d(com.transsion.baseui.R$string.insufficient_storage_available);
        return true;
    }

    private final void z(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new DownloadingHolder$openAudio$1(this, downloadBean, null), 3, null);
    }

    public final void B(int i11, int i12, DownloadBean downloadBean) {
        Object objO;
        TnTextView tnTextView;
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL == null) {
            downloadBeanL = downloadBean;
        }
        int i13 = R$color.text_03;
        if (i12 == 1 || i12 == 2 || i12 == 3) {
            long progress = downloadBeanL.getProgress();
            if (progress < 0) {
                progress = 0;
            }
            Long size = downloadBeanL.getSize();
            long jLongValue = size != null ? size.longValue() : 1L;
            long j11 = jLongValue <= 0 ? 1L : jLongValue;
            int i14 = (int) (((progress * 1.0f) / j11) * 100);
            ProgressBar progressBar = this.f60334h;
            if (progressBar != null) {
                progressBar.setSecondaryProgress(0);
            }
            ProgressBar progressBar2 = this.f60334h;
            if (progressBar2 != null) {
                progressBar2.setProgress(i14);
            }
            StringBuilder sb2 = new StringBuilder(tp.a.a(progress, this.f60330c == 12.0f ? 1 : 0));
            sb2.append("/");
            sb2.append(tp.a.a(j11, this.f60330c == 12.0f ? 1 : 0));
            TextView textView = this.f60333g;
            if (textView != null) {
                textView.setText(sb2.toString());
            }
        } else if (i12 == 4 || i12 == 6) {
            downloadBeanL.setCurrentDownloadSpeed(0L);
            long progress2 = downloadBeanL.getProgress();
            long j12 = progress2 < 0 ? 0L : progress2;
            Long size2 = downloadBeanL.getSize();
            long jLongValue2 = size2 != null ? size2.longValue() : 1L;
            long j13 = jLongValue2 <= 0 ? 1L : jLongValue2;
            int i15 = (int) (((j12 * 1.0f) / j13) * 100);
            ProgressBar progressBar3 = this.f60334h;
            if (progressBar3 != null) {
                progressBar3.setProgress(0);
            }
            ProgressBar progressBar4 = this.f60334h;
            if (progressBar4 != null) {
                progressBar4.setSecondaryProgress(i15);
            }
            StringBuilder sb3 = new StringBuilder(tp.a.a(j12, this.f60330c == 12.0f ? 1 : 0));
            sb3.append("/");
            sb3.append(tp.a.a(j13, this.f60330c == 12.0f ? 1 : 0));
            TextView textView2 = this.f60333g;
            if (textView2 != null) {
                textView2.setText(sb3.toString());
            }
        }
        if (i12 == 1 || i12 == 2) {
            if (downloadBeanL.isPreDownload()) {
                objO = Integer.valueOf(this.f60343q);
            } else {
                i13 = R$color.text_01;
                objO = o(downloadBeanL);
            }
        } else if (i12 == 3) {
            objO = Integer.valueOf(this.f60343q);
        } else if (i12 == 4) {
            objO = Integer.valueOf(this.f60344r);
            i13 = R$color.error_50;
        } else if (i12 != 6) {
            objO = null;
        } else {
            objO = Integer.valueOf((downloadBeanL.isNoNetError() || !com.tn.lib.util.networkinfo.f.f49475a.e()) ? this.f60346t : this.f60345s);
            i13 = R$color.error_50;
        }
        if (objO instanceof Integer) {
            TnTextView tnTextView2 = this.f60338l;
            if (tnTextView2 != null) {
                tnTextView2.setTextById(((Number) objO).intValue());
            }
        } else if ((objO instanceof String) && (tnTextView = this.f60338l) != null) {
            tnTextView.setTextWithString((CharSequence) objO);
        }
        TnTextView tnTextView3 = this.f60338l;
        if (tnTextView3 != null) {
            tnTextView3.setTextColor(z2.a.getColor(this.itemView.getContext(), i13));
        }
        switch (i12) {
            case 1:
            case 2:
            case 3:
                ImageView imageView = this.f60337k;
                if (imageView != null) {
                    imageView.setImageResource(R$mipmap.ic_download_pause);
                }
                break;
            case 4:
                ImageView imageView2 = this.f60337k;
                if (imageView2 != null) {
                    imageView2.setImageResource(R$mipmap.ic_download_downloading);
                }
                break;
            case 5:
                uo.b.f78622a.h(DownloadBaseRunnable.TAG, "DownloadingHolder refresh complete position=" + i11 + ",bean=" + downloadBeanL.getName() + " subjectId=" + downloadBeanL.getSubjectId() + ",resourceId=" + downloadBeanL.getResourceId(), true);
                d0.b bVar = this.f60350x;
                if (bVar != null) {
                    bVar.a(i11, 5);
                }
                break;
            case 6:
                ImageView imageView3 = this.f60337k;
                if (imageView3 != null) {
                    imageView3.setImageResource(R$mipmap.ic_download_downloading);
                }
                break;
        }
    }

    public final void C(int i11, View view, DownloadBean downloadBean) {
        PopupManager popupManager = new PopupManager(i11, downloadBean);
        popupManager.z(view, 2);
        d0.b bVar = this.f60350x;
        if (bVar != null) {
            popupManager.u(bVar);
        }
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void a(int i11, e9.a aVar) {
        if (aVar instanceof DownloadBean) {
            DownloadBean downloadBean = (DownloadBean) aVar;
            B(i11, downloadBean.getStatus(), downloadBean);
        }
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void c(d0.b listener) {
        Intrinsics.g(listener, "listener");
        this.f60350x = listener;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    @Override // com.transsnet.downloader.adapter.d0
    public void d(final int i11, final e9.a aVar) {
        if (aVar instanceof DownloadBean) {
            TextView textView = this.f60333g;
            if (textView != null) {
                float f11 = this.f60330c;
                if (f11 == 0.0f) {
                    f11 = 12.0f;
                }
                textView.setTextSize(2, f11);
            }
            TnTextView tnTextView = this.f60338l;
            if (tnTextView != null) {
                float f12 = this.f60330c;
                tnTextView.setTextSize(2, f12 != 0.0f ? f12 : 12.0f);
            }
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean = (DownloadBean) aVar;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            final DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
            if (downloadBeanL == null) {
                downloadBeanL = downloadBean;
            }
            String cover = downloadBeanL.getCover();
            ShapeableImageView shapeableImageView = this.f60336j;
            if (shapeableImageView != null && cover != null) {
                Context context = this.itemView.getContext();
                Intrinsics.f(context, "itemView.context");
                DownloadedHolderKt.a(context, shapeableImageView, cover, downloadBean.getThumbnail());
            }
            int type = downloadBeanL.getType();
            if (type == 2) {
                this.f60332f.setImageResource(com.transsion.baseui.R$mipmap.home_ic_movie_white);
            } else if (type == 3) {
                this.f60332f.setImageResource(downloadBean.isShotTV() ? com.transsion.baseui.R$mipmap.home_ic_short_tv_white : com.transsion.baseui.R$mipmap.home_ic_tv_white);
            } else if (type == 5 || type == 6) {
                this.f60332f.setImageResource(com.transsion.baseui.R$mipmap.home_ic_movie_white);
            } else {
                this.f60332f.setImageResource(com.transsion.baseui.R$mipmap.home_ic_audio_white);
            }
            TextView textView2 = this.f60335i;
            if (textView2 != null) {
                textView2.setText(downloadBean.getTitleNameAppendResolution());
            }
            if (downloadBean.getEpName().length() > 0) {
                so.c.k(this.f60339m);
                this.f60339m.setText(downloadBean.getEpName());
            } else {
                so.c.g(this.f60339m);
            }
            TextView textView3 = this.f60335i;
            if (textView3 != null) {
                textView3.setTag(downloadBeanL.getResourceId());
            }
            getView(R$id.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadingHolder.t(aVar, downloadBeanL, this, i11, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsnet.downloader.adapter.y
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return DownloadingHolder.u(aVar, downloadBeanL, this, i11, view);
                }
            });
            ShapeableImageView shapeableImageView2 = this.f60336j;
            if (shapeableImageView2 != null) {
                shapeableImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsnet.downloader.adapter.z
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return DownloadingHolder.v(aVar, downloadBeanL, this, i11, view);
                    }
                });
            }
            View view = this.f60340n;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.a0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DownloadingHolder.w(aVar, downloadBeanL, this, view2);
                    }
                });
            }
            ShapeableImageView shapeableImageView3 = this.f60336j;
            if (shapeableImageView3 != null) {
                shapeableImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DownloadingHolder.x(aVar, downloadBeanL, this, view2);
                    }
                });
            }
        }
    }

    public final String o(DownloadBean downloadBean) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = this.f60352z;
        long j12 = (jCurrentTimeMillis - j11) / ((long) 1000);
        if (j11 > 0 && j12 < 2 && downloadBean.getCurrentDownloadSpeed() > 0) {
            return tp.a.b(downloadBean.getCurrentDownloadSpeed(), this.f60330c != 12.0f ? 0 : 1, 0) + "/s";
        }
        this.f60352z = jCurrentTimeMillis;
        long progress = j12 <= 0 ? 0L : (downloadBean.getProgress() - this.f60351y) / j12;
        this.f60351y = downloadBean.getProgress();
        if (progress <= 0 && downloadBean.getCurrentDownloadSpeed() > 0) {
            progress = downloadBean.getCurrentDownloadSpeed();
        }
        if (progress <= 0) {
            return "0KB/s";
        }
        downloadBean.setCurrentDownloadSpeed(progress);
        return tp.a.b(progress, this.f60330c != 12.0f ? 0 : 1, 0) + "/s";
    }
}
