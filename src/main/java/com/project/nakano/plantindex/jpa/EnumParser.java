package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumParser<E extends Enum<E>> {

  private static final Logger LOGGER = LoggerFactory.getLogger(EnumParser.class);
  
  private Class<E> enumName;
  private List<E> baseList;
 
  
  EnumParser(Class<E> enumName, String fields) {
    this.enumName = enumName;
    setListEnum(fields);
  }
  
  private void setListEnum(String field) {
    String[] fields = field.trim().split(" ");
    this.baseList = new ArrayList<>();
    for (String f : fields) {
      try {
        this.baseList.add(Enum.valueOf(this.enumName, f));
      } catch (Exception e) {
        LOGGER.debug("Error on parsing enum", e);
      }      
    }
  }
  
  public List<E> getListEnum() {
    return this.baseList;
  }
}
