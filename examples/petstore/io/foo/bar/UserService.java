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
     * add this binding in the SitebricksModule -  at("/v2").serve(UserService.class);
     */
    @At("/v2/user")
    @Service
    public class UserService  {
    /**
    * Uncomment and implement as you see fit.  These operations will map
    * Direclty to operation calls from the routing logic.  Because the inflector
    * Code allows you to implement logic incrementally, they are disabled.
    **/

    @Inject
    public UserService(){
    }


        /**
         * Create userThis can only be done by the logged in user.
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 0 :  (successful operation)
         * 
         * @return
         */
         
         @Post
         public Reply<?> createUser(Request request) {
           
           //Created user object
           User body = request.read(User.class).as(GsonTransport.class);
           

           //TODO: logic here
           
           return Reply.saying().ok();
         }

        /**
         * Creates list of users with given input array
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 0 :  (successful operation)
         * 
         * @return
         */
         
         @Post
         public Reply<?> createUsersWithArrayInput(Request request) {
           
           //List of user object
           
           TypeLiteral<List<User>> bodytypeLiteral = new TypeLiteral<List<User>>(){};
                              List<User> body = request.read(bodytypeLiteral).as(GsonTransport.class);

           //TODO: logic here
           
           return Reply.saying().ok();
         }

        /**
         * Creates list of users with given input array
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 0 :  (successful operation)
         * 
         * @return
         */
         
         @Post
         public Reply<?> createUsersWithListInput(Request request) {
           
           //List of user object
           
           TypeLiteral<List<User>> bodytypeLiteral = new TypeLiteral<List<User>>(){};
                              List<User> body = request.read(bodytypeLiteral).as(GsonTransport.class);

           //TODO: logic here
           
           return Reply.saying().ok();
         }

        /**
         * Delete userThis can only be done by the logged in user.
         * 
         * 
         * 
         * @param username The name that needs to be deleted
         * 
         * Expected answers:
         * 
         *          code 400 :  (Invalid username supplied)
         * 
         *          code 404 :  (User not found)
         * 
         * @return
         */
         @At("/:username")
         @Delete
         public Reply<?> deleteUser(@Named("username") String username) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Get user by user name
         * 
         * 
         * 
         * @param username The name that needs to be fetched. Use user1 for testing. 
         * 
         * Expected answers:
         * 
         *          code 200 : User (successful operation)
         * 
         *          code 400 :  (Invalid username supplied)
         * 
         *          code 404 :  (User not found)
         * 
         * @return
         */
         @At("/:username")
         @Get
         public Reply<?> getUserByName(@Named("username") String username) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Logs user into the system
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * 
         * Expected answers:
         * 
         *          code 200 : String (successful operation)
         *          Headers :
         *          X-Rate-Limit - calls per hour allowed by the user
         *          X-Expires-After - date in UTC when token expires
         * 
         *          code 400 :  (Invalid username/password supplied)
         * 
         * @return
         */
         
         @Get
         public Reply<?> loginUser(Request request) {
           
           String username = request.param("username");
           String password = request.param("password");
           //TODO: logic here
           return Reply.saying().ok();
         }

        /**
         * Logs out current logged in user session
         * 
         * 
         * 
         * Expected answers:
         * 
         *          code 0 :  (successful operation)
         * 
         * @return
         */
         
         @Get
         public Reply<?> logoutUser() {
           
           
           return Reply.saying().ok();
         }

        /**
         * Updated userThis can only be done by the logged in user.
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * @param username name that need to be updated
         * 
         * Expected answers:
         * 
         *          code 400 :  (Invalid user supplied)
         * 
         *          code 404 :  (User not found)
         * 
         * @return
         */
         @At("/:username")
         @Put
         public Reply<?> updateUser(Request request, @Named("username") String username) {
           
           //Updated user object
           User body = request.read(User.class).as(GsonTransport.class);
           

           //TODO: logic here
           
           return Reply.saying().ok();
         }
    }

