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
     * add this binding in the SitebricksModule -  at("/v2").serve(StoreService.class);
     */
    @At("/v2/store")
    @Service
    public class StoreService  {
    /**
    * Uncomment and implement as you see fit.  These operations will map
    * Direclty to operation calls from the routing logic.  Because the inflector
    * Code allows you to implement logic incrementally, they are disabled.
    **/

    @Inject
    public StoreService(){
    }


        /**
         * Delete purchase order by IDFor valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
         * 
         * 
         * 
         * @param orderId ID of the order that needs to be deleted
         * 
         * Expected answers:
         * 
         *          code 400 :  (Invalid ID supplied)
         * 
         *          code 404 :  (Order not found)
         * 
         * @return
         */
         @At("/order/:orderId")
         @Delete
         public Reply<?> deleteOrder(@Named("orderId") Long orderId) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Returns pet inventories by statusReturns a map of status codes to quantities
         * 
         * 
         * 
         * Expected answers:
         * 
         *          code 200 : Map&lt;String, Integer&gt; (successful operation)
         * 
         * @return
         */
         
         @Get
         public Reply<?> getInventory() {
           
           
           return Reply.saying().ok();
         }

        /**
         * Find purchase order by IDFor valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions
         * 
         * 
         * 
         * @param orderId ID of pet that needs to be fetched
         * 
         * Expected answers:
         * 
         *          code 200 : Order (successful operation)
         * 
         *          code 400 :  (Invalid ID supplied)
         * 
         *          code 404 :  (Order not found)
         * 
         * @return
         */
         @At("/order/:orderId")
         @Get
         public Reply<?> getOrderById(@Named("orderId") Long orderId) {
           
           
           return Reply.saying().ok();
         }

        /**
         * Place an order for a pet
         * 
         * @param request - sitebrickst request wrapper, that contains the request body
         * 
         * Expected answers:
         * 
         *          code 200 : Order (successful operation)
         * 
         *          code 400 :  (Invalid Order)
         * 
         * @return
         */
         
         @Post
         public Reply<?> placeOrder(Request request) {
           
           //order placed for purchasing the pet
           Order body = request.read(Order.class).as(GsonTransport.class);
           

           //TODO: logic here
           
           return Reply.saying().ok();
         }
    }

