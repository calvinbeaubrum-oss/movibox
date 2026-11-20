package com.cloud.tupdate.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cloud.tupdate.R$color;
import com.cloud.tupdate.R$id;
import com.cloud.tupdate.R$layout;
import com.cloud.tupdate.R$string;
import com.cloud.tupdate.bean.AppScoreContent;
import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.dialog.DialogPosition;
import com.cloud.tupdate.net.utils.LogUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32262a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: com.cloud.tupdate.utils.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0350a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f32263a;

            static {
                int[] iArr = new int[DialogPosition.values().length];
                iArr[DialogPosition.TOP.ordinal()] = 1;
                iArr[DialogPosition.MIDDLE.ordinal()] = 2;
                iArr[DialogPosition.BOTTOM.ordinal()] = 3;
                f32263a = iArr;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<ScrollView> f32264a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f32265b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<View> f32266c;

            public b(Ref.ObjectRef<ScrollView> objectRef, Ref.BooleanRef booleanRef, Ref.ObjectRef<View> objectRef2) {
                this.f32264a = objectRef;
                this.f32265b = booleanRef;
                this.f32266c = objectRef2;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                try {
                    View childAt = this.f32264a.element.getChildAt(0);
                    if (childAt != null) {
                        int height = childAt.getHeight();
                        this.f32265b.element = this.f32264a.element.getHeight() < height;
                        if (this.f32265b.element) {
                            View view = this.f32266c.element;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            this.f32264a.element.setVerticalScrollBarEnabled(true);
                        } else {
                            View view2 = this.f32266c.element;
                            if (view2 != null) {
                                view2.setVisibility(8);
                            }
                        }
                    }
                    ViewTreeObserver viewTreeObserver = this.f32264a.element.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                    return true;
                } catch (Exception e11) {
                    LogUtil.f32213a.d(e11);
                    return true;
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void m(re.a aVar, b bVar, View view) {
            try {
                aVar.dismiss();
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
            if (bVar == null) {
                return;
            }
            bVar.b();
        }

        public static final void n(te.e updateManager, DialogInterface dialogInterface) {
            Intrinsics.g(updateManager, "$updateManager");
            updateManager.g();
        }

        public static final void o(te.e updateManager, DialogInterface dialogInterface) {
            Intrinsics.g(updateManager, "$updateManager");
            updateManager.g();
        }

        public static final void p(re.a aVar, b bVar, View view) {
            try {
                aVar.dismiss();
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
            if (bVar == null) {
                return;
            }
            bVar.a();
        }

        public static final void r(te.e updateManager, DialogInterface dialogInterface) {
            Intrinsics.g(updateManager, "$updateManager");
            updateManager.d();
        }

        public static final void s(te.e updateManager, DialogInterface dialogInterface) {
            Intrinsics.g(updateManager, "$updateManager");
            updateManager.d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void t(Ref.ObjectRef contentScrollView, Ref.BooleanRef isScroll, Ref.ObjectRef contentScrollViewTop, Ref.ObjectRef contentScrollViewBottom) {
            Intrinsics.g(contentScrollView, "$contentScrollView");
            Intrinsics.g(isScroll, "$isScroll");
            Intrinsics.g(contentScrollViewTop, "$contentScrollViewTop");
            Intrinsics.g(contentScrollViewBottom, "$contentScrollViewBottom");
            try {
                int scrollY = ((ScrollView) contentScrollView.element).getScrollY();
                View childAt = ((ScrollView) contentScrollView.element).getChildAt(0);
                if (isScroll.element) {
                    if (scrollY <= 0) {
                        View view = (View) contentScrollViewTop.element;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                        View view2 = (View) contentScrollViewBottom.element;
                        if (view2 == null) {
                            return;
                        }
                        view2.setVisibility(0);
                        return;
                    }
                    if (scrollY == childAt.getHeight() - ((ScrollView) contentScrollView.element).getHeight()) {
                        View view3 = (View) contentScrollViewTop.element;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                        View view4 = (View) contentScrollViewBottom.element;
                        if (view4 == null) {
                            return;
                        }
                        view4.setVisibility(8);
                        return;
                    }
                    View view5 = (View) contentScrollViewTop.element;
                    if (view5 != null) {
                        view5.setVisibility(0);
                    }
                    View view6 = (View) contentScrollViewBottom.element;
                    if (view6 == null) {
                        return;
                    }
                    view6.setVisibility(0);
                }
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void u(Ref.ObjectRef cbIgnore, View view) {
            Intrinsics.g(cbIgnore, "$cbIgnore");
            T t11 = cbIgnore.element;
            CheckBox checkBox = (CheckBox) t11;
            if (checkBox == null) {
                return;
            }
            CheckBox checkBox2 = (CheckBox) t11;
            checkBox.setChecked(!(checkBox2 == null ? false : checkBox2.isChecked()));
        }

        public static final void v(c cVar, CompoundButton compoundButton, boolean z11) {
            if (cVar == null) {
                return;
            }
            cVar.c(z11);
        }

        public static final void w(c cVar, UpdateContent updateContent, te.e updateManager, re.a aVar, View view) {
            Intrinsics.g(updateManager, "$updateManager");
            if (cVar != null) {
                cVar.b();
            }
            d.f32241a.l(updateContent, updateManager, aVar);
        }

        public static final void x(re.a aVar, c cVar, View view) {
            try {
                aVar.dismiss();
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
            if (cVar == null) {
                return;
            }
            cVar.a();
        }

        public final void l(Context context, AppScoreContent appScoreContent, final te.e updateManager, final b bVar) {
            String scoreButton;
            Intrinsics.g(context, "context");
            Intrinsics.g(updateManager, "updateManager");
            final re.a aVarA = new re.a.b(context).d(R$layout.tupdate_score_dialog).f(new DialogInterface.OnShowListener() { // from class: com.cloud.tupdate.utils.m
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    p.a.n(updateManager, dialogInterface);
                }
            }).e(new DialogInterface.OnDismissListener() { // from class: com.cloud.tupdate.utils.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    p.a.o(updateManager, dialogInterface);
                }
            }).a();
            Window window = aVarA.getWindow();
            int i11 = C0350a.f32263a[updateManager.f().ordinal()];
            if (i11 == 1) {
                if (window != null) {
                    window.setGravity(48);
                }
                WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
                if (attributes != null) {
                    attributes.y = com.transsion.core.utils.e.a(updateManager.b());
                }
                if (window != null) {
                    window.setAttributes(attributes);
                }
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (window != null) {
                        window.setGravity(80);
                    }
                    WindowManager.LayoutParams attributes2 = window == null ? null : window.getAttributes();
                    if (attributes2 != null) {
                        attributes2.y = com.transsion.core.utils.e.a(updateManager.b());
                    }
                    if (window != null) {
                        window.setAttributes(attributes2);
                    }
                }
            } else if (window != null) {
                window.setGravity(17);
            }
            TextView textView = (TextView) aVarA.findViewById(R$id.tv_score_title);
            TextView textView2 = (TextView) aVarA.findViewById(R$id.tv_score_content);
            String scoreTitle = appScoreContent == null ? null : appScoreContent.getScoreTitle();
            if (scoreTitle == null || kotlin.text.l.y(scoreTitle)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (textView2 != null) {
                    textView2.setTextColor(context.getResources().getColor(R$color.update_color_191F2B));
                }
            } else {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    textView.setText(appScoreContent == null ? null : appScoreContent.getScoreTitle());
                }
                if (textView2 != null) {
                    textView2.setTextColor(context.getResources().getColor(R$color.update_color_92969E));
                }
            }
            String scoreContent = appScoreContent == null ? null : appScoreContent.getScoreContent();
            if (scoreContent == null || kotlin.text.l.y(scoreContent)) {
                if (textView2 != null) {
                    textView2.setText(context.getString(R$string.text_update_score_content));
                }
            } else if (textView2 != null) {
                textView2.setText(appScoreContent != null ? appScoreContent.getScoreContent() : null);
            }
            Button button = (Button) aVarA.findViewById(R$id.btn_negative);
            Button button2 = (Button) aVarA.findViewById(R$id.btn_positive);
            String string = (appScoreContent == null || (scoreButton = appScoreContent.getScoreButton()) == null || kotlin.text.l.y(scoreButton)) ? context.getString(R$string.text_update_score_button) : appScoreContent.getScoreButton();
            Intrinsics.f(string, "if (appScoreContent == n…eButton\n                }");
            if (button2 != null) {
                button2.setText(string);
            }
            String string2 = appScoreContent == null ? context.getString(R$string.text_update_cancel) : appScoreContent.getCancelScoreButton();
            if (button != null) {
                button.setText(string2);
            }
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tupdate.utils.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.a.p(aVarA, bVar, view);
                    }
                });
            }
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tupdate.utils.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.a.m(aVarA, bVar, view);
                    }
                });
            }
            try {
                updateManager.g();
                if (!(context instanceof Activity)) {
                    aVarA.show();
                } else {
                    if (((Activity) context).isFinishing()) {
                        return;
                    }
                    aVarA.show();
                }
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
        }

        /* JADX WARN: Code duplicated, block: B:226:0x03ae  */
        /* JADX WARN: Code duplicated, block: B:229:0x03b4  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v59, types: [T, android.widget.ScrollView] */
        /* JADX WARN: Type inference failed for: r0v63, types: [T, android.view.View] */
        /* JADX WARN: Type inference failed for: r0v65, types: [T, android.view.View] */
        /* JADX WARN: Type inference failed for: r0v71, types: [T, android.widget.CheckBox] */
        public final void q(Context context, UpdateEntity updateEntity, final te.e updateManager, final c cVar, boolean z11) {
            Boolean force;
            View viewFindViewById;
            TextView textView;
            View viewFindViewById2;
            TextView textView2;
            final re.a aVar;
            int i11;
            String updateButton;
            ViewTreeObserver viewTreeObserver;
            ViewTreeObserver viewTreeObserver2;
            Intrinsics.g(context, "context");
            Intrinsics.g(updateEntity, "updateEntity");
            Intrinsics.g(updateManager, "updateManager");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final UpdateContent updateContent = updateEntity.getUpdateContent();
            re.a aVarA = new re.a.b(context).d(R$layout.tupdate_layout_upgrade_dialog).b(false).c(!((updateContent == null || (force = updateContent.getForce()) == null) ? false : force.booleanValue())).f(new DialogInterface.OnShowListener() { // from class: com.cloud.tupdate.utils.e
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    p.a.r(updateManager, dialogInterface);
                }
            }).e(new DialogInterface.OnDismissListener() { // from class: com.cloud.tupdate.utils.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    p.a.s(updateManager, dialogInterface);
                }
            }).a();
            Window window = aVarA.getWindow();
            int i12 = C0350a.f32263a[updateManager.f().ordinal()];
            if (i12 == 1) {
                if (window != null) {
                    window.setGravity(48);
                    Unit unit = Unit.f68710a;
                }
                WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
                if (attributes != null) {
                    attributes.y = com.transsion.core.utils.e.a(updateManager.b());
                }
                if (window != null) {
                    window.setAttributes(attributes);
                }
            } else if (i12 != 2) {
                if (i12 == 3) {
                    if (window != null) {
                        window.setGravity(80);
                        Unit unit2 = Unit.f68710a;
                    }
                    WindowManager.LayoutParams attributes2 = window == null ? null : window.getAttributes();
                    if (attributes2 != null) {
                        attributes2.y = 32;
                    }
                    if (window != null) {
                        window.setAttributes(attributes2);
                    }
                }
            } else if (window != null) {
                window.setGravity(17);
                Unit unit3 = Unit.f68710a;
            }
            TextView textView3 = (TextView) aVarA.findViewById(R$id.updateTitleTv);
            TextView textView4 = (TextView) aVarA.findViewById(R$id.updateVersionTv);
            TextView textView5 = (TextView) aVarA.findViewById(R$id.updateContentTv);
            Button button = (Button) aVarA.findViewById(R$id.updateNegativeBtn);
            Button button2 = (Button) aVarA.findViewById(R$id.updatePositiveBtn);
            try {
                viewFindViewById = aVarA.findViewById(R$id.ll_ignore);
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
                viewFindViewById = null;
            }
            try {
                objectRef.element = (CheckBox) aVarA.findViewById(R$id.updateIgnoreCb);
            } catch (Exception e12) {
                LogUtil.f32213a.d(e12);
            }
            try {
                textView = (TextView) aVarA.findViewById(R$id.currentVersionTv);
            } catch (Exception e13) {
                LogUtil.f32213a.d(e13);
                textView = null;
            }
            try {
                objectRef2.element = aVarA.findViewById(R$id.contentScrollViewTop);
                objectRef3.element = aVarA.findViewById(R$id.contentScrollViewBottom);
            } catch (Exception e14) {
                LogUtil.f32213a.d(e14);
            }
            try {
                viewFindViewById2 = aVarA.findViewById(R$id.updateBottomDivider);
            } catch (Exception e15) {
                LogUtil.f32213a.d(e15);
                viewFindViewById2 = null;
            }
            try {
                objectRef4.element = (ScrollView) aVarA.findViewById(R$id.contentScrollView);
            } catch (Exception e16) {
                LogUtil.f32213a.d(e16);
            }
            try {
                textView2 = (TextView) aVarA.findViewById(R$id.ignoreUpdateTips);
            } catch (Exception e17) {
                com.cloud.tupdate.utils.a.j().a(Log.getStackTraceString(e17));
                textView2 = null;
            }
            ScrollView scrollView = (ScrollView) objectRef4.element;
            if (scrollView != null) {
                scrollView.setVerticalScrollBarEnabled(false);
            }
            ScrollView scrollView2 = (ScrollView) objectRef4.element;
            if (scrollView2 != null && (viewTreeObserver2 = scrollView2.getViewTreeObserver()) != null) {
                viewTreeObserver2.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.cloud.tupdate.utils.h
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        p.a.t(objectRef4, booleanRef, objectRef2, objectRef3);
                    }
                });
                Unit unit4 = Unit.f68710a;
            }
            ScrollView scrollView3 = (ScrollView) objectRef4.element;
            if (scrollView3 != null && (viewTreeObserver = scrollView3.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnPreDrawListener(new b(objectRef4, booleanRef, objectRef3));
                Unit unit5 = Unit.f68710a;
            }
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tupdate.utils.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.a.u(objectRef, view);
                    }
                });
                Unit unit6 = Unit.f68710a;
            }
            CheckBox checkBox = (CheckBox) objectRef.element;
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cloud.tupdate.utils.j
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z12) {
                        p.a.v(cVar, compoundButton, z12);
                    }
                });
                Unit unit7 = Unit.f68710a;
            }
            String updateTitle = updateContent == null ? null : updateContent.getUpdateTitle();
            if (updateTitle == null || kotlin.text.l.y(updateTitle)) {
                if (textView3 != null) {
                    textView3.setText(context.getString(R$string.text_update_dialog_title));
                }
            } else if (textView3 != null) {
                textView3.setText(updateContent == null ? null : updateContent.getUpdateTitle());
            }
            String updateVersion = updateContent == null ? null : updateContent.getUpdateVersion();
            if (updateVersion != null && updateVersion.length() != 0) {
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                if (textView4 != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                    String string = context.getString(R$string.text_update_version);
                    Intrinsics.f(string, "context.getString(R.string.text_update_version)");
                    Object[] objArr = new Object[1];
                    objArr[0] = updateContent == null ? null : updateContent.getUpdateVersion();
                    String str = String.format(string, Arrays.copyOf(objArr, 1));
                    Intrinsics.f(str, "format(format, *args)");
                    textView4.setText(str);
                }
            } else if (textView4 != null) {
                textView4.setVisibility(8);
            }
            if (z11) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
                    String string2 = context.getString(R$string.text_update_current_version);
                    Intrinsics.f(string2, "context.getString(R.stri…t_update_current_version)");
                    String str2 = String.format(string2, Arrays.copyOf(new Object[]{d.f32241a.b(context)}, 1));
                    Intrinsics.f(str2, "format(format, *args)");
                    textView.setText(str2);
                }
            } else if (textView != null) {
                textView.setVisibility(8);
            }
            String updateContent2 = updateContent == null ? null : updateContent.getUpdateContent();
            if (updateContent2 == null || kotlin.text.l.y(updateContent2)) {
                if (textView5 != null) {
                    textView5.setText(context.getString(R$string.text_update_content));
                }
            } else if (textView5 != 0) {
                textView5.setText(updateContent == null ? null : updateContent.getUpdateContent());
            }
            String ignoreUpdateTips = updateContent == null ? null : updateContent.getIgnoreUpdateTips();
            if (ignoreUpdateTips == null || kotlin.text.l.y(ignoreUpdateTips)) {
                if (textView2 != null) {
                    textView2.setText(context.getString(R$string.text_update_ignore));
                }
            } else if (textView2 != null) {
                textView2.setText(updateContent != null ? updateContent.getIgnoreUpdateTips() : null);
            }
            String string3 = (updateContent == null || (updateButton = updateContent.getUpdateButton()) == null || kotlin.text.l.y(updateButton)) ? context.getString(R$string.text_update_button) : updateContent.getUpdateButton();
            Intrinsics.f(string3, "if (updateContent == nul…eButton\n                }");
            if (button2 != 0) {
                button2.setText(string3);
            }
            if (button2 == null) {
                aVar = aVarA;
            } else {
                aVar = aVarA;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tupdate.utils.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.a.w(cVar, updateContent, updateManager, aVar, view);
                    }
                });
                Unit unit8 = Unit.f68710a;
            }
            String string4 = updateContent == null ? context.getString(R$string.text_update_cancel) : updateContent.getCancelUpdateButton();
            if (button != null) {
                button.setText(string4);
            }
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tupdate.utils.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        p.a.x(aVar, cVar, view);
                    }
                });
                Unit unit9 = Unit.f68710a;
            }
            if (updateContent == null || Intrinsics.b(updateContent.getForce(), Boolean.FALSE)) {
                View view = viewFindViewById2;
                if (!updateManager.c()) {
                    if (viewFindViewById != null) {
                        i11 = 0;
                        viewFindViewById.setVisibility(0);
                    }
                    if (button != null) {
                        button.setVisibility(i11);
                    }
                    if (view != null) {
                        view.setVisibility(i11);
                    }
                } else if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
                i11 = 0;
                if (button != null) {
                    button.setVisibility(i11);
                }
                if (view != null) {
                    view.setVisibility(i11);
                }
            } else {
                if (button != null) {
                    button.setVisibility(8);
                }
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
                if (viewFindViewById2 != 0) {
                    viewFindViewById2.setVisibility(8);
                }
            }
            try {
                com.cloud.tupdate.utils.a.j().d("update", "showCurrentVersion = " + z11 + ",  isHideIgnoreVersion = " + updateManager.c() + ", position = " + updateManager.f());
                updateManager.d();
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    aVar.show();
                }
                com.cloud.tupdate.utils.b.f32235a.k("upgrade", updateEntity);
            } catch (Exception e18) {
                LogUtil.f32213a.d(e18);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface c {
        void a();

        void b();

        void c(boolean z11);
    }
}
