package com.clouway;

import io.swagger.codegen.CodegenOperation;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class CustomCodeGenOperation extends CodegenOperation {
  public Boolean isValid = true;
  public String httpMethodCapitalized;
  public String methodPath;

  public CustomCodeGenOperation() {
    super();
    isValid = false;
  }
}