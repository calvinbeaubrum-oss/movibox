package com.cloud.tmc.miniapp.ui;

import OooO0o0.oo000o;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$dimen;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.ui.ImageSelectActivity;
import com.cloud.tmc.miniapp.ui.adapter.ImageSelectAdapter;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.p;
import com.cloud.tmc.miniapp.widget.s;
import com.cloud.tmc.miniutils.util.j0;
import id.i;
import j.a0;
import j.z;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.l;
import ua.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class ImageSelectActivity extends BaseActivity implements i, Runnable, BaseAdapter.d, BaseAdapter.b {
    public static final a OooOOOo = new a();
    public static int OooOOo0 = 1;

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final ArrayList<String> f31699OooO;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final ArrayList<Integer> f31704OooOO0;
    public final ArrayList<String> OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<String>> f31705OooOO0o;
    public oo000o OooOOO;
    public final ImageSelectAdapter OooOOO0;
    public final ArrayList<String> OooOOOO;
    public final Lazy OooO00o = LazyKt__LazyJVMKt.b(new OooO0O0());
    public final Lazy OooO0O0 = LazyKt__LazyJVMKt.b(new OooOOOO());
    public final Lazy OooO0OO = LazyKt__LazyJVMKt.b(new OooO0OO());

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31700OooO0Oo = LazyKt__LazyJVMKt.b(new OooOOO0());

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final Lazy f31702OooO0o0 = LazyKt__LazyJVMKt.b(new OooOO0O());

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final Lazy f31701OooO0o = LazyKt__LazyJVMKt.b(new OooO());
    public final Lazy OooO0oO = LazyKt__LazyJVMKt.b(new OooOOO());

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public int f31703OooO0oo = 1;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<LinearLayoutCompat> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public LinearLayoutCompat invoke() {
            return (LinearLayoutCompat) ImageSelectActivity.this.findViewById(R$id.ll_album_select);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<FrameLayout> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImageSelectActivity.this.findViewById(R$id.fl_title_back);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) ImageSelectActivity.this.findViewById(R$id.iv_image_select);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<RecyclerView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public RecyclerView invoke() {
            return (RecyclerView) ImageSelectActivity.this.findViewById(R$id.rv_image_select_list);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<TextView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImageSelectActivity.this.findViewById(R$id.tv_image_select);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<StatusLayout> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public StatusLayout invoke() {
            return (StatusLayout) ImageSelectActivity.this.findViewById(R$id.sl_image_select_status);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImageSelectActivity.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements n {
        public b() {
        }

        @Override // ua.n
        public void a() {
            n.a.b(this);
        }

        @Override // ua.n
        public void b(boolean z11) {
        }

        @Override // ua.n
        public void c(ArrayList<String> data) {
            Intrinsics.g(data, "data");
        }

        @Override // ua.n
        public void d(ArrayList<String> data, ArrayList<Integer> arrayList, boolean z11) {
            Intrinsics.g(data, "data");
            if (z11) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("imageList", data);
                ImageSelectActivity.this.setResult(-1, intent);
                ImageSelectActivity.this.finish();
                return;
            }
            ImageSelectActivity.this.f31699OooO.clear();
            ImageSelectActivity.this.f31699OooO.addAll(data);
            if (arrayList != null) {
                ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                imageSelectActivity.f31704OooOO0.clear();
                imageSelectActivity.f31704OooOO0.addAll(arrayList);
            }
            ImageSelectActivity.this.OooO00o();
            ImageSelectActivity.this.OooOOO0.notifyDataSetChanged();
        }

        @Override // ua.n
        public void onCancel() {
            n.a.a(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements a0 {
        public c() {
        }

        @Override // j.a0
        public void a(OooO0o0.OooO0OO oooO0OO, int i11, z bean) {
            Intrinsics.g(bean, "bean");
            TextView textView = (TextView) ImageSelectActivity.this.OooO0O0.getValue();
            if (textView != null) {
                textView.setText(bean.f67796b);
            }
            RecyclerView recyclerViewOooO0o0 = ImageSelectActivity.this.OooO0o0();
            if (recyclerViewOooO0o0 != null) {
                recyclerViewOooO0o0.scrollToPosition(0);
            }
            if (i11 == 0) {
                ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                imageSelectActivity.OooOOO0.x(imageSelectActivity.OooOO0O);
            } else {
                ImageSelectActivity imageSelectActivity2 = ImageSelectActivity.this;
                imageSelectActivity2.OooOOO0.x(imageSelectActivity2.f31705OooOO0o.get(bean.f67797c));
            }
            RecyclerView recyclerViewOooO0o1 = ImageSelectActivity.this.OooO0o0();
            if (recyclerViewOooO0o1 != null) {
                recyclerViewOooO0o1.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(ImageSelectActivity.this.getActivity(), R$anim.layout_from_right));
            }
            RecyclerView recyclerViewOooO0o2 = ImageSelectActivity.this.OooO0o0();
            if (recyclerViewOooO0o2 != null) {
                recyclerViewOooO0o2.scheduleLayoutAnimation();
            }
        }
    }

    public ImageSelectActivity() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f31699OooO = arrayList;
        this.f31704OooOO0 = new ArrayList<>();
        this.OooOO0O = new ArrayList<>();
        this.f31705OooOO0o = new ConcurrentHashMap<>();
        this.OooOOO0 = new ImageSelectAdapter(this, arrayList);
        this.OooOOOO = new ArrayList<>();
    }

    public static final void OooO00o(ImageSelectActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            this$0.run();
        } catch (Throwable unused) {
        }
    }

    public static final void OooO00o(ImageSelectActivity this$0, Ref.BooleanRef finishLoad) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(finishLoad, "$finishLoad");
        if (this$0.OooOO0O.isEmpty()) {
            finishLoad.element = true;
            this$0.OooO0oO();
        } else {
            this$0.OooOOO0.r(this$0.OooOOOO);
            this$0.OooOOOO.clear();
        }
    }

    public static final void OooO0O0(ImageSelectActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            this$0.OooOO0O.addAll(this$0.OooOOOO);
            this$0.OooOOO0.x(this$0.OooOO0O);
            this$0.OooOOOO.clear();
            this$0.OooO00o();
            RecyclerView recyclerViewOooO0o0 = this$0.OooO0o0();
            if (recyclerViewOooO0o0 != null) {
                recyclerViewOooO0o0.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this$0.getActivity(), R$anim.layout_fall_down));
            }
            RecyclerView recyclerViewOooO0o1 = this$0.OooO0o0();
            if (recyclerViewOooO0o1 != null) {
                recyclerViewOooO0o1.scheduleLayoutAnimation();
            }
            if (this$0.OooOO0O.isEmpty()) {
                i.a.t(this$0, R$drawable.mini_ic_photo_empty, R$string.status_empty_photo, null);
            } else {
                i.a.c(this$0);
            }
        } catch (Throwable unused) {
        }
    }

    public static final void OooO0OO(ImageSelectActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.OooOOO0.r(this$0.OooOOOO);
    }

    public final void OooO00o() {
        String string;
        if (this.f31699OooO.isEmpty()) {
            TextView textViewOooO0o = OooO0o();
            if (textViewOooO0o != null) {
                textViewOooO0o.setText(getString(R$string.mini_image_select_done));
            }
            TextView textViewOooO0o2 = OooO0o();
            if (textViewOooO0o2 != null) {
                textViewOooO0o2.setTextColor(z2.a.getColor(this, R$color.mini_color_505358));
                return;
            }
            return;
        }
        TextView textViewOooO0o3 = OooO0o();
        if (textViewOooO0o3 != null) {
            if (this.f31703OooO0oo == 1) {
                string = getString(R$string.mini_image_select_done);
            } else {
                try {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                    String string2 = getString(R$string.mini_image_select_mutiple_done);
                    Intrinsics.f(string2, "getString(R.string.mini_image_select_mutiple_done)");
                    string = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.f31699OooO.size()), String.valueOf(this.f31703OooO0oo)}, 2));
                    Intrinsics.f(string, "format(format, *args)");
                } catch (Throwable unused) {
                    string = "";
                }
            }
            textViewOooO0o3.setText(string);
        }
        TextView textViewOooO0o4 = OooO0o();
        if (textViewOooO0o4 != null) {
            textViewOooO0o4.setTextColor(z2.a.getColor(this, R$color.mini_color_white));
        }
    }

    public final void OooO00o(int i11) {
        int i12 = this.f31703OooO0oo;
        List urls = CollectionsKt___CollectionsKt.M0(this.OooOOO0.v());
        ArrayList<String> selectList = this.f31699OooO;
        ArrayList<Integer> positionList = this.f31704OooOO0;
        b bVar = new b();
        Intrinsics.g(this, "context");
        Intrinsics.g(urls, "urls");
        Intrinsics.g(selectList, "selectList");
        Intrinsics.g(positionList, "positionList");
        if (urls.isEmpty()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ImagePreviewActivity.class);
        if (urls.size() > 2000) {
            urls = f.e(urls.get(i11));
        }
        if (urls instanceof ArrayList) {
            intent.putExtra("imageList", (Serializable) urls);
        } else {
            intent.putExtra("imageList", new ArrayList(urls));
        }
        intent.putExtra("imageSelectList", selectList);
        intent.putExtra("imageIndex", i11);
        intent.putExtra("imageSelectPositionList", positionList);
        intent.putExtra("imageMaxSelect", i12);
        h.f31061a.a(intent, this);
        startActivityForResult(intent, new com.cloud.tmc.miniapp.ui.a(bVar));
    }

    public final FrameLayout OooO0Oo() {
        return (FrameLayout) this.OooO00o.getValue();
    }

    public final TextView OooO0o() {
        return (TextView) this.OooO0oO.getValue();
    }

    public final RecyclerView OooO0o0() {
        return (RecyclerView) this.f31702OooO0o0.getValue();
    }

    public final void OooO0oO() {
        try {
            post(new Runnable() { // from class: qd.a
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSelectActivity.OooO0O0(this.f74494a);
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R$layout.activity_image_select;
    }

    @Override // id.i
    public StatusLayout getStatusLayout() {
        return (StatusLayout) this.f31700OooO0Oo.getValue();
    }

    @Override // id.i
    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        TextView textViewOooO0o;
        this.f31703OooO0oo = getInt("maxSelect", this.f31703OooO0oo);
        this.OooOOO0.C(OooOOo0);
        if (this.f31703OooO0oo == 1 && (textViewOooO0o = OooO0o()) != null) {
            textViewOooO0o.setVisibility(4);
        }
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = e.b();
            if (scheduledThreadPoolExecutorB != null) {
                scheduledThreadPoolExecutorB.execute(new Runnable() { // from class: qd.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageSelectActivity.OooO00o(this.f74496a);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.h("ImageSelectActivity", th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        e0.c(this);
        FrameLayout frameLayoutOooO0Oo = OooO0Oo();
        if (frameLayoutOooO0Oo != null) {
            frameLayoutOooO0Oo.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.OooO0OO.getValue();
        if (appCompatImageView != null) {
            appCompatImageView.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        setOnClickListener(OooO0Oo(), (LinearLayoutCompat) this.f31701OooO0o.getValue(), OooO0o());
        this.OooOOO0.q(this);
        this.OooOOO0.p(R$id.fl_image_select_check, this);
        RecyclerView recyclerViewOooO0o0 = OooO0o0();
        if (recyclerViewOooO0o0 != null) {
            recyclerViewOooO0o0.setAdapter(this.OooOOO0);
            recyclerViewOooO0o0.addItemDecoration(new p((int) getResources().getDimension(R$dimen.mini_dp_3)));
        }
    }

    public boolean isLoadStatusLoadingOrError() {
        return i.a.a(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1, new Intent());
        finish();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.b
    public void onChildClick(RecyclerView recyclerView, View view, int i11) {
        if (u.a()) {
            return;
        }
        if (OooOOo0 == 1) {
            OooO00o(i11);
            return;
        }
        if (view == null || view.getId() != R$id.fl_image_select_check) {
            return;
        }
        String item = this.OooOOO0.getItem(i11);
        if (!new File(item).isFile()) {
            this.OooOOO0.w(i11);
            String string = getResources().getString(R$string.image_select_error);
            Intrinsics.f(string, "resources.getString(R.string.image_select_error)");
            s.b(string);
            return;
        }
        int iIndexOf = this.f31699OooO.indexOf(item);
        int i12 = 0;
        if (iIndexOf >= 0) {
            this.f31704OooOO0.remove(Integer.valueOf(i11));
            this.f31699OooO.remove(item);
            OooO00o();
            this.OooOOO0.notifyItemChanged(i11);
            for (Object obj : this.f31704OooOO0) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    g.u();
                }
                int iIntValue = ((Number) obj).intValue();
                if (i12 >= iIndexOf) {
                    this.OooOOO0.notifyItemChanged(iIntValue);
                }
                i12 = i13;
            }
            return;
        }
        if (this.f31699OooO.size() < this.f31703OooO0oo) {
            if (this.f31699OooO.size() < this.f31703OooO0oo) {
                this.f31699OooO.add(item);
                this.f31704OooOO0.add(Integer.valueOf(i11));
                OooO00o();
            }
            this.OooOOO0.notifyItemChanged(i11);
            return;
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string2 = getResources().getString(R$string.image_select_max_hint);
            Intrinsics.f(string2, "resources.getString(R.st…ng.image_select_max_hint)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.f31703OooO0oo)}, 1));
            Intrinsics.f(str, "format(format, *args)");
            s.a(str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String string;
        Intrinsics.g(view, "view");
        super.onClick(view);
        if (Intrinsics.b(view, OooO0o())) {
            ArrayList<String> arrayList = this.f31699OooO;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            setResult(-1, new Intent().putStringArrayListExtra("imageList", this.f31699OooO));
            finish();
            return;
        }
        if (Intrinsics.b(view, OooO0Oo())) {
            setResult(-1, new Intent());
            finish();
            return;
        }
        if (!Intrinsics.b(view, (LinearLayoutCompat) this.f31701OooO0o.getValue()) || this.OooOO0O.isEmpty()) {
            return;
        }
        ArrayList data = new ArrayList(this.f31705OooOO0o.size() + 1);
        Set<String> setKeySet = this.f31705OooOO0o.keySet();
        Intrinsics.f(setKeySet, "allAlbum.keys");
        int size = 0;
        for (String str2 : setKeySet) {
            List<String> list = this.f31705OooOO0o.get(str2);
            if (list != null && !list.isEmpty()) {
                size += list.size();
                String str3 = list.get(0);
                try {
                    if (l.v(str2, "pictures", true)) {
                        string = getString(R$string.image_select_album_pictures);
                    } else if (l.v(str2, "screenshot", true)) {
                        string = getString(R$string.image_select_album_screenshot);
                    } else {
                        string = l.v(str2, "camera", true) ? getString(R$string.image_select_album_camera) : str2;
                    }
                    Intrinsics.f(string, "{\n            when {\n   …}\n            }\n        }");
                    str = string;
                } catch (Throwable unused) {
                    str = str2;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String string2 = getString(R$string.image_select_total);
                Intrinsics.f(string2, "getString(R.string.image_select_total)");
                String str4 = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(list.size())}, 1));
                Intrinsics.f(str4, "format(format, *args)");
                data.add(new z(str3, str, str2, str4, this.OooOOO0.v() == list));
            }
        }
        String str5 = this.OooOO0O.get(0);
        Intrinsics.f(str5, "allImage[0]");
        String str6 = str5;
        String string3 = getString(R$string.image_select_all);
        Intrinsics.f(string3, "getString(R.string.image_select_all)");
        String string4 = getString(R$string.image_select_all);
        Intrinsics.f(string4, "getString(R.string.image_select_all)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
        String string5 = getString(R$string.image_select_total);
        Intrinsics.f(string5, "getString(R.string.image_select_total)");
        String str7 = String.format(string5, Arrays.copyOf(new Object[]{String.valueOf(size)}, 1));
        Intrinsics.f(str7, "format(format, *args)");
        data.add(0, new z(str6, string3, string4, str7, this.OooOOO0.v() == this.OooOO0O));
        if (this.OooOOO == null) {
            oo000o oo000oVar = new oo000o(this);
            oo000oVar.f163t = new c();
            this.OooOOO = oo000oVar;
        }
        oo000o oo000oVar2 = this.OooOOO;
        if (oo000oVar2 != null) {
            Intrinsics.g(data, "data");
            oo000oVar2.f165v.x(data);
            int size2 = data.size();
            for (int i11 = 0; i11 < size2; i11++) {
                if (((z) data.get(i11)).f67799e) {
                    RecyclerView recyclerView = (RecyclerView) oo000oVar2.f164u.getValue();
                    if (recyclerView == null) {
                        break;
                    }
                    recyclerView.scrollToPosition(i11);
                    break;
                }
            }
            oo000oVar2.q();
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.d
    public void onItemClick(RecyclerView recyclerView, View view, int i11) {
        if (u.a()) {
            return;
        }
        OooO00o(i11);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        Iterator<String> it = this.f31699OooO.iterator();
        Intrinsics.f(it, "selectImage.iterator()");
        while (it.hasNext()) {
            String next = it.next();
            File file = new File(next);
            if (!file.isFile()) {
                it.remove();
                this.OooOO0O.remove(next);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    List<String> list = this.f31705OooOO0o.get(parentFile.getName());
                    if (list != null) {
                        list.remove(next);
                    }
                    this.OooOOO0.notifyDataSetChanged();
                    OooO00o();
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        File parentFile;
        try {
            this.f31705OooOO0o.clear();
            this.OooOO0O.clear();
            Uri contentUri = MediaStore.Files.getContentUri("external");
            Intrinsics.f(contentUri, "getContentUri(\"external\")");
            ContentResolver contentResolver = getContentResolver();
            Intrinsics.f(contentResolver, "contentResolver");
            int i11 = 0;
            Cursor cursorQuery = contentResolver.query(contentUri, new String[]{"_id", "_data", "_display_name", "date_modified", "mime_type", "width", "height", "_size"}, "(media_type=?) AND _size>0", new String[]{"1"}, "date_modified DESC");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("_data");
                int columnIndex2 = cursorQuery.getColumnIndex("mime_type");
                int columnIndex3 = cursorQuery.getColumnIndex("_size");
                do {
                    if (cursorQuery.getLong(columnIndex3) >= 1024) {
                        String string = cursorQuery.getString(columnIndex2);
                        Intrinsics.f(string, "cursor.getString(mimeTypeIndex)");
                        String string2 = cursorQuery.getString(columnIndex);
                        Intrinsics.f(string2, "cursor.getString(pathIndex)");
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                            File file = new File(string2);
                            if (file.exists() && file.isFile() && (parentFile = file.getParentFile()) != null) {
                                String name = parentFile.getName();
                                Intrinsics.f(name, "parentFile.name");
                                List<String> arrayList = this.f31705OooOO0o.get(name);
                                if (arrayList == null) {
                                    arrayList = new ArrayList<>();
                                    this.f31705OooOO0o.put(name, arrayList);
                                }
                                arrayList.add(string2);
                                this.OooOOOO.add(string2);
                                i11++;
                                if (i11 == 50) {
                                    booleanRef.element = true;
                                    OooO0oO();
                                } else if (i11 % 100 == 0) {
                                    post(new Runnable() { // from class: qd.c
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            ImageSelectActivity.OooO0OO(this.f74498a);
                                        }
                                    });
                                    this.OooOOOO.clear();
                                }
                            }
                        }
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            if (!this.OooOOOO.isEmpty()) {
                post(new Runnable() { // from class: qd.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageSelectActivity.OooO00o(this.f74500a, booleanRef);
                    }
                });
            }
            if (booleanRef.element) {
                return;
            }
            OooO0oO();
        } catch (Throwable unused) {
        }
    }

    public void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel loadingAnimationModel) {
        i.a.b(this, loadingAnimationModel);
    }

    public boolean showComplete() {
        return i.a.c(this);
    }

    public void showCustomErrorLayout(String str, String str2, String str3, StatusLayout.b bVar, String str4, StatusLayout.a aVar) {
        i.a.d(this, str, str2, str3, bVar, str4, aVar);
    }

    @Override // id.i
    public void showError(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.e(this, bVar, i11, str, str2, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.g(this, i11, i12, i13, bVar, z11, z12, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.h(this, i11, i12, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.i(this, drawable, charSequence, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.j(this, drawable, charSequence, charSequence2, bVar, str, z11, z12, aVar);
    }

    public void showLoading() {
        i.a.o(this);
    }

    public void showLoadingLogo(String str, String str2) {
        i.a.p(this, str, str2);
    }

    public void showMainLayoutAlpha(float f11) {
        i.a.q(this, f11);
    }

    @Override // id.i
    public void showNoNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.r(this, bVar, i11, str, str2, aVar);
    }

    public void showPhotoEmpty(int i11, @StringRes int i12, StatusLayout.b bVar) {
        i.a.t(this, i11, i12, bVar);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }

    @Override // id.i
    public void showUnstableNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.u(this, bVar, i11, str, str2, aVar);
    }

    public void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        i.a.w(this, str, function3);
    }

    public void statusLayoutOnResume() {
        i.a.x(this);
    }

    public void updateStepAnimation(LoadStepAction loadStepAction) {
        i.a.y(this, loadStepAction);
    }
}
