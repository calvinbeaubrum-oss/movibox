package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadResLoadMoreView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public class DownloadReDetectorGroupFragment extends DownloadReDetectorBaseFragment<h00.a0> {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f60702d0 = new a(null);
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public DownloadResourcesDetectorViewModel F;
    public Subject G;
    public String H;
    public String I;
    public String J;
    public String K;
    public boolean U;
    public long V;
    public int X;
    public Function2<? super List<DownloadBean>, ? super Boolean, Unit> Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Function1<? super String, Unit> f60703a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f60704b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f60705c0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.transsnet.downloader.adapter.f f60706v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f60707w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f60708x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f60709y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f60710z = "";
    public String A = "";
    public int L = 1;
    public int M = 1;
    public int N = 1;
    public int O = 1;
    public int P = 1;
    public int Q = 1;
    public String R = "PAGE";
    public String S = "1";
    public int T = 20;
    public String W = "";
    public final kotlinx.coroutines.k0 Y = kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorGroupFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, Integer num, int i11, boolean z11, boolean z12, int i12, int i13) {
            DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = new DownloadReDetectorGroupFragment();
            downloadReDetectorGroupFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_subject_id", str3), TuplesKt.a("extra_group_id", str4), TuplesKt.a("extra_ops", str5), TuplesKt.a("extra_target_resource_id", str6), TuplesKt.a("extra_resolution", num), TuplesKt.a("extra_show_premium_if_need", Boolean.valueOf(z11)), TuplesKt.a("extra_resolution_position", Integer.valueOf(i11)), TuplesKt.a("extra_resolution_is_show_loading", Boolean.valueOf(z12)), TuplesKt.a("extra_season", Integer.valueOf(i12)), TuplesKt.a("extra_ep_index", Integer.valueOf(i13))));
            return downloadReDetectorGroupFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends DiffUtil.e<DownloadBean> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId()) && oldItem.getStatus() == newItem.getStatus() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.b(oldItem.getUpdateTimeStamp(), newItem.getUpdateTimeStamp());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getUrl(), newItem.getUrl());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60711a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60711a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60711a;
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
            this.f60711a.invoke(obj);
        }
    }

    private final View P1(Context context) {
        final DefaultView defaultView = new DefaultView(context);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(R$string.no_content);
        Intrinsics.f(string, "context.getString(com.tn…dget.R.string.no_content)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string2, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorGroupFragment.Q1(this.f60897a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void Q1(DownloadReDetectorGroupFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.startLoading();
        this$0.e2();
        this_apply.setVisibility(8);
    }

    private final int R1() {
        return kotlin.ranges.a.g(this.P + 19, kotlin.ranges.a.g(this.O, this.N));
    }

    private final int S1() {
        return kotlin.ranges.a.g(this.L + 19, kotlin.ranges.a.g(this.O, this.N));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W1(DownloadListBean downloadListBean) {
        String nextPage;
        Boolean hasMore;
        Boolean hasMore2;
        String str = this.R;
        if (Intrinsics.b(str, "POSITION")) {
            this.L = this.M + 1;
            int iS1 = S1();
            this.M = iS1;
            if (this.L >= iS1) {
                return false;
            }
        } else {
            if (!Intrinsics.b(str, "EPISODE")) {
                Pager pager = downloadListBean.getPager();
                if (pager == null || (nextPage = pager.getNextPage()) == null) {
                    nextPage = "1";
                }
                this.S = nextPage;
                Pager pager2 = downloadListBean.getPager();
                if (pager2 == null || (hasMore = pager2.getHasMore()) == null) {
                    return false;
                }
                return hasMore.booleanValue();
            }
            this.P = this.Q + 1;
            this.Q = R1();
            Pager pager3 = downloadListBean.getPager();
            if (pager3 == null || (hasMore2 = pager3.getHasMore()) == null || !hasMore2.booleanValue() || this.P >= this.Q) {
                return false;
            }
        }
        return true;
    }

    public static final void Y1(DownloadReDetectorGroupFragment this$0, final com.transsnet.downloader.adapter.f this_apply) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.e2();
        } else {
            zp.b.f82110a.d(R$string.no_network_toast);
            this_apply.W().postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.c0
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadReDetectorGroupFragment.Z1(this_apply);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(com.transsnet.downloader.adapter.f this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.Q().u();
    }

    private final boolean a2() {
        h9.f fVarQ;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        return (fVar == null || (fVarQ = fVar.Q()) == null || !fVarQ.q()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2() {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        Function2<? super List<DownloadBean>, ? super Boolean, Unit> function2;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar == null || (copyOnWriteArrayListL0 = fVar.L0()) == null || (function2 = this.Z) == null) {
            return;
        }
        int size = copyOnWriteArrayListL0.size() + this.X;
        com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
        Intrinsics.d(fVar2);
        function2.invoke(copyOnWriteArrayListL0, Boolean.valueOf(size == fVar2.D().size()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r1.intValue() != r3) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e2() {
        String str;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            p2();
            return;
        }
        h00.a0 a0Var = (h00.a0) getMViewBinding();
        LinearLayout linearLayout = a0Var != null ? a0Var.f65709c : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (this.C != 0) {
            Subject subject = this.G;
            if (subject != null) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.TV.getValue();
                if (subjectType == null || subjectType.intValue() != value) {
                }
                int i11 = this.M;
                int i12 = this.L;
                if (i11 < i12) {
                    this.M = i12 + 1;
                }
                if (this.N > 50) {
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = this.F;
                    if (downloadResourcesDetectorViewModel != null) {
                        String str2 = this.H;
                        Subject subject2 = this.G;
                        downloadResourcesDetectorViewModel.i(str2, (920 & 2) != 0 ? "" : subject2 != null ? subject2.getTitle() : null, (920 & 4) != 0 ? 0 : 2, (920 & 8) != 0 ? "1" : null, (920 & 16) != 0 ? 20 : 0, (920 & 32) != 0 ? 1 : 0, (920 & 64) != 0 ? 1 : 0, (920 & 128) != 0 ? 1 : this.C, (920 & 256) != 0 ? 1 : this.P, (920 & 512) == 0 ? this.Q : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : this.f60707w);
                    }
                    str = "EPISODE";
                } else {
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = this.F;
                    if (downloadResourcesDetectorViewModel2 != null) {
                        String str3 = this.H;
                        Subject subject3 = this.G;
                        downloadResourcesDetectorViewModel2.i(str3, (920 & 2) != 0 ? "" : subject3 != null ? subject3.getTitle() : null, (920 & 4) != 0 ? 0 : 1, (920 & 8) != 0 ? "1" : null, (920 & 16) != 0 ? 20 : 0, (920 & 32) != 0 ? 1 : this.L, (920 & 64) != 0 ? 1 : this.M, (920 & 128) != 0 ? 1 : 0, (920 & 256) != 0 ? 1 : 0, (920 & 512) == 0 ? 0 : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : this.f60707w);
                    }
                    str = "POSITION";
                }
                this.R = str;
                return;
            }
            Subject subject4 = this.G;
            if (subject4 != null) {
                Integer subjectType2 = subject4.getSubjectType();
                int value2 = SubjectType.EDUCATION.getValue();
                if (subjectType2 != null) {
                }
            }
        }
        this.R = "PAGE";
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel3 = this.F;
        if (downloadResourcesDetectorViewModel3 != null) {
            String str4 = this.H;
            Subject subject5 = this.G;
            downloadResourcesDetectorViewModel3.i(str4, (920 & 2) != 0 ? "" : subject5 != null ? subject5.getTitle() : null, (920 & 4) != 0 ? 0 : 0, (920 & 8) != 0 ? "1" : this.S, (920 & 16) != 0 ? 20 : this.T, (920 & 32) != 0 ? 1 : 0, (920 & 64) != 0 ? 1 : 0, (920 & 128) != 0 ? 1 : 0, (920 & 256) != 0 ? 1 : 0, (920 & 512) == 0 ? 0 : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : this.f60707w);
        }
    }

    private final void g2(boolean z11) {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        List<DownloadBean> listD;
        Function1<? super Boolean, Unit> function1 = this.f60705c0;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        ArrayList arrayList = new ArrayList();
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar != null && (listD = fVar.D()) != null) {
            arrayList.addAll(listD);
        }
        com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
        if (fVar2 != null && (copyOnWriteArrayListL0 = fVar2.L0()) != null) {
            copyOnWriteArrayListL0.clear();
        }
        kotlinx.coroutines.j.d(this.Y, null, null, new DownloadReDetectorGroupFragment$selectAllWithSizeGreaterThan30$1(arrayList, this, z11, arrayList.size(), null), 3, null);
    }

    private final void h2(boolean z11) {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        List<DownloadBean> listD;
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL1;
        List<DownloadBean> listD2;
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL2;
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL3;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar != null && (copyOnWriteArrayListL3 = fVar.L0()) != null) {
            copyOnWriteArrayListL3.clear();
        }
        com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
        long j11 = 0;
        if (fVar2 != null && (listD2 = fVar2.D()) != null) {
            long jLongValue = 0;
            for (DownloadBean downloadBean : listD2) {
                downloadBean.setCheck(z11);
                if (this.U && !downloadBean.isUnable()) {
                    Long size = downloadBean.getSize();
                    jLongValue += size != null ? size.longValue() : 0L;
                    com.transsnet.downloader.adapter.f fVar3 = this.f60706v;
                    if (fVar3 != null && (copyOnWriteArrayListL2 = fVar3.L0()) != null) {
                        copyOnWriteArrayListL2.add(downloadBean);
                    }
                }
            }
            j11 = jLongValue;
        }
        com.transsnet.downloader.adapter.f fVar4 = this.f60706v;
        if (fVar4 != null) {
            fVar4.notifyDataSetChanged();
        }
        this.V = j11;
        Integer numValueOf = null;
        if (z11) {
            String strA = tp.a.a(j11, 1);
            this.W = strA;
            Function1<? super String, Unit> function1 = this.f60703a0;
            if (function1 != null) {
                function1.invoke(strA);
            }
        } else {
            Function1<? super String, Unit> function2 = this.f60703a0;
            if (function2 != null) {
                function2.invoke(null);
            }
        }
        com.transsnet.downloader.adapter.f fVar5 = this.f60706v;
        if (fVar5 == null || (copyOnWriteArrayListL0 = fVar5.L0()) == null) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        com.transsnet.downloader.adapter.f fVar6 = this.f60706v;
        Integer numValueOf2 = (fVar6 == null || (copyOnWriteArrayListL1 = fVar6.L0()) == null) ? null : Integer.valueOf(copyOnWriteArrayListL1.size());
        int i11 = this.X;
        com.transsnet.downloader.adapter.f fVar7 = this.f60706v;
        if (fVar7 != null && (listD = fVar7.D()) != null) {
            numValueOf = Integer.valueOf(listD.size());
        }
        uo.b.a.s(aVar, TAG, "selectAllWithSizeLessThan30,checkedSize = " + numValueOf2 + ",unableSize = " + i11 + ", dataSize = " + numValueOf, false, 4, null);
        i2();
        Function2<? super List<DownloadBean>, ? super Boolean, Unit> function3 = this.Z;
        if (function3 != null) {
            int size2 = copyOnWriteArrayListL0.size() + this.X;
            com.transsnet.downloader.adapter.f fVar8 = this.f60706v;
            Intrinsics.d(fVar8);
            function3.invoke(copyOnWriteArrayListL0, Boolean.valueOf(size2 == fVar8.D().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        Function1<? super Boolean, Unit> function1 = this.f60704b0;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2() {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        ArrayList arrayList = new ArrayList();
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar != null && (copyOnWriteArrayListL0 = fVar.L0()) != null) {
            for (DownloadBean downloadBean : copyOnWriteArrayListL0) {
                if (!downloadBean.isUnable() && downloadBean.isSeries()) {
                    arrayList.add(downloadBean.getEpName());
                }
            }
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setCheckItem, size:" + arrayList.size(), false, 4, null);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<List<String>> c0VarZ = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.z() : null;
        if (c0VarZ == null) {
            return;
        }
        c0VarZ.q(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        h00.a0 a0Var = (h00.a0) getMViewBinding();
        RecyclerView recyclerView = a0Var != null ? a0Var.f65710d : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        int i11 = this.C;
        ArrayList arrayList = new ArrayList();
        String str = this.f60710z;
        String str2 = this.H;
        Subject subject = this.G;
        final com.transsnet.downloader.adapter.f fVar = new com.transsnet.downloader.adapter.f(i11, arrayList, str, str2, subject != null ? subject.getSubjectType() : null, Boolean.valueOf(this.B), new Function0<Boolean>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment.initView.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(DownloadReDetectorGroupFragment.this.T1());
            }
        });
        if (this.G == null) {
            fVar.Q().y(false);
            fVar.Q().x(false);
        } else {
            fVar.Q().B(new DownloadResLoadMoreView());
            fVar.Q().y(true);
            fVar.Q().x(true);
            fVar.Q().D(2);
            fVar.Q().C(new f9.f() { // from class: com.transsnet.downloader.fragment.a0
                @Override // f9.f
                public final void a() {
                    DownloadReDetectorGroupFragment.Y1(this.f60883a, fVar);
                }
            });
        }
        fVar.o0(new b());
        this.f60706v = fVar;
        h00.a0 a0Var2 = (h00.a0) getMViewBinding();
        RecyclerView recyclerView2 = a0Var2 != null ? a0Var2.f65710d : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f60706v);
        }
        com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
        if (fVar2 != null) {
            fVar2.Q0(new Function2<Long, Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment.initView.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l11, Boolean bool) {
                    invoke(l11.longValue(), bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(long j11, boolean z11) {
                    DownloadReDetectorGroupFragment.this.i2();
                    DownloadReDetectorGroupFragment.this.d2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        View viewP1 = P1(contextRequireContext);
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar != null) {
            fVar.r0(viewP1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p2() {
        AppCompatTextView appCompatTextView;
        hideLoading();
        h00.a0 a0Var = (h00.a0) getMViewBinding();
        LinearLayout linearLayout = a0Var != null ? a0Var.f65709c : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        h00.a0 a0Var2 = (h00.a0) getMViewBinding();
        if (a0Var2 == null || (appCompatTextView = a0Var2.f65713h) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorGroupFragment.q2(this.f60984a, view);
            }
        });
    }

    public static final void q2(DownloadReDetectorGroupFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.startLoading();
            this$0.e2();
        }
    }

    private final void r2(DownloadBean downloadBean) {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar == null || (copyOnWriteArrayListL0 = fVar.L0()) == null) {
            return;
        }
        copyOnWriteArrayListL0.add(downloadBean);
        i2();
        Function2<? super List<DownloadBean>, ? super Boolean, Unit> function2 = this.Z;
        if (function2 != null) {
            int size = copyOnWriteArrayListL0.size() + this.X;
            com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
            Intrinsics.d(fVar2);
            function2.invoke(copyOnWriteArrayListL0, Boolean.valueOf(size == fVar2.D().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(List<? extends DownloadBean> list, boolean z11) {
        h9.f fVarQ;
        com.transsnet.downloader.adapter.f fVar;
        h9.f fVarQ2;
        com.transsnet.downloader.adapter.f fVar2;
        h9.f fVarQ3;
        h9.f fVarQ4;
        boolean z12;
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        com.transsnet.downloader.adapter.f fVar3;
        h9.f fVarQ5;
        h9.f fVarQ6;
        com.transsnet.downloader.adapter.f fVar4;
        h9.f fVarQ7;
        HashMap<String, String> mapG;
        List<DownloadBean> listD;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0;
        androidx.lifecycle.c0<List<String>> c0VarZ;
        List<String> value;
        androidx.lifecycle.c0<List<String>> c0VarZ2;
        androidx.lifecycle.c0<List<String>> c0VarZ3;
        List<String> listF;
        String str;
        Integer numL;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "updateList , TabPosition:" + this.f60708x + ", size:" + (list != null ? Integer.valueOf(list.size()) : null) + ", hasMore:" + z11, false, 4, null);
        List<? extends DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            if (!Intrinsics.b(this.R, "EPISODE")) {
                com.transsnet.downloader.adapter.f fVar5 = this.f60706v;
                if (fVar5 == null || (fVarQ = fVar5.Q()) == null) {
                    return;
                }
                h9.f.t(fVarQ, false, 1, null);
                return;
            }
            if (!z11 || (fVar2 = this.f60706v) == null || (fVarQ3 = fVar2.Q()) == null || !fVarQ3.q()) {
                if (z11 || (fVar = this.f60706v) == null || (fVarQ2 = fVar.Q()) == null) {
                    return;
                }
                h9.f.t(fVarQ2, false, 1, null);
                return;
            }
            com.transsnet.downloader.adapter.f fVar6 = this.f60706v;
            if (fVar6 == null || (fVarQ4 = fVar6.Q()) == null) {
                return;
            }
            fVarQ4.r();
            return;
        }
        ArrayList<DownloadBean> arrayList = new ArrayList();
        boolean z13 = false;
        for (DownloadBean downloadBean : list) {
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
            if (this.U) {
                if (downloadBeanL != null) {
                    downloadBeanL.setCheck(true);
                }
                downloadBean.setCheck(true);
                long j11 = this.V;
                Long size = downloadBean.getSize();
                this.V = j11 + (size != null ? size.longValue() : 0L);
            }
            String str2 = this.K;
            int iIntValue = (str2 == null || (numL = kotlin.text.k.l(str2)) == null) ? -2 : numL.intValue();
            DownloadBean downloadBean2 = downloadBeanL == null ? downloadBean : downloadBeanL;
            if (downloadBean2.isSeries() ? !downloadBean2.isUnable() && (Intrinsics.b(downloadBean2.getResourceId(), this.K) || (downloadBean2.getEp() == iIntValue && iIntValue > 0)) : !z13 && !downloadBean2.isUnable() && ((str = this.K) == null || str.length() == 0 ? downloadBean2.getResolution() == RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 360) : Intrinsics.b(downloadBean2.getResourceId(), this.K))) {
                r2(downloadBean);
                downloadBean2.setCheck(true);
                z13 = true;
            }
            downloadBean2.setUploadBy(downloadBean.getUploadBy());
            int i11 = this.f60707w;
            if (i11 > 0) {
                downloadBean2.setResolution(i11);
            }
            arrayList.add(downloadBean2);
            if (downloadBeanL != null && downloadBeanL.isUnable()) {
                this.X++;
                uo.b.a aVar2 = uo.b.f78622a;
                String TAG2 = X0();
                Intrinsics.f(TAG2, "TAG");
                uo.b.a.s(aVar2, TAG2, "tabPosition = " + this.f60708x + ", unableSize plus = " + this.X, false, 4, null);
            }
        }
        DownloadBean downloadBean3 = (DownloadBean) CollectionsKt___CollectionsKt.g0(arrayList);
        if (downloadBean3 != null && !downloadBean3.isSeries() && !z13 && !downloadBean3.isUnable()) {
            r2(downloadBean3);
            downloadBean3.setCheck(true);
        }
        uo.b.a aVar3 = uo.b.f78622a;
        String TAG3 = X0();
        Intrinsics.f(TAG3, "TAG");
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        Integer numValueOf = (downloadResourcesDetectorViewModelY1 == null || (c0VarZ3 = downloadResourcesDetectorViewModelY1.z()) == null || (listF = c0VarZ3.f()) == null) ? null : Integer.valueOf(listF.size());
        uo.b.a.f(aVar3, TAG3, "--updateList, size:" + numValueOf + "， newList size:" + arrayList.size(), false, 4, null);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
        List<String> listF2 = (downloadResourcesDetectorViewModelY2 == null || (c0VarZ2 = downloadResourcesDetectorViewModelY2.z()) == null) ? null : c0VarZ2.f();
        if (listF2 == null || listF2.isEmpty()) {
            z12 = false;
        } else {
            z12 = false;
            for (DownloadBean downloadBean4 : arrayList) {
                if (downloadBean4.isSeries() && (downloadResourcesDetectorViewModelY0 = Y0()) != null && (c0VarZ = downloadResourcesDetectorViewModelY0.z()) != null && (value = c0VarZ.f()) != null) {
                    Intrinsics.f(value, "value");
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.b(downloadBean4.getEpName(), (String) it.next()) && !downloadBean4.isUnable()) {
                            downloadBean4.setCheck(true);
                            com.transsnet.downloader.adapter.f fVar7 = this.f60706v;
                            if (fVar7 != null) {
                                fVar7.I0(downloadBean4, true);
                            }
                            z12 = true;
                        }
                    }
                }
            }
        }
        com.transsnet.downloader.adapter.f fVar8 = this.f60706v;
        if (fVar8 != null) {
            fVar8.m(arrayList);
        }
        com.transsnet.downloader.adapter.f fVar9 = this.f60706v;
        if (fVar9 != null && (listD = fVar9.D()) != null) {
            int i12 = 0;
            for (Object obj : listD) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                DownloadBean downloadBean5 = (DownloadBean) obj;
                downloadBean5.setIndex(i12);
                downloadBean5.setResourcePosition(i13);
                i12 = i13;
            }
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
            mapG.put("size", String.valueOf(arrayList.size()));
        }
        com.transsnet.downloader.adapter.f fVar10 = this.f60706v;
        if (fVar10 != null && (fVarQ6 = fVar10.Q()) != null && fVarQ6.q() && (fVar4 = this.f60706v) != null && (fVarQ7 = fVar4.Q()) != null) {
            fVarQ7.r();
        }
        if (!z11 && (fVar3 = this.f60706v) != null && (fVarQ5 = fVar3.Q()) != null) {
            h9.f.t(fVarQ5, false, 1, null);
        }
        if (this.U) {
            com.transsnet.downloader.adapter.f fVar11 = this.f60706v;
            if (fVar11 != null && (copyOnWriteArrayListL0 = fVar11.L0()) != null) {
                copyOnWriteArrayListL0.addAll(arrayList);
            }
            String strA = tp.a.a(this.V, 1);
            this.W = strA;
            Function1<? super String, Unit> function1 = this.f60703a0;
            if (function1 != null) {
                function1.invoke(strA);
            }
        }
        if (z12) {
            d2();
        }
    }

    private final void startLoading() {
        Function1<? super Boolean, Unit> function1 = this.f60704b0;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<DownloadBean> listD;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar == null || (listD = fVar.D()) == null || listD.size() != 0) {
            return;
        }
        startLoading();
        e2();
    }

    public final boolean T1() {
        return this.E;
    }

    public final Integer U1() {
        List<DownloadBean> listD;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar != null && (listD = fVar.D()) != null) {
            Iterator<T> it = listD.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                int resolution = ((DownloadBean) next).getResolution();
                do {
                    Object next2 = it.next();
                    int resolution2 = ((DownloadBean) next2).getResolution();
                    if (resolution < resolution2) {
                        next = next2;
                        resolution = resolution2;
                    }
                } while (it.hasNext());
            }
            DownloadBean downloadBean = (DownloadBean) next;
            if (downloadBean != null) {
                return Integer.valueOf(downloadBean.getResolution());
            }
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public h00.a0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.a0 a0VarC = h00.a0.c(inflater);
        Intrinsics.f(a0VarC, "inflate(inflater)");
        return a0VarC;
    }

    public final boolean X1() {
        List<DownloadBean> listD;
        Integer requireMemberType;
        boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (fVar == null || (listD = fVar.D()) == null) {
            return false;
        }
        for (DownloadBean downloadBean : listD) {
            if (zE1 && (requireMemberType = downloadBean.getRequireMemberType()) != null && requireMemberType.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean b2() {
        return this.U;
    }

    public final boolean c2() {
        List<DownloadBean> listD;
        int i11 = this.X;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        return i11 < ((fVar == null || (listD = fVar.D()) == null) ? 0 : listD.size()) && !a2();
    }

    public final void f2(boolean z11) {
        List<DownloadBean> listD;
        List<DownloadBean> listD2;
        int i11 = this.X;
        com.transsnet.downloader.adapter.f fVar = this.f60706v;
        if (i11 >= ((fVar == null || (listD2 = fVar.D()) == null) ? 0 : listD2.size())) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "selectAll click, selectAll = " + z11 + " ", false, 4, null);
        this.U = z11;
        com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
        if (fVar2 == null || (listD = fVar2.D()) == null || listD.size() <= 30) {
            h2(z11);
        } else {
            g2(z11);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Fragment parentFragment;
        if (this.f60709y) {
            startLoading();
        }
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null && (parentFragment = parentFragment2.getParentFragment()) != null) {
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(parentFragment).a(DownloadResourcesDetectorViewModel.class);
            ResourcesSeasonList resourcesSeasonListF = downloadResourcesDetectorViewModel.x().f();
            if (resourcesSeasonListF != null) {
                List<ResourcesSeason> seasons = resourcesSeasonListF.getSeasons();
                this.E = seasons != null && seasons.size() > 1;
                List<ResourcesSeason> seasons2 = resourcesSeasonListF.getSeasons();
                if (seasons2 != null) {
                    Pair<Integer, Integer> pairT = DownloadUtil.f61136a.t(seasons2, this.C, this.f60707w);
                    this.N = pairT.getFirst().intValue();
                    this.L = pairT.getSecond().intValue() + (this.D * 50);
                    this.M = S1();
                    this.P = (this.D * 50) + 1;
                    this.Q = R1();
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = X0();
                    Intrinsics.f(TAG, "TAG");
                    uo.b.a.o(aVar, TAG, new String[]{"initViewModel,season:" + this.C + ", epIndex:" + this.D + ", resolution:" + this.f60707w + " start:" + this.L + ", end:" + this.M + ", total:" + this.N + ", startEp:" + this.P + ", endEp:" + this.Q}, false, 4, null);
                }
            }
            k1(downloadResourcesDetectorViewModel);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel2.r().j(this, new c(new Function1<DownloadListBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment$initViewModel$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                h9.f fVarQ;
                h9.f fVarQ2;
                com.transsnet.downloader.adapter.f fVar;
                h9.f fVarQ3;
                List<DownloadBean> listD;
                this.this$0.hideLoading();
                if (downloadListBean == null) {
                    com.transsnet.downloader.adapter.f fVar2 = this.this$0.f60706v;
                    if (fVar2 != null && (listD = fVar2.D()) != null && listD.size() == 0) {
                        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            this.this$0.o2();
                            return;
                        }
                        return;
                    }
                    com.transsnet.downloader.adapter.f fVar3 = this.this$0.f60706v;
                    if (fVar3 != null && (fVarQ2 = fVar3.Q()) != null && fVarQ2.q() && (fVar = this.this$0.f60706v) != null && (fVarQ3 = fVar.Q()) != null) {
                        fVarQ3.u();
                    }
                    com.transsnet.downloader.adapter.f fVar4 = this.this$0.f60706v;
                    if (fVar4 == null || (fVarQ = fVar4.Q()) == null) {
                        return;
                    }
                    h9.f.t(fVarQ, false, 1, null);
                    return;
                }
                boolean zW1 = this.this$0.W1(downloadListBean);
                uo.b.a aVar2 = uo.b.f78622a;
                String TAG2 = this.this$0.X0();
                Intrinsics.f(TAG2, "TAG");
                String[] strArr = new String[1];
                List<DownloadItem> items = downloadListBean.getItems();
                Integer numValueOf = items != null ? Integer.valueOf(items.size()) : null;
                strArr[0] = "get data from  net, size: " + numValueOf + ",loadType:" + this.this$0.R + ",hasMore:" + zW1 + ",start:" + this.this$0.L + ",end:" + this.this$0.M + ", startEp:" + this.this$0.P + ",endEp:" + this.this$0.Q;
                uo.b.a.o(aVar2, TAG2, strArr, false, 4, null);
                String subjectId = downloadListBean.getSubjectId();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initViewModel#resDataLiveData: subjectId:");
                sb2.append(subjectId);
                DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = this.this$0;
                DownloadUtil downloadUtil = DownloadUtil.f61136a;
                Subject subject = downloadReDetectorGroupFragment.G;
                String str = this.this$0.I;
                String str2 = this.this$0.f60710z;
                String str3 = this.this$0.A;
                String str4 = this.this$0.J;
                String subjectTitle = downloadListBean.getSubjectTitle();
                if (subjectTitle == null) {
                    Subject subject2 = this.this$0.G;
                    String title = subject2 != null ? subject2.getTitle() : null;
                    if (title == null) {
                        title = "";
                    }
                    subjectTitle = title;
                }
                downloadReDetectorGroupFragment.s2(downloadUtil.q(downloadListBean, subject, (128 & 4) != 0 ? null : str, (128 & 8) != 0 ? null : str2, (128 & 16) != 0 ? null : str3, (128 & 32) != 0 ? null : str4, (128 & 64) != 0 ? null : subjectTitle, (128 & 128) != 0 ? null : null), zW1);
            }
        }));
        this.F = downloadResourcesDetectorViewModel2;
        e2();
        Function2<? super List<DownloadBean>, ? super Boolean, Unit> function2 = this.Z;
        if (function2 != null) {
            function2.invoke(new ArrayList(), Boolean.FALSE);
        }
    }

    public final void j2(Function2<? super List<DownloadBean>, ? super Boolean, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.Z = listener;
    }

    public final void k2(Function1<? super String, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60703a0 = listener;
    }

    public final void l2(boolean z11) {
        this.U = z11;
    }

    public final void m2(Function1<? super Boolean, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60705c0 = listener;
    }

    public final void n2(Function1<? super Boolean, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f60704b0 = listener;
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        HashMap<String, String> mapG4;
        HashMap<String, String> mapG5;
        String string2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f60707w = arguments != null ? arguments.getInt("extra_resolution") : 0;
        Bundle arguments2 = getArguments();
        this.f60708x = arguments2 != null ? arguments2.getInt("extra_resolution_position") : 0;
        Bundle arguments3 = getArguments();
        this.f60709y = arguments3 != null ? arguments3.getBoolean("extra_resolution_is_show_loading") : true;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString("extra_page_from") : null;
        String str = "";
        if (string3 == null) {
            string3 = "";
        }
        this.f60710z = string3;
        Bundle arguments5 = getArguments();
        String string4 = arguments5 != null ? arguments5.getString("extra_last_page_from") : null;
        if (string4 == null) {
            string4 = "";
        }
        this.A = string4;
        Bundle arguments6 = getArguments();
        this.G = (Subject) (arguments6 != null ? arguments6.getSerializable("extra_subject") : null);
        Bundle arguments7 = getArguments();
        this.H = arguments7 != null ? arguments7.getString("extra_subject_id") : null;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (string = arguments8.getString("extra_ops")) == null) {
            string = "";
        }
        this.J = string;
        Bundle arguments9 = getArguments();
        if (arguments9 != null && (string2 = arguments9.getString("extra_target_resource_id")) != null) {
            str = string2;
        }
        this.K = str;
        Bundle arguments10 = getArguments();
        this.B = arguments10 != null ? arguments10.getBoolean("extra_show_premium_if_need") : false;
        Bundle arguments11 = getArguments();
        this.C = arguments11 != null ? arguments11.getInt("extra_season") : 0;
        Bundle arguments12 = getArguments();
        int i11 = arguments12 != null ? arguments12.getInt("extra_ep_index") : 0;
        this.D = i11;
        this.O = (i11 + 1) * 50;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG5 = logViewConfig.g()) != null) {
            mapG5.put(WebConstants.PAGE_FROM, this.f60710z);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG4 = logViewConfig2.g()) != null) {
            mapG4.put("last_page_from", this.A);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
            Subject subject = this.G;
            mapG3.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG2 = logViewConfig4.g()) != null) {
            mapG2.put("ops", this.J);
        }
        com.transsion.baselib.report.h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (mapG = logViewConfig5.g()) == null) {
            return;
        }
        mapG.put("type", "2");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
        List<DownloadBean> listD;
        CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL1;
        com.transsnet.downloader.adapter.f fVar;
        List<DownloadBean> listD2;
        boolean z12;
        androidx.lifecycle.c0<List<String>> c0VarZ;
        androidx.lifecycle.c0<List<String>> c0VarZ2;
        androidx.lifecycle.c0<List<String>> c0VarZ3;
        List<String> listF;
        super.onHiddenChanged(z11);
        if (z11) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        Integer numValueOf = null;
        uo.b.a.f(aVar, TAG, "--onHiddenChanged, size:" + ((downloadResourcesDetectorViewModelY0 == null || (c0VarZ3 = downloadResourcesDetectorViewModelY0.z()) == null || (listF = c0VarZ3.f()) == null) ? null : Integer.valueOf(listF.size())), false, 4, null);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        List<String> listF2 = (downloadResourcesDetectorViewModelY1 == null || (c0VarZ2 = downloadResourcesDetectorViewModelY1.z()) == null) ? null : c0VarZ2.f();
        if (listF2 != null && !listF2.isEmpty() && (fVar = this.f60706v) != null && (listD2 = fVar.D()) != null) {
            for (DownloadBean downloadBean : listD2) {
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
                List<String> listF3 = (downloadResourcesDetectorViewModelY2 == null || (c0VarZ = downloadResourcesDetectorViewModelY2.z()) == null) ? null : c0VarZ.f();
                Intrinsics.d(listF3);
                Iterator<String> it = listF3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.b(downloadBean.getEpName(), it.next()) && !downloadBean.isUnable()) {
                            z12 = true;
                            break;
                        }
                    } else {
                        z12 = false;
                        break;
                    }
                }
                downloadBean.setCheck(z12);
                com.transsnet.downloader.adapter.f fVar2 = this.f60706v;
                if (fVar2 != null) {
                    fVar2.I0(downloadBean, z12);
                }
            }
        }
        com.transsnet.downloader.adapter.f fVar3 = this.f60706v;
        if (fVar3 != null) {
            fVar3.notifyDataSetChanged();
        }
        d2();
        com.transsnet.downloader.adapter.f fVar4 = this.f60706v;
        if (fVar4 == null || (copyOnWriteArrayListL0 = fVar4.L0()) == null) {
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        String TAG2 = X0();
        Intrinsics.f(TAG2, "TAG");
        int i11 = this.f60708x;
        com.transsnet.downloader.adapter.f fVar5 = this.f60706v;
        Integer numValueOf2 = (fVar5 == null || (copyOnWriteArrayListL1 = fVar5.L0()) == null) ? null : Integer.valueOf(copyOnWriteArrayListL1.size());
        int i12 = this.X;
        com.transsnet.downloader.adapter.f fVar6 = this.f60706v;
        if (fVar6 != null && (listD = fVar6.D()) != null) {
            numValueOf = Integer.valueOf(listD.size());
        }
        uo.b.a.s(aVar2, TAG2, "onHiddenChanged, resolutionTabPosition = " + i11 + ",checkedSize = " + numValueOf2 + ",unableSize = " + i12 + ", dataSize = " + numValueOf, false, 4, null);
        Function2<? super List<DownloadBean>, ? super Boolean, Unit> function2 = this.Z;
        if (function2 != null) {
            int size = copyOnWriteArrayListL0.size() + this.X;
            com.transsnet.downloader.adapter.f fVar7 = this.f60706v;
            Intrinsics.d(fVar7);
            function2.invoke(copyOnWriteArrayListL0, Boolean.valueOf(size == fVar7.D().size()));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        initView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return true;
    }
}
