package symtable;

import exceptions.*;

import java.util.*;

public class Type
{
  public static final Type BOOL = new Type();
  public static final Type INT = new Type();
  public static final Type BYTE = new Type();
  public static final Type COLOR = new Type();
  public static final Type BUTTON = new Type();
  public static final Type VOID = new Type();
  public static final Type TONE = new Type();
  
  private static final HashMap<String, Type> classTypes = new HashMap();
  private final String className

  private Type()
  {
	  this.className = null;
  }

  private Type(String id)
  {
	if(id == null) throw new InternalException("id is null");
	this.className = id;
  }
  
  public static Type getClassType(String id)
  {
	if(id == null) throw new InternalException("id is null");
	Type localClassType = (Type)classTypes.get(id);
   if(localClassType == null) {
	   localClassType = new Type(id);
	   classTypes.put(id, localClassType);
   }
   return localClassType;
  }
  
  public boolean isRef()
  {
	return this.className != null;
  }
  
  public String getClassName()
  {
	if(this.className == null) throw new InternalException("cannot reference this type");
	return this.className;
  }
  
/*
*/

  public String toString()
  {
    if(this == INT)
    {
      return "INT";
    }

    if(this == BOOL)
    {
      return "BOOL";
    }

    if(this == BYTE)
    {
      return "BYTE";
    }

    if(this == COLOR)
    {
      return "COLOR";
    }

    if(this == BUTTON)
    {
      return "BUTTON";
    }
	
	if(this == TONE)
	{
	  return "TONE";
	}
	
	return "class_" + this.className + ";";
    //return "MAINCLASS;";
  }
  
  public int getAVRTypeSize() {
      if(this == INT) { return 2; }
      if(this == BOOL) { return 1; }
      if(this == BYTE) { return 1; }
      if(this == COLOR) { return 1; }
      if(this == BUTTON) { return 1; }
	  if(this == TONE) { return 2; }
      if(this == VOID) { return 0; }

      return 2; // class references are 2 bytes
  }

    
/*  
*/

}
