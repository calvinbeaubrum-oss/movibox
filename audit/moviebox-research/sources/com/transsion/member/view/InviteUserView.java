package com.transsion.member.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$styleable;
import com.transsion.member.view.InviteUserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
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
public final class InviteUserView<T> extends RecyclerView {
    public static final int TYPE_ITEM_ACTIVE = 2;
    public static final int TYPE_ITEM_DONE = 1;
    public static final int TYPE_ITEM_LOADMORE = 4;
    public static final int TYPE_ITEM_UNACTIVE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53395d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<T> f53397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c<T> f53398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f53399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f53400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f53401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f53402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f53403m;
    public static final b Companion = new b(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteUserView<T> f53404a;

        public a(InviteUserView<T> inviteUserView) {
            this.f53404a = inviteUserView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            if (recyclerView.canScrollHorizontally(1) || !this.f53404a.f53401k || this.f53404a.f53402l) {
                return;
            }
            this.f53404a.f53402l = true;
            c cVar = this.f53404a.f53398h;
            if (cVar != null) {
                cVar.a();
            }
            RecyclerView.a0 a0VarFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.f53404a.f53397g.size());
            if (a0VarFindViewHolderForAdapterPosition != null && (a0VarFindViewHolderForAdapterPosition instanceof e) && ((e) a0VarFindViewHolderForAdapterPosition).e() == 4) {
                View itemView = a0VarFindViewHolderForAdapterPosition.itemView;
                Intrinsics.f(itemView, "itemView");
                so.c.k(itemView);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface c<T> {
        void a();

        int b(int i11, T t11);

        void c(InviteUserView<?>.e eVar, int i11, T t11);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class d extends RecyclerView.Adapter<InviteUserView<T>.e> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f53405i;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InviteUserView<T>.e f53407a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InviteUserView<T> f53408b;

            public a(InviteUserView<T>.e eVar, InviteUserView<T> inviteUserView) {
                this.f53407a = eVar;
                this.f53408b = inviteUserView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.g(animation, "animation");
                View view = this.f53407a.itemView;
                Intrinsics.f(view, "holder.itemView");
                so.c.h(view);
                this.f53408b.f53403m = false;
                this.f53407a.itemView.setAlpha(1.0f);
                this.f53407a.itemView.setScaleX(1.0f);
                this.f53407a.itemView.setScaleY(1.0f);
                InviteUserView<T> inviteUserView = this.f53408b;
                int width = this.f53407a.itemView.getWidth();
                InviteUserView<T> inviteUserView2 = this.f53408b;
                inviteUserView.smoothScrollBy(-(width + inviteUserView2.c(inviteUserView2.f53400j)), 0);
            }
        }

        public d(int i11) {
            this.f53405i = i11;
        }

        public static final void g(InviteUserView this$0, int i11, e holder, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(holder, "$holder");
            Function2 function2 = this$0.f53399i;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i11), Integer.valueOf(holder.e()));
            }
        }

        public final View e(int i11, ViewGroup viewGroup) {
            int i12;
            if (InviteUserView.this.f53401k && i11 == 4 && InviteUserView.this.f53395d == 0) {
                ProgressBar progressBar = new ProgressBar(InviteUserView.this.getContext(), null, R.attr.progressBarStyle);
                InviteUserView<T> inviteUserView = InviteUserView.this;
                progressBar.setIndeterminate(true);
                if (Build.VERSION.SDK_INT < 29) {
                    return progressBar;
                }
                progressBar.setMinWidth(inviteUserView.c(50.0f));
                progressBar.setMinHeight(inviteUserView.c(50.0f));
                return progressBar;
            }
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(InviteUserView.this.getContext());
            if (i11 == 1) {
                i12 = InviteUserView.this.f53392a;
            } else if (i11 != 2) {
                i12 = i11 != 3 ? InviteUserView.this.f53395d : InviteUserView.this.f53394c;
            } else {
                i12 = InviteUserView.this.f53393b;
            }
            View viewInflate = layoutInflaterFrom.inflate(i12, viewGroup, false);
            Intrinsics.f(viewInflate, "{\n                Layout…          )\n            }");
            return viewInflate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final InviteUserView<T>.e holder, final int i11) {
            Intrinsics.g(holder, "holder");
            View view = holder.itemView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.f53405i;
            view.setLayoutParams(layoutParams);
            if (holder.e() != 4) {
                c cVar = InviteUserView.this.f53398h;
                if (cVar != 0) {
                    cVar.c(holder, i11, InviteUserView.this.f53397g.get(i11));
                }
                View view2 = holder.itemView;
                final InviteUserView<T> inviteUserView = InviteUserView.this;
                view2.setOnClickListener(new View.OnClickListener() { // from class: ru.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        InviteUserView.d.g(inviteUserView, i11, holder, view3);
                    }
                });
                return;
            }
            if (InviteUserView.this.f53402l) {
                View view3 = holder.itemView;
                Intrinsics.f(view3, "holder.itemView");
                so.c.k(view3);
                holder.itemView.setAlpha(1.0f);
                holder.itemView.setScaleX(1.0f);
                holder.itemView.setScaleY(1.0f);
                return;
            }
            View view4 = holder.itemView;
            Intrinsics.f(view4, "holder.itemView");
            so.c.k(view4);
            if (InviteUserView.this.f53403m) {
                holder.itemView.animate().scaleX(0.1f).scaleY(0.1f).alpha(0.0f).setDuration(200L).setListener(new a(holder, InviteUserView.this)).start();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return InviteUserView.this.f53397g.size() + (InviteUserView.this.f53401k ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            if (i11 >= InviteUserView.this.f53397g.size()) {
                return 4;
            }
            c cVar = InviteUserView.this.f53398h;
            if (cVar != 0) {
                return cVar.b(i11, InviteUserView.this.f53397g.get(i11));
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public InviteUserView<T>.e onCreateViewHolder(ViewGroup parent, int i11) {
            Intrinsics.g(parent, "parent");
            return new e(InviteUserView.this, e(i11, parent), i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class e extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InviteUserView<T> f53410c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InviteUserView inviteUserView, View itemView, int i11) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            this.f53410c = inviteUserView;
            this.f53409b = i11;
        }

        public final int e() {
            return this.f53409b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class f extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53411a;

        public f(int i11) {
            this.f53411a = i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                if (childAdapterPosition == 0) {
                    outRect.left = 0;
                    return;
                } else {
                    outRect.left = this.f53411a;
                    return;
                }
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (childAdapterPosition == (adapter != null ? adapter.getItemCount() : 0) - 1) {
                outRect.left = 0;
            } else {
                outRect.left = this.f53411a;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InviteUserView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InviteUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InviteUserView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f53396f = 5;
        this.f53397g = new ArrayList();
        this.f53400j = 8.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.InviteUserView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…styleable.InviteUserView)");
        this.f53400j = typedArrayObtainStyledAttributes.getFloat(R$styleable.InviteUserView_iuv_inviteViewHorizontalSpace, 8.0f);
        this.f53392a = typedArrayObtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_doneItemLayout, R.layout.select_dialog_item);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_unActiveItemLayout, R.layout.select_dialog_item);
        this.f53394c = resourceId;
        this.f53393b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_activeItemLayout, resourceId);
        this.f53395d = typedArrayObtainStyledAttributes.getResourceId(R$styleable.InviteUserView_iuv_loadMoreItemLayout, 0);
        this.f53396f = typedArrayObtainStyledAttributes.getInt(R$styleable.InviteUserView_iuv_length, 5);
        this.f53401k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.InviteUserView_iuv_loadMoreEnable, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        addOnScrollListener(new a(this));
    }

    public /* synthetic */ InviteUserView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void b() {
        View childAt;
        RecyclerView.m layoutManager = getLayoutManager();
        int measuredHeight = 0;
        if (layoutManager != null && (childAt = layoutManager.getChildAt(0)) != null) {
            measuredHeight = childAt.getMeasuredHeight();
        }
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = paddingTop;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int c(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void d(InviteUserView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.setLayoutManager(new LinearLayoutManager(this$0.getContext(), 0, false));
        int measuredWidth = this$0.getMeasuredWidth();
        int iC = this$0.c(this$0.f53400j);
        int i11 = this$0.f53396f;
        this$0.setAdapter(new d((measuredWidth - (iC * (i11 - 1))) / i11));
        this$0.addItemDecoration(new f(this$0.c(this$0.f53400j)));
        this$0.b();
    }

    public final List<T> getData() {
        return this.f53397g;
    }

    public final boolean isLoadingMoreState() {
        return this.f53402l;
    }

    public final void notifyAllItemInviteUserStateChange() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void notifyItemInviteUserStateChange(int i11) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i11);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        post(new Runnable() { // from class: ru.c
            @Override // java.lang.Runnable
            public final void run() {
                InviteUserView.d(this.f75729a);
            }
        });
    }

    public final void onLoadMoreCompleted(List<? extends T> newList) {
        Intrinsics.g(newList, "newList");
        this.f53402l = false;
        int size = this.f53397g.size();
        this.f53397g.addAll(newList);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeInserted(size, this.f53397g.size());
        }
        this.f53403m = true;
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.notifyItemChanged(this.f53397g.size() + 1);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<? extends T> list) {
        Intrinsics.g(list, "list");
        this.f53397g = CollectionsKt___CollectionsKt.M0(list);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void setDataViewBinder(c<T> binder) {
        Intrinsics.g(binder, "binder");
        this.f53398h = binder;
    }

    public final void setItemClicker(Function2<? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f53399i = listener;
    }

    public final void setLoadMoreEnable(boolean z11) {
        this.f53401k = z11;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
