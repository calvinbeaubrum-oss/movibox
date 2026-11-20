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
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import sw.o;

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
public final class CommunityRoomsAdapter extends BaseQuickAdapter<RoomItem, RecommendRoomsItemVH> {
    public final int H;
    public RoomsViewType I;
    public boolean J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RecommendRoomsItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f57118b;

        /* JADX WARN: Illegal instructions before constructor call */
        public RecommendRoomsItemVH(o viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f57118b = viewBinding;
        }

        public final o e() {
            return this.f57118b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57119a;

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
            f57119a = iArr;
        }
    }

    public CommunityRoomsAdapter() {
        super(R$layout.item_recommend_rooms, null, 2, null);
        this.H = f0.a(64.0f);
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
        marginLayoutParams.width = this.J ? -1 : gs.a.a(64);
        holder.e().getRoot().setLayoutParams(marginLayoutParams);
        if (item.getBuiltIn()) {
            j.d(l0.a(w0.b()), null, null, new CommunityRoomsAdapter$convert$1(item, holder, null), 3, null);
        } else {
            String avatar = item.getAvatar();
            if (avatar != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                ShapeableImageView shapeableImageView = holder.e().f76569c;
                Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
                int i11 = this.H;
                companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
        }
        holder.e().f76573h.setText(item.getName());
        Long newPostCount = item.getNewPostCount();
        K0(holder, item, newPostCount != null ? newPostCount.longValue() : 0L);
        List<String> tags2 = item.getTags();
        if (tags2 != null && !tags2.isEmpty() && (tags = item.getTags()) != null && (str = (String) CollectionsKt___CollectionsKt.g0(tags)) != null) {
            holder.e().f76572g.setText(str);
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
        o oVarC = o.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(oVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        int i12 = a.f57119a[this.I.ordinal()];
        if (i12 == 1) {
            oVarC.f76573h.setTextSize(11.0f);
            oVarC.f76572g.setTextSize(13.0f);
            oVarC.f76571f.setTextSize(9.0f);
        } else if (i12 == 2 || i12 == 3) {
            oVarC.f76573h.setTextSize(12.0f);
            oVarC.f76572g.setTextSize(11.0f);
            oVarC.f76571f.setTextSize(11.0f);
            ViewGroup.LayoutParams layoutParams = oVarC.f76568b.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.width = -1;
            }
            oVarC.f76568b.setLayoutParams(marginLayoutParams);
        }
        return new RecommendRoomsItemVH(oVarC);
    }

    public final void J0(RecommendRoomsItemVH recommendRoomsItemVH, boolean z11) {
        recommendRoomsItemVH.e().f76574i.setStatus(z11 ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
    }

    public final void K0(RecommendRoomsItemVH recommendRoomsItemVH, RoomItem roomItem, long j11) {
        String strA;
        if (this.I != RoomsViewType.TYPE_ROOM_HOME) {
            Long newPostCount = roomItem.getNewPostCount();
            if ((newPostCount != null ? newPostCount.longValue() : 0L) > 0) {
                recommendRoomsItemVH.e().f76571f.setText(Utils.a().getString(R$string.x_new, j11 > 99 ? "99+" : String.valueOf(j11)));
                recommendRoomsItemVH.e().f76571f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
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
        recommendRoomsItemVH.e().f76571f.setText(strA);
        recommendRoomsItemVH.e().f76571f.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_room_home_member, 0, 0, 0);
    }

    public final void L0(RoomsViewType type) {
        Intrinsics.g(type, "type");
        this.I = type;
    }

    public final void M0(boolean z11) {
        this.J = z11;
    }
}
