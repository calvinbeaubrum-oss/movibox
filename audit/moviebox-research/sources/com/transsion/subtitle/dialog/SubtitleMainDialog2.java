package com.transsion.subtitle.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.os.c;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.m;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.subtitle.fragment.AudioSelectListFragment;
import com.transsion.subtitle.fragment.NoSubtitleTipFragment;
import com.transsion.subtitle.fragment.SubtitleBaseFragment;
import com.transsion.subtitle.fragment.SubtitleOptionsFragment;
import com.transsion.subtitle.fragment.SubtitleSearchDownloadFragment;
import com.transsion.subtitle.fragment.SubtitleSelectListFragment;
import com.transsion.subtitle.fragment.SubtitleSyncAdjustFragment;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import com.transsnet.downloader.R$style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

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
public final class SubtitleMainDialog2 extends BaseDialog {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f58131y = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SubtitleDownloadViewModel f58132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadBean f58133d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f58134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f58135g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f58139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super vx.a, Unit> f58140l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LocalVideoUiType f58142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f58143o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f58145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f58146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f58147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FrameLayout f58148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FrameLayout f58149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public xx.b f58150v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DubsInfo f58152x;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<DubsInfo> f58136h = g.l();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<vx.a> f58137i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f58138j = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f58141m = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f58144p = "SELECT_SUBTITLE";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f58151w = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleMainDialog2 a(boolean z11, boolean z12, List<DubsInfo> dubs, DownloadBean downloadBean, String str) {
            Intrinsics.g(dubs, "dubs");
            SubtitleMainDialog2 subtitleMainDialog2 = new SubtitleMainDialog2();
            subtitleMainDialog2.f58136h = dubs;
            subtitleMainDialog2.I0(downloadBean);
            subtitleMainDialog2.setArguments(c.b(TuplesKt.a("EXTRA_FRAGMENT_TYPE", "NO_SUBTITLE"), TuplesKt.a("KEY_VIDEO_START_CHECK", Boolean.valueOf(z12)), TuplesKt.a("EXTRA_IS_LAND", Boolean.valueOf(z11)), TuplesKt.a("KEY_PAGE_NAME", str)));
            return subtitleMainDialog2;
        }

        public final SubtitleMainDialog2 b(boolean z11, boolean z12, List<vx.a> list, List<DubsInfo> dubs, DownloadBean downloadBean, LocalVideoUiType layerType, Integer num, String str) {
            Intrinsics.g(list, "list");
            Intrinsics.g(dubs, "dubs");
            Intrinsics.g(layerType, "layerType");
            SubtitleMainDialog2 subtitleMainDialog2 = new SubtitleMainDialog2();
            subtitleMainDialog2.f58136h = dubs;
            subtitleMainDialog2.I0(downloadBean);
            subtitleMainDialog2.K0(z12, list);
            subtitleMainDialog2.J0(layerType, num);
            subtitleMainDialog2.setArguments(c.b(TuplesKt.a("EXTRA_FRAGMENT_TYPE", "SELECT_SUBTITLE"), TuplesKt.a("EXTRA_IS_LAND", Boolean.valueOf(z11)), TuplesKt.a("KEY_PAGE_NAME", str)));
            if (downloadBean != null) {
                VideoSubtitleManager.f58109a.a().c(downloadBean);
            }
            return subtitleMainDialog2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58153a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58153a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58153a;
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
            this.f58153a.invoke(obj);
        }
    }

    private final void B0() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().beginTransaction().hide(it.next()).commitNowAllowingStateLoss();
        }
    }

    private final void C0(View view) {
        if (!this.f58135g) {
            wx.a aVarA = wx.a.a(view);
            Intrinsics.f(aVarA, "bind(view)");
            aVarA.f79666i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleMainDialog2.D0(this.f58155a, view2);
                }
            });
        }
        M0(this.f58144p);
        this.f58151w = this.f58144p;
    }

    public static final void D0(SubtitleMainDialog2 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void E0(SubtitleMainDialog2 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void initViewModel() {
        final SubtitleDownloadViewModel subtitleDownloadViewModel = (SubtitleDownloadViewModel) new v0(this).a(SubtitleDownloadViewModel.class);
        subtitleDownloadViewModel.f().j(this, new b(new Function1<String, Unit>() { // from class: com.transsion.subtitle.dialog.SubtitleMainDialog2$initViewModel$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x004e  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String type) {
                if (type == null) {
                    SubtitleMainDialog2 subtitleMainDialog2 = this.this$0;
                    Intrinsics.f(type, "type");
                    subtitleMainDialog2.M0(type);
                } else {
                    int iHashCode = type.hashCode();
                    if (iHashCode != -36909585) {
                        if (iHashCode != 767768588) {
                            if (iHashCode == 1814388055 && type.equals("SUBTITLE_OPTIONS")) {
                                SubtitleMainDialog2 subtitleMainDialog3 = this.this$0;
                                Intrinsics.f(type, "type");
                                subtitleMainDialog3.N0(type);
                            } else {
                                SubtitleMainDialog2 subtitleMainDialog4 = this.this$0;
                                Intrinsics.f(type, "type");
                                subtitleMainDialog4.M0(type);
                            }
                        } else if (type.equals("SUBTITLE_SYNC_ADJUST")) {
                            SubtitleMainDialog2 subtitleMainDialog5 = this.this$0;
                            Intrinsics.f(type, "type");
                            subtitleMainDialog5.P0(type);
                        } else {
                            SubtitleMainDialog2 subtitleMainDialog6 = this.this$0;
                            Intrinsics.f(type, "type");
                            subtitleMainDialog6.M0(type);
                        }
                    } else if (type.equals("DOWNLOAD_SUBTITLE")) {
                        SubtitleMainDialog2 subtitleMainDialog7 = this.this$0;
                        Intrinsics.f(type, "type");
                        subtitleMainDialog7.O0(type);
                    } else {
                        SubtitleMainDialog2 subtitleMainDialog8 = this.this$0;
                        Intrinsics.f(type, "type");
                        subtitleMainDialog8.M0(type);
                    }
                }
                this.this$0.f58151w = type;
                com.transsion.subtitle.a.f58119a.a(subtitleDownloadViewModel.getClass().getSimpleName() + " --> createFragment() --> type = " + type + " --> currentSubtitleType = " + this.this$0.f58151w);
            }
        }));
        subtitleDownloadViewModel.l().j(this, new b(new Function1<String, Unit>() { // from class: com.transsion.subtitle.dialog.SubtitleMainDialog2$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                this.this$0.f58139k = str;
            }
        }));
        this.f58132c = subtitleDownloadViewModel;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void A0(String str) {
        switch (str.hashCode()) {
            case -1109352453:
                if (!str.equals("SELECT_SUBTITLE")) {
                    return;
                }
                break;
            case -36909585:
                if (str.equals("DOWNLOAD_SUBTITLE")) {
                    FrameLayout frameLayout = this.f58146r;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    FrameLayout frameLayout2 = this.f58145q;
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(8);
                    }
                    FrameLayout frameLayout3 = this.f58147s;
                    if (frameLayout3 != null) {
                        frameLayout3.setVisibility(8);
                    }
                    FrameLayout frameLayout4 = this.f58149u;
                    if (frameLayout4 != null) {
                        frameLayout4.setVisibility(8);
                    }
                    FrameLayout frameLayout5 = this.f58148t;
                    if (frameLayout5 == null) {
                        return;
                    }
                    frameLayout5.setVisibility(0);
                    return;
                }
                return;
            case 767768588:
                if (str.equals("SUBTITLE_SYNC_ADJUST")) {
                    FrameLayout frameLayout6 = this.f58146r;
                    if (frameLayout6 != null) {
                        frameLayout6.setVisibility(8);
                    }
                    FrameLayout frameLayout7 = this.f58145q;
                    if (frameLayout7 != null) {
                        frameLayout7.setVisibility(8);
                    }
                    FrameLayout frameLayout8 = this.f58147s;
                    if (frameLayout8 != null) {
                        frameLayout8.setVisibility(8);
                    }
                    FrameLayout frameLayout9 = this.f58148t;
                    if (frameLayout9 != null) {
                        frameLayout9.setVisibility(8);
                    }
                    FrameLayout frameLayout10 = this.f58149u;
                    if (frameLayout10 == null) {
                        return;
                    }
                    frameLayout10.setVisibility(0);
                    return;
                }
                return;
            case 1814388055:
                if (str.equals("SUBTITLE_OPTIONS")) {
                    FrameLayout frameLayout11 = this.f58146r;
                    if (frameLayout11 != null) {
                        frameLayout11.setVisibility(8);
                    }
                    FrameLayout frameLayout12 = this.f58145q;
                    if (frameLayout12 != null) {
                        frameLayout12.setVisibility(8);
                    }
                    FrameLayout frameLayout13 = this.f58148t;
                    if (frameLayout13 != null) {
                        frameLayout13.setVisibility(8);
                    }
                    FrameLayout frameLayout14 = this.f58149u;
                    if (frameLayout14 != null) {
                        frameLayout14.setVisibility(8);
                    }
                    FrameLayout frameLayout15 = this.f58147s;
                    if (frameLayout15 == null) {
                        return;
                    }
                    frameLayout15.setVisibility(0);
                    return;
                }
                return;
            case 2039663830:
                if (!str.equals("NO_SUBTITLE")) {
                    return;
                }
                break;
            default:
                return;
        }
        FrameLayout frameLayout16 = this.f58146r;
        if (frameLayout16 != null) {
            frameLayout16.setVisibility(0);
        }
        FrameLayout frameLayout17 = this.f58145q;
        if (frameLayout17 != null) {
            frameLayout17.setVisibility(0);
        }
        FrameLayout frameLayout18 = this.f58147s;
        if (frameLayout18 != null) {
            frameLayout18.setVisibility(8);
        }
        FrameLayout frameLayout19 = this.f58148t;
        if (frameLayout19 != null) {
            frameLayout19.setVisibility(8);
        }
        FrameLayout frameLayout20 = this.f58149u;
        if (frameLayout20 == null) {
            return;
        }
        frameLayout20.setVisibility(8);
    }

    public final void F0(DubsInfo dubsInfo) {
        String subjectId;
        String resourceId;
        String lanCode;
        String lanName;
        String str = this.f58134f;
        if (str == null || str.length() == 0) {
            return;
        }
        boolean z11 = dubsInfo != null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f58133d;
        String str2 = "";
        if (downloadBean == null || (subjectId = downloadBean.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        DownloadBean downloadBean2 = this.f58133d;
        if (downloadBean2 == null || (resourceId = downloadBean2.getResourceId()) == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        if (dubsInfo == null || (lanCode = dubsInfo.getLanCode()) == null) {
            lanCode = "";
        }
        linkedHashMap.put("lan_code", lanCode);
        if (dubsInfo != null && (lanName = dubsInfo.getLanName()) != null) {
            str2 = lanName;
        }
        linkedHashMap.put("lan_name", str2);
        linkedHashMap.put("result", z11 ? "1" : "0");
        m mVar = m.f51277a;
        String str3 = this.f58134f;
        Intrinsics.d(str3);
        mVar.m(str3, "audio_switch", linkedHashMap);
    }

    public final void G0() {
        DownloadBean downloadBean = this.f58133d;
        String subjectId = downloadBean != null ? downloadBean.getSubjectId() : null;
        Application applicationA = Utils.a();
        DubsInfo dubsInfo = new DubsInfo(subjectId, applicationA != null ? applicationA.getString(R$string.audio_default) : null, null, false);
        dubsInfo.setSelected(true);
        if (this.f58136h.isEmpty()) {
            this.f58136h = f.e(dubsInfo);
        }
    }

    public final void H0(xx.b bVar) {
        this.f58150v = bVar;
    }

    public final void I0(DownloadBean downloadBean) {
        this.f58133d = downloadBean;
        G0();
    }

    public final void J0(LocalVideoUiType localVideoUiType, Integer num) {
        this.f58142n = localVideoUiType;
        this.f58143o = num;
    }

    public final void K0(boolean z11, List<vx.a> list) {
        Intrinsics.g(list, "list");
        this.f58138j = z11;
        this.f58137i.clear();
        this.f58137i.addAll(list);
    }

    public final void L0(Function1<? super vx.a, Unit> function1) {
        this.f58140l = function1;
    }

    public final void M0(String str) {
        A0(str);
        B0();
        x0();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = z0(str);
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.fl_subtitle_container, fragmentFindFragmentByTag, str).commitNowAllowingStateLoss();
        }
    }

    public final void N0(String str) {
        A0(str);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = z0(str);
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.flStyleContainer, fragmentFindFragmentByTag, str).commitNowAllowingStateLoss();
        }
    }

    public final void O0(String str) {
        A0(str);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = z0(str);
        }
        SubtitleSearchDownloadFragment subtitleSearchDownloadFragment = fragmentFindFragmentByTag instanceof SubtitleSearchDownloadFragment ? (SubtitleSearchDownloadFragment) fragmentFindFragmentByTag : null;
        if (subtitleSearchDownloadFragment != null) {
            subtitleSearchDownloadFragment.F0(this.f58140l, this.f58151w);
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.flSearchContainer, fragmentFindFragmentByTag, str).commitNowAllowingStateLoss();
        }
    }

    public final void P0(String str) {
        A0(str);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = z0(str);
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.flSyncAdjustContainer, fragmentFindFragmentByTag, str).commitNowAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.getBoolean("KEY_SAVE_INSTANCE")) {
            dismissAllowingStateLoss();
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("EXTRA_FRAGMENT_TYPE", "SELECT_SUBTITLE");
            Intrinsics.f(string, "getString(\n             …CT_SUBTITLE\n            )");
            this.f58144p = string;
            this.f58135g = arguments.getBoolean("EXTRA_IS_LAND", false);
            this.f58141m = arguments.getBoolean("KEY_VIDEO_START_CHECK", true);
            this.f58134f = arguments.getString("KEY_PAGE_NAME", "");
        }
        setStyle(0, R$style.DownloadBottomDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(this.f58135g ? R$layout.dialog_subtitle_main_land : R$layout.dialog_subtitle_main_portrait, viewGroup, false);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "childFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof SubtitleBaseFragment) {
                ((SubtitleBaseFragment) fragment).k0();
            }
        }
        F0(this.f58152x);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("KEY_SAVE_INSTANCE", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        int i11;
        int i12;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            if (this.f58135g) {
                i11 = so.c.f() ? com.tn.lib.widget.R$style.ActionSheetDialogLeft : com.tn.lib.widget.R$style.ActionSheetDialogRight;
            } else {
                i11 = R$style.BottomShowAnimation;
            }
            window.setWindowAnimations(i11);
            if (this.f58135g) {
                i12 = so.c.f() ? GravityCompat.START : GravityCompat.END;
            } else {
                i12 = 80;
            }
            window.setGravity(i12);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                window.setLayout(-1, this.f58135g ? -1 : (com.blankj.utilcode.util.d0.c() - d.c()) - (d.d(activity) ? d.a() : 0));
            }
            if (this.f58135g) {
                ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
                immersionBarWith.hideBar(BarHide.FLAG_HIDE_BAR);
                immersionBarWith.init();
            }
        }
        View viewFindViewById = view.findViewById(R$id.space);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleMainDialog2.E0(this.f58154a, view2);
                }
            });
        }
        this.f58145q = (FrameLayout) view.findViewById(R$id.fl_audio_container);
        this.f58146r = (FrameLayout) view.findViewById(R$id.fl_subtitle_container);
        this.f58147s = (FrameLayout) view.findViewById(R$id.flStyleContainer);
        this.f58148t = (FrameLayout) view.findViewById(R$id.flSearchContainer);
        this.f58149u = (FrameLayout) view.findViewById(R$id.flSyncAdjustContainer);
        initViewModel();
        C0(view);
    }

    public final void x0() {
        if (this.f58136h.isEmpty()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("SELECT_AUDIO");
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = y0();
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else if (this.f58145q != null) {
            getChildFragmentManager().beginTransaction().add(R$id.fl_audio_container, fragmentFindFragmentByTag, "SELECT_AUDIO").commitNowAllowingStateLoss();
        }
    }

    public final AudioSelectListFragment y0() {
        AudioSelectListFragment audioSelectListFragmentA = AudioSelectListFragment.f58156m.a(this.f58136h, this.f58133d, this.f58134f);
        audioSelectListFragmentA.q0(this.f58150v);
        return audioSelectListFragmentA;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Fragment z0(String str) {
        switch (str.hashCode()) {
            case -1109352453:
                if (str.equals("SELECT_SUBTITLE")) {
                    SubtitleSelectListFragment subtitleSelectListFragmentA = SubtitleSelectListFragment.f58214p.a(this.f58137i, this.f58135g, this.f58133d, this.f58134f);
                    subtitleSelectListFragmentA.Q0(this.f58150v);
                    return subtitleSelectListFragmentA;
                }
                break;
            case 767768588:
                if (str.equals("SUBTITLE_SYNC_ADJUST")) {
                    SubtitleSyncAdjustFragment subtitleSyncAdjustFragment = new SubtitleSyncAdjustFragment();
                    subtitleSyncAdjustFragment.r0(this.f58150v);
                    return subtitleSyncAdjustFragment;
                }
                break;
            case 1814388055:
                if (str.equals("SUBTITLE_OPTIONS")) {
                    SubtitleOptionsFragment.a aVar = SubtitleOptionsFragment.f58173n;
                    LocalVideoUiType localVideoUiType = this.f58142n;
                    Integer num = this.f58143o;
                    xx.b bVar = this.f58150v;
                    SimpleSubtitleView simpleSubtitleViewD = bVar != null ? bVar.d() : null;
                    xx.b bVar2 = this.f58150v;
                    SimpleSubtitleView simpleSubtitleViewA = bVar2 != null ? bVar2.a() : null;
                    xx.b bVar3 = this.f58150v;
                    ViewGroup subtitleViewGroup = bVar3 != null ? bVar3.getSubtitleViewGroup() : null;
                    xx.b bVar4 = this.f58150v;
                    return aVar.a(localVideoUiType, num, simpleSubtitleViewD, simpleSubtitleViewA, subtitleViewGroup, bVar4 != null ? bVar4.h() : null, this.f58134f);
                }
                break;
            case 2039663830:
                if (str.equals("NO_SUBTITLE")) {
                    return NoSubtitleTipFragment.f58162k.a(this.f58141m, SubtitleSearchHelper.f58255c.a().d(this.f58133d), this.f58134f);
                }
                break;
        }
        SubtitleSearchDownloadFragment subtitleSearchDownloadFragmentA = SubtitleSearchDownloadFragment.f58180q.a(this.f58139k, this.f58133d, this.f58134f);
        subtitleSearchDownloadFragmentA.F0(this.f58140l, this.f58151w);
        return subtitleSearchDownloadFragmentA;
    }
}
