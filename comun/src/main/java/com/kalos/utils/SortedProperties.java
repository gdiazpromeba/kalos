package com.kalos.utils;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;


public class SortedProperties extends Properties{
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Enumeration keys() {
       Enumeration keysEnum = super.keys();
       Vector<String> keyList = new Vector<String>();
       while(keysEnum.hasMoreElements()){
         keyList.add((String)keysEnum.nextElement());
       }
       Collections.sort(keyList);
       return keyList.elements();
    }
    
  }
