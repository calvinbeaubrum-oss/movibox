package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom1PopUpWindowView;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import tc.a;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AddHomeCustom1PopUpWindowView extends LinearLayout {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<TextView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AddHomeCustom1PopUpWindowView.this.findViewById(R$id.add_home_toast);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<ImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) AddHomeCustom1PopUpWindowView.this.findViewById(R$id.iv_images);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function1<Drawable, Unit> {
        public OooO0OO() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Drawable drawable) {
            Drawable drawable2 = drawable;
            ImageView ivImages = AddHomeCustom1PopUpWindowView.this.getIvImages();
            if (ivImages != null) {
                i.g(ivImages, drawable2 != null);
            }
            ImageView ivImages2 = AddHomeCustom1PopUpWindowView.this.getIvImages();
            if (ivImages2 != null) {
                ivImages2.setImageDrawable(drawable2);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AddHomeCustom1PopUpWindowView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddHomeCustom1PopUpWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooO00o());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooO0O0());
        LayoutInflater.from(context).inflate(R$layout.mini_layout_custom_addhomepopwindow_view_1, this);
        if (!isInEditMode()) {
            setTranslationY(getTranslationY() + e0.a());
        }
        setOnClickListener(new View.OnClickListener() { // from class: td.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddHomeCustom1PopUpWindowView.OooO00o(this.f76944a, view);
            }
        });
    }

    public /* synthetic */ AddHomeCustom1PopUpWindowView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void OooO00o(IResourceProcessor iResourceProcessor, String str, String str2, AddHomeCustom1PopUpWindowView this$0, final Function1 function1) {
        Intrinsics.g(this$0, "this$0");
        final File file = iResourceProcessor != null ? iResourceProcessor.get(str, str2) : null;
        ImageView ivImages = this$0.getIvImages();
        if (ivImages != null) {
            ivImages.post(new Runnable() { // from class: td.c
                @Override // java.lang.Runnable
                public final void run() {
                    AddHomeCustom1PopUpWindowView.OooO00o(function1, file);
                }
            });
        }
    }

    public static final void OooO00o(AddHomeCustom1PopUpWindowView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.getClass();
        i.c(this$0);
    }

    public static final void OooO00o(Function1 function1, File file) {
        if (function1 != null) {
            function1.invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
        }
    }

    private final TextView getAddHomeToast() {
        return (TextView) this.OooO00o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getIvImages() {
        return (ImageView) this.OooO0O0.getValue();
    }

    public final AddHomeCustom1PopUpWindowView OooO00o(String str) {
        TextView addHomeToast = getAddHomeToast();
        if (addHomeToast != null) {
            if (str == null || str.length() == 0) {
                str = getContext().getString(R$string.mini_toast_add_home_tips);
            }
            addHomeToast.setText(str);
        }
        return this;
    }

    public final AddHomeCustom1PopUpWindowView OooO00o(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            ImageView ivImages = getIvImages();
            if (ivImages != null) {
                i.d(ivImages);
            }
        } else {
            OooO00o(str2, str, new OooO0OO());
        }
        return this;
    }

    public final void OooO00o(final String str, final String str2, final Function1<? super Drawable, Unit> function1) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    final IResourceProcessor iResourceProcessor = (IResourceProcessor) a.a(IResourceProcessor.class);
                    if (i0.b(str) && !StringsKt__StringsKt.Q(str, ".miniapp.transsion.com", false, 2, null)) {
                        e.a(ExecutorType.IO, new Runnable() { // from class: td.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                AddHomeCustom1PopUpWindowView.OooO00o(iResourceProcessor, str, str2, this, function1);
                            }
                        });
                        return;
                    } else {
                        File file = iResourceProcessor != null ? iResourceProcessor.get(str, str2) : null;
                        ((OooO0OO) function1).invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.g("AddHomeCustom1PopUpWind", "requestDrawable failed!", th2);
                ((OooO0OO) function1).invoke(null);
                return;
            }
        }
        ((OooO0OO) function1).invoke(null);
    }
}
