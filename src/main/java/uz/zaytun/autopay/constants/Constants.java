package uz.zaytun.autopay.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    /**
     * This is rest template bean name configured for auto-pay
     */
    public static final String AUTOPAY_REST_TEMPLATE = "autopayRestTemplate";
    public static final String AUTOPAY_OBJECT_MAPPER = "autopayObjectMapper";


    /**
     * These are auto-pay endpoints
     */
    public static final String LOGIN_API = "/api/login";
    public static final String AUTOPAY_API = "/api/v1/partners";


    /**
     * These are method names demonstrated in auto-pay documentation
     */
    public static final String LOGIN = "login";
    public static final String CONTRACT_CREATE = "contract.create";
    public static final String CONTRACT_CREATE_WITH_CLIENT = "contract.create.wc.single";
    public static final String CONTRACT_UPDATE = "contract.update";
    public static final String CONTRACT_BULK_UPDATE = "contract.bulk.update";
    public static final String CONTRACT_GET = "contract.get";
    public static final String CONTRACT_DELETE = "contract.delete";
    public static final String CONTRACT_AUTO_TOGGLE = "contract.auto.toggle";
    public static final String CONTRACT_FIND = "contract.find";
    public static final String TRANSACTION_GET = "transaction.get";
    public static final String TRANSACTION_SYNCHRONIZE = "transaction.synchronize";
    public static final String TRANSACTION_FIND = "transaction.find";
    public static final String TRANSACTION_CANCEL = "transaction.cancel";
    public static final String TRANSACTION_VERIFICATION_SET = "transaction.verification.set";
    public static final String TRANSACTION_VERIFICATION_CHECK = "transaction.verification.check";




}
