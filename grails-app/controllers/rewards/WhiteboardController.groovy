package rewards

import java.time.LocalDate

class WhiteboardController {

    CalculationsService calculationsService

    def index() { }

    def variables() {
        def myTotal = 1
        render "Total: " + myTotal
        render("</br>" + myTotal.getClass())

        def firstName = "Mike"
        render("</br>Name: " + firstName)
        render("</br>" + firstName.getClass())

        def today = new Date("2/5/1994")
        render ("</br>Today is: " + today)
        render("</br>" + today.getClass())
    }

    def strings() {
        def first = params.id
        def last = "LellyKelly"
        def points = params.ciao
        render "Hey there $first. You have $points points"
    }

    def conditions() {
        def welcomeMessage = calculationsService.welcome(params);
        render welcomeMessage
    }
}
