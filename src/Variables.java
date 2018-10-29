import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Variables {
	
	
	public static HashMap<String, Object> simbols = new HashMap<String, Object>();
		
	public static void initializeVariable(String idName){
		if(!simbols.containsKey(idName))
			simbols.put(idName, (Object) 0.0);
	}
	
	public static void initializeVector(String idName) {
		if (!simbols.containsKey(idName))
			simbols.put(idName, (Object) new Vector());
	}
	
	public static void setValue(String idName, Object val){
		simbols.put(idName, (Object) val);
	}
	
	public static void setVector(String idName, Object v) {
		simbols.put(idName, (Object) v);
	}
	
	public static void setVector(String idName, Object d1, Object d2) {
		simbols.put(idName, (Object) new Vector((Double)d1, (Double)d2));
	}
		
	public static Object getValue(String idName){
		if(!simbols.containsKey(idName))
			initializeVariable (idName);
		return (Object) simbols.get(idName);
	}
	
	public static String getVectorString(String idName) {
		if (!simbols.containsKey(idName))
			initializeVector(idName);
		return (String) "<" + ((Vector) simbols.get(idName)).d1 + ", " + ((Vector) simbols.get(idName)).d2 + ">";
	}
	
	public static void printVariables() {
		Iterator it = simbols.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if (pair.getValue() instanceof Vector) {
				Vector t = (Vector) pair.getValue();
				System.out.println((String)pair.getKey() + ": <" + t.d1 + ", " + t.d2 + ">");
			}
			else {
				System.out.println((String)pair.getKey() + ": " + (Double)(pair.getValue()));
			}
		}
	}
	
}


