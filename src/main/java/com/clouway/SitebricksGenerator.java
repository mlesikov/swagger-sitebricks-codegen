package com.clouway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;
import io.swagger.codegen.*;
import io.swagger.codegen.languages.AbstractJavaCodegen;
import io.swagger.models.Operation;
import io.swagger.models.Swagger;
import io.swagger.models.properties.Property;
import io.swagger.util.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SitebricksGenerator extends AbstractJavaCodegen implements CodegenConfig {
  private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(SitebricksGenerator.class.getName());
  private static final Logger LOGGER = LoggerFactory.getLogger(SitebricksGenerator.class);


  // source folder where to write the files
//  protected String sourceFolder = "src";
  protected String sourceFolder = "";
  protected String apiVersion = "1.0.0";

  /**
   * Configures the type of generator.
   *
   * @return  the CodegenType for this generator
   * @see     io.swagger.codegen.CodegenType
   */
  public CodegenType getTag() {
    return CodegenType.SERVER;
  }

  /**
   * Configures a friendly name for the generator.  This will be used by the generator
   * to select the library with the -l flag.
   *
   * @return the friendly name for the generator
   */
  public String getName() {
    return "sitebricks";
  }

  /**
   * Returns human-friendly help for the generator.  Provide the consumer with help
   * tips, parameters here
   *
   * @return A string value for the help message
   */
  public String getHelp() {
    return "Generates a Java Sitebricks Server REST service";
  }


   protected String title = "JAVA Sitebricks REST";
   protected String implFolder = "src/main/java";

  public SitebricksGenerator() {
    super();
    CodegenModelFactory.setTypeMapping(CodegenModelType.OPERATION, CustomCodeGenOperation.class);

    this.projectFolder = "io.foo.bar";

//         sourceFolder = "src/gen/java";
         apiTestTemplateFiles.clear(); // TODO: add test template
//         embeddedTemplateDir = templateDir = "JavaInflector";
//         embeddedTemplateDir = templateDir = "JavaSiteBricksREST";
//         invokerPackage = "io.swagger.handler";
//         artifactId = "swagger-inflector-server";   // in the pom, not needed
//         dateLibrary = "legacy"; //TODO: add joda support

         // clear model and api doc template as this codegen
         // does not support auto-generated markdown doc at the moment
         //TODO: add doc templates
         modelDocTemplateFiles.remove("model_doc.mustache");
         apiDocTemplateFiles.remove("api_doc.mustache");


//         apiPackage = System.getProperty("swagger.codegen.inflector.apipackage", "io.swagger.handler");
//         modelPackage = System.getProperty("swagger.codegen.inflector.modelpackage", "io.swagger.model");

         additionalProperties.put("title", title);
         // java inflector uses the gson lib
         additionalProperties.put("gson", "true");
//         additionalProperties.put("jackson", "true");



    // set the output folder here
    outputFolder = "generated-code/sitebricks";

    /**
     * Models.  You can write model files using the modelTemplateFiles map.
     * if you want to create one template for file, you can do so here.
     * for multiple files for model, just put another entry in the `modelTemplateFiles` with
     * a different extension
     */
//    modelTemplateFiles.put(
//      "model.mustache", // the template to use
//      ".sample");       // the extension for each file to write

    /**
     * Api classes.  You can write classes for each Api file with the apiTemplateFiles map.
     * as with models, add multiple entries with different extensions for multiple files per
     * class
     */
//    apiTemplateFiles.put(
//      "_api.mustache",   // the template to use
//      ".sample");       // the extension for each file to write

    /**
     * Template Location.  This is the location which templates will be read from.  The generator
     * will use the resource stream to attempt to read the templates.
     */
    templateDir = "sitebricks";

    /**
     * Api Package.  Optional, if needed, this can be used in templates
     */
//    apiPackage = "io.swagger.client.api";
//    apiPackage = "io.swagger.server.rest";
    apiPackage = projectFolder;

    /**
     * Model Package.  Optional, if needed, this can be used in templates
     */
//    modelPackage = "io.swagger.client.model";
//    modelPackage = "io.swagger.server.rest.model";
    modelPackage = "io.foo.bar";

    /**
     * Reserved words.  Override this with reserved words specific to your language
     */
    reservedWords = new HashSet<String> (
      Arrays.asList(
        "sample1",  // replace with static values
        "sample2")
    );

    /**
     * Additional Properties.  These values can be passed to the templates and
     * are available in models, apis, and supporting files
     */
    additionalProperties.put("apiVersion", apiVersion);

    /**
     * Supporting Files.  You can write single files for the generator with the
     * entire object tree available.  If the input file has a suffix of `.mustache
     * it will be processed by the template engine.  Otherwise, it will be copied
     */
//    supportingFiles.add(new SupportingFile("myFile.mustache",   // the input template or file
//      "",                                                       // the destination folder, relative `outputFolder`
//      "myFile.sample")                                          // the output file
//    );

//    /**
//     * Language Specific Primitives.  These types will not trigger imports by
//     * the client generator
//     */
//    languageSpecificPrimitives = new HashSet<String>(
//      Arrays.asList(
//        "Type1",      // replace these with your types
//        "Type2")
//    );
  }

  /**
   * Escapes a reserved word as defined in the `reservedWords` array. Handle escaping
   * those terms here.  This logic is only called if a variable matches the reseved words
   *
   * @return the escaped term
   */
  @Override
  public String escapeReservedWord(String name) {
    return "_" + name;  // add an underscore to the name
  }

  /**
   * Location to write model files.  You can use the modelPackage() as defined when the class is
   * instantiated
   */
  public String modelFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + modelPackage().replace('.', File.separatorChar);
  }

//  /**
//   * Location to write api files.  You can use the apiPackage() as defined when the class is
//   * instantiated
//   */
  @Override
  public String apiFileFolder() {
    return outputFolder + "/" + sourceFolder + "/" + apiPackage().replace('.', File.separatorChar);
  }


  /**
   * Optional - swagger type conversion.  This is used to map swagger types in a `Property` into
   * either language specific types via `typeMapping` or into complex models if there is not a mapping.
   *
   * @return a string value of the type or complex model for this property
   * @see io.swagger.models.properties.Property
   */
  @Override
  public String getSwaggerType(Property p) {
    String swaggerType = super.getSwaggerType(p);
    String type = null;
    if(typeMapping.containsKey(swaggerType)) {
      type = typeMapping.get(swaggerType);
      if(languageSpecificPrimitives.contains(type))
        return toModelName(type);
    }
    else
      type = swaggerType;
    return toModelName(type);
  }

   @Override
   public void processOpts() {
       super.processOpts();
       supportingFiles.add(new SupportingFile("swagger.mustache",
                       "resources/io/foo/bar",
                       "swagger.yaml")
       );
   }

  @Override
  public String sanitizeName(String packageName) {
    packageName = packageName.trim();
    packageName = packageName.replaceAll("[^a-zA-Z0-9_\\.]", "_");
    return Strings.isNullOrEmpty(packageName) ? "invalidPackageName" : packageName;
  }

  @Override
  public void addOperationToGroup(String tag, String resourcePath, Operation operation, CodegenOperation co, Map<String, List<CodegenOperation>> operations) {
    String basePath = resourcePath;
    if (basePath.startsWith("/")) {
      basePath = basePath.substring(1);
    }
    int pos = basePath.indexOf("/");
    if (pos > 0) {
      basePath = basePath.substring(0, pos);
    }

    if (basePath == "") {
      basePath = "default";
    } else {
      if (co.path.startsWith("/" + basePath)) {
        co.path = co.path.substring(("/" + basePath).length());
      }
      co.subresourceOperation = !co.path.isEmpty();
    }
    List<CodegenOperation> opList = operations.get(basePath);
    if (opList == null) {
      opList = new ArrayList<CodegenOperation>();
      operations.put(basePath, opList);
    }
    opList.add(co);
    co.baseName = basePath;
    CustomCodeGenOperation op = (CustomCodeGenOperation)co;
    op.httpMethodCapitalized =  capitalize(co.httpMethod);

    log.info("-------------------Operations is --------------------" + co.getClass());

    if(op.path !=null && op.path.contains("{")) {
      op.methodPath = op.path.replaceAll("\\{", ":").replaceAll("\\}","");
    }
    if("".equals(op.methodPath)){
      op.methodPath = null;
    }

  }
  String capitalize(String s) {
        String s1 = s.substring(0,1).toUpperCase();
        String sTitle = s1 + s.substring(1).toLowerCase();
        return sTitle;
   }

   @Override
   public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
       super.postProcessModelProperty(model, property);

     model.imports.remove("ApiModel");
     model.imports.remove("ApiModelProperty");

   }

   @Override
   public Map<String, Object> postProcessSupportingFileData(Map<String, Object> objs) {
       Swagger swagger = (Swagger)objs.get("swagger");
       if(swagger != null) {
           try {
               objs.put("swagger-yaml", Yaml.mapper().writeValueAsString(swagger));
           } catch (JsonProcessingException e) {
               LOGGER.error(e.getMessage(), e);
           }
       }
       return super.postProcessSupportingFileData(objs);
   }

   @Override
   public String toApiName(String name) {
       if (name.length() == 0) {
           return "DefaultController";
       }
       name = name.replaceAll("[^a-zA-Z0-9]+", "_"); // FIXME: a parameter should not be assigned. Also declare the methods parameters as 'final'.
       return camelize(name)+ "Service";
   }

}