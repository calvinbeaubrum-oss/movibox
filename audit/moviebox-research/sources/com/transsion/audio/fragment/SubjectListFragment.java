package com.transsion.audio.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.f0;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.audio.viewmodel.SubjectListViewModel;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;

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
public final class SubjectListFragment extends BaseFragment<fr.c> implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f50804r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f50805s = "SubjectListFragment";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubjectListAdapter f50807b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioBottomSheetFragment f50811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f50812h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f50817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f50818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f50819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f50820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AtomicBoolean f50821q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50806a = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50808c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50809d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50810f = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f50813i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50814j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50815k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50816l = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return SubjectListFragment.f50805s;
        }

        @JvmStatic
        public final SubjectListFragment b(String str) {
            SubjectListFragment subjectListFragment = new SubjectListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("subjectId", str);
            subjectListFragment.setArguments(bundle);
            return subjectListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f50822a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f50822a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f50822a;
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
            this.f50822a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.fragment.SubjectListFragment$onCompletion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onCompletion$1", f = "SubjectListFragment.kt", l = {430}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class C19891 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaSource $mediaSource;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19891(MediaSource mediaSource, SubjectListFragment subjectListFragment, Continuation<? super C19891> continuation) {
            super(2, continuation);
            this.$mediaSource = mediaSource;
            this.this$0 = subjectListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C19891(this.$mediaSource, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19891) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0064  */
        /* JADX WARN: Code duplicated, block: B:21:0x006c  */
        /* JADX WARN: Code duplicated, block: B:24:0x0077  */
        /* JADX WARN: Code duplicated, block: B:31:0x009e  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:34:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:37:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0092 -> B:30:0x009b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:37:0x00b4
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 216
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment.C19891.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.fragment.SubjectListFragment$onPlayError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onPlayError$1", f = "SubjectListFragment.kt", l = {TTAdConstant.VIDEO_URL_CODE}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class C19901 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C19901(Continuation<? super C19901> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubjectListFragment.this.new C19901(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19901) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0054  */
        /* JADX WARN: Code duplicated, block: B:17:0x005c  */
        /* JADX WARN: Code duplicated, block: B:20:0x0067  */
        /* JADX WARN: Code duplicated, block: B:27:0x008b  */
        /* JADX WARN: Code duplicated, block: B:29:0x0094  */
        /* JADX WARN: Code duplicated, block: B:33:0x009e  */
        /* JADX WARN: Code duplicated, block: B:36:0x00a8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:26:0x0088). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:33:0x009e
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
                int r1 = r12.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 != r3) goto L28
                int r1 = r12.I$1
                int r4 = r12.I$0
                java.lang.Object r5 = r12.L$2
                com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
                java.lang.Object r6 = r12.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r12.L$0
                com.transsion.audio.fragment.SubjectListFragment r7 = (com.transsion.audio.fragment.SubjectListFragment) r7
                kotlin.ResultKt.b(r13)
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r1
                r1 = r0
                r0 = r12
                goto L88
            L28:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L30:
                kotlin.ResultKt.b(r13)
                com.transsion.audio.fragment.SubjectListFragment r13 = com.transsion.audio.fragment.SubjectListFragment.this
                com.transsion.audio.adapter.SubjectListAdapter r13 = com.transsion.audio.fragment.SubjectListFragment.n0(r13)
                if (r13 == 0) goto Lb3
                java.util.List r13 = r13.D()
                if (r13 == 0) goto Lb3
                java.lang.Iterable r13 = (java.lang.Iterable) r13
                com.transsion.audio.fragment.SubjectListFragment r1 = com.transsion.audio.fragment.SubjectListFragment.this
                java.util.Iterator r13 = r13.iterator()
                r4 = 0
                r6 = r13
                r7 = r1
                r1 = 0
                r13 = r12
            L4e:
                boolean r4 = r6.hasNext()
                if (r4 == 0) goto Lb1
                java.lang.Object r4 = r6.next()
                int r5 = r1 + 1
                if (r1 >= 0) goto L5f
                kotlin.collections.CollectionsKt.u()
            L5f:
                com.transsion.moviedetailapi.DownloadItem r4 = (com.transsion.moviedetailapi.DownloadItem) r4
                java.lang.String r8 = r4.getUrl()
                if (r8 == 0) goto L8b
                rr.a r9 = com.transsion.audio.fragment.SubjectListFragment.k0(r7)
                if (r9 == 0) goto L8b
                r13.L$0 = r7
                r13.L$1 = r6
                r13.L$2 = r4
                r13.I$0 = r5
                r13.I$1 = r1
                r13.label = r3
                java.lang.Object r8 = r9.c(r8, r13)
                if (r8 != r0) goto L80
                return r0
            L80:
                r11 = r0
                r0 = r13
                r13 = r8
                r8 = r7
                r7 = r6
                r6 = r4
                r4 = r1
                r1 = r11
            L88:
                com.transsion.baselib.db.audio.AudioBean r13 = (com.transsion.baselib.db.audio.AudioBean) r13
                goto L92
            L8b:
                r8 = r7
                r7 = r6
                r6 = r4
                r4 = r1
                r1 = r0
                r0 = r13
                r13 = r2
            L92:
                if (r13 == 0) goto Lab
                int r9 = r13.getStatus()
                r10 = 3
                if (r9 != r10) goto Lab
                if (r13 != 0) goto L9e
                goto La2
            L9e:
                r9 = 7
                r13.setStatus(r9)
            La2:
                com.transsion.audio.adapter.SubjectListAdapter r13 = com.transsion.audio.fragment.SubjectListFragment.n0(r8)
                if (r13 == 0) goto Lab
                r13.notifyItemChanged(r4, r6)
            Lab:
                r13 = r0
                r0 = r1
                r1 = r5
                r6 = r7
                r7 = r8
                goto L4e
            Lb1:
                kotlin.Unit r2 = kotlin.Unit.f68710a
            Lb3:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment.C19901.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.fragment.SubjectListFragment$onPrepare$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onPrepare$1", f = "SubjectListFragment.kt", l = {358}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class C19911 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaSource $mediaSource;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19911(MediaSource mediaSource, SubjectListFragment subjectListFragment, Continuation<? super C19911> continuation) {
            super(2, continuation);
            this.$mediaSource = mediaSource;
            this.this$0 = subjectListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C19911(this.$mediaSource, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19911) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0060  */
        /* JADX WARN: Code duplicated, block: B:21:0x0068  */
        /* JADX WARN: Code duplicated, block: B:24:0x0073  */
        /* JADX WARN: Code duplicated, block: B:30:0x0091  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:37:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:41:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:45:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:48:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:51:0x0103  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008b -> B:29:0x008e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x0060
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment.C19911.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.transsion.audio.fragment.SubjectListFragment$onProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onProgress$1", f = "SubjectListFragment.kt", l = {380}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class C19921 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaSource $mediaSource;
        final /* synthetic */ long $progress;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19921(MediaSource mediaSource, SubjectListFragment subjectListFragment, long j11, Continuation<? super C19921> continuation) {
            super(2, continuation);
            this.$mediaSource = mediaSource;
            this.this$0 = subjectListFragment;
            this.$progress = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C19921(this.$mediaSource, this.this$0, this.$progress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19921) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0066  */
        /* JADX WARN: Code duplicated, block: B:21:0x006e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0079  */
        /* JADX WARN: Code duplicated, block: B:30:0x0099  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:39:0x00be  */
        /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:43:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:52:0x0108  */
        /* JADX WARN: Code duplicated, block: B:55:0x0110  */
        /* JADX WARN: Code duplicated, block: B:56:0x0115  */
        /* JADX WARN: Code duplicated, block: B:59:0x011c  */
        /* JADX WARN: Code duplicated, block: B:63:0x0129  */
        /* JADX WARN: Code duplicated, block: B:67:0x0134  */
        /* JADX WARN: Code duplicated, block: B:70:0x0144  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0093 -> B:29:0x0096). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:63:0x0129
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 334
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment.C19921.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SubjectListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f50817m = FragmentViewModelLazyKt.a(this, Reflection.b(SubjectListViewModel.class), new Function0<x0>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.audio.fragment.SubjectListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f50818n = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsion.audio.fragment.SubjectListFragment$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                Application applicationA = com.tn.lib.util.a.f49452a.a();
                if (applicationA != null) {
                    return AppDatabase.f51036p.b(applicationA).D0();
                }
                return null;
            }
        });
        this.f50819o = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.audio.fragment.SubjectListFragment$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f50820p = "";
        this.f50821q = new AtomicBoolean(false);
    }

    private final void E0() {
        if (this.f50813i < 1) {
            return;
        }
        O0(this, false, this.f50816l, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a F0() {
        return (rr.a) this.f50818n.getValue();
    }

    private final IAudioApi G0() {
        return (IAudioApi) this.f50819o.getValue();
    }

    public static final void K0(SubjectListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.P0();
    }

    public static final void L0(BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof DownloadItem) {
            DownloadItem downloadItem = (DownloadItem) item;
            if (TextUtils.isEmpty(downloadItem.getPostId())) {
                zp.b.f82110a.e("This page is unavailable");
            } else {
                com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, "audio_list").withString("id", downloadItem.getPostId()).withString("media_type", MediaType.AUDIO.getValue()).withBoolean("video_load_more", true).navigation();
            }
        }
    }

    public static final void M0(SubjectListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0();
    }

    public static /* synthetic */ void O0(SubjectListFragment subjectListFragment, boolean z11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 8;
        }
        subjectListFragment.N0(z11, i11, i12);
    }

    private final void P0() {
        O0(this, true, this.f50815k, 0, 4, null);
    }

    public static final void T0(SubjectListFragment this$0, DownloadListBean downloadListBean, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.J0(this$0.f50808c, downloadListBean != null ? downloadListBean.getSubjectType() : SubjectType.MOVIE.getValue());
    }

    public final SubjectListViewModel H0() {
        return (SubjectListViewModel) this.f50817m.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public fr.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        fr.c cVarC = fr.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }

    public final void J0(String str, int i11) {
        com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", i11).withString("id", str).navigation();
    }

    public final void N0(boolean z11, int i11, int i12) {
        H0().d(z11, this.f50808c, (48 & 4) != 0 ? "1" : String.valueOf(i11), (48 & 8) != 0 ? 8 : i12, (48 & 16) != 0 ? 1 : 0, (48 & 32) != 0 ? 8 : 0, (48 & 64) != 0 ? 0 : 0);
    }

    public final void Q0(DownloadItem downloadItem, AudioBean audioBean) throws InterruptedException {
        List<DownloadItem> listD;
        SubjectListAdapter subjectListAdapter;
        SubjectListAdapter subjectListAdapter2 = this.f50807b;
        if (subjectListAdapter2 != null && (listD = subjectListAdapter2.D()) != null) {
            int i11 = 0;
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                if (Intrinsics.b(downloadItem, (DownloadItem) obj) && (subjectListAdapter = this.f50807b) != null) {
                    subjectListAdapter.notifyItemChanged(i11, downloadItem);
                }
                i11 = i12;
            }
        }
        Long readProcess = audioBean.getReadProcess();
        long jLongValue = readProcess != null ? readProcess.longValue() : 0L;
        String url = downloadItem.getUrl();
        String url2 = downloadItem.getUrl();
        if (url2 == null) {
            url2 = "";
        }
        onProgress(jLongValue, new MediaSource(url, url2, 0, null, null, 28, null));
    }

    public final void R0(int i11) {
        this.f50812h = i11;
    }

    public final void S0(final DownloadListBean downloadListBean) {
        String url;
        h9.f fVarQ;
        List<DownloadItem> listL;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        SubjectListAdapter subjectListAdapter;
        h9.f fVarQ2;
        h9.f fVarQ3;
        SubjectListAdapter subjectListAdapter2;
        h9.f fVarQ4;
        String nextPage;
        List<DownloadItem> listD;
        LinearLayoutCompat linearLayoutCompat;
        Cover cover;
        if (downloadListBean == null || (cover = downloadListBean.getCover()) == null || (url = cover.getUrl()) == null) {
            url = "";
        }
        String str = url;
        fr.c mViewBinding = getMViewBinding();
        ShapeableImageView shapeableImageView = mViewBinding != null ? mViewBinding.f65231c : null;
        Context context = getContext();
        if (context != null && !TextUtils.isEmpty(str) && shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            companion.r(context, shapeableImageView, str, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        fr.c mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (linearLayoutCompat = mViewBinding2.f65232d) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListFragment.T0(this.f50828a, downloadListBean, view);
                }
            });
        }
        fr.c mViewBinding3 = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding3 != null ? mViewBinding3.f65235h : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(downloadListBean != null ? downloadListBean.getSubjectTitle() : null);
        }
        List<DownloadItem> items = downloadListBean != null ? downloadListBean.getItems() : null;
        if (items == null || items.isEmpty()) {
            SubjectListAdapter subjectListAdapter3 = this.f50807b;
            if (subjectListAdapter3 == null || (fVarQ = subjectListAdapter3.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ, false, 1, null);
            return;
        }
        SubjectListAdapter subjectListAdapter4 = this.f50807b;
        if (subjectListAdapter4 != null && (listD = subjectListAdapter4.D()) != null && listD.isEmpty()) {
            SubjectListAdapter subjectListAdapter5 = this.f50807b;
            if (subjectListAdapter5 != null) {
                subjectListAdapter5.w0(items);
                return;
            }
            return;
        }
        SubjectListAdapter subjectListAdapter6 = this.f50807b;
        if (subjectListAdapter6 == null || (listL = subjectListAdapter6.D()) == null) {
            listL = kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!listL.contains((DownloadItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (downloadListBean.getLoadMore()) {
            SubjectListAdapter subjectListAdapter7 = this.f50807b;
            if (subjectListAdapter7 != null) {
                subjectListAdapter7.m(arrayList);
            }
            Pager pager = downloadListBean.getPager();
            this.f50815k = (pager == null || (nextPage = pager.getNextPage()) == null) ? 1 : Integer.parseInt(nextPage);
            SubjectListAdapter subjectListAdapter8 = this.f50807b;
            if (subjectListAdapter8 != null && (fVarQ3 = subjectListAdapter8.Q()) != null && fVarQ3.q() && (subjectListAdapter2 = this.f50807b) != null && (fVarQ4 = subjectListAdapter2.Q()) != null) {
                fVarQ4.r();
            }
        } else {
            SubjectListAdapter subjectListAdapter9 = this.f50807b;
            if (subjectListAdapter9 != null) {
                subjectListAdapter9.k(0, arrayList);
            }
            fr.c mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (recyclerView = mViewBinding4.f65233f) != null) {
                recyclerView.scrollToPosition(arrayList.size() - 1);
            }
            fr.c mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (swipeRefreshLayout = mViewBinding5.f65234g) != null && swipeRefreshLayout.isRefreshing()) {
                fr.c mViewBinding6 = getMViewBinding();
                SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding6 != null ? mViewBinding6.f65234g : null;
                if (swipeRefreshLayout2 != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
            }
            this.f50816l--;
        }
        Pager pager2 = downloadListBean.getPager();
        if (pager2 == null || !Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) || (subjectListAdapter = this.f50807b) == null || (fVarQ2 = subjectListAdapter.Q()) == null) {
            return;
        }
        h9.f.t(fVarQ2, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        HistoryListManager.f50901e.b().o().j(this, new b(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.audio.fragment.SubjectListFragment.initData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                SubjectListAdapter subjectListAdapter;
                h9.f fVarQ;
                if (downloadListBean != null) {
                    SubjectListFragment subjectListFragment = SubjectListFragment.this;
                    Integer totalEpisode = downloadListBean.getTotalEpisode();
                    subjectListFragment.R0(totalEpisode != null ? totalEpisode.intValue() : 0);
                    Cover cover = downloadListBean.getCover();
                    subjectListFragment.f50806a = cover != null ? cover.getUrl() : null;
                    subjectListFragment.f50809d = downloadListBean.getGroupId();
                    subjectListFragment.f50810f = downloadListBean.getSubjectTitle();
                    subjectListFragment.S0(downloadListBean);
                    Integer position = downloadListBean.getPosition();
                    subjectListFragment.f50813i = position != null ? (position.intValue() / subjectListFragment.f50814j) + 1 : 1;
                    subjectListFragment.f50816l = subjectListFragment.f50813i - 1;
                    subjectListFragment.f50815k = subjectListFragment.f50813i + 1;
                    if (subjectListFragment.f50813i < 1) {
                        fr.c mViewBinding = subjectListFragment.getMViewBinding();
                        SwipeRefreshLayout swipeRefreshLayout = mViewBinding != null ? mViewBinding.f65234g : null;
                        if (swipeRefreshLayout != null) {
                            swipeRefreshLayout.setEnabled(false);
                        }
                    }
                    Pager pager = downloadListBean.getPager();
                    if (pager == null || !Intrinsics.b(pager.getHasMore(), Boolean.FALSE) || (subjectListAdapter = subjectListFragment.f50807b) == null || (fVarQ = subjectListAdapter.Q()) == null) {
                        return;
                    }
                    h9.f.t(fVarQ, false, 1, null);
                }
            }
        }));
        H0().c().j(this, new b(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.audio.fragment.SubjectListFragment.initData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                SubjectListFragment.this.S0(downloadListBean);
            }
        }));
        Bundle arguments = getArguments();
        this.f50808c = arguments != null ? arguments.getString("subjectId") : null;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        Intrinsics.g(view, "view");
        Fragment parentFragment = getParentFragment();
        Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.audio.fragment.AudioBottomSheetFragment");
        this.f50811g = (AudioBottomSheetFragment) parentFragment;
        fr.c mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (swipeRefreshLayout2 = mViewBinding.f65234g) == null) ? null : swipeRefreshLayout2.getLayoutParams();
        if (layoutParams != null) {
            AudioBottomSheetFragment audioBottomSheetFragment = this.f50811g;
            layoutParams.height = (audioBottomSheetFragment != null ? Integer.valueOf(audioBottomSheetFragment.B0() - f0.a(104.0f)) : null).intValue();
        }
        fr.c mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView = mViewBinding2 != null ? mViewBinding2.f65233f : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(getContext()));
        }
        SubjectListAdapter subjectListAdapter = new SubjectListAdapter(new ArrayList());
        subjectListAdapter.Q().y(true);
        subjectListAdapter.Q().C(new f9.f() { // from class: com.transsion.audio.fragment.d
            @Override // f9.f
            public final void a() {
                SubjectListFragment.K0(this.f50826a);
            }
        });
        subjectListAdapter.B0(new f9.d() { // from class: com.transsion.audio.fragment.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                SubjectListFragment.L0(baseQuickAdapter, view2, i11);
            }
        });
        subjectListAdapter.M0(new SubjectListAdapter.a() { // from class: com.transsion.audio.fragment.SubjectListFragment$initView$1$3
            @Override // com.transsion.audio.adapter.SubjectListAdapter.a
            public void a(DownloadItem download) throws InterruptedException {
                Intrinsics.g(download, "download");
                i.b(null, new SubjectListFragment$initView$1$3$onPlayItem$1(download, this.f50823a, null), 1, null);
            }
        });
        this.f50807b = subjectListAdapter;
        fr.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (swipeRefreshLayout = mViewBinding3.f65234g) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.audio.fragment.f
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    SubjectListFragment.M0(this.f50827a);
                }
            });
        }
        fr.c mViewBinding4 = getMViewBinding();
        RecyclerView recyclerView2 = mViewBinding4 != null ? mViewBinding4.f65233f : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.f50807b);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) throws InterruptedException {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        i.b(null, new C19891(mediaSource, this, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IAudioApi iAudioApiG0 = G0();
        if (iAudioApiG0 != null) {
            iAudioApiG0.removePlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) throws InterruptedException {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        zp.b.f82110a.e(String.valueOf(errorInfo.getErrorMessage()));
        i.b(null, new C19901(null), 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) throws InterruptedException {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        uo.b.a.f(uo.b.f78622a, f50805s, "onPrepare  " + (!TextUtils.equals(this.f50820p, mediaSource != null ? mediaSource.j() : null)) + "  previousUrl " + this.f50820p + " url " + (mediaSource != null ? mediaSource.j() : null), false, 4, null);
        i.b(null, new C19911(mediaSource, this, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) throws InterruptedException {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        i.b(null, new C19921(mediaSource, this, j11, null), 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IAudioApi iAudioApiG0 = G0();
        if (iAudioApiG0 != null) {
            iAudioApiG0.addPlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }
}
