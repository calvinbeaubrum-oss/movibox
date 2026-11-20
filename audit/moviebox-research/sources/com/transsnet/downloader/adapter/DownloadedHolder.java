package com.transsnet.downloader.adapter;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.snackbar.Snackbar;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.MediaSource;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$color;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import java.io.File;
import java.lang.ref.SoftReference;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public final class DownloadedHolder extends BaseViewHolder implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f60308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function5<Integer, View, DownloadBean, Integer, d0.b, Unit> f60309d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f60310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f60311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f60313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f60314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TnTextView f60315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TnTextView f60316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TnTextView f60317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f60318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ProgressBar f60319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f60320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f60321q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f60322r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f60323s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d0.b f60324t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f60325a;

        public a(long j11) {
            this.f60325a = j11;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            if (System.currentTimeMillis() - this.f60325a < 500) {
                com.transsnet.downloader.viewmodel.c.f61276a.C();
            }
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends rw.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioBean f60326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DownloadBean f60327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DownloadedHolder f60328d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AudioBean audioBean, DownloadBean downloadBean, DownloadedHolder downloadedHolder, SoftReference<Object> softReference) {
            super(softReference);
            this.f60326b = audioBean;
            this.f60327c = downloadBean;
            this.f60328d = downloadedHolder;
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(MediaSource mediaSource) {
            this.f60326b.setStatus(6);
            this.f60327c.setAudioStatus(6);
            DownloadedHolder downloadedHolder = this.f60328d;
            SoftReference<Object> softReferenceA = a();
            AudioBean audioBean = this.f60326b;
            String resourceId = this.f60327c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60327c.getUrl();
            }
            downloadedHolder.G(softReferenceA, audioBean, resourceId);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j11, MediaSource mediaSource) {
            this.f60326b.setReadProcess(Long.valueOf(j11));
            DownloadedHolder downloadedHolder = this.f60328d;
            SoftReference<Object> softReferenceA = a();
            AudioBean audioBean = this.f60326b;
            String resourceId = this.f60327c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60327c.getUrl();
            }
            downloadedHolder.G(softReferenceA, audioBean, resourceId);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(MediaSource mediaSource) {
            this.f60326b.setStatus(4);
            this.f60327c.setAudioStatus(4);
            DownloadedHolder downloadedHolder = this.f60328d;
            SoftReference<Object> softReferenceA = a();
            AudioBean audioBean = this.f60326b;
            String resourceId = this.f60327c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60327c.getUrl();
            }
            downloadedHolder.G(softReferenceA, audioBean, resourceId);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            this.f60326b.setStatus(3);
            this.f60327c.setAudioStatus(3);
            Long duration = this.f60326b.getDuration();
            if (duration != null && duration.longValue() == 0) {
                AudioBean audioBean = this.f60326b;
                IAudioApi iAudioApiR = this.f60328d.r();
                audioBean.setDuration(iAudioApiR != null ? Long.valueOf(iAudioApiR.U0()) : null);
            }
            DownloadedHolder downloadedHolder = this.f60328d;
            SoftReference<Object> softReferenceA = a();
            AudioBean audioBean2 = this.f60326b;
            String resourceId = this.f60327c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f60327c.getUrl();
            }
            downloadedHolder.G(softReferenceA, audioBean2, resourceId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadedHolder(View view, String pageFrom, float f11, Function5<? super Integer, ? super View, ? super DownloadBean, ? super Integer, ? super d0.b, Unit> popSaveListener) {
        super(view);
        Intrinsics.g(view, "view");
        Intrinsics.g(pageFrom, "pageFrom");
        Intrinsics.g(popSaveListener, "popSaveListener");
        this.f60307b = pageFrom;
        this.f60308c = f11;
        this.f60309d = popSaveListener;
        this.f60311g = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f60312h = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$mFloatApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFloatingApi invoke() {
                return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
            }
        });
        this.f60313i = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).D0();
            }
        });
        this.f60310f = view;
        this.f60314j = (TextView) getView(R$id.tv_name);
        this.f60315k = (TnTextView) getView(R$id.tv_process);
        this.f60318n = getView(R$id.layout_no_file_tips);
        this.f60319o = (ProgressBar) getView(R$id.progress_bar);
        this.f60320p = getView(R$id.v_series_top_bg);
        this.f60321q = getView(R$id.v_series_top_bg_2);
        this.f60316l = (TnTextView) getView(R$id.tv_file_size);
        this.f60317m = (TnTextView) getView(R$id.tv_save_file_name);
        this.f60322r = (TextView) getView(R$id.tv_save_to);
        this.f60323s = (TextView) getView(R$id.tv_ep);
    }

    public static final void E(Button this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.performClick();
    }

    public static final void F(DownloadedHolder this$0, Context context, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        this$0.p(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a q() {
        return (rr.a) this.f60313i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi r() {
        return (IAudioApi) this.f60311g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi s() {
        return (IFloatingApi) this.f60312h.getValue();
    }

    public static final void u(DownloadedHolder this$0, int i11, e9.a aVar, View v11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(v11, "v");
        this$0.x(i11, v11, (DownloadBean) aVar);
    }

    public static final boolean v(DownloadedHolder this$0, int i11, e9.a aVar, View v11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(v11, "v");
        this$0.x(i11, v11, (DownloadBean) aVar);
        return true;
    }

    public static final void w(e9.a aVar, DownloadedHolder this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        DownloadBean downloadBean = (DownloadBean) aVar;
        if (downloadBean.getStatus() == 10) {
            this$0.A(downloadBean);
        } else {
            this$0.y(downloadBean, i11);
        }
    }

    private final void y(DownloadBean downloadBean, int i11) {
        String name;
        String subjectName;
        if (downloadBean.getType() == 1) {
            if (downloadBean.isFileExist()) {
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new DownloadedHolder$openMedia$1(this, downloadBean, null), 3, null);
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
            View view = this.f60310f;
            Intrinsics.d(view);
            Context context = view.getContext();
            Intrinsics.f(context, "view!!.context");
            localVideoNotExistUtil.n(context, downloadBean, i11);
            return;
        }
        String path = downloadBean.getPath();
        if (path != null && path.length() != 0) {
            File file = new File(path);
            Log.e("yy", "exists:" + file.exists() + "  canRead" + file.canRead() + "    " + path);
            boolean zS = PermissionUtils.s("android.permission.WRITE_EXTERNAL_STORAGE");
            if (file.exists() && !file.canRead() && !zS) {
                Context context2 = this.itemView.getContext();
                Intrinsics.f(context2, "context");
                D(context2);
                return;
            }
        }
        String path2 = downloadBean.getPath();
        String str = path2 == null ? "" : path2;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        String str2 = resourceId;
        String url = downloadBean.getUrl();
        String str3 = (!downloadBean.isSeries() || (subjectName = downloadBean.getSubjectName()) == null || subjectName.length() <= 0 ? (name = downloadBean.getName()) != null : (name = downloadBean.getSubjectName()) != null) ? name : "";
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = downloadBean.getUrl();
        }
        String str4 = postId;
        String subjectId = downloadBean.getSubjectId();
        z(downloadBean, str, str2, url, str3, str4, subjectId == null ? "" : subjectId, i11);
    }

    private final void z(DownloadBean downloadBean, String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        if (downloadBean.isShotTV()) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(downloadBean)).withInt("ep", downloadBean.getEp()).withInt("extra_series_position", i11).withLong("ms", downloadBean.getReadProgress()).navigation();
            return;
        }
        View view = this.f60310f;
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Postcard postcardWithInt = com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withInt("subject_type", downloadBean.getSubjectType()).withString("id", str6).withString("extra_local_path", str).withString("extra_url", str3).withString("extra_resource_id", str2).withString("extra_subject_id", str6).withString("extra_name", str4).withString("extra_post_id", str5).withBoolean("extra_completed", true).withBoolean("extra_is_series", downloadBean.isSeries()).withString("extra_page_from", this.f60307b).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth());
        if (!downloadBean.isSeries()) {
            i11 = -1;
        }
        postcardWithInt.withInt("extra_series_position", i11).navigation(appCompatActivity);
    }

    public final void A(DownloadBean downloadBean) {
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        aVar.a().z().q(null);
        aVar.a().z().q(downloadBean);
        View view = this.f60310f;
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/download/series_list");
        String subjectName = downloadBean.getSubjectName();
        if (subjectName == null) {
            subjectName = "Series";
        }
        postcardB.withString("extra_name", subjectName).navigation(appCompatActivity);
    }

    public final void B(Long l11, Long l12, int i11, final int i12) {
        final long jLongValue = l11 != null ? l11.longValue() : 0L;
        long jLongValue2 = l12 != null ? l12.longValue() : 1L;
        final int i13 = (int) (((jLongValue * 1.0f) / (jLongValue2 > 0 ? jLongValue2 : 1L)) * 100);
        if (i13 >= 0 && i13 < 101) {
            this.f60315k.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$refresh$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    int i14 = i13;
                    if (i14 != 0) {
                        if (i14 != 100) {
                            return i12 == 1 ? this.itemView.getContext().getString(R$string.download_listened, Integer.valueOf(i13)) : this.itemView.getContext().getString(R$string.download_watched, Integer.valueOf(i13));
                        }
                        return this.itemView.getContext().getString(R$string.download_finished);
                    }
                    if (jLongValue > 0) {
                        return i12 == 1 ? this.itemView.getContext().getString(R$string.download_listened, 1) : this.itemView.getContext().getString(R$string.download_watched, 1);
                    }
                    return this.itemView.getContext().getString(R$string.download_not_open);
                }
            });
            this.f60319o.setProgress(i13);
        }
        if (i11 == 1) {
            this.f60315k.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$refresh$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return this.this$0.itemView.getContext().getString(R$string.download_not_open);
                }
            });
        } else {
            if (i11 != 6) {
                return;
            }
            this.f60315k.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$refresh$3
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return this.this$0.itemView.getContext().getString(R$string.download_finished);
                }
            });
        }
    }

    public final void C(DownloadBean downloadBean, AudioBean audioBean) {
        downloadBean.setAudioListener(new b(audioBean, downloadBean, this, new SoftReference(this)));
    }

    public final void D(final Context context) {
        Snackbar snackbarP0 = Snackbar.m0(this.itemView, R$string.download_open_file_no_permission, -1).p0(com.transsion.transfer.R$string.wifi_setting, new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadedHolder.F(this.f60407a, context, view);
            }
        });
        int color = z2.a.getColor(context, R$color.download_snackbar_bg);
        int color2 = z2.a.getColor(context, R$color.download_snackbar_action);
        snackbarP0.r0(color);
        View view = snackbarP0.H();
        Intrinsics.f(view, "view");
        com.transsion.baseui.util.n.a(view, com.blankj.utilcode.util.i.e(8.0f));
        final Button button = (Button) snackbarP0.H().findViewById(com.google.android.material.R$id.snackbar_action);
        if (button != null) {
            Intrinsics.f(button, "findViewById<Button>(com…ial.R.id.snackbar_action)");
            TextView textView = new TextView(context);
            textView.setAllCaps(false);
            textView.setTextColor(color);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setBackgroundColor(color2);
            com.transsion.baseui.util.n.a(textView, com.blankj.utilcode.util.i.e(8.0f));
            textView.setTypeface(so.a.c(context));
            textView.setText(button.getText());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadedHolder.E(button, view2);
                }
            });
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            layoutParams.width = com.blankj.utilcode.util.i.e(68.0f);
            layoutParams.height = com.blankj.utilcode.util.i.e(32.0f);
            ViewGroup viewGroup = (ViewGroup) button.getParent();
            if (viewGroup != null) {
                viewGroup.addView(textView, layoutParams);
            }
            so.c.g(button);
        }
        TextView textView2 = (TextView) snackbarP0.H().findViewById(com.google.android.material.R$id.snackbar_text);
        if (textView2 != null) {
            Intrinsics.f(textView2, "findViewById<TextView>(c…erial.R.id.snackbar_text)");
            textView2.setAllCaps(false);
            textView2.setTextSize(14.0f);
            textView2.setTypeface(so.a.c(context));
            textView2.setTextColor(color2);
        }
        snackbarP0.X();
    }

    public final void G(SoftReference<Object> softReference, AudioBean audioBean, String str) {
        if ((softReference != null ? softReference.get() : null) != null) {
            Object obj = softReference.get();
            Intrinsics.e(obj, "null cannot be cast to non-null type com.transsnet.downloader.adapter.DownloadedHolder");
            DownloadedHolder downloadedHolder = (DownloadedHolder) obj;
            if (audioBean != null) {
                downloadedHolder.B(audioBean.getReadProcess(), audioBean.getDuration(), audioBean.getStatus(), 1);
            }
        }
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void a(int i11, e9.a aVar) {
        if (aVar instanceof DownloadBean) {
            DownloadBean downloadBean = (DownloadBean) aVar;
            B(Long.valueOf(downloadBean.getReadProgress()), downloadBean.getDuration(), downloadBean.getStatus(), downloadBean.getType());
        }
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void c(d0.b listener) {
        Intrinsics.g(listener, "listener");
        this.f60324t = listener;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9  */
    @Override // com.transsnet.downloader.adapter.d0
    public void d(final int i11, final e9.a aVar) {
        final String strA;
        TnTextView tnTextView = this.f60315k;
        float f11 = this.f60308c;
        if (f11 == 0.0f) {
            f11 = 12.0f;
        }
        tnTextView.setTextSize(2, f11);
        if (aVar instanceof DownloadBean) {
            DownloadBean downloadBean = (DownloadBean) aVar;
            Long size = downloadBean.getSize();
            if (size != null) {
                strA = tp.a.a(size.longValue(), this.f60308c == 12.0f ? 1 : 0);
                if (strA == null) {
                    strA = "";
                }
            } else {
                strA = "";
            }
            if (downloadBean.isTransferFailed()) {
                downloadBean.isClosedTransferFailed();
            }
            if (downloadBean.getStatus() == 10) {
                so.c.k(this.f60320p);
                so.c.k(this.f60321q);
                this.f60316l.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$initData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CharSequence invoke() {
                        return this.this$0.itemView.getContext().getString(R$string.download_files, Integer.valueOf(((DownloadBean) aVar).getCount())) + " · " + strA;
                    }
                });
                this.f60316l.setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.ic_download_series, 0, 0, 0);
                so.c.g(this.f60317m);
                so.c.g(this.f60318n);
            } else {
                so.c.g(this.f60320p);
                so.c.g(this.f60321q);
                so.c.g(this.f60317m);
                this.f60316l.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.DownloadedHolder$initData$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CharSequence invoke() {
                        return strA;
                    }
                });
                this.f60316l.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                this.f60318n.setVisibility(downloadBean.isFileExist() ^ true ? 0 : 8);
            }
            ImageView imageView = (ImageView) getView(R$id.iv_cover);
            String cover = downloadBean.getCover();
            if (cover != null && !Intrinsics.b(imageView.getTag(), cover)) {
                imageView.setTag(cover);
                Context context = this.itemView.getContext();
                Intrinsics.f(context, "itemView.context");
                DownloadedHolderKt.a(context, imageView, cover, downloadBean.getThumbnail());
            }
            ImageView imageView2 = (ImageView) getView(R$id.iv_type);
            int type = downloadBean.getType();
            if (type == 2) {
                imageView2.setImageResource(com.transsion.baseui.R$mipmap.home_ic_movie_white);
            } else if (type == 3) {
                imageView2.setImageResource(downloadBean.isShotTV() ? com.transsion.baseui.R$mipmap.home_ic_short_tv_white : com.transsion.baseui.R$mipmap.home_ic_tv_white);
            } else if (type == 5 || type == 6) {
                imageView2.setImageResource(com.transsion.baseui.R$mipmap.home_ic_movie_white);
            } else {
                imageView2.setImageResource(com.transsion.baseui.R$mipmap.home_ic_audio_white);
            }
            this.f60314j.setText(downloadBean.getTitleNameAppendResolution());
            if (downloadBean.getEpName().length() > 0) {
                so.c.k(this.f60323s);
                this.f60323s.setText(downloadBean.getEpName());
            } else {
                so.c.g(this.f60323s);
            }
            getView(R$id.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadedHolder.u(this.f60398a, i11, aVar, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsnet.downloader.adapter.r
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return DownloadedHolder.v(this.f60401a, i11, aVar, view);
                }
            });
            View view = this.f60310f;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DownloadedHolder.w(aVar, this, i11, view2);
                    }
                });
            }
            if (downloadBean.getType() != 1 || downloadBean.getStatus() == 10) {
                B(Long.valueOf(downloadBean.getReadProgress()), downloadBean.getDuration(), downloadBean.getStatus(), downloadBean.getType());
                return;
            }
            kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new DownloadedHolder$initData$7(aVar, this, i11, null), 3, null);
            uo.b.a.f(uo.b.f78622a, "audioPlay", "------------------refrehs, name = " + downloadBean.getName() + ", audioStatus = " + downloadBean.getAudioStatus(), false, 4, null);
        }
    }

    public final void p(Context context) {
        PermissionUtils.x("android.permission.WRITE_EXTERNAL_STORAGE").m(new a(System.currentTimeMillis())).y();
    }

    public final View t() {
        return this.f60310f;
    }

    public final void x(int i11, View view, DownloadBean downloadBean) {
        if (downloadBean.isAllFileExist()) {
            this.f60309d.invoke(Integer.valueOf(i11), view, downloadBean, 1, this.f60324t);
            return;
        }
        LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
        Context context = view.getContext();
        Intrinsics.f(context, "view.context");
        localVideoNotExistUtil.n(context, downloadBean, i11);
    }
}
