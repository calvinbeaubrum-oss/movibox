package com.transsion.baseui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public class BaseLoadMoreView extends g9.a implements View.OnAttachStateChangeListener, Parcelable {
    private LoadMoreStatus loadMoreStatus;
    public static final a CREATOR = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<g9.a> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g9.a createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new BaseLoadMoreView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g9.a[] newArray(int i11) {
            return new g9.a[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51479a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f51479a = iArr;
        }
    }

    public BaseLoadMoreView() {
        this.loadMoreStatus = LoadMoreStatus.Complete;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLoadMoreView(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
    }

    @Override // g9.a
    public void convert(BaseViewHolder holder, int i11, LoadMoreStatus loadMoreStatus) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(loadMoreStatus, "loadMoreStatus");
        this.loadMoreStatus = loadMoreStatus;
        super.convert(holder, i11, loadMoreStatus);
        if (b.f51479a[loadMoreStatus.ordinal()] == 1) {
            c.k(getLoadingView(holder));
        } else {
            c.g(getLoadingView(holder));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // g9.a
    public View getLoadComplete(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        View viewFindViewById = holder.itemView.findViewById(R$id.tv_complete);
        Intrinsics.f(viewFindViewById, "holder.itemView.findViewById(R.id.tv_complete)");
        return viewFindViewById;
    }

    @Override // g9.a
    public View getLoadEndView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        View viewFindViewById = holder.itemView.findViewById(R$id.tv_no_more);
        Intrinsics.f(viewFindViewById, "holder.itemView.findViewById(R.id.tv_no_more)");
        return viewFindViewById;
    }

    @Override // g9.a
    public View getLoadFailView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        View viewFindViewById = holder.itemView.findViewById(R$id.tv_err);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewFindViewById;
        appCompatTextView.setText(f.f49475a.e() ? appCompatTextView.getContext().getString(R$string.base_load_err) : appCompatTextView.getContext().getString(com.tn.lib.widget.R$string.no_network_tips));
        Intrinsics.f(viewFindViewById, "holder.itemView.findView…)\n            }\n        }");
        return viewFindViewById;
    }

    @Override // g9.a
    public View getLoadingView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        View viewFindViewById = holder.itemView.findViewById(R$id.load_view);
        Intrinsics.f(viewFindViewById, "holder.itemView.findViewById(R.id.load_view)");
        return viewFindViewById;
    }

    @Override // g9.a
    public View getRootView(ViewGroup parent) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.base_item_load_more, parent, false);
        view.addOnAttachStateChangeListener(this);
        Intrinsics.f(view, "view");
        return view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View p11) {
        ProgressBar progressBar;
        Intrinsics.g(p11, "p0");
        if (this.loadMoreStatus != LoadMoreStatus.Loading || (progressBar = (ProgressBar) p11.findViewById(R$id.load_view)) == null) {
            return;
        }
        c.k(progressBar);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View p11) {
        Intrinsics.g(p11, "p0");
        ProgressBar progressBar = (ProgressBar) p11.findViewById(R$id.load_view);
        if (progressBar != null) {
            c.g(progressBar);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
    }
}
