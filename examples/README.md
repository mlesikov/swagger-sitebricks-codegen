Once modified, you can run this:

```
mvn package
```

In your generator project.  A single jar file will be produced in `target`.  You can now use that with codegen:

```
java -cp /path/to/swagger-codegen-distribution:/path/to/your/jar io.swagger.codegen.Codegen -l sitebricks -o ./test
```

Now your templates are available to the client generator and you can write output values

# generate example petstore
```
java -cp target/swagger-sitebricks-codegen-1.0.0.jar:examples/swagger-codegen-cli.jar io.swagger.codegen.SwaggerCodegen generate -l sitebricks -i examples/petstore.yaml -o examples/petstore
```

# clear the generated example

rm -rf examples/petstore
