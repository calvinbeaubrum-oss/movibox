package com.transsion.moviedetail.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.Postcard;
import com.transsion.baseui.R$string;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class ResourceDetectorDialogFragment extends BaseDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f53509f = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResourceDetectors f53510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53511d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResourceDetectorDialogFragment a(String title, ResourceDetectors resourceDetectors) {
            Intrinsics.g(title, "title");
            Intrinsics.g(resourceDetectors, "resourceDetectors");
            ResourceDetectorDialogFragment resourceDetectorDialogFragment = new ResourceDetectorDialogFragment();
            resourceDetectorDialogFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("arguments_resource_detectors_title", title), TuplesKt.a("arguments_resource_detectors", resourceDetectors)));
            return resourceDetectorDialogFragment;
        }
    }

    public ResourceDetectorDialogFragment() {
        super(R$layout.dialog_resource_detector_layout);
        this.f53511d = "";
    }

    private final int o0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public static final void r0(ResourceDetectorDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(ResourceDetectorDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW);
        ResourceDetectors resourceDetectors = this$0.f53510c;
        postcardB.withString("url", resourceDetectors != null ? resourceDetectors.getResourceLink() : null).withBoolean(WebConstants.FIELD_LOAD_URL_ONLY, true).navigation();
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f53510c = (ResourceDetectors) arguments.getSerializable("arguments_resource_detectors");
            this.f53511d = arguments.getString("arguments_resource_detectors_title");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = o0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        q0(view);
    }

    public final SpannableString p0(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (StringsKt__StringsKt.Q(str, "etc", false, 2, null)) {
            try {
                Result.Companion companion = Result.Companion;
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1FBDFF")), 0, StringsKt__StringsKt.d0(str, "etc", 0, false, 6, null), 17);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            return spannableString;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1FBDFF")), 0, spannableString.length(), 17);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th3));
        }
        return spannableString;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0087  */
    public final void q0(View view) {
        String strB;
        String uploadTime;
        Long firstSize;
        long jLongValue;
        Integer type;
        Long totalSize;
        String source;
        ((ImageView) view.findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ResourceDetectorDialogFragment.r0(this.f53661a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tvTitle)).setText(this.f53511d);
        TextView textView = (TextView) view.findViewById(R$id.tvUrl);
        if (textView != null) {
            ResourceDetectors resourceDetectors = this.f53510c;
            textView.setText(resourceDetectors != null ? resourceDetectors.getResourceLink() : null);
        }
        TextView textView2 = (TextView) view.findViewById(R$id.tvSourceData);
        String str = "";
        if (textView2 != null) {
            ResourceDetectors resourceDetectors2 = this.f53510c;
            if (resourceDetectors2 == null || (source = resourceDetectors2.getSource()) == null) {
                source = "";
            }
            textView2.setText(p0(source));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResourceDetectorDialogFragment.s0(this.f53663a, view2);
                }
            });
        }
        TextView textView3 = (TextView) view.findViewById(R$id.tvSizeData);
        long j11 = 0;
        if (textView3 != null) {
            ResourceDetectors resourceDetectors3 = this.f53510c;
            if (resourceDetectors3 == null || (type = resourceDetectors3.getType()) == null || type.intValue() != 0) {
                ResourceDetectors resourceDetectors4 = this.f53510c;
                if (resourceDetectors4 == null || (firstSize = resourceDetectors4.getFirstSize()) == null) {
                    jLongValue = 0;
                } else {
                    jLongValue = firstSize.longValue();
                }
            } else {
                ResourceDetectors resourceDetectors5 = this.f53510c;
                if (resourceDetectors5 == null || (totalSize = resourceDetectors5.getTotalSize()) == null) {
                    jLongValue = 0;
                } else {
                    jLongValue = totalSize.longValue();
                }
            }
            textView3.setText(tp.a.a(jLongValue, 1));
        }
        TextView textView4 = (TextView) view.findViewById(R$id.tvDateData);
        if (textView4 != null) {
            try {
                Result.Companion companion = Result.Companion;
                ResourceDetectors resourceDetectors6 = this.f53510c;
                if (resourceDetectors6 != null && (uploadTime = resourceDetectors6.getUploadTime()) != null) {
                    j11 = Long.parseLong(uploadTime) * ((long) 1000);
                }
                strB = com.blankj.utilcode.util.h0.b(com.blankj.utilcode.util.h0.g(j11), "yyyy-MM-dd");
                Intrinsics.f(strB, "date2String(\n           …-MM-dd\"\n                )");
                try {
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    th = th2;
                    str = strB;
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th));
                    strB = str;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            textView4.setText(strB);
        }
        TextView textView5 = (TextView) view.findViewById(R$id.tvUploadedBy);
        if (textView5 != null) {
            String string = textView5.getContext().getString(R$string.base_ui_uploaded_by);
            ResourceDetectors resourceDetectors7 = this.f53510c;
            textView5.setText(string + " " + (resourceDetectors7 != null ? resourceDetectors7.getUploadBy() : null));
        }
    }
}
