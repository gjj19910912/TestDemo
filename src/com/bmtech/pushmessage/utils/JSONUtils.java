package com.bmtech.pushmessage.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JSONUtils {

	/**
	 * 提供hashmap生成返回给客户端的json值
	 * 
	 * @param map
	 * @return
	 */
	public static String returnJSONMessageFromHashMap(HashMap<String, Object> map) {
		if(map != null){
			String result = "{";
			Set<String> set = map.keySet();
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				result += "\"" + key + "\":\"" + map.get(key) + "\",";
			}
			result = result.substring(0, result.length() - 1) + "}";
			return result;
		}else{
			return "{}";
		}
	}
	
	/**
	 * 提供list生成返回给客户端的json值
	 * 
	 * @param map
	 * @return
	 */
	public static String returnJSONMessageFromList(List<HashMap<String, Object>> list) {
		if(list != null && list.size() > 0){
			String result = "[";
			for(int i = 0 ; i < list.size(); i++){
				HashMap<String,Object> map = list.get(i);
				Set<String> set = map.keySet();
				Iterator<String> iterator = set.iterator();
				String str = "{";
				while (iterator.hasNext()) {
					String key = iterator.next();
					str += "\"" + key + "\":\"" + map.get(key) + "\",";
				}
				result += str.substring(0, str.length() - 1) + "}" + ",";
			}
			result = result.substring(0,result.length() - 1) + "]";
			return result;
		}else{
			return "[]";
		}
	}
}
