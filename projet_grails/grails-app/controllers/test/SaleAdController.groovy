package test

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SaleAdController {

    SaleAdService saleAdService

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond saleAdService.list(params), model:[saleAdCount: saleAdService.count()]
    }

    def show(Long id) {
        respond saleAdService.get(id)
    }

    def create() {
        respond new SaleAd(params)
    }

    def save(SaleAd saleAd) {
        if (saleAd == null) {
            notFound()
            return
        }

        try {
            saleAdService.save(saleAd)
        } catch (ValidationException e) {
            respond saleAd.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'saleAd.label', default: 'SaleAd'), saleAd.id])
                redirect saleAd
            }
            '*' { respond saleAd, [status: CREATED] }
        }
    }


    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        saleAdService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'saleAd.label', default: 'SaleAd'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

}
