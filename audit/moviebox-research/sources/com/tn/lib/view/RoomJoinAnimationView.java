package com.tn.lib.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class RoomJoinAnimationView extends BLFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yp.e f49564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f49567d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f49568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f49569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f49570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f49571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f49572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f49573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f49574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RoomJoinStatus f49575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f49576n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49577a;

        static {
            int[] iArr = new int[RoomJoinStatus.values().length];
            try {
                iArr[RoomJoinStatus.JOIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomJoinStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomJoinStatus.JOINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49577a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomJoinAnimationView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomJoinAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomJoinAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49565b = f0.a(4.0f);
        String string = Utils.a().getString(R$string.Join);
        Intrinsics.f(string, "getApp().getString(R.string.Join)");
        this.f49573k = string;
        String string2 = Utils.a().getString(R$string.Leave);
        Intrinsics.f(string2, "getApp().getString(R.string.Leave)");
        this.f49574l = string2;
        RoomJoinStatus roomJoinStatus = RoomJoinStatus.JOIN;
        this.f49575m = roomJoinStatus;
        View.inflate(context, R$layout.view_room_join, this);
        yp.e eVarA = yp.e.a(this);
        Intrinsics.f(eVarA, "bind(this)");
        this.f49564a = eVarA;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoomJoinAnimationView, 0, 0);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…mJoinAnimationView, 0, 0)");
        int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.RoomJoinAnimationView_jv_style, 0);
        this.f49566c = i12;
        this.f49567d = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_join_bg, -1);
        this.f49568f = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_loading_bg, Utils.a().getResources().getColor(R$color.white_20));
        this.f49569g = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_joined_bg, Utils.a().getResources().getColor(R$color.white_20));
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_loading_color, Utils.a().getResources().getColor(R$color.white_80));
        this.f49570h = color;
        this.f49571i = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_join_text_color, ViewCompat.MEASURED_STATE_MASK);
        this.f49572j = typedArrayObtainStyledAttributes.getColor(R$styleable.RoomJoinAnimationView_jv_text_joined_text_color, ViewCompat.MEASURED_STATE_MASK);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoomJoinAnimationView_jv_text_text_size, 14.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoomJoinAnimationView_jv_text_loading_size, 16.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (i12 == 0) {
            AppCompatTextView appCompatTextView = eVarA.f81598d;
            Intrinsics.f(appCompatTextView, "viewBinding.tvJoin");
            so.c.g(appCompatTextView);
            ProgressBar progressBar = eVarA.f81597c;
            Intrinsics.f(progressBar, "viewBinding.pbLoading");
            so.c.g(progressBar);
            AppCompatImageView appCompatImageView = eVarA.f81596b;
            Intrinsics.f(appCompatImageView, "viewBinding.ivJoin");
            so.c.k(appCompatImageView);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(eVarA.f81596b, "rotation", 0.0f, 360.0f);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            this.f49576n = objectAnimatorOfFloat;
        } else {
            AppCompatTextView appCompatTextView2 = eVarA.f81598d;
            Intrinsics.f(appCompatTextView2, "viewBinding.tvJoin");
            so.c.k(appCompatTextView2);
            ProgressBar progressBar2 = eVarA.f81597c;
            Intrinsics.f(progressBar2, "viewBinding.pbLoading");
            so.c.k(progressBar2);
            AppCompatImageView appCompatImageView2 = eVarA.f81596b;
            Intrinsics.f(appCompatImageView2, "viewBinding.ivJoin");
            so.c.g(appCompatImageView2);
            eVarA.f81598d.setTextSize(dimension);
            eVarA.f81598d.setTextSize(0, dimension);
            ViewGroup.LayoutParams layoutParams = eVarA.f81597c.getLayoutParams();
            if (layoutParams == null) {
                int i13 = (int) dimension2;
                layoutParams = new FrameLayout.LayoutParams(i13, i13);
            }
            int i14 = (int) dimension2;
            layoutParams.width = i14;
            layoutParams.height = i14;
            eVarA.f81597c.setLayoutParams(layoutParams);
            eVarA.f81597c.setIndeterminateTintList(ColorStateList.valueOf(color));
        }
        setStatus(roomJoinStatus);
    }

    public final void a() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f49576n;
        if ((objectAnimator2 == null || !objectAnimator2.isRunning()) && (objectAnimator = this.f49576n) != null) {
            objectAnimator.start();
        }
    }

    public final void b() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f49576n;
        if (objectAnimator2 == null || !objectAnimator2.isRunning() || (objectAnimator = this.f49576n) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    public final RoomJoinStatus getStatus() {
        return this.f49575m;
    }

    public final boolean isLoading() {
        return this.f49575m == RoomJoinStatus.LOADING;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f49575m == RoomJoinStatus.LOADING) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final void setStatus(RoomJoinStatus status) {
        String str;
        int i11;
        int i12;
        int i13;
        Intrinsics.g(status, "status");
        this.f49575m = status;
        if (this.f49566c == 0) {
            AppCompatImageView appCompatImageView = this.f49564a.f81596b;
            int i14 = a.f49577a[status.ordinal()];
            if (i14 == 1) {
                i13 = R$mipmap.ic_room_join_def_new;
            } else if (i14 == 2) {
                i13 = R$mipmap.ic_room_join_loading_new;
            } else {
                if (i14 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i13 = R$mipmap.ic_room_join_view_new;
            }
            appCompatImageView.setImageResource(i13);
            if (status == RoomJoinStatus.LOADING) {
                a();
                return;
            } else {
                this.f49564a.f81596b.setRotation(0.0f);
                b();
                return;
            }
        }
        ProgressBar progressBar = this.f49564a.f81597c;
        Intrinsics.f(progressBar, "viewBinding.pbLoading");
        so.c.g(progressBar);
        AppCompatTextView appCompatTextView = this.f49564a.f81598d;
        int[] iArr = a.f49577a;
        int i15 = iArr[status.ordinal()];
        if (i15 == 1) {
            str = this.f49573k;
        } else if (i15 == 2) {
            ProgressBar progressBar2 = this.f49564a.f81597c;
            Intrinsics.f(progressBar2, "viewBinding.pbLoading");
            so.c.k(progressBar2);
            str = "";
        } else {
            if (i15 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = this.f49574l;
        }
        appCompatTextView.setText(str);
        int i16 = iArr[status.ordinal()];
        if (i16 == 1) {
            i11 = this.f49567d;
        } else if (i16 == 2) {
            i11 = this.f49568f;
        } else {
            if (i16 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i11 = this.f49569g;
        }
        setBackground(new DrawableCreator.Builder().setCornersRadius(this.f49565b).setSolidColor(i11).build());
        int i17 = iArr[status.ordinal()];
        if (i17 == 1 || i17 == 2) {
            i12 = this.f49571i;
        } else {
            if (i17 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i12 = this.f49572j;
        }
        this.f49564a.f81598d.setTextColor(i12);
        if (iArr[status.ordinal()] == 1) {
            this.f49564a.f81598d.setCompoundDrawablesWithIntrinsicBounds(R$drawable.room_ic_add, 0, 0, 0);
        } else {
            this.f49564a.f81598d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }
}
