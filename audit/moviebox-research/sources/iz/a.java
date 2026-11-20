package iz;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.profile.see.bean.ProfileSeeStaffItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeSubjectItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem;
import com.transsnet.downloader.DownloadManagerApi;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class a extends BaseProviderMultiAdapter<e9.a> implements j {
    public static final C0720a I = new C0720a(null);

    /* JADX INFO: renamed from: iz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0720a {
        public C0720a() {
        }

        public /* synthetic */ C0720a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends BaseItemProvider<e9.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f67760f = f0.a(72.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f67761g = f0.a(98.0f);

        public static final void x(ProfileSeeSubjectItem item, b this$0, View view) {
            Intrinsics.g(item, "$item");
            Intrinsics.g(this$0, "this$0");
            if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
                return;
            }
            Integer subjectType = item.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Integer subjectType2 = item.getSubjectType();
                postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", item.getSubjectId()).withString("ops", item.getOps()).navigation();
            } else {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context contextG = this$0.g();
                Intrinsics.e(contextG, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                downloadManagerApiA.a2((FragmentActivity) contextG, "movie_audio_archies", (384 & 4) != 0 ? "" : "", item.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : item, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 2;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.profile_item_see_content;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, e9.a item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            ProfileSeeSubjectItem profileSeeSubjectItem = (ProfileSeeSubjectItem) item;
            y(helper, profileSeeSubjectItem);
            w(helper, profileSeeSubjectItem);
        }

        public final void w(BaseViewHolder baseViewHolder, final ProfileSeeSubjectItem profileSeeSubjectItem) {
            so.c.g((AppCompatTextView) baseViewHolder.getView(R$id.desTv));
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: iz.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.x(profileSeeSubjectItem, this, view);
                }
            });
        }

        public final void y(BaseViewHolder baseViewHolder, ProfileSeeSubjectItem profileSeeSubjectItem) {
            String url;
            String thumbnail;
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.coverIv);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "imageView.context");
            Cover cover = profileSeeSubjectItem.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            int i11 = this.f67760f;
            int i12 = this.f67761g;
            Cover cover2 = profileSeeSubjectItem.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(context, imageView, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            baseViewHolder.setText(R$id.nameTv, profileSeeSubjectItem.getTitle());
            baseViewHolder.setText(R$id.maskTv, profileSeeSubjectItem.getCorner());
            View view = baseViewHolder.getView(R$id.maskTv);
            String corner = profileSeeSubjectItem.getCorner();
            view.setVisibility((corner == null || corner.length() == 0) ^ true ? 0 : 8);
            ((AppCompatTextView) baseViewHolder.getView(R$id.tagTv)).setText(com.transsion.moviedetailapi.helper.a.f53896a.f(profileSeeSubjectItem));
            so.c.g(baseViewHolder.getView(R$id.desTv));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c extends BaseItemProvider<e9.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f67762f = f0.a(72.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f67763g = f0.a(98.0f);

        public static final void x(ProfileSeeStaffItem item, View view) {
            Intrinsics.g(item, "$item");
            if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
                return;
            }
            com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", item).navigation();
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 3;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.profile_item_see_content;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, e9.a item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            ProfileSeeStaffItem profileSeeStaffItem = (ProfileSeeStaffItem) item;
            y(helper, profileSeeStaffItem);
            w(helper, profileSeeStaffItem);
        }

        public final void w(BaseViewHolder baseViewHolder, final ProfileSeeStaffItem profileSeeStaffItem) {
            ((ImageView) baseViewHolder.getView(R$id.jumpTv)).setImageResource(R$mipmap.ic_btn_arrow_transparent);
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: iz.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.c.x(profileSeeStaffItem, view);
                }
            });
        }

        public final void y(BaseViewHolder baseViewHolder, ProfileSeeStaffItem profileSeeStaffItem) {
            String str;
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.coverIv);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "imageView.context");
            String avatarUrl = profileSeeStaffItem.getAvatarUrl();
            companion.o(context, imageView, avatarUrl == null ? "" : avatarUrl, (32704 & 8) != 0 ? R$color.skeleton : com.transsion.usercenter.R$mipmap.profile_staff_default_avatar, (32704 & 16) != 0 ? companion.d() : this.f67762f, (32704 & 32) != 0 ? companion.c() : this.f67763g, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            baseViewHolder.setText(R$id.nameTv, profileSeeStaffItem.getName());
            baseViewHolder.getView(R$id.maskTv).setVisibility(8);
            AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R$id.tagTv);
            List<StaffType> staffTypes = profileSeeStaffItem.getStaffTypes();
            if (staffTypes != null) {
                str = "";
                for (StaffType staffType : staffTypes) {
                    if (str.length() > 0) {
                        str = ((Object) str) + " I ";
                    }
                    str = ((Object) str) + staffType.getName();
                }
            } else {
                str = "";
            }
            appCompatTextView.setTextColor(g().getResources().getColor(R$color.white_60));
            appCompatTextView.setText(str);
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(com.transsion.usercenter.R$mipmap.profile_ic_staff, 0, 0, 0);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) baseViewHolder.getView(R$id.desTv);
            appCompatTextView2.setText(profileSeeStaffItem.getDescription());
            String description = profileSeeStaffItem.getDescription();
            appCompatTextView2.setVisibility((description == null || description.length() == 0) ^ true ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends BaseItemProvider<e9.a> {
        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.profile_item_see_time;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, e9.a item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            ((TextView) helper.getView(R$id.tv_time)).setText(((ProfileSeeTimeItem) item).getDate());
        }
    }

    public a() {
        super(null, 1, null);
        K0(new d());
        K0(new b());
        K0(new c());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends e9.a> data, int i11) {
        Intrinsics.g(data, "data");
        return data.get(i11).getItemType();
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
