package com.transsnet.downloader.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class DownloadAudioTrackSelectDialog extends DownloadReDetectorBaseFragment<h00.v> {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DubsInfoData f60500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.transsnet.downloader.adapter.d f60501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f60502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f60503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f60504z = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadAudioTrackSelectDialog a(DubsInfoData dubsInfoData, boolean z11) {
            DownloadAudioTrackSelectDialog downloadAudioTrackSelectDialog = new DownloadAudioTrackSelectDialog();
            downloadAudioTrackSelectDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_dialog_style", Boolean.valueOf(z11))));
            downloadAudioTrackSelectDialog.t1(dubsInfoData);
            return downloadAudioTrackSelectDialog;
        }
    }

    public static final void q1(DownloadAudioTrackSelectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.s1();
    }

    public static final void r1(DownloadAudioTrackSelectDialog this$0, com.transsnet.downloader.adapter.d this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<DubsInfo> listD;
        List<DubsInfo> listD2;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f60502x == 0 || System.currentTimeMillis() - this$0.f60502x > 1000) {
            this$0.f60502x = System.currentTimeMillis();
            com.transsnet.downloader.adapter.d dVar = this$0.f60501w;
            if (dVar != null && (listD = dVar.D()) != null) {
                Iterator<DubsInfo> it = listD.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i12 = -1;
                        break;
                    } else if (Intrinsics.b(this$0.f60503y, it.next().getSubjectId())) {
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i12 >= 0) {
                    com.transsnet.downloader.adapter.d dVar2 = this$0.f60501w;
                    DubsInfo dubsInfo = (dVar2 == null || (listD2 = dVar2.D()) == null) ? null : listD2.get(i12);
                    if (dubsInfo != null) {
                        dubsInfo.setSelected(false);
                    }
                    com.transsnet.downloader.adapter.d dVar3 = this$0.f60501w;
                    if (dVar3 != null) {
                        dVar3.notifyItemChanged(i12);
                    }
                }
            }
            DubsInfo item = this_apply.getItem(i11);
            this$0.f60503y = item.getSubjectId();
            item.setSelected(true);
            com.transsnet.downloader.adapter.d dVar4 = this$0.f60501w;
            if (dVar4 != null) {
                dVar4.notifyItemChanged(i11);
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
            androidx.lifecycle.c0<DubsInfo> c0VarN = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.n() : null;
            if (c0VarN != null) {
                c0VarN.q(item);
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this$0.Y0();
            androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.f() : null;
            if (c0VarF != null) {
                c0VarF.q(item.getSubjectId());
            }
            this$0.s1();
        }
    }

    private final void s1() {
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(2);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f60504z = arguments != null ? arguments.getBoolean("extra_dialog_style") : true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public h00.v getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.v vVarC = h00.v.c(inflater);
        Intrinsics.f(vVarC, "inflate(inflater)");
        return vVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void t1(DubsInfoData dubsInfoData) {
        this.f60500v = dubsInfoData;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0061  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        List<DubsInfo> dubs;
        androidx.lifecycle.c0<String> c0VarF;
        RecyclerView.m npaLinearLayoutManager;
        h00.v vVar = (h00.v) getMViewBinding();
        if (vVar != null) {
            if (!this.f60504z) {
                vVar.f66050b.setBackground(new DrawableCreator.Builder().setSolidColor(requireActivity().getResources().getColor(R$color.gray_dark_00)).build());
            }
            vVar.f66050b.getLayoutParams().height = T0();
            vVar.f66052d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadAudioTrackSelectDialog.q1(this.f60575a, view);
                }
            });
            RecyclerView recyclerView = vVar.f66053f;
            Context context = getContext();
            if (context != null) {
                Intrinsics.f(context, "context");
                if (com.transsion.baseui.util.b.a(context)) {
                    npaLinearLayoutManager = new NpaGridLayoutManager(requireContext(), 2);
                } else {
                    npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
                }
            } else {
                npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
            }
            recyclerView.setLayoutManager(npaLinearLayoutManager);
            RecyclerView recyclerView2 = vVar.f66053f;
            final com.transsnet.downloader.adapter.d dVar = new com.transsnet.downloader.adapter.d();
            this.f60501w = dVar;
            dVar.B0(new f9.d() { // from class: com.transsnet.downloader.dialog.d
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    DownloadAudioTrackSelectDialog.r1(this.f60577a, dVar, baseQuickAdapter, view, i11);
                }
            });
            recyclerView2.setAdapter(dVar);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        String strF = (downloadResourcesDetectorViewModelY0 == null || (c0VarF = downloadResourcesDetectorViewModelY0.f()) == null) ? null : c0VarF.f();
        this.f60503y = strF;
        DubsInfoData dubsInfoData = this.f60500v;
        if (dubsInfoData == null || (dubs = dubsInfoData.getDubs()) == null) {
            return;
        }
        List<DubsInfo> list = dubs;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list, 10));
        for (DubsInfo dubsInfo : list) {
            dubsInfo.setSelected(Intrinsics.b(dubsInfo.getSubjectId(), strF));
            arrayList.add(dubsInfo);
        }
        com.transsnet.downloader.adapter.d dVar2 = this.f60501w;
        if (dVar2 != null) {
            dVar2.w0(arrayList);
        }
    }
}
