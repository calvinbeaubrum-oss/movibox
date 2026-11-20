package com.transsion.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.banner.adapter.c;
import com.transsion.banner.adapter.d;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.gslb.Utils;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class OpSubBannerNew extends FrameLayout {
    public static final a Companion = new a(null);
    public static final String OP_GROUPS = "GROUPS";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50920d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f50923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f50924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OperateItem f50927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<ImageView> f50928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Context f50929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f50930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f50931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppCompatTextView f50932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f50933r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f50934s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AppCompatImageView f50935t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f50936u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f50937v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m f50938w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f50939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f50940y;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            m mVar;
            View viewFindSnapView;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 0 || (mVar = OpSubBannerNew.this.f50938w) == null || (viewFindSnapView = mVar.findSnapView(recyclerView.getLayoutManager())) == null) {
                return;
            }
            OpSubBannerNew opSubBannerNew = OpSubBannerNew.this;
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int position = layoutManager.getPosition(viewFindSnapView);
                uo.b.a.f(uo.b.f78622a, "OpSubBanner2", "scroll position" + position, false, 4, null);
                if (opSubBannerNew.getLastPosition() != position) {
                    opSubBannerNew.i(position);
                }
                opSubBannerNew.setLastPosition(position);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpSubBannerNew(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpSubBannerNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpSubBannerNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f50917a = 5;
        this.f50923h = com.tn.lib.widget.R$drawable.libui_circle_red_4dp;
        this.f50924i = com.tn.lib.widget.R$drawable.libui_circle_grey_4dp;
        this.f50933r = true;
        this.f50929n = context;
        this.f50928m = new ArrayList();
        c(context, attributeSet);
        this.f50939x = -1;
        this.f50940y = new b();
    }

    public static final void d(OpSubBannerNew this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        OperateItem operateItem = this$0.f50927l;
        if (operateItem == null) {
            return;
        }
        String type = operateItem != null ? operateItem.getType() : null;
        if (type != null && Intrinsics.b(type, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
            this$0.k(this$0.f50927l);
        } else {
            if (type == null || !Intrinsics.b(type, OP_GROUPS)) {
                return;
            }
            com.alibaba.android.arouter.launcher.a.d().b("/room/hot_room").navigation();
        }
    }

    private final int getAllCount() {
        OperateItem operateItem = this.f50927l;
        if ((operateItem != null ? operateItem.getType() : null) != null) {
            OperateItem operateItem2 = this.f50927l;
            if (Intrinsics.b(operateItem2 != null ? operateItem2.getType() : null, OP_GROUPS)) {
                return getGroupsCount();
            }
        }
        return getSubjectsCount();
    }

    private final int getGroupsCount() {
        List<Group> groups;
        OperateItem operateItem = this.f50927l;
        return ((operateItem == null || (groups = operateItem.getGroups()) == null) ? 0 : groups.size()) / 3;
    }

    private final int getSubjectsCount() {
        List<AppointSubject> subjects;
        OperateItem operateItem = this.f50927l;
        return ((operateItem == null || (subjects = operateItem.getSubjects()) == null) ? 0 : subjects.size()) / 3;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.opt_banner);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.opt_banner)");
        this.f50918b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.opt_banner_indicator_width, this.f50922g);
        this.f50919c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.opt_banner_indicator_height, this.f50922g);
        this.f50920d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.opt_banner_indicator_selected_width, this.f50922g);
        this.f50921f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.opt_banner_indicator_selected_height, this.f50922g);
        this.f50917a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.opt_banner_indicator_margin, 5);
        this.f50923h = typedArrayObtainStyledAttributes.getResourceId(R$styleable.opt_banner_indicator_drawable_selected, com.tn.lib.widget.R$drawable.libui_circle_red_4dp);
        this.f50924i = typedArrayObtainStyledAttributes.getResourceId(R$styleable.opt_banner_indicator_drawable_unselected, com.tn.lib.widget.R$drawable.libui_circle_grey_4dp);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void c(Context context, AttributeSet attributeSet) {
        b(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.op_sub2_banner, (ViewGroup) this, true);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.recycler_view);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, 3, 0, false));
            m mVar = new m();
            mVar.attachToRecyclerView(recyclerView);
            this.f50938w = mVar;
        } else {
            recyclerView = null;
        }
        this.f50930o = recyclerView;
        this.f50931p = (LinearLayout) viewInflate.findViewById(R$id.circleIndicator);
        this.f50932q = (AppCompatTextView) viewInflate.findViewById(R$id.tv_ops_title);
        View viewFindViewById = viewInflate.findViewById(R$id.view_more);
        this.f50934s = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.banner.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpSubBannerNew.d(this.f50942a, view);
                }
            });
        }
        this.f50937v = viewInflate.findViewById(R$id.op_gradient);
        this.f50935t = (AppCompatImageView) viewInflate.findViewById(R$id.cover);
        this.f50936u = viewInflate.findViewById(R$id.bg_color);
        TnTextView tnTextView = (TnTextView) viewInflate.findViewById(R$id.tv_view_more);
        if (tnTextView != null) {
            tnTextView.setTextById(R$string.view_more_rooms);
        }
        m();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:32:0x0070  */
    public final boolean e(OperateItem operateItem, OperateItem operateItem2) {
        int size;
        int size2;
        if (operateItem == null || operateItem2 == null) {
            return true;
        }
        if ((operateItem.getType() != null && !Intrinsics.b(operateItem.getType(), operateItem2.getType())) || !Intrinsics.b(operateItem.getTitle(), operateItem2.getTitle())) {
            return true;
        }
        if (operateItem.getType() == null || !Intrinsics.b(operateItem.getType(), OP_GROUPS)) {
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                size = subjects.size();
            } else {
                size = 0;
            }
        } else {
            List<Group> groups = operateItem.getGroups();
            if (groups != null) {
                size = groups.size();
            } else {
                size = 0;
            }
        }
        if (operateItem2.getType() == null || !Intrinsics.b(operateItem2.getType(), OP_GROUPS)) {
            List<AppointSubject> subjects2 = operateItem2.getSubjects();
            if (subjects2 != null) {
                size2 = subjects2.size();
            } else {
                size2 = 0;
            }
        } else {
            List<Group> groups2 = operateItem2.getGroups();
            if (groups2 != null) {
                size2 = groups2.size();
            } else {
                size2 = 0;
            }
        }
        return size > 0 && size != size2;
    }

    public final void f() {
        Context context = this.f50929n;
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.banner.OpSubBannerNew$observeAddToDownload$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                Intrinsics.g(value, "value");
                try {
                    RecyclerView recyclerView = this.this$0.f50930o;
                    RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                    if (adapter instanceof d) {
                        Iterator<Subject> it = ((d) adapter).d().iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.b(it.next().getSubjectId(), value.getSubjectId())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (i11 >= 0) {
                            ((d) adapter).notifyItemChanged(i11);
                        }
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void g() {
        Context context = this.f50929n;
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>() { // from class: com.transsion.banner.OpSubBannerNew$observerGroupEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                Intrinsics.g(value, "value");
                try {
                    RecyclerView recyclerView = this.this$0.f50930o;
                    RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                    if (adapter instanceof c) {
                        Iterator<Group> it = ((c) adapter).d().iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.b(it.next().getGroupId(), value.getGroupId())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (i11 >= 0) {
                            ((c) adapter).d().get(i11).setHasJoin(Boolean.valueOf(value.getJoin()));
                            ((c) adapter).notifyItemChanged(i11);
                        }
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final int getLastPosition() {
        return this.f50939x;
    }

    public final void h() {
        Context context = this.f50929n;
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<PublishEvent, Unit> function1 = new Function1<PublishEvent, Unit>() { // from class: com.transsion.banner.OpSubBannerNew$observerPublishEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                invoke2(publishEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishEvent value) {
                Intrinsics.g(value, "value");
                try {
                    RecyclerView recyclerView = this.this$0.f50930o;
                    RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                    if (adapter instanceof c) {
                        Iterator<Group> it = ((c) adapter).d().iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.b(it.next().getGroupId(), value.getGroupId())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (i11 >= 0) {
                            Long postCount = ((c) adapter).d().get(i11).getPostCount();
                            if (postCount != null) {
                                postCount.longValue();
                            }
                            ((c) adapter).notifyItemChanged(i11);
                        }
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void i(int i11) {
        OperateItem operateItem = this.f50927l;
        if (operateItem != null) {
            int i12 = 0;
            if (!Intrinsics.b(operateItem.getType(), OP_GROUPS)) {
                List<AppointSubject> subjects = operateItem.getSubjects();
                if (subjects == null || subjects.size() <= i11 + 2) {
                    return;
                }
                while (i12 < 3) {
                    AppointSubject appointSubject = subjects.get(i12 + i11);
                    pr.a.f74040a.d((28672 & 1) != 0 ? null : operateItem.getPageName(), (28672 & 2) != 0 ? null : "opt", (28672 & 4) != 0 ? null : operateItem.getType(), (28672 & 8) != 0 ? null : appointSubject.getSubjectId(), (28672 & 16) != 0 ? null : null, (28672 & 32) != 0 ? null : null, (28672 & 64) != 0 ? null : appointSubject.getHasResource(), (28672 & 128) != 0 ? null : null, (28672 & 256) != 0 ? null : null, (28672 & 512) != 0 ? null : null, (28672 & 1024) != 0 ? 0L : 0L, (28672 & 2048) != 0 ? Boolean.FALSE : Boolean.FALSE, (28672 & 4096) != 0 ? null : null, (28672 & 8192) != 0 ? null : null, (28672 & 16384) != 0 ? null : null);
                    i12++;
                }
                return;
            }
            List<Group> groups = operateItem.getGroups();
            if (groups == null || groups.size() < i11 + 2) {
                return;
            }
            while (i12 < 3) {
                String strComponent2 = groups.get(i12 + i11).component2();
                pr.a aVar = pr.a.f74040a;
                OperateItem operateItem2 = this.f50927l;
                Intrinsics.d(operateItem2);
                String pageName = operateItem2.getPageName();
                String type = operateItem.getType();
                Boolean bool = Boolean.FALSE;
                aVar.d((28672 & 1) != 0 ? null : pageName, (28672 & 2) != 0 ? null : "opt", (28672 & 4) != 0 ? null : type, (28672 & 8) != 0 ? null : null, (28672 & 16) != 0 ? null : strComponent2, (28672 & 32) != 0 ? null : null, (28672 & 64) != 0 ? null : bool, (28672 & 128) != 0 ? null : null, (28672 & 256) != 0 ? null : null, (28672 & 512) != 0 ? null : null, (28672 & 1024) != 0 ? 0L : 0L, (28672 & 2048) != 0 ? Boolean.FALSE : bool, (28672 & 4096) != 0 ? null : null, (28672 & 8192) != 0 ? null : null, (28672 & 16384) != 0 ? null : null);
                i12++;
            }
        }
    }

    public final void j(OperateItem operateItem, or.a aVar) {
        String url;
        if (operateItem == null) {
            Log.e("OpSubBanner2", "The image data set is empty.");
            return;
        }
        int allCount = getAllCount();
        if (Intrinsics.b(operateItem.getType(), PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                int size = subjects.size() / 3;
                RecyclerView recyclerView = this.f50930o;
                if (recyclerView != null) {
                    d dVar = new d(subjects.subList(0, size * 3), operateItem.getPageName());
                    dVar.g(aVar);
                    recyclerView.setAdapter(dVar);
                }
            }
            if (allCount >= 1) {
                List<AppointSubject> subjects2 = operateItem.getSubjects();
                AppointSubject appointSubject = subjects2 != null ? subjects2.get(0) : null;
                Cover cover = appointSubject != null ? appointSubject.getCover() : null;
                if (cover != null && (url = cover.getUrl()) != null) {
                    l(url, o.f51321a.a() ? cover.getAverageHueDark() : cover.getAverageHueLight());
                }
            }
            f();
        } else {
            List<Group> groups = operateItem.getGroups();
            if (groups != null) {
                int size2 = groups.size() / 3;
                RecyclerView recyclerView2 = this.f50930o;
                if (recyclerView2 != null) {
                    c cVar = new c(groups.subList(0, size2 * 3), operateItem.getPageName());
                    cVar.g(aVar);
                    recyclerView2.setAdapter(cVar);
                }
            }
            if (allCount >= 1) {
                List<Group> groups2 = operateItem.getGroups();
                Group group = groups2 != null ? groups2.get(0) : null;
                String avatar = group != null ? group.getAvatar() : null;
                if (avatar != null) {
                    l(avatar, o.f51321a.a() ? group.getAvatarAverageHueDark() : group.getAvatarAverageHueLight());
                }
            }
            h();
            g();
        }
        AppCompatTextView appCompatTextView = this.f50932q;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(operateItem.getTitle());
    }

    public final void k(OperateItem operateItem) {
        Uri uriD;
        if (operateItem == null) {
            return;
        }
        String deepLink = operateItem.getDeepLink();
        if (TextUtils.isEmpty(deepLink) || (uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink))) == null) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().a(uriD).withString("ops", PostItemType.OP_SUBJECTS_MOVIE.getValue()).navigation();
    }

    public final void l(String str, String str2) {
        List listL;
        if (str2 == null) {
            return;
        }
        AppCompatImageView appCompatImageView = this.f50935t;
        if (appCompatImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = appCompatImageView.getContext();
            Intrinsics.f(context, "it.context");
            companion.r(context, appCompatImageView, str, (4088 & 8) != 0 ? companion.d() : companion.d(), (4088 & 16) != 0 ? companion.c() : companion.c(), (4088 & 32) != 0 ? true : true, (4088 & 64) != 0 ? true : true, (4088 & 128) != 0 ? true : true, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        if (!TextUtils.isEmpty(str2) || StringsKt__StringsKt.Q(str2, Utils.SEPARATOR, false, 2, null)) {
            View view = this.f50936u;
            Intrinsics.d(view);
            view.setBackgroundColor(Color.parseColor(str2));
            List<String> listSplit = new Regex(Utils.SEPARATOR).split(str2, 0);
            if (listSplit.isEmpty()) {
                listL = g.l();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    }
                }
                listL = g.l();
            }
            String[] strArr = (String[]) listL.toArray(new String[0]);
            n(new int[]{Color.parseColor("#33" + strArr[1]), Color.parseColor("#B2" + strArr[1]), Color.parseColor("#ff" + strArr[1])});
        }
    }

    public final void m() {
        Context context = this.f50929n;
        if (context != null) {
            n(new int[]{z2.a.getColor(context, R$color.bg_01_20), z2.a.getColor(context, R$color.bg_01_70), z2.a.getColor(context, R$color.bg_01)});
        }
    }

    public final void n(int[] iArr) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        View view = this.f50937v;
        if (view == null) {
            return;
        }
        view.setBackground(gradientDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView = this.f50930o;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f50940y);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView = this.f50930o;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f50940y);
        }
    }

    public final OpSubBannerNew setData(OperateItem operateItem) {
        if (e(this.f50927l, operateItem)) {
            this.f50927l = operateItem;
            this.f50925j = getAllCount();
            this.f50933r = true;
        } else {
            this.f50933r = false;
        }
        return this;
    }

    public final void setLastPosition(int i11) {
        this.f50939x = i11;
    }

    public final OpSubBannerNew start(or.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (!this.f50933r) {
            return this;
        }
        this.f50926k = 0;
        j(this.f50927l, aVar);
        return this;
    }
}
