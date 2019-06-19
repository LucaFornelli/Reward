package rewards

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
        def firstnName = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = ""

        switch (totalPoints) {
            case 5:
                welcomeMessage = "Welcome back $firstnName. The drink is on us."
                break
            case 4:
                welcomeMessage = "Welcome back $firstnName. The next drink is free."
                break
            case 2..3:
                welcomeMessage = "Welcome back $firstnName. You now have $totalPoints points."
                break
            default:
                welcomeMessage = "Welcome back $firstnName. Thank you for registering."
                break
        }
    }

    def getTotalPoints(Customer customer) {
        def totalAwards = 0
        if (customer.awards != null) {
            customer.awards.each {
                totalAwards += it.points
            }
        }
        customer.totalPoints = totalAwards
        return customer
    }

    def processCheckin (lookupInstance) {
        def customer = Customer.findByPhone(lookupInstance.phone)
        if (customer == null){
            customer = lookupInstance
            customer.firstName = "Customer"
        }
        customer = getTotalPoints(customer)
        def welcomeMessage = ""
        switch (customer.totalPoints) {
            case 5:
                welcomeMessage = "Welcome back $customer.firstName. The drink is on us."
                break
            case 4:
                welcomeMessage = "Welcome back $customer.firstName. The next drink is free."
                break
            case 2..3:
                welcomeMessage = "Welcome back $customer.firstName. You now have $customer.totalPoints points."
                break
            default:
                welcomeMessage = "Welcome back $customer.firstName. Thank you for registering."
                break
        }

        if (customer.totalPoints < 5) {
            customer.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customer.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }

        customer.save()

        return [customer, welcomeMessage]
    }
}
