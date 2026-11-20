package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.moviedetailapi.bean.PlayListDeepLink;
import com.transsion.moviedetailapi.bean.PlayListItemBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper;
import com.transsion.postdetail.shorttv.ShortTvListActivity;
import com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter;
import com.transsion.postdetail.shorttv.n;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tv.g0;

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
@SourceDebugExtension
public final class ShortTVDiscoverHeaderView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayListItemBean f55474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f55477d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShortTVHeaderViewAdapter f55478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zr.b f55479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f55480h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements zr.a {
        public a() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<Subject> listD;
            List<Subject> listD2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVDiscoverHeaderView.this.f55478f;
            if (((shortTVHeaderViewAdapter == null || (listD2 = shortTVHeaderViewAdapter.D()) == null) ? 0 : listD2.size()) <= i11) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVDiscoverHeaderView.this.f55478f;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (listD = shortTVHeaderViewAdapter2.D()) == null) ? null : listD.get(i11);
            if (subject != null) {
                ShortTVDiscoverHeaderView.this.f55480h.a("minitv_explore", subject, i11, j11, ShortTVDiscoverHeaderView.this.getItemOptType());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.l {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                if (childAdapterPosition == 0) {
                    if (ShortTVDiscoverHeaderView.this.f55475b) {
                        outRect.right = ShortTVDiscoverHeaderView.this.f55476c * 2;
                        return;
                    } else {
                        outRect.left = ShortTVDiscoverHeaderView.this.f55476c * 2;
                        return;
                    }
                }
                if (childAdapterPosition == adapter.getItemCount() - 1) {
                    outRect.right = ShortTVDiscoverHeaderView.this.f55476c;
                    outRect.left = ShortTVDiscoverHeaderView.this.f55476c;
                } else if (ShortTVDiscoverHeaderView.this.f55475b) {
                    outRect.right = ShortTVDiscoverHeaderView.this.f55476c;
                } else {
                    outRect.left = ShortTVDiscoverHeaderView.this.f55476c;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context) {
        this(playListBean, context, null);
        Intrinsics.g(playListBean, "playListBean");
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context, AttributeSet attributeSet) {
        this(playListBean, context, attributeSet, 0);
        Intrinsics.g(playListBean, "playListBean");
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(playListBean, "playListBean");
        Intrinsics.g(context, "context");
        this.f55474a = playListBean;
        this.f55475b = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.f55476c = f0.a(8.0f);
        this.f55480h = new n();
        View.inflate(context, R$layout.layout_short_tv_discover_header, this);
        g0 g0VarA = g0.a(this);
        Intrinsics.f(g0VarA, "bind(this)");
        this.f55477d = g0VarA;
        setOrientation(1);
        c();
        f();
    }

    public static final void d(ShortTVDiscoverHeaderView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.g(aVar, "Click view all", false, 2, null);
        PlayListDeepLink playListDeepLinkA = PlayListDeepLink.Companion.a(this$0.f55474a.getDeepLink());
        if (playListDeepLinkA != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/home/playlist").withString("label", playListDeepLinkA.getLabel()).withString("category", playListDeepLinkA.getCategory()).withString("recType", playListDeepLinkA.getRecType()).withString("topIds", null).navigation();
            return;
        }
        uo.b.a.k(aVar, "Invalid deeplink for " + this$0.f55474a.getTitle() + ", " + this$0.f55474a.getDeepLink(), false, 2, null);
    }

    public static final void e(ShortTVDiscoverHeaderView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.f55480h.b("minitv_explore", subject, i11, this$0.getItemOptType());
            this$0.g(subject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.b(this.f55474a.getId(), "10000000000") ? "new_release" : "playlist";
    }

    public final void c() {
        this.f55479g = new zr.b(0.6f, new a(), false, 4, null);
        this.f55477d.f77749f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDiscoverHeaderView.d(this.f55505a, view);
            }
        });
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(this.f55479g);
        shortTVHeaderViewAdapter.B0(new f9.d() { // from class: com.transsion.postdetail.shorttv.widget.d
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverHeaderView.e(this.f55506a, baseQuickAdapter, view, i11);
            }
        });
        this.f55478f = shortTVHeaderViewAdapter;
        RecyclerView recyclerView = this.f55477d.f77746b;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new b());
        recyclerView.setAdapter(this.f55478f);
        zr.b bVar = this.f55479g;
        Intrinsics.d(bVar);
        recyclerView.addOnScrollListener(bVar);
    }

    public final void clearExposureCache() {
        zr.b bVar = this.f55479g;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void f() {
        if (this.f55474a.isLastOne()) {
            TnTextView tnTextView = this.f55477d.f77748d;
            Intrinsics.f(tnTextView, "viewBinding.tvTitleTrending");
            tnTextView.setVisibility(0);
        }
        this.f55477d.f77747c.setText(this.f55474a.getTitle());
        updateList(this.f55474a.getSubjects());
    }

    public final void g(Subject subject) {
        Context context = getContext();
        if (context != null) {
            String itemOptType = getItemOptType();
            if (Intrinsics.b(itemOptType, "new_release") || Intrinsics.b(itemOptType, "playlist")) {
                DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, "minitv_explore", (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            } else {
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, null, 0L, false, 28, null);
            }
        }
    }

    public final PlayListItemBean getPlayListBean() {
        return this.f55474a;
    }

    public final void updateList(List<? extends Subject> list) {
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = this.f55478f;
        if (shortTVHeaderViewAdapter != null) {
            shortTVHeaderViewAdapter.w0(list2);
        }
        ShortTVDiscoverPreloadHelper.f55032n.a().J(list);
    }
}
