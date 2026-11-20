package com.transsion.room.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import h9.f;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import so.c;
import sw.q;

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
public final class RoomListAdapter extends BaseQuickAdapter<RoomItem, RoomListItemVH> implements j {
    public final RoomListFrom H;
    public final boolean I;
    public final int J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RoomListItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f57125b;

        /* JADX WARN: Illegal instructions before constructor call */
        public RoomListItemVH(q viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f57125b = viewBinding;
        }

        public final q e() {
            return this.f57125b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57126a;

        static {
            int[] iArr = new int[RoomListFrom.values().length];
            try {
                iArr[RoomListFrom.MY_ROOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomListFrom.ROOM_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f57126a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomListAdapter(RoomListFrom roomListFrom, boolean z11) {
        super(R$layout.item_room_list, null, 2, null);
        Intrinsics.g(roomListFrom, "roomListFrom");
        this.H = roomListFrom;
        this.I = z11;
        this.J = f0.a(52.0f);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(RoomListItemVH holder, RoomItem item) {
        String strA;
        List<String> tags;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        String avatar = item.getAvatar();
        if (avatar != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            ShapeableImageView shapeableImageView = holder.e().f76587d;
            Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
            int i11 = this.J;
            companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        if (this.I) {
            holder.e().f76594l.setMaxLines(2);
            AppCompatTextView appCompatTextView = holder.e().f76590h;
            Intrinsics.f(appCompatTextView, "holder.viewBinding.tvMember");
            c.g(appCompatTextView);
            AppCompatTextView appCompatTextView2 = holder.e().f76593k;
            Intrinsics.f(appCompatTextView2, "holder.viewBinding.tvTag");
            c.g(appCompatTextView2);
            Group group = holder.e().f76586c;
            Intrinsics.f(group, "holder.viewBinding.groupNewPost");
            c.g(group);
            holder.e().f76594l.setText(item.getName());
            return;
        }
        Long newPostCount = item.getNewPostCount();
        L0(holder, newPostCount != null ? newPostCount.longValue() : 0L);
        holder.e().f76594l.setText(item.getName());
        if (item.getUserCount() != null) {
            Long userCount = item.getUserCount();
            Intrinsics.d(userCount);
            strA = i.a(userCount.longValue());
        } else {
            strA = "0";
        }
        AppCompatTextView appCompatTextView3 = holder.e().f76590h;
        Long userCount2 = item.getUserCount();
        appCompatTextView3.setText((userCount2 != null ? userCount2.longValue() : 0L) == 1 ? Utils.a().getString(R$string.one_members) : Utils.a().getString(R$string.x_members, strA));
        up.c.a aVarE = up.c.e();
        List<String> tags2 = item.getTags();
        if (tags2 == null || tags2.size() <= 3) {
            tags = item.getTags();
        } else {
            List<String> tags3 = item.getTags();
            tags = tags3 != null ? tags3.subList(0, 3) : null;
        }
        if (tags != null) {
            boolean z11 = true;
            for (String str : tags) {
                if (!z11) {
                    aVarE.e("丨").c(z2.a.getColor(Utils.a(), R$color.white_20));
                }
                aVarE.e(str).c(z2.a.getColor(Utils.a(), R$color.white_60));
                z11 = false;
            }
        }
        holder.e().f76593k.setText(aVarE.b());
        int i12 = a.f57126a[this.H.ordinal()];
        if (i12 == 1) {
            RoomJoinAnimationView roomJoinAnimationView = holder.e().f76595m;
            Intrinsics.f(roomJoinAnimationView, "holder.viewBinding.vJoin");
            c.g(roomJoinAnimationView);
            K0(holder, item);
            return;
        }
        if (i12 != 2) {
            return;
        }
        Group group2 = holder.e().f76586c;
        Intrinsics.f(group2, "holder.viewBinding.groupNewPost");
        c.g(group2);
        O0(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(RoomListItemVH holder, RoomItem item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object objR0 = CollectionsKt___CollectionsKt.r0(payloads);
        if (objR0 instanceof Boolean) {
            J0(holder, ((Boolean) objR0).booleanValue());
        } else if (objR0 instanceof Long) {
            L0(holder, ((Number) objR0).longValue());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public RoomListItemVH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        q qVarC = q.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(qVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new RoomListItemVH(qVarC);
    }

    public final void J0(RoomListItemVH roomListItemVH, boolean z11) {
        roomListItemVH.e().f76595m.setStatus(z11 ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
    }

    public final void K0(RoomListItemVH roomListItemVH, RoomItem roomItem) {
        List<PostSubjectItem> latestPosts = roomItem.getLatestPosts();
        PostSubjectItem postSubjectItem = latestPosts != null ? (PostSubjectItem) CollectionsKt___CollectionsKt.g0(latestPosts) : null;
        if (postSubjectItem == null) {
            Group group = roomListItemVH.e().f76586c;
            Intrinsics.f(group, "holder.viewBinding.groupNewPost");
            c.g(group);
            return;
        }
        Group group2 = roomListItemVH.e().f76586c;
        Intrinsics.f(group2, "holder.viewBinding.groupNewPost");
        c.k(group2);
        String content = postSubjectItem.getContent();
        String title = (content == null || content.length() == 0) ? postSubjectItem.getTitle() : postSubjectItem.getContent();
        AppCompatTextView appCompatTextView = roomListItemVH.e().f76592j;
        if (title == null || title.length() == 0) {
            title = Utils.a().getString(R$string.New_post);
        }
        appCompatTextView.setText(title);
        Media media = postSubjectItem.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.b(mediaType, MediaType.VIDEO.getValue())) {
            N0(roomListItemVH, postSubjectItem);
            return;
        }
        if (Intrinsics.b(mediaType, MediaType.IMAGE.getValue())) {
            M0(roomListItemVH, postSubjectItem);
            return;
        }
        FrameLayout root = roomListItemVH.e().f76589g.getRoot();
        Intrinsics.f(root, "holder.viewBinding.layoutNewPostVideo.root");
        c.g(root);
        FrameLayout root2 = roomListItemVH.e().f76588f.getRoot();
        Intrinsics.f(root2, "holder.viewBinding.layoutNewPostImage.root");
        c.g(root2);
    }

    public final void L0(RoomListItemVH roomListItemVH, long j11) {
        BLTextView bLTextView = roomListItemVH.e().f76591i;
        Intrinsics.f(bLTextView, "holder.viewBinding.tvNewCount");
        bLTextView.setVisibility((j11 > 0L ? 1 : (j11 == 0L ? 0 : -1)) > 0 ? 0 : 8);
        roomListItemVH.e().f76591i.setText(Utils.a().getString(R$string.x_new, j11 > 99 ? "99+" : String.valueOf(j11)));
    }

    public final void M0(RoomListItemVH roomListItemVH, PostSubjectItem postSubjectItem) {
        List<Image> image;
        List<Image> image2;
        Media media = postSubjectItem.getMedia();
        List<Image> image3 = null;
        int i11 = 0;
        if (media == null || (image = media.getImage()) == null || image.size() <= 2) {
            Media media2 = postSubjectItem.getMedia();
            if (media2 != null) {
                image3 = media2.getImage();
            }
        } else {
            Media media3 = postSubjectItem.getMedia();
            if (media3 != null && (image2 = media3.getImage()) != null) {
                image3 = image2.subList(0, 2);
            }
        }
        List<Image> list = image3;
        if (list == null || list.isEmpty()) {
            FrameLayout root = roomListItemVH.e().f76588f.getRoot();
            Intrinsics.f(root, "holder.viewBinding.layoutNewPostImage.root");
            c.g(root);
            return;
        }
        FrameLayout root2 = roomListItemVH.e().f76588f.getRoot();
        Intrinsics.f(root2, "holder.viewBinding.layoutNewPostImage.root");
        c.k(root2);
        ShapeableImageView shapeableImageView = roomListItemVH.e().f76588f.f76610c;
        Intrinsics.f(shapeableImageView, "holder.viewBinding.layoutNewPostImage.ivPostCover2");
        shapeableImageView.setVisibility(image3.size() > 1 ? 0 : 8);
        BLView bLView = roomListItemVH.e().f76588f.f76611d;
        Intrinsics.f(bLView, "holder.viewBinding.layoutNewPostImage.vPostBg");
        bLView.setVisibility(image3.size() > 1 ? 0 : 8);
        for (Object obj : image3) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            Image image4 = (Image) obj;
            ShapeableImageView shapeableImageView2 = i11 == 0 ? roomListItemVH.e().f76588f.f76609b : roomListItemVH.e().f76588f.f76610c;
            Intrinsics.f(shapeableImageView2, "if (index == 0) holder.v…NewPostImage.ivPostCover2");
            String url = image4.getUrl();
            if (url != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                int i13 = this.J;
                companion.r(context, shapeableImageView2, url, (4088 & 8) != 0 ? companion.d() : i13, (4088 & 16) != 0 ? companion.c() : i13, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
            i11 = i12;
        }
    }

    public final void N0(RoomListItemVH roomListItemVH, PostSubjectItem postSubjectItem) {
        String url;
        FirstFrame firstFrame;
        Cover cover;
        Media media = postSubjectItem.getMedia();
        if (media == null || (cover = media.getCover()) == null || (url = cover.getUrl()) == null) {
            Media media2 = postSubjectItem.getMedia();
            url = (media2 == null || (firstFrame = media2.getFirstFrame()) == null) ? null : firstFrame.getUrl();
        }
        String str = url;
        if (str == null || str.length() == 0) {
            FrameLayout root = roomListItemVH.e().f76589g.getRoot();
            Intrinsics.f(root, "holder.viewBinding.layoutNewPostVideo.root");
            c.g(root);
            return;
        }
        FrameLayout root2 = roomListItemVH.e().f76589g.getRoot();
        Intrinsics.f(root2, "holder.viewBinding.layoutNewPostVideo.root");
        c.k(root2);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        ShapeableImageView shapeableImageView = roomListItemVH.e().f76589g.f76613b;
        Intrinsics.f(shapeableImageView, "holder.viewBinding.layoutNewPostVideo.ivPostCover");
        int i11 = this.J;
        companion.r(context, shapeableImageView, str, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    public final void O0(RoomListItemVH roomListItemVH, RoomItem roomItem) {
        J0(roomListItemVH, Intrinsics.b(roomItem.getHasJoin(), Boolean.TRUE));
        RoomJoinAnimationView roomJoinAnimationView = roomListItemVH.e().f76595m;
        Intrinsics.f(roomJoinAnimationView, "holder.viewBinding.vJoin");
        c.k(roomJoinAnimationView);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
