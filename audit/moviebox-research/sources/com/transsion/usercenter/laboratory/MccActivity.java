package com.transsion.usercenter.laboratory;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.db.mcc.LocalMcc;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MccActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f59361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xy.f f59362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f59363c = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null && childAdapterPosition == 0) {
                outRect.top = com.blankj.utilcode.util.f0.a(8.0f);
            }
            outRect.bottom = com.blankj.utilcode.util.f0.a(16.0f);
        }
    }

    private final void V() {
        AppCompatEditText appCompatEditText;
        Button button;
        xy.f fVar = this.f59362b;
        if (fVar != null && (button = fVar.f80798c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MccActivity.W(this.f59414a, view);
                }
            });
        }
        xy.f fVar2 = this.f59362b;
        if (fVar2 == null || (appCompatEditText = fVar2.f80799d) == null) {
            return;
        }
        appCompatEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.transsion.usercenter.laboratory.x0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                return MccActivity.X(this.f59416a, textView, i11, keyEvent);
            }
        });
    }

    public static final void W(MccActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        zp.b.f82110a.e("重置自定义数据");
        this$0.f59363c = -1;
        this$0.c0(null);
        z0 z0Var = this$0.f59361a;
        if (z0Var != null) {
            z0Var.w0(null);
        }
        this$0.Z();
    }

    public static final boolean X(MccActivity this$0, TextView textView, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 3) {
            return true;
        }
        this$0.a0(String.valueOf(textView != null ? textView.getText() : null));
        Object systemService = this$0.getSystemService("input_method");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView != null ? textView.getWindowToken() : null, 0);
        return true;
    }

    public static final void Y(MccActivity this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.b0(adapter, i11);
    }

    private final void Z() {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new MccActivity$loadData$1(this, null), 3, null);
    }

    private final void initView() {
        RecyclerView recyclerView;
        xy.f fVar = this.f59362b;
        if (fVar == null || (recyclerView = fVar.f80801g) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        z0 z0Var = new z0();
        z0Var.B0(new f9.d() { // from class: com.transsion.usercenter.laboratory.y0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                MccActivity.Y(this.f59418a, baseQuickAdapter, view, i11);
            }
        });
        this.f59361a = z0Var;
        recyclerView.setAdapter(z0Var);
        recyclerView.addItemDecoration(new a());
    }

    public final void a0(String str) {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new MccActivity$locationMcc$1(str, this, null), 3, null);
    }

    public final void b0(BaseQuickAdapter<?, ?> baseQuickAdapter, int i11) {
        List<?> listD;
        List<?> listD2;
        Object obj = (baseQuickAdapter == null || (listD2 = baseQuickAdapter.D()) == null) ? null : listD2.get(i11);
        a1 a1Var = obj instanceof a1 ? (a1) obj : null;
        if (a1Var != null) {
            a1Var.c(true);
        }
        z0 z0Var = this.f59361a;
        if (z0Var != null) {
            z0Var.notifyItemChanged(i11);
        }
        d0(a1Var != null ? a1Var.a() : null);
        c0(a1Var);
        if (this.f59363c >= 0) {
            Object obj2 = (baseQuickAdapter == null || (listD = baseQuickAdapter.D()) == null) ? null : listD.get(this.f59363c);
            a1 a1Var2 = obj2 instanceof a1 ? (a1) obj2 : null;
            if (a1Var2 != null) {
                a1Var2.c(false);
            }
            z0 z0Var2 = this.f59361a;
            if (z0Var2 != null) {
                z0Var2.notifyItemChanged(this.f59363c);
            }
        }
        this.f59363c = i11;
    }

    public final void c0(a1 a1Var) {
        LocalMcc localMccA;
        String countryCode;
        String country;
        LocalMcc localMccA2;
        String iso;
        LocalMcc localMccA3;
        String mcc;
        LocalMcc localMccA4;
        ip.a.C0714a c0714a = ip.a.f67589a;
        MMKV mmkvC = c0714a.c();
        String str = "";
        if (mmkvC != null) {
            if (a1Var == null || (localMccA4 = a1Var.a()) == null || (mcc = localMccA4.getMcc()) == null) {
                mcc = "";
            }
            mmkvC.putString("sp_code", mcc);
        }
        MMKV mmkvC2 = c0714a.c();
        if (mmkvC2 != null) {
            if (a1Var == null || (localMccA3 = a1Var.a()) == null || (iso = localMccA3.getIso()) == null) {
                iso = "";
            }
            mmkvC2.putString("custom_local_iso", iso);
        }
        MMKV mmkvC3 = c0714a.c();
        if (mmkvC3 != null) {
            if (a1Var == null || (localMccA2 = a1Var.a()) == null || (country = localMccA2.getCountry()) == null) {
                country = "";
            }
            mmkvC3.putString("custom_local_country", country);
        }
        MMKV mmkvC4 = c0714a.c();
        if (mmkvC4 != null) {
            if (a1Var != null && (localMccA = a1Var.a()) != null && (countryCode = localMccA.getCountryCode()) != null) {
                str = countryCode;
            }
            mmkvC4.putString("custom_country_code", str);
        }
    }

    public final void d0(LocalMcc localMcc) {
        String str = "Country : + " + (localMcc != null ? localMcc.getCountry() : null) + " -- Mcc : " + (localMcc != null ? localMcc.getMcc() : null) + " -- Iso : " + (localMcc != null ? localMcc.getIso() : null) + " -- CountryCode : " + (localMcc != null ? localMcc.getCountryCode() : null);
        xy.f fVar = this.f59362b;
        Button button = fVar != null ? fVar.f80797b : null;
        if (button == null) {
            return;
        }
        button.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xy.f fVarC = xy.f.c(getLayoutInflater());
        this.f59362b = fVarC;
        setContentView(fVarC != null ? fVarC.getRoot() : null);
        initView();
        V();
        Z();
    }
}
