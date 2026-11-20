package com.transsion.home.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.nonstandard.WrapperNonstandardManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsion.home.fragment.HomeGameCenterProvider$initGameCenter$1", f = "HomeGameCenterProvider.kt", l = {49, 59}, m = "invokeSuspend")
public final class HomeGameCenterProvider$initGameCenter$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrameLayout $flGameCenter;
    final /* synthetic */ FrameLayout $flPhoneCenter;
    final /* synthetic */ View $leftLogo;
    int label;
    final /* synthetic */ HomeGameCenterProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeGameCenterProvider$initGameCenter$1(HomeGameCenterProvider homeGameCenterProvider, FrameLayout frameLayout, FrameLayout frameLayout2, View view, Continuation<? super HomeGameCenterProvider$initGameCenter$1> continuation) {
        super(2, continuation);
        this.this$0 = homeGameCenterProvider;
        this.$flGameCenter = frameLayout;
        this.$flPhoneCenter = frameLayout2;
        this.$leftLogo = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeGameCenterProvider$initGameCenter$1(this.this$0, this.$flGameCenter, this.$flPhoneCenter, this.$leftLogo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HomeGameCenterProvider$initGameCenter$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        WrapperNonstandardManager wrapperNonstandardManager = this.this$0.f52404a;
        if (wrapperNonstandardManager != null) {
            final FrameLayout frameLayout = this.$flGameCenter;
            final HomeGameCenterProvider homeGameCenterProvider = this.this$0;
            WrapperAdListener wrapperAdListener = new WrapperAdListener() { // from class: com.transsion.home.fragment.HomeGameCenterProvider$initGameCenter$1.1
                @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
                public void onLoad() {
                    super.onLoad();
                    frameLayout.setVisibility(0);
                    WrapperNonstandardManager wrapperNonstandardManager2 = homeGameCenterProvider.f52404a;
                    if (wrapperNonstandardManager2 != null) {
                        wrapperNonstandardManager2.g(frameLayout);
                    }
                }
            };
            this.label = 1;
            if (wrapperNonstandardManager.f("HomeRIGHTTopGameNonstandardScene", wrapperAdListener, this) == objE) {
                return objE;
            }
        }
        WrapperNonstandardManager wrapperNonstandardManager2 = this.this$0.f52405b;
        if (wrapperNonstandardManager2 != null) {
            final FrameLayout frameLayout2 = this.$flPhoneCenter;
            final View view = this.$leftLogo;
            final HomeGameCenterProvider homeGameCenterProvider2 = this.this$0;
            WrapperAdListener wrapperAdListener2 = new WrapperAdListener() { // from class: com.transsion.home.fragment.HomeGameCenterProvider$initGameCenter$1.2
                @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
                public void onLoad() {
                    super.onLoad();
                    frameLayout2.setVisibility(0);
                    view.setVisibility(8);
                    WrapperNonstandardManager wrapperNonstandardManager3 = homeGameCenterProvider2.f52405b;
                    if (wrapperNonstandardManager3 != null) {
                        wrapperNonstandardManager3.g(frameLayout2);
                    }
                }
            };
            this.label = 2;
            if (wrapperNonstandardManager2.f("HomeLeftTopBrandNonstandardScene", wrapperAdListener2, this) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
