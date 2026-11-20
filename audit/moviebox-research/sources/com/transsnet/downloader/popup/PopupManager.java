package com.transsnet.downloader.popup;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.d0;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.dialog.DownloadMoreDialog;
import com.transsnet.downloader.dialog.DownloadReDetectorSaveDialog;
import com.transsnet.downloader.util.DocumentsUtils;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import f00.e;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
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
@Metadata
public final class PopupManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f61079f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadBean f61081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f61082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0.b f61083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f61084e;

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
    public static final class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f61086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f61087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, Integer, Unit> f61088d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Context context, boolean z11, Function2<? super Boolean, ? super Integer, Unit> function2) {
            this.f61086b = context;
            this.f61087c = z11;
            this.f61088d = function2;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            PopupManager.this.o(this.f61086b, this.f61087c, this.f61088d);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            PopupManager.this.o(this.f61086b, this.f61087c, this.f61088d);
        }
    }

    public PopupManager(int i11, DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        this.f61080a = i11;
        this.f61081b = downloadBean;
        this.f61082c = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.popup.PopupManager$audioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C(PopupManager popupManager, Context context, boolean z11, Function2 function2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            function2 = null;
        }
        popupManager.B(context, z11, function2);
    }

    public final void A() {
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DOWNLOAD").withString("subject_id", this.f61081b.getSubjectId()).navigation();
    }

    public final void B(Context context, boolean z11, Function2<? super Boolean, ? super Integer, Unit> function2) {
        Intrinsics.g(context, "context");
        if (Build.VERSION.SDK_INT > 29) {
            D(context, z11, function2);
        } else if (PermissionUtils.s("android.permission.WRITE_EXTERNAL_STORAGE")) {
            o(context, z11, function2);
        } else {
            PermissionUtils.x("android.permission.WRITE_EXTERNAL_STORAGE").m(new b(context, z11, function2)).y();
        }
    }

    public final void D(final Context context, final boolean z11, final Function2<? super Boolean, ? super Integer, Unit> function2) {
        String rootPath;
        if (this.f61081b.isTransferFailed() || (rootPath = this.f61081b.getRootPath()) == null) {
            rootPath = tr.b.f77264a.d();
        }
        final DownloadReDetectorSaveDialog downloadReDetectorSaveDialogA = DownloadReDetectorSaveDialog.f60523u.a(rootPath, z11);
        downloadReDetectorSaveDialogA.K0(new Function1<f00.b, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$transferFileForEach$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.b pathInfo) {
                Intrinsics.g(pathInfo, "pathInfo");
                this.this$0.t(context, pathInfo, downloadReDetectorSaveDialogA, z11, function2);
            }
        });
        downloadReDetectorSaveDialogA.J0(new Function0<Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$transferFileForEach$1$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
        downloadReDetectorSaveDialogA.j0(context, "save_loading_Dialog");
    }

    public final void E() {
        Function0<Unit> function0 = this.f61084e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void m() {
        String postId = this.f61081b.getPostId();
        if (postId == null) {
            postId = this.f61081b.getUrl();
        }
        String cover = this.f61081b.getCover();
        Long duration = this.f61081b.getDuration();
        Long size = this.f61081b.getSize();
        String url = this.f61081b.getUrl();
        String name = this.f61081b.getName();
        String subjectId = this.f61081b.getSubjectId();
        String subjectName = this.f61081b.getSubjectName();
        int ep2 = this.f61081b.getEp();
        j.d(l0.a(w0.c()), null, null, new PopupManager$audioAddPlayList$1(new AudioBean(postId, cover, duration, size, url, name, "", null, null, null, null, null, null, this.f61081b.getPostId(), subjectId, this.f61081b.getGroupId(), 0, subjectName, this.f61081b.getSe(), ep2, 73600, null), null), 3, null);
    }

    public final Pair<Boolean, String> n() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (i11 <= 28) {
            String str = "";
            String strB = str;
            for (e eVar : DownloadSDCardUtil.f61130a.b()) {
                if (eVar.c()) {
                    strB = eVar.b();
                    str = strB;
                }
            }
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "SaveVideo", "onStoragePermissionGranted，1  sdRootPath = " + str, false, 4, null);
            if (str.length() > 0) {
                DocumentsUtils documentsUtils = DocumentsUtils.f61126a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                boolean zD = documentsUtils.d(applicationA, str);
                uo.b.a.f(aVar, "SaveVideo", " check other permission, showOpenDocumentTree = " + zD, false, 4, null);
                if (zD) {
                    return new Pair<>(Boolean.FALSE, strB);
                }
            }
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public final void o(final Context context, final boolean z11, final Function2<? super Boolean, ? super Integer, Unit> function2) {
        Pair<Boolean, String> pairN = n();
        if (pairN.getFirst().booleanValue()) {
            y(pairN.getSecond(), new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$checkDocumentTree$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z12) {
                    if (z12) {
                        this.this$0.D(context, z11, function2);
                    }
                }
            });
        } else {
            D(context, z11, function2);
        }
    }

    public final void p() {
        com.transsnet.downloader.manager.a aVarA = com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        DownloadBean downloadBean = this.f61081b;
        if (downloadBean.getStatus() != 10) {
            aVarA.k(downloadBean, new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$delete$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    zp.b.f82110a.e(Utils.a().getString(R$string.download_delete_success));
                    d0.b bVar = this.this$0.f61083d;
                    if (bVar != null) {
                        bVar.a(this.this$0.f61080a, 4);
                    }
                    String resourceId = this.this$0.f61081b.getResourceId();
                    if (resourceId != null) {
                        TnPlayerManager.f54684a.o(resourceId);
                    }
                }
            });
        } else {
            if (downloadBean.getSeriesList().isEmpty()) {
                zp.b.f82110a.e(Utils.a().getString(R$string.download_delete_success));
                d0.b bVar = this.f61083d;
                if (bVar != null) {
                    bVar.a(this.f61080a, 4);
                }
                String resourceId = this.f61081b.getResourceId();
                if (resourceId != null) {
                    TnPlayerManager.f54684a.o(resourceId);
                    return;
                }
                return;
            }
            aVarA.y(downloadBean.getSeriesList(), new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$delete$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    zp.b.f82110a.e(Utils.a().getString(R$string.download_delete_success));
                    d0.b bVar2 = this.this$0.f61083d;
                    if (bVar2 != null) {
                        bVar2.a(this.this$0.f61080a, 4);
                    }
                    String resourceId2 = this.this$0.f61081b.getResourceId();
                    if (resourceId2 != null) {
                        TnPlayerManager.f54684a.o(resourceId2);
                    }
                }
            });
        }
        if (downloadBean.getType() == 1 && r().u(downloadBean.getUrl())) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).hide();
            r().stop();
        }
    }

    public final void q(Context context) {
        String string;
        int rootPathType = this.f61081b.getRootPathType();
        if (rootPathType != 2) {
            string = rootPathType != 3 ? context.getString(com.transsion.push.R$string.app_name) : context.getString(R$string.str_download_dialog_path_albums);
        } else {
            string = context.getString(R$string.sdcard_name);
        }
        Intrinsics.f(string, "when (downloadBean.rootP…)\n            }\n        }");
        DownloadConfirmDialog downloadConfirmDialogA = DownloadConfirmDialog.f60505j.a(context.getString(R$string.cancel), context.getString(R$string.delete), context.getString(R$string.download_delete_tips, string), null);
        downloadConfirmDialogA.r0(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$deleteItemClick$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (z11) {
                    this.this$0.p();
                }
            }
        });
        downloadConfirmDialogA.j0(context, "confirm_Dialog");
    }

    public final IAudioApi r() {
        Object value = this.f61082c.getValue();
        Intrinsics.f(value, "<get-audioApi>(...)");
        return (IAudioApi) value;
    }

    public final String s(boolean z11) {
        if (z11) {
            return Utils.a().getString(R$string.download_move_successful) + "\n" + Utils.a().getString(R$string.download_save_subtitle_tips);
        }
        return Utils.a().getString(R$string.download_save_successful) + "\n" + Utils.a().getString(R$string.download_save_subtitle_tips);
    }

    public final void t(Context context, f00.b bVar, DownloadReDetectorSaveDialog downloadReDetectorSaveDialog, boolean z11, Function2<? super Boolean, ? super Integer, Unit> function2) {
        j.d(l0.a(w0.b()), null, null, new PopupManager$handleTransferFile$1(this, z11, context, bVar, downloadReDetectorSaveDialog, function2, null), 3, null);
    }

    public final void u(d0.b listener) {
        Intrinsics.g(listener, "listener");
        this.f61083d = listener;
    }

    public final void v(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61084e = callback;
    }

    public final void w(final Context context) {
        List<Pair<String, String>> listQ;
        String value;
        Boolean boolY0;
        if (this.f61081b.getType() == 1) {
            listQ = g.q(new Pair(Utils.a().getString(R$string.help), "feedback"), new Pair(Utils.a().getString(R$string.download_dialog_audio_playlist), "audio_add"), new Pair(Utils.a().getString(R$string.delete), RequestParameters.SUBRESOURCE_DELETE));
        } else {
            ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sb_show_save_to", false, 2, null);
            boolean zBooleanValue = (configBeanC == null || (value = configBeanC.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null) ? false : boolY0.booleanValue();
            List<Pair<String, String>> listQ2 = g.q(new Pair(Utils.a().getString(R$string.help), "feedback"), new Pair(Utils.a().getString(R$string.download_transfer_tips), "transfer_file_2_mb"), new Pair(Utils.a().getString(R$string.delete), RequestParameters.SUBRESOURCE_DELETE));
            if (zBooleanValue) {
                listQ2.add(2, new Pair<>(Utils.a().getString(R$string.download_save_to_dot), "transfer_file"));
            }
            listQ = listQ2;
        }
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(listQ);
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$showDownloadedDialog$dialog$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.f68710a;
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            public final void invoke(int i11, String str, String str2) {
                Intrinsics.g(str, "<anonymous parameter 1>");
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -2014367408:
                            if (str2.equals("transfer_file")) {
                                PopupManager.C(this.this$0, context, false, null, 6, null);
                                break;
                            }
                            break;
                        case -1335458389:
                            if (str2.equals(RequestParameters.SUBRESOURCE_DELETE)) {
                                this.this$0.q(context);
                                break;
                            }
                            break;
                        case -191501435:
                            if (str2.equals("feedback")) {
                                this.this$0.A();
                                break;
                            }
                            break;
                        case 188508344:
                            if (str2.equals("audio_add")) {
                                this.this$0.m();
                                break;
                            }
                            break;
                        case 1086195281:
                            if (str2.equals("transfer_file_2_mb")) {
                                this.this$0.E();
                                break;
                            }
                            break;
                    }
                }
            }
        });
        downloadMoreDialogA.j0(context, "more_Dialog");
    }

    public final void x(final Context context) {
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(g.q(new Pair(Utils.a().getString(R$string.help), "feedback"), new Pair(Utils.a().getString(R$string.delete), RequestParameters.SUBRESOURCE_DELETE)));
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$showDownloadingDialog$dialog$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.f68710a;
            }

            public final void invoke(int i11, String str, String str2) {
                Intrinsics.g(str, "<anonymous parameter 1>");
                if (i11 == 0) {
                    this.this$0.A();
                } else {
                    if (i11 != 1) {
                        return;
                    }
                    this.this$0.q(context);
                }
            }
        });
        downloadMoreDialogA.j0(context, "more_Dialog");
    }

    public final void y(final String str, final Function1<? super Boolean, Unit> function1) {
        try {
            DocumentsUtils.f61126a.k(str, new Function1<Uri, Unit>() { // from class: com.transsnet.downloader.popup.PopupManager$showOpenDocumentTree$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                    invoke2(uri);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Uri uri) {
                    if (uri == null) {
                        function1.invoke(Boolean.FALSE);
                        return;
                    }
                    uo.b.a.f(uo.b.f78622a, "SaveVideo", "onStoragePermissionGranted------- uri = " + uri, false, 4, null);
                    DocumentsUtils.f61126a.l(Utils.a(), str, uri);
                    function1.invoke(Boolean.TRUE);
                }
            });
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void z(View anchorView, int i11) {
        Intrinsics.g(anchorView, "anchorView");
        if (i11 == 1) {
            Context context = anchorView.getContext();
            Intrinsics.f(context, "anchorView.context");
            w(context);
        } else {
            Context context2 = anchorView.getContext();
            Intrinsics.f(context2, "anchorView.context");
            x(context2);
        }
    }
}
