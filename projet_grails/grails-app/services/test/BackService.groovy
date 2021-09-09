package test

import Test.Role
import Test.User
import Test.UserRole
import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class BackService {

    def serviceMethod() {

    }



//liste des utilisateurs
    def listUser() {
        return User.list()
    }
//supprimer un utilisateur
    def deleteUser(id) {
        def user =  User.get(id)
        def listRole = UserRole.findAllByUser(user)
        UserRole.deleteAll(listRole)
        user.delete()
    }


    //afficher les articles
    def salesAd(){
        def ad = SaleAd.list();
        return  ad;
    }

    //supprimer un article
    def deleteAd(id) {
        def ad= SaleAd.get(id)
        ad.delete()
    }
//modifier un article
    def editAd(id , String descShort, String descLong, String title, price){
        def advert =  SaleAd.get(id)
        println(advert)
        advert.title = title;
        advert.descShort=descShort;
        advert.price=price;
        advert.save(flush:true);
    }

}
