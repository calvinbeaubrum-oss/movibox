package com.cloud.tmc.miniapp.ui;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.integration.utils.v;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter;
import com.cloud.tmc.miniapp.widget.s;
import com.cloud.tmc.miniutils.util.c;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import p010OooOooo.o000000;
import p010OooOooo.o0O0O00;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class ImagePreviewActivity extends BaseActivity implements BaseAdapter.d, BaseAdapter.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f31681r = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f31693m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f31682a = LazyKt__LazyJVMKt.b(new OooO());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f31683b = LazyKt__LazyJVMKt.b(new OooOo());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f31684c = LazyKt__LazyJVMKt.b(new OooOo00());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f31685d = LazyKt__LazyJVMKt.b(new OooOOOO());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f31686f = LazyKt__LazyJVMKt.b(new Oooo000());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f31687g = LazyKt__LazyJVMKt.b(new OooOO0());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f31688h = LazyKt__LazyJVMKt.b(new OooO0o());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f31689i = LazyKt__LazyJVMKt.b(new OooO0OO());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f31690j = LazyKt__LazyJVMKt.b(new OooO0O0());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f31691k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f31692l = LazyKt__LazyJVMKt.b(OooOOO.OooO00o);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f31694n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<String> f31695o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<Integer> f31696p = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewPager2.OnPageChangeCallback f31697q = new b();

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<FrameLayout> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R$id.fl_title_back);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<ImagePreviewAdapter> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImagePreviewAdapter invoke() {
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            return new ImagePreviewAdapter(imagePreviewActivity, imagePreviewActivity.f31695o);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<FrameLayout> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R$id.fl_operate_download);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<FrameLayout> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImagePreviewActivity.this.findViewById(R$id.fl_operate_share);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<LinearLayout> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public LinearLayout invoke() {
            return (LinearLayout) ImagePreviewActivity.this.findViewById(R$id.linear_operate_panel);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.ImagePreviewActivity$loadFile$1", f = "ImagePreviewActivity.kt", l = {}, m = "invokeSuspend")
    public static final class OooOO0O extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ Function1<File, Unit> OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OooOO0O(String str, Function1<? super File, Unit> function1, Continuation<? super OooOO0O> continuation) {
            super(2, continuation);
            this.OooO0O0 = str;
            this.OooO0OO = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImagePreviewActivity.this.new OooOO0O(this.OooO0O0, this.OooO0OO, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ImagePreviewActivity.this.new OooOO0O(this.OooO0O0, this.OooO0OO, continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            ResultKt.b(obj);
            try {
                ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
                a aVar = ImagePreviewActivity.f31681r;
                File fileLoadImgFile = imagePreviewActivity.R().A().loadImgFile(ImagePreviewActivity.this, this.OooO0O0);
                if (fileLoadImgFile == null) {
                    this.OooO0OO.invoke(null);
                    return Unit.f68710a;
                }
                String strP0 = StringsKt__StringsKt.P0(StringsKt__StringsKt.Z0(this.OooO0O0).toString(), "/", "");
                if (StringsKt__StringsKt.O0(strP0, '.', "").length() == 0) {
                    strP0 = "IMG_" + System.currentTimeMillis() + ".png";
                }
                File file = new File(new File(ImagePreviewActivity.this.getCacheDir(), "downloadFile"), strP0);
                if (file.exists()) {
                    xb.b.b(file);
                }
                boolean zH = xb.b.h(fileLoadImgFile, file, false, false, 6, null);
                Function1<File, Unit> function1 = this.OooO0OO;
                if (!zH) {
                    file = null;
                }
                function1.invoke(file);
                return Unit.f68710a;
            } catch (Throwable th2) {
                TmcLogger.h("ImagePreviewActivity", th2);
                this.OooO0OO.invoke(null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<d0.a> {
        public static final OooOOO OooO00o = new OooOOO();

        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public d0.a invoke() {
            return new d0.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R$id.tv_image_select);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo extends Lambda implements Function0<TextView> {
        public OooOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<TextView> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImagePreviewActivity.this.findViewById(R$id.tv_preview_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Oooo000 extends Lambda implements Function0<ViewPager2> {
        public Oooo000() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewPager2 invoke() {
            return (ViewPager2) ImagePreviewActivity.this.findViewById(R$id.vp_preview_image);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
            imagePreviewActivity.f31693m = i11;
            TextView textViewW = imagePreviewActivity.W();
            if (textViewW != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i11 + 1);
                sb2.append('/');
                sb2.append(ImagePreviewActivity.this.R().u());
                textViewW.setText(sb2.toString());
            }
            TextView textViewO = ImagePreviewActivity.this.O();
            if (textViewO == null) {
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i11 + 1);
            sb3.append('/');
            sb3.append(ImagePreviewActivity.this.R().u());
            textViewO.setText(sb3.toString());
        }
    }

    public final TextView O() {
        return (TextView) this.f31684c.getValue();
    }

    public final void OooO00o() {
        String string;
        if (this.f31695o.isEmpty()) {
            TextView textViewV = V();
            if (textViewV != null) {
                textViewV.setText(getString(R$string.mini_image_select_done));
            }
            TextView textViewV2 = V();
            if (textViewV2 != null) {
                textViewV2.setTextColor(z2.a.getColor(this, R$color.mini_color_505358));
                return;
            }
            return;
        }
        TextView textViewV3 = V();
        if (textViewV3 != null) {
            if (this.f31694n == 1) {
                string = getString(R$string.mini_image_select_done);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String string2 = getString(R$string.mini_image_select_mutiple_done);
                Intrinsics.f(string2, "getString(R.string.mini_image_select_mutiple_done)");
                string = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.f31695o.size()), String.valueOf(this.f31694n)}, 2));
                Intrinsics.f(string, "format(format, *args)");
            }
            textViewV3.setText(string);
        }
        TextView textViewV4 = V();
        if (textViewV4 != null) {
            textViewV4.setTextColor(z2.a.getColor(this, R$color.mini_color_white));
        }
    }

    public final void Q(String str, Function1<? super File, Unit> function1) {
        j.d(l0.a(w0.b()), null, null, new OooOO0O(str, function1, null), 3, null);
    }

    public final ImagePreviewAdapter R() {
        return (ImagePreviewAdapter) this.f31690j.getValue();
    }

    public final FrameLayout S() {
        return (FrameLayout) this.f31682a.getValue();
    }

    public final String T() {
        String str;
        try {
            List<String> listV = R().v();
            if (this.f31693m >= listV.size() || (str = listV.get(this.f31693m)) == null) {
                return null;
            }
            if (!StringsKt__StringsKt.Q(str, ".miniapp.transsion.com", false, 2, null)) {
                return str;
            }
            String strA = v.f31133a.a(str);
            if (strA == null) {
                strA = "";
            }
            File file = R().z().get(str, strA);
            if (file != null) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th2) {
            TmcLogger.h("ImagePreviewActivity", th2);
        }
        return null;
    }

    public final d0.a U() {
        return (d0.a) this.f31692l.getValue();
    }

    public final TextView V() {
        return (TextView) this.f31685d.getValue();
    }

    public final TextView W() {
        return (TextView) this.f31683b.getValue();
    }

    public final ViewPager2 X() {
        return (ViewPager2) this.f31686f.getValue();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R$layout.activity_image_preview;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        int i11;
        ViewPager2 viewPager2X;
        ArrayList<String> stringArrayList = getStringArrayList("imageList");
        ArrayList<String> stringArrayList2 = getStringArrayList("imageSelectList");
        ArrayList<Integer> integerArrayList = getIntegerArrayList("imageSelectPositionList");
        boolean z11 = getBoolean("showMenu", false);
        if (stringArrayList2 != null) {
            this.f31695o.addAll(stringArrayList2);
        }
        if (integerArrayList != null) {
            this.f31696p.addAll(integerArrayList);
        }
        this.f31694n = getInt("imageMaxSelect");
        w.d(this);
        int i12 = this.f31694n;
        if (i12 == 0) {
            c.i(this, false);
            c.m(this, false);
            TextView textViewV = V();
            if (textViewV != null) {
                textViewV.setVisibility(4);
            }
            FrameLayout frameLayoutS = S();
            if (frameLayoutS != null) {
                frameLayoutS.setVisibility(4);
            }
            TextView textViewO = O();
            if (textViewO != null) {
                textViewO.setVisibility(0);
            }
            i11 = 3;
        } else if (i12 != 1) {
            e0.c(this);
            i11 = 2;
        } else {
            e0.c(this);
            i11 = 1;
        }
        this.f31691k = i11;
        R().D(this.f31691k);
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            finish();
            return;
        }
        R().x(stringArrayList);
        R().q(this);
        R().p(R$id.fl_image_select_check, this);
        ViewPager2 viewPager2X2 = X();
        if (viewPager2X2 != null) {
            viewPager2X2.setAdapter(R());
        }
        if (stringArrayList.size() != 1) {
            if (this.f31691k == 3) {
                TextView textViewW = W();
                if (textViewW != null) {
                    textViewW.setVisibility(4);
                }
                TextView textViewO2 = O();
                if (textViewO2 != null) {
                    textViewO2.setVisibility(0);
                }
            } else {
                TextView textViewO3 = O();
                if (textViewO3 != null) {
                    textViewO3.setVisibility(4);
                }
                TextView textViewW2 = W();
                if (textViewW2 != null) {
                    textViewW2.setVisibility(0);
                }
            }
            ViewPager2 viewPager2X3 = X();
            if (viewPager2X3 != null) {
                viewPager2X3.registerOnPageChangeCallback(this.f31697q);
            }
            int i13 = getInt("imageIndex");
            this.f31693m = i13;
            if (i13 < stringArrayList.size() && (viewPager2X = X()) != null) {
                viewPager2X.setCurrentItem(this.f31693m, false);
            }
        }
        if (this.f31691k == 1) {
            TextView textViewV2 = V();
            if (textViewV2 != null) {
                textViewV2.setTextColor(z2.a.getColor(this, R$color.mini_color_white));
            }
        } else {
            OooO00o();
        }
        LinearLayout linearLayout = (LinearLayout) this.f31687g.getValue();
        if (linearLayout != null) {
            i.f(linearLayout, z11);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        ViewPager2 viewPager2X = X();
        if (viewPager2X != null) {
            viewPager2X.setOffscreenPageLimit(3);
        }
        FrameLayout frameLayoutS = S();
        if (frameLayoutS != null) {
            frameLayoutS.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        setOnClickListener(S(), V(), (FrameLayout) this.f31688h.getValue(), (FrameLayout) this.f31689i.getValue());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f31691k == 2) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("imageSelectList", this.f31695o);
            intent.putIntegerArrayListExtra("imageSelectPositionList", this.f31696p);
            intent.putExtra("imageBackPressed", true);
            setResult(-1, intent);
        }
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.b
    public void onChildClick(RecyclerView recyclerView, View view, int i11) {
        String item;
        if (this.f31691k == 1 || view == null || view.getId() != R$id.fl_image_select_check || (item = R().getItem(i11)) == null) {
            return;
        }
        if (!new File(item).isFile()) {
            R().w(i11);
            String string = getResources().getString(R$string.image_select_error);
            Intrinsics.f(string, "resources.getString(R.string.image_select_error)");
            s.b(string);
            return;
        }
        int iIndexOf = this.f31695o.indexOf(item);
        int i12 = 0;
        if (iIndexOf < 0) {
            if (this.f31695o.size() < this.f31694n) {
                if (this.f31695o.size() < this.f31694n) {
                    this.f31695o.add(item);
                    this.f31696p.add(Integer.valueOf(i11));
                    OooO00o();
                }
                R().notifyItemChanged(i11);
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string2 = getResources().getString(R$string.image_select_max_hint);
            Intrinsics.f(string2, "resources.getString(R.st…ng.image_select_max_hint)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.f31694n)}, 1));
            Intrinsics.f(str, "format(format, *args)");
            s.a(str);
            return;
        }
        this.f31696p.remove(Integer.valueOf(i11));
        this.f31695o.remove(item);
        OooO00o();
        R().notifyItemChanged(i11);
        for (Object obj : this.f31696p) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            Integer num = (Integer) obj;
            if (i12 >= iIndexOf && num != null) {
                num.intValue();
                R().notifyItemChanged(num.intValue());
            }
            i12 = i13;
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        if (u.a()) {
            return;
        }
        if (Intrinsics.b(view, S())) {
            onBackPressed();
            return;
        }
        if (Intrinsics.b(view, V())) {
            if (this.f31691k != 1) {
                if (this.f31695o.size() > 0) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("imageSelectList", this.f31695o);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            }
            if (this.f31693m < R().v().size()) {
                this.f31695o.add(R().v().get(this.f31693m));
                Intent intent2 = new Intent();
                intent2.putStringArrayListExtra("imageSelectList", this.f31695o);
                setResult(-1, intent2);
                finish();
                return;
            }
            return;
        }
        if (Intrinsics.b(view, (FrameLayout) this.f31688h.getValue())) {
            String strT = T();
            if (strT != null) {
                Q(strT, new o000000(this));
                return;
            } else {
                TmcLogger.c("ImagePreviewActivity", "doShareFile imagePath is null");
                n0.j.b(R$string.mini_image_select_shared_failed, 0, 0L, false, 14);
                return;
            }
        }
        if (Intrinsics.b(view, (FrameLayout) this.f31689i.getValue())) {
            String strT2 = T();
            if (strT2 != null) {
                Q(strT2, o0O0O00.OooO00o);
            } else {
                TmcLogger.c("ImagePreviewActivity", "doDownloadFile imagePath is null");
                n0.j.b(R$string.mini_image_select_save_failed, 0, 0L, false, 14);
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        U().f62852a.clear();
        ViewPager2 viewPager2X = X();
        if (viewPager2X != null) {
            viewPager2X.unregisterOnPageChangeCallback(this.f31697q);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.d
    public void onItemClick(RecyclerView recyclerView, View view, int i11) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        U().a();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }
}
