package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadPathEntranceView;
import com.transsnet.downloader.widget.DownloadPremiumView;
import com.transsnet.downloader.widget.DownloadView;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
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
public final class DownloadReDetectorSingleResFragment extends DownloadReDetectorSingleResBaseFragment<h00.h0> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f60777z = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorSingleResFragment a(String str) {
            DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment = new DownloadReDetectorSingleResFragment();
            downloadReDetectorSingleResFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_module_name", str)));
            return downloadReDetectorSingleResFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ss.b {
        public b() {
        }

        @Override // ss.b
        public void a(boolean z11) {
            ss.b.a.a(this, z11);
        }

        @Override // ss.b
        public void onFail() {
        }

        @Override // ss.b
        public void onSuccess() {
            DownloadReDetectorSingleResFragment.this.u1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60779a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60779a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60779a;
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
            this.f60779a.invoke(obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    public static final void A1(DownloadReDetectorSingleResFragment this$0, View view) throws InterruptedException {
        boolean z11;
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        DownloadBean downloadBeanO1 = this$0.o1();
        String resourceId = downloadBeanO1 != null ? downloadBeanO1.getResourceId() : null;
        DownloadBean downloadBeanO2 = this$0.o1();
        if (downloadBeanO2 != null) {
            z11 = downloadBeanO2.isMultiresolution();
        }
        if (!downloadManagerApiA.m2(null, resourceId, false, z11)) {
            ITaskCenterApi iTaskCenterApi = (ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class);
            DownloadBean downloadBeanO3 = this$0.o1();
            Integer numValueOf = downloadBeanO3 != null ? Integer.valueOf(downloadBeanO3.getResolution()) : null;
            DownloadBean downloadBeanO4 = this$0.o1();
            iTaskCenterApi.t(numValueOf, downloadBeanO4 != null ? downloadBeanO4.getGenre() : null, this$0.new b());
            return;
        }
        DownloadBean downloadBeanO5 = this$0.o1();
        if (downloadBeanO5 == null || (subjectId = downloadBeanO5.getSubjectId()) == null) {
            return;
        }
        DownloadManagerApi downloadManagerApiA2 = aVar.a();
        Context context = this$0.getContext();
        Intrinsics.d(context);
        DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, "Download_Dialog", null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x1() {
        DownloadPathEntranceView downloadPathEntranceView;
        DownloadPathEntranceView downloadPathEntranceView2;
        if (m1()) {
            h00.h0 h0Var = (h00.h0) getMViewBinding();
            if (h0Var == null || (downloadPathEntranceView2 = h0Var.f65895j) == null) {
                return;
            }
            downloadPathEntranceView2.onPermissionDenied();
            return;
        }
        h00.h0 h0Var2 = (h00.h0) getMViewBinding();
        if (h0Var2 == null || (downloadPathEntranceView = h0Var2.f65895j) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionRefresh();
    }

    public static final void z1(DownloadReDetectorSingleResFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1() {
        DownloadView downloadView;
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var == null || (downloadView = h0Var.f65892g) == null) {
            return;
        }
        DownloadBean downloadBeanO1 = o1();
        DownloadView.setShowType$default(downloadView, null, downloadBeanO1 != null ? downloadBeanO1.getResourceId() : null, Boolean.FALSE, false, 0, 24, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void b1() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.b1();
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionGranted();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void c1() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.c1();
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionDenied();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void d1() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.d1();
        if (m1()) {
            l1();
            return;
        }
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionGranted();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void e1() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.e1();
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionRefresh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        DownloadView downloadView;
        ImageView imageView;
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var != null && (imageView = h0Var.f65889c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorSingleResFragment.z1(this.f60914a, view);
                }
            });
        }
        h00.h0 h0Var2 = (h00.h0) getMViewBinding();
        if (h0Var2 == null || (downloadView = h0Var2.f65892g) == null) {
            return;
        }
        downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                DownloadReDetectorSingleResFragment.A1(this.f60917a, view);
            }
        });
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<List<f00.b>> c0VarQ;
        androidx.lifecycle.c0<f00.b> c0VarA;
        super.initViewModel();
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "single， initViewModel  ", false, 4, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            if (downloadResourcesDetectorViewModelY0 != null && (c0VarA = downloadResourcesDetectorViewModelY0.A()) != null) {
                c0VarA.j(parentFragment, new c(new Function1<f00.b, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$initViewModel$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(f00.b bVar) {
                        invoke2(bVar);
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(f00.b bVar) {
                        DownloadPathEntranceView downloadPathEntranceView;
                        if (bVar == null) {
                            return;
                        }
                        this.this$0.h1(bVar);
                        uo.b.a aVar2 = uo.b.f78622a;
                        String TAG2 = this.this$0.X0();
                        Intrinsics.f(TAG2, "TAG");
                        uo.b.a.f(aVar2, TAG2, "path select path = " + bVar.d() + " ", false, 4, null);
                        h00.h0 h0Var = (h00.h0) this.this$0.getMViewBinding();
                        if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
                            return;
                        }
                        downloadPathEntranceView.updatePathName(bVar.d(), bVar.a());
                    }
                }));
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
            if (downloadResourcesDetectorViewModelY1 != null && (c0VarQ = downloadResourcesDetectorViewModelY1.q()) != null) {
                c0VarQ.j(parentFragment, new c(new Function1<List<f00.b>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$initViewModel$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<f00.b> list) {
                        invoke2(list);
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<f00.b> list) {
                        DownloadPathEntranceView downloadPathEntranceView;
                        for (f00.b bVar : list) {
                            if (bVar.f()) {
                                this.this$0.h1(bVar);
                                uo.b.a aVar2 = uo.b.f78622a;
                                String TAG2 = this.this$0.X0();
                                Intrinsics.f(TAG2, "TAG");
                                uo.b.a.f(aVar2, TAG2, "cur download path = " + bVar.d() + " ", false, 4, null);
                                RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
                                roomAppMMKV.a().putString("download_root_path", bVar.b());
                                roomAppMMKV.a().putString("download_root_path_name", bVar.d());
                                roomAppMMKV.a().putInt("download_root_path_type", bVar.e());
                                h00.h0 h0Var = (h00.h0) this.this$0.getMViewBinding();
                                if (h0Var == null || (downloadPathEntranceView = h0Var.f65895j) == null) {
                                    return;
                                }
                                downloadPathEntranceView.updatePathName(bVar.d(), bVar.a());
                                return;
                            }
                        }
                    }
                }));
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
        if (downloadResourcesDetectorViewModelY2 != null) {
            downloadResourcesDetectorViewModelY2.u();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment
    public void t1(DownloadBean item) {
        String sizeFormat;
        h00.o0 o0Var;
        DownloadPremiumView downloadPremiumView;
        Integer requireMemberType;
        h00.o0 o0Var2;
        DownloadPremiumView downloadPremiumView2;
        h00.o0 o0Var3;
        h00.o0 o0Var4;
        h00.o0 o0Var5;
        AppCompatTextView appCompatTextView;
        h00.o0 o0Var6;
        Intrinsics.g(item, "item");
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        AppCompatImageView appCompatImageView = null;
        AppCompatTextView appCompatTextView2 = (h0Var == null || (o0Var6 = h0Var.f65888b) == null) ? null : o0Var6.f65978h;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(item.getTotalTitleName());
        }
        h00.h0 h0Var2 = (h00.h0) getMViewBinding();
        if (h0Var2 != null && (o0Var5 = h0Var2.f65888b) != null && (appCompatTextView = o0Var5.f65975d) != null) {
            so.c.g(appCompatTextView);
        }
        if (TextUtils.isEmpty(item.getSizeFormat())) {
            Long size = item.getSize();
            sizeFormat = size != null ? tp.a.a(size.longValue(), 1) : null;
        } else {
            sizeFormat = item.getSizeFormat();
        }
        Long duration = item.getDuration();
        String str = sizeFormat + " · " + TimeUtilKt.i((duration != null ? duration.longValue() : 0L) * ((long) 1000));
        h00.h0 h0Var3 = (h00.h0) getMViewBinding();
        AppCompatTextView appCompatTextView3 = (h0Var3 == null || (o0Var4 = h0Var3.f65888b) == null) ? null : o0Var4.f65976f;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(str);
        }
        h00.h0 h0Var4 = (h00.h0) getMViewBinding();
        if (h0Var4 != null && (o0Var3 = h0Var4.f65888b) != null) {
            appCompatImageView = o0Var3.f65973b;
        }
        if (appCompatImageView != null) {
            appCompatImageView.setSelected(true);
        }
        if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1() && (requireMemberType = item.getRequireMemberType()) != null && requireMemberType.intValue() == 1) {
            h00.h0 h0Var5 = (h00.h0) getMViewBinding();
            if (h0Var5 != null && (o0Var2 = h0Var5.f65888b) != null && (downloadPremiumView2 = o0Var2.f65974c) != null) {
                so.c.k(downloadPremiumView2);
            }
        } else {
            h00.h0 h0Var6 = (h00.h0) getMViewBinding();
            if (h0Var6 != null && (o0Var = h0Var6.f65888b) != null && (downloadPremiumView = o0Var.f65974c) != null) {
                so.c.g(downloadPremiumView);
            }
        }
        B1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        String string;
        DownloadPathEntranceView downloadPathEntranceView;
        LinearLayoutCompat linearLayoutCompat;
        ViewGroup.LayoutParams layoutParams;
        HashMap<String, String> mapG;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("extra_module_name")) == null) {
            string = "";
        }
        s1(string);
        r1(true);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put("type", "1");
        }
        h00.h0 h0Var = (h00.h0) getMViewBinding();
        if (h0Var != null && (linearLayoutCompat = h0Var.f65891f) != null && (layoutParams = linearLayoutCompat.getLayoutParams()) != null) {
            layoutParams.height = V0();
        }
        h00.h0 h0Var2 = (h00.h0) getMViewBinding();
        if (h0Var2 != null && (downloadPathEntranceView = h0Var2.f65895j) != null) {
            downloadPathEntranceView.setChangeClickCallback(new Function1<View, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$initViewData$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this.this$0.Y0();
                    androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
                    if (c0VarO == null) {
                        return;
                    }
                    c0VarO.q(4);
                }
            });
            downloadPathEntranceView.setPermissionClickCallback(new Function1<View, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$initViewData$2$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    DownloadUtil downloadUtil = DownloadUtil.f61136a;
                    if (downloadUtil.w()) {
                        if (this.this$0.m1()) {
                            this.this$0.l1();
                        }
                    } else if (this.this$0.Z0()) {
                        this.this$0.i1(false);
                        RoomAppMMKV.f51271a.a().putBoolean("download_root_path_permission_first", false);
                        this.this$0.W0().a(downloadUtil.m());
                    } else if (!downloadUtil.y(this.this$0)) {
                        this.this$0.W0().a(downloadUtil.m());
                    } else {
                        this.this$0.j1(true);
                        com.transsnet.downloader.viewmodel.c.f61276a.C();
                    }
                }
            });
        }
        x1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: y1, reason: merged with bridge method [inline-methods] */
    public h00.h0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.h0 h0VarC = h00.h0.c(inflater);
        Intrinsics.f(h0VarC, "inflate(inflater)");
        return h0VarC;
    }
}
