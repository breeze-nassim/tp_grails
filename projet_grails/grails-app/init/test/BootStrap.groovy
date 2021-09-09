package test

import Test.Role
import Test.User
import Test.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def AdminInstance = new User(username: "nassim_admin", password: "admin").save()
        UserRole.create(AdminInstance, adminRole, true)

        def modRole = new Role(authority: "ROLE_MOD").save()
        def modInstance = new User(username: "user_modo", password: "modo").save()
        UserRole.create(modInstance, modRole, true)

        def userRole = new Role(authority: "ROLE_ADMIN").save()
        def userInstance = new User(username: "user", password: "user").save()
        UserRole.create(userInstance, userRole, true)


        (1..6).each { Integer it ->
            new SaleAd(title: "article " + it,
                    descShort: "c'est un article",
                    descLong: "détail de l'article",
                    price: it * 12)
                    .addToIllustrations(new Illustration(filename: "filename.png"))
                    .save()
        }
        def destroy = {
        }
    }
}