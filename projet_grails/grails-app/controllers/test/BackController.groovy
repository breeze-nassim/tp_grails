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

    @Secured("ROLE_ADMIN")
    def index() {

    }



    def salesAd() {
        println(backService.salesAd())

        [listSalesAd: backService.salesAd()]
    }

    /*** Delete advertise ***/

    def deleteAd(){
        def id = params.id
        if(id) {
            backService.deleteAd(id)
        }

        redirect(action: "salesAd")
    }



    def createSalesAd() {
        def message = ""
        if (params.title!=null && params.descShort!=null && params.price!=null){
            List illustrations = request.getFiles('illustration')
            def projectPath = request.getSession().getServletContext().getRealPath("").replace("src\\main\\webapp\\", "")

            def created = backService.createSalesAd(params, illustrations, projectPath + "grails-app\\assets\\images\\salesAd\\")
            message = created ? "Creation reussite" : "Ad non créer !!"
        }

        [message: message]
    }
}
