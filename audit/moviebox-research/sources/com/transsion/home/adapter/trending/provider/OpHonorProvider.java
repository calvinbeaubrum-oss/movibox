package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.bean.HonorBackground;
import com.transsion.home.bean.HonorInfoBean;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.view.VerticalRoundedRectView;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.io.File;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.f1;

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
public final class OpHonorProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f52229h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f52230i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseHomeSubFragment<?> f52231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TrendingViewModel f52232g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends BaseQuickAdapter<jt.a, BaseViewHolder> {
        public b(int i11) {
            super(i11, null, 2, null);
        }

        public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? R$layout.item_main_operation_honor_more : i11);
        }

        public static final void I0(jt.a item, ShapeableImageView this_apply) {
            String url;
            Cover cover;
            Integer height;
            Cover cover2;
            Integer width;
            Cover cover3;
            String thumbnail;
            Cover cover4;
            String coverUrl;
            String thumbnail2;
            Intrinsics.g(item, "$item");
            Intrinsics.g(this_apply, "$this_apply");
            if (item.a() != null) {
                VideoDetailPlayBean videoDetailPlayBeanA = item.a();
                if (videoDetailPlayBeanA == null || (coverUrl = videoDetailPlayBeanA.getCoverUrl()) == null) {
                    coverUrl = "";
                }
                VideoDetailPlayBean videoDetailPlayBeanA2 = item.a();
                String str = (videoDetailPlayBeanA2 == null || (thumbnail2 = videoDetailPlayBeanA2.getThumbnail()) == null) ? "" : thumbnail2;
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = this_apply.getContext();
                Intrinsics.f(context, "context");
                companion.q(context, this_apply, coverUrl, (8120 & 8) != 0 ? companion.d() : this_apply.getWidth(), (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                return;
            }
            Subject subjectB = item.b();
            if (subjectB == null || (cover4 = subjectB.getCover()) == null || (url = cover4.getUrl()) == null) {
                url = "";
            }
            Subject subjectB2 = item.b();
            String str2 = (subjectB2 == null || (cover3 = subjectB2.getCover()) == null || (thumbnail = cover3.getThumbnail()) == null) ? "" : thumbnail;
            Subject subjectB3 = item.b();
            int iIntValue = 0;
            int iIntValue2 = (subjectB3 == null || (cover2 = subjectB3.getCover()) == null || (width = cover2.getWidth()) == null) ? 0 : width.intValue();
            Subject subjectB4 = item.b();
            if (subjectB4 != null && (cover = subjectB4.getCover()) != null && (height = cover.getHeight()) != null) {
                iIntValue = height.intValue();
            }
            int height2 = iIntValue2 > iIntValue ? this_apply.getHeight() : this_apply.getWidth();
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context2 = this_apply.getContext();
            Intrinsics.f(context2, "context");
            companion2.q(context2, this_apply, url, (8120 & 8) != 0 ? companion2.d() : height2, (8120 & 16) != 0 ? companion2.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str2, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public int F(int i11) {
            if (i11 == 10) {
                return 100;
            }
            return super.F(i11);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, final jt.a item) {
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            int iB = com.transsion.baselib.utils.i.b(D(), item);
            final ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.main_op_honor_image);
            if (shapeableImageView != null) {
                shapeableImageView.post(new Runnable() { // from class: com.transsion.home.adapter.trending.provider.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        OpHonorProvider.b.I0(item, shapeableImageView);
                    }
                });
            }
            View viewOrNull = holder.getViewOrNull(R$id.main_op_honor_more_mask);
            View viewOrNull2 = holder.getViewOrNull(R$id.main_op_honor_more_text);
            if (F(iB) == 100) {
                if (viewOrNull != null) {
                    so.c.k(viewOrNull);
                }
                if (viewOrNull2 != null) {
                    so.c.k(viewOrNull2);
                }
                pr.a.f74040a.l(iB);
                return;
            }
            if (viewOrNull != null) {
                so.c.g(viewOrNull);
            }
            if (viewOrNull2 != null) {
                so.c.g(viewOrNull2);
            }
            if (item.a() != null) {
                pr.a.f74040a.j(item.a(), iB);
            } else {
                pr.a.f74040a.n(item.b(), iB);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52233a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52233a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52233a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52233a.invoke(obj);
        }
    }

    public OpHonorProvider(BaseHomeSubFragment<?> fragment, TrendingViewModel trendingViewModel) {
        Intrinsics.g(fragment, "fragment");
        this.f52231f = fragment;
        this.f52232g = trendingViewModel;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x009b  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:65:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0107  */
    /* JADX WARN: Code duplicated, block: B:67:0x010c  */
    /* JADX WARN: Code duplicated, block: B:69:0x010f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0115  */
    /* JADX WARN: Code duplicated, block: B:72:0x011a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0121  */
    /* JADX WARN: Code duplicated, block: B:76:0x0126  */
    /* JADX WARN: Code duplicated, block: B:79:0x012d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0132  */
    public static final void A(b adapter, Ref.ObjectRef historyList, OpHonorProvider this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        VideoDetailPlayBean videoDetailPlayBeanA;
        Subject subjectB;
        Subject subjectB2;
        Integer subjectType;
        Subject subjectB3;
        String subjectId;
        Subject subjectB4;
        String ops;
        VideoDetailPlayBean videoDetailPlayBeanA2;
        String downloadFilePath;
        String str;
        VideoDetailPlayBean videoDetailPlayBeanA3;
        String id2;
        VideoDetailPlayBean videoDetailPlayBeanA4;
        String id3;
        VideoDetailPlayBean videoDetailPlayBeanA5;
        Integer subjectType2;
        VideoDetailPlayBean videoDetailPlayBeanA6;
        String subjectId2;
        Intrinsics.g(adapter, "$adapter");
        Intrinsics.g(historyList, "$historyList");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (adapter.getItemViewType(i11 + 1) == 100) {
            com.alibaba.android.arouter.launcher.a.d().b("/download/play_history").navigation();
            pr.a.f74040a.m(i11);
            return;
        }
        List list = (List) historyList.element;
        jt.a aVar = list != null ? (jt.a) list.get(i11) : null;
        if ((aVar != null ? aVar.a() : null) == null) {
            if (aVar != null) {
                videoDetailPlayBeanA = aVar.a();
            } else {
                videoDetailPlayBeanA = null;
            }
            if (videoDetailPlayBeanA != null) {
                videoDetailPlayBeanA2 = aVar.a();
                if (videoDetailPlayBeanA2 != null) {
                    downloadFilePath = videoDetailPlayBeanA2.getDownloadFilePath();
                } else {
                    downloadFilePath = null;
                }
                str = "";
                if (this$0.E(downloadFilePath)) {
                    videoDetailPlayBeanA3 = aVar.a();
                    if (videoDetailPlayBeanA3 != null) {
                        id2 = videoDetailPlayBeanA3.getId();
                    } else {
                        id2 = null;
                    }
                    if (id2 != null && this$0.f52231f.getActivity() != null) {
                        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                        FragmentActivity activity = this$0.f52231f.getActivity();
                        Intrinsics.d(activity);
                        videoDetailPlayBeanA4 = aVar.a();
                        if (videoDetailPlayBeanA4 != null && (id3 = videoDetailPlayBeanA4.getId()) != null) {
                            str = id3;
                        }
                        downloadManagerApiA.j2(activity, str, HomeTabType.TAB_CODE_TRENDING);
                    }
                } else {
                    videoDetailPlayBeanA5 = aVar.a();
                    if (videoDetailPlayBeanA5 != null) {
                        subjectType2 = videoDetailPlayBeanA5.getSubjectType();
                    } else {
                        subjectType2 = null;
                    }
                    videoDetailPlayBeanA6 = aVar.a();
                    if (videoDetailPlayBeanA6 != null) {
                        subjectId2 = videoDetailPlayBeanA6.getSubjectId();
                    } else {
                        subjectId2 = null;
                    }
                    this$0.C(subjectType2, subjectId2, "");
                }
            } else {
                if (aVar != null) {
                    subjectB = aVar.b();
                } else {
                    subjectB = null;
                }
                if (subjectB != null) {
                    subjectB2 = aVar.b();
                    if (subjectB2 != null) {
                        subjectType = subjectB2.getSubjectType();
                    } else {
                        subjectType = null;
                    }
                    subjectB3 = aVar.b();
                    if (subjectB3 != null) {
                        subjectId = subjectB3.getSubjectId();
                    } else {
                        subjectId = null;
                    }
                    subjectB4 = aVar.b();
                    if (subjectB4 != null) {
                        ops = subjectB4.getOps();
                    } else {
                        ops = null;
                    }
                    this$0.C(subjectType, subjectId, ops);
                }
            }
        } else {
            VideoDetailPlayBean videoDetailPlayBeanA7 = aVar.a();
            if (Intrinsics.b(videoDetailPlayBeanA7 != null ? videoDetailPlayBeanA7.getPlayMode() : null, PlayMode.STREAM.getValue())) {
                VideoDetailPlayBean videoDetailPlayBeanA8 = aVar.a();
                Integer subjectType3 = videoDetailPlayBeanA8 != null ? videoDetailPlayBeanA8.getSubjectType() : null;
                VideoDetailPlayBean videoDetailPlayBeanA9 = aVar.a();
                String subjectId3 = videoDetailPlayBeanA9 != null ? videoDetailPlayBeanA9.getSubjectId() : null;
                Subject subjectB5 = aVar.b();
                this$0.C(subjectType3, subjectId3, subjectB5 != null ? subjectB5.getOps() : null);
            } else {
                if (aVar != null) {
                    videoDetailPlayBeanA = aVar.a();
                } else {
                    videoDetailPlayBeanA = null;
                }
                if (videoDetailPlayBeanA != null) {
                    videoDetailPlayBeanA2 = aVar.a();
                    if (videoDetailPlayBeanA2 != null) {
                        downloadFilePath = videoDetailPlayBeanA2.getDownloadFilePath();
                    } else {
                        downloadFilePath = null;
                    }
                    str = "";
                    if (this$0.E(downloadFilePath)) {
                        videoDetailPlayBeanA5 = aVar.a();
                        if (videoDetailPlayBeanA5 != null) {
                            subjectType2 = videoDetailPlayBeanA5.getSubjectType();
                        } else {
                            subjectType2 = null;
                        }
                        videoDetailPlayBeanA6 = aVar.a();
                        if (videoDetailPlayBeanA6 != null) {
                            subjectId2 = videoDetailPlayBeanA6.getSubjectId();
                        } else {
                            subjectId2 = null;
                        }
                        this$0.C(subjectType2, subjectId2, "");
                    } else {
                        videoDetailPlayBeanA3 = aVar.a();
                        if (videoDetailPlayBeanA3 != null) {
                            id2 = videoDetailPlayBeanA3.getId();
                        } else {
                            id2 = null;
                        }
                        if (id2 != null) {
                            DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
                            FragmentActivity activity2 = this$0.f52231f.getActivity();
                            Intrinsics.d(activity2);
                            videoDetailPlayBeanA4 = aVar.a();
                            if (videoDetailPlayBeanA4 != null) {
                                str = id3;
                            }
                            downloadManagerApiA2.j2(activity2, str, HomeTabType.TAB_CODE_TRENDING);
                        }
                    }
                } else {
                    if (aVar != null) {
                        subjectB = aVar.b();
                    } else {
                        subjectB = null;
                    }
                    if (subjectB != null) {
                        subjectB2 = aVar.b();
                        if (subjectB2 != null) {
                            subjectType = subjectB2.getSubjectType();
                        } else {
                            subjectType = null;
                        }
                        subjectB3 = aVar.b();
                        if (subjectB3 != null) {
                            subjectId = subjectB3.getSubjectId();
                        } else {
                            subjectId = null;
                        }
                        subjectB4 = aVar.b();
                        if (subjectB4 != null) {
                            ops = subjectB4.getOps();
                        } else {
                            ops = null;
                        }
                        this$0.C(subjectType, subjectId, ops);
                    }
                }
            }
        }
        if ((aVar != null ? aVar.a() : null) != null) {
            pr.a.f74040a.k(aVar.a(), i11);
        } else {
            pr.a.f74040a.o(aVar != null ? aVar.b() : null, i11);
        }
    }

    public static final void y(View view) {
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.b((IMemberApi) objH, null, OpHonorProvider$checkClaimShow$1$1.INSTANCE, 1, null);
    }

    public final View B(RecyclerView recyclerView, HonorInfoBean honorInfoBean, int i11) {
        int iE;
        int iA;
        String title;
        String start;
        String center;
        String dotColor;
        HonorBackground background;
        String end;
        HonorBackground background2;
        HonorBackground background3;
        String subtitle;
        String icon;
        View view = LayoutInflater.from(g()).inflate(R$layout.item_home_honor, (ViewGroup) recyclerView, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i11 == 0) {
            iE = com.blankj.utilcode.util.d0.e();
            iA = f0.a(24.0f);
        } else if (i11 != 1) {
            iE = com.blankj.utilcode.util.d0.e();
            iA = f0.a(135.0f);
        } else {
            iE = com.blankj.utilcode.util.d0.e();
            iA = f0.a(123.0f);
        }
        layoutParams.width = iE - iA;
        view.setLayoutParams(layoutParams);
        ImageView iconImage = (ImageView) view.findViewById(R$id.item_honor_level_icon);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        Intrinsics.f(iconImage, "iconImage");
        String str = "";
        companion.o(contextG, iconImage, (honorInfoBean == null || (icon = honorInfoBean.getIcon()) == null) ? "" : icon, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.ic_honor_default, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        TextView textView = (TextView) view.findViewById(R$id.item_honor_level_title);
        if (honorInfoBean == null || (title = honorInfoBean.getTitle()) == null) {
            title = "";
        }
        textView.setText(title);
        TextView textView2 = (TextView) view.findViewById(R$id.item_honor_level_subtitle);
        if (honorInfoBean != null && (subtitle = honorInfoBean.getSubtitle()) != null) {
            str = subtitle;
        }
        textView2.setText(Html.fromHtml(str));
        View viewFindViewById = view.findViewById(R$id.item_honor_background);
        int[] iArr = new int[3];
        String str2 = "#202534";
        if (honorInfoBean == null || (background3 = honorInfoBean.getBackground()) == null || (start = background3.getStart()) == null) {
            start = "#202534";
        }
        iArr[0] = Color.parseColor(start);
        if (honorInfoBean == null || (background2 = honorInfoBean.getBackground()) == null || (center = background2.getCenter()) == null) {
            center = "#202534";
        }
        iArr[1] = Color.parseColor(center);
        if (honorInfoBean != null && (background = honorInfoBean.getBackground()) != null && (end = background.getEnd()) != null) {
            str2 = end;
        }
        iArr[2] = Color.parseColor(str2);
        viewFindViewById.setBackground(ot.a.b(iArr, GradientDrawable.Orientation.LEFT_RIGHT));
        Intrinsics.f(view, "view");
        x(view);
        if (honorInfoBean != null && (dotColor = honorInfoBean.getDotColor()) != null) {
            VerticalRoundedRectView verticalRoundedRectView = (VerticalRoundedRectView) view.findViewById(R$id.item_honor_dot_start);
            VerticalRoundedRectView verticalRoundedRectView2 = (VerticalRoundedRectView) view.findViewById(R$id.item_honor_dot_end);
            verticalRoundedRectView.setRectColor(Color.parseColor(dotColor));
            verticalRoundedRectView2.setRectColor(Color.parseColor(dotColor));
        }
        return view;
    }

    public final void C(Integer num, String str, String str2) {
        com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", num != null ? num.intValue() : SubjectType.MOVIE.getValue()).withString("id", str).withString("ops", str2).withString("module_name", "op_honor").navigation();
    }

    public final void D(RecyclerView recyclerView, b bVar, List<jt.a> list, HonorInfoBean honorInfoBean) {
        bVar.w0(list);
        bVar.j0();
        bVar.p(B(recyclerView, honorInfoBean, list != null ? list.size() : 0), 0, 0);
    }

    public final boolean E(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (kotlin.text.l.L(str, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
            l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(str));
            if (aVarG != null) {
                return aVarG.e();
            }
        } else {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.HONOR.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_op_honor;
    }

    public final void x(View view) {
        LinearLayout honorLayout = (LinearLayout) view.findViewById(R$id.item_honor_content);
        lt.a0 a0VarA = lt.a0.a(view.findViewById(R$id.itemClaimLayout));
        Intrinsics.f(a0VarA, "bind(view.findViewById(R.id.itemClaimLayout))");
        f1<Boolean> f1VarD = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).d();
        MemberTaskItem value = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).g0().getValue();
        if (!f1VarD.getValue().booleanValue() || value == null) {
            LinearLayout root = a0VarA.getRoot();
            Intrinsics.f(root, "claimBinding.root");
            so.c.g(root);
            Intrinsics.f(honorLayout, "honorLayout");
            so.c.k(honorLayout);
            return;
        }
        TextView textView = a0VarA.f70381b;
        String buttonName = value.getButtonName();
        if (buttonName == null) {
            buttonName = "";
        }
        textView.setText(buttonName);
        TextView textView2 = a0VarA.f70385g;
        String title = value.getTitle();
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        TextView textView3 = a0VarA.f70384f;
        String subTitle = value.getSubTitle();
        textView3.setText(subTitle != null ? subTitle : "");
        Glide.with(g()).load2(value.getIcon()).into(a0VarA.f70383d);
        a0VarA.f70381b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OpHonorProvider.y(view2);
            }
        });
        LinearLayout root2 = a0VarA.getRoot();
        Intrinsics.f(root2, "claimBinding.root");
        so.c.k(root2);
        Intrinsics.f(honorLayout, "honorLayout");
        so.c.g(honorLayout);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        androidx.lifecycle.c0<String> c0VarL;
        androidx.lifecycle.c0<Boolean> c0VarN;
        androidx.lifecycle.c0<Boolean> c0VarN2;
        androidx.lifecycle.c0<HonorInfoBean> c0VarM;
        androidx.lifecycle.c0<HonorInfoBean> c0VarM2;
        androidx.lifecycle.c0<List<jt.a>> c0VarP;
        androidx.lifecycle.c0<List<jt.a>> c0VarP2;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        final RecyclerView recyclerView = (RecyclerView) helper.itemView.findViewById(R$id.op_item_honor_recycler);
        int i11 = 0;
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        final b bVar = new b(i11, 1, null);
        recyclerView.setAdapter(bVar);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        TrendingViewModel trendingViewModel = this.f52232g;
        if (trendingViewModel != null && (c0VarP2 = trendingViewModel.P()) != null) {
            c0VarP2.p(this.f52231f);
        }
        TrendingViewModel trendingViewModel2 = this.f52232g;
        if (trendingViewModel2 != null && (c0VarP = trendingViewModel2.P()) != null) {
            c0VarP.j(this.f52231f, new c(new Function1<List<? extends jt.a>, Unit>() { // from class: com.transsion.home.adapter.trending.provider.OpHonorProvider$convert$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends jt.a> list) {
                    invoke2((List<jt.a>) list);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<jt.a> list) {
                    booleanRef.element = true;
                    objectRef.element = list;
                    if (booleanRef2.element) {
                        OpHonorProvider opHonorProvider = this;
                        RecyclerView recyclerview = recyclerView;
                        Intrinsics.f(recyclerview, "recyclerview");
                        opHonorProvider.D(recyclerview, bVar, objectRef.element, objectRef2.element);
                        booleanRef2.element = false;
                        booleanRef.element = false;
                    }
                }
            }));
        }
        TrendingViewModel trendingViewModel3 = this.f52232g;
        if (trendingViewModel3 != null && (c0VarM2 = trendingViewModel3.M()) != null) {
            c0VarM2.p(this.f52231f);
        }
        TrendingViewModel trendingViewModel4 = this.f52232g;
        if (trendingViewModel4 != null && (c0VarM = trendingViewModel4.M()) != null) {
            c0VarM.j(this.f52231f, new c(new Function1<HonorInfoBean, Unit>() { // from class: com.transsion.home.adapter.trending.provider.OpHonorProvider$convert$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HonorInfoBean honorInfoBean) {
                    invoke2(honorInfoBean);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HonorInfoBean honorInfoBean) {
                    booleanRef2.element = true;
                    objectRef2.element = honorInfoBean;
                    if (booleanRef.element) {
                        OpHonorProvider opHonorProvider = this;
                        RecyclerView recyclerview = recyclerView;
                        Intrinsics.f(recyclerview, "recyclerview");
                        opHonorProvider.D(recyclerview, bVar, objectRef.element, objectRef2.element);
                        booleanRef2.element = false;
                        booleanRef.element = false;
                    }
                }
            }));
        }
        TrendingViewModel trendingViewModel5 = this.f52232g;
        if (trendingViewModel5 != null && (c0VarN2 = trendingViewModel5.N()) != null) {
            c0VarN2.p(this.f52231f);
        }
        TrendingViewModel trendingViewModel6 = this.f52232g;
        if (trendingViewModel6 != null && (c0VarN = trendingViewModel6.N()) != null) {
            c0VarN.j(this.f52231f, new c(new Function1<Boolean, Unit>() { // from class: com.transsion.home.adapter.trending.provider.OpHonorProvider$convert$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    OpHonorProvider opHonorProvider = this.this$0;
                    RecyclerView recyclerview = recyclerView;
                    Intrinsics.f(recyclerview, "recyclerview");
                    opHonorProvider.D(recyclerview, bVar, objectRef.element, objectRef2.element);
                }
            }));
        }
        int iN0 = this.f52231f.n0();
        helper.getView(R$id.op_item_honor_space).getLayoutParams().height = iN0;
        final View viewOrNull = helper.getViewOrNull(R$id.op_item_honor_gradient_bg);
        ViewGroup.LayoutParams layoutParams = viewOrNull != null ? viewOrNull.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = iN0 + f0.a(130.0f);
        }
        TrendingViewModel trendingViewModel7 = this.f52232g;
        if (trendingViewModel7 != null && (c0VarL = trendingViewModel7.L()) != null) {
            c0VarL.j(this.f52231f, new c(new Function1<String, Unit>() { // from class: com.transsion.home.adapter.trending.provider.OpHonorProvider$convert$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    View view = viewOrNull;
                    if (view == null) {
                        return;
                    }
                    Intrinsics.f(it, "it");
                    view.setBackground(ot.a.c(kotlin.text.l.F(it, com.transsion.gslb.Utils.SEPARATOR, "#ff", false, 4, null), kotlin.text.l.F(it, com.transsion.gslb.Utils.SEPARATOR, "#00", false, 4, null), null, 4, null));
                }
            }));
        }
        bVar.B0(new f9.d() { // from class: com.transsion.home.adapter.trending.provider.g
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                OpHonorProvider.A(bVar, objectRef, this, baseQuickAdapter, view, i12);
            }
        });
    }
}
