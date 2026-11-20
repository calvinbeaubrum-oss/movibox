package com.transsnet.downloader.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$style;
import com.transsnet.downloader.dialog.DownloadAudioTrackSelectDialog;
import com.transsnet.downloader.dialog.DownloadSeasonsSelectFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
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
public final class DownloadReDetectorMainDialog extends BaseDialog {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f60720w = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f60721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f60722d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f60723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f60724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Subject f60725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f60726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f60727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f60728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f60729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f60730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f60731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f60732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f60733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f60735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function4<? super Integer, ? super String, ? super DownloadBean, ? super Boolean, Unit> f60736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super f00.b, Unit> f60737t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public DownloadResourcesDetectorViewModel f60738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f60739v;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorMainDialog a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, String str7, int i11, boolean z11) {
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            if (subject != null) {
                Integer subjectType = subject.getSubjectType();
                SubjectType.EDUCATION.getValue();
                if (subjectType != null) {
                    subjectType.intValue();
                }
            }
            downloadReDetectorMainDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", 2), TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_resource", str5), TuplesKt.a("extra_target_resource_id", str6), TuplesKt.a("extra_module_name", str7), TuplesKt.a("extra_season", Integer.valueOf(i11)), TuplesKt.a("extra_dialog_style", Boolean.valueOf(z11))));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog b(String str, String str2, String str3, Subject subject, String str4, String resourceFrom, String str5) {
            Intrinsics.g(resourceFrom, "resourceFrom");
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", 3), TuplesKt.a("extra_page_from", str2), TuplesKt.a("extra_last_page_from", str3), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_link_url", str), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_resource", resourceFrom), TuplesKt.a("extra_module_name", str5)));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog c() {
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", 4)));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog d(String resourceFrom, String str) {
            Intrinsics.g(resourceFrom, "resourceFrom");
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", 1), TuplesKt.a("extra_resource", resourceFrom), TuplesKt.a("extra_module_name", str)));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog e(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, boolean z11) {
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", 5), TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_subject_id", str3), TuplesKt.a("extra_group_id", str4), TuplesKt.a("extra_ops", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_download_scroll_to_download", Boolean.valueOf(z11))));
            return downloadReDetectorMainDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60740a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60740a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60740a;
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
            this.f60740a.invoke(obj);
        }
    }

    public DownloadReDetectorMainDialog() {
        super(R$layout.dialog_download_res_main);
        this.f60722d = 1;
        this.f60723f = 1;
        this.f60728k = "";
        this.f60729l = "";
        this.f60734q = true;
    }

    private final void initViewModel() {
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel.o().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMainDialog$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer type) {
                DownloadReDetectorMainDialog downloadReDetectorMainDialog = this.this$0;
                Intrinsics.f(type, "type");
                downloadReDetectorMainDialog.x0(type.intValue());
            }
        }));
        downloadResourcesDetectorViewModel.l().j(this, new b(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMainDialog$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                androidx.lifecycle.c0<com.transsnet.downloader.viewmodel.b> c0VarH;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = this.this$0.f60738u;
                if (downloadResourcesDetectorViewModel2 == null || (c0VarH = downloadResourcesDetectorViewModel2.h()) == null) {
                    return;
                }
                final DownloadReDetectorMainDialog downloadReDetectorMainDialog = this.this$0;
                c0VarH.j(downloadReDetectorMainDialog, new DownloadReDetectorMainDialog.b(new Function1<com.transsnet.downloader.viewmodel.b, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMainDialog$initViewModel$1$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.transsnet.downloader.viewmodel.b bVar) {
                        invoke2(bVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.transsnet.downloader.viewmodel.b bVar) {
                        DownloadBean downloadBeanB = bVar.b();
                        Subject subject = downloadReDetectorMainDialog.f60725h;
                        downloadBeanB.setGenre(subject != null ? subject.getGenre() : null);
                        DownloadBean downloadBeanB2 = bVar.b();
                        Subject subject2 = downloadReDetectorMainDialog.f60725h;
                        downloadBeanB2.setCurrentDubLanName(subject2 != null ? subject2.currentDubLandName() : null);
                        DownloadBean downloadBeanB3 = bVar.b();
                        Subject subject3 = downloadReDetectorMainDialog.f60725h;
                        downloadBeanB3.setCurrentDubLanCode(subject3 != null ? subject3.currentDubLandCode() : null);
                        Function4 function4 = downloadReDetectorMainDialog.f60736s;
                        if (function4 != null) {
                            function4.invoke(Integer.valueOf(bVar.a()), bVar.c(), bVar.b(), Boolean.valueOf(bVar.d()));
                        }
                    }
                }));
            }
        }));
        downloadResourcesDetectorViewModel.A().j(this, new b(new Function1<f00.b, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMainDialog$initViewModel$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.b bVar) {
                Function1 function1;
                if (bVar == null || (function1 = this.this$0.f60737t) == null) {
                    return;
                }
                function1.invoke(bVar);
            }
        }));
        this.f60738u = downloadResourcesDetectorViewModel;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final Fragment s0(int i11) {
        androidx.lifecycle.c0<ResourcesSeasonList> c0VarX;
        androidx.lifecycle.c0<DubsInfoData> c0VarM;
        dubsInfoDataF = null;
        DubsInfoData dubsInfoDataF = null;
        switch (i11) {
            case 2:
                return DownloadReDetectorGroupMainFragment.W.a(this.f60728k, this.f60729l, this.f60725h, this.f60727j, this.f60730m, this.f60731n, this.f60732o, this.f60739v, this.f60734q);
            case 3:
                return DownloadReDetectorAnalysingFragment.J.a(this.f60724g, this.f60725h, this.f60728k, this.f60729l, this.f60730m, this.f60721c, Boolean.valueOf(this.f60735r), this.f60732o);
            case 4:
                return DownloadReDetectorPathSettingFragment.A.a(this.f60722d);
            case 5:
                return DownloadReDetectorShortTVFragment.X.a(this.f60728k, this.f60729l, this.f60725h, this.f60726i, this.f60727j, this.f60730m, this.f60732o, this.f60733p);
            case 6:
                return DownloadReDetectorShortTVADFragment.A.a();
            case 7:
                return DownloadReDetectorMultiFragment.R.a(this.f60728k, this.f60729l, this.f60725h, this.f60727j, this.f60730m, this.f60731n, this.f60732o, this.f60739v);
            case 8:
                DownloadSeasonsSelectFragment.a aVar = DownloadSeasonsSelectFragment.B;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = this.f60738u;
                ResourcesSeasonList resourcesSeasonListF = (downloadResourcesDetectorViewModel == null || (c0VarX = downloadResourcesDetectorViewModel.x()) == null) ? null : c0VarX.f();
                Subject subject = this.f60725h;
                return aVar.a(resourcesSeasonListF, subject != null ? subject.getSubjectType() : null, this.f60734q);
            case 9:
                DownloadAudioTrackSelectDialog.a aVar2 = DownloadAudioTrackSelectDialog.A;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = this.f60738u;
                if (downloadResourcesDetectorViewModel2 != null && (c0VarM = downloadResourcesDetectorViewModel2.m()) != null) {
                    dubsInfoDataF = c0VarM.f();
                }
                return aVar2.a(dubsInfoDataF, this.f60734q);
            default:
                return DownloadReDetectorSingleResFragment.f60777z.a(this.f60732o);
        }
    }

    private final void t0() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().beginTransaction().hide(it.next()).commitNowAllowingStateLoss();
        }
    }

    public static final boolean u0(DownloadReDetectorMainDialog this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        int i12 = this$0.f60723f;
        if (i12 == 3) {
            uo.b.a.f(uo.b.f78622a, "DownloadReDetectorMainDialog", "back click~  anima do nothing", false, 4, null);
            return true;
        }
        if (i12 != this$0.f60722d) {
            uo.b.a.f(uo.b.f78622a, "DownloadReDetectorMainDialog", "back click~ show base", false, 4, null);
            this$0.x0(this$0.f60722d);
        } else {
            uo.b.a.f(uo.b.f78622a, "DownloadReDetectorMainDialog", "back click~ dismiss", false, 4, null);
            this$0.dismissAllowingStateLoss();
        }
        return true;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("download_main_dialog", false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        super.onCreate(bundle);
        if (bundle != null && bundle.getBoolean("key_download_save_instance")) {
            dismissAllowingStateLoss();
            return;
        }
        setStyle(0, R$style.DownloadBottomDialogTheme);
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString("extra_resource")) == null) {
            string = "";
        }
        this.f60721c = string;
        Bundle arguments2 = getArguments();
        this.f60722d = arguments2 != null ? arguments2.getInt("extra_download_page_type") : 1;
        Bundle arguments3 = getArguments();
        String string8 = arguments3 != null ? arguments3.getString("extra_page_from") : null;
        if (string8 == null) {
            string8 = "";
        }
        this.f60728k = string8;
        Bundle arguments4 = getArguments();
        String string9 = arguments4 != null ? arguments4.getString("extra_last_page_from") : null;
        if (string9 == null) {
            string9 = "";
        }
        this.f60729l = string9;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string2 = arguments5.getString("extra_group_id")) == null) {
            string2 = "";
        }
        this.f60727j = string2;
        Bundle arguments6 = getArguments();
        this.f60725h = (Subject) (arguments6 != null ? arguments6.getSerializable("extra_subject") : null);
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (string3 = arguments7.getString("extra_link_url")) == null) {
            string3 = "";
        }
        this.f60724g = string3;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (string4 = arguments8.getString("extra_ops")) == null) {
            string4 = "";
        }
        this.f60730m = string4;
        Bundle arguments9 = getArguments();
        if (arguments9 == null || (string5 = arguments9.getString("extra_target_resource_id")) == null) {
            string5 = "";
        }
        this.f60731n = string5;
        Bundle arguments10 = getArguments();
        this.f60735r = arguments10 != null ? arguments10.getBoolean("extra_download_execute_download", false) : false;
        Bundle arguments11 = getArguments();
        if (arguments11 == null || (string6 = arguments11.getString("extra_module_name")) == null) {
            string6 = "";
        }
        this.f60732o = string6;
        Bundle arguments12 = getArguments();
        if (arguments12 != null && (string7 = arguments12.getString("extra_subject_id")) != null) {
            str = string7;
        }
        this.f60726i = str;
        Bundle arguments13 = getArguments();
        this.f60733p = arguments13 != null ? arguments13.getBoolean("extra_download_scroll_to_download", false) : false;
        Bundle arguments14 = getArguments();
        this.f60739v = arguments14 != null ? arguments14.getInt("extra_season") : 0;
        Bundle arguments15 = getArguments();
        this.f60734q = arguments15 != null ? arguments15.getBoolean("extra_dialog_style") : true;
        initViewModel();
        x0(this.f60722d);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.f(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BottomShowAnimation);
            window.setGravity(80);
            window.setDimAmount(this.f60734q ? 0.5f : 0.0f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.transsnet.downloader.fragment.i0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                return DownloadReDetectorMainDialog.u0(this.f60924a, dialogInterface, i11, keyEvent);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        aVar.a().K(null);
        aVar.a().N(null);
        super.onDestroy();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(false);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("key_download_save_instance", true);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        super.show(manager, str);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(true);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }

    public final void v0(Function4<? super Integer, ? super String, ? super DownloadBean, ? super Boolean, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60736s = listener;
    }

    public final void w0(Function1<? super f00.b, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60737t = listener;
    }

    public final void x0(int i11) {
        String str;
        String str2 = "download_ana_single_resources";
        switch (i11) {
            case 2:
                str2 = "download_ana_series";
                break;
            case 3:
                str2 = "download_ana_animation";
                break;
            case 4:
                str2 = "download_path_setting";
                break;
            case 5:
                str2 = "download_short_tv";
                break;
            case 6:
                str2 = "download_short_tv_ad";
                break;
            case 7:
                str2 = "download_edu";
                break;
            case 8:
                str2 = "season_list";
                break;
            case 9:
                str2 = "audio_track";
                break;
        }
        uo.b.a.f(uo.b.f78622a, "DownloadReDetectorMainDialog", "showFragment tag = " + str2, false, 4, null);
        if (this.f60722d == 3 && (str = this.f60724g) != null && str.length() != 0 && (i11 == 1 || i11 == 2 || i11 == 7)) {
            this.f60722d = i11;
        }
        this.f60723f = i11;
        setCancelable((i11 == 3 || i11 == 6) ? false : true);
        t0();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str2);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = s0(i11);
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.fl_container, fragmentFindFragmentByTag, str2).commitNowAllowingStateLoss();
        }
    }
}
