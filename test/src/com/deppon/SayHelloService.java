package com.deppon;

import java.util.Map;

public class SayHelloService implements BaseService {

	@Override
	public Object execute(Map<String, Object> args) {
		String[] arg = (String[]) args.get("arg");
		if(args.equals(arg[0])){
			return "hello everybody";
		}else{
			return " bye ";
		}
	}

}
