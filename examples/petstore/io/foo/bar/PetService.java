package io.foo.bar;

import java.io.File;
import java.util.List;
import java.io.File;
import java.util.List;
import com.clouway.telcong.bss.adapter.http.GsonTransport;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.http.Put;
import com.google.sitebricks.http.Delete;

    /**
     *
     * @author
     * add this binding in the SitebricksModule -  at("/v2").serve(PetService.class);
     */
    @At("/v2/pet")
    @Service
    public class PetService  {
    /**
    * Uncomment and implement as you see fit.  These operations will map
    * Direclty to operation calls from the routing logic.  Because the inflector
    * Code allows you to implement logic incrementally, they are disabled.
    **/

    @Inject
    public PetService(){
    }


        /**
         * Add a new pet to the store
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 405 :  (Invalid input)
         * 
         * @return
         */
         
         @Post
         public Reply<?> addPet(Request request) {
           
           //Pet object that needs to be added to the store
           Pet pet = request.read(Pet.class).as(GsonTransport.class);
           

           //TODO: logic here
           
           return Reply.saying().ok();
         }

        /**
         * Deletes a pet
         * 
         * 
         * 
         * @param petId Pet id to delete
         * 
         * Expected answers:
         * 
         *          code 400 :  (Invalid ID supplied)
         * 
         *          code 404 :  (Pet not found)
         * 
         * @return
         */
         @At("/:petId")
         @Delete
         public Reply<?> deletePet(@Named("petId") Long petId) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Finds Pets by statusMultiple status values can be provided with comma separated strings
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * 
         * Expected answers:
         * 
         *          code 200 : List&lt;Pet&gt; (successful operation)
         * 
         *          code 400 :  (Invalid status value)
         * 
         * @return
         */
         
         @Get
         public Reply<?> findPetsByStatus(Request request) {
           
           List<String> status = request.param("status");//TODO: parse the list on your own
           //TODO: logic here
           return Reply.saying().ok();
         }

        /**
         * Finds Pets by tagsMuliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * 
         * Expected answers:
         * 
         *          code 200 : List&lt;Pet&gt; (successful operation)
         * 
         *          code 400 :  (Invalid tag value)
         * 
         * @return
         */
         
         @Get
         public Reply<?> findPetsByTags(Request request) {
           
           List<String> tags = request.param("tags");//TODO: parse the list on your own
           //TODO: logic here
           return Reply.saying().ok();
         }

        /**
         * Find pet by IDReturns a single pet
         * 
         * 
         * 
         * @param petId ID of pet to return
         * 
         * Expected answers:
         * 
         *          code 200 : Pet (successful operation)
         * 
         *          code 400 :  (Invalid ID supplied)
         * 
         *          code 404 :  (Pet not found)
         * 
         * @return
         */
         @At("/:petId")
         @Get
         public Reply<?> getPetById(@Named("petId") Long petId) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Update an existing pet
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 400 :  (Invalid ID supplied)
         * 
         *          code 404 :  (Pet not found)
         * 
         *          code 405 :  (Validation exception)
         * 
         * @return
         */
         
         @Put
         public Reply<?> updatePet(Request request) {
           
           //Pet object that needs to be added to the store
           Pet body = request.read(Pet.class).as(GsonTransport.class);
           

           //TODO: logic here
           
           return Reply.saying().ok();
         }

        /**
         * Updates a pet in the store with form data
         * 
         * 
         * 
         * @param petId ID of pet that needs to be updated
         * 
         * Expected answers:
         * 
         *          code 405 :  (Invalid input)
         * 
         * @return
         */
         @At("/:petId")
         @Post
         public Reply<?> updatePetWithForm(@Named("petId") Long petId) {
           
           
           return Reply.saying().ok();
         }

        /**
         * uploads an image
         * 
         * 
         * 
         * @param petId ID of pet to update
         * 
         * Expected answers:
         * 
         *          code 200 : ApiResponse (successful operation)
         * 
         * @return
         */
         @At("/:petId/uploadImage")
         @Post
         public Reply<?> uploadFile(@Named("petId") Long petId) {
           
           
           return Reply.saying().ok();
         }
    }

