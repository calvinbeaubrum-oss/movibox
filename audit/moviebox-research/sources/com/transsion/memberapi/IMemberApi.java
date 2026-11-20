package com.transsion.memberapi;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.template.IProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.f1;
import su.b;
import su.c;
import su.e;
import su.g;

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
public interface IMemberApi extends IProvider {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IMemberApi iMemberApi, Function0 function0, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkShowAdState");
            }
            if ((i11 & 1) != 0) {
                function0 = null;
            }
            iMemberApi.h1(function0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IMemberApi iMemberApi, Function2 function2, Function0 function0, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: claimMemberShipReward");
            }
            if ((i11 & 1) != 0) {
                function2 = null;
            }
            if ((i11 & 2) != 0) {
                function0 = null;
            }
            iMemberApi.Z0(function2, function0);
        }

        public static /* synthetic */ void c(IMemberApi iMemberApi, Activity activity, MemberSource memberSource, b bVar, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMemberPage");
            }
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            iMemberApi.v(activity, memberSource, bVar, z11);
        }
    }

    boolean A(Fragment fragment);

    void A0();

    void B(MemberDetail memberDetail);

    MemberDetail M();

    void N0(float f11);

    boolean O();

    void R(OpType opType, Function1<Object, Unit> function1);

    void V0(e eVar);

    void W(int i11, Function2<? super Boolean, ? super Boolean, Unit> function2);

    void Y();

    void Z0(Function2<? super String, ? super String, Unit> function2, Function0<Unit> function0);

    void c1(Activity activity, MemberSource memberSource, MemberCheckResult memberCheckResult, b bVar);

    f1<Boolean> d();

    void e0(MemberSceneType memberSceneType, Integer num, su.a aVar);

    boolean e1();

    Object f(MemberSceneType memberSceneType, Integer num, Function1<? super MemberCheckResult, Unit> function1, Continuation<? super Unit> continuation);

    boolean g();

    f1<MemberTaskItem> g0();

    void h1(Function0<Unit> function0);

    void i(Integer num, su.a aVar);

    int j1();

    void k1(Activity activity, String str, String str2, g gVar);

    boolean m();

    Fragment m0();

    void n();

    void p(c cVar);

    void v(Activity activity, MemberSource memberSource, b bVar, boolean z11);

    void w(e eVar);

    void y1();

    void z();
}
