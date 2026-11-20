package com.transsnet.flow.event.sync;

import com.transsion.user.action.sync.event.CommentEvent;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.flow.event.sync.event.WatchLaterEvent;
import j00.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
@SourceDebugExtension
public final class SyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f61414a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SyncManager> f61415b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SyncManager>() { // from class: com.transsnet.flow.event.sync.SyncManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SyncManager invoke() {
            return new SyncManager(null);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SyncManager a() {
            return (SyncManager) SyncManager.f61415b.getValue();
        }
    }

    public SyncManager() {
    }

    public /* synthetic */ SyncManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void b(int i11, String commentId, String commentNum, String str) {
        Intrinsics.g(commentId, "commentId");
        Intrinsics.g(commentNum, "commentNum");
        CommentEvent commentEvent = new CommentEvent(i11 == 1, commentId, commentNum, str);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, commentEvent, 0L);
    }

    public final void c(String postId) {
        Intrinsics.g(postId, "postId");
        b bVar = new b(postId);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = b.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, bVar, 0L);
    }

    public final void d(int i11, String groupId) {
        Intrinsics.g(groupId, "groupId");
        boolean z11 = false;
        if (i11 != 0 && i11 == 1) {
            z11 = true;
        }
        JoinRoomEvent joinRoomEvent = new JoinRoomEvent(z11, groupId);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, joinRoomEvent, 0L);
    }

    public final void e(int i11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        LikeEvent likeEvent = new LikeEvent(i11 == 0, subjectId);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, likeEvent, 0L);
    }

    public final void f(String postId, String str, int i11) {
        Intrinsics.g(postId, "postId");
        try {
            PublishEvent publishEvent = new PublishEvent(postId, str, i11);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, publishEvent, 0L);
        } catch (Exception unused) {
            PublishEvent publishEvent2 = new PublishEvent(postId, null, i11);
            FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = PublishEvent.class.getName();
            Intrinsics.f(name2, "T::class.java.name");
            flowEventBus2.postEvent(name2, publishEvent2, 0L);
        }
    }

    public final void g(int i11, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        boolean z11 = false;
        if (i11 != 0 && i11 == 1) {
            z11 = true;
        }
        WatchLaterEvent watchLaterEvent = new WatchLaterEvent(z11, subjectId);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = WatchLaterEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, watchLaterEvent, 0L);
    }
}
