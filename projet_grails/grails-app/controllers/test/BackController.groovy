package test

import Test.Role
import Test.User
import Test.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.MultipartFile


class BackController {
    SpringSecurityService springSecurityService
    BackService backService




    @Secured(["ROLE_ADMIN", "ROLE_MOD"])
    def listUser() {
        [listUser: backService.listUser(),userRo:UserRole.list()]
    }

    @Secured("ROLE_ADMIN")
    def deleteUser(){
        def id = params.id
        if(id) {
            backService.deleteUser(id)
        }
        redirect(action: "listUser")
    }

    @Secured(["ROLE_ADMIN", "ROLE_MOD"])
    def salesAd() {
        println(backService.salesAd())

        [listSalesAd: backService.salesAd()]
    }


   @Secured(["ROLE_ADMIN", "ROLE_MOD"])
    def deleteAd(){
        def id = params.id
        if(id) {
            backService.deleteAd(id)
        }

        redirect(action: "salesAd")
    }

    @Secured(["ROLE_ADMIN"])
    def editAd(){
        def id = params.id
        if(id) {
            def ad = SaleAd.get(id)
            if(ad) {
                ['saleAd' : ad]
            }
        }
    }
    @Secured(["ROLE_ADMIN"])
    def editAdMethod() {
        def id = params.id
        def ad = SaleAd.get(id)
        if(ad) {
            if(params.descShort && params.title && params.price) {

                ad.descShort = params.descShort
                ad.title = params.title
                ad.price = Float.valueOf(params.price);
                ad.save(flush:true)
                println "SAVED"
                redirect(action: "salesAd")
            }
            println ad
        }
    }


}
