package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.itransfer.ITransferApi;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.fragment.TransferMainFragment;
import com.transsnet.downloader.util.DownloadTransferUtils;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import h00.d1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
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
public final class TransferBottomToolsView extends ConstraintLayout {
    public static final a Companion = new a(null);
    public static final String LEFT_STATUS_CLOSE = "icon_status_close";
    public static final String LEFT_STATUS_SEND = "icon_status_send";
    public static final String SEND_STATUS_NONE = "SEND_STATUS_NONE";
    public static final String SEND_STATUS_NONE_FAIL = "SEND_STATUS_NONE_FAIL";
    public static final String SEND_STATUS_SENDING = "SEND_STATUS_SENDING";
    public static final String SEND_STATUS_SENDING_FAIL = "SEND_STATUS_SENDING_FAIL";
    public static final String STATUS_DEFAULT = "status_default";
    public static final String STATUS_SEND = "status_send";
    public static final String TAG = "Transfer_d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f61355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadViewModel f61356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f61358d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f61359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public my.b f61360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TransferMainFragment f61361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f61362i;

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
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61363a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61363a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61363a;
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
            this.f61363a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferBottomToolsView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferBottomToolsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferBottomToolsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61358d = LEFT_STATUS_CLOSE;
        this.f61359f = true;
        View.inflate(getContext(), R$layout.view_transfer_bottom_tools, this);
        d1 d1VarA = d1.a(this);
        Intrinsics.f(d1VarA, "bind(this)");
        this.f61355a = d1VarA;
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.f61356b = (DownloadViewModel) new v0((FragmentActivity) context2).a(DownloadViewModel.class);
        w();
        l();
        this.f61362i = true;
    }

    private final void l() {
        this.f61355a.f65805v.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.m(this.f61396a, view);
            }
        });
        this.f61355a.f65798o.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.n(this.f61397a, view);
            }
        });
        this.f61355a.f65792i.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.o(this.f61398a, view);
            }
        });
        this.f61355a.f65800q.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.p(this.f61399a, view);
            }
        });
        this.f61355a.f65793j.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.q(this.f61400a, view);
            }
        });
        this.f61355a.f65808y.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.r(this.f61401a, view);
            }
        });
        this.f61355a.f65809z.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.s(this.f61402a, view);
            }
        });
        this.f61355a.f65807x.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.t(this.f61403a, view);
            }
        });
        this.f61355a.f65794k.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.u(this.f61372a, view);
            }
        });
        this.f61355a.f65804u.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferBottomToolsView.v(this.f61373a, view);
            }
        });
    }

    public static final void m(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.z();
    }

    public static final void n(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y();
    }

    public static final void o(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y();
    }

    public static final void p(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C();
    }

    public static final void q(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C();
    }

    public static final void r(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(this$0.f61355a.f65808y.hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.D();
    }

    public static final void s(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(this$0.f61355a.f65809z.hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.D();
    }

    private final void setLeftUIVisibility(boolean z11) {
        if (z11) {
            E(this.f61358d);
            return;
        }
        AppCompatTextView appCompatTextView = this.f61355a.f65798o;
        Intrinsics.f(appCompatTextView, "viewBinding.tvClose");
        so.c.g(appCompatTextView);
        AppCompatImageView appCompatImageView = this.f61355a.f65792i;
        Intrinsics.f(appCompatImageView, "viewBinding.ivClose");
        so.c.g(appCompatImageView);
        Group group = this.f61355a.f65789f;
        Intrinsics.f(group, "viewBinding.groupList");
        so.c.g(group);
    }

    public static /* synthetic */ void setSendIconStatus$default(TransferBottomToolsView transferBottomToolsView, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        transferBottomToolsView.setSendIconStatus(str, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSendLoadingVisibility(boolean z11) {
        ProgressBar progressBar = this.f61355a.f65796m;
        Intrinsics.f(progressBar, "viewBinding.pbLoading");
        progressBar.setVisibility(z11 ? 0 : 8);
        AppCompatTextView appCompatTextView = this.f61355a.f65801r;
        Intrinsics.f(appCompatTextView, "viewBinding.tvSend");
        appCompatTextView.setVisibility(z11 ^ true ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSendSize(int i11) {
        String string = Utils.a().getString(R$string.download_transfer_btn_send);
        Intrinsics.f(string, "getApp().getString(R.str…wnload_transfer_btn_send)");
        AppCompatTextView appCompatTextView = this.f61355a.f65801r;
        if (i11 > 0) {
            string = string + " (" + (i11 > 99 ? "99+" : Integer.valueOf(i11)) + ")";
        }
        appCompatTextView.setText(string);
    }

    public static final void t(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(this$0.f61355a.f65807x.hashCode(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.B();
    }

    public static final void u(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.A();
    }

    public static final void v(TransferBottomToolsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.A();
    }

    private final void w() {
        androidx.lifecycle.c0<Integer> c0VarD = this.f61356b.D();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarD.j((FragmentActivity) context, new b(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.TransferBottomToolsView$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer size) {
                TransferBottomToolsView transferBottomToolsView = this.this$0;
                Intrinsics.f(size, "size");
                transferBottomToolsView.setSendSize(size.intValue());
            }
        }));
        androidx.lifecycle.c0<Integer> c0VarG = this.f61356b.G();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarG.j((FragmentActivity) context2, new b(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.TransferBottomToolsView$initViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer tab) {
                TransferBottomToolsView transferBottomToolsView = this.this$0;
                Intrinsics.f(tab, "tab");
                transferBottomToolsView.f61357c = tab.intValue();
            }
        }));
    }

    private final void y() {
        C();
        changeStatus(STATUS_DEFAULT);
    }

    public final void A() {
        my.b bVar;
        if (this.f61359f || (bVar = this.f61360g) == null) {
            return;
        }
        bVar.b();
    }

    public final void B() {
        ITransferApi iTransferApi = (ITransferApi) com.alibaba.android.arouter.launcher.a.d().h(ITransferApi.class);
        Object context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        iTransferApi.J0((androidx.lifecycle.u) context);
    }

    public final void C() {
        clearSelectStatus();
    }

    public final void D() {
        if (x()) {
            uo.b.f78622a.t(TAG, "onSendClick, isSendLoading-------", true);
            zp.b.f82110a.d(R$string.download_transfer_sending);
            return;
        }
        androidx.lifecycle.c0<List<DownloadBean>> c0VarB = this.f61356b.B(this.f61357c);
        List<DownloadBean> listF = c0VarB != null ? c0VarB.f() : null;
        uo.b.f78622a.c(TAG, "onSendClick, size:" + (listF != null ? Integer.valueOf(listF.size()) : null), true);
        List<DownloadBean> list = listF;
        if (list != null && !list.isEmpty()) {
            setSendLoadingVisibility(true);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        DownloadTransferUtils downloadTransferUtils = DownloadTransferUtils.f61135a;
        Context context = getContext();
        Intrinsics.f(context, "this.context");
        downloadTransferUtils.d(context, listF, new Function1<List<FileData>, Unit>() { // from class: com.transsnet.downloader.widget.TransferBottomToolsView$onSendClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<FileData> list2) {
                invoke2(list2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FileData> fileDataList) {
                Intrinsics.g(fileDataList, "fileDataList");
                this.this$0.setSendLoadingVisibility(false);
                uo.b.a aVar = uo.b.f78622a;
                aVar.r(TransferBottomToolsView.TAG, "transform data duration:" + (System.currentTimeMillis() - jCurrentTimeMillis), true);
                aVar.c(TransferBottomToolsView.TAG, "onSendClick--2, isDownloadTab:" + this.this$0.f61359f + ", size:" + fileDataList.size() + ",data:" + fileDataList, true);
                if (this.this$0.f61359f) {
                    ry.b.f75768a.j(fileDataList);
                    ITransferApi iTransferApi = (ITransferApi) com.alibaba.android.arouter.launcher.a.d().h(ITransferApi.class);
                    Object context2 = this.this$0.getContext();
                    Intrinsics.e(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    iTransferApi.F0((androidx.lifecycle.u) context2);
                } else {
                    ry.b.f75768a.a(fileDataList);
                    my.b bVar = this.this$0.f61360g;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
                this.this$0.clearSelectStatus();
            }
        });
    }

    public final void E(String str) {
        if (Intrinsics.b(str, LEFT_STATUS_CLOSE)) {
            AppCompatTextView appCompatTextView = this.f61355a.f65798o;
            Intrinsics.f(appCompatTextView, "viewBinding.tvClose");
            so.c.k(appCompatTextView);
            AppCompatImageView appCompatImageView = this.f61355a.f65792i;
            Intrinsics.f(appCompatImageView, "viewBinding.ivClose");
            so.c.k(appCompatImageView);
            Group group = this.f61355a.f65789f;
            Intrinsics.f(group, "viewBinding.groupList");
            so.c.g(group);
            return;
        }
        AppCompatTextView appCompatTextView2 = this.f61355a.f65798o;
        Intrinsics.f(appCompatTextView2, "viewBinding.tvClose");
        so.c.h(appCompatTextView2);
        AppCompatImageView appCompatImageView2 = this.f61355a.f65792i;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivClose");
        so.c.h(appCompatImageView2);
        Group group2 = this.f61355a.f65789f;
        Intrinsics.f(group2, "viewBinding.groupList");
        so.c.k(group2);
    }

    public final void changeStatus(String status) {
        Intrinsics.g(status, "status");
        if (Intrinsics.b(status, STATUS_SEND)) {
            Group group = this.f61355a.f65790g;
            Intrinsics.f(group, "viewBinding.groupSend");
            so.c.k(group);
            setLeftUIVisibility(true);
            Group group2 = this.f61355a.f65788d;
            Intrinsics.f(group2, "viewBinding.groupDef");
            so.c.g(group2);
            return;
        }
        Group group3 = this.f61355a.f65788d;
        Intrinsics.f(group3, "viewBinding.groupDef");
        so.c.k(group3);
        Group group4 = this.f61355a.f65790g;
        Intrinsics.f(group4, "viewBinding.groupSend");
        so.c.g(group4);
        setLeftUIVisibility(false);
    }

    public final void clearSelectStatus() {
        Iterator<Map.Entry<Integer, androidx.lifecycle.c0<List<DownloadBean>>>> it = this.f61356b.C().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().q(new ArrayList());
        }
        this.f61356b.A().q(Boolean.TRUE);
        this.f61356b.y().q(Boolean.FALSE);
        this.f61356b.D().q(0);
    }

    public final void onPageNotVisible() {
    }

    public final void setBehaviorListener(my.b bVar) {
        this.f61360g = bVar;
    }

    public final void setLeftIconStatus(String status) {
        Intrinsics.g(status, "status");
        if (Intrinsics.b(this.f61358d, status)) {
            return;
        }
        this.f61358d = status;
        Group group = this.f61355a.f65790g;
        Intrinsics.f(group, "viewBinding.groupSend");
        if (group.getVisibility() == 0) {
            E(status);
        }
    }

    public final void setPageStatus(boolean z11) {
        this.f61359f = z11;
    }

    public final void setParentFragment(TransferMainFragment fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f61361h = fragment;
    }

    public final void setSendIconStatus(String status, int i11) {
        Intrinsics.g(status, "status");
        int iHashCode = status.hashCode();
        if (iHashCode != -562350193) {
            if (iHashCode != -344681223) {
                if (iHashCode == 695846276 && status.equals(SEND_STATUS_SENDING)) {
                    AppCompatTextView appCompatTextView = this.f61355a.f65803t;
                    appCompatTextView.setText(i11 <= 99 ? String.valueOf(i11) : "99+");
                    appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.text_01));
                    Glide.with(getContext()).load2(Integer.valueOf(com.transsion.baselib.utils.o.f51321a.a() ? R$mipmap.ic_transfer_send_ing_dark : R$mipmap.ic_transfer_send_ing)).into(this.f61355a.f65794k);
                    return;
                }
            } else if (status.equals(SEND_STATUS_SENDING_FAIL)) {
                AppCompatTextView appCompatTextView2 = this.f61355a.f65803t;
                appCompatTextView2.setText(i11 <= 99 ? String.valueOf(i11) : "99+");
                appCompatTextView2.setTextColor(z2.a.getColor(appCompatTextView2.getContext(), R$color.error_red));
                Glide.with(getContext()).load2(Integer.valueOf(R$mipmap.ic_transfer_send_ing_error)).into(this.f61355a.f65794k);
                return;
            }
        } else if (status.equals(SEND_STATUS_NONE_FAIL)) {
            this.f61355a.f65803t.setText("");
            this.f61355a.f65794k.setImageResource(R$drawable.ic_transfer_send_none_error);
            return;
        }
        this.f61355a.f65803t.setText("");
        this.f61355a.f65794k.setImageResource(R$drawable.ic_transfer_send_none);
    }

    public final void showConnectContent(boolean z11, String clientPhoneName) {
        Intrinsics.g(clientPhoneName, "clientPhoneName");
        this.f61362i = z11;
        this.f61355a.f65806w.setText(getContext().getString(z11 ? R$string.download_transfer_connect_to : R$string.download_transfer_disconnect_to, clientPhoneName));
        uo.b.a.f(uo.b.f78622a, TAG, "showConnectContent, connect:" + z11 + " 连接的手机名:" + clientPhoneName, false, 4, null);
        this.f61355a.f65795l.setImageResource(z11 ? com.transsion.transfer.R$mipmap.transfer_ic_link : com.transsion.transfer.R$mipmap.transfer_ic_unlink);
    }

    public final void showConnectUI(boolean z11) {
        Group group = this.f61355a.f65791h;
        Intrinsics.f(group, "viewBinding.groupTopConnect");
        group.setVisibility(z11 ? 0 : 8);
        AppCompatTextView appCompatTextView = this.f61355a.f65805v;
        Intrinsics.f(appCompatTextView, "viewBinding.tvTopDisconnect");
        appCompatTextView.setVisibility(z11 ? 0 : 8);
    }

    public final boolean x() {
        ProgressBar progressBar = this.f61355a.f65796m;
        Intrinsics.f(progressBar, "viewBinding.pbLoading");
        return progressBar.getVisibility() == 0;
    }

    public final void z() {
        my.b bVar = this.f61360g;
        if (bVar != null) {
            bVar.a();
        }
    }
}
