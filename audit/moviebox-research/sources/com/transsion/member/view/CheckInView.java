package com.transsion.member.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$styleable;
import com.transsion.member.view.CheckInView;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class CheckInView extends RecyclerView {
    public static final int TYPE_END_ACTIVE = 5;
    public static final int TYPE_END_DONE = 4;
    public static final int TYPE_END_UNACTIVE = 6;
    public static final int TYPE_ITEM_ACTIVE = 2;
    public static final int TYPE_ITEM_DONE = 1;
    public static final int TYPE_ITEM_UNACTIVE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53371d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f53374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f53375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f53377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f53378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f53379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f53380n;
    public static final c Companion = new c(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends RecyclerView.Adapter<b> {
        public a() {
        }

        public static final void f(CheckInView this$0, int i11, b holder, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(holder, "$holder");
            Function2 function2 = this$0.f53375i;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i11), Integer.valueOf(holder.e()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final b holder, final int i11) {
            Intrinsics.g(holder, "holder");
            d dVar = CheckInView.this.f53374h;
            if (dVar != null) {
                dVar.a(holder, i11);
            }
            View view = holder.itemView;
            final CheckInView checkInView = CheckInView.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: ru.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CheckInView.a.f(checkInView, i11, holder, view2);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int i11) {
            int i12;
            Intrinsics.g(parent, "parent");
            CheckInView checkInView = CheckInView.this;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(checkInView.getContext());
            switch (i11) {
                case 1:
                    i12 = CheckInView.this.f53369b;
                    break;
                case 2:
                    i12 = CheckInView.this.f53370c;
                    break;
                case 3:
                    i12 = CheckInView.this.f53368a;
                    break;
                case 4:
                    i12 = CheckInView.this.f53372f;
                    break;
                case 5:
                    i12 = CheckInView.this.f53373g;
                    break;
                case 6:
                    i12 = CheckInView.this.f53371d;
                    break;
                default:
                    i12 = CheckInView.this.f53368a;
                    break;
            }
            View viewInflate = layoutInflaterFrom.inflate(i12, parent, false);
            Intrinsics.f(viewInflate, "from(context).inflate(\n …, false\n                )");
            return new b(checkInView, viewInflate, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CheckInView.this.f53376j;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            d dVar = CheckInView.this.f53374h;
            if (dVar != null) {
                return dVar.b(i11);
            }
            return 3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CheckInView f53383c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CheckInView checkInView, View itemView, int i11) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            this.f53383c = checkInView;
            this.f53382b = i11;
        }

        public final int e() {
            return this.f53382b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface d {
        void a(b bVar, int i11);

        int b(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class e extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f53386c;

        public e(int i11, int i12, int i13) {
            this.f53384a = i11;
            this.f53385b = i12;
            this.f53386c = i13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i11 = this.f53384a;
            int i12 = childAdapterPosition % i11;
            int i13 = this.f53385b;
            outRect.left = (i12 * i13) / i11;
            outRect.right = i13 - (((i12 + 1) * i13) / i11);
            if (childAdapterPosition >= i11) {
                outRect.top = this.f53386c;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends GridLayoutManager.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f53389f;

        public f(GridLayoutManager gridLayoutManager) {
            this.f53389f = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            RecyclerView.m layoutManager = CheckInView.this.getLayoutManager();
            return i11 == (layoutManager != null ? layoutManager.getItemCount() : this.f53389f.getSpanCount()) - 1 ? 2 : 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckInView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckInView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f53377k = 4;
        this.f53378l = 2;
        this.f53379m = 12.0f;
        this.f53380n = 8.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CheckInView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.CheckInView)");
        this.f53376j = typedArrayObtainStyledAttributes.getInt(R$styleable.CheckInView_civ_length, 7);
        this.f53377k = typedArrayObtainStyledAttributes.getInt(R$styleable.CheckInView_civ_spanCount, 4);
        this.f53378l = typedArrayObtainStyledAttributes.getInt(R$styleable.CheckInView_civ_endSpanCount, 2);
        this.f53379m = typedArrayObtainStyledAttributes.getFloat(R$styleable.CheckInView_civ_verticalSpace, 12.0f);
        this.f53380n = typedArrayObtainStyledAttributes.getFloat(R$styleable.CheckInView_civ_horizontalSpace, 8.0f);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_unActiveItemLayout, R.layout.select_dialog_item);
        this.f53368a = resourceId;
        this.f53369b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_doneItemLayout, resourceId);
        this.f53370c = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_activeItemLayout, this.f53368a);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_unActiveEndLayout, R.layout.select_dialog_item);
        this.f53371d = resourceId2;
        this.f53372f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_doneEndLayout, resourceId2);
        this.f53373g = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CheckInView_civ_activeEndLayout, this.f53371d);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public /* synthetic */ CheckInView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void d(CheckInView this$0) {
        Intrinsics.g(this$0, "this$0");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this$0.getContext(), this$0.f53377k);
        gridLayoutManager.setSpanSizeLookup(this$0.new f(gridLayoutManager));
        this$0.setLayoutManager(gridLayoutManager);
        this$0.setAdapter(this$0.new a());
        this$0.addItemDecoration(this$0.new e(this$0.f53377k, this$0.c(8.0f), this$0.c(12.0f)));
        this$0.b();
    }

    public final void b() {
        View childAt;
        RecyclerView.m layoutManager = getLayoutManager();
        int measuredHeight = 0;
        if (layoutManager != null && (childAt = layoutManager.getChildAt(0)) != null) {
            measuredHeight = childAt.getMeasuredHeight();
        }
        int paddingTop = (measuredHeight * ((this.f53376j / this.f53377k) + 1)) + getPaddingTop() + getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = paddingTop;
        setLayoutParams(layoutParams);
    }

    public final int c(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void notifyAllChange() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void notifyItemCheckInStateChange(int i11) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i11);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        post(new Runnable() { // from class: ru.a
            @Override // java.lang.Runnable
            public final void run() {
                CheckInView.d(this.f75725a);
            }
        });
    }

    public final void setDataViewBinder(d binder) {
        Intrinsics.g(binder, "binder");
        this.f53374h = binder;
    }

    public final void setItemClicker(Function2<? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f53375i = listener;
    }
}
