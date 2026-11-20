package com.transsion.share.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.baselib.report.m;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
import com.transsion.share.R$mipmap;
import com.transsion.share.R$string;
import com.transsion.share.R$style;
import com.transsion.share.api.ActionViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.bean.ShareBean;
import com.transsion.share.bean.ShareType;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ShareDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f57724t = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionViewModel f57725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f57726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f57727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57728d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f57729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PostType f57731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f57732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f57733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f57734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f57735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f57736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f57737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mx.a f57738o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f57739p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f57740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f57741r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f57742s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShareDialogFragment a(PostType postType, String str, String str2, String reportType, String str3, String str4, boolean z11, boolean z12, boolean z13, String source, String str5, String str6) {
            Intrinsics.g(postType, "postType");
            Intrinsics.g(reportType, "reportType");
            Intrinsics.g(source, "source");
            ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("postType", postType);
            bundle.putString("subjectId", str);
            bundle.putBoolean("subject_delete", z12);
            bundle.putBoolean("subject_download", z11);
            bundle.putBoolean("subject_checkout", z13);
            bundle.putString("share_title", str3);
            bundle.putString("share_score", str4);
            bundle.putString("source", source);
            bundle.putString("author_id", str2);
            bundle.putString("report_type", reportType);
            bundle.putString("ops", str5);
            bundle.putString("download_name", str6);
            shareDialogFragment.setArguments(bundle);
            return shareDialogFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f57744b;

        static {
            int[] iArr = new int[ShareType.values().length];
            try {
                iArr[ShareType.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShareType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShareType.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShareType.WHATSAPP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShareType.TELEGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ShareType.CHECKOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f57743a = iArr;
            int[] iArr2 = new int[PostType.values().length];
            try {
                iArr2[PostType.POST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PostType.SUBJECT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PostType.GROUP_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PostType.STAFF_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PostType.SHORT_TV_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PostType.LIVE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            f57744b = iArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsion.share.share.a {
        public c() {
        }

        @Override // com.transsion.share.share.a
        @SuppressLint({"MissingPermission"})
        public void a(mx.a shareData) {
            Intrinsics.g(shareData, "shareData");
            ShareDialogFragment.this.f57738o = shareData;
            if (shareData.c() == ShareType.DELETE) {
                if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    kx.a aVar = kx.a.f69643a;
                    String string = ShareDialogFragment.this.getString(R$string.player_no_network_tip2);
                    Intrinsics.f(string, "getString(R.string.player_no_network_tip2)");
                    aVar.e(string);
                    return;
                }
                e eVar = ShareDialogFragment.this.f57736m;
                if (eVar != null) {
                    eVar.a(ShareDialogFragment.this.f57739p, ShareDialogFragment.this.f57731h);
                }
                ShareDialogFragment.x0(ShareDialogFragment.this, RequestParameters.SUBRESOURCE_DELETE, null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (shareData.c() == ShareType.DOWNLOAD) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ShareDialogFragment.this.A0(shareData);
                    return;
                }
                ShareDialogFragment shareDialogFragment = ShareDialogFragment.this;
                h hVar = h.f57754a;
                if (shareDialogFragment.v0(hVar.c())) {
                    ShareDialogFragment.this.A0(shareData);
                    return;
                } else {
                    ShareDialogFragment.this.requestPermissions(hVar.c(), 11);
                    return;
                }
            }
            if (shareData.c() == ShareType.CHECKOUT) {
                e eVar2 = ShareDialogFragment.this.f57736m;
                if (eVar2 != null) {
                    eVar2.d(ShareDialogFragment.this.f57739p);
                }
                ShareDialogFragment.x0(ShareDialogFragment.this, AppLovinEventTypes.USER_COMPLETED_CHECKOUT, null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (shareData.c() != ShareType.REPORT) {
                ShareDialogFragment.this.A0(shareData);
                return;
            }
            ShareDialogFragment.x0(ShareDialogFragment.this, "report", null, 2, null);
            kx.a aVar2 = kx.a.f69643a;
            Context contextRequireContext = ShareDialogFragment.this.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            aVar2.d(contextRequireContext, ShareDialogFragment.this.f57733j, ShareDialogFragment.this.f57739p, ShareDialogFragment.this.f57736m);
            ShareDialogFragment.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57746a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57746a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57746a;
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
            this.f57746a.invoke(obj);
        }
    }

    public ShareDialogFragment() {
        super(R$layout.player_share_dialog);
        this.f57737n = LazyKt__LazyJVMKt.b(new Function0<com.transsion.baselib.report.h>() { // from class: com.transsion.share.share.ShareDialogFragment$logViewConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.baselib.report.h invoke() {
                return new com.transsion.baselib.report.h("share_panel", false, 2, null);
            }
        });
        this.f57739p = "";
        this.f57740q = "";
        this.f57741r = "";
        this.f57742s = "";
    }

    private final void C0(View view) {
        View viewFindViewById = view.findViewById(R$id.iv_close);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.share.share.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShareDialogFragment.D0(this.f57752a, view2);
                }
            });
        }
        this.f57726b = (RecyclerView) view.findViewById(R$id.share_list);
        com.transsion.share.share.c cVar = new com.transsion.share.share.c(u0());
        RecyclerView recyclerView = this.f57726b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
            recyclerView.setAdapter(cVar);
        }
        cVar.h(new c());
    }

    public static final void D0(ShareDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    private final void H0(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.executePendingTransactions();
            if (!isAdded() && fragmentManager.findFragmentByTag(str) == null) {
                show(fragmentManager, str);
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private final com.transsion.baselib.report.h getLogViewConfig() {
        return (com.transsion.baselib.report.h) this.f57737n.getValue();
    }

    private final void initViewModel() {
        ActionViewModel actionViewModel = (ActionViewModel) new v0(this).a(ActionViewModel.class);
        actionViewModel.e().j(getViewLifecycleOwner(), new d(new Function1<ShareBean, Unit>() { // from class: com.transsion.share.share.ShareDialogFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShareBean shareBean) {
                invoke2(shareBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShareBean shareBean) {
                ShareType shareTypeC;
                if (shareBean != null) {
                    this.this$0.B0(shareBean);
                    return;
                }
                ShareDialogFragment shareDialogFragment = this.this$0;
                mx.a aVar = shareDialogFragment.f57738o;
                shareDialogFragment.B0((aVar == null || (shareTypeC = aVar.c()) == null) ? null : this.this$0.y0(shareTypeC));
            }
        }));
        this.f57725a = actionViewModel;
    }

    public static /* synthetic */ void x0(ShareDialogFragment shareDialogFragment, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        shareDialogFragment.w0(str, str2);
    }

    @SuppressLint({"MissingPermission"})
    public final void A0(mx.a aVar) {
        if (aVar == null) {
            return;
        }
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        if (!fVar.e() && (aVar.c() == ShareType.DELETE || aVar.c() == ShareType.DOWNLOAD)) {
            kx.a aVar2 = kx.a.f69643a;
            String string = getString(R$string.player_no_network_tip2);
            Intrinsics.f(string, "getString(R.string.player_no_network_tip2)");
            aVar2.e(string);
            return;
        }
        if (!fVar.e()) {
            B0(y0(aVar.c()));
            return;
        }
        this.f57727c = System.currentTimeMillis();
        Bundle arguments = getArguments();
        String string2 = arguments != null ? arguments.getString("subjectId") : null;
        String str = "";
        if (string2 == null) {
            string2 = "";
        }
        this.f57739p = string2;
        String strB = kx.a.f69643a.b();
        if (TextUtils.isEmpty(strB)) {
            strB = "0";
        }
        if (aVar.c() == ShareType.TELEGRAM) {
            str = "Telegram";
        } else if (aVar.c() == ShareType.WHATSAPP) {
            str = "WhatsApp";
        }
        String str2 = str;
        ActionViewModel actionViewModel = this.f57725a;
        if (actionViewModel != null) {
            actionViewModel.f(aVar.c(), r0(), this.f57739p, strB == null ? "0" : strB, str2);
        }
    }

    public final void B0(ShareBean shareBean) {
        FragmentActivity it;
        FragmentActivity it2;
        ShareType shareType = shareBean != null ? shareBean.getShareType() : null;
        switch (shareType == null ? -1 : b.f57743a[shareType.ordinal()]) {
            case 1:
                e eVar = this.f57736m;
                if (eVar != null) {
                    e.a.a(eVar, this.f57739p, null, 2, null);
                }
                x0(this, "delete ", null, 2, null);
                dismiss();
                break;
            case 2:
                e eVar2 = this.f57736m;
                if (eVar2 != null) {
                    eVar2.c(shareBean.getDownUrl(), shareBean.getTitle(), "", shareBean.getCoverUrl());
                }
                x0(this, DownloadBaseRunnable.TAG, null, 2, null);
                dismiss();
                break;
            case 3:
                String shortUrl = shareBean.getShortUrl();
                if (shortUrl != null) {
                    ClipData clipDataNewPlainText = ClipData.newPlainText("Simple test", shortUrl);
                    Context context = getContext();
                    Object systemService = context != null ? context.getSystemService("clipboard") : null;
                    Intrinsics.e(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
                    dismiss();
                }
                x0(this, "copylink", null, 2, null);
                break;
            case 4:
                String shortUrl2 = shareBean.getShortUrl();
                if (shortUrl2 != null && (it = getActivity()) != null) {
                    Intrinsics.f(it, "it");
                    F0("com.whatsapp", it, shortUrl2, shareBean.getDesc(), shareBean.getTitle());
                }
                x0(this, "whatsup", null, 2, null);
                break;
            case 5:
                String shortUrl3 = shareBean.getShortUrl();
                if (shortUrl3 != null && (it2 = getActivity()) != null) {
                    Intrinsics.f(it2, "it");
                    F0("org.telegram.messenger", it2, shortUrl3, shareBean.getDesc(), shareBean.getTitle());
                }
                x0(this, "Telegram", null, 2, null);
                break;
            case 6:
                e eVar3 = this.f57736m;
                if (eVar3 != null) {
                    eVar3.d(this.f57739p);
                }
                x0(this, AppLovinEventTypes.USER_COMPLETED_CHECKOUT, null, 2, null);
                break;
        }
    }

    public final void E0(e callback) {
        Intrinsics.g(callback, "callback");
        this.f57736m = callback;
    }

    public final void F0(String str, Activity activity, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3 + "\n" + str2;
        }
        if (!TextUtils.isEmpty(str4)) {
            str2 = str4 + "\n" + str2;
        }
        if (TextUtils.equals(str, "com.whatsapp")) {
            i.f57758a.d(activity, str2, new Function1<Boolean, Unit>() { // from class: com.transsion.share.share.ShareDialogFragment$shareShortUrl$1
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
                        this.this$0.dismissAllowingStateLoss();
                        return;
                    }
                    kx.a aVar = kx.a.f69643a;
                    String string = this.this$0.getString(R$string.tip_app_not_install);
                    Intrinsics.f(string, "getString(R.string.tip_app_not_install)");
                    aVar.e(string);
                }
            });
        } else if (TextUtils.equals(str, "org.telegram.messenger")) {
            i.f57758a.c(activity, str2, new Function1<Boolean, Unit>() { // from class: com.transsion.share.share.ShareDialogFragment$shareShortUrl$2
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
                        this.this$0.dismissAllowingStateLoss();
                        return;
                    }
                    kx.a aVar = kx.a.f69643a;
                    String string = this.this$0.getString(R$string.tip_app_not_install);
                    Intrinsics.f(string, "getString(R.string.tip_app_not_install)");
                    aVar.e(string);
                }
            });
        }
    }

    public final void G0(Context context, String str) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "context.supportFragmentManager");
                H0(supportFragmentManager, str);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public final void I0() {
        String string = getString(R$string.permission_deny_down_tip, "\"" + kx.a.f69643a.a() + "\"", "\"" + getString(R$string.system_settings) + "\"");
        Intrinsics.f(string, "getString(R.string.permi…n_tip, appName, settings)");
        h hVar = h.f57754a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        hVar.f(contextRequireContext, "", string, new Function0<Unit>() { // from class: com.transsion.share.share.ShareDialogFragment$showPermissionDenyDialog$1
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
                h hVar2 = h.f57754a;
                FragmentActivity activity = this.this$0.getActivity();
                if (activity == null) {
                    return;
                }
                h.j(hVar2, activity, 0, 2, null);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.shareDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.share_dialog_animations);
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
            attributes.width = com.blankj.utilcode.util.d0.e();
            attributes.height = -2;
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || !logViewConfig.d()) {
            return;
        }
        m.f51277a.r(logViewConfig);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i11, String[] permissions, int[] grantResults) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i11, permissions, grantResults);
        if (i11 == 11) {
            if (!h.f57754a.k(grantResults)) {
                I0();
                return;
            }
            mx.a aVar = this.f57738o;
            if (aVar != null) {
                A0(aVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.n(SystemClock.elapsedRealtime());
            if (logViewConfig.c()) {
                m.f51277a.s(logViewConfig);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f57728d = arguments != null && arguments.getBoolean("subject_delete");
        Bundle arguments2 = getArguments();
        this.f57729f = arguments2 != null && arguments2.getBoolean("subject_download");
        Bundle arguments3 = getArguments();
        this.f57730g = arguments3 != null && arguments3.getBoolean("subject_checkout");
        Bundle arguments4 = getArguments();
        String string = arguments4 != null ? arguments4.getString("subjectId") : null;
        if (string == null) {
            string = "";
        }
        this.f57739p = string;
        Bundle arguments5 = getArguments();
        this.f57731h = (PostType) (arguments5 != null ? arguments5.getSerializable("postType") : null);
        Bundle arguments6 = getArguments();
        this.f57740q = String.valueOf(arguments6 != null ? arguments6.getString("share_title") : null);
        Bundle arguments7 = getArguments();
        this.f57741r = String.valueOf(arguments7 != null ? arguments7.getString("share_score") : null);
        Bundle arguments8 = getArguments();
        this.f57742s = String.valueOf(arguments8 != null ? arguments8.getString("source") : null);
        Bundle arguments9 = getArguments();
        this.f57732i = arguments9 != null ? arguments9.getString("author_id") : null;
        Bundle arguments10 = getArguments();
        this.f57733j = arguments10 != null ? arguments10.getString("report_type") : null;
        Bundle arguments11 = getArguments();
        this.f57734k = arguments11 != null ? arguments11.getString("ops") : null;
        Bundle arguments12 = getArguments();
        this.f57735l = arguments12 != null ? arguments12.getString("download_name") : null;
        C0(view);
        initViewModel();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null) {
            return;
        }
        logViewConfig2.k(false);
    }

    public final String r0() {
        PostType postType = this.f57731h;
        switch (postType == null ? -1 : b.f57744b[postType.ordinal()]) {
            case 1:
                return "/post/detail";
            case 2:
                return "/movie/detail";
            case 3:
                return "/room/detail";
            case 4:
                return "/movie/staff";
            case 5:
                return "/shorts/detail";
            case 6:
                return "/live/detail";
            default:
                return "";
        }
    }

    public final String s0() {
        String string;
        PostType postType = this.f57731h;
        int i11 = postType == null ? -1 : b.f57744b[postType.ordinal()];
        if (i11 == 1) {
            Context context = getContext();
            string = context != null ? context.getString(R$string.share_long_link_post_s) : null;
            Intrinsics.d(string);
            return string;
        }
        if (i11 == 2) {
            Context context2 = getContext();
            string = context2 != null ? context2.getString(R$string.share_long_link_sub_no_duration, this.f57740q, this.f57741r) : null;
            Intrinsics.d(string);
            return string;
        }
        if (i11 != 3) {
            return "";
        }
        Context context3 = getContext();
        string = context3 != null ? context3.getString(R$string.share_long_link_group_s) : null;
        Intrinsics.d(string);
        return string;
    }

    public final String t0() {
        String strB = kx.a.f69643a.b();
        if (TextUtils.isEmpty(strB)) {
            strB = "0";
        }
        String strB2 = cp.a.f62775a.b();
        String strR0 = r0();
        Context context = getContext();
        String packageName = context != null ? context.getPackageName() : null;
        String str = strB2 + "?type=" + strR0 + "&package_name=" + packageName + "&id=" + this.f57739p + "&uid=" + strB;
        uo.b.a.f(uo.b.f78622a, "ShareDialogFragment", "share long link:" + str, false, 4, null);
        return str;
    }

    public final List<mx.a> u0() {
        String str;
        String string;
        ArrayList arrayList = new ArrayList();
        ShareType shareType = ShareType.WHATSAPP;
        int i11 = R$mipmap.share_ic_whatsapp;
        String string2 = getString(R$string.player_whatsapp);
        Intrinsics.f(string2, "getString(R.string.player_whatsapp)");
        arrayList.add(new mx.a(shareType, i11, string2));
        ShareType shareType2 = ShareType.TELEGRAM;
        int i12 = R$mipmap.share_ic_telegram;
        String string3 = getString(R$string.player_telegram);
        Intrinsics.f(string3, "getString(R.string.player_telegram)");
        arrayList.add(new mx.a(shareType2, i12, string3));
        ShareType shareType3 = ShareType.COPY_LINK;
        int i13 = R$mipmap.share_ic_copy_link;
        String string4 = getString(R$string.share_copy_link);
        Intrinsics.f(string4, "getString(R.string.share_copy_link)");
        arrayList.add(new mx.a(shareType3, i13, string4));
        if (this.f57729f) {
            String str2 = this.f57735l;
            if (str2 == null || str2.length() == 0) {
                string = getString(R$string.player_download);
            } else {
                string = this.f57735l;
                if (string == null) {
                    string = getString(R$string.player_download);
                    Intrinsics.f(string, "getString(R.string.player_download)");
                }
            }
            Intrinsics.f(string, "if (downloadName.isNullO…r_download)\n            }");
            arrayList.add(new mx.a(ShareType.DOWNLOAD, R$mipmap.share_ic_download, string));
        }
        if (this.f57728d) {
            ShareType shareType4 = ShareType.DELETE;
            int i14 = R$mipmap.share_ic_delete;
            String string5 = getString(R$string.player_delete);
            Intrinsics.f(string5, "getString(R.string.player_delete)");
            arrayList.add(new mx.a(shareType4, i14, string5));
        }
        if (this.f57730g) {
            ShareType shareType5 = ShareType.CHECKOUT;
            int i15 = R$mipmap.share_ic_checkout;
            String string6 = getString(R$string.player_check_out);
            Intrinsics.f(string6, "getString(R.string.player_check_out)");
            arrayList.add(new mx.a(shareType5, i15, string6));
        }
        if (!Intrinsics.b(kx.a.f69643a.b(), this.f57732i) && (str = this.f57733j) != null && str.length() != 0) {
            ShareType shareType6 = ShareType.REPORT;
            int i16 = R$mipmap.share_ic_report;
            String string7 = getString(R$string.player_report);
            Intrinsics.f(string7, "getString(R.string.player_report)");
            arrayList.add(new mx.a(shareType6, i16, string7));
        }
        return arrayList;
    }

    public final boolean v0(String[] strArr) {
        return PermissionUtils.s((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void w0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("module_name", str);
        if (str2 != null) {
        }
        map.put(z0(), this.f57739p);
        String str3 = this.f57734k;
        if (str3 == null) {
            str3 = "";
        }
        map.put("ops", str3);
        m.f51277a.m("share_panel", "click", map);
    }

    public final ShareBean y0(ShareType shareType) {
        ShareBean shareBean = new ShareBean();
        shareBean.setShareType(shareType);
        shareBean.setShortUrl(t0());
        shareBean.setDesc(s0());
        return shareBean;
    }

    public final String z0() {
        String str = this.f57742s;
        switch (str.hashCode()) {
            case 584244349:
                return !str.equals("subjectdetail") ? "post_id" : "subject_id";
            case 1232204688:
                return !str.equals("groupdetail") ? "post_id" : "group_id";
            case 2036233184:
                return !str.equals("usercenter") ? "post_id" : "host_uid";
            case 2092022001:
                str.equals("postdetail");
                return "post_id";
            default:
                return "post_id";
        }
    }
}
