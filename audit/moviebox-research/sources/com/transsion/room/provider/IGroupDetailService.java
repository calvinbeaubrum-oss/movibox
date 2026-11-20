package com.transsion.room.provider;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.room.activity.RoomDetailActivity;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.RoomsViewType;
import com.transsion.room.api.bean.LocationPlace;
import com.transsion.room.helper.GpsServiceHelper;
import com.transsion.room.helper.LocationPlaceHelper;
import com.transsion.room.widget.RecommendRoomsView;
import com.transsion.room.widget.SubjectDetailRoomsView;
import com.transsion.room.widget.TrendingRoomsView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import rw.b;

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
@Route(path = "/group/detail")
@Metadata
public class IGroupDetailService implements IRoomApi {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57302a;

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
            f57302a = iArr;
        }
    }

    @Override // com.transsion.room.api.IRoomApi
    public void E0(FragmentActivity activity, boolean z11, Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(callback, "callback");
        LocationPlaceHelper.f57284a.t(activity, z11, callback);
    }

    @Override // com.transsion.room.api.IRoomApi
    public void M0(FragmentActivity activity, Function1<? super LocationPlace, Unit> callback) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(callback, "callback");
        LocationPlaceHelper.f57284a.n(activity, callback);
    }

    @Override // com.transsion.room.api.IRoomApi
    public b O0(Context context, RoomsViewType type) {
        Intrinsics.g(context, "context");
        Intrinsics.g(type, "type");
        int i11 = a.f57302a[type.ordinal()];
        if (i11 == 1) {
            return new RecommendRoomsView(context, null, 0, 6, null);
        }
        if (i11 == 2) {
            return new TrendingRoomsView(context, null, 0, 6, null);
        }
        if (i11 == 3) {
            return new SubjectDetailRoomsView(context, null, 0, 6, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.transsion.room.api.IRoomApi
    public String R0() {
        return String.valueOf(Reflection.b(RoomDetailActivity.class).e());
    }

    @Override // com.transsion.room.api.IRoomApi
    public void S0(double d11, double d12, Function1<? super List<LocationPlace>, Unit> callback) {
        Intrinsics.g(callback, "callback");
        LocationPlaceHelper.f57284a.p(d11, d12, callback);
    }

    @Override // com.transsion.room.api.IRoomApi
    public rw.a i1(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        return new GpsServiceHelper(fragment);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }
}
