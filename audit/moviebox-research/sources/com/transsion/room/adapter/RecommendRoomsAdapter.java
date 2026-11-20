package com.transsion.room.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import com.transsion.room.api.RoomsViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sw.p;

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
@SourceDebugExtension
public final class RecommendRoomsAdapter extends BaseQuickAdapter<RoomItem, RecommendRoomsItemVH> {
    public final int H;
    public RoomsViewType I;
    public boolean J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RecommendRoomsItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f57120b;

        /* JADX WARN: Illegal instructions before constructor call */
        public RecommendRoomsItemVH(p viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f57120b = viewBinding;
        }

        public final p e() {
            return this.f57120b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57121a;

        static {
            int[] iArr = new int[RoomsViewType.values().length];
            try {
                iArr[RoomsViewType.TYPE_ROOM_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomsViewType.TYPE_TRENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomsViewType.TYPE_SUBJECT_DETAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f57121a = iArr;
        }
    }

    public RecommendRoomsAdapter() {
        super(R$layout.item_recommend_rooms, null, 2, null);
        this.H = f0.a(30.0f);
        this.I = RoomsViewType.TYPE_ROOM_HOME;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(RecommendRoomsItemVH holder, RoomItem item) {
        List<String> tags;
        String str;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ViewGroup.LayoutParams layoutParams = holder.e().getRoot().getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = this.J ? -1 : gs.a.a(104);
        holder.e().getRoot().setLayoutParams(marginLayoutParams);
        String avatar = item.getAvatar();
        if (avatar != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            ShapeableImageView shapeableImageView = holder.e().f76578d;
            Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCoverBg");
            int i11 = this.H;
            companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : true, (4088 & 2048) != 0 ? 25 : 30);
            Context context2 = getContext();
            ShapeableImageView shapeableImageView2 = holder.e().f76577c;
            Intrinsics.f(shapeableImageView2, "holder.viewBinding.ivCover");
            int i12 = this.H;
            companion.r(context2, shapeableImageView2, avatar, (4088 & 8) != 0 ? companion.d() : i12, (4088 & 16) != 0 ? companion.c() : i12, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        holder.e().f76581h.setText(item.getName());
        Long newPostCount = item.getNewPostCount();
        K0(holder, item, newPostCount != null ? newPostCount.longValue() : 0L);
        List<String> tags2 = item.getTags();
        if (tags2 != null && !tags2.isEmpty() && (tags = item.getTags()) != null && (str = (String) CollectionsKt___CollectionsKt.g0(tags)) != null) {
            holder.e().f76580g.setText(str);
        }
        Boolean hasJoin = item.getHasJoin();
        J0(holder, hasJoin != null ? hasJoin.booleanValue() : false);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(RecommendRoomsItemVH holder, RoomItem item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            J0(holder, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            K0(holder, item, ((Number) obj).longValue());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public RecommendRoomsItemVH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        p pVarC = p.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(pVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        int i12 = a.f57121a[this.I.ordinal()];
        if (i12 == 1) {
            pVarC.f76581h.setTextSize(13.0f);
            pVarC.f76580g.setTextSize(13.0f);
            pVarC.f76579f.setTextSize(13.0f);
        } else if (i12 == 2 || i12 == 3) {
            pVarC.f76581h.setTextSize(12.0f);
            pVarC.f76580g.setTextSize(11.0f);
            pVarC.f76579f.setTextSize(11.0f);
            ViewGroup.LayoutParams layoutParams = pVarC.f76576b.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.width = -1;
            }
            pVarC.f76576b.setLayoutParams(marginLayoutParams);
        }
        BLView bLView = pVarC.f76583j;
        Intrinsics.f(bLView, "viewBinding.vStroke");
        bLView.setVisibility(this.I == RoomsViewType.TYPE_ROOM_HOME ? 0 : 8);
        return new RecommendRoomsItemVH(pVarC);
    }

    public final void J0(RecommendRoomsItemVH recommendRoomsItemVH, boolean z11) {
        recommendRoomsItemVH.e().f76582i.setStatus(z11 ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
    }

    public final void K0(RecommendRoomsItemVH recommendRoomsItemVH, RoomItem roomItem, long j11) {
        String strA;
        if (this.I != RoomsViewType.TYPE_ROOM_HOME) {
            Long newPostCount = roomItem.getNewPostCount();
            if ((newPostCount != null ? newPostCount.longValue() : 0L) > 0) {
                recommendRoomsItemVH.e().f76579f.setText(Utils.a().getString(R$string.x_new, j11 > 99 ? "99+" : String.valueOf(j11)));
                recommendRoomsItemVH.e().f76579f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
        }
        if (roomItem.getUserCount() != null) {
            Long userCount = roomItem.getUserCount();
            Intrinsics.d(userCount);
            strA = i.a(userCount.longValue());
        } else {
            strA = "0";
        }
        recommendRoomsItemVH.e().f76579f.setText(strA);
        recommendRoomsItemVH.e().f76579f.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_room_member, 0, 0, 0);
    }

    public final void L0(RoomsViewType type) {
        Intrinsics.g(type, "type");
        this.I = type;
    }

    public final void M0(boolean z11) {
        this.J = z11;
    }
}
