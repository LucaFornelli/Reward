package rewards

import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Value

import static org.springframework.http.HttpStatus.*

class TempController {

    TempService tempService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def foo () {
        def recipient = grailsApplication.config.getProperty('foo.bar.hello', "Default")
        render "Hello ${recipient}"
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tempService.list(params), model:[tempCount: tempService.count()]
    }

    def show(Long id) {
        respond tempService.get(id)
    }

    def create() {
        respond new Temp(params)
    }

    def save(Temp temp) {
        if (temp == null) {
            notFound()
            return
        }

        try {
            tempService.save(temp)
        } catch (ValidationException e) {
            respond temp.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'temp.label', default: 'Temp'), temp.id])
                redirect temp
            }
            '*' { respond temp, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tempService.get(id)
    }

    def update(Temp temp) {
        if (temp == null) {
            notFound()
            return
        }

        try {
            tempService.save(temp)
        } catch (ValidationException e) {
            respond temp.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'temp.label', default: 'Temp'), temp.id])
                redirect temp
            }
            '*'{ respond temp, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tempService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'temp.label', default: 'Temp'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'temp.label', default: 'Temp'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
