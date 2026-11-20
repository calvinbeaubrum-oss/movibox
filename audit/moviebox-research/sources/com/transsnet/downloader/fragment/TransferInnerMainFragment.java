package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.server.TransferServer;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.downloader.widget.TransferSelectSeriesListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
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
public final class TransferInnerMainFragment extends TransferMainFragment implements com.transsion.transfer.impl.e, com.transsion.transfer.impl.b, my.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f60851w = new a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public my.b f60852m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f60854o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.transsion.transfer.impl.d f60857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f60858s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.transsion.transfer.impl.a f60860u;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f60853n = "内部";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f60855p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f60856q = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TransferInnerMainFragment$serverConnectListener$1 f60859t = new Function4<String, String, Boolean, String, Unit>() { // from class: com.transsnet.downloader.fragment.TransferInnerMainFragment$serverConnectListener$1
        public void a(String clientIp, String transferId, boolean z11, String str) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(transferId, "transferId");
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new TransferInnerMainFragment$serverConnectListener$1$invoke$1(this.f60863a, z11, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Boolean bool, String str3) {
            a(str, str2, bool.booleanValue(), str3);
            return Unit.f68710a;
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f60861v = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferInnerMainFragment a() {
            TransferInnerMainFragment transferInnerMainFragment = new TransferInnerMainFragment();
            transferInnerMainFragment.setArguments(androidx.core.os.c.a());
            return transferInnerMainFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60862a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60862a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60862a;
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
            this.f60862a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0() {
        TransferBottomToolsView transferBottomToolsView;
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.clearSelectStatus();
    }

    public static final void R0(TransferInnerMainFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.X0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void W0(TransferInnerMainFragment this$0, int i11, int i12) {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this$0.f60853n + " onTaskStateChange, transmittingCount：" + i11 + ",failCount:" + i12 + " ", false, 4, null);
        if (i11 > 0) {
            if (i12 == 0) {
                h00.m0 m0Var = (h00.m0) this$0.getMViewBinding();
                if (m0Var == null || (transferBottomToolsView4 = m0Var.f65953d) == null) {
                    return;
                }
                transferBottomToolsView4.setSendIconStatus(TransferBottomToolsView.SEND_STATUS_SENDING, i11);
                return;
            }
            h00.m0 m0Var2 = (h00.m0) this$0.getMViewBinding();
            if (m0Var2 == null || (transferBottomToolsView3 = m0Var2.f65953d) == null) {
                return;
            }
            transferBottomToolsView3.setSendIconStatus(TransferBottomToolsView.SEND_STATUS_SENDING_FAIL, i11);
            return;
        }
        if (i12 > 0) {
            h00.m0 m0Var3 = (h00.m0) this$0.getMViewBinding();
            if (m0Var3 == null || (transferBottomToolsView2 = m0Var3.f65953d) == null) {
                return;
            }
            TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView2, TransferBottomToolsView.SEND_STATUS_NONE_FAIL, 0, 2, null);
            return;
        }
        h00.m0 m0Var4 = (h00.m0) this$0.getMViewBinding();
        if (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) {
            return;
        }
        TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView, TransferBottomToolsView.SEND_STATUS_NONE, 0, 2, null);
    }

    private final void initViewModel() {
        m0().w().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.downloader.fragment.TransferInnerMainFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String status) {
                TransferBottomToolsView transferBottomToolsView;
                h00.m0 m0Var = (h00.m0) TransferInnerMainFragment.this.getMViewBinding();
                if (m0Var != null && (transferBottomToolsView = m0Var.f65953d) != null) {
                    Intrinsics.f(status, "status");
                    transferBottomToolsView.changeStatus(status);
                }
                if (Intrinsics.b(status, TransferBottomToolsView.STATUS_DEFAULT)) {
                    TransferInnerMainFragment.this.m0().D().q(0);
                }
            }
        }));
        n0().A();
        m0().y().j(this, new b(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferInnerMainFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                h00.m0 m0Var = (h00.m0) TransferInnerMainFragment.this.getMViewBinding();
                TransferSelectSeriesListView transferSelectSeriesListView = m0Var != null ? m0Var.f65954f : null;
                if (transferSelectSeriesListView == null) {
                    return;
                }
                Intrinsics.f(show, "show");
                transferSelectSeriesListView.setVisibility(show.booleanValue() ? 0 : 8);
            }
        }));
    }

    @Override // com.transsion.transfer.impl.e
    public void A(String clientIp) {
        Intrinsics.g(clientIp, "clientIp");
    }

    @Override // com.transsnet.downloader.fragment.TransferMainFragment, com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public h00.m0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.m0 m0VarC = h00.m0.c(inflater);
        Intrinsics.f(m0VarC, "inflate(inflater)");
        return m0VarC;
    }

    @Override // my.a
    public void F(my.b listener) {
        Intrinsics.g(listener, "listener");
        this.f60852m = listener;
    }

    @Override // com.transsion.transfer.impl.b
    public void L(String remoteFilePath, long j11, long j12) {
        Intrinsics.g(remoteFilePath, "remoteFilePath");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // my.a
    public void M(String name) {
        TransferBottomToolsView transferBottomToolsView;
        Intrinsics.g(name, "name");
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this.f60853n + " ====== setDeviceInfo ,连接成功setDeviceInfo ,连接成功:" + name, false, 4, null);
        this.f60855p = name;
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.showConnectContent(this.f60854o, name);
    }

    public final void N0() {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TransferBottomToolsView.TAG, this.f60853n + " TransferMainFragment, 已连接，初始化客户端", false, 4, null);
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.transfer.impl.a aVarF = TransferClient.f58969t.f();
            this.f60860u = aVarF;
            if (aVarF.h()) {
                uo.b.a.f(aVar, TransferBottomToolsView.TAG, this.f60853n + "  TransferMainFragment, 初始化客户端，hasConnected true", false, 4, null);
                aVarF.k(this);
                T0();
                U0();
            } else {
                P0();
            }
            Result.m163constructorimpl(aVarF);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void O0() {
        if (getContext() == null) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.s(aVar, TransferBottomToolsView.TAG, this.f60853n + " initTransferServer", false, 4, null);
        TransferServer.a aVar2 = TransferServer.f59075s;
        Context context = getContext();
        Intrinsics.d(context);
        com.transsion.transfer.impl.d dVarB = aVar2.b(context);
        this.f60857r = dVarB;
        dVarB.a(this);
        dVarB.b(this.f60859t);
        boolean z11 = !dVarB.c().isEmpty();
        uo.b.a.f(aVar, TransferBottomToolsView.TAG, this.f60853n + " --initTransferServer， isConnect：" + z11, false, 4, null);
        this.f60858s = z11;
        if (z11) {
            Q0();
        } else {
            S0();
        }
    }

    public final void P0() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new TransferInnerMainFragment$onClientDisconnect$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q0() {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        this.f60856q.clear();
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null && (transferBottomToolsView3 = m0Var.f65953d) != null) {
            transferBottomToolsView3.showConnectUI(true);
        }
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView2 = m0Var2.f65953d) != null) {
            transferBottomToolsView2.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_SEND);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView = m0Var3.f65953d) != null) {
            transferBottomToolsView.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.t1
                @Override // java.lang.Runnable
                public final void run() {
                    TransferInnerMainFragment.R0(this.f60962a);
                }
            }, 1000L);
        }
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this.f60853n + " TransferConnect ,连接成功", false, 4, null);
        M0();
    }

    @Override // com.transsion.transfer.impl.b
    public void R(String remoteFilePath, TaskState state, long j11, long j12, long j13, String str) {
        Intrinsics.g(remoteFilePath, "remoteFilePath");
        Intrinsics.g(state, "state");
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new TransferInnerMainFragment$onTaskStateChange$3(state, this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S0() {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null && (transferBottomToolsView4 = m0Var.f65953d) != null) {
            transferBottomToolsView4.showConnectUI(true);
        }
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView3 = m0Var2.f65953d) != null) {
            transferBottomToolsView3.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_CLOSE);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView2 = m0Var3.f65953d) != null) {
            String str = (String) CollectionsKt___CollectionsKt.g0(this.f60856q);
            if (str == null) {
                str = "";
            }
            transferBottomToolsView2.showConnectContent(false, str);
        }
        h00.m0 m0Var4 = (h00.m0) getMViewBinding();
        if (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) {
            return;
        }
        TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView, TransferBottomToolsView.SEND_STATUS_NONE, 0, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T0() {
        String strJ;
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        com.transsion.transfer.impl.a aVar = this.f60860u;
        if (aVar == null || (strJ = aVar.j()) == null) {
            strJ = "";
        }
        uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, this.f60853n + "  TransferMainFragment, 客户端，updateTransferConnectStatus，serverInfo:" + strJ, false, 4, null);
        if (strJ.length() > 0) {
            this.f60861v = strJ;
            h00.m0 m0Var = (h00.m0) getMViewBinding();
            if (m0Var != null && (transferBottomToolsView4 = m0Var.f65953d) != null) {
                transferBottomToolsView4.changeStatus(TransferBottomToolsView.STATUS_SEND);
            }
            h00.m0 m0Var2 = (h00.m0) getMViewBinding();
            if (m0Var2 != null && (transferBottomToolsView3 = m0Var2.f65953d) != null) {
                transferBottomToolsView3.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_SEND);
            }
            h00.m0 m0Var3 = (h00.m0) getMViewBinding();
            if (m0Var3 != null && (transferBottomToolsView2 = m0Var3.f65953d) != null) {
                transferBottomToolsView2.showConnectUI(true);
            }
            h00.m0 m0Var4 = (h00.m0) getMViewBinding();
            if (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) {
                return;
            }
            transferBottomToolsView.showConnectContent(true, strJ);
        }
    }

    @Override // com.transsion.transfer.impl.e
    public void U(String clientIp, String remoteFilePath, TaskState state, long j11, long j12) {
        com.transsion.transfer.impl.d dVar;
        Intrinsics.g(clientIp, "clientIp");
        Intrinsics.g(remoteFilePath, "remoteFilePath");
        Intrinsics.g(state, "state");
        if (this.f60856q.isEmpty() && (dVar = this.f60857r) != null) {
            this.f60856q.addAll(dVar.i());
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new TransferInnerMainFragment$onTaskStateChange$2(this, state, null), 3, null);
    }

    public final void U0() {
        ry.a aVar = ry.a.f75766a;
        int size = aVar.g().size();
        int size2 = aVar.f().size();
        int size3 = aVar.e().size();
        uo.b.a.s(uo.b.f78622a, TransferBottomToolsView.TAG, this.f60853n + "  onTaskStateChange 客户端 waitingCount:" + size + ",transferCount:" + size2, false, 4, null);
        V0(size + size2, size3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V0(final int i11, final int i12) {
        TransferBottomToolsView transferBottomToolsView;
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.post(new Runnable() { // from class: com.transsnet.downloader.fragment.u1
            @Override // java.lang.Runnable
            public final void run() {
                TransferInnerMainFragment.W0(this.f60966a, i11, i12);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // my.a
    public void W() {
        h00.m0 m0Var;
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        this.f60854o = true;
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView4 = m0Var2.f65953d) != null) {
            transferBottomToolsView4.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_SEND);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView3 = m0Var3.f65953d) != null) {
            TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView3, TransferBottomToolsView.SEND_STATUS_NONE, 0, 2, null);
        }
        h00.m0 m0Var4 = (h00.m0) getMViewBinding();
        if (m0Var4 != null && (transferBottomToolsView2 = m0Var4.f65953d) != null) {
            transferBottomToolsView2.showConnectUI(true);
        }
        if (this.f60855p.length() > 0 && (m0Var = (h00.m0) getMViewBinding()) != null && (transferBottomToolsView = m0Var.f65953d) != null) {
            transferBottomToolsView.showConnectContent(true, this.f60855p);
        }
        uo.b.a.o(uo.b.f78622a, TransferBottomToolsView.TAG, new String[]{this.f60853n + " ====== onConnect ,连接成功" + this.f60855p}, false, 4, null);
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0() {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        if (this.f60856q.isEmpty() && this.f60858s) {
            com.transsion.transfer.impl.d dVar = this.f60857r;
            if (dVar != null) {
                this.f60856q.addAll(dVar.i());
            }
            uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, this.f60853n + " updateTransferServerNameInfo ," + this.f60856q, false, 4, null);
            h00.m0 m0Var = (h00.m0) getMViewBinding();
            if (m0Var != null && (transferBottomToolsView2 = m0Var.f65953d) != null) {
                transferBottomToolsView2.showConnectUI(true);
            }
            h00.m0 m0Var2 = (h00.m0) getMViewBinding();
            if (m0Var2 == null || (transferBottomToolsView = m0Var2.f65953d) == null) {
                return;
            }
            String str = (String) CollectionsKt___CollectionsKt.g0(this.f60856q);
            if (str == null) {
                str = "";
            }
            transferBottomToolsView.showConnectContent(true, str);
        }
    }

    @Override // com.transsion.transfer.impl.b
    public void Y() {
        P0();
    }

    @Override // my.a
    public void Z(int i11, int i12) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new TransferInnerMainFragment$onStatusChange$1(this, i11, i12, null), 3, null);
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        n0().E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // my.a
    public void a() {
        TransferBottomToolsView transferBottomToolsView;
        h00.m0 m0Var;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        this.f60854o = false;
        uo.b.a.o(uo.b.f78622a, TransferBottomToolsView.TAG, new String[]{this.f60853n + " ====== onDisconnect onDisconnect: " + this.f60855p}, false, 4, null);
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView4 = m0Var2.f65953d) != null) {
            transferBottomToolsView4.setLeftIconStatus(TransferBottomToolsView.LEFT_STATUS_CLOSE);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView3 = m0Var3.f65953d) != null) {
            transferBottomToolsView3.showConnectUI(true);
        }
        if (this.f60855p.length() > 0 && (m0Var = (h00.m0) getMViewBinding()) != null && (transferBottomToolsView2 = m0Var.f65953d) != null) {
            transferBottomToolsView2.showConnectContent(false, this.f60855p);
        }
        h00.m0 m0Var4 = (h00.m0) getMViewBinding();
        if (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) {
            return;
        }
        TransferBottomToolsView.setSendIconStatus$default(transferBottomToolsView, TransferBottomToolsView.SEND_STATUS_NONE, 0, 2, null);
    }

    @Override // com.transsion.transfer.impl.e
    public void d(String clientIp) {
        Intrinsics.g(clientIp, "clientIp");
    }

    @Override // com.transsion.transfer.impl.e
    public void i(String clientIp, String remoteFilePath, long j11, long j12) {
        Intrinsics.g(clientIp, "clientIp");
        Intrinsics.g(remoteFilePath, "remoteFilePath");
    }

    @Override // com.transsnet.downloader.fragment.TransferMainFragment, com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        initViewModel();
        uo.b.a.o(uo.b.f78622a, TransferBottomToolsView.TAG, new String[]{this.f60853n + " TransferMainFragment, initData，内部 监听"}, false, 4, null);
        O0();
        N0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.TransferMainFragment, com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        AppCompatImageView appCompatImageView;
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null && (appCompatImageView = m0Var.f65955g) != null) {
            so.c.e(appCompatImageView);
        }
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView3 = m0Var2.f65953d) != null) {
            transferBottomToolsView3.setPageStatus(false);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (transferBottomToolsView2 = m0Var3.f65953d) != null) {
            transferBottomToolsView2.setParentFragment(this);
        }
        h00.m0 m0Var4 = (h00.m0) getMViewBinding();
        if (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) {
            return;
        }
        transferBottomToolsView.setBehaviorListener(this.f60852m);
    }

    @Override // com.transsion.transfer.impl.b
    public void l(int i11) {
    }

    @Override // com.transsnet.downloader.fragment.TransferMainFragment, com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsnet.downloader.fragment.TransferMainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.transfer.impl.d dVar = this.f60857r;
        if (dVar != null) {
            dVar.g(this);
        }
        com.transsion.transfer.impl.d dVar2 = this.f60857r;
        if (dVar2 != null) {
            dVar2.h(this.f60859t);
        }
        com.transsion.transfer.impl.a aVar = this.f60860u;
        if (aVar != null) {
            aVar.g(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.TransferMainFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        TransferBottomToolsView transferBottomToolsView;
        super.onHiddenChanged(z11);
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        X0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.TransferMainFragment, androidx.fragment.app.Fragment
    public void onStop() {
        TransferBottomToolsView transferBottomToolsView;
        super.onStop();
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    @Override // com.transsion.transfer.impl.e
    public void w(String clientIp) {
        Intrinsics.g(clientIp, "clientIp");
    }

    @Override // com.transsion.transfer.impl.e
    public void y(String clientIp, List<FileData> files) {
        Intrinsics.g(clientIp, "clientIp");
        Intrinsics.g(files, "files");
    }

    @Override // com.transsion.transfer.impl.b
    public void z(String remoteFilePath) {
        Intrinsics.g(remoteFilePath, "remoteFilePath");
    }
}
