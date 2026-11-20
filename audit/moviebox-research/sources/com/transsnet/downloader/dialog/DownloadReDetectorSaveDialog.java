package com.transsnet.downloader.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DocumentsUtils;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import h00.w0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__IndentKt;

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
public final class DownloadReDetectorSaveDialog extends BaseDialog {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f60523u = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h00.d0 f60524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f60526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f60527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsnet.downloader.adapter.i f60528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f60529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f00.b f60530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f60531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super f00.b, Unit> f60532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f60533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f60535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h00.k f60536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f60538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f60539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b1.b<Intent> f60540t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorSaveDialog a(String str, boolean z11) {
            DownloadReDetectorSaveDialog downloadReDetectorSaveDialog = new DownloadReDetectorSaveDialog();
            downloadReDetectorSaveDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_save_path", str), TuplesKt.a("extra_check_transfer_failed", Boolean.valueOf(z11))));
            return downloadReDetectorSaveDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60541a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60541a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60541a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60541a.invoke(obj);
        }
    }

    public DownloadReDetectorSaveDialog() {
        super(R$layout.fragment_download_res_path_save);
        String string = Utils.a().getString(R$string.download_save_to);
        Intrinsics.f(string, "getApp().getString(R.string.download_save_to)");
        this.f60525d = string;
        String string2 = Utils.a().getString(R$string.download_move_to);
        Intrinsics.f(string2, "getApp().getString(R.string.download_move_to)");
        this.f60526f = string2;
        this.f60527g = tr.b.f77264a.d();
        this.f60529i = -1;
        this.f60531k = -1;
        this.f60539s = "";
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.downloader.dialog.w
            @Override // b1.a
            public final void a(Object obj) {
                DownloadReDetectorSaveDialog.I0(this.f60601a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f60540t = bVarRegisterForActivityResult;
    }

    private final int A0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return (i11 - (i11 / 3)) - com.blankj.utilcode.util.f0.a(116.0f);
    }

    private final void B0(f00.b bVar, int i11) {
        w0 w0Var;
        if (this.f60534n) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "DownloadReDetectorSaveDialog", StringsKt__IndentKt.f("\n            path， handleItemClick, position = " + i11 + ", selectedPosition = " + this.f60529i + " \n                pathName =  " + bVar.d() + " ,downloadPath =  " + bVar.b() + " ,downloadShowPath =  " + bVar.c() + "\n        "), false, 4, null);
        int i12 = this.f60529i;
        if (i12 == i11) {
            return;
        }
        AppCompatTextView appCompatTextView = null;
        if (i12 >= 0) {
            com.transsnet.downloader.adapter.i iVar = this.f60528h;
            f00.b item = iVar != null ? iVar.getItem(i12) : null;
            if (item != null) {
                item.g(false);
            }
            com.transsnet.downloader.adapter.i iVar2 = this.f60528h;
            if (iVar2 != null) {
                iVar2.notifyItemChanged(this.f60529i, Boolean.FALSE);
            }
        }
        this.f60529i = i11;
        bVar.g(true);
        com.transsnet.downloader.adapter.i iVar3 = this.f60528h;
        if (iVar3 != null) {
            iVar3.notifyItemChanged(i11, Boolean.TRUE);
        }
        this.f60530j = bVar;
        h00.d0 d0Var = this.f60524c;
        if (d0Var != null && (w0Var = d0Var.f65783b) != null) {
            appCompatTextView = w0Var.f66079i;
        }
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setAlpha(1.0f);
    }

    public static final void C0(DownloadReDetectorSaveDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f60534n) {
            return;
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void D0(DownloadReDetectorSaveDialog this$0, View view) {
        f00.b bVar;
        w0 w0Var;
        w0 w0Var2;
        w0 w0Var3;
        w0 w0Var4;
        w0 w0Var5;
        AppCompatTextView appCompatTextView;
        Intrinsics.g(this$0, "this$0");
        h00.d0 d0Var = this$0.f60524c;
        AppCompatTextView appCompatTextView2 = null;
        if (!Intrinsics.a((d0Var == null || (w0Var5 = d0Var.f65783b) == null || (appCompatTextView = w0Var5.f66079i) == null) ? null : Float.valueOf(appCompatTextView.getAlpha()), 1.0f) || this$0.f60534n || (bVar = this$0.f60530j) == null) {
            return;
        }
        this$0.f60534n = true;
        this$0.setCancelable(false);
        Function1<? super f00.b, Unit> function1 = this$0.f60532l;
        if (function1 != null) {
            function1.invoke(bVar);
        }
        h00.d0 d0Var2 = this$0.f60524c;
        View vLoadingIntercept = (d0Var2 == null || (w0Var4 = d0Var2.f65783b) == null) ? null : w0Var4.f66084n;
        if (vLoadingIntercept != null) {
            Intrinsics.f(vLoadingIntercept, "vLoadingIntercept");
            vLoadingIntercept.setVisibility(0);
        }
        h00.d0 d0Var3 = this$0.f60524c;
        BLFrameLayout flLoading = (d0Var3 == null || (w0Var3 = d0Var3.f65783b) == null) ? null : w0Var3.f66073b;
        if (flLoading != null) {
            Intrinsics.f(flLoading, "flLoading");
            flLoading.setVisibility(0);
        }
        if (this$0.f60535o) {
            h00.d0 d0Var4 = this$0.f60524c;
            if (d0Var4 != null && (w0Var2 = d0Var4.f65783b) != null) {
                appCompatTextView2 = w0Var2.f66081k;
            }
            if (appCompatTextView2 == null) {
                return;
            }
            appCompatTextView2.setText(this$0.getString(R$string.download_moving));
            return;
        }
        h00.d0 d0Var5 = this$0.f60524c;
        if (d0Var5 != null && (w0Var = d0Var5.f65783b) != null) {
            appCompatTextView2 = w0Var.f66081k;
        }
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setText(this$0.getString(R$string.download_saving));
    }

    public static final void E0(DownloadReDetectorSaveDialog this$0, View view) {
        w0 w0Var;
        w0 w0Var2;
        Intrinsics.g(this$0, "this$0");
        this$0.f60534n = false;
        this$0.setCancelable(true);
        h00.d0 d0Var = this$0.f60524c;
        View view2 = null;
        BLFrameLayout bLFrameLayout = (d0Var == null || (w0Var2 = d0Var.f65783b) == null) ? null : w0Var2.f66073b;
        if (bLFrameLayout != null) {
            bLFrameLayout.setVisibility(8);
        }
        h00.d0 d0Var2 = this$0.f60524c;
        if (d0Var2 != null && (w0Var = d0Var2.f65783b) != null) {
            view2 = w0Var.f66084n;
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
        Function0<Unit> function0 = this$0.f60533m;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void F0() {
        w0 w0Var;
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.i iVar = new com.transsnet.downloader.adapter.i(true, new ArrayList());
        iVar.B0(new f9.d() { // from class: com.transsnet.downloader.dialog.s
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadReDetectorSaveDialog.G0(this.f60597a, baseQuickAdapter, view, i11);
            }
        });
        this.f60528h = iVar;
        h00.d0 d0Var = this.f60524c;
        if (d0Var == null || (w0Var = d0Var.f65783b) == null || (recyclerView = w0Var.f66078h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = A0();
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f60528h);
    }

    public static final void G0(DownloadReDetectorSaveDialog this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsnet.downloader.bean.DownloadSDCardPathInfo");
        this$0.B0((f00.b) item, i11);
    }

    public static final void I0(DownloadReDetectorSaveDialog this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            if (activityResult.getData() != null) {
                Intent data = activityResult.getData();
                Intrinsics.d(data);
                if (data.getData() != null) {
                    uo.b.a aVar = uo.b.f78622a;
                    Intent data2 = activityResult.getData();
                    Intrinsics.d(data2);
                    uo.b.a.f(aVar, "DownloadReDetectorSaveDialog", "onStoragePermissionGranted------- uri = " + data2.getData(), false, 4, null);
                    DocumentsUtils documentsUtils = DocumentsUtils.f61126a;
                    Application applicationA = Utils.a();
                    String str = this$0.f60539s;
                    Intent data3 = activityResult.getData();
                    Intrinsics.d(data3);
                    Uri data4 = data3.getData();
                    Intrinsics.d(data4);
                    documentsUtils.l(applicationA, str, data4);
                    FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                    String packageName = this$0.requireActivity().getPackageName();
                    Intent data5 = activityResult.getData();
                    Intrinsics.d(data5);
                    Uri data6 = data5.getData();
                    Intrinsics.d(data6);
                    fragmentActivityRequireActivity.grantUriPermission(packageName, data6, 3);
                    ContentResolver contentResolver = this$0.requireActivity().getContentResolver();
                    Intent data7 = activityResult.getData();
                    Intrinsics.d(data7);
                    Uri data8 = data7.getData();
                    Intrinsics.d(data8);
                    contentResolver.takePersistableUriPermission(data8, 3);
                    this$0.f60538r = true;
                    this$0.y0();
                    return;
                }
            }
            this$0.f60538r = false;
        }
    }

    public static final void N0(DownloadReDetectorSaveDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.z0();
    }

    private final void O0() {
        try {
            Intent intent = null;
            if (Build.VERSION.SDK_INT >= 24) {
                FragmentActivity activity = getActivity();
                Intrinsics.d(activity);
                StorageVolume storageVolume = ((StorageManager) activity.getSystemService(StorageManager.class)).getStorageVolume(new File(this.f60539s));
                if (storageVolume != null) {
                    intent = storageVolume.createAccessIntent(null);
                }
            }
            if (intent == null) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            }
            this.f60540t.a(intent);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private final boolean P0() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return false;
        }
        if (this.f60537q) {
            return !this.f60538r;
        }
        this.f60537q = true;
        if (i11 <= 28) {
            String strB = "";
            for (f00.e eVar : DownloadSDCardUtil.f61130a.b()) {
                if (eVar.c()) {
                    strB = eVar.b();
                    this.f60539s = strB;
                }
            }
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "DownloadReDetectorSaveDialog", "onStoragePermissionGranted，1  sdRootPath = " + strB, false, 4, null);
            if (strB.length() > 0) {
                DocumentsUtils documentsUtils = DocumentsUtils.f61126a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                boolean zD = documentsUtils.d(applicationA, strB);
                uo.b.a.f(aVar, "DownloadReDetectorSaveDialog", " check other permission, showOpenDocumentTree = " + zD, false, 4, null);
                if (zD) {
                    this.f60538r = false;
                    return true;
                }
            }
        }
        this.f60538r = true;
        return false;
    }

    private final void x0() {
        if (!DownloadUtil.f61136a.w() || P0()) {
            M0();
        } else {
            y0();
        }
    }

    public final void H0(View view) {
        w0 w0Var;
        w0 w0Var2;
        Bundle arguments = getArguments();
        AppCompatTextView appCompatTextView = null;
        String string = arguments != null ? arguments.getString("extra_download_save_path") : null;
        if (string == null) {
            string = tr.b.f77264a.d();
        }
        this.f60527g = string;
        this.f60524c = h00.d0.a(view);
        Bundle arguments2 = getArguments();
        boolean z11 = arguments2 != null ? arguments2.getBoolean("extra_check_transfer_failed") : false;
        this.f60535o = z11;
        if (z11) {
            h00.d0 d0Var = this.f60524c;
            if (d0Var != null && (w0Var2 = d0Var.f65783b) != null) {
                appCompatTextView = w0Var2.f66082l;
            }
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(this.f60526f + "…");
            return;
        }
        h00.d0 d0Var2 = this.f60524c;
        if (d0Var2 != null && (w0Var = d0Var2.f65783b) != null) {
            appCompatTextView = w0Var.f66082l;
        }
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(this.f60525d + "…");
    }

    public final void J0(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60533m = listener;
    }

    public final void K0(Function1<? super f00.b, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60532l = listener;
    }

    public final void L0(int i11) {
        w0 w0Var;
        w0 w0Var2;
        CircleProgressBar circleProgressBar;
        h00.d0 d0Var = this.f60524c;
        if (d0Var != null && (w0Var2 = d0Var.f65783b) != null && (circleProgressBar = w0Var2.f66077g) != null) {
            circleProgressBar.setProgress(i11);
        }
        h00.d0 d0Var2 = this.f60524c;
        AppCompatTextView appCompatTextView = (d0Var2 == null || (w0Var = d0Var2.f65783b) == null) ? null : w0Var.f66080j;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(i11 + "%");
    }

    public final void M0() {
        ConstraintLayout root;
        h00.d0 d0Var;
        ViewStub viewStub;
        View viewInflate;
        if (this.f60536p == null && (d0Var = this.f60524c) != null && (viewStub = d0Var.f65784c) != null && (viewInflate = viewStub.inflate()) != null && (viewInflate.getParent() instanceof ViewGroup)) {
            h00.k kVarA = h00.k.a(viewInflate);
            kVarA.f65920d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorSaveDialog.N0(this.f60596a, view);
                }
            });
            kVarA.f65919c.setText(getString(this.f60535o ? R$string.download_allow_access_to_move_tips : R$string.download_allow_access_to_save_tips));
            this.f60536p = kVarA;
        }
        h00.k kVar = this.f60536p;
        if (kVar == null || (root = kVar.getRoot()) == null) {
            return;
        }
        so.c.k(root);
    }

    public final void initListener() {
        w0 w0Var;
        AppCompatImageView appCompatImageView;
        w0 w0Var2;
        AppCompatTextView appCompatTextView;
        w0 w0Var3;
        ImageView imageView;
        h00.d0 d0Var = this.f60524c;
        if (d0Var != null && (w0Var3 = d0Var.f65783b) != null && (imageView = w0Var3.f66074c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorSaveDialog.C0(this.f60598a, view);
                }
            });
        }
        h00.d0 d0Var2 = this.f60524c;
        if (d0Var2 != null && (w0Var2 = d0Var2.f65783b) != null && (appCompatTextView = w0Var2.f66079i) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorSaveDialog.D0(this.f60599a, view);
                }
            });
        }
        h00.d0 d0Var3 = this.f60524c;
        if (d0Var3 == null || (w0Var = d0Var3.f65783b) == null || (appCompatImageView = w0Var.f66075d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorSaveDialog.E0(this.f60600a, view);
            }
        });
    }

    public final void initViewModel() {
        uo.b.a.o(uo.b.f78622a, "DownloadReDetectorSaveDialog", new String[]{"initViewModel "}, false, 4, null);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel.w().j(this, new b(new Function1<List<f00.b>, Unit>() { // from class: com.transsnet.downloader.dialog.DownloadReDetectorSaveDialog$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<f00.b> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<f00.b> list) {
                w0 w0Var;
                w0 w0Var2;
                uo.b.a.s(uo.b.f78622a, "DownloadReDetectorSaveDialog", "path size = " + list.size() + " ", false, 4, null);
                h00.d0 d0Var = this.this$0.f60524c;
                AppCompatTextView appCompatTextView = (d0Var == null || (w0Var2 = d0Var.f65783b) == null) ? null : w0Var2.f66079i;
                if (appCompatTextView != null) {
                    appCompatTextView.setAlpha(0.5f);
                }
                Intrinsics.f(list, "list");
                DownloadReDetectorSaveDialog downloadReDetectorSaveDialog = this.this$0;
                int i11 = 0;
                for (Object obj : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.g.u();
                    }
                    f00.b bVar = (f00.b) obj;
                    if (bVar.f()) {
                        downloadReDetectorSaveDialog.f60529i = i11;
                        downloadReDetectorSaveDialog.f60531k = i11;
                        h00.d0 d0Var2 = downloadReDetectorSaveDialog.f60524c;
                        AppCompatTextView appCompatTextView2 = (d0Var2 == null || (w0Var = d0Var2.f65783b) == null) ? null : w0Var.f66079i;
                        if (appCompatTextView2 != null) {
                            appCompatTextView2.setAlpha(1.0f);
                        }
                        downloadReDetectorSaveDialog.f60530j = bVar;
                    }
                    i11 = i12;
                }
                com.transsnet.downloader.adapter.i iVar = this.this$0.f60528h;
                if (iVar != null) {
                    iVar.w0(list);
                }
            }
        }));
        downloadResourcesDetectorViewModel.k(this.f60527g);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = -1;
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        H0(view);
        initListener();
        F0();
        initViewModel();
    }

    public final void y0() {
        ConstraintLayout root;
        h00.k kVar = this.f60536p;
        if (kVar == null || (root = kVar.getRoot()) == null) {
            return;
        }
        so.c.g(root);
    }

    public final void z0() {
        if (!DownloadUtil.f61136a.w()) {
            com.transsnet.downloader.viewmodel.c.f61276a.C();
        } else if (P0()) {
            O0();
        }
    }
}
