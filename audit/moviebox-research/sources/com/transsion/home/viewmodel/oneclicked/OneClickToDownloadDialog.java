package com.transsion.home.viewmodel.oneclicked;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.h0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.view.indicator.CircleIndicator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.banner.banner.Banner;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.m;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.home.R$id;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lt.e;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class OneClickToDownloadDialog extends BaseDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f52774i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f52775j = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f52776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends Subject> f52777d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f52778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52780h = LazyKt__LazyJVMKt.b(new Function0<com.transsion.home.utils.b>() { // from class: com.transsion.home.viewmodel.oneclicked.OneClickToDownloadDialog$dotHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.home.utils.b invoke() {
            return new com.transsion.home.utils.b();
        }
    });

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
    public static final class b implements wp.c {
        public b() {
        }

        @Override // wp.c
        public void onPageScrollStateChanged(int i11) {
        }

        @Override // wp.c
        public void onPageScrolled(int i11, float f11, int i12) {
        }

        @Override // wp.c
        public void onPageSelected(int i11) {
            OneClickToDownloadDialog.this.f52779g = i11;
            OneClickToDownloadDialog.this.w0();
        }
    }

    private final void initView() {
        e eVar = this.f52778f;
        if (eVar != null) {
            eVar.f70422k.setText(this.f52776c);
            eVar.f70420i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.viewmodel.oneclicked.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneClickToDownloadDialog.t0(this.f52782a, view);
                }
            });
            eVar.f70423l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.viewmodel.oneclicked.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneClickToDownloadDialog.u0(this.f52783a, view);
                }
            });
            eVar.f70417f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.viewmodel.oneclicked.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneClickToDownloadDialog.v0(this.f52784a, view);
                }
            });
        }
    }

    public static final void t0(OneClickToDownloadDialog this$0, View view) {
        String resourceLink;
        ResourceDetectors resourceDetector;
        Intrinsics.g(this$0, "this$0");
        if (!f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        }
        this$0.dismiss();
        Subject subjectR0 = this$0.r0();
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        String ops = subjectR0 != null ? subjectR0.getOps() : null;
        if (subjectR0 == null || (resourceDetector = subjectR0.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
            resourceLink = "";
        }
        downloadManagerApiA.P1(fragmentActivityRequireActivity, subjectR0, "OneClickToDownloadDialog", (960 & 8) != 0 ? "" : "", ops, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
        this$0.s0().e("OneClickToDownloadDialog", subjectR0 != null ? subjectR0.getSubjectId() : null, DownloadBaseRunnable.TAG);
    }

    public static final void u0(OneClickToDownloadDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
        this$0.s0().e("OneClickToDownloadDialog", null, "discover");
    }

    public static final void v0(OneClickToDownloadDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
        this$0.s0().e("OneClickToDownloadDialog", null, "back");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public String h0() {
        return "POSITION_START";
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public h newLogViewConfig() {
        return new h("OneClickToDownloadDialog", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        e eVarC = e.c(inflater);
        this.f52778f = eVarC;
        if (eVarC != null) {
            return eVarC.getRoot();
        }
        return null;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(null);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f52776c = arguments != null ? arguments.getString(CampaignEx.JSON_KEY_TITLE) : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("subject_list") : null;
        this.f52777d = serializable instanceof List ? (List) serializable : null;
        initView();
        List<? extends Subject> list = this.f52777d;
        if (list != null) {
            h logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.j(true);
            }
            m.f51277a.x(HomeTabType.TAB_CODE_TRENDING);
            Banner banner = (Banner) view.findViewById(R$id.banner);
            if (banner != null) {
                Intrinsics.f(banner, "findViewById<Banner<Subj…oadAdapter>>(R.id.banner)");
                banner.setBannerGalleryEffect(56, 16);
                banner.isAutoLoop(false);
                banner.setAdapter(new OneClickDownloadAdapter(list));
                CircleIndicator circleIndicator = new CircleIndicator(banner.getContext());
                circleIndicator.getIndicatorConfig().o(1);
                circleIndicator.getIndicatorConfig().m(true);
                circleIndicator.getIndicatorConfig().s(new com.tn.lib.view.indicator.a.C0540a(0, 0, 0, 0));
                banner.setIndicator(circleIndicator);
                banner.getIndicatorConfig().t(z2.a.getColor(banner.getContext(), R$color.indicator_normal));
                banner.getIndicatorConfig().w(z2.a.getColor(banner.getContext(), R$color.brand));
                banner.addOnPageChangeListener(new b());
                w0();
            }
        }
    }

    public final Subject r0() {
        List<? extends Subject> list;
        List<? extends Subject> list2 = this.f52777d;
        int size = list2 != null ? list2.size() : 0;
        int i11 = this.f52779g;
        if (i11 < 0 || i11 >= size || (list = this.f52777d) == null) {
            return null;
        }
        return list.get(i11);
    }

    public final com.transsion.home.utils.b s0() {
        return (com.transsion.home.utils.b) this.f52780h.getValue();
    }

    public final void w0() {
        Subject subjectR0 = r0();
        e eVar = this.f52778f;
        if (eVar != null) {
            eVar.f70421j.setText(subjectR0 != null ? subjectR0.getTitle() : null);
            Date dateK = h0.k(subjectR0 != null ? subjectR0.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateK);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            if (!TextUtils.isEmpty(subjectR0 != null ? subjectR0.getCountryName() : null)) {
                spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) (subjectR0 != null ? subjectR0.getCountryName() : null));
            }
            eVar.f70416d.setText(spannableStringBuilder.toString());
            Drawable drawable = z2.a.getDrawable(eVar.getRoot().getContext(), com.transsion.moviedetailapi.a.a(subjectR0 != null ? subjectR0.getSubjectType() : null));
            if (drawable != null) {
                drawable.setTint(z2.a.getColor(eVar.getRoot().getContext(), R$color.gray_40));
            }
            eVar.f70416d.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            s0().d("OneClickToDownloadDialog", subjectR0 != null ? subjectR0.getSubjectId() : null);
        }
    }
}
