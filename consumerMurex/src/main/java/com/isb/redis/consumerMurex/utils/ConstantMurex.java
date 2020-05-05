package com.isb.redis.consumerMurex.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constantes
 * @author ftsaiz
 *
 */
public class ConstantMurex {
	
	public final static String KEY_TO_REPLACE = "eDerivativesMurex-";

	final static String RESULT_OK = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root><contractId>2328064</contractId><correlationId>"
			+ "eDerivativesMurex-</correlationId></root>";
	 
	final static String RESULT_ALREADY_EXIST_IN_TABLE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root><errorText>already exists in table"
			+ "</errorText><correlationId>eDerivativesMurex-</correlationId></root>";
	
	final static String RESULT_ERROR_PARSEO = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root><errorText> "
			+ "Technical error :&lt;?xml version=\"1.0\" "
			+ "encoding=\"UTF-8\"?&gt; &lt;ns0:ErrorReport xmlns:ns0=\"http://www.tibco.com/pe/EngineTypes\"&gt;     "
			+ "&lt;StackTrace&gt;Job-2000 Error in [Processes/JMS_eDerivativesMurex-MurexEQEngine.process/TransformeDerivativesCall] error "
			+ "on exit from activity, no matching transition&amp;#xD;                 at com.tibco.pe.core.Job.a(Unknown Source)&amp;#xD;  "
			+ "        at com.tibco.pe.core.Job.a(Unknown Source)&amp;#xD;        at com.tibco.pe.core.Job.k(Unknown Source)&amp;#xD;       "
			+ "   at com.tibco.pe.core.JobDispatcher$JobCourier.a(Unknown Source)&amp;#xD;              "
			+ "  at com.tibco.pe.core.JobDispatcher$JobCourier.run(Unknown Source)&amp;#xD; &lt;/StackTrace&gt;   "
			+ "  &lt;Msg&gt;error on exit from activity, no matching transition&lt;/Msg&gt;   "
			+ "  &lt;FullClass&gt;com.tibco.pe.core.EngineSupportException&lt;/FullClass&gt;     &lt;Class&gt;EngineSupportException&lt;/Class&gt; "
			+ "    &lt;ProcessStack&gt;Processes/JMS_eDerivativesMurex-MurexEQEngine.process/TransformeDerivativesCall&lt;/ProcessStack&gt;  "
			+ "   &lt;MsgCode&gt;BWENGINE-100035&lt;/MsgCode&gt; "
			+ "&lt;/ns0:ErrorReport&gt;</errorText><correlationId>eDerivativesMurex-</correlationId></root>";
	
	

		
		public static final Map<Integer, String> mapResult;
	    static {
	        Map<Integer, String> aMap = new HashMap<>();
	        aMap.put(1, RESULT_OK);
	        aMap.put(2, RESULT_ALREADY_EXIST_IN_TABLE);
	        aMap.put(3, RESULT_ERROR_PARSEO);
	        mapResult = Collections.unmodifiableMap(aMap);
	    }
	
}
