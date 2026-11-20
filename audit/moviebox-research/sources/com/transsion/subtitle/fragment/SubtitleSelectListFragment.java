package com.transsion.subtitle.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle.R$drawable;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
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
public final class SubtitleSelectListFragment extends SubtitleBaseFragment<wx.g> implements com.transsion.subtitle_download.a, xx.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f58214p = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f58215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public xx.b f58216i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DownloadBean f58218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ux.b f58219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f58220m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58222o;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<vx.a> f58217j = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f58221n = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSelectListFragment a(List<vx.a> subtitleList, boolean z11, DownloadBean downloadBean, String str) {
            Intrinsics.g(subtitleList, "subtitleList");
            SubtitleSelectListFragment subtitleSelectListFragment = new SubtitleSelectListFragment();
            subtitleSelectListFragment.R0(subtitleList, z11, downloadBean);
            subtitleSelectListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("KEY_PAGE_NAME", str)));
            return subtitleSelectListFragment;
        }
    }

    public static final void B0(SubtitleSelectListFragment this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.f58222o = z11;
        xx.b bVar = this$0.f58216i;
        if (bVar != null) {
            bVar.e(z11);
        }
        this$0.H0(z11);
        ux.b bVar2 = this$0.f58219l;
        if (bVar2 != null) {
            bVar2.J0(z11);
        }
    }

    public static final void C0(SubtitleSelectListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f58221n && this$0.A0()) {
            SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
            c0<String> c0VarF = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.f() : null;
            if (c0VarF == null) {
                return;
            }
            c0VarF.q("SUBTITLE_OPTIONS");
        }
    }

    public static final void D0(SubtitleSelectListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f58221n && this$0.A0()) {
            SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
            c0<String> c0VarF = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.f() : null;
            if (c0VarF == null) {
                return;
            }
            c0VarF.q("SUBTITLE_SYNC_ADJUST");
        }
    }

    public static final void E0(SubtitleSelectListFragment this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.f58221n = z11;
        xx.b bVar = this$0.f58216i;
        if (bVar != null) {
            bVar.b(z11);
        }
        this$0.P0(z11);
    }

    public static final void F0(SubtitleSelectListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        this$0.N0(i11);
    }

    public static final void G0(SubtitleSelectListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f58221n) {
            SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
            c0<String> c0VarL = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.l() : null;
            if (c0VarL != null) {
                c0VarL.q(SubtitleSearchHelper.f58255c.a().d(this$0.f58218k));
            }
            SubtitleDownloadViewModel subtitleDownloadViewModelI1 = this$0.i0();
            c0<String> c0VarF = subtitleDownloadViewModelI1 != null ? subtitleDownloadViewModelI1.f() : null;
            if (c0VarF == null) {
                return;
            }
            c0VarF.q("DOWNLOAD_SUBTITLE");
        }
    }

    public static final void K0(SubtitleSelectListFragment this$0, SubtitleDownloadTable dbBean) {
        List<vx.a> listD;
        Object next;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(dbBean, "$dbBean");
        ux.b bVar = this$0.f58219l;
        if (bVar == null || (listD = bVar.D()) == null) {
            return;
        }
        Iterator<T> it = listD.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((vx.a) next).b().getId(), dbBean.getId()));
        vx.a aVar = (vx.a) next;
        if (aVar != null) {
            aVar.h(dbBean);
            com.transsion.subtitle.a aVar2 = com.transsion.subtitle.a.f58119a;
            String simpleName = SubtitleSelectListFragment.class.getSimpleName();
            DownloadBean downloadBean = this$0.f58218k;
            String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
            DownloadBean downloadBean2 = this$0.f58218k;
            String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
            aVar2.a(simpleName + " --> onFail() --> 内置字幕点击下载失败TnT，name = " + totalTitleName + ", videoResourceId = " + resourceId + ",\" + \" download subtitleName = " + aVar.b().getName() + ", lan = " + aVar.b().getLan() + "， status:" + dbBean.getStatus() + "~");
            this$0.W0(aVar);
        }
    }

    private final void W0(vx.a aVar) {
        int iIndexOf;
        ux.b bVar = this.f58219l;
        if (bVar == null || (iIndexOf = bVar.D().indexOf(aVar)) < 0 || !isAdded()) {
            return;
        }
        com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> updateDownloadStatus() --> updateDownloadStatus index:" + iIndexOf + ", status:" + aVar.b().getStatus() + ",name:" + aVar.b().getName() + ",isSelect:" + aVar.f());
        ux.b bVar2 = this.f58219l;
        if (bVar2 != null) {
            bVar2.notifyItemChanged(iIndexOf, aVar);
        }
    }

    public final boolean A0() {
        xx.b bVar;
        String string;
        List<vx.a> listD;
        ux.b bVar2 = this.f58219l;
        boolean z11 = false;
        if (bVar2 != null && (listD = bVar2.D()) != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                if (((vx.a) it.next()).f()) {
                    z11 = true;
                }
            }
        }
        if (!z11 && (bVar = this.f58216i) != null) {
            Context context = getContext();
            if (context == null || (string = context.getString(R$string.subtitle_please_select_subtitles)) == null) {
                string = "";
            }
            bVar.c(string);
        }
        return z11;
    }

    @Override // com.transsion.subtitle_download.a
    public void B(int i11, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
    }

    @Override // com.transsion.subtitle_download.a
    public void E(SubtitleDownloadTable subtitleDownloadTable) {
        com.transsion.subtitle_download.a.C0598a.b(this, subtitleDownloadTable);
    }

    public final void H0(boolean z11) {
        if (z11) {
            V0();
        } else {
            v0();
        }
    }

    public final void I0() {
        vx.a aVar;
        List<vx.a> listD;
        ux.b bVar = this.f58219l;
        vx.a aVar2 = null;
        if (bVar == null || (listD = bVar.D()) == null) {
            aVar = null;
        } else {
            aVar = null;
            for (vx.a aVar3 : listD) {
                if (aVar3.f() && TextUtils.equals("1st", aVar3.a())) {
                    aVar2 = aVar3;
                } else if (aVar3.f() && TextUtils.equals("2nd", aVar3.a())) {
                    aVar = aVar3;
                }
            }
        }
        O0(aVar2, aVar);
    }

    @Override // com.transsion.subtitle_download.a
    public void J(SubtitleDownloadTable subtitleDownloadTable) {
        com.transsion.subtitle_download.a.C0598a.a(this, subtitleDownloadTable);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00f3  */
    public final void J0(vx.a aVar, int i11) {
        List<vx.a> listD;
        List<vx.a> listD2;
        ux.b bVar;
        List<vx.a> listD3;
        List<vx.a> listD4;
        int i12 = 0;
        if (aVar.f()) {
            aVar.l(false);
            aVar.g("");
            ux.b bVar2 = this.f58219l;
            if (bVar2 != null) {
                bVar2.notifyItemChanged(i11, aVar);
            }
            ux.b bVar3 = this.f58219l;
            if (bVar3 != null && (listD4 = bVar3.D()) != null) {
                for (Object obj : listD4) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    vx.a aVar2 = (vx.a) obj;
                    if (TextUtils.equals(aVar2.a(), "2nd")) {
                        aVar2.g("1st");
                        ux.b bVar4 = this.f58219l;
                        if (bVar4 != null) {
                            bVar4.notifyItemChanged(i12, aVar2);
                        }
                    }
                    i12 = i13;
                }
            }
            I0();
            return;
        }
        ux.b bVar5 = this.f58219l;
        if (bVar5 != null && (listD2 = bVar5.D()) != null) {
            Iterator<T> it = listD2.iterator();
            int i14 = 0;
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(((vx.a) it.next()).a())) {
                    i14++;
                }
            }
            if (i14 >= 2 && (bVar = this.f58219l) != null && (listD3 = bVar.D()) != null) {
                int i15 = 0;
                for (Object obj2 : listD3) {
                    int i16 = i15 + 1;
                    if (i15 < 0) {
                        kotlin.collections.g.u();
                    }
                    vx.a aVar3 = (vx.a) obj2;
                    if (TextUtils.equals(aVar3.a(), "2nd")) {
                        aVar3.l(false);
                        aVar3.g("");
                        ux.b bVar6 = this.f58219l;
                        if (bVar6 != null) {
                            bVar6.notifyItemChanged(i15, aVar3);
                        }
                    }
                    i15 = i16;
                }
            }
        }
        aVar.l(true);
        ux.b bVar7 = this.f58219l;
        if (bVar7 == null || (listD = bVar7.D()) == null) {
            aVar.g("1st");
        } else {
            Iterator<T> it2 = listD.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(((vx.a) it2.next()).a(), "1st")) {
                    i12 = 1;
                }
            }
            if (i12 != 0) {
                aVar.g("2nd");
            } else {
                aVar.g("1st");
            }
        }
        ux.b bVar8 = this.f58219l;
        if (bVar8 != null) {
            bVar8.notifyItemChanged(i11, aVar);
        }
        I0();
    }

    public final void L0(vx.a aVar) {
        List<vx.a> listD;
        SubtitleDownloadTable subtitleDownloadTableB;
        ux.b bVar = this.f58219l;
        if (bVar != null && (listD = bVar.D()) != null) {
            int i11 = 0;
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                vx.a aVar2 = (vx.a) obj;
                if (Intrinsics.b(aVar2.b().getId(), (aVar == null || (subtitleDownloadTableB = aVar.b()) == null) ? null : subtitleDownloadTableB.getId())) {
                    aVar2.l(true);
                    ux.b bVar2 = this.f58219l;
                    if (bVar2 != null) {
                        bVar2.notifyItemChanged(i11, aVar2);
                    }
                } else {
                    aVar2.l(false);
                    ux.b bVar3 = this.f58219l;
                    if (bVar3 != null) {
                        bVar3.notifyItemChanged(i11, aVar2);
                    }
                }
                i11 = i12;
            }
        }
        O0(aVar, null);
    }

    public final void M0(vx.a aVar, int i11) {
        if (!aVar.f()) {
            L0(aVar);
            return;
        }
        com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> setSubtitle() --> 单字幕 --> 已经选中的就不在重复设置了");
    }

    public final void N0(int i11) {
        if (this.f58221n) {
            vx.a aVar = this.f58217j.get(i11);
            if (aVar.d()) {
                T0(aVar, i11);
            } else {
                w0(i11, aVar);
            }
        }
    }

    public final void O0(vx.a aVar, vx.a aVar2) {
        xx.b bVar;
        String string;
        if ((aVar != null || aVar2 != null) && (bVar = this.f58216i) != null) {
            Context context = getContext();
            if (context == null || (string = context.getString(R$string.subtitle_switch_toast)) == null) {
                string = "";
            }
            bVar.c(string);
        }
        xx.b bVar2 = this.f58216i;
        if (bVar2 != null) {
            bVar2.l(aVar, aVar2, this.f58222o);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void P0(boolean z11) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        SwitchButton switchButton;
        SwitchButton switchButton2;
        wx.g gVar = (wx.g) getMViewBinding();
        U0(z11, gVar != null ? gVar.f79705l : null);
        wx.g gVar2 = (wx.g) getMViewBinding();
        U0(z11, gVar2 != null ? gVar2.f79704k : null);
        wx.g gVar3 = (wx.g) getMViewBinding();
        U0(z11, gVar3 != null ? gVar3.f79703j : null);
        wx.g gVar4 = (wx.g) getMViewBinding();
        S0(z11, gVar4 != null ? gVar4.f79696b : null);
        wx.g gVar5 = (wx.g) getMViewBinding();
        S0(z11, gVar5 != null ? gVar5.f79697c : null);
        int color = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start);
        int color2 = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end);
        int color3 = z2.a.getColor(Utils.a(), R$color.common_white);
        if (!z11) {
            wx.g gVar6 = (wx.g) getMViewBinding();
            if (gVar6 == null || (switchButton2 = gVar6.f79701h) == null || !switchButton2.isChecked()) {
                color = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start);
                color2 = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end);
                color3 = z2.a.getColor(Utils.a(), R$color.white_50);
            } else {
                color = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start_50);
                color2 = z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end_50);
                color3 = z2.a.getColor(Utils.a(), R$color.white_50);
            }
        }
        wx.g gVar7 = (wx.g) getMViewBinding();
        if (gVar7 != null && (switchButton = gVar7.f79701h) != null) {
            switchButton.setGradientColors(color, color2, Integer.valueOf(color3));
            switchButton.setEnable(z11);
        }
        ux.b bVar = this.f58219l;
        if (bVar != null) {
            bVar.K0(z11);
        }
        if (z11) {
            View view = this.f58215h;
            if (view != null && (textView2 = (TextView) view.findViewById(R$id.tvText)) != null) {
                textView2.setTextColor(z2.a.getColor(Utils.a(), R$color.white));
            }
            View view2 = this.f58215h;
            if (view2 == null || (imageView2 = (ImageView) view2.findViewById(R$id.ivImage)) == null) {
                return;
            }
            imageView2.setImageResource(R$drawable.subtitle_arrow_left_white);
            return;
        }
        View view3 = this.f58215h;
        if (view3 != null && (textView = (TextView) view3.findViewById(R$id.tvText)) != null) {
            textView.setTextColor(z2.a.getColor(Utils.a(), R$color.white_40));
        }
        View view4 = this.f58215h;
        if (view4 == null || (imageView = (ImageView) view4.findViewById(R$id.ivImage)) == null) {
            return;
        }
        imageView.setImageResource(R$drawable.subtitle_arrow_left_white_2);
    }

    public final void Q0(xx.b bVar) {
        this.f58216i = bVar;
        this.f58221n = bVar != null ? bVar.k() : true;
        this.f58222o = bVar != null ? bVar.f() : false;
    }

    public final void R0(List<vx.a> list, boolean z11, DownloadBean downloadBean) {
        this.f58218k = downloadBean;
        this.f58217j.clear();
        this.f58217j.addAll(list);
        int size = this.f58217j.size();
        String str = "";
        for (int i11 = 0; i11 < size; i11++) {
            vx.a aVar = this.f58217j.get(i11);
            if (aVar.f()) {
                str = "获取选中的那个 -- index = " + i11 + " -- name = " + aVar.b().getName();
            }
        }
        com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> setData() --> isLand = " + z11 + " --> list = " + list.size() + " --> tag = " + str);
    }

    public final void S0(boolean z11, AppCompatImageView appCompatImageView) {
        Drawable drawable;
        if (appCompatImageView == null || (drawable = appCompatImageView.getDrawable()) == null) {
            return;
        }
        d3.a.n(drawable, y0(z11));
        appCompatImageView.setImageDrawable(drawable);
    }

    @Override // xx.c
    public void T(boolean z11, DownloadBean downloadBean) {
        xx.c.a.a(this, z11, downloadBean);
    }

    public final void T0(vx.a aVar, int i11) {
        if (this.f58222o) {
            J0(aVar, i11);
        } else {
            M0(aVar, i11);
        }
    }

    public final void U0(boolean z11, AppCompatTextView appCompatTextView) {
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(y0(z11));
        }
    }

    public final void V0() {
        boolean z11;
        ux.b bVar;
        List<vx.a> listD;
        List<vx.a> listD2;
        ux.b bVar2 = this.f58219l;
        int i11 = 0;
        vx.a aVar = null;
        if (bVar2 == null || (listD2 = bVar2.D()) == null) {
            z11 = false;
        } else {
            z11 = false;
            int i12 = 0;
            for (Object obj : listD2) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                vx.a aVar2 = (vx.a) obj;
                if (aVar2.f()) {
                    aVar2.g("1st");
                    aVar = aVar2;
                    z11 = true;
                }
                i12 = i13;
            }
        }
        if (!z11 && (bVar = this.f58219l) != null && (listD = bVar.D()) != null) {
            for (Object obj2 : listD) {
                int i14 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                vx.a aVar3 = (vx.a) obj2;
                if (aVar3.d() && !z11) {
                    aVar3.l(true);
                    aVar3.g("1st");
                    aVar = aVar3;
                    z11 = true;
                }
                i11 = i14;
            }
        }
        u0(aVar);
        I0();
    }

    @Override // xx.c
    public void b(vx.a bean) {
        Intrinsics.g(bean, "bean");
    }

    @Override // com.transsion.subtitle_download.a
    public void b0(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        this.f58220m = false;
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new SubtitleSelectListFragment$onComplete$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initListener() {
        SwitchButton switchButton;
        SwitchButton switchButton2;
        LinearLayoutCompat linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat2;
        super.initListener();
        wx.g gVar = (wx.g) getMViewBinding();
        if (gVar != null && (linearLayoutCompat2 = gVar.f79698d) != null) {
            linearLayoutCompat2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubtitleSelectListFragment.C0(this.f58246a, view);
                }
            });
        }
        wx.g gVar2 = (wx.g) getMViewBinding();
        if (gVar2 != null && (linearLayoutCompat = gVar2.f79699f) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubtitleSelectListFragment.D0(this.f58247a, view);
                }
            });
        }
        wx.g gVar3 = (wx.g) getMViewBinding();
        if (gVar3 != null && (switchButton2 = gVar3.f79702i) != null) {
            switchButton2.setChecked(this.f58221n);
            P0(this.f58221n);
            switchButton2.setOnCheckedChangeListener(new SwitchButton.d() { // from class: com.transsion.subtitle.fragment.r
                @Override // com.tn.lib.view.SwitchButton.d
                public final void a(SwitchButton switchButton3, boolean z11) {
                    SubtitleSelectListFragment.E0(this.f58248a, switchButton3, z11);
                }
            });
        }
        wx.g gVar4 = (wx.g) getMViewBinding();
        if (gVar4 == null || (switchButton = gVar4.f79701h) == null) {
            return;
        }
        switchButton.setChecked(this.f58222o);
        switchButton.setOnCheckedChangeListener(new SwitchButton.d() { // from class: com.transsion.subtitle.fragment.s
            @Override // com.tn.lib.view.SwitchButton.d
            public final void a(SwitchButton switchButton3, boolean z11) {
                SubtitleSelectListFragment.B0(this.f58249a, switchButton3, z11);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        ux.b bVar;
        Intrinsics.g(view, "view");
        ux.b bVar2 = new ux.b(this.f58217j);
        bVar2.B0(new f9.d() { // from class: com.transsion.subtitle.fragment.t
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                SubtitleSelectListFragment.F0(this.f58250a, baseQuickAdapter, view2, i11);
            }
        });
        bVar2.K0(this.f58221n);
        bVar2.J0(this.f58222o);
        this.f58219l = bVar2;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.footer_download_other_subtitle_layout, (ViewGroup) null);
        this.f58215h = viewInflate;
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleSelectListFragment.G0(this.f58251a, view2);
                }
            });
        }
        View view2 = this.f58215h;
        if (view2 != null && (bVar = this.f58219l) != null) {
            BaseQuickAdapter.o(bVar, view2, 0, 0, 6, null);
        }
        wx.g gVar = (wx.g) getMViewBinding();
        if (gVar == null || (recyclerView = gVar.f79700g) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f58219l);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.subtitle_download.a
    public void m(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.g(e11, "e");
        Intrinsics.g(dbBean, "dbBean");
        this.f58220m = false;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.fragment.v
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSelectListFragment.K0(this.f58252a, dbBean);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        xx.b bVar;
        List<vx.a> listI;
        List<vx.a> listD;
        super.onHiddenChanged(z11);
        if (z11 || (bVar = this.f58216i) == null || (listI = bVar.i()) == null) {
            return;
        }
        com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f58119a;
        String simpleName = SubtitleSelectListFragment.class.getSimpleName();
        int size = listI.size();
        ux.b bVar2 = this.f58219l;
        aVar.a(simpleName + " --> onHiddenChanged(hidden = false) --> 刷新界面 --> newSize = " + size + " --> oldSize = " + ((bVar2 == null || (listD = bVar2.D()) == null) ? null : Integer.valueOf(listD.size())));
        this.f58217j.clear();
        this.f58217j.addAll(listI);
        ux.b bVar3 = this.f58219l;
        if (bVar3 != null) {
            bVar3.w0(this.f58217j);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoSubtitleManager.Companion companion = VideoSubtitleManager.f58109a;
        companion.a().j(this);
        companion.a().h(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoSubtitleManager.Companion companion = VideoSubtitleManager.f58109a;
        companion.a().e(this);
        companion.a().i(this);
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        l0("dialog_subtitle_select");
    }

    public final void u0(vx.a aVar) {
        List<vx.a> listD;
        SubtitleDownloadTable subtitleDownloadTableB;
        List<vx.a> listD2;
        SubtitleDownloadTable subtitleDownloadTableB2;
        SubtitleDownloadTable subtitleDownloadTableB3;
        vx.a aVarX0 = x0();
        boolean zEquals = TextUtils.equals((aVar == null || (subtitleDownloadTableB3 = aVar.b()) == null) ? null : subtitleDownloadTableB3.getId(), (aVarX0 == null || (subtitleDownloadTableB2 = aVarX0.b()) == null) ? null : subtitleDownloadTableB2.getId());
        int i11 = 0;
        if (zEquals || aVarX0 == null) {
            ux.b bVar = this.f58219l;
            if (bVar == null || (listD = bVar.D()) == null) {
                return;
            }
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                vx.a aVar2 = (vx.a) obj;
                if (!TextUtils.equals(aVar2.b().getId(), (aVarX0 == null || (subtitleDownloadTableB = aVarX0.b()) == null) ? null : subtitleDownloadTableB.getId()) && !aVar2.f()) {
                    w0(i11, aVar2);
                    com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> autoShowNdSubtitle() --> 如果按照规则获取到的2nd和1st是同一个，那就默认下载一个作为2nd");
                    return;
                }
                i11 = i12;
            }
            return;
        }
        if (aVarX0.d()) {
            if (aVarX0.f()) {
                return;
            }
            aVarX0.g("2nd");
            aVarX0.l(true);
            com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> autoShowNdSubtitle() --> 2nd 已下载，自动设置 --> name = " + aVarX0.b().getName());
            return;
        }
        ux.b bVar2 = this.f58219l;
        if (bVar2 == null || (listD2 = bVar2.D()) == null) {
            return;
        }
        for (Object obj2 : listD2) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(aVarX0, (vx.a) obj2)) {
                com.transsion.subtitle.a.f58119a.a(SubtitleSelectListFragment.class.getSimpleName() + " --> autoShowNdSubtitle() --> 没有下载，自动下载 --> index = " + i11 + " --> name = " + aVarX0.b().getName());
                w0(i11, aVarX0);
                return;
            }
            i11 = i13;
        }
    }

    public final void v0() {
        List<vx.a> listD;
        ux.b bVar = this.f58219l;
        vx.a aVar = null;
        if (bVar != null && (listD = bVar.D()) != null) {
            for (vx.a aVar2 : listD) {
                if (aVar2.f()) {
                    if (TextUtils.equals("2nd", aVar2.a())) {
                        aVar2.l(false);
                        aVar2.g("");
                        if (aVar == null) {
                            aVar = aVar2;
                        }
                    } else if (TextUtils.equals("1st", aVar2.a())) {
                        aVar2.l(true);
                        aVar2.g("");
                        aVar = aVar2;
                    }
                }
            }
        }
        L0(aVar);
    }

    public final void w0(int i11, vx.a aVar) {
        if (this.f58220m) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.subtitle_is_downloading);
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        aVar.b().setStatus(2);
        this.f58220m = true;
        ux.b bVar = this.f58219l;
        if (bVar != null) {
            bVar.notifyItemChanged(i11, aVar);
        }
        com.transsion.subtitle.a aVar2 = com.transsion.subtitle.a.f58119a;
        String simpleName = SubtitleSelectListFragment.class.getSimpleName();
        DownloadBean downloadBean = this.f58218k;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        aVar2.a(simpleName + " --> downloadSubtitle() --> 内置字幕列表，下载字幕，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ",\" + \" download subtitleName = " + aVar.b().getSubtitleName() + ", subResourceId = " + aVar.b().getResourceId() + "~");
        VideoSubtitleManager.f58109a.a().g(aVar);
    }

    public final vx.a x0() {
        vx.a aVar;
        vx.a aVar2;
        vx.a aVar3;
        vx.a aVar4;
        List<vx.a> listD;
        ux.b bVar = this.f58219l;
        if (bVar == null || (listD = bVar.D()) == null) {
            aVar = null;
            aVar2 = null;
            aVar3 = null;
            aVar4 = null;
        } else {
            aVar = null;
            aVar2 = null;
            aVar3 = null;
            aVar4 = null;
            int i11 = 0;
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                vx.a aVar5 = (vx.a) obj;
                if (!aVar5.f()) {
                    if (TextUtils.equals(aVar5.b().getLan(), "en")) {
                        aVar = aVar5;
                    }
                    if (TextUtils.equals(RoomAppMMKV.f51271a.a().getString("k_language_short_name", null), aVar5.b().getLan())) {
                        aVar2 = aVar5;
                    }
                    if (TextUtils.equals((Build.VERSION.SDK_INT >= 24 ? Utils.a().getResources().getConfiguration().getLocales().get(0) : Utils.a().getResources().getConfiguration().locale).getLanguage(), aVar5.b().getLan())) {
                        aVar3 = aVar5;
                    }
                    if (i11 == 0) {
                        aVar4 = aVar5;
                    }
                }
                i11 = i12;
            }
        }
        if (aVar != null) {
            return aVar;
        }
        if (aVar2 != null) {
            return aVar2;
        }
        if (aVar3 != null) {
            return aVar3;
        }
        if (aVar4 != null) {
            return aVar4;
        }
        return null;
    }

    public final int y0(boolean z11) {
        return z11 ? z2.a.getColor(Utils.a(), R$color.white) : z2.a.getColor(Utils.a(), R$color.white_40);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public wx.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.g gVarC = wx.g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }
}
