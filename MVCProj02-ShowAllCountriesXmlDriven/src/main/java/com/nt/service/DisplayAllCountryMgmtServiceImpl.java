package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DisplayAllCountryMgmtServiceImpl implements DisplayAllCountryMgmtService {

	@Override
	public List<String> getAllCountryName() {	
		String[] locale=null;
		List<String> list=null;
		
		list=new ArrayList<String>(); 
		//get the locale
		locale=Locale.getISOCountries();
		for(String countryCode : locale) {
			Locale name=new Locale("",countryCode);
			list.add(name.getDisplayName());
		}
		
		return list;
		}
}
