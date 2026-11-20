package gq;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.network.BaseDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import y30.f;
import y30.o;
import y30.t;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface b {
    @o("trade/checkout/txnInfo")
    Object a(@y30.a RequestBody requestBody, Continuation<? super QueryOrderResultContent> continuation);

    @o("trade/checkout/loadConfig")
    Object b(@y30.a RequestBody requestBody, Continuation<? super LoadConfigContent> continuation);

    @o("trade/checkout/cashierPay")
    Object c(@y30.a RequestBody requestBody, Continuation<? super CreateOrderResultContent> continuation);

    @o("trade/checkout/cancel")
    Object d(@y30.a RequestBody requestBody, Continuation<? super QueryOrderResultContent> continuation);

    @f("trade/extend/transaction/currencyinfo")
    Object e(@t(TtmlNode.TAG_REGION) String str, Continuation<? super BaseDto<CurrencyInfoBean>> continuation);
}
