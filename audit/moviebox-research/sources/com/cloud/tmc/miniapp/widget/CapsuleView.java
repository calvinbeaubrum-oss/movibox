package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$styleable;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.z;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class CapsuleView extends LinearLayoutCompat {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final Lazy f31812OooO;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO00o;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO0O0;
    public final HashMap<Integer, Integer> OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final HashMap<Integer, Integer> f31813OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public Function0<Unit> f31814OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public Function0<Unit> f31815OooO0o0;
    public final Lazy OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final Lazy f31816OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Lazy f31817OooOO0;
    public HashMap<Integer, HashMap<Integer, Integer>> OooOO0O;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) CapsuleView.this.findViewById(R$id.iv_left);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<LinearLayoutCompat> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public LinearLayoutCompat invoke() {
            return (LinearLayoutCompat) CapsuleView.this.findViewById(R$id.capsule_layout);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<View> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return CapsuleView.this.findViewById(R$id.view_center_line);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) CapsuleView.this.findViewById(R$id.iv_right);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements vc.a<Drawable> {
        public a() {
        }

        @Override // vc.a
        public void a(String str) {
        }

        @Override // vc.a
        public void b(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvLeft().setForeground(drawable2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements vc.a<Drawable> {
        public b() {
        }

        @Override // vc.a
        public void a(String str) {
        }

        @Override // vc.a
        public void b(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvRight().setForeground(drawable2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapsuleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        HashMap<Integer, HashMap<Integer, Integer>> mapJ = kotlin.collections.s.j(TuplesKt.a(0, kotlin.collections.s.j(TuplesKt.a(Integer.valueOf(R$id.iv_left), Integer.valueOf(R$drawable.mini_ic_title_more_white_mode)), TuplesKt.a(Integer.valueOf(R$id.iv_right), Integer.valueOf(R$drawable.mini_ic_title_close_white_mode)))), TuplesKt.a(1, kotlin.collections.s.j(TuplesKt.a(Integer.valueOf(R$id.iv_left), Integer.valueOf(R$drawable.mini_ic_title_more_black_mode)), TuplesKt.a(Integer.valueOf(R$id.iv_right), Integer.valueOf(R$drawable.mini_ic_title_close_black_mode)))));
        this.OooO00o = mapJ;
        HashMap<Integer, HashMap<Integer, Integer>> mapJ2 = kotlin.collections.s.j(TuplesKt.a(0, kotlin.collections.s.j(TuplesKt.a(Integer.valueOf(R$id.iv_left), Integer.valueOf(R$drawable.mini_ic_title_back_white_mode)), TuplesKt.a(Integer.valueOf(R$id.iv_right), Integer.valueOf(R$drawable.mini_ic_title_home_white_mode)))), TuplesKt.a(1, kotlin.collections.s.j(TuplesKt.a(Integer.valueOf(R$id.iv_left), Integer.valueOf(R$drawable.mini_ic_immersive_title_bar_back_black_mode)), TuplesKt.a(Integer.valueOf(R$id.iv_right), Integer.valueOf(R$drawable.mini_ic_immersive_title_bar_home_black_mode)))));
        this.OooO0O0 = mapJ2;
        this.OooO0OO = kotlin.collections.s.j(TuplesKt.a(0, Integer.valueOf(R$color.mini_color_capsule_line_white_mode_bg)), TuplesKt.a(1, Integer.valueOf(R$color.mini_color_border_capsule)));
        this.f31813OooO0Oo = kotlin.collections.s.j(TuplesKt.a(0, Integer.valueOf(R$drawable.shape_bg_capsule_white_mode)), TuplesKt.a(1, Integer.valueOf(R$drawable.shape_bg_capsule_black_mode)));
        this.OooO0oO = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f31816OooO0oo = LazyKt__LazyJVMKt.b(new OooO());
        this.f31812OooO = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f31817OooOO0 = LazyKt__LazyJVMKt.b(new OooOO0());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Mini_CapsuleView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.Mini_CapsuleView)");
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.Mini_CapsuleView_capsule_style, 0);
        if (i11 != 1 && i11 == 2) {
            mapJ = mapJ2;
        }
        this.OooOO0O = mapJ;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R$layout.layout_mini_capsule, this);
        if (!isInEditMode()) {
            getIvLeft().setRotationY(j0.a() ? 180.0f : 0.0f);
            getIvRight().setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        getIvLeft().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO00o(this.f31891a, view);
            }
        });
        getIvRight().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO0O0(this.f31892a, view);
            }
        });
        int i12 = !z.a(context) ? 1 : 0;
        try {
            ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
            imageLoaderProxy.loadImg(context, R$drawable.shape_fg_capsule_left_click, 0, getIvLeft(), new a());
            imageLoaderProxy.loadImg(context, R$drawable.shape_fg_capsule_right_click, 0, getIvRight(), new b());
        } catch (Throwable th2) {
            TmcLogger.h("", th2);
        }
        OooO00o(this, i12, null, 2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005f A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:12:0x0044, B:18:0x0059, B:20:0x005f, B:21:0x006b, B:17:0x0055), top: B:49:0x0044, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x006b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:12:0x0044, B:18:0x0059, B:20:0x005f, B:21:0x006b, B:17:0x0055), top: B:49:0x0044, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0086  */
    /* JADX WARN: Code duplicated, block: B:30:0x0089 A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0078, B:31:0x008d, B:33:0x0093, B:34:0x009f, B:30:0x0089), top: B:50:0x0078, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[Catch: all -> 0x0087, PHI: r8
  0x008d: PHI (r8v11 java.lang.Integer) = (r8v10 java.lang.Integer), (r8v13 java.lang.Integer) binds: [B:26:0x0084, B:30:0x0089] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0078, B:31:0x008d, B:33:0x0093, B:34:0x009f, B:30:0x0089), top: B:50:0x0078, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0093 A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0078, B:31:0x008d, B:33:0x0093, B:34:0x009f, B:30:0x0089), top: B:50:0x0078, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009f A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x0078, B:31:0x008d, B:33:0x0093, B:34:0x009f, B:30:0x0089), top: B:50:0x0078, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void OooO00o(CapsuleView capsuleView, int i11, HashMap map, int i12) {
        Integer num;
        Integer num2;
        int iIntValue;
        int iIntValue2;
        HashMap<Integer, HashMap<Integer, Integer>> style = (i12 & 2) != 0 ? capsuleView.OooOO0O : null;
        capsuleView.getClass();
        Intrinsics.g(style, "style");
        LinearLayoutCompat capsuleLayout = capsuleView.getCapsuleLayout();
        Integer num3 = capsuleView.f31813OooO0Oo.get(Integer.valueOf(i11));
        if (num3 == null) {
            num3 = 0;
        }
        capsuleLayout.setBackgroundResource(num3.intValue());
        HashMap<Integer, Integer> map2 = style.get(Integer.valueOf(i11));
        try {
            ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
            if (map2 != null) {
                try {
                    num = map2.get(Integer.valueOf(R$id.iv_left));
                    if (num == null) {
                        num = 0;
                        iIntValue2 = num.intValue();
                        if (iIntValue2 != 0) {
                            imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue2, iIntValue2, capsuleView.getIvLeft());
                        } else {
                            capsuleView.getIvLeft().setImageResource(iIntValue2);
                        }
                    } else {
                        iIntValue2 = num.intValue();
                        if (iIntValue2 != 0) {
                            imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue2, iIntValue2, capsuleView.getIvLeft());
                        } else {
                            capsuleView.getIvLeft().setImageResource(iIntValue2);
                        }
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("", th2);
                }
                if (map2 != null) {
                    try {
                        num2 = map2.get(Integer.valueOf(R$id.iv_right));
                        if (num2 == null) {
                            num2 = 0;
                            iIntValue = num2.intValue();
                            if (iIntValue != 0) {
                                imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                            } else {
                                capsuleView.getIvRight().setImageResource(iIntValue);
                            }
                        } else {
                            iIntValue = num2.intValue();
                            if (iIntValue != 0) {
                                imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                            } else {
                                capsuleView.getIvRight().setImageResource(iIntValue);
                            }
                        }
                    } catch (Throwable th3) {
                        TmcLogger.h("", th3);
                    }
                } else {
                    num2 = 0;
                    iIntValue = num2.intValue();
                    if (iIntValue != 0) {
                        imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                    } else {
                        capsuleView.getIvRight().setImageResource(iIntValue);
                    }
                }
            } else {
                num = 0;
                iIntValue2 = num.intValue();
                if (iIntValue2 != 0) {
                    imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue2, iIntValue2, capsuleView.getIvLeft());
                } else {
                    capsuleView.getIvLeft().setImageResource(iIntValue2);
                }
                if (map2 != null) {
                    num2 = map2.get(Integer.valueOf(R$id.iv_right));
                    if (num2 == null) {
                        num2 = 0;
                        iIntValue = num2.intValue();
                        if (iIntValue != 0) {
                            imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                        } else {
                            capsuleView.getIvRight().setImageResource(iIntValue);
                        }
                    } else {
                        iIntValue = num2.intValue();
                        if (iIntValue != 0) {
                            imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                        } else {
                            capsuleView.getIvRight().setImageResource(iIntValue);
                        }
                    }
                } else {
                    num2 = 0;
                    iIntValue = num2.intValue();
                    if (iIntValue != 0) {
                        imageLoaderProxy.loadImg(capsuleView.getContext(), iIntValue, iIntValue, capsuleView.getIvRight());
                    } else {
                        capsuleView.getIvRight().setImageResource(iIntValue);
                    }
                }
            }
        } catch (Throwable th4) {
            TmcLogger.h("", th4);
        }
        try {
            View centerLineView = capsuleView.getCenterLineView();
            Context context = capsuleView.getContext();
            Integer numValueOf = capsuleView.OooO0OO.get(Integer.valueOf(i11));
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(R$color.mini_color_border_capsule);
            }
            centerLineView.setBackgroundColor(z2.a.getColor(context, numValueOf.intValue()));
        } catch (Throwable th5) {
            TmcLogger.h("", th5);
        }
    }

    public static final void OooO00o(CapsuleView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.g(this$0, "this$0");
        if (com.cloud.tmc.integration.utils.u.a() || (function0 = this$0.f31815OooO0o0) == null) {
            return;
        }
        function0.invoke();
    }

    public static final void OooO0O0(CapsuleView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.g(this$0, "this$0");
        if (com.cloud.tmc.integration.utils.u.a() || (function0 = this$0.f31814OooO0o) == null) {
            return;
        }
        function0.invoke();
    }

    private final LinearLayoutCompat getCapsuleLayout() {
        Object value = this.OooO0oO.getValue();
        Intrinsics.f(value, "<get-capsuleLayout>(...)");
        return (LinearLayoutCompat) value;
    }

    private final View getCenterLineView() {
        Object value = this.f31812OooO.getValue();
        Intrinsics.f(value, "<get-centerLineView>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvLeft() {
        Object value = this.f31816OooO0oo.getValue();
        Intrinsics.f(value, "<get-ivLeft>(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvRight() {
        Object value = this.f31817OooOO0.getValue();
        Intrinsics.f(value, "<get-ivRight>(...)");
        return (AppCompatImageView) value;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getBackAndHome() {
        return this.OooO0O0;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getCapsuleStyle() {
        return this.OooOO0O;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getMoreAndClose() {
        return this.OooO00o;
    }

    public final void setCapsuleStyle(HashMap<Integer, HashMap<Integer, Integer>> map) {
        Intrinsics.g(map, "<set-?>");
        this.OooOO0O = map;
    }

    public final void setOnLeftClickListener(Function0<Unit> cb2) {
        Intrinsics.g(cb2, "cb");
        this.f31815OooO0o0 = cb2;
    }

    public final void setOnRightClickListener(Function0<Unit> cb2) {
        Intrinsics.g(cb2, "cb");
        this.f31814OooO0o = cb2;
    }
}
