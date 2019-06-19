package rewards

class Customer {

    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints
    static hasMany = [awards: Award, orders: Request]

    String toString () {
        "${firstName} ${lastName}"
    }

    static constraints = {
        firstName()
        lastName()
        phone(nullable: true)
        email(nullable: true, email: true)
        totalPoints()
    }
}
