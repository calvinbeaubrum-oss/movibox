package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class StateView extends FrameLayout {
    public static final a Companion = new a(null);
    public static final int LOCATION_LABEL_FLOATING_LAYER = 3;
    public static final int LOCATION_LABEL_FULL_SCREEN = 1;
    public static final int LOCATION_LABEL_HALF_SCREEN = 2;
    public static final int LOCATION_LABEL_HALF_SCREEN_NONE = 5;
    public static final int LOCATION_LABEL_HALF_SCREEN_NONE_SMALL = 6;
    public static final int LOCATION_LABEL__FULL_SCREEN_WITH_STATUS_BAR = 4;
    public static final int STATE_TYPE_ERROR_DATA = 3;
    public static final int STATE_TYPE_NO_DATA = 2;
    public static final int STATE_TYPE_NO_DATA_WITH_RETRY = 4;
    public static final int STATE_TYPE_NO_NETWORK = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yp.b f49613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49614b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49613a = yp.b.a((LinearLayoutCompat) LayoutInflater.from(getContext()).inflate(R$layout.default_state_view_layout, this).findViewById(R$id.stateRoot));
        this.f49614b = R$mipmap.ic_no_content;
        b(context, attributeSet);
    }

    public static final void c(Function0 onClick, View view) {
        Intrinsics.g(onClick, "$onClick");
        onClick.invoke();
    }

    private final void setDefaultImageMargin(int i11) {
        yp.b bVar = this.f49613a;
        if (bVar != null) {
            ViewGroup.LayoutParams layoutParams = bVar.f81577b.getLayoutParams();
            LinearLayoutCompat.a aVar = layoutParams instanceof LinearLayoutCompat.a ? (LinearLayoutCompat.a) layoutParams : null;
            switch (i11) {
                case 1:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = f0.a(128.0f);
                        break;
                    }
                    break;
                case 2:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = f0.a(72.0f);
                        break;
                    }
                    break;
                case 3:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = f0.a(48.0f);
                        break;
                    }
                    break;
                case 4:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = f0.a(172.0f) + com.blankj.utilcode.util.d.c();
                        break;
                    }
                    break;
                case 5:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = 0;
                        break;
                    }
                    break;
                case 6:
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).topMargin = 0;
                    }
                    if (aVar != null) {
                        ((LinearLayout.LayoutParams) aVar).width = f0.a(200.0f);
                        break;
                    }
                    break;
            }
        }
    }

    public static /* synthetic */ void showData$default(StateView stateView, int i11, int i12, boolean z11, String str, String str2, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showData");
        }
        if ((i13 & 16) != 0) {
            str2 = "";
        }
        stateView.showData(i11, i12, z11, str, str2);
    }

    public void b(Context context, AttributeSet attributeSet) {
        Intrinsics.g(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StateView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…s, R.styleable.StateView)");
        setDefaultImageMargin(typedArrayObtainStyledAttributes.getInt(R$styleable.StateView_screen_type, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final yp.b getMViewBinding() {
        return this.f49613a;
    }

    public int getNoContentResId() {
        return this.f49614b;
    }

    public final void retry(final Function0<Unit> onClick) {
        TextView textView;
        Intrinsics.g(onClick, "onClick");
        yp.b bVar = this.f49613a;
        if (bVar == null || (textView = bVar.f81581g) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StateView.c(onClick, view);
            }
        });
    }

    public final void setMViewBinding(yp.b bVar) {
        this.f49613a = bVar;
    }

    public void setNoContentResId(int i11) {
        this.f49614b = i11;
    }

    public final void setReTryTxt(String txt) {
        Intrinsics.g(txt, "txt");
        yp.b bVar = this.f49613a;
        TextView textView = bVar != null ? bVar.f81581g : null;
        if (textView == null) {
            return;
        }
        textView.setText(txt);
    }

    public final void showData(int i11, int i12, boolean z11, String title, String desc) {
        TextView tvRetry;
        TextView tvRetry2;
        TextView tvRetry3;
        TextView tvRetry4;
        Intrinsics.g(title, "title");
        Intrinsics.g(desc, "desc");
        yp.b bVar = this.f49613a;
        if (bVar != null) {
            setDefaultImageMargin(i12);
            if (z11) {
                TitleLayout titleLayout = bVar.f81578c;
                titleLayout.setTitleText(title);
                titleLayout.setVisibility(0);
            }
            AppCompatImageView appCompatImageView = bVar.f81577b;
            if (i11 == 1) {
                appCompatImageView.setImageResource(R$mipmap.ic_no_network);
                TextView textView = bVar.f81580f;
                if (TextUtils.isEmpty(desc)) {
                    desc = appCompatImageView.getResources().getString(R$string.no_network_toast);
                }
                textView.setText(desc);
                yp.b bVar2 = this.f49613a;
                if (bVar2 == null || (tvRetry = bVar2.f81581g) == null) {
                    return;
                }
                Intrinsics.f(tvRetry, "tvRetry");
                so.c.k(tvRetry);
                return;
            }
            if (i11 == 2) {
                appCompatImageView.setImageResource(getNoContentResId());
                TextView textView2 = bVar.f81580f;
                if (TextUtils.isEmpty(desc)) {
                    desc = appCompatImageView.getResources().getString(R$string.no_content);
                }
                textView2.setText(desc);
                yp.b bVar3 = this.f49613a;
                if (bVar3 == null || (tvRetry2 = bVar3.f81581g) == null) {
                    return;
                }
                Intrinsics.f(tvRetry2, "tvRetry");
                so.c.g(tvRetry2);
                return;
            }
            if (i11 == 3) {
                appCompatImageView.setImageResource(R$mipmap.ic_no_error);
                TextView textView3 = bVar.f81580f;
                if (TextUtils.isEmpty(desc)) {
                    desc = appCompatImageView.getResources().getString(R$string.no_error_content);
                }
                textView3.setText(desc);
                yp.b bVar4 = this.f49613a;
                if (bVar4 == null || (tvRetry3 = bVar4.f81581g) == null) {
                    return;
                }
                Intrinsics.f(tvRetry3, "tvRetry");
                so.c.k(tvRetry3);
                return;
            }
            if (i11 != 4) {
                return;
            }
            appCompatImageView.setImageResource(getNoContentResId());
            TextView textView4 = bVar.f81580f;
            if (TextUtils.isEmpty(desc)) {
                desc = appCompatImageView.getResources().getString(R$string.no_content);
            }
            textView4.setText(desc);
            yp.b bVar5 = this.f49613a;
            if (bVar5 == null || (tvRetry4 = bVar5.f81581g) == null) {
                return;
            }
            Intrinsics.f(tvRetry4, "tvRetry");
            so.c.k(tvRetry4);
        }
    }

    public final void upDateEmptyDescText(String txt) {
        Intrinsics.g(txt, "txt");
        yp.b bVar = this.f49613a;
        TextView textView = bVar != null ? bVar.f81580f : null;
        if (textView == null) {
            return;
        }
        textView.setText(txt);
    }

    public final void updateNoContentResId(int i11) {
        setNoContentResId(i11);
    }
}
