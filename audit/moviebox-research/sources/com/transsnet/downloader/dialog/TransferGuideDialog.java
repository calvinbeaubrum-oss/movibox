package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.tn.lib.view.indicator.CircleIndicator;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.TransferTipsMmkv;
import kotlin.Metadata;
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
public final class TransferGuideDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f60564g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h00.p f60565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer[] f60566d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer[] f60567f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return TransferTipsMmkv.f61150a.b();
        }

        public final TransferGuideDialog b() {
            TransferGuideDialog transferGuideDialog = new TransferGuideDialog();
            transferGuideDialog.setArguments(new Bundle());
            return transferGuideDialog;
        }

        public final void c() {
            TransferTipsMmkv.f61150a.c(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer[] f60568i;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ImageView f60569b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View itemView) {
                super(itemView);
                Intrinsics.g(itemView, "itemView");
                View viewFindViewById = itemView.findViewById(R$id.f60285iv);
                Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.iv)");
                this.f60569b = (ImageView) viewFindViewById;
            }

            public final ImageView e() {
                return this.f60569b;
            }
        }

        public b(Integer[] dataList) {
            Intrinsics.g(dataList, "dataList");
            this.f60568i = dataList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int i11) {
            Intrinsics.g(holder, "holder");
            Glide.with(holder.e()).load2(Integer.valueOf(this.f60568i[i11].intValue())).into(holder.e());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int i11) {
            Intrinsics.g(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_transfer_tips_dialog_item, parent, false);
            Intrinsics.f(viewInflate, "from(parent.context)\n   …alog_item, parent, false)");
            return new a(viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f60568i.length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            TextView textView;
            CircleIndicator circleIndicator;
            super.onPageSelected(i11);
            h00.p pVar = TransferGuideDialog.this.f60565c;
            TextView textView2 = pVar != null ? pVar.f65981b : null;
            if (textView2 != null) {
                TransferGuideDialog transferGuideDialog = TransferGuideDialog.this;
                textView2.setText(transferGuideDialog.getString(transferGuideDialog.f60567f[i11].intValue()));
            }
            if (i11 == TransferGuideDialog.this.f60566d.length - 1) {
                h00.p pVar2 = TransferGuideDialog.this.f60565c;
                textView = pVar2 != null ? pVar2.f65985g : null;
                if (textView != null) {
                    textView.setText(TransferGuideDialog.this.getString(R$string.download_tab_transfer_tips_get));
                }
            } else {
                h00.p pVar3 = TransferGuideDialog.this.f60565c;
                textView = pVar3 != null ? pVar3.f65985g : null;
                if (textView != null) {
                    textView.setText(TransferGuideDialog.this.getString(R$string.download_tab_transfer_tips_next));
                }
            }
            h00.p pVar4 = TransferGuideDialog.this.f60565c;
            if (pVar4 == null || (circleIndicator = pVar4.f65983d) == null) {
                return;
            }
            circleIndicator.onPageSelected(i11 % TransferGuideDialog.this.f60566d.length);
        }
    }

    public TransferGuideDialog() {
        super(R$layout.dialog_transfer_tips_layout);
        this.f60566d = new Integer[]{Integer.valueOf(R$mipmap.image_transfer_tips_step1), Integer.valueOf(R$mipmap.image_transfer_tips_step2), Integer.valueOf(R$mipmap.image_transfer_tips_step3)};
        this.f60567f = new Integer[]{Integer.valueOf(R$string.download_tab_transfer_tips_desc_1), Integer.valueOf(R$string.download_tab_transfer_tips_desc_2), Integer.valueOf(R$string.download_tab_transfer_tips_desc_3)};
    }

    private final void initView() {
        CircleIndicator circleIndicator;
        CircleIndicator circleIndicator2;
        com.tn.lib.view.indicator.a indicatorConfig;
        AppCompatImageView appCompatImageView;
        TextView textView;
        ViewPager2 viewPager2;
        h00.p pVar = this.f60565c;
        if (pVar != null && (viewPager2 = pVar.f65982c) != null) {
            viewPager2.registerOnPageChangeCallback(new c());
            viewPager2.setAdapter(new b(this.f60566d));
            viewPager2.setCurrentItem(0);
        }
        h00.p pVar2 = this.f60565c;
        if (pVar2 != null && (textView = pVar2.f65985g) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransferGuideDialog.s0(this.f60589a, view);
                }
            });
        }
        h00.p pVar3 = this.f60565c;
        if (pVar3 != null && (appCompatImageView = pVar3.f65984f) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransferGuideDialog.t0(this.f60591a, view);
                }
            });
        }
        h00.p pVar4 = this.f60565c;
        if (pVar4 != null && (circleIndicator2 = pVar4.f65983d) != null && (indicatorConfig = circleIndicator2.getIndicatorConfig()) != null) {
            indicatorConfig.w(Color.parseColor("#10A84D"));
            indicatorConfig.t(Color.parseColor("#66FFFFFF"));
            indicatorConfig.u(com.blankj.utilcode.util.f0.a(8.0f));
            indicatorConfig.x(com.blankj.utilcode.util.f0.a(8.0f));
            indicatorConfig.q(this.f60566d.length);
        }
        h00.p pVar5 = this.f60565c;
        if (pVar5 == null || (circleIndicator = pVar5.f65983d) == null) {
            return;
        }
        circleIndicator.post(new Runnable() { // from class: com.transsnet.downloader.dialog.k0
            @Override // java.lang.Runnable
            public final void run() {
                TransferGuideDialog.u0(this.f60593a);
            }
        });
    }

    public static final void s0(TransferGuideDialog this$0, View view) {
        ViewPager2 viewPager2;
        Intrinsics.g(this$0, "this$0");
        h00.p pVar = this$0.f60565c;
        int currentItem = (pVar == null || (viewPager2 = pVar.f65982c) == null) ? 0 : viewPager2.getCurrentItem();
        if (currentItem == this$0.f60566d.length - 1) {
            this$0.dismissAllowingStateLoss();
            return;
        }
        int i11 = currentItem + 1;
        h00.p pVar2 = this$0.f60565c;
        ViewPager2 viewPager3 = pVar2 != null ? pVar2.f65982c : null;
        if (viewPager3 == null) {
            return;
        }
        viewPager3.setCurrentItem(i11);
    }

    public static final void t0(TransferGuideDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void u0(TransferGuideDialog this$0) {
        CircleIndicator circleIndicator;
        Intrinsics.g(this$0, "this$0");
        h00.p pVar = this$0.f60565c;
        if (pVar == null || (circleIndicator = pVar.f65983d) == null) {
            return;
        }
        circleIndicator.requestLayout();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        ((ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class)).v1();
        this.f60565c = h00.p.a(view);
        initView();
    }
}
