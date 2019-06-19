package rewards

class BootStrap {

    def init = { servletContext ->
        //Products
        new Product(name: "Morning Blend", sku: "MB01", price: 14.95).save()
        new Product(name: "Dark Roast", sku: "DK01", price: 12.95).save()

        //Customers
        new rewards.Customer(phone: 3929979727, firstName: "Luca", lastName: "Fornelli", totalPoints: 4).save()
        new rewards.Customer(phone: 3928989823, firstName: "Nicola", lastName: "Marino", totalPoints: 3).save()
        new rewards.Customer(phone: 3929817233, firstName: "Miche", lastName: "Russo", totalPoints: 2).save()
        new rewards.Customer(phone: 3124343449, firstName: "Luigi", lastName: "Recchia", totalPoints: 1).save()
        new rewards.Customer(phone: 3339898765, firstName: "Gianni", lastName: "Poliseno", totalPoints: 5).save()
        new rewards.Customer(phone: 3121278987, firstName: "Donato", lastName: "Conversano", totalPoints: 5).save()
        new rewards.Customer(phone: 3456787665, firstName: "Francesco", lastName: "Bianco", totalPoints: 5).save()
        new rewards.Customer(phone: 3767878522, firstName: "Alessandro", lastName: "Rini", totalPoints: 2).save()
        new rewards.Customer(phone: 3651234567, firstName: "Alessio", lastName: "Mele", totalPoints: 1).save()
        new rewards.Customer(phone: 3798945251, firstName: "Nicola", lastName: "MNastrorilli", totalPoints: 3).save()
        new rewards.Customer(phone: 3145765123, firstName: "Antonio", lastName: "Violante", totalPoints: 1).save()
        new rewards.Customer(phone: 3145566777, firstName: "Domenico", lastName: "Gallucci", totalPoints: 2).save()
        new rewards.Customer(phone: 3344456666, firstName: "Granco", lastName: "Bruno", totalPoints: 3).save()
        new rewards.Customer(phone: 3291231233, firstName: "Walter", lastName: "Centrone", totalPoints: 4).save()
        new rewards.Customer(phone: 3807584105, firstName: "Antonella", lastName: "Lotito", totalPoints: 1).save()
        new rewards.Customer(phone: 3202168668, firstName: "Nicoletta", lastName: "Guglielmi", totalPoints: 3).save()
        new rewards.Customer(phone: 3493958862, firstName: "Roberto", lastName: "Fornelli", totalPoints: 2).save()
        new rewards.Customer(phone: 3281897645, firstName: "Luca", lastName: "Guglielmi", totalPoints: 5).save()
        new rewards.Temp(name: "ciaone").save()
    }
    def destroy = {
    }
}
