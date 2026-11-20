package com.transsion.subroom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.mb.config.download.UserPreferOption;
import com.transsion.startup.StartupManager;
import com.transsion.subroom.R$drawable;
import com.transsion.subroom.R$id;
import com.transsion.subroom.R$string;
import f9.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import so.c;
import tx.e;
import zp.b;

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
@Deprecated
@Metadata
@SourceDebugExtension
public final class UserPreferFragment extends BaseFragment<e> implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sx.a f58055b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f58058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f58059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f58060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f58061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ProgressBar f58062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f58063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f58064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ProgressBar f58065m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58054a = "UserPrefer-tag";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<UserPreferOption> f58056c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f58057d = new Function1<Boolean, Unit>() { // from class: com.transsion.subroom.fragment.UserPreferFragment$mCallback$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f68710a;
        }

        public final void invoke(boolean z11) {
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DiffUtil.e<UserPreferOption> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(UserPreferOption oldItem, UserPreferOption newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getId(), newItem.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(UserPreferOption oldItem, UserPreferOption newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getId(), newItem.getId());
        }
    }

    public static final void l0(UserPreferFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.mb.config.download.UserPreferOption");
        UserPreferOption userPreferOption = (UserPreferOption) item;
        boolean zIsSelected = view.isSelected();
        if (zIsSelected) {
            this$0.f58056c.remove(userPreferOption);
            view.setSelected(!zIsSelected);
        } else if (this$0.f58056c.size() >= 5) {
            b.f82110a.d(R$string.choose_up_to_5);
        } else {
            this$0.f58056c.add(userPreferOption);
            view.setSelected(!zIsSelected);
        }
        TextView textView = this$0.f58064l;
        if (textView == null) {
            return;
        }
        textView.setSelected(this$0.f58056c.isEmpty());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public e getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        e eVarC = e.c(inflater);
        Intrinsics.f(eVarC, "inflate(inflater)");
        return eVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        this.f58058f = (ViewGroup) view;
        if (this.f58059g == null) {
            this.f58060h = true;
            return;
        }
        uo.b.a.f(uo.b.f78622a, "userPrefer", "userprefer, xml inflate before viewCreated", false, 4, null);
        ViewGroup viewGroup = this.f58058f;
        if (viewGroup != null) {
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
        k0(this.f58058f);
    }

    public final void j0(View view) {
    }

    public final void k0(ViewGroup viewGroup) {
        this.f58061i = viewGroup != null ? (TextView) viewGroup.findViewById(R$id.tv_skip) : null;
        this.f58062j = viewGroup != null ? (ProgressBar) viewGroup.findViewById(R$id.pb_skip) : null;
        this.f58063k = viewGroup != null ? (RecyclerView) viewGroup.findViewById(R$id.recycler_view) : null;
        this.f58064l = viewGroup != null ? (TextView) viewGroup.findViewById(R$id.tv_submit) : null;
        this.f58065m = viewGroup != null ? (ProgressBar) viewGroup.findViewById(R$id.load_view) : null;
        TextView textView = this.f58061i;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.f58064l;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        TextView textView3 = this.f58064l;
        if (textView3 != null) {
            textView3.setSelected(true);
        }
        sx.a aVar = new sx.a(new ArrayList());
        aVar.B0(new d() { // from class: com.transsion.subroom.fragment.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UserPreferFragment.l0(this.f58066a, baseQuickAdapter, view, i11);
            }
        });
        aVar.o0(new a());
        this.f58055b = aVar;
        RecyclerView recyclerView = this.f58063k;
        if (recyclerView != null) {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
            flexboxLayoutManager.P(0);
            flexboxLayoutManager.Q(1);
            flexboxLayoutManager.R(0);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(recyclerView.getContext());
            dVar.setOrientation(3);
            dVar.setDrawable(z2.a.getDrawable(Utils.a(), R$drawable.space_user_perfer_decoration));
            recyclerView.addItemDecoration(dVar);
            recyclerView.setAdapter(this.f58055b);
        }
        j0(viewGroup);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    public final void m0() {
        TextView textView = this.f58064l;
        if (textView != null) {
            textView.setClickable(false);
        }
        TextView textView2 = this.f58064l;
        if (textView2 != null) {
            textView2.setText("");
        }
        ProgressBar progressBar = this.f58065m;
        if (progressBar != null) {
            c.k(progressBar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f58056c.iterator();
        while (it.hasNext()) {
            String id2 = ((UserPreferOption) it.next()).getId();
            if (id2 != null) {
                arrayList.add(id2);
            }
        }
        StartupManager.f57960d.a().U(arrayList, new Function1<Boolean, Unit>() { // from class: com.transsion.subroom.fragment.UserPreferFragment$submit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                uo.b.a.f(uo.b.f78622a, this.this$0.f58054a, "submit success result = " + z11, false, 4, null);
            }
        });
        this.f58057d.invoke(Boolean.FALSE);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public h newLogViewConfig() {
        return new h("UserPrefer", false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.tv_skip;
        if (numValueOf != null && numValueOf.intValue() == i11) {
            this.f58057d.invoke(Boolean.TRUE);
            ProgressBar progressBar = this.f58062j;
            if (progressBar != null) {
                c.k(progressBar);
            }
            TextView textView = this.f58061i;
            if (textView != null) {
                c.h(textView);
                return;
            }
            return;
        }
        int i12 = R$id.tv_submit;
        if (numValueOf != null && numValueOf.intValue() == i12) {
            if (this.f58056c.isEmpty()) {
                b.f82110a.d(R$string.choose_at_least_one);
            } else if (f.f49475a.e()) {
                m0();
            } else {
                b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
            }
        }
    }
}
