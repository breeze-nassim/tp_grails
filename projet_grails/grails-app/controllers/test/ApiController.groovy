package test

import Test.User
import grails.converters.JSON
import grails.converters.XML

class ApiController {

    BackService backService
    SaleAdService saleAdService
    def index() { }

    def users() {
        switch (request.getMethod()) {
            case "GET" :
                def list = backService.listUser()
                withFormat {
                    json { render list as JSON }
                    xml { render list as XML}
                }
                break

            default:
                return response.status= 405
                break
        }
    }



    def salesad(){
        switch(request.getMethod()) {
            case "GET":
                def annonceInstance= SaleAd.list()
                if (!annonceInstance)
                    return response.status= 404
                response.withFormat{
                    json{ render annonceInstance as JSON }
                }
                break
            case "POST":
                if( !request.JSON.title || !request.JSON.descShort || !request.JSON.descLong || !request.JSON.price)
                    return response.status = 400

                println(request.JSON)


                 println request.JSON
                def created = backService.createSalesAd(request.JSON,null, null)
                println created
                if(created)
                    return response.status = 201
                else
                    withFormat {
                        json { render ([error : true, message : "Sale not created"] as JSON)}
                    }
                break

            default:
                return response.status= 405
                break}
        return response.status= 406
    }
    }


