package rewards


class CustomerController {

    static scaffold = Customer

    CalculationsService calculationsService

    def index() {
        params.max = 10
        [customerList: Customer.list(params), customerCount: Customer.count()]
    }

    def lookup() {
        //def customerInstance = Customer.list(sort: "lastName", order: "desc", max: 5, offset: 0)
        //[customerInstanceList: customerInstance]

        //def customerInstance = Customer.findAllByTotalPoints(5, [sort: "lastName"])
        //[customerInstanceList: customerInstance]

        //def customerInstance = Customer.findAllByLastNameLike("F%", [sort: "lastName"])
        //[customerInstanceList: customerInstance]

        //With Ilike we want to search a lastName that start with F or f
        //def customerInstance = Customer.findAllByLastNameIlike("f%", [sort: "lastName"])
        //[customerInstanceList: customerInstance]

        //def customerInstance = Customer.findAllByTotalPointsGreaterThan(3, [sort:"totalPoints", order:"desc"])
        //[customerInstanceList: customerInstance]

        //def customerInstance = Customer.findAllByTotalPointsBetween(3,4, [sort:"totalPoints", order:"desc"])
        //[customerInstanceList: customerInstance]

        def customerInstance = Customer.findAllByFirstNameIlikeOrFirstNameIlike("F%", "L%", [sort:"totalPoints", order:"desc"])
        [customerInstanceList: customerInstance]
    }

    def checkin() {

        //def customerInstance = Customer.findAllByFirstNameIlikeOrFirstNameIlike("F%", "L%", [sort:"totalPoints", order:"desc"])
        params.max = 10
        [customerList: Customer.list(params), customerCount: Customer.count()]
    }

    def create() {
        [customer: new Customer()]
    }

    def save(Customer customer) {
        customer.save()
        redirect action: "Show", id: customer.id
    }

    def show(Long id){
        def customer = Customer.get(id)
        customer = calculationsService.getTotalPoints(customer)
        [customer: customer]
    }

    def edit(Long id){
        def customer = Customer.get(id)
        [customer: customer]
    }

    def update(Long id){
        def customer = Customer.get(id)
        customer.properties = params
        customer.save()
        redirect action: "Show", id: customer.id
    }

    def delete(Long id) {
        def customer = Customer.get(id)
        customer.delete()
        redirect( action:"index")

    }

    def customerLookup(Customer lookupInstance) {
        def (customer, welcomeMessage) = calculationsService.processCheckin(lookupInstance)
        render(view: "checkin", model: [customer: customer, welcomeMessage: welcomeMessage])
    }

    def profile () {
        def customer = Customer.findByPhone(params.id)
        [customerInstance: customer]
    }

    def updateProfile(Customer customer) {
        customer.save()
        render(view: "profile", model:[customerInstance:  customer])
    }
}
