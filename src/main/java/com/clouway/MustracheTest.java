package com.clouway;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class MustracheTest {
   public class Foo {
         public String httpMethod;
         public String package3 = "com.cloyway";
   }

  @Test
  public void test() throws FileNotFoundException {
//    Handlebar
//    Handlebar.registerHelper('lowercase', function (str) {
//      if(str && typeof str === "string") {
//        return str.toLowerCase();
//      }
//      return '';
//    });


//    Swagger swagger = new SwaggerParser().read("src/main/java/com/clouway/petstore.yaml");
////    ClientOpts clientOpts = new SwaggerParser().read("src/main/java/com/clouway/petstore.yaml");
//    // resolve inline models
//    new InlineModelResolver().flatten(swagger);
//
//    System.out.println("title " +swagger.getInfo().getTitle());
//    System.out.println("base path : " + swagger.getBasePath());
//    System.out.println("host "+swagger.getHost());
//    System.out.println("host "+swagger.getConsumes());
//    System.out.println("host "+swagger.getSchemes().size());
//    System.out.println("host "+swagger.getSchemes().get(0).toValue());

    Mustache.Compiler compiler = Mustache.compiler();


//    Template Tt =  compiler.compile(new FileReader("src/main/java/com/clouway/petstore.yaml"));
    Template t =  compiler.compile(new FileReader("src/main/java/com/clouway/api.mustache"));


//    Handlebars handlebars = new Handlebars();
//    Template template = handlebars.compileInline("Hello {{this}}!");


    Foo foo = new Foo();
    foo.httpMethod = "GET";
    System.out.println(t.execute(foo));

//    List<File> files  = new DefaultGenerator().generate();
//    for (File file : files) {
//      System.out.println("filename " + file.getName());
//    }
  }

  @Test
  public void name() throws Exception {

    System.out.println("/{pathId}".replaceAll("\\{", ":").replaceAll("\\}",""));
    System.out.println(capitalize("POST"));
  }

  String capitalize(String s) {
        String s1 = s.substring(0,1).toUpperCase();
        String sTitle = s1 + s.substring(1).toLowerCase();
        return sTitle;
   }
}
