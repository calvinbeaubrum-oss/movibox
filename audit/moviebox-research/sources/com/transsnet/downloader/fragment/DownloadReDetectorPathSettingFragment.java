package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
public final class DownloadReDetectorPathSettingFragment extends DownloadReDetectorBaseFragment<h00.e0> {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.transsnet.downloader.adapter.i f60750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f60751w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f60752x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f60753y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f00.b f60754z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorPathSettingFragment a(int i11) {
            DownloadReDetectorPathSettingFragment downloadReDetectorPathSettingFragment = new DownloadReDetectorPathSettingFragment();
            downloadReDetectorPathSettingFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_page_type", Integer.valueOf(i11))));
            return downloadReDetectorPathSettingFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60755a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60755a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60755a;
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
            this.f60755a.invoke(obj);
        }
    }

    public static final void w1(DownloadReDetectorPathSettingFragment this$0, View view) {
        List<f00.b> listD;
        Intrinsics.g(this$0, "this$0");
        com.transsnet.downloader.adapter.i iVar = this$0.f60750v;
        int size = (iVar == null || (listD = iVar.D()) == null) ? 0 : listD.size();
        int i11 = this$0.f60752x;
        if (size > i11) {
            com.transsnet.downloader.adapter.i iVar2 = this$0.f60750v;
            this$0.v1(iVar2 != null ? iVar2.getItem(i11) : null, this$0.f60752x);
        }
        if (this$0.f60751w == 4) {
            this$0.S0();
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(Integer.valueOf(this$0.f60751w));
    }

    public static final void x1(DownloadReDetectorPathSettingFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "DownloadReDetector", "Confirm click ----selectedInfo = " + this$0.f60754z, false, 4, null);
        f00.b bVar = this$0.f60754z;
        if (bVar != null) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            roomAppMMKV.a().putString("download_root_path", bVar.b());
            roomAppMMKV.a().putString("download_root_path_name", bVar.d());
            roomAppMMKV.a().putInt("download_root_path_type", bVar.e());
            DownloadEsHelper.a aVar = DownloadEsHelper.f60994m;
            aVar.a().M(bVar.b());
            aVar.a().N(bVar.d());
            aVar.a().O(bVar.e());
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        androidx.lifecycle.c0<f00.b> c0VarA = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.A() : null;
        if (c0VarA != null) {
            c0VarA.q(this$0.f60754z);
        }
        this$0.f60752x = this$0.f60753y;
        if (this$0.f60751w == 4) {
            this$0.S0();
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this$0.Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(Integer.valueOf(this$0.f60751w));
    }

    public static final void z1(DownloadReDetectorPathSettingFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        f00.b bVar = item instanceof f00.b ? (f00.b) item : null;
        if (bVar == null || bVar.getItemType() != 4) {
            this$0.v1(bVar, i11);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        h00.w0 w0Var;
        AppCompatTextView appCompatTextView;
        h00.w0 w0Var2;
        ImageView imageView;
        h00.e0 e0Var = (h00.e0) getMViewBinding();
        if (e0Var != null && (w0Var2 = e0Var.f65824b) != null && (imageView = w0Var2.f66074c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorPathSettingFragment.w1(this.f60948a, view);
                }
            });
        }
        h00.e0 e0Var2 = (h00.e0) getMViewBinding();
        if (e0Var2 == null || (w0Var = e0Var2.f65824b) == null || (appCompatTextView = w0Var.f66079i) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorPathSettingFragment.x1(this.f60951a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<List<f00.b>> c0VarQ;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = X0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.o(aVar, TAG, new String[]{"initViewModel "}, false, 4, null);
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            if (downloadResourcesDetectorViewModelY0 != null && (c0VarQ = downloadResourcesDetectorViewModelY0.q()) != null) {
                c0VarQ.j(parentFragment, new b(new Function1<List<f00.b>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorPathSettingFragment$initViewModel$1$1
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
                        uo.b.a aVar2 = uo.b.f78622a;
                        String TAG2 = this.this$0.X0();
                        Intrinsics.f(TAG2, "TAG");
                        uo.b.a.o(aVar2, TAG2, new String[]{"path setting size = " + list.size() + " "}, false, 4, null);
                        Intrinsics.f(list, "list");
                        DownloadReDetectorPathSettingFragment downloadReDetectorPathSettingFragment = this.this$0;
                        int i11 = 0;
                        for (Object obj : list) {
                            int i12 = i11 + 1;
                            if (i11 < 0) {
                                kotlin.collections.g.u();
                            }
                            f00.b bVar = (f00.b) obj;
                            if (bVar.f()) {
                                downloadReDetectorPathSettingFragment.f60752x = i11;
                                downloadReDetectorPathSettingFragment.f60753y = i11;
                                downloadReDetectorPathSettingFragment.f60754z = bVar;
                            }
                            i11 = i12;
                        }
                        com.transsnet.downloader.adapter.i iVar = this.this$0.f60750v;
                        if (iVar != null) {
                            iVar.w0(list);
                        }
                    }
                }));
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        if (downloadResourcesDetectorViewModelY1 != null) {
            downloadResourcesDetectorViewModelY1.u();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public h00.e0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.e0 e0VarC = h00.e0.c(inflater);
        Intrinsics.f(e0VarC, "inflate(inflater)");
        return e0VarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Bundle arguments = getArguments();
        this.f60751w = arguments != null ? arguments.getInt("extra_download_page_type") : 1;
        y1();
    }

    public final void v1(f00.b bVar, int i11) {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, StringsKt__IndentKt.f("\n            path， handleItemClick, position = " + i11 + ", selectedPosition = " + this.f60753y + " \n                pathName =  " + (bVar != null ? bVar.d() : null) + " ,downloadPath =  " + (bVar != null ? bVar.b() : null) + " ,downloadShowPath =  " + (bVar != null ? bVar.c() : null) + "\n        "), false, 4, null);
        int i12 = this.f60753y;
        if (i12 == i11) {
            return;
        }
        if (i12 >= 0) {
            com.transsnet.downloader.adapter.i iVar = this.f60750v;
            f00.b item = iVar != null ? iVar.getItem(i12) : null;
            if (item != null) {
                item.g(false);
            }
            com.transsnet.downloader.adapter.i iVar2 = this.f60750v;
            if (iVar2 != null) {
                iVar2.notifyItemChanged(this.f60753y, Boolean.FALSE);
            }
        }
        this.f60753y = i11;
        if (bVar != null) {
            bVar.g(true);
        }
        com.transsnet.downloader.adapter.i iVar3 = this.f60750v;
        if (iVar3 != null) {
            iVar3.notifyItemChanged(i11, Boolean.TRUE);
        }
        this.f60754z = bVar;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        h00.w0 w0Var;
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.i iVar = new com.transsnet.downloader.adapter.i(false, new ArrayList());
        iVar.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.r0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadReDetectorPathSettingFragment.z1(this.f60955a, baseQuickAdapter, view, i11);
            }
        });
        this.f60750v = iVar;
        h00.e0 e0Var = (h00.e0) getMViewBinding();
        if (e0Var == null || (w0Var = e0Var.f65824b) == null || (recyclerView = w0Var.f66078h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = V0();
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f60750v);
    }
}
